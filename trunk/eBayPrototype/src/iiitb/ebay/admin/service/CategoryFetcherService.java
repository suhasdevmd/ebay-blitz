package iiitb.ebay.admin.service;

import iiitb.ebay.admin.model.CategoryHierarchy;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryFetcherService {
	static ArrayList<CategoryHierarchy> productList;
	static Connection con;
	static ResultSet rs;
	static String query;

	public static ArrayList<CategoryHierarchy> fetch() {
		con = DB.getConnection();
		query = "SELECT * FROM producthierarchy";
		rs = DB.readFromDB(query, con);
		productList = new ArrayList<CategoryHierarchy>();
		ArrayList<CategoryHierarchy> productListForPage = new ArrayList<CategoryHierarchy>();

		try {
			while (rs.next()) {
				CategoryHierarchy temp = new CategoryHierarchy();
				temp.setPhKey(rs.getString("phKey"));
				temp.setParent(rs.getString("parent"));
				temp.setHasChild(rs.getString("hasChild"));
				temp.setName(rs.getString("name"));
				temp.setLevel(temp.getPhKey().split(",").length);

				productList.add(temp);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection in CategoryFetcherService->fetch()");
		}

		for (int i = 0; i < productList.size(); i++) {
			String parentPhKey = productList.get(i).getParent();
			String parentName = null;

			if (parentPhKey != null) {
				for (int j = 0; j < productList.size(); j++) {
					if (parentPhKey.equals(productList.get(j).getPhKey())) {
						parentName = productList.get(j).getName();
						break;
					}
				}
			}
			try {
				if (parentName != null) {
					productList.get(i).setName(
							parentName + "->" + productList.get(i).getName());
					productListForPage.add(productList.get(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out
						.println("Error concatenating parent's name in CategoryFetcherService->fetch()");
			}
		}

		// return productList;
		return productListForPage;
	}

	public static String insertToEav(String image, String categoryId,
			String productName, String productPrice, String productQty,
			String productBrand, String condition, String[] av,
			boolean additional, int userID) {
		long entityNum = -1;
		/*
		 * This userID is taken to be 1 as default. Needs to be changed as and
		 * when userID is put into the session
		 */
		// int userID = 1;

		con = DB.getConnection();
		query = "SELECT MAX(entity) from producteav";
		rs = DB.readFromDB(query, con);

		try {
			if (rs.next()) {
				entityNum = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("SQL Error in CategoryFetcherService->insertToEav()");
		}
		entityNum++;

		query = "INSERT into producteav values(" + entityNum + ", 'name', '"
				+ productName.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum
				+ ", 'categoryid', '" + categoryId.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum + ", 'price', '"
				+ productPrice.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum
				+ ", 'quantity', '" + productQty.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum + ", 'brand', '"
				+ productBrand.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum
				+ ", 'condition', '" + condition.trim() + "')";
		DB.update(con, query);

		query = "INSERT into producteav values(" + entityNum
				+ ", 'sellerid', '" + userID + "')";
		DB.update(con, query);
		
		
		/* Setting flag buy 3 flag to false */
		query = "INSERT into producteav values(" + entityNum
				+ ", 'buy3', 'false')";
		DB.update(con, query);

		/*
		 * Here again the userID is hard coded as 1. Change as and when required
		 */
		query = "SELECT role from userdetails where userID =" + userID;
		rs = DB.readFromDB(query, con);
		try {
			if (rs.next() && rs.getString(1).equalsIgnoreCase("admin"))
				query = "UPDATE userdetails set role = 'both' where userID ="
						+ userID;
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out
					.println("Error closing database connection in CategoryFetcherService->insertIntoEav()");
		}
		DB.update(con, query);

		if (additional) {
			for (int i = 0; i < av.length; i++) {
				String[] temp = av[i].split(" : ");
				query = "INSERT into producteav values(" + entityNum + ", '"
						+ temp[0].toLowerCase() + "', '" + temp[1] + "')";
				DB.update(con, query);
			}
		}

		try {
			query = "INSERT into productimage(productID,image1) values("
					+ entityNum + ",'" + image + "')";
			System.out.println("Image " + query);
			DB.update(con, query);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection in CategoryFetcherService->insertIntoEav()");
			return "error";
		}
		return "success";
	}
}

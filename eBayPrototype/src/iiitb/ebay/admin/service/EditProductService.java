package iiitb.ebay.admin.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EditProductService {
	static Connection con;
	static ResultSet rs;
	static String query;
	static Map<String, String> attrVals;

	public static Map<String, String> getDetails(int productID) {
		attrVals = new HashMap<String, String>();
		con = DB.getConnection();

		/*
		 * Here the productID is hard coded. Use suitable productID as required.
		 */
		query = "select * from producteav where entity = " + productID;
		rs = DB.readFromDB(query, con);

		try {
			while (rs.next()) {
				if (!rs.getNString(2).toLowerCase()
						.equalsIgnoreCase("newprice")
						&& !rs.getNString(2).toLowerCase()
								.equalsIgnoreCase("save")) {
					attrVals.put(rs.getNString(2).toLowerCase(),
							rs.getNString(3));
					System.out.println(rs.getNString(2).toLowerCase() + " : "
							+ rs.getNString(3));
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in EditProductService->getDetails()");
		}

		return attrVals;
	}

	public static String modifyEav(int productID, String categoryId,
			String productName, String productPrice, String productQty,
			String productBrand, String productDiscount, String startDate,
			String endDate, String condition, String[] av, boolean additional) {

		con = DB.getConnection();

		/*
		 * query = "UPDATE producteav set val = '" + categoryId +
		 * "' where attr = 'categoryid' and entity = " + productID;
		 * DB.update(con, query);
		 */

		query = "UPDATE producteav set val = '" + productName
				+ "' where attr = 'name' and entity = " + productID;
		DB.update(con, query);

		query = "UPDATE producteav set val = '" + productPrice
				+ "' where attr = 'price' and entity = " + productID;
		DB.update(con, query);

		query = "UPDATE producteav set val = '" + productQty
				+ "' where attr = 'quantity' and entity = " + productID;
		DB.update(con, query);

		query = "UPDATE producteav set val = '" + productBrand
				+ "' where attr = 'brand' and entity = " + productID;
		DB.update(con, query);

		query = "UPDATE producteav set val = '" + condition
				+ "' where attr = 'condition' and entity = " + productID;
		DB.update(con, query);

		try {
			float discount = Float.parseFloat(productDiscount);
			if (discount > 0) {
				float newprice, save, price;
				price = Float.parseFloat(productPrice);
				newprice = price - ((discount / 100) * price);
				save = price - newprice;
				System.out.println("calculated vals " + newprice + " " + save
						+ " " + discount);
				query = "SELECT * from producteav where entity = " + productID
						+ " AND attr = 'discount'";
				rs = DB.readFromDB(query, con);

				if (rs.next()) {
					query = "UPDATE producteav set val = " + discount
							+ " where attr = 'discount' and entity = "
							+ productID;
					DB.update(con, query);
					query = "UPDATE producteav set val = " + newprice
							+ " where attr = 'newprice' and entity = "
							+ productID;
					System.out.println("newprice=" + newprice + "\n" + query);
					DB.update(con, query);
					query = "UPDATE producteav set val = " + save
							+ " where attr = 'save' and entity = " + productID;
					DB.update(con, query);
					query = "UPDATE producteav set val = '" + startDate
							+ "' where attr = 'startdate' and entity = "
							+ productID;
					DB.update(con, query);
					query = "UPDATE producteav set val = '" + endDate
							+ "' where attr = 'enddate' and entity = "
							+ productID;
					DB.update(con, query);

				}

				else {
					query = "INSERT into producteav values(" + productID
							+ ", 'discount', '" + discount + "')";
					DB.update(con, query);
					query = "INSERT into producteav values(" + productID
							+ ", 'newprice', '" + newprice + "')";
					DB.update(con, query);
					query = "INSERT into producteav values(" + productID
							+ ", 'save', '" + save + "')";
					DB.update(con, query);
					query = "INSERT into producteav values(" + productID
							+ ", 'startdate', '" + startDate + "')";
					DB.update(con, query);
					query = "INSERT into producteav values(" + productID
							+ ", 'enddate', '" + endDate + "')";
					DB.update(con, query);
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			System.out
					.println("Error in parsing numbers in EditProductService->modifyEav()");
			return "error";
		} catch (SQLException e2) {
			e2.printStackTrace();
			System.out.println("SQL error in EditProductService->modifyEav()");
			return "error";
		}

		if (additional) {
			for (int i = 0; i < av.length; i++) {
				String[] temp = av[i].split(":");
				if (temp != null && temp.length == 2) {
					query = "UPDATE producteav set val = '" + temp[1]
							+ "' where attr = '" + temp[0].toLowerCase()
							+ "' and entity = " + productID;
					DB.update(con, query);
				}
			}
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection in EditProductService->modifyEav()");
			return "error";
		}
		return "success";
	}
}

package iiitb.ebay.service;

import iiitb.ebay.users.model.ViewOrderStatusModel;
import iiitb.ebay.model.Orders;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.displaytag.decorator.TotalTableDecorator;

public class OrderService {

	static Connection con;
	static ResultSet rs;
	static String query;
	static Statement stmt;

	public static final String INITIATE = "NOT_YET_SHIPPED";
	public static final String SHIPPED = "SHIPPED";
	public static final String DELIVERED = "DELIVERED";

	public static int createOrder(double amount, String shippingStatus,
			int userID, String trackingDetails) {
		try {
			con = DB.getConnection();
			stmt = con.createStatement();
			query = "INSERT INTO `orders` (`totalAmt` ,`shippingStatus` ,`userID` ,`trackingDetails`) VALUES ("
					+ amount
					+ ",'"
					+ shippingStatus
					+ "',"
					+ userID
					+ ",'"
					+ trackingDetails + "')";
			System.out.println("orders Query " + query);
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

			int autoIncKeyFromApi = -1;

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				autoIncKeyFromApi = rs.getInt(1);
			} else {
				try {
					throw new Exception("key not generated!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rs.close();

			if (stmt != null)
				DB.close(stmt);
			DB.close(con);
			// returns the order id
			return autoIncKeyFromApi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static String insertOrderItems(int productID, int orderID,
			int quantity, double amount) {
		con = DB.getConnection();
		query = "INSERT INTO `orderitems` (`productID` ,`orderID` ,`quantity` ,`amount`) VALUES ("
				+ productID
				+ ","
				+ orderID
				+ ","
				+ quantity
				+ ","
				+ amount
				+ ")";
		System.out.println("orderitems Query " + query);
		DB.update(con, query);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection");
			return "error";
		}
		return "success";
	}
	
	
	public static ArrayList<Orders> getOrders(int userID) {
		Connection con;
		ResultSet rs;
		String query;
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		try {
			con = DB.getConnection();
			query = "SELECT * FROM orders where userID=";
			
			rs = DB.readFromDB(query + userID, con);
			while(rs.next()){
				Orders order = new Orders();
				order.setOrderID(rs.getInt("orderID"));
				order.setShippingStatus(rs.getString("shippingStatus"));
				order.setTotalAmt(rs.getDouble("totalAmt"));
				order.setTrackingDetails(rs.getString("trackingDetails"));
				order.setUserID(rs.getInt("userID"));
				
				orderList.add(order);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;

	}

}

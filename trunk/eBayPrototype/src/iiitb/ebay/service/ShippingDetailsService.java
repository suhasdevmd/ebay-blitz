package iiitb.ebay.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShippingDetailsService {
	static Connection con;
	static ResultSet rs;
	static String query;

	public static String addShippingDetails(String name, double amount,
			String address, String date, int orderID, int sellerID,
			String courierName, String courierContact) {
		con = DB.getConnection();
		query = "INSERT INTO `shippingdetails` (`name` ,`amount` ,`address` ,`date` ,`orderID` ,`sellerID` ,`courierName` ,`courierContact`) VALUES ('"
				+ name
				+ "',"
				+ amount
				+ ",'"
				+ address
				+ "','"
				+ date
				+ "',"
				+ orderID
				+ ","
				+ sellerID
				+ ",'"
				+ courierName
				+ "','"
				+ courierContact + "')";

		System.out.println("shippingDetails Query " + query);
		DB.update(con, query);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error closing database connection ");
			return "error";
		}
		return "success";
	}
	
	public static String getDateNow() {

		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MM-yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

}

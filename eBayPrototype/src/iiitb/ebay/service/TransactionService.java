package iiitb.ebay.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TransactionService {

	static Connection con;
	static ResultSet rs;
	static String query;

	public static String makeTransaction(String details, String date,
			int senderID, int receiverID) {
		con = DB.getConnection();
		query = "INSERT INTO transactions(`details` ,`date` ,`senderID` ,`receiverID`) VALUES ('"
				+ details
				+ "','"
				+ date
				+ "',"
				+ senderID
				+ ","
				+ receiverID
				+ ")";
		System.out.println("Transaction Query "+query);
		DB.update(con, query);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection ");
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

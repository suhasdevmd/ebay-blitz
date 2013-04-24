package iiitb.ebay.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TransactionService {

	static Connection con;
	static ResultSet rs;
	static String query;
	static Statement stmt;

	public static int makeTransaction(String details, String date,
			int senderID, int receiverID) {
		try {
			con = DB.getConnection();
			stmt = con.createStatement();
			query = "INSERT INTO transactions(`details` ,`date` ,`senderID` ,`receiverID`) VALUES ('"
					+ details
					+ "','"
					+ date
					+ "',"
					+ senderID
					+ ","
					+ receiverID + ")";
			System.out.println("Transaction Query " + query);
			// DB.update(con, query);
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

	public static String getDateNow() {

		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

}

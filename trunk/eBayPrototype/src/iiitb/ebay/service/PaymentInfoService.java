package iiitb.ebay.service;

import iiitb.ebay.model.Orders;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PaymentInfoService {

	static Connection con;
	static ResultSet rs;
	static String query;
	static Statement stmt;

	public static int addPaymentInfo(String mode, int transactionID,
			String transactionDate, int orderID, int shippingID, double amount) {
		try {
			con = DB.getConnection();
			stmt = con.createStatement();
			query = "INSERT INTO `paymentInfo` (`mode` ,`transactionID` , `date` , `orderID` , `shippingID`, `amount`) VALUES ('"
					+ mode
					+ "',"
					+ transactionID
					+ ",'"
					+ transactionDate
					+ "'," + orderID + "," + shippingID + "," + amount + ")";

			System.out.println("paymentInfo Query " + query);
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

	public static String getParam(String paramName, String whereClause) {
		Connection con;
		ResultSet rs;
		String query;
		String value = null;
		try {
			con = DB.getConnection();
			query = "SELECT " + paramName + " FROM paymentinfo " + whereClause;

			rs = DB.readFromDB(query, con);
			while (rs.next()) {
				value = rs.getString(paramName);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static String getDateNow() {

		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

}

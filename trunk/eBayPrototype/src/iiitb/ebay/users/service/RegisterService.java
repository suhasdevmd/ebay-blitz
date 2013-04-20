package iiitb.ebay.users.service;

import iiitb.ebay.users.model.UserAddress;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.utilities.DB;

import java.util.Calendar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class RegisterService {
int userid;
	public int insertIntoUserDetails(UserDetails user) {
		//System.out.println("hello \n\n");
		int val=0;
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			String insertSQL = "insert into userdetails "
				+ "(firstName, lastName, address, city, state, pincode, country, telephone, email, memberSince, DOB, role) " + 
				"values('" + user.getFirstName()
				+ "', '" + user.getLastName() + "', '" + user.getAddress() + 
				"', '" + user.getCity() + "', '" + user.getState() + "', " + user.getPinCode() + ", '" + user.getCountry() + 
				"', '" + user.getTelephone() + "', '" + user.getEmail() + "', '" + this.getDateNow() + "', '" + user.getDay() + "-" + user.getMonth() + "-" + user.getYear() + "', '" + "Buyer" + "');";
			System.out.println("query :"+insertSQL);
			stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int autoIncKeyFromApi = -1;

			rs=stmt.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
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
			//returns the patient id
			return autoIncKeyFromApi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return val;
	}
	
	public int insertIntoUserCredential(UserCredential user) {
		//System.out.println("hello \n\n");
		int val=0;
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			String insertSQL = "insert into usercredential "
				+ "(userID, userName, password, secretquestion, secretAnswer, accStatus) " + 
				"values(" + user.getUserID()
				+ ", '" + user.getUserName() + "', '" + user.getPassword() + 
				"', '" + user.getSecretQuestion() + "', '" + user.getSecretAnswer() + "', '" + "A" + "');";
			System.out.println("query: "+insertSQL);
			stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int autoIncKeyFromApi = -1;

			rs=stmt.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
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
			//returns the patient id
			return autoIncKeyFromApi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return val;
	}

	public int insertIntoUserAddress(UserAddress user) {
		//System.out.println("hello \n\n");
		int val=0;
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			String insertSQL = "insert into useraddress "
				+ "(userID, address) " + 
				"values(" + user.getUserID() + ", '" + user.getAddress1() + "');";
			stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

			int autoIncKeyFromApi = -1;

			rs=stmt.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
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
			//returns the patient id
			return autoIncKeyFromApi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return val;
	}
	public String getDateNow() {

		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= 
			new SimpleDateFormat("dd-MM-yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}
	
		
	public static boolean checkForDuplicateUser(UserCredential user)  {

		ResultSet resultSet = null;
		String query= "select userName from usercredential where userName = '" + user.getUserName()+"'";
		System.out.println(query);
		//System.out.println(employee.getFirstname());
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet!=null && resultSet.first()) {
				DB.close(resultSet);
				DB.close(connection);
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return true;	


	}

	
	
	

}

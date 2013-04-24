package iiitb.ebay.users.service;

import iiitb.ebay.admin.model.CategoryDB;
import iiitb.ebay.users.model.ShippingAddress;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChangeShippingAddressService {


	public int addAddress(ShippingAddress shipaddress){


		Connection con;
		Statement stmt;
		ResultSet rs;



		try {
			con=DB.getConnection();
			stmt=con.createStatement();


			String insertSQL = "insert into useraddress "
				+ "(userID,contactName,address,city,state,pincode,country,isPrimary,telephone) " + 
				"values('"+shipaddress.getUserID()+"','" + shipaddress.getContactName()
				+ "', '" + shipaddress.getAddress()  + "', '" + shipaddress.getCity()  + "', '" + shipaddress.getState()  
				+ "', '" + shipaddress.getPincode()  + "', '" + shipaddress.getCountry()  + "', '" + shipaddress.getIsPrimary()
				+ "', '" + shipaddress.getTelephone()+ "');";






			// if the new address to be inserted is primary , make others not primary


			if(shipaddress.getIsPrimary().equalsIgnoreCase("Y")){
				
				
				
				
				System.out.println(" userrrrrrrrrrrrrrrrrrrrr id "+shipaddress.getUserID());

				String qry="update useraddress set isPrimary='N' where userID='"+shipaddress.getUserID()+"'";

				int ret=DB.update(qry);

				if(ret <=0 ){

					return 0;

				}



			}







			System.out.println(" >>>>>> "+insertSQL);

			int ret = stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);
			//int ret=DB.update(insertSQL);


			if (stmt != null) 
				DB.close(stmt);
			DB.close(con);
			//returns the patient id
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return 0;

	}




	public ShippingAddress getPrimaryAddress(int userID){

		ShippingAddress sa=new ShippingAddress();

		Connection con;
		ResultSet rs1;
		String query;


		try {
			con=DB.getConnection();
			query="select * from useraddress where userID='"+userID+"' and isPrimary='Y'";
			rs1=DB.readFromDB(query, con);

			System.out.println("--------> "+query);


			while(rs1 !=null && rs1.next()) {


				System.out.println("insieeeeeeeeeeeeeeeeeeeeeeeeeeee");

				sa.setUserID(String.valueOf(rs1.getInt("userID")));
				sa.setContactName(rs1.getString("contactName"));
				sa.setCountry(rs1.getString("country"));
				sa.setTelephone(Long.parseLong(rs1.getString("telephone")));
				sa.setAddress(rs1.getString("address"));
				sa.setPincode(rs1.getInt("pincode"));
				sa.setCity(rs1.getString("city"));
				sa.setState(rs1.getString("state"));
				sa.setIsPrimary(rs1.getString("isPrimary"));

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		System.out.println(" in side service "+sa.getAddress());


		return sa;

	}




	public String getTelephoneNumber(int userID){
		String number="";


		Connection con;
		ResultSet rs1;
		String query;


		try {
			con=DB.getConnection();
			query="select telephone from userdetails where userID='"+userID+"'";
			rs1=DB.readFromDB(query, con);

			System.out.println("--------> "+query);


			while(rs1 !=null && rs1.next()) {

				number=String.valueOf(rs1.getString("telephone"));

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}






		return number;
	}


	
	public ArrayList<ShippingAddress> getAddressList(int userID){

		ArrayList<ShippingAddress> aList=new ArrayList<ShippingAddress>();
		ShippingAddress sa=null;

		Connection con;
		ResultSet rs1;
		String query;


		try {
			con=DB.getConnection();
			query="select * from useraddress where userID='"+userID+"' and isPrimary='N'";
			rs1=DB.readFromDB(query, con);

			System.out.println("--------> "+query);

			
			aList.add(getPrimaryAddress(userID));

			while(rs1 !=null && rs1.next()) {


				sa=new ShippingAddress();
			

				sa.setUserID(String.valueOf(rs1.getInt("userID")));
				sa.setContactName(rs1.getString("contactName"));
				sa.setCountry(rs1.getString("country"));
				sa.setTelephone(Long.parseLong(rs1.getString("telephone")));
				sa.setAddress(rs1.getString("address"));
				sa.setPincode(rs1.getInt("pincode"));
				sa.setCity(rs1.getString("city"));
				sa.setState(rs1.getString("state"));
				sa.setIsPrimary(rs1.getString("isPrimary"));

				
				aList.add(sa);
				
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//System.out.println(" in side service "+sa.getAddress());


		return aList;

	}

	

}

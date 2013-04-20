package iiitb.ebay.admin.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageUserService {
	
	
	
	
public ArrayList<String> sellerIDList() {

		
		Connection con;
		ResultSet rs;
		String query;
		ArrayList<String> sellerList=new ArrayList<String>();
		try {
			con = DB.getConnection();
			
			query="select userID from userdetails where role='both'";
			
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
			while (rs.next()) {
				//System.out.println(rs.getString("userID"));
				sellerList.add(rs.getString("userID"));
				
				//=rs.getString(parameter);	
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return sellerList;
	}

public float avgRating(int sellerID){
	
	float rating=0,avgrating=0;
	float turn=0;
	Connection con;
	ResultSet rs;
	String query;
	
	try {
		con = DB.getConnection();
		
		query="select descriptionRating, communicationRating, shippingRating, shipChargesRating from feedback where toUserID="+sellerID+";";
		
		rs = DB.readFromDB(query, con);
		//System.out.println(query);
		while (rs.next()) {
			turn=turn+4;
			//System.out.println("rating:"+rs.getFloat("rating"));
			rating=rating+rs.getFloat("descriptionRating")+rs.getFloat("communicationRating")
			+rs.getFloat("shippingRating")+rs.getFloat("shipChargesRating");
		
		
			//`descriptionRating`,  `communicationRating`,  `shippingRating`,  `shipChargesRating`,  `toUserID`, 			
			
		}
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

	avgrating=rating/turn;
	if(Float.isNaN(avgrating))
		return -1;

	return avgrating;
	
	}
public String sellerName(int sellerID){
	Connection con;
	ResultSet rs;
	String query;
	String name=new String();
	
	try {
		con = DB.getConnection();
		
		query="select firstName,lastName from userdetails where userID="+sellerID+";";
		
		rs = DB.readFromDB(query, con);
		//System.out.println(query);
		while (rs.next()) {
			
			name=rs.getString("firstName")+" "+rs.getString("lastName");
			}
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return name;
	}

public ArrayList<Integer> BlockedSellerList(){
	Connection con;
	ResultSet rs;
	String query;
	int i=0;
	ArrayList<Integer> BlockedSellerList=new ArrayList<Integer>();
	try {
		con = DB.getConnection();
		
		query="select userID from usercredential where accStatus='SI';";
		
		rs = DB.readFromDB(query, con);
	
		while (rs.next()) {
			
			BlockedSellerList.add(rs.getInt("userID"));
			
		}
		// close the connection
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

	return BlockedSellerList;
}
}

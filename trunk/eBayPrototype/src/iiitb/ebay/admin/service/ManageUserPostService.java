package iiitb.ebay.admin.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;

public class ManageUserPostService {
	
	public void BlockSeller(int sellerID){

		Connection con;
		ResultSet rs;
		String query,query1;
		
		try {
			con = DB.getConnection();

			query="update usercredential set accStatus='SI' WHERE userID='"+sellerID+"';";
			
			DB.update(query);
			
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void UnblockAllSeller(){
	
		Connection con;
		ResultSet rs;
		String query1;
		
		try {
			con = DB.getConnection();
			query1="update usercredential set accStatus='A' WHERE accStatus='SI';";
			DB.update(query1);
			
			
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

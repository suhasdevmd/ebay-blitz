package iiitb.ebay.users.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import iiitb.ebay.utilities.DB;

public class CancelOrderService {

	public String getOrderStatus(String selectionModifier)  {
			
		String query = "Select shippingStatus from orders where " + selectionModifier ;
		System.out.println("CancelOrderService::query " + query);
		
		String shippingStatus = "" ;
		        ResultSet rs = DB.readFromBmtcDB(query);
		        try{
		        	if(rs!=null){
		        		while(rs.next()){
		        			shippingStatus = rs.getString("shippingStatus");
		        			System.out.println("shippingStatus " + shippingStatus);
		        	
		        		}
		        	}
		        }
		        catch(SQLException ex){
		        	ex.printStackTrace();
		        }
		
		
		return shippingStatus;
	}

	public void updateDB(int orderID,String message,String status) {
		ArrayList<Integer> productIDList = new ArrayList<Integer>();
		ArrayList<Integer> QtyList = new ArrayList<Integer>();
		
		//this deletes all records where orderID is a FK also..
		String query = "Update orders set shippingstatus='"+status+"', trackingDetails='"+message+"' where orderID='"+orderID+"'";
		System.out.println("CancelOrderService::updateDB query " + query);
		
		DB.update(query);
		
		//Assuming On buying if you are decreasing the quantity in producteav table
		//Now increment the quantity in producteav table
		//*********HOW TO UPDATE productEAV table 
		//Select quantity,ProductID from orderitems where orderID='orderID' //2,1 is expected
				
			//	update 

		}
	
	
	

}

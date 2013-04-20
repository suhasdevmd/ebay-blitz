package iiitb.ebay.admin.service;

import iiitb.ebay.admin.model.ManageOrder;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageOrderService {
	
	
	public ArrayList<ManageOrder> getOrderlist(){
		
		ArrayList<ManageOrder> orders=new ArrayList<ManageOrder>();
		
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
		
			query="select o.orderID,userID,totalAmt,productID,quantity,shippingStatus from orders o,orderitems oi where o.orderID=oi.orderID";
			
			
			System.out.println(" The order list query --> "+query);
			
			
			rs=DB.readFromDB(query, con);
			while(rs.next()) {
				System.out.println("inside while" + rs.getInt("userID") );
				ManageOrder order=new ManageOrder();
				
				order.setOrderID(rs.getInt("orderID"));
				order.setUserID(rs.getInt("userID"));
				order.setUsername(getUserName(rs.getInt("userID")));
				order.setProductName(getProductName(rs.getInt("productID")));
				order.setAmount(rs.getDouble("totalAmt"));
				order.setShippingStatus(rs.getString("shippingStatus"));
				order.setQuantity(rs.getInt("quantity"));

				orders.add(order);
			}

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
		return orders;
	}
	
	
	
	
	public String getProductName(int productID){
		
		String name="";
		
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select val from producteav where attr='name'  and entity="+productID+"";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				
				name=rs.getString("val");
				
			}

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return name;
		
	}
	
	
	
	public String getUserName(int userID){
		String name="";
		
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select CONCAT(firstName,' ',lastName) as name from userdetails where userID="+userID+"";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				
				name=rs.getString("name");
				
			}

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return name;
	}

	
	
	
	public int updateOrderStatus(int orderID,String newStatus){
		
		int val=0;
		
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="update orders set shippingStatus='"+newStatus+"' where orderID="+orderID+"";
			
			
			val=DB.update(con, query);
			
			con.close();
			return val;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return val;
	}
	
	
	
	
	
	
	
}

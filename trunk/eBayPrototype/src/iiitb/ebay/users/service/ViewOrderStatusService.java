package iiitb.ebay.users.service;

import iiitb.ebay.users.model.ViewOrderStatusModel;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ViewOrderStatusService {

	ArrayList<ViewOrderStatusModel> itemList = new ArrayList<ViewOrderStatusModel>();

	public ArrayList<ViewOrderStatusModel> GetOrderItems(int orderID) {

		// String query1 =
		// " select image1,quantity,amount from orderitems o,productimage p where"
		// +
		// " p.productID in (select o.productID from orderitems where o.orderID='"+orderID+"')and o.orderID = '"+orderID+"'"
		// ;

		String query1 = "select p.image1,o.quantity,o.amount,m.totalAmt,m.trackingDetails,s.shippingID,m.shippingstatus from orderitems o,productimage p,orders"
				+ " m,shippingDetails s where p.productID in "
				+ "(select o.productID from orderitems where orderID='"
				+ orderID
				+ "') and o.orderID = '"
				+ orderID
				+ "' and m.orderID = '" + orderID + "' and s.orderID=m.orderID";

		System.out.println("query1  " + query1);
		ResultSet rs = DB.readFromBmtcDB(query1);
		try {
			while (rs.next()) {
				System.out.println("Inside While");
				ViewOrderStatusModel model = new ViewOrderStatusModel();
				model.setItemImage(rs.getString("image1"));
				model.setQuantity(rs.getInt("quantity"));
				model.setPrice(rs.getInt("amount"));
				model.setTotalAmt(rs.getInt("totalAmt"));
				model.setShippingStatus(rs.getString("shippingstatus"));
				model.setShippingID(rs.getInt("shippingID"));
				model.setTrackingDetails(rs.getString("trackingDetails"));
				itemList.add(model);
				System.out.println("");

			}
		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return itemList;
	}

	public ArrayList<ViewOrderStatusModel> GetItemDetails(int userID,
			int orderID) {
		// item image , shipping status,quantity,price,shippingID
		// getorderId -> orderID has many items with itemID need to dispaly

		// Select a.productID,a.quantity,a.amount,b.shippingStatus,b.shippingID
		// from orderitems a, orders b where a.orderID = b.orderID and
		// b.userID='1';

		String query = "Select c.image1,a.quantity,a.amount,b.shippingStatus,s.shippingID,b.trackingDetails from orderitems a, orders b,productimage c,shippingdetails s where c.productID = a.productID "
				+ "and a.orderID = b.orderID and b.userID='"
				+ userID
				+ "' and s.orderID=b.orderid and b.orderID=" + orderID;

		System.out.println("query  " + query);

		ResultSet rs = DB.readFromBmtcDB(query);
		try {
			while (rs.next()) {
				ViewOrderStatusModel itemModel = new ViewOrderStatusModel();
				itemModel.setItemImage(rs.getString("image1"));
				itemModel.setQuantity(rs.getInt("quantity"));
				itemModel.setPrice(rs.getDouble("amount"));
				itemModel.setShippingStatus(rs.getString("shippingStatus"));
				itemModel.setShippingID(rs.getInt("shippingID"));
				itemModel.setTrackingDetails(rs.getString("trackingDetails"));
				itemList.add(itemModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * test for(int i=0;i<itemList.size();i++){
		 * System.out.println("itemList  " +
		 * itemList.get(i).getTrackingDetails() ); }
		 */
		return itemList;

	}

	

}
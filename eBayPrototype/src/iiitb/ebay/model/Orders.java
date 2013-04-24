package iiitb.ebay.model;

public class Orders {
	
	private int orderID;
	private double totalAmt;
	private String shippingStatus;
	private int userID;
	private String trackingDetails;
	private int sellerID;
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getTrackingDetails() {
		return trackingDetails;
	}
	public void setTrackingDetails(String trackingDetails) {
		this.trackingDetails = trackingDetails;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	
}

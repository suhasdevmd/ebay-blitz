package iiitb.ebay.users.model;

public class ViewOrderStatusModel {
	//item image , shipping status,quantity,price,shippingID
	private String itemImage;
	private String shippingStatus;
	private int quantity;
	private double price;
	private int shippingID;
	private String	trackingDetails;
	private int productID;
	private double totalAmt;
	
	
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getShippingID() {
		return shippingID;
	}
	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}
	public String getTrackingDetails() {
		return trackingDetails;
	}
	public void setTrackingDetails(String trackingDetails) {
		this.trackingDetails = trackingDetails;
	}
		
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
	
	
	
	

}

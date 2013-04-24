package iiitb.ebay.model;

public class PaymentInfo {
	
	private int paymentID;
	private String mode;
	private int transactionID;
	private String paymentDate;
	private int orderID;
	private int shippingID;
	private double amount;
	
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getShippingID() {
		return shippingID;
	}
	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}

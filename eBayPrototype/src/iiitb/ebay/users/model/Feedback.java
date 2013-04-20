package iiitb.ebay.users.model;

public class Feedback {
	
	private int feedbackID;
	private int fromUserID;
	private String details;
	private String date;
	private float descriptionRating;
	private float communicationRating;
	private float shippingRating;
	private float shipChargesRating;
	private String feedbackType;/* positive or negative image value */
	private String overallFeedback; /* can be positive,negative or neutral */
	private int toUserID;
	private int productID;
	private int orderID;
	
	
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public int getFromUserID() {
		return fromUserID;
	}
	public void setFromUserID(int fromUserID) {
		this.fromUserID = fromUserID;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getDescriptionRating() {
		return descriptionRating;
	}
	public void setDescriptionRating(float descriptionRating) {
		this.descriptionRating = descriptionRating;
	}
	public float getCommunicationRating() {
		return communicationRating;
	}
	public void setCommunicationRating(float communicationRating) {
		this.communicationRating = communicationRating;
	}
	public float getShippingRating() {
		return shippingRating;
	}
	public void setShippingRating(float shippingRating) {
		this.shippingRating = shippingRating;
	}
	public float getShipChargesRating() {
		return shipChargesRating;
	}
	public void setShipChargesRating(float shipChargesRating) {
		this.shipChargesRating = shipChargesRating;
	}
	public int getToUserID() {
		return toUserID;
	}
	public void setToUserID(int toUserID) {
		this.toUserID = toUserID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getFeedbackType() {
		return feedbackType;
	}
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	public String getOverallFeedback() {
		return overallFeedback;
	}
	public void setOverallFeedback(String overallFeedback) {
		this.overallFeedback = overallFeedback;
	}
	
	
	
	

}

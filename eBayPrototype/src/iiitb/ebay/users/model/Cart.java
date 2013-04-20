package iiitb.ebay.users.model;

import java.util.ArrayList;

public class Cart {
	
	private String sellerID;
	private String sellerUserName;
	private int feedbackScore;
	private float positiveFeedback;
	private Double total;
	private ArrayList<Category> cartProduct = new ArrayList<Category>();
	
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	
	public ArrayList<Category> getCartProduct() {
		return cartProduct;
	}
	public void setCartProduct(ArrayList<Category> cartProduct) {
		this.cartProduct = cartProduct;
	}
	public String getSellerUserName() {
		return sellerUserName;
	}
	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}
	public int getFeedbackScore() {
		return feedbackScore;
	}
	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	public float getPositiveFeedback() {
		return positiveFeedback;
	}
	public void setPositiveFeedback(float positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}

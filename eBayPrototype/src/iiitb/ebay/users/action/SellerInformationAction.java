package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.Feedback;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.FeedbackService;
import iiitb.ebay.users.service.ProductService;
import iiitb.ebay.users.service.UserService;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SellerInformationAction {
	
	private int sellerID;
	private int productID;
	
	private java.sql.Blob sellerImage;
	private String memberSince;
	private String sellerUserName;
	private float positiveFeedback;
	private int feedbackScore;
	private ArrayList<Feedback> customerFeedbacks;
	private ArrayList<Category> itemsList;
	private float itemAsDescribed;
	private float communication;
	private float shippingTime;
	private float shippingCharges;
	private int itemAsDescribedCount;
	private int communicationCount;
	private int shippingTimeCount;
	private int shippingChargesCount;
	Map<String,Object>session;
	
	public String execute(){
		//session = ActionContext.getContext().getSession();
		//UserDetails ud = (UserDetails)session.get("userdetails");
		FeedbackService fdbkService = new FeedbackService();
		this.setSellerID(this.getSellerID());
		UserCredential userCreds = new UserCredential();
		UserDetails userDetails = new UserDetails();
		
		/* get the input from this.getSellerID() */
		userDetails = UserService.getUserDetails(this.getSellerID());
		//this.setSellerImage(userDetails.getImage());
		this.setMemberSince(userDetails.getMemberSince());
		
		/* get the input from this.getSellerID() */
		userCreds =  UserService.getUserCredentials(this.getSellerID());
		this.setSellerUserName(userCreds.getUserName());
		
	   this.setCustomerFeedbacks(fdbkService.fetchFeedback(this.getSellerID()));
		
		/* fetch sellers item list */
		ArrayList<Integer> productIDs = ProductService.getproductIDs(this.getSellerID());
		
		this.itemsList = new ArrayList<Category>();
		for (Integer i : productIDs) {
		 itemsList.add(ProductService.fetchSingleProductDetails(i+"").get(0));
		}
		
		/* setting properties*/
		this.setItemAsDescribedCount(fdbkService.getDescriptionRatingCount());
		this.setCommunicationCount(fdbkService.getCommunicationRatingCount());
		this.setShippingChargesCount(fdbkService.getShipChargesRatingCount());
		this.setShippingTimeCount(fdbkService.getShippingRatingCount());
		this.setItemAsDescribed(fdbkService.avgRatingValue("descriptionRating"));
		this.setCommunication(fdbkService.avgRatingValue("communicationRating"));
		this.setShippingCharges(fdbkService.avgRatingValue("shipChargesRating"));
		this.setShippingTime(fdbkService.avgRatingValue("shippingRating"));
		this.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
		
		
		/* Do not know the logic for calculation of this */
		this.setFeedbackScore(fdbkService.getFeedbackList().size());
		
		return "success";
	}
	
	
	public java.sql.Blob getSellerImage() {
		return sellerImage;
	}
	public void setSellerImage(java.sql.Blob blob) {
		this.sellerImage = blob;
	}
	public String getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}
	public float getPositiveFeedback() {
		return positiveFeedback;
	}
	public void setPositiveFeedback(float positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}
	public int getFeedbackScore() {
		return feedbackScore;
	}
	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	public ArrayList<Feedback> getCustomerFeedbacks() {
		return customerFeedbacks;
	}
	public void setCustomerFeedbacks(ArrayList<Feedback> customerFeedbacks) {
		this.customerFeedbacks = customerFeedbacks;
	}
	public float getItemAsDescribed() {
		return itemAsDescribed;
	}
	public void setItemAsDescribed(float itemAsDescribed) {
		this.itemAsDescribed = itemAsDescribed;
	}
	public float getCommunication() {
		return communication;
	}
	public void setCommunication(float communication) {
		this.communication = communication;
	}
	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public int getSellerID() {
		return sellerID;
	}


	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}


	public float getShippingTime() {
		return shippingTime;
	}
	public void setShippingTime(float shippingTime) {
		this.shippingTime = shippingTime;
	}
	public ArrayList<Category> getItemsList() {
		return itemsList;
	}


	public void setItemsList(ArrayList<Category> itemsList) {
		this.itemsList = itemsList;
	}


	public float getShippingCharges() {
		return shippingCharges;
	}
	public String getSellerUserName() {
		return sellerUserName;
	}


	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}


	public void setShippingCharges(float shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public int getItemAsDescribedCount() {
		return itemAsDescribedCount;
	}
	public void setItemAsDescribedCount(int itemAsDescribedCount) {
		this.itemAsDescribedCount = itemAsDescribedCount;
	}
	public int getCommunicationCount() {
		return communicationCount;
	}
	public void setCommunicationCount(int communicationCount) {
		this.communicationCount = communicationCount;
	}
	public int getShippingTimeCount() {
		return shippingTimeCount;
	}
	public void setShippingTimeCount(int shippingTimeCount) {
		this.shippingTimeCount = shippingTimeCount;
	}
	public int getShippingChargesCount() {
		return shippingChargesCount;
	}
	public void setShippingChargesCount(int shippingChargesCount) {
		this.shippingChargesCount = shippingChargesCount;
	}
	

}

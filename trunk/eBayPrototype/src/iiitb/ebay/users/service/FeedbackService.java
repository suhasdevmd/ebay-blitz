package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Feedback;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FeedbackService {
	
	private ArrayList<Feedback> feedbackList;
	private int descriptionRatingCount;
	private int communicationRatingCount;
	private int shippingRatingCount;
	private int shipChargesRatingCount;
	private float positiveFeedback;



	public  ArrayList<Feedback> fetchFeedback(int userID) {
		/* Add the datewise filtering : fetch only last 12 months data */
		String feedbackQuery = "SELECT * FROM feedback WHERE toUserID="
				+ userID;
		Connection connectionFeedback;
		ResultSet resultSetfeedback;
		feedbackList = new ArrayList<Feedback>();
		Feedback feedbackItem;
		int positiveFeedbackCount=0;
		System.out.println("feedback query "+feedbackQuery);
		try {
			connectionFeedback = DB.getConnection();
			resultSetfeedback = DB
					.readFromDB(feedbackQuery, connectionFeedback);

			while (resultSetfeedback !=null && resultSetfeedback.next()) {

				feedbackItem = new Feedback();

				feedbackItem.setFeedbackID(resultSetfeedback
						.getInt("feedbackID"));
				feedbackItem.setFromUserID(resultSetfeedback
						.getInt("fromUserID"));
				feedbackItem.setDetails(resultSetfeedback
						.getString("details"));
				feedbackItem.setDate(resultSetfeedback.getString("date"));
				feedbackItem.setDescriptionRating(resultSetfeedback
						.getFloat("descriptionRating"));
				feedbackItem.setCommunicationRating(resultSetfeedback
						.getFloat("communicationRating"));
				feedbackItem.setShippingRating(resultSetfeedback
						.getFloat("shippingRating"));
				feedbackItem.setShipChargesRating(resultSetfeedback
						.getFloat("shipChargesRating"));
				feedbackItem.setToUserID(resultSetfeedback.getInt("toUserID"));
				feedbackItem
						.setProductID(resultSetfeedback.getInt("productID"));
				feedbackItem.setOrderID(resultSetfeedback.getInt("orderID"));
				feedbackItem.setOverallFeedback(resultSetfeedback.getString("overallFeedback"));
				
				if(feedbackItem.getDescriptionRating() != 0){
					this.setDescriptionRatingCount(this.getDescriptionRatingCount()+1);
				}
				if(feedbackItem.getCommunicationRating() != 0){
					this.setCommunicationRatingCount(this.getCommunicationRatingCount()+1);
				}
				if(feedbackItem.getShippingRating() != 0){			
					this.setShippingRatingCount(this.getShippingRatingCount()+1);
				}
				if(feedbackItem.getShipChargesRating() != 0){
					this.setShipChargesRatingCount(this.getShipChargesRatingCount()+1);
				}
				
				if(feedbackItem.getOverallFeedback().equalsIgnoreCase("Positive")/*feedbackItem.getDescriptionRating() > 0 && feedbackItem.getCommunicationRating() > 0 && feedbackItem.getShippingRating() > 0 && feedbackItem.getShipChargesRating() > 0*/){
					positiveFeedbackCount++;
					
					/* Evaluate if a feedback is positive or negative */
					feedbackItem.setFeedbackType("iconPos_16x16.gif");
					
				}
				else{
					feedbackItem.setFeedbackType("iconNeg_16x16.gif");
				}

				feedbackList.add(feedbackItem);
			}
			connectionFeedback.close();
			
			/* Prevent divide by zero error */
			if(feedbackList != null && feedbackList.size() != 0)
				this.setPositiveFeedback((float)positiveFeedbackCount/feedbackList.size());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return feedbackList;
	}

	public  float avgRatingValue(String type) {

		float avgRating = 0;
		int itemCount=0;
		
		if (type.equalsIgnoreCase("descriptionRating")) {
			for (Feedback feedItem : this.feedbackList) {
				avgRating += feedItem.getDescriptionRating();
				itemCount++;
			}

		} else if (type.equalsIgnoreCase("communicationRating")) {
			for (Feedback feedItem : this.feedbackList) {
				avgRating += feedItem.getCommunicationRating();
				itemCount++;
			}

		} else if (type.equalsIgnoreCase("shippingRating")) {
			for (Feedback feedItem : this.feedbackList) {
				avgRating += feedItem.getShippingRating();
				itemCount++;
			}

		}
		else if (type.equalsIgnoreCase("shipChargesRating")) {
			for (Feedback feedItem : this.feedbackList) {
				avgRating += feedItem.getShipChargesRating();
				itemCount++;
			}

		}
		else{
			itemCount=1;
		}

		return (avgRating/itemCount);
	}
	
	
	public ArrayList<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(ArrayList<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
	
	public int getDescriptionRatingCount() {
		return descriptionRatingCount;
	}
	public void setDescriptionRatingCount(int descriptionRatingCount) {
		this.descriptionRatingCount = descriptionRatingCount;
	}
	public int getCommunicationRatingCount() {
		return communicationRatingCount;
	}
	public void setCommunicationRatingCount(int communicationRatingCount) {
		this.communicationRatingCount = communicationRatingCount;
	}
	public int getShippingRatingCount() {
		return shippingRatingCount;
	}
	public void setShippingRatingCount(int shippingRatingCount) {
		this.shippingRatingCount = shippingRatingCount;
	}
	public int getShipChargesRatingCount() {
		return shipChargesRatingCount;
	}
	public void setShipChargesRatingCount(int shipChargesRatingCount) {
		this.shipChargesRatingCount = shipChargesRatingCount;
	}

	public float getPositiveFeedback() {
		return positiveFeedback;
	}

	public void setPositiveFeedback(float positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}

}

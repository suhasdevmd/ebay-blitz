package iiitb.ebay.users.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import iiitb.ebay.users.model.Feedback;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ProductService;
import iiitb.ebay.users.service.RegisterService;

public class LeaveFeedbackAction extends ActionSupport {

	/**
*
*/
	private static final long serialVersionUID = 1L;
	private int feedbackID;
	private int fromUserID;
	private String details;
	private String date;
	private float descriptionRating;
	private float communicationRating;
	private float shippingRating;
	private float shipChargesRating;
	private String feedbackType;/* positive or negative */

	private int toUserID;
	private int productID;
	private int orderID;
	private int sellerID;

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

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

	public String execute() {
		Feedback feedback = new Feedback();
		ProductService prd = new ProductService();
		RegisterService reg = new RegisterService();
		Map<String, Object> session = (Map<String, Object>) ActionContext
				.getContext().getSession();
		if (null != session.get("login") && (Boolean) session.get("login")) {
			UserDetails ud = (UserDetails) session.get("userdetails");
			feedback.setFromUserID(ud.getUserID());
			feedback.setDetails(details);
			feedback.setDescriptionRating(descriptionRating);
			feedback.setCommunicationRating(communicationRating);
			feedback.setShippingRating(shippingRating);
			feedback.setShipChargesRating(shipChargesRating);
			feedback.setFeedbackType(feedbackType);
			feedback.setToUserID(sellerID);
			feedback.setProductID(productID);
			feedback.setOrderID(ProductService.getOrderID(ud.getUserID(),
					productID));
			feedback.setDate(reg.getDateNow());
			if (ProductService.checkForDuplicateFeedback(feedback)) {
				prd.insertIntoFeedback(feedback);
				return "success";
			} else {
				addActionError(getText("feedback already exists!!"));
				return "duplicate";
			}
		} else {
			return "error";
		}
	}

}
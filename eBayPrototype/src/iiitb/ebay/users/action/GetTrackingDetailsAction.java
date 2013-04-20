package iiitb.ebay.users.action;
import java.util.ArrayList;
import java.util.Map;

import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.model.ViewOrderStatusModel;
import iiitb.ebay.users.service.ViewOrderStatusService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GetTrackingDetailsAction extends ActionSupport {
	private int userID ;
	private ArrayList<ViewOrderStatusModel>itemDetailsList = null;
	private int orderID=0;
	private String trackingDetails = "";
	private int trackingNo = 0;
	public ArrayList<ViewOrderStatusModel> getItemDetailsList() {
		return itemDetailsList;
	}

	public void setItemDetailsList(ArrayList<ViewOrderStatusModel> itemDetailsList) {
		this.itemDetailsList = itemDetailsList;
	}

	
	
	
	public String execute(){
		System.out.println("******************In execute of GetTrackingDetailsAction***********************");
		ViewOrderStatusService trackingService = new ViewOrderStatusService();
		Map<String,Object> session = ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails)session.get("userdetails");
		userID = ud.getUserID();
		itemDetailsList = trackingService.GetItemDetails(userID,orderID);
		
		
		if(itemDetailsList != null && 0 != itemDetailsList.size()){
			System.out.println(itemDetailsList.get(0).getTrackingDetails());
			this.setTrackingDetails(itemDetailsList.get(0).getTrackingDetails()); //hardcoding to get(0) for now to be changed
			this.setTrackingNo( itemDetailsList.get(0).getShippingID()); 			
		
			return "success";
			
		}
			
		
		return "error";
	}

	public String getTrackingDetails() {
		return trackingDetails;
	}

	public void setTrackingDetails(String trackingDetails) {
		this.trackingDetails = trackingDetails;
	}

	public int getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(int trackingNo) {
		this.trackingNo = trackingNo;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	

}

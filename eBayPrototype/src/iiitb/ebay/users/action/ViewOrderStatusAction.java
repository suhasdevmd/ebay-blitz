package iiitb.ebay.users.action;

import java.util.ArrayList;
import java.util.Map;

import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.model.ViewOrderStatusModel;
import iiitb.ebay.users.service.ViewOrderStatusService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewOrderStatusAction extends ActionSupport {

	private String itemImage;
	private String shippingStatus;
	private int quantity;
	private double price;
	private int shippingID;
	private String trackingDetails;
	private int orderID;
	
	public String getTrackingDetails() {
		return trackingDetails;
	}
	public void setTrackingDetails(String trackingDetails) {
		this.trackingDetails = trackingDetails;
	}


	private ArrayList<ViewOrderStatusModel>itemList = null;
	
	public ArrayList<ViewOrderStatusModel> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ViewOrderStatusModel> itemList) {
		this.itemList = itemList;
	}
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	
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
	
	

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String execute(){
		System.out.println("*******In execute of ViewOrderStatusAction************");
		int userID=0;
		
		
 
		Map<String,Object> session  =  ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails) session.get("userdetails"); 
		userID = ud.getUserID();
		//userID = 1; // hardcoding for now
		this.setOrderID(this.getOrderID()); //hardcoding for now ;it has to come from jsp
		ViewOrderStatusService itemService = new ViewOrderStatusService();
		//itemList = itemService.GetItemDetails(userID);
		itemList = itemService.GetOrderItems(this.orderID);

		if(null != itemList && 0 != itemList.size() ){	
			
			//these three fields need to be set explicitly they shouldnt be in an iterator.
			this.setShippingID(itemList.get(0).getShippingID());
			this.setShippingStatus(itemList.get(0).getShippingStatus());
			this.setTrackingDetails(itemList.get(0).getTrackingDetails());
			
		 
			for(int i=0;i<(itemList.size());i++){
				
				//	System.out.println("itemList.ProductID  " + itemList.get(i).getProductID() );
				System.out.println("itemList.Quantity  " + itemList.get(i).getQuantity() );
				System.out.println("itemList.ItemImage  " + itemList.get(i).getItemImage() );
			}
			
			return "success";
		}
		else
			return"error";
	}
	
		
	
}

package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.ManageOrder;
import iiitb.ebay.admin.service.ManageOrderService;
import iiitb.ebay.users.model.UserDetails;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManageOrderAction extends ActionSupport{


	ArrayList<ManageOrder> orderList=new ArrayList<ManageOrder>();
	ManageOrderService mos=new ManageOrderService();
	private int orderID;
	Map<String,Object> session;

	private String username;
	private String productName;
	private String shippingStatus;



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getShippingStatus() {
		return shippingStatus;
	}


	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public ArrayList<ManageOrder> getOrderList() {
		return orderList;
	}


	public void setOrderList(ArrayList<ManageOrder> orderList) {
		this.orderList = orderList;
	}


	public String execute(){
		System.out.println("I am Here in MOA");
		session=ActionContext.getContext().getSession();
		int userid=((UserDetails)session.get("userdetails")).getUserID();
		
		orderList=mos.getOrderlist(userid);
		//System.out.println(" order list ----> "+(orderList.get(0).getUsername()));

		return SUCCESS;
	}


	public String updateOrder(){

		// update order status 

		session=ActionContext.getContext().getSession();
		int userid=((UserDetails)session.get("userdetails")).getUserID();
		
		System.out.println(" the order id to update in update order "+orderID);

		System.out.println(" Suahsssssssss "+username+" "+productName);


		orderList=mos.getOrderlist(userid);
		//System.out.println(" order list up----> "+(orderList.get(0).getUsername()));



		return SUCCESS;
	}

	public String updateOrderStatus(){

		// update order status 

		session=ActionContext.getContext().getSession();
		int userid=((UserDetails)session.get("userdetails")).getUserID();
		
		
		System.out.println(" the order id to update"+orderID);


		int val=mos.updateOrderStatus(orderID, shippingStatus);
		
		if(val==0){
			addActionError("Error updating the shipping status.");
			return "error";
		}
			
		

		orderList=mos.getOrderlist(userid);
		//System.out.println(" order list up----> "+(orderList.get(0).getUsername()));



		return SUCCESS;
	}

}

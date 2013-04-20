package iiitb.ebay.action;

import java.util.ArrayList;
import java.util.Map;

import iiitb.ebay.model.Orders;
import iiitb.ebay.service.OrderService;
import iiitb.ebay.users.model.UserDetails;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewOrdersListAction extends ActionSupport {
	
	public ArrayList<Orders> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(ArrayList<Orders> orderDetails) {
		this.orderDetails = orderDetails;
	}


	private ArrayList<Orders> orderDetails;
	
	
	public String execute(){
		Map<String,Object> session;
		session= ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails)session.get("userdetails");
		this.setOrderDetails(OrderService.getOrders(ud.getUserID()));
		return "success";
	}

}

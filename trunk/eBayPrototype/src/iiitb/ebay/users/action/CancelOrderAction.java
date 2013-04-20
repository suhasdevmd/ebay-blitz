package iiitb.ebay.users.action;

import java.util.Map;

import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CancelOrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CancelOrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int orderID;//to be got from jsp
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public String execute(){
		//request for cancel order comes in
		CancelOrderService cancelOrderService = new CancelOrderService();//could have used the TrackItemStatusService class itself but for clarity's sake using a new one
		Map<String,Object>session = ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails)session.get("userdetails");
		int userID = ud.getUserID();//hard code for now get from session
		//orderID=2;
		System.out.println("cancel order orderid="+this.getOrderID());
		//from db get shipping status if shipping status is 'shipped' print "order cant be cancelled" o/w print "order has been cancelled"
		String orderStatus = cancelOrderService.getOrderStatus("orderID='"+orderID+"'"+"and userID='"+userID+"'");
		//order cancelled successfully ;Shipping Status : SHIPPED ; NOT YET SHIPPED ; CANCELLED ; DELIVERED
		 if (orderStatus.equalsIgnoreCase("NOT_YET_SHIPPED")){
			
			 cancelOrderService.updateDB(orderID,"Order Canceled by user");
			 return "success";
		 }
		 else if (orderStatus.equalsIgnoreCase("SHIPPED") || orderStatus.equalsIgnoreCase("DELIVERED") || orderStatus.equalsIgnoreCase("CANCELLED") ){		 		 
			 return "failure";
		 }
		 
		return "error"; 
	}
	

}

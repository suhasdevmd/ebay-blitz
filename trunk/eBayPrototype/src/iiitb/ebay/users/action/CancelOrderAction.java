package iiitb.ebay.users.action;

import java.util.Map;

import iiitb.ebay.service.OrderService;
import iiitb.ebay.service.PaymentInfoService;
import iiitb.ebay.service.TransactionService;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CancelOrderService;
import iiitb.ebay.users.service.PaymentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CancelOrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int orderID;//to be got from jsp
	
	/*
	 * 0 : ebay : 1 : cash 2 : credit/debit card 3 : PaisaPay
	 */
	private static final int ebay = 0;
	private static final int cash = 1;
	private static final int credit = 2;
	private static final int debit = 3;
	private static final int paisaPay = 4;
	private static final int eBayID = 14;
	
	
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
			
			 cancelOrderService.updateDB(orderID,"Order Canceled by user","CANCELED");
			 return "success";
		 }
		 else if (orderStatus.equalsIgnoreCase("SHIPPED") || orderStatus.equalsIgnoreCase("DELIVERED") || orderStatus.equalsIgnoreCase("CANCELLED") ){		 		 
			 return "failure";
		 }
		 
		return "error"; 
	}
	
	
	public String delivered(){
		
		CancelOrderService cancelOrderService = new CancelOrderService();//could have used the TrackItemStatusService class itself but for clarity's sake using a new one
		Map<String,Object>session = ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails)session.get("userdetails");
		int userID = ud.getUserID();
		String mode;
		double amount =0.0;
		double balance = 0.0;
		int sellerID = 0;
		
		
		System.out.println("delivered order orderid="+this.getOrderID());
	
		String orderStatus = cancelOrderService.getOrderStatus("orderID='"+orderID+"'"+"and userID='"+userID+"'");
		
		//order cancelled successfully ;Shipping Status : SHIPPED ; NOT YET SHIPPED ; CANCELLED ; DELIVERED
		 if (orderStatus.equalsIgnoreCase("SHIPPED")){
			
			 cancelOrderService.updateDB(orderID,"Order Delivery Confirmed by user","DELIVERED");
			 mode = PaymentInfoService.getParam("mode", "WHERE orderID ="+orderID);
			 amount = Double.parseDouble(PaymentInfoService.getParam("amount", "WHERE orderID ="+orderID));
			 sellerID = Integer.parseInt(OrderService.getParam("sellerID", "orders", "WHERE orderID="+orderID));
			 /* If payment was via PaisaPay, transfer money to Seller, 5% eBay Commission */
			 if(mode.equalsIgnoreCase("paisaPay")){
				 
				 
				 	/* add 5% commission to ebay account */
				 	balance = PaymentService.checkBalance(ebay, paisaPay);
					System.out.println("ebay balance " + balance);
					PaymentService.updateAmount(ebay, balance - (amount * 0.95), 1);

					/* deduct ebay share of 5% and pass on money to seller */
					balance = PaymentService.checkBalance(paisaPay, sellerID);
					PaymentService.updateAmount(paisaPay, balance
							+ (amount - (amount * 0.05)), sellerID);
				 
					/* Transaction from eBay to Seller */
					TransactionService.makeTransaction(
							"Transfer eBay PaisaPay to Seller PaisaPay: Total Amount= Rs."
									+ (amount - amount * 0.05),
							TransactionService.getDateNow(), eBayID, sellerID);
				 
			 }
			 
			 return "success";
		 }
		 
		return "error"; 
	}
	

}

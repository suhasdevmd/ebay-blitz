package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.SignOutService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SignOutAction extends ActionSupport{

	Map<String,Object> session;
	
	
	
	public String execute(){
		
		session=ActionContext.getContext().getSession();
		int userID = ((UserDetails)session.get("userdetails")).getUserID();
		ArrayList<Cart> sessionCart = (ArrayList<Cart>)session.get("SessionCart");
		
		SignOutService.updateCartTable(sessionCart,userID);
		
		session.put("login", false);
		session.remove("userdetails");
		
		return SUCCESS;
	}
	
	
	
	
}

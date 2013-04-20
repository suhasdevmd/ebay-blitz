package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CartService;
import iiitb.ebay.users.service.InformSellerService;
import iiitb.ebay.users.service.LoginService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{


	String username,pass;
	LoginService ls=new LoginService();
	ArrayList<String> pd=new ArrayList<String>();
	Map<String,Object> session;
	

	public ArrayList<String> getPd() {
		return pd;
	}

	public void setPd(ArrayList<String> pd) {
		this.pd = pd;
	}



	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPass() {
		return pass;
	}




	public void setPass(String pass) {
		this.pass = pass;
	}




	public String execute(){

		UserDetails ud=new UserDetails();
		boolean val;
		session=ActionContext.getContext().getSession();
		
		
		session.put("login", true);
		
		
		
		System.out.println(username+" -->  "+pass);
		
		val=ls.authenticateUser(username, pass);

		if(!val){

			System.out.println("error");
			addActionError("Invalid username / password combination");
			return ERROR;
			
		}else{
			
		// get the user details and put it in the session	
			
		
			ud=ls.getUserDetails(username, pass);
			
			System.out.println(" sSSSS --> "+ud.getAddress());
			
			session.put("userdetails", ud);
		}
		
		
		
		// to be replaced by actual value
		
		
		int sellerid=2;
		
		
		
		InformSellerService ifs=new InformSellerService();
		pd=ifs.getOutOfStockProduct(sellerid);
		
		
		
		for(int i=0;i<pd.size();i++){
			System.out.println("----> "+pd.get(i));
		}
		
		ArrayList<Cart> sessionCart = CartService.fetchCartItems(ud.getUserID());
		System.out.println("---------------------------Login Action---------------------------");
		System.out.println("sessionCart size = "+sessionCart.size());
		for(int i=0;i<sessionCart.size();i++){
			System.out.println("sellerID = "+sessionCart.get(i).getSellerID());
			System.out.println("seller UserName = "+sessionCart.get(i).getSellerUserName());
			System.out.println("positive FeedBack = "+sessionCart.get(i).getPositiveFeedback());
			System.out.println("feed Back Score = "+sessionCart.get(i).getFeedbackScore());
			System.out.println("%%%%%%%%%%%%%%"+sessionCart.get(i).getCartProduct().size()+"%%%%%%%%%%%%%%");
			for(int j=0;j<sessionCart.get(i).getCartProduct().size();j++){
				System.out.println("\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("\t productID = "+sessionCart.get(i).getCartProduct().get(j).getProductID());
				System.out.println("\t productname = "+sessionCart.get(i).getCartProduct().get(j).getName());
				System.out.println("\t sellerID = "+sessionCart.get(i).getCartProduct().get(j).getSellerID());
				System.out.println("\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
		}
		System.out.println("---------------------------Login Action---------------------------");
		session.put("SessionCart" , sessionCart);
		
		return SUCCESS;
	}


}

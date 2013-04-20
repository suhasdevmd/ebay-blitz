package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.ShippingAddress;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ChangeShippingAddressService;
import iiitb.ebay.users.service.ProductService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateOrderAction extends ActionSupport{

	private String productID;
	ArrayList<Category> productDetails = new ArrayList<Category>();
	private String sellerID;
	Map<String,Object> session;
	ArrayList<Cart> sessionCart;

	private String contactName;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private String country;



	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}


	public String execute(){


		System.out.println("working -- dev --> ");

		session=ActionContext.getContext().getSession();
		int userID=((UserDetails)session.get("userdetails")).getUserID();
		String userIDstring = String.valueOf(userID);


		//ArrayList<Cart> sessionCart = (ArrayList<Cart>) session.get("SessionCart");


			ArrayList<Cart> temp = (ArrayList<Cart>) session.get("SessionCart");
			sessionCart = new ArrayList<Cart>();

			for(int i=0;i<temp.size();i++){
				if(temp.get(i).getSellerID().equalsIgnoreCase(sellerID)){
					sessionCart.add(temp.get(i));
				}
			}


		ChangeShippingAddressService csas = new ChangeShippingAddressService();
		ShippingAddress sa = csas.getPrimaryAddress(userIDstring);

		this.setAddress(sa.getAddress());
		this.setCity(sa.getCity());
		this.setState(sa.getState());
		this.setCountry(sa.getCountry());
		this.setPincode(sa.getPincode());
		this.setContactName(sa.getContactName());

		return SUCCESS;
	}

	
	@SuppressWarnings("unchecked")
	public String buyNowOrder(){


		System.out.println("working -- buy now order --> ");

		session=ActionContext.getContext().getSession();
		int userID=((UserDetails)session.get("userdetails")).getUserID();
		String userIDstring = String.valueOf(userID);
		
		sessionCart = (ArrayList<Cart>) session.get("BuyNow");
		for(int i=0;i<sessionCart.size();i++){
			System.out.println("session cart val "+sessionCart.get(i).getSellerUserName());
			for(int j=0;j<sessionCart.get(i).getCartProduct().size();j++){
				System.out.println("cart pdt val "+sessionCart.get(i).getCartProduct().get(j).getName());
			}
		}
/*
			@SuppressWarnings("unchecked")
			ArrayList<Cart> temp = (ArrayList<Cart>) session.get("sessionBuyNow");
			sessionCart = new ArrayList<Cart>();

			for(int i=0;i<temp.size();i++){
				if(temp.get(i).getSellerID().equalsIgnoreCase(sellerID)){
					sessionCart.add(temp.get(i));
				}
			}

*/
		ChangeShippingAddressService csas = new ChangeShippingAddressService();
		ShippingAddress sa = csas.getPrimaryAddress(userIDstring);

		this.setAddress(sa.getAddress());
		this.setCity(sa.getCity());
		this.setState(sa.getState());
		this.setCountry(sa.getCountry());
		this.setPincode(sa.getPincode());
		this.setContactName(sa.getContactName());

		return SUCCESS;
	}

	
	public ArrayList<Cart> getSessionCart() {
		return sessionCart;
	}

	public void setSessionCart(ArrayList<Cart> sessionCart) {
		this.sessionCart = sessionCart;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

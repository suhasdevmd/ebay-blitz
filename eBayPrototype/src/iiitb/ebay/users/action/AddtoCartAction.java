package iiitb.ebay.users.action;

import com.opensymphony.xwork2.ActionSupport;

public class AddtoCartAction extends ActionSupport {
	private String sellerID;
	private String productID;
	private double price;
	private String name;
	private int quantity;
	
	
	public String getSellerID() {
		return sellerID;
	}


	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String execute(){
		System.out.println("Inside Cart");
		
		System.out.println("values are "+this.getName()+" "+this.getPrice()+" "+this.getProductID()+" "+this.getQuantity()+" "+this.getSellerID());
		
		return "success";
	}

}

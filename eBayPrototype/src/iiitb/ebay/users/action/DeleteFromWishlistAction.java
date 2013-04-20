package iiitb.ebay.users.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ProductService;

public class DeleteFromWishlistAction {
	
	private int productID;
	private int userID;
	private ArrayList<Category> productDetails = new ArrayList<Category>();
	
	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String execute() {
		ProductService wish = new ProductService();
		Map<String,Object> session = (Map<String, Object>) ActionContext.getContext().getSession() ;
		UserDetails ud = (UserDetails)session.get("userdetails");
		wish.deleteFromWishList(" where productID= " + productID + " and userID= " + ud.getUserID());
		productDetails = ProductService.fetchProductsFromWishlist(ud.getUserID());
		return "delete-from-wishlist";
	}
}

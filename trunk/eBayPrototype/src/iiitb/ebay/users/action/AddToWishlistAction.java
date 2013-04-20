package iiitb.ebay.users.action;

import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.model.Wishlist;
import iiitb.ebay.users.service.ProductService;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddToWishlistAction extends ActionSupport {

	private int wishListID;
	private int userID;
	private int productID;

	public int getWishListID() {
		return wishListID;
	}

	public void setWishListID(int wishListID) {
		this.wishListID = wishListID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String execute() {
		Wishlist wishlist = new Wishlist();
		ProductService wish = new ProductService();
		Map<String, Object> session = (Map<String, Object>) ActionContext
				.getContext().getSession();
		if (null != session.get("login") && (Boolean) session.get("login")) {
			UserDetails ud = (UserDetails) session.get("userdetails");
			wishlist.setUserID(ud.getUserID());
			//wishlist.setUserID(1);
			wishlist.setProductID(productID);
			if (ProductService.checkForDuplicateWishlistProduct(wishlist)) {
				wish.insertIntoWishList(wishlist);
				return "success";
			} else {
				addActionError(getText("product in wishlist already exists!!"));
				return "duplicate";
			}
		} else {

			return "error";
		}

	}

}

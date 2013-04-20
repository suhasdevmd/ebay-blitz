package iiitb.ebay.users.model;

public class Wishlist {

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
	
}

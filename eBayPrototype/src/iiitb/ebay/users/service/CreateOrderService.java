package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CreateOrderService {


	public ArrayList<Cart> getProductForUserFromCart(String userID,String sellerID){
		System.out.println("inside getProductForUserFromCart");
		final String fetchCartDetails = "select * from cart where userID= '"+userID+"' and sellerID='"+sellerID+"'";
		ArrayList<Cart> sessionCart = new ArrayList<Cart>();

		Connection connectionCartItems;
		ResultSet resultSetCartItems;

		try {
			connectionCartItems = DB.getConnection();

			resultSetCartItems = DB.readFromDB(fetchCartDetails, connectionCartItems);

			while (resultSetCartItems.next()) {

				int i;
				if(sessionCart.size() > 0){
					System.out.println("IF - cart size > 0 : sessionCart.size = "+sessionCart.size());
					//iterate over each product in the sessionCart
					for(i=0;i<sessionCart.size();i++){
						//if sellerID being sent from the Product.jsp is equal to sellerID in the sessionCart
						//only add another product details to the same sellerID
						//do not create a new cartItem and add to sessionCart
						if(sessionCart.get(i).getSellerID().equalsIgnoreCase(resultSetCartItems.getString("sellerID"))){
							System.out.println("IF - seller ID from sessioncart is equal to sellerID sent from previous jsp");

							Category productDetails = new Category();
							productDetails.setName(resultSetCartItems.getString("productName"));
							productDetails.setProductID(resultSetCartItems.getString("productID"));
							productDetails.setPrice(resultSetCartItems.getString("price"));
							productDetails.setSellerID(resultSetCartItems.getString("sellerID"));
							productDetails.setQuantitySelected(resultSetCartItems.getString("quantity"));
							productDetails.setIsNew("inserted");

							sessionCart.get(i).getCartProduct().add(productDetails);
							break;
						}
					}

					//if no match was found to the sellerID ie loop variable 'i' will be equal to the size of sessionCart
					//this means product is from a new sellerID
					//create a new CartItem and add to sessionCart
					if(i == sessionCart.size()){
						System.out.println("IF - seller ID is not equal.. create a new cart item and add it to the existing session cart");
						Cart cartItem = new Cart();
						Category productDetails = new Category();
						UserCredential userCreds = new UserCredential();
						FeedbackService fdbkService = new FeedbackService();

						productDetails.setName(resultSetCartItems.getString("productName"));
						productDetails.setProductID(resultSetCartItems.getString("productID"));
						productDetails.setPrice(resultSetCartItems.getString("price"));
						productDetails.setSellerID(resultSetCartItems.getString("sellerID"));
						productDetails.setQuantitySelected(resultSetCartItems.getString("quantity"));
						productDetails.setIsNew("inserted");

						cartItem.setSellerID(resultSetCartItems.getString("sellerID"));
						userCreds =  UserService.getUserCredentials(Integer.parseInt(resultSetCartItems.getString("sellerID")));
						cartItem.setSellerUserName(userCreds.getUserName());
						fdbkService.fetchFeedback(Integer.parseInt(resultSetCartItems.getString("sellerID")));  
						cartItem.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
						cartItem.getCartProduct().add(productDetails);

						cartItem.setFeedbackScore(fdbkService.getFeedbackList().size());
						sessionCart.add(cartItem);

					}

					//if sessionCart size is less than or equal to 0.
					//this will be executed only when the session cart is empty
					//create a new cartItem and add it to the sessionCart
				}else{

					System.out.println("ELSE - new CartItem needs to be created");
					Cart cartItem = new Cart();
					Category productDetails = new Category();
					UserCredential userCreds = new UserCredential();
					FeedbackService fdbkService = new FeedbackService();

					productDetails.setName(resultSetCartItems.getString("productName"));
					productDetails.setProductID(resultSetCartItems.getString("productID"));
					productDetails.setPrice(resultSetCartItems.getString("price"));
					productDetails.setSellerID(resultSetCartItems.getString("sellerID"));
					productDetails.setQuantitySelected(resultSetCartItems.getString("quantity"));
					productDetails.setIsNew("inserted");

					cartItem.setSellerID(resultSetCartItems.getString("sellerID"));
					userCreds =  UserService.getUserCredentials(Integer.parseInt(resultSetCartItems.getString("sellerID")));
					cartItem.setSellerUserName(userCreds.getUserName());
					fdbkService.fetchFeedback(Integer.parseInt(resultSetCartItems.getString("sellerID")));
					cartItem.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
					cartItem.setFeedbackScore(fdbkService.getFeedbackList().size());

					ArrayList<Category> temp = cartItem.getCartProduct();  
					temp.add(productDetails);
					cartItem.setCartProduct(temp);

					sessionCart.add(cartItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return sessionCart;
	}





}

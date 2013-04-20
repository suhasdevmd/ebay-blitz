package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class CartService {


	public static ArrayList<Cart> fetchCartItems(int userID){

		System.out.println("inside fetchCartItems");
		final String fetchCartDetails = "select * from cart where userID= "+userID;
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
	
	public static void removeFromCart(String productID,String sellerID,int userID){
		Connection con;
		ResultSet rs;
		
		String query = null;
		
		try {
			con = DB.getConnection();
			query = "delete from cart where productID="+productID+" and sellerID="+sellerID+" and userID="+userID+";";
			DB.update(query);
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void UpdateQuantities(String sellerID){
		Map<String,Object> session = ActionContext.getContext().getSession();
		int userID = ((UserDetails)session.get("userdetails")).getUserID();

		try {
			Connection con = DB.getConnection();
			ResultSet resultSet;

			String query = "select productID, quantity from cart where sellerID="+sellerID+" and userID="+userID+";";

			resultSet = DB.readFromDB(query, con);
			//ArrayList<String> productsIDs = new ArrayList<String>();
			System.out.println("----"+query);
			while (resultSet.next()) {

				String tempProductID = resultSet.getString("productID");
				String tempQuantity = resultSet.getString("quantity");

				fetchQuantityAvailable(tempProductID, tempQuantity,sellerID);

			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	private static void fetchQuantityAvailable(String tempProductID, String tempQuantity, String tempSellerID) {

		try {
			Connection con = DB.getConnection();
			ResultSet resultSet;

			String query = "select val from producteav where entity='"+tempProductID+"' and attr='quantity';";

			resultSet = DB.readFromDB(query, con);
			ArrayList<String> productsIDs = new ArrayList<String>();

			while (resultSet.next()) {

				String tempQuantityAvailable = resultSet.getString("val");
				updateProducteav(tempProductID, tempQuantity, tempQuantityAvailable);

			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	private static void updateProducteav(String tempProductID,
			String tempQuantity, String tempQuantityAvailable) {
		try {
			Connection con = DB.getConnection();

			int updateQuantity = Integer.parseInt(tempQuantityAvailable) - Integer.parseInt(tempQuantity);

			String query = "update producteav set val='"+String.valueOf(updateQuantity)+"' where entity='"+tempProductID+"' and attr='quantity';";

			DB.update(query);


			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

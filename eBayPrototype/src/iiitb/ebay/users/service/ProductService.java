package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.Feedback;
import iiitb.ebay.users.model.Wishlist;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {

	private static final String fetchProductDetails = "select * from producteav where entity= ";
	private static final String fetchProductIDs = "select entity from producteav where attr='sellerid' and val=";

	public static ArrayList<Category> fetchSingleProductDetails(String productID) {

		System.out.println("inside fetchSingleProductDetails");
		Connection connectionProductDetails;
		ResultSet resultSetProductDetails;
		ArrayList<Category> productDetails = new ArrayList<Category>();
		Category product = new Category();

		try {
			connectionProductDetails = DB.getConnection();
			 System.out.println("++++++++++++++++++++++++++\n"+fetchProductDetails+ productID+"\n+++++++++++++++++++++++++++++++");
			resultSetProductDetails = DB.readFromDB(fetchProductDetails
					+ productID, connectionProductDetails);

			System.out
					.println("_____________________________________________________________");
			while (resultSetProductDetails.next()) {

				product.setProductID(productID);

				if (resultSetProductDetails.getString("attr").equalsIgnoreCase(
						"Name")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setName(resultSetProductDetails.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("price")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setPrice(resultSetProductDetails.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("quantity")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setQuantityAvailable(resultSetProductDetails
							.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("condition")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setProductCondition(resultSetProductDetails
							.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("brand")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setBrand(resultSetProductDetails.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("sellerID")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setSellerID(resultSetProductDetails
							.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("categoryid")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setCategoryID(resultSetProductDetails
							.getString("val"));
				} else if (resultSetProductDetails.getString("attr")
						.equalsIgnoreCase("duration")) {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.setDuration(resultSetProductDetails
							.getString("val"));
				} else {
					System.out
							.println(resultSetProductDetails.getString("val"));
					product.getDescription().put(
							resultSetProductDetails.getString("attr"),
							resultSetProductDetails.getString("val"));
				}

			}
			System.out
					.println("_____________________________________________________________");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		product.setImage1(getProductImage(product.getProductID()));
		productDetails.add(product);
		return productDetails;
	}

	public static ArrayList<Integer> getproductIDs(int sellerID) {

		Connection connectionProductIDs;
		ResultSet resultSetProductIDs;
		ArrayList<Integer> productIDs = new ArrayList<Integer>();
		Category product = new Category();

		try {
			connectionProductIDs = DB.getConnection();
			// System.out.println("++++++++++++++++++++++++++\n"+fetchProductDetails+"\n+++++++++++++++++++++++++++++++");
			resultSetProductIDs = DB.readFromDB(fetchProductIDs + "'"
					+ sellerID + "'", connectionProductIDs);

			while (resultSetProductIDs.next()) {
				productIDs.add(resultSetProductIDs.getInt("entity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productIDs;

	}

	public int insertIntoWishList(Wishlist wishlist) {
		// System.out.println("hello \n\n");

		String insertSQL = "insert into wishlist " + " (userID, productID) "
				+ " values(" + wishlist.getUserID() + ", "
				+ wishlist.getProductID() + ");";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}

	public static ArrayList<Category> fetchProductsFromWishlist(int userID) {

		Connection connection;
		Connection connection2;
		String retrieveFromWishList = "select * from wishlist where userID = "
				+ userID;
		System.out.println("query =" + retrieveFromWishList);
		ResultSet resultSetProductDetails;
		ResultSet resultSetWishList;
		ArrayList<Category> productDetails = new ArrayList<Category>();
		Category product;// = new Category();

		try {
			connection = DB.getConnection();
			connection2 = DB.getConnection();
			resultSetWishList = DB.readFromDB(retrieveFromWishList, connection);
			String productID = "";
			// resultSetWishList.getString("productID");

			System.out
					.println("_____________________________________________________________");
			while (resultSetWishList.next()) {
				productID = resultSetWishList.getString("productID");
				resultSetProductDetails = DB.readFromDB(fetchProductDetails
						+ productID, connection2);
				product = new Category();
				while (resultSetProductDetails.next()) {

					product.setProductID(productID);
					product.setImage1(getProductImage(product.getProductID()));

					if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("Name")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setName(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("price")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setPrice(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("quantity")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setQuantityAvailable(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("condition")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setProductCondition(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("brand")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setBrand(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("sellerID")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setSellerID(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("CategoryID")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setCategoryID(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("duration")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setDuration(resultSetProductDetails
								.getString("val"));
					} else {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.getDescription().put(
								resultSetProductDetails.getString("attr"),
								resultSetProductDetails.getString("val"));
					}

				}
				productDetails.add(product);
			}
			System.out
					.println("_____________________________________________________________");
			connection.close();
			connection2.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		return productDetails;
	}
		
	public int deleteFromWishList(String deleteModifier) {
		// System.out.println("hello \n\n");

		String deleteSQL = "delete from wishlist " + deleteModifier;
		System.out.println(deleteSQL);
		return DB.update(deleteSQL);
	}

	public static boolean checkForDuplicateWishlistProduct(Wishlist wish) {

		ResultSet resultSet = null;
		String query = "select * from wishlist where userID = "
				+ wish.getUserID() + " and productID= " + wish.getProductID();
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet != null && resultSet.first()) {
				DB.close(resultSet);
				DB.close(connection);
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return true;

	}

	public static int getOrderID(int userID, int productID) {

		Connection connectionOrderID;
		ResultSet resultSetOrderID;
		/*String query = "select * from orders o,orderitems oi where o.orderID=oi.orderID and o.shippingStatus='Delivered' and userID = "
				+ userID + " and oi.productID= " + productID;*/
		String query = "select * from orders o,orderitems oi where o.orderID=oi.orderID and userID = "
				+ userID + " and oi.productID= " + productID;
		int OrderID = 0;
		Category product = new Category();

		try {
			connectionOrderID = DB.getConnection();
			// System.out.println("++++++++++++++++++++++++++\n"+fetchProductDetails+"\n+++++++++++++++++++++++++++++++");
			resultSetOrderID = DB.readFromDB(query, connectionOrderID);

			if (resultSetOrderID.next()) {
				OrderID = resultSetOrderID.getInt("orderID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderID;

	}

	public static ArrayList<Category> fetchBoughtProducts(int userID) {

		Connection connection;
		Connection connection2;
		/*String retrieveBoughtProducts = "select * from orders o,orderitems oi where o.orderID=oi.orderID and o.shippingStatus='DELIVERED' and userID = "
				+ userID;*/
		String retrieveBoughtProducts = "select * from orders o,orderitems oi where o.orderID=oi.orderID and userID = "
				+ userID;
		System.out.println("query =" + retrieveBoughtProducts);
		ResultSet resultSetProductDetails;
		ResultSet resultSetBoughtproducts;
		ArrayList<Category> productDetails = new ArrayList<Category>();
		Category product;// = new Category();
		int orderID=0;

		try {
			connection = DB.getConnection();
			connection2 = DB.getConnection();
			resultSetBoughtproducts = DB.readFromDB(retrieveBoughtProducts,
					connection);
			String productID = "";
			// resultSetWishList.getString("productID");

			System.out
					.println("_____________________________________________________________");
			while (resultSetBoughtproducts.next()) {
				productID = resultSetBoughtproducts.getString("productID");
				resultSetProductDetails = DB.readFromDB(fetchProductDetails
						+ productID, connection2);
				product = new Category();
				while (resultSetProductDetails.next()) {

					product.setProductID(productID);

					if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("Name")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setName(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("price")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setPrice(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("quantity")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setQuantitySelected(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("condition")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setProductCondition(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("brand")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setBrand(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("sellerID")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setSellerID(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("CategoryID")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setCategoryID(resultSetProductDetails
								.getString("val"));
					} else if (resultSetProductDetails.getString("attr")
							.equalsIgnoreCase("duration")) {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.setDuration(resultSetProductDetails
								.getString("val"));
					} else {
						System.out.println(resultSetProductDetails
								.getString("val"));
						product.getDescription().put(
								resultSetProductDetails.getString("attr"),
								resultSetProductDetails.getString("val"));
					}

				}
				productDetails.add(product);
			}
			System.out
					.println("_____________________________________________________________");
			connection.close();
			connection2.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return productDetails;
	}

	/* USING users.FeedBack */
	public int insertIntoFeedback(Feedback feedback) {
		// System.out.println("hello \n\n");
		String feedbackValue = null;
		
		if(feedback.getFeedbackType().equalsIgnoreCase("1"))
			feedbackValue = "positive";
		else if(feedback.getFeedbackType().equalsIgnoreCase("2"))
			feedbackValue = "neutral";
		else if(feedback.getFeedbackType().equalsIgnoreCase("3"))
			feedbackValue = "negative";
		else 
			feedbackValue = "later";
		
		String insertSQL = "insert into feedback "
				+ " (fromUserID, details, date, descriptionRating, communicationRating, shippingRating, shipChargesRating, toUserID, productID, orderID, overallFeedback) "
				+ " values("
				+ feedback.getFromUserID()
				+ ", '"
				+ feedback.getDetails()
				+ "', '"
				+ feedback.getDate()
				+ "', "
				+ feedback.getDescriptionRating()
				+ ", "
				+ feedback.getCommunicationRating()
				+ ", "
				+ feedback.getShippingRating()
				+ ", "
				+ feedback.getShipChargesRating()
				+ ", "
				+ feedback.getToUserID()
				+ ", "
				+ feedback.getProductID()
				+ ", "
				+ feedback.getOrderID()
				+ ", '"
				+ feedbackValue + "');";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}
	
	
	
	
	public static String getProductImage(String productID){
		String productImage="";
		
		
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();

			query = "select image1 from productimage where productID="+productID;
			
			System.out.println(" ----+++++ "+query);

			rs = DB.readFromDB(query, con);
			// System.out.println(query);
			while (rs.next()) {
				productImage=rs.getString("image1");
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("  )))))))))))))))))))) "+productImage);
		
		return productImage;
		
		
	}
 	
	
	
	
	/*public static int getOrderID(int userID, int productID) {

		Connection connectionOrderID;
		ResultSet resultSetOrderID;
		String query = "select * from orders o,orderitems oi where o.orderID=oi.orderID and o.shippingStatus='Delivered' and userID = "
				+ userID + " and oi.productID= " + productID;
		String query = "select * from orders o,orderitems oi where o.orderID=oi.orderID and userID = "
				+ userID + " and oi.productID= " + productID;
		int OrderID = 0;
		Category product = new Category();

		try {
			connectionOrderID = DB.getConnection();
			// System.out.println("++++++++++++++++++++++++++\n"+fetchProductDetails+"\n+++++++++++++++++++++++++++++++");
			resultSetOrderID = DB.readFromDB(query, connectionOrderID);

			if (resultSetOrderID.next()) {
				OrderID = resultSetOrderID.getInt("orderID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderID;

	}
*/
	
	
	public static boolean checkForDuplicateFeedback(Feedback feedback) {

		ResultSet resultSet = null;
		String query= "select * from feedback where productID = " + feedback.getProductID() + " and orderID= " + feedback.getOrderID();
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
		if (resultSet!=null && resultSet.first()) {
		DB.close(resultSet);
		DB.close(connection);
		return false;
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return true;

		}
 	

	
	

}

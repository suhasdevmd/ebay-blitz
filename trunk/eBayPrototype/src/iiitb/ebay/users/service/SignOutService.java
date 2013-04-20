package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SignOutService {

	public static void updateCartTable(ArrayList<Cart> sessionCart, int userID){
		Connection con;

		String sellerID = null;
		String productID = null;
		String quantity = null;
		String productName = null;
		String price = null;
		String isNew = null;
		String query = null;

		try {
			con = DB.getConnection();

			for(int i=0;i<sessionCart.size();i++){
				sellerID = sessionCart.get(i).getSellerID();
				for(int j=0;j<sessionCart.get(i).getCartProduct().size();j++){
					productID = sessionCart.get(i).getCartProduct().get(j).getProductID();
					productName = sessionCart.get(i).getCartProduct().get(j).getName();
					quantity = sessionCart.get(i).getCartProduct().get(j).getQuantitySelected();
					price = sessionCart.get(i).getCartProduct().get(j).getPrice();
					isNew = sessionCart.get(i).getCartProduct().get(j).getIsNew();
					System.out.println("cart flag for "+j+" "+isNew);
					if(isNew.equalsIgnoreCase("new")){
						System.out.println("SignOutService - new Query");
						query = "insert into cart(productID,userID,sellerID,quantity,productName,price)values('"+productID+"',"+userID+",'"+sellerID+"','"+quantity+"','"+productName+"','"+price+"')";
					}
					if(isNew.equalsIgnoreCase("modified")){
						query = "update cart set quantity = '"+quantity+"' where userID='"+userID+"' and productID='"+productID+"' and sellerID='"+sellerID+"' ";
					}

					DB.update(query);

				}

			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

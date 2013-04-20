package iiitb.ebay.service;

import iiitb.ebay.model.ProductData;
import iiitb.ebay.users.service.ProductService;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchHomepageDataService {
	static ArrayList<ProductData> productNames;
	static Connection con;
	static ResultSet rs;
	static String query;
	
	/* Returns String for now. Should be modified to return Map
	 * when the images are also dynamically retrieved.
	 */
 	public static ArrayList<ProductData> getFromOurSellers() {
		productNames = new ArrayList<ProductData>();
		con = DB.getConnection();
		query = "SELECT entity, val from producteav where attr = 'name'";
		rs = DB.readFromDB(query, con);
		
		int counter = 0;
		try {
			while(rs.next()) {
				if(counter < 4) {
					System.out.println(rs.getString(2));
					ProductData temp = new ProductData();
					temp.setId(rs.getLong(1));
					temp.setName(rs.getString(2));
					temp.setImage1(ProductService.getProductImage( String.valueOf(temp.getId())));
					productNames.add(temp);
					counter++;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in FetchHomepageDataService->getFromOurSellers()");
		}
		
		return productNames;
	}
}

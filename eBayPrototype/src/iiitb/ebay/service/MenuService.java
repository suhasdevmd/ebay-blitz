package iiitb.ebay.service;

import iiitb.ebay.admin.model.CategoryHierarchy;
import iiitb.ebay.admin.service.ManageOrderService;
import iiitb.ebay.model.Menu;
import iiitb.ebay.users.service.InformSellerService;
import iiitb.ebay.utilities.DB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;

public class MenuService {

	private static final String fetchCategories = "SELECT * from producthierarchy WHERE parent IS NULL";
	private static final String fetchSubCategories = "SELECT * from producthierarchy WHERE parent = ";

	/* Fetch the entire menu from the hierarchy */
	public static ArrayList<Menu> fetchMenu() {
		Connection connectionCategories;
		Connection connectionSubCategories;
		ResultSet resultSetCategories;
		ResultSet resultSetSubCategories;
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Menu menuItem;
		CategoryHierarchy prodhDetailsCategories;
		CategoryHierarchy prodhDetailsSubCategories;
		Map<String, String> subCategoryList;
		
		
		try {
			connectionCategories = DB.getConnection();
			connectionSubCategories = DB.getConnection();

			resultSetCategories = DB.readFromDB(fetchCategories,
					connectionCategories);
			
			//callSuhas();

			/* iterate all the Categories */
			while (resultSetCategories.next()) {

				menuItem = new Menu();

				/* Fetch Data */
				prodhDetailsCategories = new CategoryHierarchy();
				prodhDetailsCategories.setPhKey(resultSetCategories
						.getString("phKey"));
				prodhDetailsCategories.setName(resultSetCategories
						.getString("name"));
				prodhDetailsCategories.setHasChild(resultSetCategories
						.getString("hasChild"));
				prodhDetailsCategories.setParent(resultSetCategories
						.getString("parent"));

				/* Populate the menuItem */
				menuItem.setBaseCategory(prodhDetailsCategories.getName());
				menuItem.setPhKey(prodhDetailsCategories.getPhKey());
				
				/* Fetch SubCategories only if they exist */
				if (prodhDetailsCategories.getHasChild().equalsIgnoreCase("Y")) {

					subCategoryList = new HashMap<String, String>();

					resultSetSubCategories = DB.readFromDB(fetchSubCategories
							+ "'" + prodhDetailsCategories.getPhKey() + "'",
							connectionSubCategories);
					while (resultSetSubCategories.next()) {

						/* Fetch Data */
						prodhDetailsSubCategories = new CategoryHierarchy();
						prodhDetailsSubCategories.setPhKey(resultSetSubCategories
								.getString("phKey"));
						//System.out.println("phKey = "+prodhDetailsSubCategories.getPhKey());
						prodhDetailsSubCategories.setName(resultSetSubCategories
								.getString("name"));
						//System.out.println("Name = "+prodhDetailsSubCategories.getName());
						prodhDetailsSubCategories
								.setHasChild(resultSetSubCategories
										.getString("hasChild"));
						prodhDetailsSubCategories.setParent(resultSetSubCategories
								.getString("parent"));

						/* Add to list */
						subCategoryList.put(
								prodhDetailsSubCategories.getPhKey(),
								prodhDetailsSubCategories.getName());
					}

					/* Set the categorylist for the Main Product Category */
					menuItem.setSubcategory(subCategoryList);
				} else {
					menuItem.setSubcategory(null);
				}

				/* Add menuItem to the menuList */
				menuList.add(menuItem);
			}

			/* Close the connections */
			connectionSubCategories.close();
			connectionCategories.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return menuList;
	}

	
	
	/* fetch the subcategory for the input Category key */
	public static Map<String, String> fetchSubCategories(String phKey) {

		CategoryHierarchy prodhDetailsSubCategories;
		Map<String, String> subCategoryList = new HashMap<String, String>();
		Connection connectionSubCategories;
		ResultSet resultSetSubCategories;

		try {
			connectionSubCategories = DB.getConnection();
			
			/* fetch the resultSet */
			resultSetSubCategories = DB.readFromDB(fetchSubCategories + "'"
					+ phKey + "'", connectionSubCategories);
			
			/* Iterate overall the items and populate the list */
			while (resultSetSubCategories.next()) {
				subCategoryList.put(resultSetSubCategories.getString("phKey"),
						resultSetSubCategories.getString("name"));
			}
			
			connectionSubCategories.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return subCategoryList;
	}
/*	
	public static void callSuhas(){
		InformSellerService inf =new InformSellerService();
		 inf.getOutOfStockProduct(1);
		//System.out.println("value="+lst.get(0));
	}
*/
}

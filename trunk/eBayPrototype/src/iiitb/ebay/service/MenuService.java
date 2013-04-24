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
		Connection connectionSubSubCategories;
		ResultSet resultSetCategories;
		ResultSet resultSetSubCategories;
		ResultSet resultSetSubSubCategories;
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Menu menuItem;
		CategoryHierarchy prodhDetailsCategories;
		CategoryHierarchy prodhDetailsSubCategories;
		CategoryHierarchy prodhDetailsSubSubCategories;
		CategoryHierarchy prodhDetailsSubSubSubCategories;
		Map<String, String> subCategoryList;
		Map<String, String> subSubCategoryList;

		/* More nesting */
		Menu subMenuItem;
		Map<String, Menu> childCategory;

		try {
			connectionCategories = DB.getConnection();
			connectionSubCategories = DB.getConnection();
			connectionSubSubCategories = DB.getConnection();

			resultSetCategories = DB.readFromDB(fetchCategories,
					connectionCategories);

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
				menuItem.setHasChild(prodhDetailsCategories.getHasChild());

				/* Fetch SubCategories only if they exist */
				if (prodhDetailsCategories.getHasChild().equalsIgnoreCase("Y")) {

					subCategoryList = new HashMap<String, String>();
					childCategory = new HashMap<String, Menu>();
					resultSetSubCategories = DB.readFromDB(fetchSubCategories
							+ "'" + prodhDetailsCategories.getPhKey() + "'",
							connectionSubCategories);
					while (resultSetSubCategories.next()) {

						/* Fetch Data */
						prodhDetailsSubCategories = new CategoryHierarchy();
						prodhDetailsSubCategories
								.setPhKey(resultSetSubCategories
										.getString("phKey"));
						prodhDetailsSubCategories
								.setName(resultSetSubCategories
										.getString("name"));
						prodhDetailsSubCategories
								.setHasChild(resultSetSubCategories
										.getString("hasChild"));
						prodhDetailsSubCategories
								.setParent(resultSetSubCategories
										.getString("parent"));

						/* Add to list */

						subCategoryList.put(
								prodhDetailsSubCategories.getPhKey(),
								prodhDetailsSubCategories.getName());

						if (prodhDetailsSubCategories.getHasChild()
								.equalsIgnoreCase("Y")) {

							/* Another level of nesting */
							subMenuItem = new Menu();
							subMenuItem
									.setBaseCategory(prodhDetailsSubCategories
											.getName());
							subMenuItem.setPhKey(prodhDetailsSubCategories
									.getPhKey());
							subMenuItem.setHasChild(prodhDetailsSubCategories
									.getHasChild());

							subSubCategoryList = new HashMap<String, String>();
							resultSetSubSubCategories = DB.readFromDB(
									fetchSubCategories
											+ "'"
											+ prodhDetailsSubCategories
													.getPhKey() + "'",
									connectionSubSubCategories);

							while (resultSetSubSubCategories.next()) {

								/* Fetch Data */
								prodhDetailsSubSubSubCategories = new CategoryHierarchy();
								prodhDetailsSubSubSubCategories
										.setPhKey(resultSetSubSubCategories
												.getString("phKey"));
								prodhDetailsSubSubSubCategories
										.setName(resultSetSubSubCategories
												.getString("name"));
								prodhDetailsSubSubSubCategories
										.setHasChild(resultSetSubSubCategories
												.getString("hasChild"));
								prodhDetailsSubSubSubCategories
										.setParent(resultSetSubSubCategories
												.getString("parent"));

								/* Add to list */
								subSubCategoryList.put(
										prodhDetailsSubSubSubCategories
												.getPhKey(),
										prodhDetailsSubSubSubCategories
												.getName());
							}
							subMenuItem.setSubcategory(subSubCategoryList);
							childCategory.put(
									prodhDetailsSubCategories.getPhKey(),
									subMenuItem);
						}

					}

					/* Set the categorylist for the Main Product Category */
					menuItem.setSubcategory(subCategoryList);
					menuItem.setChildCategory(childCategory);
				} else {
					menuItem.setSubcategory(null);
				}

				/* Add menuItem to the menuList */
				menuList.add(menuItem);
			}

			/* Close the connections */
			connectionSubSubCategories.close();
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
	 * public static void callSuhas(){ InformSellerService inf =new
	 * InformSellerService(); inf.getOutOfStockProduct(1);
	 * //System.out.println("value="+lst.get(0)); }
	 */


	/* Fetch the entire menu from the hierarchy */
	public static ArrayList<Menu> fetchMultiLevelMenu() {
		Connection connectionCategories;

		ResultSet resultSetCategories;

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		CategoryHierarchy prodhDetailsCategories;
		Menu menuItem;

		try {
			connectionCategories = DB.getConnection();

			resultSetCategories = DB.readFromDB(fetchCategories,
					connectionCategories);

			/* iterate all the Categories */
			while (resultSetCategories.next()) {

				menuItem = new Menu();

				/* Fetch Data For Top level Category */
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
				menuItem.setHasChild(prodhDetailsCategories.getHasChild());

				/* Fetch SubCategories only if they exist */
				if (prodhDetailsCategories.getHasChild().equalsIgnoreCase("Y")) {
					/* Fetch SubCategory Details */
					fetchsubMenu(prodhDetailsCategories.getPhKey(), menuItem);

					/* Iterate all subcategories */
					for (Map.Entry<String, Menu> level2 : menuItem
							.getChildCategory().entrySet()) {
						Menu menuObjLevel2 = level2.getValue();
						/* Check if SubCategory has further level */
						if (menuObjLevel2.getHasChild().equalsIgnoreCase("Y")) {
							fetchsubMenu(menuObjLevel2.getPhKey(),
									menuObjLevel2);
							/* Iterate Level3 */
							for (Map.Entry<String, Menu> level3 : menuObjLevel2
									.getChildCategory().entrySet()) {
								Menu menuObjLevel3 = level3.getValue();
								/* Chekc if Level 3 has data */
								if (menuObjLevel3.getHasChild()
										.equalsIgnoreCase("Y")) {
									fetchsubMenu(menuObjLevel3.getPhKey(),
											menuObjLevel3);
								}

							}

						}
					}

				} else {
					menuItem.setSubcategory(null);
				}

				/* Add menuItem to the menuList */
				menuList.add(menuItem);
			}

			/* Close the connections */
			connectionCategories.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return menuList;
	}
	
	
	public static void fetchsubMenu(String phKey, Menu menuItem) {

		CategoryHierarchy prodhDetailsSubCategories;
		Map<String, Menu> childCatMenuList = new HashMap<String, Menu>();
		Map<String, String> childCatStringList = new HashMap<String, String>();

		try {
			Connection connectionSubCategories = DB.getConnection();
			ResultSet resultSetSubCategories = DB.readFromDB(fetchSubCategories
					+ "'" + phKey + "'", connectionSubCategories);

			while (resultSetSubCategories.next()) {

				Menu subMenuItem = new Menu();

				/* Fetch Data */
				prodhDetailsSubCategories = new CategoryHierarchy();
				prodhDetailsSubCategories.setPhKey(resultSetSubCategories
						.getString("phKey"));
				prodhDetailsSubCategories.setName(resultSetSubCategories
						.getString("name"));
				prodhDetailsSubCategories.setHasChild(resultSetSubCategories
						.getString("hasChild"));
				prodhDetailsSubCategories.setParent(resultSetSubCategories
						.getString("parent"));

				subMenuItem
						.setBaseCategory(prodhDetailsSubCategories.getName());
				subMenuItem.setPhKey(prodhDetailsSubCategories.getPhKey());
				subMenuItem
						.setHasChild(prodhDetailsSubCategories.getHasChild());


				/* Add to list */
				childCatMenuList.put(prodhDetailsSubCategories.getPhKey(),
						subMenuItem);
				childCatStringList.put(prodhDetailsSubCategories.getPhKey(),
						prodhDetailsSubCategories.getName());

			}
			menuItem.setSubcategory(childCatStringList);
			menuItem.setChildCategory(childCatMenuList);
			connectionSubCategories.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package iiitb.ebay.users.service;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CategoryService {

	public static ArrayList<Category> fetchProduct(String CategoryID) {

		final String fetchProductID = "select p.entity, count(*) as numberofattributes ,img.image1, img.image2, img.image3, img.image4"
				+ " from producteav p, productimage img"
				+ " where p.entity = img.productID and entity in"
				+ "( select entity"
				+ " from producteav p"
				+ " where p.attr='categoryid'"
				+ " and p.val LIKE '"
				+ CategoryID + "%' )" + " group by entity";
		final String fetchProductDetails = "select * from producteav p,productimage i where p.entity in (select entity from producteav where attr='categoryid' and val LIKE '"
				+ CategoryID + "%') and p.entity=i.productID order by p.entity";

		Connection connectionProductID;
		Connection connectionProductDetails;
		ResultSet resultSetProductID = null;
		ResultSet resultSetProductDetails;

		ArrayList<String> productID = new ArrayList<String>();
		ArrayList<Category> productDetails = new ArrayList<Category>();
		/*
		 * Map<String, String> descTemp; descTemp = new HashMap<String,
		 * String>();
		 */

		try {
			connectionProductID = DB.getConnection();
			System.out.println("++++++++++++++++++++++++++\n" + fetchProductID
					+ "\n+++++++++++++++++++++++++++++++");
			resultSetProductID = DB.readFromDB(fetchProductID,
					connectionProductID);
			productDetails.clear();

			while (resultSetProductID.next()) {

				Category prodInfo = new Category();
				prodInfo.setProductID(resultSetProductID.getString("entity"));
				prodInfo.setNumberOfAttributes(resultSetProductID
						.getInt("numberofattributes"));
				prodInfo.setImage1(resultSetProductID.getString("image1"));

				/*
				 * prodInfo.setImage2(resultSetProductID.getBlob("image2"));
				 * prodInfo.setImage3(resultSetProductID.getBlob("image3"));
				 * prodInfo.setImage4(resultSetProductID.getBlob("image4"));
				 */

				productDetails.add(prodInfo);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		try {
			connectionProductDetails = DB.getConnection();
			// System.out.println("++++++++++++++++++++++++++\n"+fetchProductDetails+"\n+++++++++++++++++++++++++++++++");
			resultSetProductDetails = DB.readFromDB(fetchProductDetails,
					connectionProductDetails);

			System.out.println("size = " + productDetails.size());
			for (int i = 0; i < productDetails.size(); i++) {
				System.out.println("Inside the for-------------");
				int count = 0;
				while (count < productDetails.get(i).getNumberOfAttributes()
						&& resultSetProductDetails.next()) {
					System.out.println("Inside while----------------");
					++count;
					System.out.println("###################### count = "
							+ count);
					System.out
							.println("###################### noofAttributes = "
									+ productDetails.get(i)
											.getNumberOfAttributes()
									+ "################## productID = "
									+ productDetails.get(i).getProductID());

					String prodIDTemp = resultSetProductDetails
							.getString("entity");
					System.out.println("temp ProdID" + prodIDTemp);

					if (prodIDTemp.equalsIgnoreCase(productDetails.get(i)
							.getProductID())) {
						System.out.println("Outter if");
						String attrTemp = resultSetProductDetails
								.getString("attr");

						if (attrTemp.equalsIgnoreCase("Name")) {
							System.out.println("if for name");
							productDetails.get(i).setName(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("price")) {
							System.out.println("if for price");
							productDetails.get(i).setPrice(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("quantity")) {
							System.out.println("if for quantity");
							productDetails.get(i).setQuantityAvailable(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("condition")) {
							System.out.println("if for condition");
							productDetails.get(i).setProductCondition(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("brand")) {
							System.out.println("if for brand");
							productDetails.get(i).setBrand(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("sellerID")) {
							System.out.println("if for sellerID");
							productDetails.get(i).setSellerID(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("CategoryID")) {
							System.out.println("if for categoryID");
							productDetails.get(i).setCategoryID(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("duration")) {
							System.out.println("if for duration");
							productDetails.get(i).setDuration(
									resultSetProductDetails.getString("val"));
						} else {
							System.out.println("if for other things");
							String valTemp = resultSetProductDetails
									.getString("val");
							productDetails.get(i).getDescription()
									.put(attrTemp, valTemp);

						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return productDetails;
	}

	public static ArrayList<Category> fetchDealsProduct(String CategoryID) {

		final String fetchProductID = "select p.entity, count(*) as numberofattributes ,img.image1, img.image2, img.image3, img.image4"
				+ " from producteav p, productimage img"
				+ " where p.entity = img.productID and entity in"
				+ "( select entity"
				+ " from producteav p"
				+ " where p.attr='categoryid'"
				+ " and p.val LIKE '"
				+ CategoryID
				+ "%' ) and p.entity in (select entity from producteav where attr='discount')"
				+ " group by entity";
		final String fetchProductDetails = "select * from producteav p,productimage i where p.entity in (select entity from producteav where attr='categoryid' and val LIKE '"
				+ CategoryID
				+ "%') and p.entity in (select entity from producteav where attr='discount' ) and p.entity=i.productID order by p.entity";

		Connection connectionProductID;
		Connection connectionProductDetails;
		ResultSet resultSetProductID = null;
		ResultSet resultSetProductDetails;

		String startDate = null, endDate = null;

		ArrayList<String> productID = new ArrayList<String>();
		ArrayList<Category> productDetails = new ArrayList<Category>();
		/*
		 * Map<String, String> descTemp; descTemp = new HashMap<String,
		 * String>();
		 */

		try {
			connectionProductID = DB.getConnection();
			System.out.println("++++++++++++++++++++++++++\n" + fetchProductID
					+ "\n+++++++++++++++++++++++++++++++");
			resultSetProductID = DB.readFromDB(fetchProductID,
					connectionProductID);
			productDetails.clear();

			while (resultSetProductID.next()) {

				Category prodInfo = new Category();
				prodInfo.setProductID(resultSetProductID.getString("entity"));
				prodInfo.setNumberOfAttributes(resultSetProductID
						.getInt("numberofattributes"));
				prodInfo.setImage1(resultSetProductID.getString("image1"));
				/*
				 * prodInfo.setImage2(resultSetProductID.getBlob("image2"));
				 * prodInfo.setImage3(resultSetProductID.getBlob("image3"));
				 * prodInfo.setImage4(resultSetProductID.getBlob("image4"));
				 */
				String query = "select val from producteav where entity = '"
						+ resultSetProductID.getString("entity")
						+ "' and attr = 'startdate'";
				ResultSet rs = DB.readFromDB(query, connectionProductID);
				if(rs.next()) startDate = rs.getString(1);
				
				query = "select val from producteav where entity = '"
						+ resultSetProductID.getString("entity")
						+ "' and attr = 'enddate'";
				rs = DB.readFromDB(query, connectionProductID);
				if(rs.next()) endDate = rs.getString(1);
				Date start = new SimpleDateFormat("dd/MM/yyyy")
						.parse(startDate);
				Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
				Date curDate = Calendar.getInstance().getTime();

				if (start.before(curDate) && end.after(curDate)) {
					productDetails.add(prodInfo);
					System.out.println("Added product "
							+ resultSetProductID.getString("entity")
							+ " to productDetails");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		try {
			connectionProductDetails = DB.getConnection();
			System.out
					.println("++++++++++++++++++++++++++\n"
							+ fetchProductDetails
							+ "\n+++++++++++++++++++++++++++++++");
			resultSetProductDetails = DB.readFromDB(fetchProductDetails,
					connectionProductDetails);

			System.out.println("size = " + productDetails.size());
			for (int i = 0; i < productDetails.size(); i++) {
				System.out.println("Inside the for-------------");
				int count = 0;
				while (count < productDetails.get(i).getNumberOfAttributes()
						&& resultSetProductDetails.next()) {
					System.out.println("Inside while----------------");
					++count;
					System.out.println("###################### count = "
							+ count);
					System.out
							.println("###################### noofAttributes = "
									+ productDetails.get(i)
											.getNumberOfAttributes()
									+ "################## productID = "
									+ productDetails.get(i).getProductID());

					String prodIDTemp = resultSetProductDetails
							.getString("entity");
					System.out.println("temp ProdID" + prodIDTemp);

					if (prodIDTemp.equalsIgnoreCase(productDetails.get(i)
							.getProductID())) {
						System.out.println("Outter if");
						String attrTemp = resultSetProductDetails
								.getString("attr");

						if (attrTemp.equalsIgnoreCase("Name")) {
							System.out.println("if for name");
							productDetails.get(i).setName(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("price")) {
							System.out.println("if for price");
							productDetails.get(i).setPrice(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("quantity")) {
							System.out.println("if for quantity");
							productDetails.get(i).setQuantityAvailable(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("condition")) {
							System.out.println("if for condition");
							productDetails.get(i).setProductCondition(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("brand")) {
							System.out.println("if for brand");
							productDetails.get(i).setBrand(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("sellerID")) {
							System.out.println("if for sellerID");
							productDetails.get(i).setSellerID(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("CategoryID")) {
							System.out.println("if for categoryID");
							productDetails.get(i).setCategoryID(
									resultSetProductDetails.getString("val"));
						} else if (attrTemp.equalsIgnoreCase("duration")) {
							System.out.println("if for duration");
							productDetails.get(i).setDuration(
									resultSetProductDetails.getString("val"));
						} else {
							System.out.println("if for other things");
							String valTemp = resultSetProductDetails
									.getString("val");
							productDetails.get(i).getDescription()
									.put(attrTemp, valTemp);

						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return productDetails;
	}

}

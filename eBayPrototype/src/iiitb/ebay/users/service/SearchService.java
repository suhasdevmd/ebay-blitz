package iiitb.ebay.users.service;


import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.ProductModel;
import iiitb.ebay.utilities.DB;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SearchService {

	ArrayList<String>categoryList = new ArrayList<String>();

	public  ArrayList<String> getCategoryList() {
		String query = "Select name from producthierarchy;"	;		
		ResultSet rs = DB.readFromBmtcDB(query);

		try{		
			while(rs.next()){
				categoryList.add(rs.getString("name"));
			}

			rs.close();

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		//test
		/*for(int i=0;i<categoryList.size();i++){
			System.out.println("categories list " + categoryList.get(i));
	} 
	System.out.println("I AM IN SEARCH SERVICE"); */
		return categoryList;
	}


	public ArrayList<Category> getItemsByCategory(String category,String selectionModifier){

		int NoOfAttrs = 0;
		ArrayList<Category>ProductModellist = new  ArrayList<Category>();

		try{
			String query_getEntityID = "select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
				+"where p.entity = i.productID and entity in "
				+"(SELECT entity "
				+"FROM producteav "
				+"WHERE attr collate utf8_general_ci ='categoryid' and val "
				+"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))"
				+ selectionModifier  
				+ " group by entity" ;

			System.out.println("query_getEntityID  " + query_getEntityID);

			ResultSet rs_getEntityID = DB.readFromBmtcDB(query_getEntityID);
			while(rs_getEntityID.next()){

				Category productMeta = new Category();
				productMeta.setProductID(rs_getEntityID.getString("entity"));
				productMeta.setNumberOfAttributes(rs_getEntityID.getInt("NoOfAttrs"));
				NoOfAttrs = rs_getEntityID.getInt("NoOfAttrs");
				productMeta.setImage1(rs_getEntityID.getString("image1")); // to be uncommented later  
				ProductModellist.add(productMeta);
			}

			//System.out.println("NoOfAttrs  " + NoOfAttrs);

			if(NoOfAttrs==0 && selectionModifier.isEmpty()){
				ProductModellist = getAllItems();
				return ProductModellist;

			}//This is for adv search ; if search returns null because of incorrect price range then we should do a normal search 
			else if(NoOfAttrs==0 && !selectionModifier.isEmpty()){

				selectionModifier = "";

				String query_getProdMeta ="select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
					+"where p.entity = i.productID and entity in "
					+"(SELECT entity "
					+"FROM producteav "
					+"WHERE attr collate utf8_general_ci ='categoryid' and val "
					+"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))"
					+ selectionModifier  
					+ " group by entity" ;


				//System.out.println("query_getProdMeta   = "  + query_getProdMeta );	

				ResultSet rs = DB.readFromBmtcDB(query_getProdMeta);
				while(rs.next()){

					Category productMeta = new Category();
					productMeta.setProductID(rs.getString("entity"));
					productMeta.setNumberOfAttributes(rs.getInt("NoOfAttrs"));
					productMeta.setImage1(rs.getString("image1")); // to be uncommented later  
					ProductModellist.add(productMeta);
				}

				if(NoOfAttrs==0){
					ProductModellist = getAllItems();
					return ProductModellist;
				}

			}//end of else if 

			//-----------------------------------------------------------------------------------------------


			String query_getProductAttrs = "select *  from producteav where entity in"
				+"(SELECT entity "
				+"FROM producteav "
				+"WHERE attr collate utf8_general_ci ='categoryid' and val "
				+"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))"
				+ selectionModifier  
				+"order by entity";


			ResultSet resultSet_getProductAttrs = DB.readFromBmtcDB(query_getProductAttrs);
			//System.out.println("size = "+ProductModellist.size());
			for(int i=0;i<ProductModellist.size();i++){
				int count=0;
				while(count < ProductModellist.get(i).getNumberOfAttributes() && resultSet_getProductAttrs.next() ){
					++count;
					//				System.out.println("###################### count = "+count);
					//				System.out.println("###################### noofAttributes = "+ProductModellist.get(i).getNumberOfAttributes()+"################## productID = "+ProductModellist.get(i).getProductID());

					String prodIDTemp = resultSet_getProductAttrs.getString("entity");
				//	System.out.println("temp ProdID"+prodIDTemp);

					if(prodIDTemp.equalsIgnoreCase(ProductModellist.get(i).getProductID())){
						String attrTemp = resultSet_getProductAttrs.getString("attr");

						if(attrTemp.equalsIgnoreCase("Name")){							
							//System.out.println("if for name");
							ProductModellist.get(i).setName(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("price")){
							//System.out.println("if for price");
							ProductModellist.get(i).setPrice(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("quantity")){
							//System.out.println("if for quantity");
							ProductModellist.get(i).setQuantityAvailable(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("condition")){
							//System.out.println("if for condition");
							ProductModellist.get(i).setProductCondition(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("brand")){
							//System.out.println("if for brand");
							ProductModellist.get(i).setBrand(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("sellerID")){
							//System.out.println("if for sellerID");
							ProductModellist.get(i).setSellerID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("CategoryID")){
							//System.out.println("if for categoryID");
							ProductModellist.get(i).setCategoryID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("duration")){
							//System.out.println("if for duration");
							ProductModellist.get(i).setDuration(resultSet_getProductAttrs.getString("val"));
						}
						else {
							//System.out.println("if for other things");
							String valTemp = resultSet_getProductAttrs.getString("val");
							ProductModellist.get(i).getDescription().put(attrTemp, valTemp);

						}
					}
				}
			}


		}
		catch(Exception ex){
			ex.printStackTrace();
		}


		//test
		/*System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int i = 0; i < ProductModellist.size(); i++) {
			System.out.println(" ProductID = "+ProductModellist.get(i).getProductID());
			System.out.println(" SellerID= "+ProductModellist.get(i).getSellerID());
			System.out.println(" CategoryID = "+ProductModellist.get(i).getCategoryID());
			System.out.println(" Name = "+ProductModellist.get(i).getName());
			System.out.println(" Price = "+ProductModellist.get(i).getPrice());
			System.out.println(" Quantity = "+ProductModellist.get(i).getQuantityAvailable());
			System.out.println(" Condition = "+ProductModellist.get(i).getProductCondition());
			System.out.println(" Brand = "+ProductModellist.get(i).getBrand());
			System.out.println(" Duration = "+ProductModellist.get(i).getDuration());
			//System.out.println(" Image1 = "+productList.get(i).getImage1());
			System.out.println("Description :-");
			System.out.println("\tName: "+ProductModellist.get(i).getDescription());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		}*/


		return ProductModellist;
	}//eof mtd


	public ArrayList<Category> getAllItems() {
		ArrayList<Category>ProductModellist = new  ArrayList<Category>();
		int NoOfAttrs = 0;
		try{
			String query_getEntityID ="select p.entity, count(*) as NoOfAttrs ,img.image1"  
				+" from producteav p, productimage img"
				+" where p.entity = img.productID and entity in"
				+"( select entity"
				+" from producteav p)"					
				+" group by entity";


//			System.out.println("query_getProductAttrs  " + query_getEntityID);


			ResultSet rs_getEntityID = DB.readFromBmtcDB(query_getEntityID);
			while(rs_getEntityID.next()){

				Category productMeta = new Category();
				productMeta.setProductID(rs_getEntityID.getString("entity"));
				productMeta.setNumberOfAttributes(rs_getEntityID.getInt("NoOfAttrs"));
				NoOfAttrs = rs_getEntityID.getInt("NoOfAttrs");
				productMeta.setImage1(rs_getEntityID.getString("image1")); // to be uncommented later  
				ProductModellist.add(productMeta);
			}

//			System.out.println("NoOfAttrs  " + NoOfAttrs);

			//---------------------------------------------------------------------------------------------------------------

			String query_getProductAttrs = "select *  from producteav order by entity"	 ;


			ResultSet resultSet_getProductAttrs = DB.readFromBmtcDB(query_getProductAttrs);
		//	System.out.println("size = "+ProductModellist.size());
			for(int i=0;i<ProductModellist.size();i++){
				int count=0;
				while(count < ProductModellist.get(i).getNumberOfAttributes() && resultSet_getProductAttrs.next() ){
					++count;
					//						System.out.println("###################### count = "+count);
					//						System.out.println("###################### noofAttributes = "+ProductModellist.get(i).getNumberOfAttributes()+"################## productID = "+ProductModellist.get(i).getProductID());

					String prodIDTemp = resultSet_getProductAttrs.getString("entity");
				//	System.out.println("temp ProdID"+prodIDTemp);

					if(prodIDTemp.equalsIgnoreCase(ProductModellist.get(i).getProductID())){
						String attrTemp = resultSet_getProductAttrs.getString("attr");

						if(attrTemp.equalsIgnoreCase("Name")){							
							//System.out.println("if for name");
							ProductModellist.get(i).setName(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("price")){
							//System.out.println("if for price");
							ProductModellist.get(i).setPrice(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("quantity")){
							//System.out.println("if for quantity");
							ProductModellist.get(i).setQuantityAvailable(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("condition")){
							//System.out.println("if for condition");
							ProductModellist.get(i).setProductCondition(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("brand")){
							//System.out.println("if for brand");
							ProductModellist.get(i).setBrand(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("sellerID")){
							//System.out.println("if for sellerID");
							ProductModellist.get(i).setSellerID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("CategoryID")){
							//System.out.println("if for categoryID");
							ProductModellist.get(i).setCategoryID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("duration")){
							//System.out.println("if for duration");
							ProductModellist.get(i).setDuration(resultSet_getProductAttrs.getString("val"));
						}
						else {
							//System.out.println("if for other things");
							String valTemp = resultSet_getProductAttrs.getString("val");
							ProductModellist.get(i).getDescription().put(attrTemp, valTemp);

						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}


		return ProductModellist;
	}


	public ArrayList<Category> getItemsByNamenCategory(String name, String category,String selectionModifier){

		int NoOfAttrs = 0;
		ArrayList<Category>ProductModellist = new  ArrayList<Category>();
		try{


			String query_getEntityID = "select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
				+"where p.entity = i.productID and entity in "
				+"(SELECT entity "
				+"FROM producteav "
				+"WHERE attr collate utf8_general_ci ='categoryid' and val "
				+"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))" 
				+"AND entity in (select entity from producteav where attr collate utf8_general_ci  ='name' and val collate utf8_general_ci  LIKE '%"+name+"%')"	
				+ selectionModifier  
				+ " group by entity";


			//System.out.println("query_getEntityID  " + query_getEntityID);


			//System.out.println("query_getEntityID   = "  + query_getEntityID );
			ResultSet rs_getEntityID = DB.readFromBmtcDB(query_getEntityID);
			while(rs_getEntityID.next()){

				Category productMeta = new Category();
				productMeta.setProductID(rs_getEntityID.getString("entity"));
				productMeta.setNumberOfAttributes(rs_getEntityID.getInt("NoOfAttrs"));
				NoOfAttrs = rs_getEntityID.getInt("NoOfAttrs");
				productMeta.setImage1(rs_getEntityID.getString("image1")); // to be uncommented later  
				ProductModellist.add(productMeta);
			}

			//System.out.println("NoOfAttrs  " + NoOfAttrs);


			if(NoOfAttrs==0 && selectionModifier.isEmpty()){
				ProductModellist = getItemsByName(name, selectionModifier);
				return ProductModellist;

			}//This is for adv search ; if search returns null because of incorrect price range then we should do a normal search 
			else if(NoOfAttrs==0 && !selectionModifier.isEmpty()){

				selectionModifier = "";

				String query_getProdMeta ="select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
					+"where p.entity = i.productID and entity in "
					+"(SELECT entity "
					+"FROM producteav "
					+"WHERE attr collate utf8_general_ci ='categoryid' and val "
					+"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))" 
					+"AND entity in (select entity from producteav where attr collate utf8_general_ci  ='name' and val collate utf8_general_ci  LIKE '%"+name+"%')"	
					+ selectionModifier  
					+ " group by entity";

				//System.out.println("query_getProdMeta   = "  + query_getProdMeta );	

				ResultSet rs = DB.readFromBmtcDB(query_getProdMeta);
				while(rs.next()){

					Category productMeta = new Category();
					productMeta.setProductID(rs.getString("entity"));
					productMeta.setNumberOfAttributes(rs.getInt("NoOfAttrs"));
					productMeta.setImage1(rs.getString("image1")); // to be uncommented later  
					ProductModellist.add(productMeta);
				}

				if(NoOfAttrs==0){
					ProductModellist = getItemsByName(name, selectionModifier);
					return ProductModellist;
				}

			}//end of else if 




			//---------------------------------------------------------------------------------------------------------------

			String query_getProductAttrs = "select *  from producteav where entity in"
				+"(SELECT entity "
				+	"FROM producteav "
				+	"WHERE attr collate utf8_general_ci ='categoryid' and val "
				+	"LIKE CONCAT((select phKey from producthierarchy where name collate utf8_general_ci LIKE '"+category+"'),'%'))" 
				+   "AND entity in (select entity from producteav where attr collate utf8_general_ci  ='name' and val collate utf8_general_ci  LIKE '%"+name+"%')"	
				+ selectionModifier  
				+ " order by entity" ;

			ResultSet resultSet_getProductAttrs = DB.readFromBmtcDB(query_getProductAttrs);
			//System.out.println("size = "+ProductModellist.size());
			for(int i=0;i<ProductModellist.size();i++){
				int count=0;
				while(count < ProductModellist.get(i).getNumberOfAttributes() && resultSet_getProductAttrs.next() ){
					++count;
					//					System.out.println("###################### count = "+count);
					//					System.out.println("###################### noofAttributes = "+ProductModellist.get(i).getNumberOfAttributes()+"################## productID = "+ProductModellist.get(i).getProductID());

					String prodIDTemp = resultSet_getProductAttrs.getString("entity");
					//System.out.println("temp ProdID"+prodIDTemp);

					if(prodIDTemp.equalsIgnoreCase(ProductModellist.get(i).getProductID())){
						String attrTemp = resultSet_getProductAttrs.getString("attr");

						if(attrTemp.equalsIgnoreCase("Name")){							
							//System.out.println("if for name");
							ProductModellist.get(i).setName(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("price")){
							//System.out.println("if for price");
							ProductModellist.get(i).setPrice(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("quantity")){
							//System.out.println("if for quantity");
							ProductModellist.get(i).setQuantityAvailable(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("condition")){
							//System.out.println("if for condition");
							ProductModellist.get(i).setProductCondition(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("brand")){
							//System.out.println("if for brand");
							ProductModellist.get(i).setBrand(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("sellerID")){
							//System.out.println("if for sellerID");
							ProductModellist.get(i).setSellerID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("CategoryID")){
							//System.out.println("if for categoryID");
							ProductModellist.get(i).setCategoryID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("duration")){
							//System.out.println("if for duration");
							ProductModellist.get(i).setDuration(resultSet_getProductAttrs.getString("val"));
						}
						else {
							//System.out.println("if for other things");
							String valTemp = resultSet_getProductAttrs.getString("val");
							ProductModellist.get(i).getDescription().put(attrTemp, valTemp);

						}
					}
				}
			}


		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		return ProductModellist;
	}//eof mtd


	public ArrayList<Category> getItemsByName(String Name,String selectionModifier){

		int NoOfAttrs = 0;
		ArrayList<Category>ProductModellist = new  ArrayList<Category>();

		try{
			String query_getEntityID = "select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
				+"where p.entity = i.productID and entity in " 
				+"( select entity from producteav p where p.attr collate utf8_general_ci ='name' and p.val collate utf8_general_ci LIKE '%"+Name+"%' ) " 
				+selectionModifier
				+" group by entity";

			//System.out.println("query_getEntityID   = "  + query_getEntityID );
			ResultSet rs_getEntityID = DB.readFromBmtcDB(query_getEntityID);
			while(rs_getEntityID.next()){

				Category productMeta = new Category();
				productMeta.setProductID(rs_getEntityID.getString("entity"));
				productMeta.setNumberOfAttributes(rs_getEntityID.getInt("NoOfAttrs"));
				NoOfAttrs = rs_getEntityID.getInt("NoOfAttrs");
				productMeta.setImage1(rs_getEntityID.getString("image1")); // to be uncommented later  
				ProductModellist.add(productMeta);
			}

			//System.out.println("NoOfAttrs  " + NoOfAttrs);


			if(NoOfAttrs==0 && selectionModifier.isEmpty()){
				ProductModellist = getItemsByCategory(Name, selectionModifier);
				return ProductModellist;

			}//This is for adv search ; if search returns null because of incorrect price range then we should do a normal search 
			else if(NoOfAttrs==0 && !selectionModifier.isEmpty()){

				selectionModifier = "";

				String query_getProdMeta = "select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
					+"where p.entity = i.productID and entity in " 
					+"( select entity from producteav p where p.attr collate utf8_general_ci ='name' and p.val collate utf8_general_ci LIKE '%"+Name+"%' ) " 
					+selectionModifier
					+" group by entity";

				System.out.println("query_getProdMeta   = "  + query_getProdMeta );	

				ResultSet rs = DB.readFromBmtcDB(query_getProdMeta);
				while(rs.next()){

					Category productMeta = new Category();
					productMeta.setProductID(rs.getString("entity"));
					productMeta.setNumberOfAttributes(rs.getInt("NoOfAttrs"));
					productMeta.setImage1(rs.getString("image1")); // to be uncommented later  
					ProductModellist.add(productMeta);
				}

				if(NoOfAttrs==0){
					ProductModellist = getItemsByCategory(Name, selectionModifier);
					return ProductModellist;
				}

			}//end of else if 




			//---------------------------------------------------------------------------------------------------------------

			String query_getProductAttrs = "Select * from producteav where entity in " 
				+"(select entity from producteav where attr collate utf8_general_ci = 'name' and val collate utf8_general_ci  LIKE '%"+Name+"%')"
				+ selectionModifier +"order by entity";

			ResultSet resultSet_getProductAttrs = DB.readFromBmtcDB(query_getProductAttrs);
			//System.out.println("size = "+ProductModellist.size());
			for(int i=0;i<ProductModellist.size();i++){
				int count=0;
				while(count < ProductModellist.get(i).getNumberOfAttributes() && resultSet_getProductAttrs.next() ){
					++count;
					//					System.out.println("###################### count = "+count);
					//					System.out.println("###################### noofAttributes = "+ProductModellist.get(i).getNumberOfAttributes()+"################## productID = "+ProductModellist.get(i).getProductID());

					String prodIDTemp = resultSet_getProductAttrs.getString("entity");
					//System.out.println("temp ProdID"+prodIDTemp);

					if(prodIDTemp.equalsIgnoreCase(ProductModellist.get(i).getProductID())){
						String attrTemp = resultSet_getProductAttrs.getString("attr");

						if(attrTemp.equalsIgnoreCase("Name")){							
							//System.out.println("if for name");
							ProductModellist.get(i).setName(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("price")){
							//System.out.println("if for price");
							ProductModellist.get(i).setPrice(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("quantity")){
							//System.out.println("if for quantity");
							ProductModellist.get(i).setQuantityAvailable(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("condition")){
							//System.out.println("if for condition");
							ProductModellist.get(i).setProductCondition(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("brand")){
							//System.out.println("if for brand");
							ProductModellist.get(i).setBrand(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("sellerID")){
							//System.out.println("if for sellerID");
							ProductModellist.get(i).setSellerID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("CategoryID")){
							//System.out.println("if for categoryID");
							ProductModellist.get(i).setCategoryID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("duration")){
							//System.out.println("if for duration");
							ProductModellist.get(i).setDuration(resultSet_getProductAttrs.getString("val"));
						}
						else {
							//System.out.println("if for other things");
							String valTemp = resultSet_getProductAttrs.getString("val");
							ProductModellist.get(i).getDescription().put(attrTemp, valTemp);

						}
					}
				}
			}


		}
		catch(Exception ex){
			ex.printStackTrace();
		}




		//test
		/*	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int i = 0; i < ProductModellist.size(); i++) {
			System.out.println(" ProductID = "+ProductModellist.get(i).getProductID());
			System.out.println(" SellerID= "+ProductModellist.get(i).getSellerID());
			System.out.println(" CategoryID = "+ProductModellist.get(i).getCategoryID());
			System.out.println(" Name = "+ProductModellist.get(i).getName());
			System.out.println(" Price = "+ProductModellist.get(i).getPrice());
			System.out.println(" Quantity = "+ProductModellist.get(i).getQuantity());
			System.out.println(" Condition = "+ProductModellist.get(i).getProductCondition());
			System.out.println(" Brand = "+ProductModellist.get(i).getBrand());
			System.out.println(" Duration = "+ProductModellist.get(i).getDuration());
			/*System.out.println(" Image1 = "+productList.get(i).getImage1());
			System.out.println(" Image2 = "+productList.get(i).getImage2());
			System.out.println(" Image3 = "+productList.get(i).getImage3());
			System.out.println(" Image4 = "+productList.get(i).getImage4());*/
		//System.out.println(" Image = "+productList.get(i).getImg());
		//System.out.println(" outputStream = "+productList.get(i).getOut());
		/*System.out.println("Description :-");
			System.out.println("\tName: "+ProductModellist.get(i).getDescription());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"); 

		}*/

		return ProductModellist;
	}


	public ArrayList<Category> getItemsByPriceOnly(String from, String to,String selectionModifier) {

		ArrayList<Category> ProductModellist = new ArrayList<Category>();
		int NoOfAttrs = 0;
		

		try{
			String query_getEntityID = "select p.entity, count(*) as NoOfAttrs ,i.image1 from producteav p, productimage i " 
				+"where p.entity = i.productID and entity in "
				+"(SELECT entity "
				+"FROM producteav "
				+"WHERE attr collate utf8_general_ci ='price' and "
				+selectionModifier 
				+"group by entity";

			//System.out.println("query_getEntityID  " + query_getEntityID);

			ResultSet rs_getEntityID = DB.readFromBmtcDB(query_getEntityID);
			while(rs_getEntityID.next()){

				Category productMeta = new Category();
				productMeta.setProductID(rs_getEntityID.getString("entity"));
				productMeta.setNumberOfAttributes(rs_getEntityID.getInt("NoOfAttrs"));
				NoOfAttrs = rs_getEntityID.getInt("NoOfAttrs");
				productMeta.setImage1(rs_getEntityID.getString("image1")); 
				ProductModellist.add(productMeta);
			}

			//System.out.println("NoOfAttrs  " + NoOfAttrs);

			if(NoOfAttrs==0){
				ProductModellist = getAllItems();
				return ProductModellist;

			}
			//-----------------------------------------------------------------------------------------------


			String query_getProductAttrs = "select *  from producteav where entity in"
				+"(SELECT entity "
				+"FROM producteav "
				+"WHERE attr collate utf8_general_ci ='price' and "
				+ selectionModifier 
				+"order by entity";

			//System.out.println("query_getProductAttrs  " + query_getProductAttrs);

			ResultSet resultSet_getProductAttrs = DB.readFromBmtcDB(query_getProductAttrs);
			//System.out.println("size = "+ProductModellist.size());
			for(int i=0;i<ProductModellist.size();i++){
				int count=0;
				while(count < ProductModellist.get(i).getNumberOfAttributes() && resultSet_getProductAttrs.next() ){
					++count;
					//				System.out.println("###################### count = "+count);
					//				System.out.println("###################### noofAttributes = "+ProductModellist.get(i).getNumberOfAttributes()+"################## productID = "+ProductModellist.get(i).getProductID());

					String prodIDTemp = resultSet_getProductAttrs.getString("entity");
				//	System.out.println("temp ProdID"+prodIDTemp);

					if(prodIDTemp.equalsIgnoreCase(ProductModellist.get(i).getProductID())){
						String attrTemp = resultSet_getProductAttrs.getString("attr");

						if(attrTemp.equalsIgnoreCase("Name")){							
					//		System.out.println("if for name");
							ProductModellist.get(i).setName(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("price")){
						//	System.out.println("if for price");
							ProductModellist.get(i).setPrice(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("quantity")){
					//		System.out.println("if for quantity");
							ProductModellist.get(i).setQuantityAvailable(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("condition")){
						//	System.out.println("if for condition");
							ProductModellist.get(i).setProductCondition(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("brand")){
						//	System.out.println("if for brand");
							ProductModellist.get(i).setBrand(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("sellerID")){
						//	System.out.println("if for sellerID");
							ProductModellist.get(i).setSellerID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("CategoryID")){
							//System.out.println("if for categoryID");
							ProductModellist.get(i).setCategoryID(resultSet_getProductAttrs.getString("val"));
						}
						else if(attrTemp.equalsIgnoreCase("duration")){
							//System.out.println("if for duration");
							ProductModellist.get(i).setDuration(resultSet_getProductAttrs.getString("val"));
						}
						else {
							//System.out.println("if for other things");
							String valTemp = resultSet_getProductAttrs.getString("val");
							ProductModellist.get(i).getDescription().put(attrTemp, valTemp);

						}
					}
				}
			}


		}
		catch(Exception ex){
			ex.printStackTrace();
		}


		//test
	/*	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int i = 0; i < ProductModellist.size(); i++) {
			System.out.println(" ProductID = "+ProductModellist.get(i).getProductID());
			System.out.println(" SellerID= "+ProductModellist.get(i).getSellerID());
			System.out.println(" CategoryID = "+ProductModellist.get(i).getCategoryID());
			System.out.println(" Name = "+ProductModellist.get(i).getName());
			System.out.println(" Price = "+ProductModellist.get(i).getPrice());
			System.out.println(" Quantity = "+ProductModellist.get(i).getQuantityAvailable());
			System.out.println(" Condition = "+ProductModellist.get(i).getProductCondition());
			System.out.println(" Brand = "+ProductModellist.get(i).getBrand());
			System.out.println(" Duration = "+ProductModellist.get(i).getDuration());
			//System.out.println(" Image1 = "+productList.get(i).getImage1());
			System.out.println("Description :-");
			System.out.println("\tName: "+ProductModellist.get(i).getDescription());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		}*/


		return ProductModellist;
	}//eof mtd



}

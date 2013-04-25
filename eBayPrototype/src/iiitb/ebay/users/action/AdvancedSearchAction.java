package iiitb.ebay.users.action;

import java.util.ArrayList;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.ProductModel;
import iiitb.ebay.users.service.SearchService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdvancedSearchAction extends ActionSupport {
	
	private String mysearch ="";//name of txtfiled gets the txtbox value
	private String category ="";//gets the value fron the dropdown from jsp
	private String from = "";
	private String to = "";
	private String selectionModifier = "" ; 
	private ArrayList<Category> productList;
	
	public String getMysearch() {
		return mysearch;
	}

	public void setMysearch(String mysearch) {
		this.mysearch = mysearch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public ArrayList<Category> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Category> arrayList) {
		this.productList = arrayList;
	}

	
public String execute(){
		
		System.out.println("******In execute of AdvSearch **********");
		SearchService searchService = new SearchService();
		//System.out.println("mysearch " + mysearch);
		//System.out.println("category " + category);
		//System.out.println("from " + from);
		//System.out.println("to "+to);
		
		if(!from.isEmpty() && !to.isEmpty()){
		
			if(Float.parseFloat(to) < Float.parseFloat(from)){
				to = "";              //if 'to' is less than 'from' set 'to' to empty
				//System.out.println("to is less than from to " + to + to.isEmpty());
			}
		}
	//search only by price range 		
if(mysearch.isEmpty() && category.isEmpty())		
{
	
	if(!from.isEmpty() && to.isEmpty()){
		selectionModifier = "CAST(val as DECIMAL) >"+from+" )" ;
							
		setProductList(searchService.getItemsByPriceOnly(from,to,selectionModifier));
		return "success";
	}
	else if(from.isEmpty() && !to.isEmpty()){
		selectionModifier =" CAST(val as DECIMAL) BETWEEN 0 AND "+to +" ) ";
							
		setProductList(searchService.getItemsByPriceOnly(from,to,selectionModifier));
		return "success";
	}
	else{
		selectionModifier = "CAST(val as DECIMAL) BETWEEN "+from +" and " + to +") ";
							
		setProductList(searchService.getItemsByPriceOnly(from,to,selectionModifier));
		return "success";
	}
}
		
if(from.isEmpty() && to.isEmpty()){
		
	//System.out.println("******from.isEmpty() && to.isEmpty()**********");
		//search by name only
		if(category.isEmpty() && !(mysearch.isEmpty()) ){
			System.out.println("******AdvSearch by Name only**********");
			setProductList(searchService.getItemsByName(mysearch,selectionModifier));
			return "success";
			
		}
		else if(category.isEmpty() && mysearch.isEmpty()){
			//System.out.println("******Search by All categories***********");
			setProductList(searchService.getAllItems());
			return "success"; 

		}//search by category only
		else if(!category.isEmpty()  && mysearch.isEmpty()){
			//System.out.println("******AdvSearch by Category***********");
			setProductList(searchService.getItemsByCategory(category,selectionModifier));	
			return "success";
		}
		else {
			//System.out.println("******AdvSearch by Both Category and Name ***********");
			setProductList(searchService.getItemsByNamenCategory(mysearch,category,selectionModifier));	
			return "success";
		}
			
}
else if(from.isEmpty() && !to.isEmpty()){
	System.out.println("from.isEmpty() && !to.isEmpty()");
	//search by name only
			if(category.isEmpty() && !(mysearch.isEmpty()) ){
				//System.out.println("******AdvSearch by Name only**********");
				selectionModifier = "AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) BETWEEN 0 AND "+to +" )";
				setProductList(searchService.getItemsByName(mysearch,selectionModifier));
				return "success";
				
			}
			else if(category.isEmpty() && mysearch.isEmpty()){
				//System.out.println("******Search by All categories***********");
				setProductList(searchService.getAllItems());
				return "success"; 

			}//search by category only
			else if(!category.isEmpty()  && mysearch.isEmpty()){
				//System.out.println("******AdvSearch by Category***********");
				selectionModifier ="AND entity in (select entity from producteav where attr collate utf8_general_ci ='Price' and CAST(val as DECIMAL) BETWEEN 0 AND "+to +" )";
				setProductList(searchService.getItemsByCategory(category,selectionModifier));	
				return "success";
			}
			else {
				//System.out.println("******AdvSearch by Both Category and Name ***********");
				selectionModifier ="AND entity in (select entity from producteav where attr collate utf8_general_ci ='Price' and CAST(val as DECIMAL) BETWEEN 0 AND "+to +" )";
				setProductList(searchService.getItemsByNamenCategory(mysearch,category,selectionModifier));	
				return "success";
			}
	
}
else if(!from.isEmpty() && to.isEmpty()){

	System.out.println("!from.isEmpty() && to.isEmpty()");
	//search by name only
	if(category.isEmpty() && !(mysearch.isEmpty()) ){
		//System.out.println("******AdvSearch by Name only**********");
		selectionModifier = "AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) >"+from+" )";
		setProductList(searchService.getItemsByName(mysearch,selectionModifier));
		return "success";
		
	}
	else if(category.isEmpty() && mysearch.isEmpty()){
		//System.out.println("******Search by All categories***********");
		setProductList(searchService.getAllItems());
		return "success"; 

	}//search by category only
	else if(!category.isEmpty()  && mysearch.isEmpty()){
		//System.out.println("******AdvSearch by Category***********");
		selectionModifier = "AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) >"+from+" )";
		setProductList(searchService.getItemsByCategory(category,selectionModifier));	
		return "success";
	}
	else {
		//System.out.println("******AdvSearch by Both Category and Name ***********");
		selectionModifier = "AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) >"+from+" )";
		setProductList(searchService.getItemsByNamenCategory(mysearch,category,selectionModifier));	
		return "success";
	}

}
else{ //both from and to provided
	//System.out.println("!from.isEmpty() && !to.isEmpty()");
	
	//search by name only
	if(category.isEmpty() && !(mysearch.isEmpty()) ){
		//System.out.println("******AdvSearch by Name only**********");
		selectionModifier = "AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) BETWEEN "+from+" AND "+to +" )";
		setProductList(searchService.getItemsByName(mysearch,selectionModifier));
		return "success";
		
	}
	else if(category.isEmpty() && mysearch.isEmpty()){
		//System.out.println("******Search by All categories***********");
		setProductList(searchService.getAllItems());
		return "success"; 

	}//search by category only
	else if(!category.isEmpty()  && mysearch.isEmpty()){
		//System.out.println("******AdvSearch by Category***********");
		selectionModifier ="AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) BETWEEN "+from+" AND "+to +" )";
		setProductList(searchService.getItemsByCategory(category,selectionModifier));	
		return "success";
	}
	else {
		//System.out.println("******AdvSearch by Both Category and Name ***********");
		selectionModifier ="AND entity in (select entity from producteav where attr collate utf8_general_ci ='price' and CAST(val as DECIMAL) BETWEEN "+from+" AND "+to +" )";
		setProductList(searchService.getItemsByNamenCategory(mysearch,category,selectionModifier));	
		return "success";
	}
	
}

		
}

	
}

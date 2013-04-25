package iiitb.ebay.users.action;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.ProductModel;
import iiitb.ebay.users.service.SearchService;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAction extends ActionSupport {
	
	
	private String mysearch ="";//name of txtfiled gets the txtbox value
	private String category ="";//gets the value fron the dropdown from jsp
	private String mychoice = "";
	private String selectionModifier = ""; //used for advanced search 
	
	private ArrayList<Category> productList;
	
	public String getMysearch() {
		return mysearch.trim();
	}



	public void setMysearch(String mysearch) {
		
		this.mysearch = mysearch.trim();
	}



	public String getCategory() {
		return category.trim();
	}



	public ArrayList<Category> getProductList() {
		//System.out.println("In getProductList");
	
		return productList;
	}



	public void setProductList(ArrayList<Category> arrayList) {
		//System.out.println("In setProductList");
		this.productList = arrayList;
	}



	public void setCategory(String category) {
		this.category = category.trim();
	}
	public String getMychoice() {
		return mychoice.trim();
	}



	public void setMychoice(String mychoice) {
		this.mychoice = mychoice.trim();
	}


		
		
	public String execute(){
		System.out.println("*********In execute of SearchAction***********");
		
		
		if(mychoice.equals("advancedSearch")){
			//System.out.println("Inside advancedSearch");
			return "advanced-search";
		}
		
		SearchService searchService = new SearchService();
		//search by name only
		if(category.equals("-1") && !(mysearch.isEmpty())){
			//System.out.println("******Search by Name only**********");
			setProductList(searchService.getItemsByName(mysearch,selectionModifier));
			return "success";
			
		}
		else if(category.equals("-1") && mysearch.isEmpty()){
			//System.out.println("******Search by All categories***********");
			setProductList(searchService.getAllItems());
			addActionMessage("Displaying All Categories.");
			return "success"; 
		}//search by category only
		else if(!category.equals("-1") && !category.equals(" ") && mysearch.isEmpty()){
			//System.out.println("******Search by Category***********");
			setProductList(searchService.getItemsByCategory(category,selectionModifier));	
			return "success";
		}
		else 
			//System.out.println("******Search by Both Category and Name ***********");
			setProductList(searchService.getItemsByNamenCategory(mysearch,category,selectionModifier));	
			return "success";
		}
		
		
		
	}




	
	


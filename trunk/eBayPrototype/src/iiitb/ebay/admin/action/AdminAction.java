package iiitb.ebay.admin.action;

import java.util.ArrayList;

import iiitb.ebay.admin.model.CategoryDB;
import iiitb.ebay.admin.service.ManageCategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{

	private String value;
	ArrayList<CategoryDB> categories=new ArrayList<CategoryDB>();
	ArrayList<String> categoryList=new ArrayList<String>();
	
	
	

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<CategoryDB> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<CategoryDB> categories) {
		this.categories = categories;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}




	public String execute(){
		
		if(value.equals("admin")){
			
			
			return "adminhome";
		}
		
		if(value.equals("managecat")){
			
			
			// retrieve all the categories from the database
			
			
			
			ManageCategoryService mcs=new ManageCategoryService();
			categories=mcs.getAllCategories();
			
			
			
			for(int i=0;i<categories.size();i++){
				categoryList.add(categories.get(i).getName());
				
				
			}
		
			
			
			return "managecat";
			
		}
		
		
		
		return "success";
	}
}

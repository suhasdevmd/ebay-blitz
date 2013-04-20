package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.CategoryDB;
import iiitb.ebay.admin.service.ManageCategoryService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ManageCategoryAction extends ActionSupport {
	
	
	private String addCategory;
	private String subCategory;
	private String category;
	private String phKey;

	ManageCategoryService mcs=new ManageCategoryService();
	ArrayList<CategoryDB> categories=new ArrayList<CategoryDB>();
	ArrayList<String> categoryList=new ArrayList<String>();
	
	


	public ArrayList<CategoryDB> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<CategoryDB> categories) {
		this.categories = categories;
	}

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	public String getPhKey() {
		return phKey;
	}

	public void setPhKey(String phKey) {
		this.phKey = phKey;
	}

	public String getAddCategory() {
		return addCategory;
	}

	public void setAddCategory(String addCategory) {
		this.addCategory = addCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public String execute(){

		//




		return SUCCESS;
	}



	public String deleteCategory(){

		
		
		
		System.out.println("phkey = "+phKey);
		
		
		int stat=mcs.deleteCategory(phKey);
		categories=mcs.getAllCategories();
		
		
		
		for(int i=0;i<categories.size();i++){
			categoryList.add(categories.get(i).getName());
			
			
		}


		if(stat>0)
			return SUCCESS;
		else
			return ERROR;


	}



	public String addCategory(){


		System.out.println(" catgry name : "+addCategory);

		int addStatus=mcs.addCategory(addCategory);
		
		
		
		categories=mcs.getAllCategories();
		
		
		
		for(int i=0;i<categories.size();i++){
			categoryList.add(categories.get(i).getName());
			
			
		}


		if(addStatus>0)
			return SUCCESS;
		else
			return ERROR;

	}



	public String addSubCategory(){



		System.out.println(" Category :"+category);
		System.out.println(" Sub Category : "+subCategory);

		int stat=mcs.addSubCategory(subCategory, category);


		
		categories=mcs.getAllCategories();
		
		
		
		for(int i=0;i<categories.size();i++){
			categoryList.add(categories.get(i).getName());
			
			
		}
		
		
		
		if(stat>0)
			return SUCCESS;
		else {
			addActionError("Unable to add Sub Category.");
			
			return ERROR;
		}
			
	}

}

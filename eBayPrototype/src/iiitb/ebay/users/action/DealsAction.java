package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.service.CategoryService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DealsAction extends ActionSupport{
	
	private ArrayList<Category> productTypeList1;
	private ArrayList<Category> productTypeList2;
	private ArrayList<Category> productTypeList3;
	private String categoryID1;
	private String categoryID2;
	private String categoryID3;
	Map<String,Object> session;
	
	public String execute(){
		session = ActionContext.getContext().getSession();
		/*if( null != session.get("login") && (Boolean)session.get("login"))*/{
			categoryID1 = "1";
			categoryID2 = "2";
			categoryID3 = "3";
			productTypeList1 =  CategoryService.fetchDealsProduct("1");
			productTypeList2 =  CategoryService.fetchDealsProduct("3");
			productTypeList3 =  CategoryService.fetchDealsProduct("2");
			return "success";
		}
		/*else{
			return "error";
		}*/
	}
	
	
	public ArrayList<Category> getProductTypeList1() {
		return productTypeList1;
	}
	public void setProductTypeList1(ArrayList<Category> productTypeList1) {
		this.productTypeList1 = productTypeList1;
	}
	public ArrayList<Category> getProductTypeList2() {
		return productTypeList2;
	}
	public void setProductTypeList2(ArrayList<Category> productTypeList2) {
		this.productTypeList2 = productTypeList2;
	}
	public ArrayList<Category> getProductTypeList3() {
		return productTypeList3;
	}
	public void setProductTypeList3(ArrayList<Category> productTypeList3) {
		this.productTypeList3 = productTypeList3;
	}


	public String getCategoryID1() {
		return categoryID1;
	}


	public void setCategoryID1(String categoryID1) {
		this.categoryID1 = categoryID1;
	}


	public String getCategoryID2() {
		return categoryID2;
	}


	public void setCategoryID2(String categoryID2) {
		this.categoryID2 = categoryID2;
	}


	public String getCategoryID3() {
		return categoryID3;
	}


	public void setCategoryID3(String categoryID3) {
		this.categoryID3 = categoryID3;
	}

}

package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.service.CategoryService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	
	private String CategoryID;
	ArrayList<Category> productDetails = new ArrayList<Category>();

	public String getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}

	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}

	public String execute() {
		productDetails = CategoryService.fetchProduct(CategoryID);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int i = 0; i < productDetails.size(); i++) {
			System.out.println(" ProductID = "+productDetails.get(i).getProductID());
			System.out.println(" SellerID= "+productDetails.get(i).getSellerID());
			System.out.println(" CategoryID = "+productDetails.get(i).getCategoryID());
			System.out.println(" Name = "+productDetails.get(i).getName());
			System.out.println(" Price = "+productDetails.get(i).getPrice());
			//System.out.println(" Quantity = "+productDetails.get(i).getQuantity());
			System.out.println(" Quantity = "+productDetails.get(i).getQuantityAvailable());
			System.out.println(" Condition = "+productDetails.get(i).getProductCondition());
			System.out.println(" Brand = "+productDetails.get(i).getBrand());
			System.out.println(" Duration = "+productDetails.get(i).getDuration());
			/*System.out.println(" Image1 = "+productDetails.get(i).getImage1());
			System.out.println(" Image2 = "+productDetails.get(i).getImage2());
			System.out.println(" Image3 = "+productDetails.get(i).getImage3());
			System.out.println(" Image4 = "+productDetails.get(i).getImage4());*/
			//System.out.println(" Image = "+productDetails.get(i).getImg());
			//System.out.println(" outputStream = "+productDetails.get(i).getOut());
			System.out.println("Description :-");
			System.out.println("\tName: "+productDetails.get(i).getDescription());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		
		return "show-list";
		
	}
	
}

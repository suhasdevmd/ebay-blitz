package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ProductService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class GiveFeedbackAction {

	private static final long serialVersionUID = 1L;
    private String productID;   
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}

	private ArrayList<Category> productDetails = new ArrayList<Category>();
	
	public String execute() {
		Map<String, Object> session = (Map<String, Object>) ActionContext
				.getContext().getSession();
		if (null != session.get("login") && (Boolean) session.get("login")) {
			UserDetails ud = (UserDetails) session.get("userdetails");
			productDetails = ProductService.fetchSingleProductDetails(productID);
			return "success";
		} else {
			return "error";
		}
	}

}

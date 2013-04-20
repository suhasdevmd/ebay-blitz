package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ProductService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SellerAction extends ActionSupport {
	Map<String, Object> session;
	private ArrayList<Category> productDetails;

	public String passOn() {
		return "success";
	}

	public String showProducts() {
		session = ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails) session.get("userdetails");
		ArrayList<Integer> productIDList;

		if (null != session.get("login") && (Boolean) session.get("login")) {
			productIDList = ProductService.getproductIDs(ud.getUserID());
			productDetails = new ArrayList<Category>();
			for (Integer i : productIDList) {
				productDetails.add(ProductService.fetchSingleProductDetails(
						i.toString()).get(0));
			}
			return "success";
		} else {
			return "no-login";
		}
	}
	
	

	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}

}

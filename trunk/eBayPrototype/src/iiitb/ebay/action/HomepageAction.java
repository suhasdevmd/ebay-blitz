package iiitb.ebay.action;

import iiitb.ebay.model.Menu;
import iiitb.ebay.model.ProductData;
import iiitb.ebay.service.FetchHomepageDataService;
import iiitb.ebay.service.MenuService;
import iiitb.ebay.users.service.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomepageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Menu> homepageMenu;
	private List<String>categoryList = new ArrayList<String>();
	private List<ProductData>productData = new ArrayList<ProductData>();

	Map<String,Object> session;
	public String execute(){
		
		/* The homepge menu */
		this.setHomepageMenu(MenuService.fetchMenu());
		session = ActionContext.getContext().getSession();
		/* The search category list */
		SearchService searchService = new SearchService();
		setCategoryList(searchService.getCategoryList());
		session.put("categoryList", this.getCategoryList());
		session.put("homepageMenu", this.getHomepageMenu());
		
		/* Fetches data of the first 4 products
		 * from the database to populate the
		 * from our dealers section of the homepage
		 */
		productData = FetchHomepageDataService.getFromOurSellers();
		
		
		session.put("productData", productData);
		
		
		return "success";
	}
	
	

	public ArrayList<Menu> getHomepageMenu() {
		return homepageMenu;
	}

	public void setHomepageMenu(ArrayList<Menu> homepageMenu) {
		this.homepageMenu = homepageMenu;
	}



	public List<String> getCategoryList() {
		return categoryList;
	}



	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<ProductData> getProductData() {
		return productData;
	}



	public void setProductData(List<ProductData> productData) {
		this.productData = productData;
	}
}

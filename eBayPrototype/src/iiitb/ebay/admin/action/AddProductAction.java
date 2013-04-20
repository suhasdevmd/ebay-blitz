package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.CategoryHierarchy;
import iiitb.ebay.admin.service.CategoryFetcherService;
import iiitb.ebay.users.model.UserDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private ArrayList<CategoryHierarchy> productList;
	private ArrayList<String> productNames;
	private String productName;
	private String productPrice;
	private String productQty;
	private String productBrand;

	private String categoryId;
	private String category;
	/*
	 * for condition 1 : Good 2 : Average 3 : Poor
	 */
	private int conditionID;
	private String condition;
	
	
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private HttpServletRequest servletRequest;
	
	
	
	
	
	
	

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	// String of attributes and values
	private String attrVals;
	
	Map<String,Object>session;

	public String execute() {
		session = ActionContext.getContext().getSession();
		if(null != session.get("login") && (Boolean)session.get("login")){
		setProductList(CategoryFetcherService.fetch());
		productNames = new ArrayList<String>();
		for (int i = 0; i < productList.size(); i++)
			productNames.add(productList.get(i).getName());

		return "success";
		}
		else{
			return "login";
		}
	}

	public String addProductToDB() {
		
		
		System.out.println(" ???????????????? "+userImageFileName);
		
		
		setProductList(CategoryFetcherService.fetch());
		session = ActionContext.getContext().getSession();
		for (int i = 0; i < productList.size(); i++) {
			if (category.equals(productList.get(i).getName())) {
				categoryId = productList.get(i).getPhKey();
				break;
			}
		}

		if (conditionID == 1)
			condition = "New";
		else if (conditionID == 2)
			condition = "Used";
		/*else
			condition = "avg";*/

		boolean additional;
		if (attrVals.trim().equals(":"))
			additional = false;
		else
			additional = true;

		String[] av = attrVals.split("\n");
		UserDetails ud = (UserDetails)session.get("userdetails");
		if (CategoryFetcherService.insertToEav(userImageFileName,categoryId, productName,
				productPrice, productQty, productBrand, condition, av,
				additional,ud.getUserID()).equalsIgnoreCase("success")) {
			addActionMessage("Product Added Successfully");
			System.out.println("Success");
			
			productNames = new ArrayList<String>();
			for (int i = 0; i < productList.size(); i++)
				productNames.add(productList.get(i).getName());

			return "success";
		} else {
			addActionError(getText("Could not add product"));
			return "error";
		}
	}

	public ArrayList<CategoryHierarchy> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<CategoryHierarchy> productList) {
		this.productList = productList;
	}

	public ArrayList<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(ArrayList<String> productNames) {
		this.productNames = productNames;
	}

	public String getAttrVals() {
		return attrVals;
	}

	public void setAttrVals(String attrVals) {
		this.attrVals = attrVals;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQty() {
		return productQty;
	}

	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getConditionID() {
		return conditionID;
	}

	public void setConditionID(int conditionID) {
		this.conditionID = conditionID;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
}

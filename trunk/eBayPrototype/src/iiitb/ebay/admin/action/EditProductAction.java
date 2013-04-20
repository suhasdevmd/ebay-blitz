package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.CategoryHierarchy;
import iiitb.ebay.admin.service.CategoryFetcherService;
import iiitb.ebay.admin.service.EditProductService;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<CategoryHierarchy> productList;
	private ArrayList<String> productNames;
	private Map<String, String> attrVals;
	private int productID;

	private String productName, productBrand, productQty, productPrice, productDiscount;
	private int productCondition, extraFields;

	private String[] attrs, vals;
	private String av = "";

	private String categoryId;
	private String category;

	public String execute() {
		System.out.println("EditProductAction productID "+this.getProductID());
		Map<String, Object> session;
		session = ActionContext.getContext().getSession();
		if (null == session.get("login") || !(Boolean) session.get("login"))
			return "login";

		setProductList(CategoryFetcherService.fetch());
		productNames = new ArrayList<String>();
		for (int i = 0; i < productList.size(); i++)
			productNames.add(productList.get(i).getName());

		// pass the appropriate productID as the parameter
		attrVals = EditProductService.getDetails(this.getProductID());

		productName = attrVals.get("name");
		productPrice = attrVals.get("price");
		productBrand = attrVals.get("brand");
		productQty = attrVals.get("quantity");
		productDiscount = attrVals.get("discount");

		if (attrVals.get("condition").equals("New"))
			productCondition = 1;
		else
			productCondition = 2;

		attrVals.remove("name");
		attrVals.remove("price");
		attrVals.remove("brand");
		attrVals.remove("quantity");
		attrVals.remove("condition");
		attrVals.remove("sellerid");
		attrVals.remove("categoryid");
		attrVals.remove("discount");

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("attrVals", attrVals);

		return "success";
	}

	public String editProductInDB() {
		setProductList(CategoryFetcherService.fetch());
/*
		/* for (int i = 0; i < productList.size(); i++) {
			if (category.equals(productList.get(i).getName())) {
				categoryId = productList.get(i).getPhKey();
				break;
			}
		} */

		boolean additional;
		if (av == null)
			additional = false;
		else
			additional = true;

		String[] additionalAttributes = av.split("\n");

		// productID is again hard coded here
		System.out.println("EditProductAction productID "+this.getProductID());
		EditProductService.modifyEav(this.getProductID(), categoryId, productName,
				productPrice, productQty, productBrand, productDiscount,
				(productCondition == 1) ? "New" : "Used", additionalAttributes,
				additional);
		return "success";
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

	public Map<String, String> getAttrVals() {
		return attrVals;
	}

	public void setAttrVals(Map<String, String> attrVals) {
		this.attrVals = attrVals;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductQty() {
		return productQty;
	}

	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCondition() {
		return productCondition;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setProductCondition(int productCondition) {
		this.productCondition = productCondition;
	}

	public String[] getAttrs() {
		return attrs;
	}

	public void setAttrs(String[] attrs) {
		this.attrs = attrs;
	}

	public String[] getVals() {
		return vals;
	}

	public void setVals(String[] vals) {
		this.vals = vals;
	}

	public int getExtraFields() {
		return extraFields;
	}

	public void setExtraFields(int extraFields) {
		this.extraFields = extraFields;
	}

	public String getAv() {
		return av;
	}

	public void setAv(String av) {
		this.av = av;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}

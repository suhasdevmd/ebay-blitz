package iiitb.ebay.model;

import java.util.Map;

/* This class handles the menu to be displayed on homepage */
public class Menu {
	
	private String baseCategory;
	private String phKey;
	private Map<String,String> Subcategory;
	
	public String getPhKey() {
		return phKey;
	}
	public void setPhKey(String phKey) {
		this.phKey = phKey;
	}
	public String getBaseCategory() {
		return baseCategory;
	}
	public void setBaseCategory(String baseCategory) {
		this.baseCategory = baseCategory;
	}
	public Map<String, String> getSubcategory() {
		return Subcategory;
	}
	public void setSubcategory(Map<String, String> subcategory) {
		Subcategory = subcategory;
	}

}

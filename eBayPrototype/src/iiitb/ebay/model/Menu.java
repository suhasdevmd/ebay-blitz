package iiitb.ebay.model;

import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/* This class handles the menu to be displayed on homepage */
public class Menu {

	private String baseCategory;
	private String phKey;
	private String hasChild;
	private Map<String, String> Subcategory;
	private Map<String, Menu> childCategory = null;

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

	public Map<String, Menu> getChildCategory() {
		return childCategory;
	}

	public void setChildCategory(Map<String, Menu> childCategory) {
		this.childCategory = childCategory;
	}

	public String toString() {
		String returnMessage = "Menu Object :\nCategory : "
				+ this.getBaseCategory() + "\n Key :" + this.getPhKey();
		if (this.getChildCategory() != null) {
			returnMessage += "\n childCategory :"+this.getChildCategory().size()+"\n";
			for (int i = 0; i < this.getChildCategory().size();i++) {
				returnMessage +=  "Category : "
						+ this.getChildCategory().get(i).getBaseCategory() + "\n Key :" + this.getChildCategory().get(i).getPhKey();
				returnMessage += "\n";
			}
		}

		return returnMessage;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

}

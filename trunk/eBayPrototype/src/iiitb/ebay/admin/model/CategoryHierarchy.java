package iiitb.ebay.admin.model;

public class CategoryHierarchy {
	
	private String phKey;
	private String name;
	private String hasChild;
	private String parent;
	private int level;
	
	public String getPhKey() {
		return phKey;
	}
	public void setPhKey(String phKey) {
		this.phKey = phKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}

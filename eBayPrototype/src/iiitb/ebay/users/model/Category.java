package iiitb.ebay.users.model;

import iiitb.ebay.model.SpecialDeals;

import java.util.HashMap;
import java.util.Map;

/* Is being used for Products  */
public class Category {
	
	private int numberOfAttributes;
	private String productID;
	private String sellerID;
	private String categoryID;
	private String name;
	private String sellerName;
	private String price;
	private String quantityAvailable;
	private String quantitySelected;
	private String productCondition;
	private String brand;
	private String duration;
	private Double subTotal;
	private Map<String, String> description = new HashMap<String, String>();
	private String isNew;
	
	private String image1;
	
	/* Special Deal Properties */
	private SpecialDeals deal;
	private boolean spclDeal;
	private String spclDealPrice;
	
	/*
	private Blob image2;
	private Blob image3;
	private Blob image4;
	private Image img; 
	private OutputStream out;*/
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	/*public OutputStream getOut() {
		return out;
	}
	public void setOut(OutputStream out) {
		this.out = out;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}*/	
	/*public Blob getImage1() {
		return image1;
	}
	public void setImage1(Blob image1) {
		this.image1 = image1;
	}
	public Blob getImage2() {
		return image2;
	}
	public void setImage2(Blob image2) {
		this.image2 = image2;
	}
	public Blob getImage3() {
		return image3;
	}
	public void setImage3(Blob image3) {
		this.image3 = image3;
	}
	public Blob getImage4() {
		return image4;
	}
	public void setImage4(Blob image4) {
		this.image4 = image4;
	}*/
	public int getNumberOfAttributes() {
		return numberOfAttributes;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public void setNumberOfAttributes(int numberOfAttributes) {
		this.numberOfAttributes = numberOfAttributes;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Map<String, String> getDescription() {
		return description;
	}
	public void setDescription(Map<String, String> description) {
		this.description = description;
	}
	public String getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(String quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public void setQuantitySelected(String quantitySelected) {
		this.quantitySelected = quantitySelected;
	}
	public SpecialDeals getDeal() {
		return deal;
	}
	public void setDeal(SpecialDeals deal) {
		this.deal = deal;
	}
	public String getQuantitySelected() {
		return quantitySelected;
	}
	public String getIsNew() {
		return isNew;
	}
	
	public boolean isSpclDeal() {
		return spclDeal;
	}
	public void setSpclDeal(boolean spclDeal) {
		this.spclDeal = spclDeal;
	}
	public String getSpclDealPrice() {
		return spclDealPrice;
	}
	public void setSpclDealPrice(String spclDealPrice) {
		this.spclDealPrice = spclDealPrice;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}

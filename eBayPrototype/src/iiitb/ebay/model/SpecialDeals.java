package iiitb.ebay.model;

public class SpecialDeals {
	
	private int dealID;
	private String startDate;
	private String endDate;
	private String buy;
	private String free;
	private String type;
	
	
	public int getDealID() {
		return dealID;
	}
	public void setDealID(int dealID) {
		this.dealID = dealID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

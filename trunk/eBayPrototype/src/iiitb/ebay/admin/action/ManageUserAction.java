package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.Seller;
import iiitb.ebay.admin.service.ManageUserService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> sellerIDList=new ArrayList<String>();
	private  ArrayList<Seller> sellerList=new ArrayList<Seller>();
	private  ArrayList<Integer> selectedDefault=new ArrayList<Integer>();
	
	



	public ArrayList<Integer> getSelectedDefault() {
		return selectedDefault;
	}




	public void setSelectedDefault(ArrayList<Integer> selectedDefault) {
		this.selectedDefault = selectedDefault;
	}




	public ArrayList<String> getSellerIDList() {
		return sellerIDList;
	}




	public void setSellerIDList(ArrayList<String> sellerIDList) {
		this.sellerIDList = sellerIDList;
	}




	public ArrayList<Seller> getSellerList() {
		return sellerList;
	}




	public void setSellerList(ArrayList<Seller> sellerList) {
		this.sellerList = sellerList;
	}




	public String execute() {
	
		
		ManageUserService mus=new ManageUserService();
		sellerIDList=mus.sellerIDList();
		this.selectedDefault=mus.BlockedSellerList();
		System.out.println("Default List size:"+selectedDefault.size()+"contents are....");
		for(int j=0;j<selectedDefault.size();j++){
			System.out.println(selectedDefault.get(j));
			
		}
	
		for(int i=0;i<sellerIDList.size();i++){
			
	
			Seller s= new Seller();
			s.setId(Integer.parseInt(sellerIDList.get(i)));
			s.setName(mus.sellerName(Integer.parseInt(sellerIDList.get(i))));
			s.setAvgRating(mus.avgRating(Integer.parseInt(sellerIDList.get(i))));
			
		
			
			sellerList.add(s);
		}
	
		return SUCCESS;
		
	}
	
}

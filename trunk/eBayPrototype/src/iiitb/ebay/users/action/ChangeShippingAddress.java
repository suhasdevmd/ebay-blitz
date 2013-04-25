package iiitb.ebay.users.action;

import java.util.ArrayList;
import java.util.Map;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.ShippingAddress;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.ChangeShippingAddressService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeShippingAddress extends ActionSupport{


	private String contactName;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private String telephone;
	private String isPrimary;
	ChangeShippingAddressService cs=new ChangeShippingAddressService();
	ArrayList<String> stateList=new ArrayList<String>();
	ArrayList<String> countryList=new ArrayList<String>();
	Map<String,Object> session;
	ArrayList<Cart> sessionCart;
	
	ArrayList<ShippingAddress> addr=new ArrayList<ShippingAddress>();
	
	public ArrayList<ShippingAddress> getAddr() {
		return addr;
	}


	public void setAddr(ArrayList<ShippingAddress> addr) {
		this.addr = addr;
	}



	private int sellerID;
	private String pageFlag;
	
	



	public int getSellerID() {
		return sellerID;
	}


	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}


	public String getPageFlag() {
		return pageFlag;
	}


	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}


	public ArrayList<String> getCountryList() {
		return countryList;
	}


	public void setCountryList(ArrayList<String> countryList) {
		this.countryList = countryList;
	}


	public ArrayList<String> getStateList() {
		return stateList;
	}


	public void setStateList(ArrayList<String> stateList) {
		this.stateList = stateList;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getIsPrimary() {
		return isPrimary;
	}


	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}


	public ArrayList<Cart> getSessionCart() {
		return sessionCart;
	}


	public void setSessionCart(ArrayList<Cart> sessionCart) {
		this.sessionCart = sessionCart;
	}

	
	


	@SuppressWarnings("unchecked")
	public String execute(){


		int userID;
		session=ActionContext.getContext().getSession();
		
		userID=((UserDetails)session.get("userdetails")).getUserID();
		ShippingAddress saddress=new ShippingAddress();
		saddress=cs.getPrimaryAddress(userID);


		//contactName=saddress.getContactName();
		//address=saddress.getAddress();
		//city=saddress.getCity();
		//state=saddress.getState();
		//pincode=saddress.getPincode();
		//country=saddress.getCountry();
		//telephone=saddress.getTelephone();
		//isPrimary=saddress.getIsPrimary();

		System.out.println("Change addr execute sellerID="+this.getSellerID());
		
		contactName="";
		address="";
		city="";
		state="";
		pincode="";
		country="";
		telephone="";
		isPrimary="";
		
		
		System.out.println("The tele in change ship address : "+telephone);


		populateStateList();
		populateCountryList();


		addr=cs.getAddressList(userID);
		
		sessionCart=(ArrayList<Cart>) session.get("SessionCart");
		
		
		
		System.out.println(" from session  sssssssss : "+sessionCart.get(0).getCartProduct().get(0).getName());

		System.out.println(" display arraylist size  ---> "+addr.size());
		
		
		for(int i=0;i<addr.size();i++){
			
			System.out.println(" check check ::: "+addr.get(i).getAddress());
			
		}


		return SUCCESS;
	}




	public String addaddress(){



		System.out.println(" add addaddress");

		ShippingAddress shipaddress=new ShippingAddress();


		int userID;
		session=ActionContext.getContext().getSession();
		userID=((UserDetails)session.get("userdetails")).getUserID();


		shipaddress.setUserID(String.valueOf(userID));
		shipaddress.setContactName(contactName);
		shipaddress.setAddress(address);
		shipaddress.setCity(city);
		shipaddress.setPincode(Integer.parseInt(pincode));
		shipaddress.setState(state);
		shipaddress.setCountry(country);
		
		if(!telephone.equals("") || !telephone.equalsIgnoreCase(null)){
		shipaddress.setTelephone(Long.parseLong(telephone));}

		// if the checkbox is selected - set it to Y else N


		if(isPrimary.equals("true")){
			shipaddress.setIsPrimary("Y");
		}
		else{
			shipaddress.setIsPrimary("N");
		}
		System.out.println("  hhhh  "+isPrimary);

		cs.addAddress(shipaddress);

		
		
		
		
		
		ShippingAddress saddress=new ShippingAddress();
		saddress=cs.getPrimaryAddress(userID);


		contactName=saddress.getContactName();
		address=saddress.getAddress();
		city=saddress.getCity();
		state=saddress.getState();
		pincode=String.valueOf(saddress.getPincode());
		country=saddress.getCountry();
		telephone=String.valueOf(saddress.getTelephone());
		isPrimary=saddress.getIsPrimary();
		
		
		
		
		

		populateStateList();
		populateCountryList();

		
		
		
		sessionCart=(ArrayList<Cart>) session.get("SessionCart");
		
		addr=cs.getAddressList(userID);

		return SUCCESS;
	}


	public String editaddress(){



		System.out.println(" edit address name: "+contactName);
		
		

		return SUCCESS;
	}



	public String shiptoaddress(){


		
		session=ActionContext.getContext().getSession();
		int userID=((UserDetails)session.get("userdetails")).getUserID();
		
		session=ActionContext.getContext().getSession();
		System.out.println(" ship to address name: "+contactName);
		
		sessionCart=(ArrayList<Cart>) session.get("SessionCart");
		
		addr=cs.getAddressList(userID);
		
		//System.out.println(" from session  sssssssss : "+sessionCart.get(0).getCartProduct().get(0).getName());

		return SUCCESS;
	}





	public void populateStateList(){


		stateList.add("Andaman and Nicobar Islands");
		stateList.add("Andhra Pradesh");
		stateList.add("Arunachal Pradesh");
		stateList.add("Assam");
		stateList.add("Bihar");
		stateList.add("Chandigarh");
		stateList.add("Chhattisgarh");
		stateList.add("Dadra and Nagar Haveli");
		stateList.add("Daman and Diu");
		stateList.add("Delhi");
		stateList.add("Goa");
		stateList.add("Gujarat");
		stateList.add("Haryana");
		stateList.add("Himachal Pradesh");
		stateList.add("Jammu and Kashmir");
		stateList.add("Jharkhand");
		stateList.add("Karnataka");
		stateList.add("Kerala");
		stateList.add("Lakshyadweep");
		stateList.add("Madhya Pradesh");
		stateList.add("Maharashtra");
		stateList.add("Manipur");
		stateList.add("Meghalaya");
		stateList.add("Mizoram");
		stateList.add("Nagaland");
		stateList.add("Orissa");
		stateList.add("Pondicherry");
		stateList.add("Punjab");
		stateList.add("Rajasthan");
		stateList.add("Sikkim");
		stateList.add("Tamil Nadu");
		stateList.add("Tripura");
		stateList.add("Uttaranchal");
		stateList.add("Uttar Pradesh");
		stateList.add("West Bangal");





	}



	public void populateCountryList(){



		countryList.add("India");
		countryList.add("Pakistan");
		countryList.add("United States");
		countryList.add("United Kingdom");
		countryList.add("Srilanka");
		countryList.add("Canada");
		countryList.add("APO/FPO");

	}





}

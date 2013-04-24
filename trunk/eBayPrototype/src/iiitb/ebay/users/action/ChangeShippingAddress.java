package iiitb.ebay.users.action;

import java.util.ArrayList;
import java.util.Map;

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
	private int pincode;
	private String country;
	private long telephone;
	private String isPrimary;
	ChangeShippingAddressService cs=new ChangeShippingAddressService();
	ArrayList<String> stateList=new ArrayList<String>();
	ArrayList<String> countryList=new ArrayList<String>();
	Map<String,Object> session;



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


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public long getTelephone() {
		return telephone;
	}


	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}


	public String getIsPrimary() {
		return isPrimary;
	}


	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}


	public String execute(){


		int userID;
		session=ActionContext.getContext().getSession();
		
		userID=((UserDetails)session.get("userdetails")).getUserID();
		ShippingAddress saddress=new ShippingAddress();
		saddress=cs.getPrimaryAddress(userID);


		contactName=saddress.getContactName();
		address=saddress.getAddress();
		city=saddress.getCity();
		state=saddress.getState();
		pincode=saddress.getPincode();
		country=saddress.getCountry();
		telephone=saddress.getTelephone();
		isPrimary=saddress.getIsPrimary();


		
		System.out.println("The tele in change ship address : "+telephone);


		populateStateList();
		populateCountryList();



		System.out.println(" display dat ---> "+contactName);


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
		shipaddress.setPincode(pincode);
		shipaddress.setState(state);
		shipaddress.setCountry(country);
		shipaddress.setTelephone(telephone);

		// if the checkbox is selected - set it to Y else N


		if(isPrimary.equals("true")){
			shipaddress.setIsPrimary("Y");
		}
		else{
			shipaddress.setIsPrimary("N");
		}
		System.out.println("  hhhh  "+isPrimary);

		cs.addAddress(shipaddress);


		populateStateList();
		populateCountryList();


		return SUCCESS;
	}


	public String editaddress(){



		System.out.println(" edit address name: "+contactName);
		
		

		return SUCCESS;
	}



	public String shiptoaddress(){



		System.out.println(" ship to address name: "+contactName);
		
		

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
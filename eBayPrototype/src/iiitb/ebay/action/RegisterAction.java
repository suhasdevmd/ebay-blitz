package iiitb.ebay.action;

import iiitb.ebay.users.model.UserAddress;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.RegisterService;

import com.mysql.jdbc.Blob;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private int userID;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int pinCode;
	private int day, year;
	private int month;
	private String country;
	private String telephone;
	private String role;
	private String DOB;
	private String email;
	private String memberSince;
	private Blob image;
	private String commandButton;
	private String userName;
	private String password;
	private String secretQuestion;
	private String secretAnswer;
	private String address1;

	public String getUserName() {
		return userName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String execute() {
		UserDetails user = new UserDetails();
		UserCredential usercredential = new UserCredential();
		UserAddress useraddress = new UserAddress();
		RegisterService register = new RegisterService();
		/* if (commandButton.equalsIgnoreCase("Continue")) */{
			user.setFirstName(firstName);
			System.out.println(firstName);
			user.setLastName(lastName);
			user.setAddress(address1);
			user.setCity(city);
			user.setState(state);
			user.setPinCode(pinCode);
			user.setCountry(country);
			user.setTelephone(telephone);
			user.setDay(day);
			user.setMonth(month);
			user.setYear(year);
			user.setEmail(email);
			user.setMemberSince(register.getDateNow());
			usercredential.setUserName(userName);
			usercredential.setSecretQuestion(secretQuestion);
			usercredential.setSecretAnswer(secretAnswer);
			usercredential.setPassword(password);
			Boolean val = RegisterService.checkForDuplicateUser(usercredential);
			if (val == true) {
				int userid = register.insertIntoUserDetails(user);
				System.out.println("User ID generated : " + userid);
				usercredential.setUserID(userid);
				register.insertIntoUserCredential(usercredential);
				useraddress.setUserID(userid);
				useraddress.setAddress1(address1);
				useraddress.setContactName(firstName);
				useraddress.setCity(city);
				useraddress.setCountry(country);
				useraddress.setState(state);
				useraddress.setPinCode(pinCode);
				register.insertIntoUserAddress(useraddress);
				return "success";
			} else {
				addActionError(getText("User already exists!!"));
				return "duplicate";
			}
		}
		// return "error";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

}

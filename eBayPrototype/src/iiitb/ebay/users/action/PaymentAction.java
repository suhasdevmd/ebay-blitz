package iiitb.ebay.users.action;

import iiitb.ebay.model.Balance;
import iiitb.ebay.model.OrderItemwithProductName;
import iiitb.ebay.model.Transactions;
import iiitb.ebay.service.OrderService;
import iiitb.ebay.service.PaymentInfoService;
import iiitb.ebay.service.ShippingDetailsService;
import iiitb.ebay.service.TransactionService;
import iiitb.ebay.users.model.CardDetails;
import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CartService;
import iiitb.ebay.users.service.PaymentService;
import iiitb.ebay.users.service.SignOutService;
import iiitb.ebay.utilities.DB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private double amount;
	private int paymentMethod;
	private String cardNumber;
	private String cvv;
	private String expiryDate;
	private String pageFlag = "Pay";
	Map<String, Object> session;
	private int sellerID;
	private String contactName;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private String country;
	private String productName = new String();
	private String errorMsg;
	double balance;
	private double charges ;
	public ArrayList<Transactions> transactionList = new ArrayList<Transactions>();
	public ArrayList<Balance> balanceList = new ArrayList<Balance>();
	public ArrayList<OrderItemwithProductName> orderItemwithProductName = new ArrayList<OrderItemwithProductName>();

	public ArrayList<Transactions> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transactions> transactionList) {
		this.transactionList = transactionList;
	}

	public ArrayList<OrderItemwithProductName> getOrderItemwithProductName() {
		return orderItemwithProductName;
	}

	public void setOrderItemwithProductName(
			ArrayList<OrderItemwithProductName> orderItemwithProductName) {
		this.orderItemwithProductName = orderItemwithProductName;
	}

	public ArrayList<Balance> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(ArrayList<Balance> balanceList) {
		this.balanceList = balanceList;
	}

	/*
	 * 0 : ebay : 1 : cash 2 : credit/debit card 3 : PaisaPay
	 */
	private static final int ebay = 0;
	private static final int cash = 1;
	private static final int credit = 2;
	private static final int debit = 3;
	private static final int paisaPay = 4;
	private static final int eBayID = 14;

	@SuppressWarnings("unchecked")
	public String execute() {
		UserDetails ud;
		int transactionID = 0;
		int shippingID = 0 ;
		int orderID = 0;
		
		System.out.println("********AMOUNT*******" + amount);
		ArrayList<Cart> sessionCart = null;
		session = ActionContext.getContext().getSession();

		System.out.println("PAYMENT ACTION----" + this.getAmount());

		System.out.println("--in payment action--");
		/*
		 * System.out.println("--" + sellerID + "--" + address + "--" + city +
		 * "--" + state + "--" + pincode + "--" + country + "--" + pageFlag +
		 * "--" + contactName);
		 */
		if (null == session.get("login"))
			return "no-login";
		ud = (UserDetails) session.get("userdetails");

		
		if (pageFlag.equalsIgnoreCase("Buy")) {
			System.out.println("Buy");
			this.setAddress(this.address + "," + this.city + "," + this.state
					+ "," + this.pincode + "," + this.country);
			sessionCart = (ArrayList<Cart>) session.get("SessionCart");

			for (int i = 0; i < sessionCart.size(); i++) {
				if (sessionCart.get(i).getSellerID()
						.equalsIgnoreCase(String.valueOf(sellerID))) {
					
					double totalAmnt = sessionCart.get(i).getTotal()  + getShippingCharges(pincode);
					//update the cart's total amount so that if order summary is asked we can display the order with the shipping charges applied
					sessionCart.get(i).setTotal(totalAmnt);
					this.setAmount(totalAmnt);
					
				}
			}
			

			for (int i = 0; i < sessionCart.size(); i++) {
				System.out.println(sessionCart.get(i).getSellerID());
				for (int j = 0; j < sessionCart.get(i).getCartProduct().size(); j++) {
					System.out.println(sessionCart.get(i).getCartProduct().get(j).getName());
				}
			}

			return "success";
		} else {
			// ud = (UserDetails) session.get("userdetails");
			if (paymentMethod == cash) {
				System.out.println("IN CASH");
				balance = PaymentService.checkBalance(cash, ud.getUserID());
				System.out.println("BALANCE  " + balance );
				System.out.println("AMOUNT " + amount );
				if (amount > balance) {
					errorMsg = "Insufficient balance in user account";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(cash, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
			} else if (paymentMethod == paisaPay) {
				// reduce the balance amount in userdetails
				balance = PaymentService.checkBalance(paisaPay, ud.getUserID());
				if (amount > balance) {
					errorMsg = "Insufficient balance in paisaPay account";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(paisaPay, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
			} else if (paymentMethod == credit) {
				/*
				 * check the validity and other details of the card using the
				 * credit/debit card table before reducing the amount in the
				 * same table
				 */
				CardDetails cd = new CardDetails();
				cd.setCardNumber(cardNumber);
				cd.setCvv(cvv);
				cd.setExpiryDate(expiryDate);

				if (!PaymentService
						.checkCardDetails(credit, cd, ud.getUserID())) {
					errorMsg = "Credit card details do not match";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				balance = PaymentService.checkBalance(credit, ud.getUserID());
				System.out.println("Credit Card " + balance + " " + amount);
				if (amount > balance) {
					errorMsg = "Insufficient balance in credit card";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(credit, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
			} else if (paymentMethod == debit) {
				/*
				 * check the validity and other details of the card using the
				 * credit/debit card table before reducing the amount in the
				 * same table
				 */
				CardDetails cd = new CardDetails();
				cd.setCardNumber(cardNumber);
				cd.setCvv(cvv);
				cd.setExpiryDate(expiryDate);

				if (!PaymentService.checkCardDetails(debit, cd, ud.getUserID())) {
					errorMsg = "Debit card details do not match";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				balance = PaymentService.checkBalance(debit, ud.getUserID());
				if (amount > balance) {
					errorMsg = "Insufficient balance in debit card";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(debit, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList = PaymentService.fetchBalance(ud.getUserID());
					transactionList = PaymentService.fetchTransactions(ud
							.getUserID());
					return "failure";
				}
			}
		}

		if (paymentMethod != paisaPay) {
			/* add 5% commission to ebay account */
			balance = PaymentService.checkBalance(ebay, 1);
			System.out.println("ebay balance bef update" + balance);
			PaymentService.updateAmount(ebay, balance + (amount * 0.05), 1);
			System.out.println("ebay balance after update" + balance);

			/* deduct ebay share of 5% and pass on money to seller */
			balance = PaymentService.checkBalance(cash, sellerID);
			PaymentService.updateAmount(cash, balance
					+ (amount - (amount * 0.05)), this.getSellerID());

			/* add transaction from buyer to ebay */
			transactionID = TransactionService.makeTransaction(
					"5% Commision transfer Buyer to eBay: Total Amount="
							+ this.getAmount() * 0.05,
					TransactionService.getDateNow(), ud.getUserID(), eBayID);
			
			/*  add transaction from eBay to Seller */
			TransactionService.makeTransaction(
					"Transfer eBay to Seller: Total Amount= Rs."
							+ (this.getAmount() - this.getAmount() * 0.05),
					TransactionService.getDateNow(), eBayID, this.getSellerID());
		}
		else{
			/* Transfer all money to eBay */
			balance = PaymentService.checkBalance(ebay, paisaPay);
			System.out.println("ebay balance " + balance);
			PaymentService.updateAmount(ebay, balance + amount, paisaPay);

			/* add transaction from buyer to ebay */
			transactionID = TransactionService.makeTransaction(
					"Amount Secured With eBay: Total Amount= Rs."
							+ this.getAmount(),
					TransactionService.getDateNow(), ud.getUserID(), eBayID);
			
		}

		 orderID = OrderService.createOrder(this.getAmount(),
				OrderService.INITIATE, ud.getUserID(),
				"Your transaction is being processed",sellerID);

		sessionCart = (ArrayList<Cart>) session.get("SessionCart");
		System.out.println("Session Cart" + sessionCart.size());
		for (int i = 0; i < sessionCart.size(); i++) {
			if (sessionCart.get(i).getSellerID()
					.equalsIgnoreCase(String.valueOf(sellerID))) {
				int productListSize = sessionCart.get(i).getCartProduct()
						.size();
				ArrayList<Category> tempProdList = sessionCart.get(i)
						.getCartProduct();
				for (int j = 0; j < productListSize; j++) {
					OrderService.insertOrderItems(Integer.parseInt(tempProdList
							.get(j).getProductID()), orderID,
							Integer.parseInt(tempProdList.get(j)
									.getQuantitySelected()), tempProdList
									.get(j).getSubTotal());

				}

			}
		}

		orderItemwithProductName = PaymentService.fetchOredrItem(orderID);

		/* add shipping details */
		shippingID = ShippingDetailsService.addShippingDetails(this.getContactName(),
				this.getAmount(), this.getAddress(),
				ShippingDetailsService.getDateNow(), orderID, sellerID, "DHL",
				"852741963");

		/* transaction details for display */
		balanceList = PaymentService.fetchBalance(ud.getUserID());
		transactionList = PaymentService.fetchTransactions(ud.getUserID());

		/* deduct quantity and remove from cart */

		SignOutService.updateCartTable(sessionCart, ud.getUserID());

		CartService.UpdateQuantities(String.valueOf(sellerID));

		for (int i = 0; i < sessionCart.size(); i++) {
			for (int j = 0; j < sessionCart.get(i).getCartProduct().size(); j++) {
				if (sessionCart.get(i).getSellerID()
						.equalsIgnoreCase(String.valueOf(sellerID)))
					CartService.removeFromCart(sessionCart.get(i)
							.getCartProduct().get(j).getProductID(),
							String.valueOf(sellerID), ud.getUserID());
			}
		}
		
		
		

		for (int i = 0; i < sessionCart.size(); i++) {
			if (sessionCart.get(i).getSellerID().equals(sellerID)) {
				/*
				 * CartService.removeFromCart(sessionCart.get(i).getCartProduct()
				 * .get(j).getProductID(),
				 * sessionCart.get(i).getCartProduct().get
				 * (j).getSellerID(),userID);
				 */

				System.out.println("  wooooorking      -------------- ");

				sessionCart.remove(i);
				//session.put("SessionCart", sessionCart);
				break;
			}


			if (sessionCart.get(i).getCartProduct().size() == 0) {
				sessionCart.remove(i);
			}
			
			
		}
		
		/* Payment Information */
		String mode="invalid";
		if(paymentMethod == cash)
			mode = "cash";
		else if(paymentMethod == credit)
			mode = "credit";
		else if(paymentMethod == debit)
			mode = "debit";
		else if(paymentMethod == paisaPay)
			mode = "paisaPay";
		PaymentInfoService.addPaymentInfo(mode, transactionID, PaymentInfoService.getDateNow(), orderID, shippingID,amount);
		
		session.put("SessionCart", sessionCart);

		
		
		sessionCart=CartService.fetchCartItems(ud.getUserID());
		
		session.put("SessionCart" , sessionCart);
		
		
		return "success";
	}

	
	private double getShippingCharges(int pincode) {
		
		try{
			String pinStr = String.valueOf(pincode);
		String query_fetchCharges = "select  charges from shippingcharges where pincode = '" + pinStr + "'" ;
		System.out.println("query_fetchCharges  " +  query_fetchCharges);
		ResultSet rs = DB.readFromBmtcDB(query_fetchCharges);
			while(rs.next()){
				this.setCharges(rs.getDouble("charges"));
			}					
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return charges;
		
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
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

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}
}

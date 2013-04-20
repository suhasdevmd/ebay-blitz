package iiitb.ebay.users.action;

import iiitb.ebay.model.Balance;
import iiitb.ebay.model.OrderItemwithProductName;
import iiitb.ebay.model.Transactions;
import iiitb.ebay.service.OrderService;
import iiitb.ebay.service.ShippingDetailsService;
import iiitb.ebay.service.TransactionService;
import iiitb.ebay.users.model.CardDetails;
import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CartService;
import iiitb.ebay.users.service.PaymentService;
import iiitb.ebay.users.service.SignOutService;

import java.util.ArrayList;
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
	private String productName=new String();
	private String errorMsg;
	double balance;
	public ArrayList<Transactions> transactionList=new ArrayList<Transactions>();
	public ArrayList<Balance> balanceList=new ArrayList<Balance>();
	public ArrayList<OrderItemwithProductName> orderItemwithProductName=new ArrayList<OrderItemwithProductName>();
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

	@SuppressWarnings("unchecked")
	public String execute() {
		UserDetails ud;
		ArrayList<Cart> sessionCart = null;
		session = ActionContext.getContext().getSession();


		System.out.println("PAYMENT ACTION----"+this.getAmount());

		System.out.println("--in payment action--");
		/*	System.out.println("--" + sellerID + "--" + address + "--" + city
				+ "--" + state + "--" + pincode + "--" + country + "--"
				+ pageFlag + "--" + contactName);
		 */
		if (null == session.get("login"))
			return "no-login";
		ud = (UserDetails) session.get("userdetails");



		/*	
		System.out.println("orderID "+orderID);
		balanceList=PaymentService.fetchBalance(ud.getUserID());
		transactionList=PaymentService.fetchTransactions(ud.getUserID());




		System.out.println("Balance Table");
		for(int j=0;j<balanceList.size();j++){
			System.out.println(balanceList.get(j).getMode()+"  "+balanceList.get(j).getAmount());
		}

		System.out.println("Transaction Table");
		for(int j=0;j<transactionList.size();j++){
			System.out.println(transactionList.get(j).getDate()+"  "+transactionList.get(j).getSenderID()+"  "+transactionList.get(j).getTransactionID()
					+"  "+transactionList.get(j).getReceiverID()+transactionList.get(j).getDetails());
		}


		System.out.println("Order Table"+orderItemwithProductName.size());
		for(int j=0;j<orderItemwithProductName.size();j++){
			System.out.println(orderItemwithProductName.get(j).getAmount()+"  "+orderItemwithProductName.get(j).getOrderID()+"  "+orderItemwithProductName.get(j).getQuantity()
					+"  "+orderItemwithProductName.get(j).getProductID()+"  "+orderItemwithProductName.get(j).getProductName());
		}

		 */		
		if (pageFlag.equalsIgnoreCase("Buy")) {
			System.out.println("Buy");
			this.setAddress(this.address + "," + this.city + "," + this.state
					+ "," + this.pincode + "," + this.country);
			sessionCart = (ArrayList<Cart>) session.get("SessionCart");

			for (int i = 0; i < sessionCart.size(); i++) {
				if (sessionCart.get(i).getSellerID()
						.equalsIgnoreCase(String.valueOf(sellerID))) {
					this.setAmount(sessionCart.get(i).getTotal());
				}
			}

			return "success";
		} else {
			//			ud = (UserDetails) session.get("userdetails");
			if (paymentMethod == cash) {
				balance = PaymentService.checkBalance(cash, ud.getUserID());
				if (amount > balance) {
					errorMsg = "Insufficient balance in user account";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(cash, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
			} else if (paymentMethod == paisaPay) {
				// reduce the balance amount in userdetails
				balance = PaymentService.checkBalance(paisaPay, ud.getUserID());
				if (amount > balance) {
					errorMsg = "Insufficient balance in paisaPay account";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(paisaPay, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
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

				if (!PaymentService.checkCardDetails(credit, cd, ud.getUserID())) {
					errorMsg = "Credit card details do not match";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				balance = PaymentService.checkBalance(credit, ud.getUserID());
				System.out.println("Credit Card "+balance+" "+amount);
				if (amount > balance) {
					errorMsg = "Insufficient balance in credit card";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(credit, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
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
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				balance = PaymentService.checkBalance(debit, ud.getUserID());
				if (amount > balance) {
					errorMsg = "Insufficient balance in debit card";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
				if (!PaymentService.updateAmount(debit, balance - amount,
						ud.getUserID())) {
					errorMsg = "Error. Transaction could not be completed successfully";
					balanceList=PaymentService.fetchBalance(ud.getUserID());
					transactionList=PaymentService.fetchTransactions(ud.getUserID());
					return "failure";
				}
			}
		}
		/* add 5% commission to ebay account */
		balance = PaymentService.checkBalance(ebay, 1);
		System.out.println("ebay balance "+balance);
		PaymentService.updateAmount(ebay, balance + (amount * 0.05), 1);

		/* deduct ebay share of 5% and pass on money to seller */
		balance = PaymentService.checkBalance(cash, sellerID);
		PaymentService.updateAmount(cash, balance + (amount - (amount * 0.05)),
				this.getSellerID());

		/* add transaction from buyer to ebay */
		TransactionService.makeTransaction(
				"5% Commision transfer Buyer to eBay: Total Amount="
				+ this.getAmount() * 0.05,
				TransactionService.getDateNow(), ud.getUserID(), 14);
		TransactionService.makeTransaction(
				"Transfer eBay to Seller: Total Amount="
				+ (this.getAmount() - this.getAmount() * 0.05),
				TransactionService.getDateNow(), 14, this.getSellerID());


		int orderID = OrderService.createOrder(this.getAmount(),
				OrderService.INITIATE, ud.getUserID(),
		"Your transaction is being processed");


		sessionCart = (ArrayList<Cart>) session.get("SessionCart");
		System.out.println("Session Cart"+sessionCart.size());
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


		orderItemwithProductName=PaymentService.fetchOredrItem(orderID);

		/* add shipping details */
		ShippingDetailsService.addShippingDetails(this.getContactName(),
				this.getAmount(), this.getAddress(),
				ShippingDetailsService.getDateNow(), orderID, sellerID, "DHL",
		"852741963");

		/* transaction details for display */
		balanceList=PaymentService.fetchBalance(ud.getUserID());
		transactionList=PaymentService.fetchTransactions(ud.getUserID());


		/* deduct quantity and remove from cart */



		SignOutService.updateCartTable(sessionCart,ud.getUserID());


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


		for(int i=0;i<sessionCart.size();i++){				
			if(sessionCart.get(i).getSellerID().equals(sellerID)){
				/*CartService.removeFromCart(sessionCart.get(i).getCartProduct().get(j).getProductID(),
							sessionCart.get(i).getCartProduct().get(j).getSellerID(),userID);*/
				
				System.out.println("  wooooorking      -------------- ");
				
				sessionCart.remove(i);
				session.put("SessionCart" , sessionCart);
			}


			if(sessionCart.get(i).getCartProduct().size() == 0){
				sessionCart.remove(i);
			}
		}






			return "success";
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
	}

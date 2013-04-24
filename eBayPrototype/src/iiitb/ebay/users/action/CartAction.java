package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Cart;
import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.CartService;
import iiitb.ebay.users.service.FeedbackService;
import iiitb.ebay.users.service.ProductService;
import iiitb.ebay.users.service.UserService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {

	private String productID;
	private String price;
	private String name;
	private String quantity;
	private String quantityAvailable;
	private String sellerID;
	private ArrayList<Cart> sessionCart;
	private ArrayList<Cart> sessionBuyNow;
	private Map<String, Object> session ;
	
	private String image1;
	
	

	private int removeFlag=0;
	private String fromProductjsp="0";
	private int updateTotal=0;
	private String buttonName=null;

	private boolean flag=false;

	
	
	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getUpdateTotal() {
		return updateTotal;
	}

	public void setUpdateTotal(int updateTotal) {
		this.updateTotal = updateTotal;
	}

	public String getFromProductjsp() {
		return fromProductjsp;
	}

	public void setFromProductjsp(String fromProductjsp) {
		this.fromProductjsp = fromProductjsp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRemoveFlag() {
		return removeFlag;
	}

	public void setRemoveFlag(int removeFlag) {
		this.removeFlag = removeFlag;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public ArrayList<Cart> getSessionCart() {
		return sessionCart;
	}

	public void setSessionCart(ArrayList<Cart> sessionCart) {
		this.sessionCart = sessionCart;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public ArrayList<Cart> getSessionBuyNow() {
		return sessionBuyNow;
	}

	public void setSessionButNow(ArrayList<Cart> sessionBuyNow) {
		this.sessionBuyNow = sessionBuyNow;
	}
	public String getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(String quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	
	public String buyNow(){
		session = ActionContext.getContext().getSession();
		System.out.println("BUY NOW button clicked---");
		sessionBuyNow = new ArrayList<Cart>();
		Cart cartItem = new Cart();
		Category productDetails = new Category();
		UserCredential userCreds = new UserCredential();
		FeedbackService fdbkService = new FeedbackService();

		cartItem.setCartProduct(ProductService.fetchSingleProductDetails(productID));
		cartItem.getCartProduct().get(0).setQuantitySelected(quantity);
		System.out.println(cartItem.getCartProduct().get(0).getQuantitySelected());
		cartItem.setSellerID(sellerID);
		Integer quantityTemp = Integer.parseInt(cartItem.getCartProduct().get(0).getQuantitySelected());
		System.out.println("Temp qty ="+quantityTemp.intValue());

		Double priceTemp = Double.parseDouble(cartItem.getCartProduct().get(0).getPrice());
		cartItem.setTotal(quantityTemp.intValue() * priceTemp.doubleValue());

		userCreds =  UserService.getUserCredentials(Integer.parseInt(sellerID));
		cartItem.setSellerUserName(userCreds.getUserName());
		fdbkService.fetchFeedback(Integer.parseInt(sellerID));  
		cartItem.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
		cartItem.getCartProduct().add(productDetails);

		cartItem.setFeedbackScore(fdbkService.getFeedbackList().size());
		sessionBuyNow.add(cartItem);
		System.out.println("buy now size = "+sessionBuyNow.size());
		session.put("BuyNow", sessionBuyNow);
		
		for(int i=0;i<sessionBuyNow.size();i++){
			System.out.println("session cart val "+sessionBuyNow.get(i).getSellerUserName());
			for(int j=0;j<sessionBuyNow.get(i).getCartProduct().size();j++){
				System.out.println("cart pdt val "+sessionBuyNow.get(i).getCartProduct().get(j).getName());
			}
		}
		System.out.println("-------------------------------------------------");
		

		return "createorder";
	}

	public String execute(){

		Double total=0.0;
		session = ActionContext.getContext().getSession();

		if(session.get("login")==null){
			return "no-login";
		}

		
		System.out.println("inside Cart action");
		System.out.println("-- "+productID+" -- "+name+" -- "+price+" -- "+sellerID+" -- "+quantity);
		System.out.println(buttonName+" -- "+removeFlag+" -- "+fromProductjsp+" -- "+updateTotal);

		//if cart item is present in session get the sessionCart for the session
		if(session.get("SessionCart") != null ){
			System.out.println("sessoncart is not null --------------------------------------------");
			sessionCart = (ArrayList<Cart>)session.get("SessionCart");
			System.out.println("session cart size = "+sessionCart.size());
		}
		//else create a new sessionCart object
		else {
			sessionCart = new ArrayList<Cart>();
		}

		UserDetails ud =(UserDetails) session.get("userdetails");
		int userID = ud.getUserID();


			// Code For Removing object from Cart
			if(removeFlag == 1){
				System.out.println("Remove clicked!!");
				sessionCart = (ArrayList<Cart>)session.get("SessionCart");

				for(int i=0;i<sessionCart.size();i++){
					System.out.println("Inside FOR - remove flag");
					System.out.println("size of cart product = "+sessionCart.get(i).getCartProduct().size());
					for(int j=0;j<sessionCart.get(i).getCartProduct().size();j++){
						System.out.println("1 --> "+sessionCart.get(i).getCartProduct().get(j).getProductID());
						System.out.println("2 --> "+productID);
						if(sessionCart.get(i).getCartProduct().get(j).getProductID().equals(productID)){
							CartService.removeFromCart(sessionCart.get(i).getCartProduct().get(j).getProductID(),
									sessionCart.get(i).getCartProduct().get(j).getSellerID(),userID);
							sessionCart.get(i).getCartProduct().remove(j);
							session.put("SessionCart" , sessionCart);
						}

					}	
					if(sessionCart.get(i).getCartProduct().size() == 0){
						sessionCart.remove(i);
					}
				}

				removeFlag = 0;
				return "success";
			}
			// End 

			//Code for Adding object to Cart		
			if(fromProductjsp.equalsIgnoreCase("1")){

				
				//actual insertion of product to sessionCart
				int i;
				//if some product is present in the sessionCart ie size of arraylist sessionCart is > 0 
				if(sessionCart.size() > 0){
					System.out.println("IF - cart size > 0 : sessionCart.size = "+sessionCart.size());
					//iterate over each product in the sessionCart
					for(i=0;i<sessionCart.size();i++){
						System.out.println("seller ID = "+sellerID);
						System.out.println("seller ID from session = "+sessionCart.get(i).getSellerID());

						//if sellerID being sent from the Product.jsp is equal to sellerID in the sessionCart
						//only add another product details to the same sellerID
						//do not create a new cartItem and add to sessionCart
						if(sessionCart.get(i).getSellerID().equalsIgnoreCase(sellerID)){
							System.out.println("IF - seller ID from sessioncart is equal to sellerID sent from previous jsp");

							for(int j=0;j<sessionCart.get(i).getCartProduct().size();j++){
								if(sessionCart.get(i).getCartProduct().get(j).getProductID().equalsIgnoreCase(productID)){
									int qty = Integer.parseInt(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());
									qty = qty+ Integer.parseInt(quantity);
									String qtys = String.valueOf(qty);
									sessionCart.get(i).getCartProduct().get(j).setQuantitySelected(qtys);
									flag=true;

									/* set the new variable to modified here!!!! */
									sessionCart.get(i).getCartProduct().get(j).setIsNew("modified");
									
									
									/* Totals */
									Double price = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getPrice());
									/*Double qty = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());*/
									Double subTotal = price * qty ;
									sessionCart.get(i).getCartProduct().get(j).setSubTotal(subTotal); 
									total += sessionCart.get(i).getCartProduct().get(j).getSubTotal();
									sessionCart.get(i).setTotal(total);

									break;
								}
							}
							if(flag){
								flag=false;
								break;
							}

							System.out.println("creating new cart product");
							Category productDetails = new Category();
							productDetails.setName(name);
							productDetails.setProductID(productID);
							productDetails.setPrice(price);
							productDetails.setSellerID(sellerID);
							productDetails.setIsNew("new");
							System.out.println("-0-0-0-0-0-0-0-0- > quantity available = "+quantityAvailable);
							productDetails.setQuantityAvailable(quantityAvailable);
							productDetails.setQuantitySelected(quantity);
							productDetails.setImage1(ProductService.getProductImage(productID));
							image1=ProductService.getProductImage(productID);
							
							
							/* Totals */
							/*Double qty = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());*/
							Double subTotal = Double.parseDouble(price) * Double.parseDouble(productDetails.getQuantitySelected()) ;
							productDetails.setSubTotal(subTotal); 
							//total += productDetails.getSubTotal();
							//sessionCart.get(i).setTotal(total);
							sessionCart.get(i).getCartProduct().add(productDetails);
							
							total=0.0;
							for(int k=0;k<sessionCart.get(i).getCartProduct().size();k++){
								total += sessionCart.get(i).getCartProduct().get(k).getSubTotal();
							}
							sessionCart.get(i).setTotal(total);
							
							break;

						}
					}


					//if no match was found to the sellerID ie loop variable 'i' will be equal to the size of sessionCart
					//this means product is from a new sellerID
					//create a new CartItem and add to sessionCart
					if(i == sessionCart.size()){
						System.out.println("IF - seller ID is not equal.. create a new cart item and add it to the existing session cart");
						Cart cartItem = new Cart();
						Category productDetails = new Category();
						UserCredential userCreds = new UserCredential();
						FeedbackService fdbkService = new FeedbackService();

						productDetails.setName(name);
						productDetails.setProductID(productID);
						productDetails.setPrice(price);
						productDetails.setSellerID(sellerID);
						productDetails.setIsNew("new");
						System.out.println("-0-0-0-0-0-0-0-0- > quantity available = "+quantityAvailable);
						productDetails.setQuantityAvailable(quantityAvailable);
						productDetails.setQuantitySelected(quantity);
						productDetails.setImage1(ProductService.getProductImage(productID));
						image1=ProductService.getProductImage(productID);
						
						
						/* Totals */
						/*Double qty = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());*/
						Double subTotal = Double.parseDouble(price) * Double.parseDouble(productDetails.getQuantitySelected()) ;
						productDetails.setSubTotal(subTotal); 
						total = subTotal;
						cartItem.setTotal(total);						

						cartItem.setSellerID(sellerID);
						userCreds =  UserService.getUserCredentials(Integer.parseInt(sellerID));
						cartItem.setSellerUserName(userCreds.getUserName());
						fdbkService.fetchFeedback(Integer.parseInt(sellerID));  
						cartItem.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
						cartItem.getCartProduct().add(productDetails);

						cartItem.setFeedbackScore(fdbkService.getFeedbackList().size());
						sessionCart.add(cartItem);

					}

					//if sessionCart size is less than or equal to 0.
					//this will be executed only when the session cart is empty
				// create a new cartItem and add it to the sessionCart
				}else{

					System.out.println("ELSE - new CartItem needs to be created");
					Cart cartItem = new Cart();
					Category productDetails = new Category();
					UserCredential userCreds = new UserCredential();
					FeedbackService fdbkService = new FeedbackService();

					productDetails.setName(name);
					productDetails.setProductID(productID);
					productDetails.setPrice(price);
					productDetails.setSellerID(sellerID);
					productDetails.setIsNew("new");
					System.out.println("-0-0-0-0-0-0-0-0- > quantity available = "+quantityAvailable);
					productDetails.setQuantityAvailable(quantityAvailable);
					productDetails.setQuantitySelected(quantity);
					productDetails.setImage1(ProductService.getProductImage(productID));
					image1=ProductService.getProductImage(productID);
					
					
					/* Totals */
					/*Double qty = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());*/
					Double subTotal = Double.parseDouble(price) * Double.parseDouble(productDetails.getQuantitySelected()) ;
					productDetails.setSubTotal(subTotal); 
					total += productDetails.getSubTotal();
					cartItem.setTotal(total);

					cartItem.setSellerID(sellerID);
					userCreds =  UserService.getUserCredentials(Integer.parseInt(sellerID));
					cartItem.setSellerUserName(userCreds.getUserName());
					fdbkService.fetchFeedback(Integer.parseInt(sellerID));
					cartItem.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
					cartItem.setFeedbackScore(fdbkService.getFeedbackList().size());

					ArrayList<Category> temp = cartItem.getCartProduct();  
					temp.add(productDetails);
					cartItem.setCartProduct(temp);

					sessionCart.add(cartItem);
				}

				//finally update the session
				session.put("SessionCart" , sessionCart);
				fromProductjsp.equals("0");
				return "success";
			}

			return "success";
		}

	
	@SuppressWarnings("unchecked")
	public String updateTotal(){
		
		System.out.println("inside update total ");
		Double total = 0.0;
		/*
		for (Cart crt : this.getSessionCart()) {
			System.out.println("Value : "+crt.getSellerID());
			for (Category cat : crt.getCartProduct()) {
				System.out.println("---val "+cat.getQuantitySelected()+" "+cat.getName()+" "+cat.getSellerID());
			}
		}
		*/
		
		/* Cart object for changes in quantity done on page */
		ArrayList<Cart> tempCart = this.getSessionCart();
				
		/* Session object with complete data */
		session = ActionContext.getContext().getSession();
		sessionCart = (ArrayList<Cart>) session.get("SessionCart");
		
		
		
		
		for (int i = 0; i < sessionCart.size(); i++) {
			for (int j = 0; j < sessionCart.get(i).getCartProduct().size(); j++){
				
				if(sessionCart.get(i).getSellerID().equalsIgnoreCase(tempCart.get(i).getSellerID())){
					Double price = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getPrice());
					/*Double qty = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantitySelected());*/
					Double qty = Double.parseDouble(tempCart.get(i).getCartProduct().get(j).getQuantitySelected());
					System.out.println("---------------0-0-0-0-0-0- > qty = "+qty);
					Double qtyAvail = Double.parseDouble(sessionCart.get(i).getCartProduct().get(j).getQuantityAvailable());
					System.out.println("---------------0-0-0-0-0-0- > qty = "+qtyAvail);
					if(qty > qtyAvail){
						addActionError("invalid quantity");
						tempCart.get(i).getCartProduct().get(j).setQuantitySelected("1");
						sessionCart.get(i).getCartProduct().get(j).setQuantitySelected("1");
					}
					qty = Double.parseDouble(tempCart.get(i).getCartProduct().get(j).getQuantitySelected());
					Double subTotal = price * qty ;
					sessionCart.get(i).getCartProduct().get(j).setSubTotal(subTotal); 
					total += sessionCart.get(i).getCartProduct().get(j).getSubTotal();
					sessionCart.get(i).setTotal(total);
					sessionCart.get(i).getCartProduct().get(j).setQuantitySelected(tempCart.get(i).getCartProduct().get(j).getQuantitySelected());
				}
			}
		}
		return "success";
	}


	
}
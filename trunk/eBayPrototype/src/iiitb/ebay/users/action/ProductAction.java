package iiitb.ebay.users.action;

import iiitb.ebay.users.model.Category;
import iiitb.ebay.users.model.UserCredential;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.FeedbackService;
import iiitb.ebay.users.service.ProductService;
import iiitb.ebay.users.service.UserService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private String productID;
	private ArrayList<Category> productDetails = new ArrayList<Category>();
	private String sellerUserName;
	private int feedbackScore;
	private float positiveFeedback;
	private int sellerID;
	private int quantity;
	private String image1;
	private Map<String, Object> session ;
	

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	private String buttonName;


	public ArrayList<Category> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<Category> productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public int getFeedbackScore() {
		return feedbackScore;
	}

	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}

	public float getPositiveFeedback() {
		return positiveFeedback;
	}

	public void setPositiveFeedback(float positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public String execute(){
		
		
		/*session = ActionContext.getContext().getSession();

		if(session.get("login")==null){
			return "no-login";
		}
*/
		
		
		System.out.println("Inside product action");
		productDetails = ProductService.fetchSingleProductDetails(productID);
		System.out.println("PRODUCT ACTOIN - quantity available = "+productDetails.get(0).getQuantityAvailable());
		UserCredential userCreds = new UserCredential();
		FeedbackService fdbkService = new FeedbackService();

		/* Seller information */
		userCreds =  UserService.getUserCredentials(Integer.parseInt(productDetails.get(0).getSellerID()));
		this.setSellerUserName(userCreds.getUserName());
		/* feedback info */
		fdbkService.fetchFeedback(Integer.parseInt(productDetails.get(0).getSellerID()));/* Please do better than this. Very heavy fetch */
		this.setPositiveFeedback(fdbkService.getPositiveFeedback()*100);
		/* Do not know the logic for calculation of this */
		this.setFeedbackScore(fdbkService.getFeedbackList().size());
		this.setSellerID(Integer.parseInt(productDetails.get(0).getSellerID()));


		image1=ProductService.getProductImage(productID);

		
		System.out.println(" ----->.  . .. . "+image1);
		
		
		return "buy-it-now";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
}

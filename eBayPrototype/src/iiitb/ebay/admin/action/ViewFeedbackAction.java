package iiitb.ebay.admin.action;

import iiitb.ebay.admin.model.Feedback;
import iiitb.ebay.admin.service.ViewFeedbackService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ViewFeedbackAction extends ActionSupport{

	private int feedback_id=0;
	private ArrayList<Feedback> feedbacks=new ArrayList<Feedback>();
	ViewFeedbackService vfs=new ViewFeedbackService();

	public ArrayList<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(ArrayList<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}


	public String execute(){
		// retrieve the feedback list from the database


		if(feedback_id!=0){
			Feedback fd=new Feedback();

			fd=vfs.getFeedbackWithID(feedback_id);
			feedbacks.clear();
			feedbacks.add(fd);
			return "display";
		}

		feedbacks.clear();
		feedbacks=vfs.getFeedbacks();
		
		
		System.out.println("working - - 1 "+feedbacks.get(0).getUsername());
		
		
		
		return SUCCESS;
	}



}

package iiitb.ebay.admin.service;

import iiitb.ebay.admin.model.Feedback;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewFeedbackService {

	



	public ArrayList<Feedback> getFeedbacks(){

		ArrayList<Feedback> feedbacks=new ArrayList<Feedback>();
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select * from feedback";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				Feedback feedback=new Feedback();
				feedback.setFeedbackID(rs.getInt("feedbackID"));
				feedback.setUserID(rs.getInt("fromUserID"));
				feedback.setUsername(getName(rs.getInt("fromUserID")));
				feedback.setDetails(rs.getString("details"));
				feedback.setDate(rs.getString("date"));
				feedback.setRating(rs.getFloat("descriptionRating"));
				feedback.setSellerID(rs.getInt("toUserID"));
				feedback.setSellername(getName(rs.getInt("toUserID")));
				feedback.setProductID(rs.getInt("productID"));
				
				
				
				
				System.out.println(" Seller --> "+feedback.getSellername());
				
				
				

				feedbacks.add(feedback);

			}

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		return feedbacks;
	}




	public String getName(int id){

		String name="";
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select CONCAT(firstname,' ',lastname) as name from userdetails where userid='"+id+"'";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				name=rs.getString("name");
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return name;

	}




	public Feedback getFeedbackWithID(int id){

		Feedback fd=new Feedback();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select * from feedback where feedbackID='"+id+"'";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {

				fd.setFeedbackID(rs.getInt("feedbackID"));
				fd.setUserID(rs.getInt("fromUserID"));
				fd.setUsername(getName(rs.getInt("fromUserID")));
				fd.setDetails(rs.getString("details"));
				fd.setDate(rs.getString("date"));
				fd.setRating(rs.getFloat("descriptionRating"));
				fd.setSellerID(rs.getInt("toUserID"));
				fd.setSellername(getName(rs.getInt("toUserID")));



			}

			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return fd;
	}



}

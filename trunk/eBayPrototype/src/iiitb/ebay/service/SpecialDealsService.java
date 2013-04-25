package iiitb.ebay.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import iiitb.ebay.model.SpecialDeals;
import iiitb.ebay.utilities.DB;

public class SpecialDealsService {
	
	public static ArrayList<SpecialDeals> getDeals(String currDate){
		Connection con;
		ResultSet rs;
		String query;
		ArrayList<SpecialDeals>  spDealsList = new ArrayList<SpecialDeals>();
		SpecialDeals spDeal = null;
		try {
			con = DB.getConnection();
			query = "SELECT * from specialDeals WHERE STR_TO_DATE('"+currDate+"','%d-%m-%Y') >= STR_TO_DATE(startDate,'%d-%m-%Y') AND STR_TO_DATE('"+currDate+"','%d-%m-%Y') <= STR_TO_DATE(endDate,'%d-%m-%Y')";

			rs = DB.readFromDB(query, con);
			while (rs.next()) {
				spDeal = new SpecialDeals();
				spDeal.setDealID(rs.getInt("dealID"));
				spDeal.setStartDate(rs.getString("startDate"));
				spDeal.setEndDate(rs.getString("endDate"));
				spDeal.setBuy(rs.getString("buy"));
				spDeal.setFree(rs.getString("free"));
				spDeal.setType(rs.getString("type"));
				
				spDealsList.add(spDeal);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return spDealsList;
	}
	
	
	public static String getDateNow() {

		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}
	

}

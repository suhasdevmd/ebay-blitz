package iiitb.ebay.users.service;

import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

	
	public boolean authenticateUser(String username,String password){
		
		boolean valid=false;
		
		String user="",pass="",accStatus="";
		
		
		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			
			query="select userName,password,accStatus from usercredential";
			
			
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				
				
				user=rs.getString("userName");
				pass=rs.getString("password");
				
				System.out.println(user+" --> from DB "+pass);
				
				
				accStatus=rs.getString("accStatus");
				
				if(user.equalsIgnoreCase(username) && pass.equals(password) && accStatus.equalsIgnoreCase("A"))
				{
					valid=true;
					return valid;
					
					
				}
				
				
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		 
		
		return valid;
	}
	
	
	
	
	
	public UserDetails getUserDetails(String username,String password){
		
		
		UserDetails ud=new UserDetails();
		Connection con;
		ResultSet rs;
		String query;

			
		try {
			con=DB.getConnection();
			
			query="select * from userdetails ud,usercredential uc where ud.userID=uc.userID and uc.userName='"+username+"' and uc.password='"+password+"'";
			
			
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				
				ud.setUserID(rs.getInt("userID"));
				ud.setFirstName(rs.getString("firstName"));
				ud.setLastName(rs.getString("lastName"));
				ud.setAddress(rs.getString("address"));
				ud.setCity(rs.getString("city"));
				ud.setState("state");
				ud.setPinCode(rs.getInt("pincode"));
				ud.setCountry(rs.getString("country"));
				ud.setImage(rs.getBlob("image"));
				ud.setTelephone(rs.getString("telephone"));
				ud.setRole(rs.getString("role"));
				ud.setDOB(rs.getString("DOB"));
				ud.setEmail(rs.getString("email"));
				//ud.setMemberSince(rs.getString("memeberSince"));
				
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return ud;
	}
	
	
	
	
	
	
	public void AccountStatus(String username,String password){
		
		
		
		
	}
	
}

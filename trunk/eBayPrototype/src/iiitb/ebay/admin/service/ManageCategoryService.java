package iiitb.ebay.admin.service;

import iiitb.ebay.admin.model.CategoryDB;
import iiitb.ebay.admin.model.Feedback;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageCategoryService {



	public ArrayList<CategoryDB> getAllCategories(){

		ArrayList<CategoryDB> category=new ArrayList<CategoryDB>();


		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select * from producthierarchy";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {


				CategoryDB ct=new CategoryDB();

				ct.setPhKey(rs.getString("phKey"));
				ct.setName(rs.getString("name"));
				ct.setHasChild(rs.getString("hasChild"));
				ct.setParent(getParentName(rs.getString("parent")));




				category.add(ct);

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return category;

	}



	public String getParentName(String parent){

		String name="";



		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select name from producthierarchy where phKey='"+parent+"'";


			System.out.println("Suhas debug --> "+query);

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



	public int addCategory(String category){


		Connection con;
		Statement stmt;
		ResultSet rs;
		int ph=0;
		
		
		String sql="select count(*) as noOfRows from producthierarchy ";


	
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			
			rs=DB.readFromDB(sql ,con);
			
			
			while(rs.next()){
				ph=rs.getInt("noOfRows");
			}
			
			ph=ph+1;
			
			System.out.println(" the key value : "+ph);
			
			String insertSQL = "insert into producthierarchy "
				+ "(phKey,name,hasChild) " + 
				"values('"+ph+"','" + category
				+ "', '" + "N"  + "');";
			
			
			
			
			
			
			System.out.println(" >>>>>> "+insertSQL);

			int ret = stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

			

			
			rs.close();

			if (stmt != null) 
				DB.close(stmt);
			DB.close(con);
			//returns the patient id
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}


	public int addSubCategory(String subcategory,String parent){

		Connection con;
		Statement stmt;
		ResultSet rs;
		int ph=0;
		
		
		String sql="select count(*) as noOfRows from producthierarchy ";
		String upd="update producthierarchy set hasChild='Y' where name='"+parent+"'";

	
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			
		int res=DB.update(upd);
			
		if(res<0)return 0;
			
			
			rs=DB.readFromDB(sql ,con);
			
			
			while(rs.next()){
				ph=rs.getInt("noOfRows");
			}
			
			
			ph=ph+1;
			
			System.out.println(" the key value : "+ph);
			
			String insertSQL = "insert into producthierarchy "
				+ "(phKey,name,hasChild,parent) " + 
				"values('"+getPhKeyofParent( parent)+","+ph+"','" + subcategory
				+ "', '" + "N" + "', '" + getPhKeyofParent( parent) + "');";
			
			
			
			
			
			
			System.out.println(" >>>>>> "+insertSQL);

			int ret = stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

			

			
			rs.close();

			if (stmt != null) 
				DB.close(stmt);
			DB.close(con);
			//returns the patient id
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}


	
	
	public String getPhKeyofParent(String parent){
		
		String phkey=" ";
		
		

		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select phKey from producthierarchy where name='"+parent+"'";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {

				phkey=rs.getString("phKey");

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		return phkey;
		
	}
	

	
	
	
	
	public int deleteCategory(String phkey){
		
		int stat=0;
		
		

		Connection con;
		ResultSet rs;
		String query,query1;


		try {
			con=DB.getConnection();
			query="delete from producthierarchy where phKey='"+phkey+"'";
			
			
			//delete the children also
			
			
			query1="delete from producthierarchy where parent='"+phkey+"'";
			
			
			
			stat=DB.update(query);	
			stat=DB.update(query1);	
			con.close();

			
			return stat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		return 0;
		
		
	}


}

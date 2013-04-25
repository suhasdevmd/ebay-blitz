package iiitb.ebay.users.service;

import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InformSellerService {



	public ArrayList<String> getOutOfStockProduct(int sellerid){

		ArrayList<String> outofstock=new ArrayList<String>();

		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			
			query="select T1.entity from producteav as T1,producteav T2 where T1.entity=T2.entity and T1.val='0' and T1.attr='quantity' and T2.attr='sellerid' and T2.val='"+sellerid+"'";
			
			//query="select entity from producteav where attr='sellerID' and  val='"+sellerid+"'";
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				outofstock.add(getValue(String.valueOf(rs.getInt("entity")),"name").get(0));
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return outofstock;
	}



	/*public String getProductName(int productid){

		String name = "";

		Connection con;
		ResultSet rs;
		String query;


		try {
			con=DB.getConnection();
			query="select val from producteav where attr='Name' and  entity='"+productid+"'";
			rs=DB.readFromDB(query, con);


			System.out.println(query);

			while(rs.next()) {
				System.out.println("inside getprodname ---> "+rs.getString("val"));

				name=rs.getString("val");

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return name;
	}

	 */








	// function to get entity given attribute and value


	public ArrayList<Integer> getEntity(String attribute,String value){

		ArrayList<Integer> ent=new ArrayList<Integer>();
		int entity=0;

		Connection con;
		ResultSet rs;
		String query=" ";


		try {
			con=DB.getConnection();

			if(attribute.equalsIgnoreCase(" "))
			{
				query="select entity from producteav where val='"+value+"'";
			}
			else if(value.equalsIgnoreCase(" ")){
				query="select entity from producteav where attr='"+attribute+"'";
			}
			else if(attribute.equalsIgnoreCase(" ") && value.equalsIgnoreCase(" ")){
				query="select entity from producteav";
			}
			else{
				query="select entity from producteav where attr='"+attribute+"' and  val='"+value+"'";
			}


			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				entity=rs.getInt("entity");
				ent.add(entity);
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		return ent;
	}



	// function to get attribute given entity and the value




	public ArrayList<String> getAttribute(String entity,String value){

		ArrayList<String> attr=new ArrayList<String>();
		String attribute=" ";

		Connection con;
		ResultSet rs;
		String query=" ";


		try {
			con=DB.getConnection();

			if(entity.equalsIgnoreCase(" "))
			{
				query="select attr from producteav where val='"+value+"'";
			}
			else if(value.equalsIgnoreCase(" ")){
				query="select attr from producteav where entity='"+entity+"'";
			}
			else if(entity.equalsIgnoreCase(" ") && value.equalsIgnoreCase(" ")){
				query="select val from producteav";
			}
			else{
				query="select attr from producteav where entity='"+entity+"' and  val='"+value+"'";
			}


			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				attribute=rs.getString("attr");
				attr.add(attribute);
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return attr;
	}



	// function to get value when entity and the attribute are given




	public ArrayList<String> getValue(String entity,String attribute){

		ArrayList<String> values=new ArrayList<String>();
		String val="";

		Connection con;
		ResultSet rs;
		String query=" ";


		try {
			con=DB.getConnection();

			if(entity.equalsIgnoreCase(" "))
			{
				query="select val from producteav where attr='"+attribute+"'";
			}
			else if(attribute.equalsIgnoreCase(" ")){
				query="select val from producteav where entity='"+entity+"'";
			}
			else if(attribute.equalsIgnoreCase(" ") && entity.equalsIgnoreCase(" ")){
				query="select val from producteav";
			}
			else{
				query="select val from producteav where attr='"+attribute+"' and  entity='"+entity+"'";
			}


			
			
			System.out.println(" -- > "+query);
			
			
			rs=DB.readFromDB(query, con);

			while(rs.next()) {
				val=rs.getString("val");
				values.add(val);
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		return values;
	}




}

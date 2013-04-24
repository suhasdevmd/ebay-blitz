package iiitb.ebay.users.service;

import iiitb.ebay.model.Balance;
import iiitb.ebay.model.OrderItemwithProductName;
import iiitb.ebay.model.Transactions;
import iiitb.ebay.model.OrderItems;
import iiitb.ebay.users.model.CardDetails;
import iiitb.ebay.utilities.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentService {
	/*
	 * 0 : ebay
	 * 1 : cash 
	 * 2 : credit-card 
	 * 3 : debit-card 
	 * 4 : PaisaPay
	 */
	private static final int ebay = 0;
	private static final int cash = 1;
	private static final int credit = 2;
	private static final int debit = 3;
	private static final int paisaPay = 4;

	static Connection con;
	static ResultSet rs,rs1;
	static String query;

	
	
	public static String getProductName(int Id){
		
		String query1 = "select val from producteav where attr='name' and entity="+Id;
		rs1 = DB.readFromDB(query1, con);
		try {
			
			
			
			while(rs1.next()){
				
				return(rs1.getString("val"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Error";
		
	}
	
	public static ArrayList<OrderItemwithProductName> fetchOredrItem(int Id){
		ArrayList<OrderItemwithProductName> orederItemList=new ArrayList<OrderItemwithProductName>();
		
		
		System.out.println("Id"+Id);
		con = DB.getConnection();
		
		
			String query = "select * from orderitems where orderID="+Id+";";
			System.out.println(query);
			rs = DB.readFromDB(query, con);
			try {
				
				
				
				while(rs.next()){
					OrderItemwithProductName t=new OrderItemwithProductName();
				t.setAmount(rs.getDouble("amount"));
				t.setOrderID(rs.getInt("orderID"));
				t.setProductID(rs.getInt("productID"));
				
				t.setQuantity(rs.getInt("quantity"));
				
				String query1 = "select val from producteav where attr='name' and entity="+rs.getInt("productID");
				System.out.println(query1);
				rs1 = DB.readFromDB(query1, con);
				try {
					
					
					
					while(rs1.next()){
						
						t.setProductName(rs1.getString("val"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
					orederItemList.add(t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return orederItemList;
	}

	public static ArrayList<Transactions> fetchTransactions(int Id){
		
		ArrayList<Transactions> TransactionsList=new ArrayList<Transactions>();
		
		System.out.println("Id"+Id);
		con = DB.getConnection();
		
		
			String query = "select details,receiverID,senderID,transactionID,date from transactions where senderID="+Id+" or receiverID="+Id+";";
			System.out.println(query);
			rs = DB.readFromDB(query, con);
			try {
				
				
				
				while(rs.next()){
					Transactions t=new Transactions();
				t.setDate(rs.getString("date"));
				t.setDetails(rs.getString("details"));
				t.setReceiverID(rs.getInt("receiverID"));
				t.setSenderID(rs.getInt("senderID"));
				t.setTransactionID(rs.getInt("transactionID"));
				
				TransactionsList.add(t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		
		return TransactionsList;
		
	}
	
	
	
	public static ArrayList<Balance> fetchBalance(int Id){
		
		ArrayList<Balance> balanceList=new ArrayList<Balance>();
		
		
		con = DB.getConnection();
		double balance = 0.0;
		
			String query = "select balance from creditcard where userID="+Id+";";
			rs = DB.readFromDB(query, con);
			try {
				while(rs.next()){
					balance = rs.getDouble("balance");
				Balance b1=new Balance();
				b1.setMode("Credit Card");
				b1.setAmount(balance);
				balanceList.add(b1);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
			// Hard coded userID=1
			query = "select balance from debitcard where userID="+Id+";";
			rs = DB.readFromDB(query, con);
			try {
				while(rs.next()){
					balance = rs.getDouble("balance");
					Balance b2=new Balance();
					b2.setMode("Debit Card");
					b2.setAmount(balance);
					balanceList.add(b2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			query = "select balance from accountdetails where userID="+Id+";";
			rs = DB.readFromDB(query, con);
			try {
				while(rs.next()){
					balance = rs.getDouble("balance");
					Balance b3=new Balance();
					b3.setMode("Cash");
					b3.setAmount(balance);
					balanceList.add(b3);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			query = "select paisaPayBalance from accountdetails where userID="+Id+";";
			rs = DB.readFromDB(query, con);
			try {
				while(rs.next()){
					balance = rs.getDouble("paisaPayBalance");
					Balance b4=new Balance();
					b4.setMode("paisaPayBalance");
					b4.setAmount(balance);
					balanceList.add(b4);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			
		return balanceList;
		
	}
	
	
	
	
	public static double checkBalance(int method,int userID) {
		con = DB.getConnection();
		double balance = 0.0;
		if (method == cash) {
			// Hard coded userID=1
			query = "select balance from accountdetails where userID="+userID;
			rs = DB.readFromDB(query, con);
			try {
				if (rs.next())
					balance = rs.getDouble("balance");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method == credit) {
			// Hard coded userID=1
			query = "select balance from creditcard where userID="+userID;
			rs = DB.readFromDB(query, con);
			try {
				if (rs.next())
					balance = rs.getDouble("balance");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method == debit) {
			// Hard coded userID=1
			query = "select balance from debitcard where userID="+userID;
			rs = DB.readFromDB(query, con);
			try {
				if (rs.next())
					balance = rs.getDouble("balance");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method == paisaPay) {
			// Hard coded userID=1
			query = "select paisaPayBalance from accountdetails where userID="+userID;
			rs = DB.readFromDB(query, con);
			try {
				if (rs.next())
					balance = rs.getDouble("paisaPayBalance");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (method == ebay) {
			// Hard coded for Ebay
			if( userID != paisaPay)
				query = "select balance from accountdetails where accID=1";
			else
				query = "select paisaPayBalance from accountdetails where accID=1";
			rs = DB.readFromDB(query, con);
			try {
				if (rs.next())
					balance = rs.getDouble("paisaPayBalance");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection in PaymentService->checkBalance");
		}
		return balance;
	}

	public static boolean checkCardDetails(int method, CardDetails cd,int userID) {
		boolean status = false;
		con = DB.getConnection();

		if (method == credit) {
			// Hard coded userID=1
			query = "SELECT creditCardNumber, CVV, expiryDate from creditcard where userID="+userID;
			rs = DB.readFromDB(query, con);

			try {
				while (rs.next()) {
					if (rs.getString("creditCardNumber").equals(
							cd.getCardNumber())
							&& rs.getString("CVV").equals(cd.getCvv())
							&& rs.getString("expiryDate").equals(
									cd.getExpiryDate())) {
						status = true;
						break;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method == debit) {
			// Hard coded userID=1
			query = "SELECT debitCardNumber, CVV, expiryDate from debitcard where userID="+userID;
			rs = DB.readFromDB(query, con);
			
			try {
				while (rs.next()) {
					if (rs.getString("debitCardNumber").equals(
							cd.getCardNumber())
							&& rs.getString("CVV").equals(cd.getCvv())
							&& rs.getString("expiryDate").equals(
									cd.getExpiryDate())) {
						status = true;
						break;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Error closing database connection in PaymentService->checkCardDetails");
		}
		return status;
	}
	
	public static boolean updateAmount(int method, double amount,int userID) {
		con = DB.getConnection();
		int status = 0;
		
		if(method == cash) {
			// Hard coded userID=1
			query = "UPDATE accountdetails SET balance=" + amount + " where userID="+userID;
			status = DB.update(con,query);
		} else if(method == debit) {
			// Hard coded userID=1
			query = "UPDATE debitcard SET balance=" + amount + " where userID="+userID;
			status = DB.update(con,query);
		} else if(method == credit) {
			// Hard coded userID=1
			query = "UPDATE creditcard SET balance=" + amount + " where userID="+userID;
			System.out.println("credit query "+query);
			status = DB.update(con,query);
		} else if(method == paisaPay) {
			// Hard coded userID=1
			query = "UPDATE accountdetails SET paisaPayBalance=" + amount + " where userID="+userID;
			status = DB.update(con,query);
		}
		else if(method == ebay) {
			if(userID != paisaPay)
				query = "UPDATE accountdetails SET balance=" + amount + " where accID=1";
			else
				query = "UPDATE accountdetails SET paisaPayBalance=" + amount + " where accID=1";
			status = DB.update(con,query);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
			.println("Error closing database connection in PaymentService->deductAmount");
		}
		
		if(status == 0) return false;
		return true;
	}
}

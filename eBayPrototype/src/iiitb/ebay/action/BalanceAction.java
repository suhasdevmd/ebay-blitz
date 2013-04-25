package iiitb.ebay.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import iiitb.ebay.model.Balance;
import iiitb.ebay.model.Transactions;
import iiitb.ebay.users.model.UserDetails;
import iiitb.ebay.users.service.PaymentService;

@SuppressWarnings("serial")
public class BalanceAction  extends ActionSupport {
	
	public ArrayList<Transactions> transactionList=new ArrayList<Transactions>();
	public ArrayList<Balance> balanceList=new ArrayList<Balance>();
	
	public String execute(){
		System.out.println("Entering Class:BalanceAction :: Method:execute :: package:iiitb.ebay.action");

		Map<String,Object>session=ActionContext.getContext().getSession();
		UserDetails ud = (UserDetails)session.get("userdetails");
		
		balanceList=PaymentService.fetchBalance(ud.getUserID());
		transactionList=PaymentService.fetchTransactions(ud.getUserID());
		
		if(balanceList != null && transactionList !=null)
		return "success";
		else
			return "error";
	}

	public ArrayList<Transactions> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transactions> transactionList) {
		this.transactionList = transactionList;
	}

	public ArrayList<Balance> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(ArrayList<Balance> balanceList) {
		this.balanceList = balanceList;
	}

}

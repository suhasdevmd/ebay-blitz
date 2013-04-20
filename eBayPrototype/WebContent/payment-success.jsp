<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success!</title>
</head>
<body>
	<h1>Success! Thank you for buying from eBay</h1>
	
	
	<h3>Balance Details</h3>
	<table border="2" align="left" title="Balance Details" >
	<tr>
	<th>Payment Mode</th>
	<th>Amount Available</th>
	
	</tr>
	<s:iterator value="balanceList">   
<tr>
  
   <td><s:property value="mode"/></td>
   <td><s:property value="amount"/></td>
</tr>
</s:iterator>
</table>
</br>
</br>
</br>
</br>
</br>
</br>
</br>



<h3>Order Details</h3>
	<table border="2" align="left" title="Balance Details" >
	<tr>
	<th>Item</th>
	<th>Quantity</th>
	<th>Amount</th>
	
	</tr>
	<s:iterator value="orderItemwithProductName">   
<tr>
  
   <td><s:property value="productName"/></td>
   <td><s:property value="quantity"/></td>
     <td><s:property value="amount"/></td>
</tr>
</s:iterator>
</table>
</br>
</br>
</br>
</br>



<h3>Transaction Details</h3>
	<table border="2" align="left" title="Balance Details" width="450" >
	<tr>
	<th>Transaction</th>
	<th>Date</th>
	
	</tr>
	<s:iterator value="transactionList">   
<tr>
  
   <td><s:property value="details"/></td>
   <td><s:property value="date"/></td>
</tr>
</s:iterator>
	
	
	</table>
</body>
</html>
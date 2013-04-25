<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-1.9.1.min.js"></script>
<title>Payment</title>
<script>
	$(document).ready(function() {
		$("#myform #cardDetails").hide();
	});
</script>
</head>
<body>
	<h2>Payment page</h2>
	<s:form id="myform" action="payment" method="post">
		<s:textfield name="amount" label="Amount" disabled="true">Amount :</s:textfield>
		<s:hidden name="amount"/>
				<br />
				Inclusive of all shipping charges <s:property value="charges"/> 
		<s:radio id="radios" label="Payment method" name="paymentMethod"
			list="#{'1':'Cash','2':'Credit card','3':'Debit card','4':'PaisaPay'}" value="1" />
		<s:div id="cardDetails">
		<table>
			<tr><td>Card number</td><td><s:textfield name="cardNumber" label="Card number"></s:textfield><br /></td></tr>
			<tr><td>Expiry date</td><td><s:textfield name="expiryDate" label="Expiry Date"></s:textfield><br /></td></tr>
			<tr><td>CVV</td><td><s:textfield name="cvv" label="CVV"></s:textfield></td></tr>
		</table>
		</s:div>
		<script>
			$('[id*="radios"]').click(function(event) {
				if ($(this).val() == '2' || $(this).val() == '3')
					$("#myform #cardDetails").show("slow");
				else
					$("#myform #cardDetails").hide("slow");
			});
		</script>
		<br />
		<s:hidden name="sellerID"/>
		<s:hidden name="address"/>
		<s:hidden name="contactName"/>
		<s:submit value="Pay!"></s:submit>
	</s:form>
</body>
</html>
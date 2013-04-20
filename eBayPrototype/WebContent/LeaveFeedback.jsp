<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm() {
var val = true;
var a = document.forms["myForm"]["descriptionRating"].value;
var b = document.forms["myForm"]["communicationRating"].value;
var c = document.forms["myForm"]["shippingRating"].value;
var d = document.forms["myForm"]["shipChargesRating"].value;
if (a == null || a == "" || b == null || b == "" || c == null || c == "" || d == null || d == "") {
alert("All the fields must be filled out");
val = false;
}
return val;
}

</script>
</head>
<body>
	<form action="LeaveFeedback" method="post" name="myForm">
		<table>
			<s:iterator value="productDetails">
				<s:hidden name="productID" />
				<s:hidden name="sellerID"/>
				<tr>
					<td><s:property value="name" />
					</td>
				</tr>

				<tr>
					<td><img src="" alt="<s:property value="name"/>" />
					</td>
				</tr>

			</s:iterator>
		</table>
		<h3>Rate this transaction</h3>
		<br>
		<s:radio id="radios" name="feedbackType" list="#{'1':'Positive','2':'Neutral','3':'Negative','4':'Later'}" value="1" />
			<h3>Tell us more</h3>
			<br>
			<s:textfield name="details" size="30" maxlength="50"></s:textfield>
			<br>
			<h3>Click "Select rating" to rate more details of the sale</h3>
			<br>
			<table>
			<tr>
			<td>How accurate was the item description?</td>
			<td><s:select label="descriptionRating"
						headerKey="Select rating"
						headerValue="Select rating"
						list="{'5', '4', '3', '2', '1'}"
						name="descriptionRating">
					</s:select>
				</td>
			</tr>
			<tr>
			<td>How satisfied were you with the seller's communication'?</td>
			<td><s:select label="communicationRating"
						headerKey="Select rating"
						headerValue="Select rating"
						list="{'5', '4', '3', '2', '1'}"
						name="communicationRating">
					</s:select>
				</td>
			</tr>
			<tr>
			<td>How quickly did the seller ship the item?</td>
			<td><s:select label="shippingRating"
						headerKey="Select rating"
						headerValue="Select rating"
						list="{'5', '4', '3', '2', '1'}"
						name="shippingRating">
					</s:select>
				</td>
			</tr>
			<tr>
			<td>How reasonable were the shipping and handling charges?</td>
			<td><s:select label="shipChargesRating"
						headerKey="Select rating"
						headerValue="Select rating"
						list="{'5', '4', '3', '2', '1'}"
						name="shipChargesRating">
					</s:select>
				</td>
			</tr>
			</table>
			<s:submit value="Leave Feedback" align="left" onclick="return validateForm();"/>
			
	</form>
	<a href="myEbay.action">Cancel</a>
</body>
</html>
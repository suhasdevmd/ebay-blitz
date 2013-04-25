<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit product details</title>
</head>
<body>
	<s:actionerror />
	<s:actionmessage />

	<form id="myForm" action="editProductInDB" method="post">
		<table>
			<tr>
				<td>Enter product name* :</td>
				<td><s:hidden name="productID" /> <s:textfield id="productName"
						name="productName" value="%{productName}" /></td>
			</tr>
			<tr>
				<td>Enter product price* :</td>
				<td><s:textfield id="productPrice" name="productPrice"
						value="%{productPrice}" /></td>
			</tr>
			<tr>
				<td>Enter product quantity* :</td>
				<td><s:textfield id="productQty" name="productQty"
						value="%{productQty}" /></td>
			</tr>
			<tr>
				<td>Enter product brand* :</td>
				<td><s:textfield id="productBrand" name="productBrand"
						value="%{productBrand}" /></td>
			</tr>
			<tr>
				<td>Enter discount :</td>
				<td><s:textfield id="productDiscount" name="productDiscount"
						value="%{productDiscount}" /></td>
			</tr>
			<tr>
				<td>Enter start date :</td>
				<td><s:textfield id="startDate" name="startDate"
						value="%{startDate}" /></td>
			</tr>
			<tr>
				<td>Enter end date :</td>
				<td><s:textfield id="endDate" name="endDate"
						value="%{endDate}" /></td>
			</tr>
		</table>
		<p>Select category</p>
		<!-- <s:select name="category" headerValue="Select Category"
			list="%{productNames}" value="1" />
		<br /> -->

		<p>Select condition</p>
		<s:radio name="conditionID" label="Select condition"
			list="#{'1':'New','2':'Used'}" value="%{productCondition}" />
		<br />

		<p>Other details about the product :</p>
		<br />

		<c:if test="${attrVals != null}">
			<div id="dynamic">
				<c:forEach var="attrVals" items="${attrVals}">
					<%
						int i = 0;
					%>
					<input type="text" value="${attrVals.key}" />
					<input type="text" value="${attrVals.value}" />
					<br />
				</c:forEach>
			</div>
			<s:hidden name="av"></s:hidden>
		</c:if>

		<s:submit></s:submit>
	</form>
	<script>
		$('#myForm').submit(
				function() {
					var productName = $("#productName").val();
					var productPrice = $("#productPrice").val();
					var productQty = $("#productQty").val();
					var productBrand = $("#productBrand").val();

					if (jQuery.trim(productName).length == 0
							|| jQuery.trim(productPrice).length == 0
							|| jQuery.trim(productQty).length == 0
							|| jQuery.trim(productBrand).length == 0) {
						alert("All required fields not filled.");
						return false;
					}
					
					var discount = $("#productDiscount").val();
					var startDate = $("#startDate").val();
					var endDate = $("#endDate").val();
					
					if (jQuery.trim(discount).length > 0) {
						if (jQuery.trim(startDate).length == 0 || jQuery.trim(endDate).length == 0) {
							alert("Start/End dates are empty");
							return false;
						} 
					}

					var msg = '';
					var count = 1;
					$('#dynamic :input').each(function() {
						var type = $(this).attr("type");
						if (type == "text") {
							if ($(this).val().length == 0) {
								alert("Other details might be empty");
								return false;
							}
							msg += $(this).val();
							if (count % 2 == 0) {
								msg += "\n";
							} else {
								msg += ":";
							}
							count++;
						}
					});
					$('#av').val(msg);
					// alert(msg);
					return true;
				});
	</script>
</body>
</html>
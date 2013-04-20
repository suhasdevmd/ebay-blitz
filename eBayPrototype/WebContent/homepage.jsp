<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eBay India - Online Shopping Mall: Free Auctions,
	Shop/Buy/Sell Mobiles, Cameras, Apparel, Computers, Bollywood Clothes
	&amp; Indian Products</title>
</head>
<body>
	<h1>Sandbox for dependent modules</h1>
	<h3>Do not use this page for any other purpose</h3>

	<!-- Seller Information page -->
	<s:form action="sellerInformation.action">
		<s:submit value="View Seller Information" />
	</s:form>

	<a href="payment.jsp">Payment Gateway</a>
	<a href="search.action">Search</a>
	<a href="view-order-status.action">View Order Status</a>
	<a href="myWishlist.action">Wishlist</a>
	<a href="deals.jsp">Deals</a>

	<s:form action="addProduct.action">
		<s:submit value="Add products" />
	</s:form>

	<s:form action="editProduct.action">
		<s:submit value="Edit products" />
	</s:form>

	<s:iterator value="productTypeList1" status="st" var="vr">
		<s:iterator value="#vr.description" var="map">

			<s:property value="#map.key" />::<s:property value="#map.value" />
			<br />

		</s:iterator>
	---------------<br />
	---------------<br />
		<s:iterator value="#st.description" var="map1">

			<s:property value="#map1.value" />

		</s:iterator>
	</s:iterator>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form>
	<table>
		<tr>
			<td>Product Name</td>
			<td>Brand</td>
			<td>Product Price</td>
			<td>Update</td>
		</tr>
		<s:iterator value="productDetails">
			<tr>
				<td><s:property value="name"/> </td>
				<td><s:property value="brand"/></td>
				<td><s:property value="price"/></td>
				<td><a href="editProduct.action?productID=<s:property value="productID"/>">Update</a></td>
			</tr>
		</s:iterator>
	</table>
	</s:form>
</body>
</html>
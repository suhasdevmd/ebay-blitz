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
	<form action="" method="post">
		<table>
			<tr>
				<h2>
				<td></td>
				<td>Product</td>
				<td>Price</td>
				<td>Leave Feedback</td>
				</h2>
			</tr>
			<s:iterator value="productDetails">
				<s:hidden name="productID" value="productID"></s:hidden>
				<tr>
					<td><img src="" alt="<s:property value="name"/>" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="price" /></td>
					<td><a
						href="GiveFeedback.action?productID=<s:property value = "productID" />">Give
							Feedback</a>
				</tr>

			</s:iterator>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order Status</title>
<link href="table.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/all.min.css">
<script language="javascript" type="text/javascript">
	function update(value1) {
		var url = "tracking-info?orderID=" + value1;
		window.open(url, "_blank",
				"directories=no, status=no,width=600, height=400,top=0,left=0");
	}
</script>
</head>
<body>
	<table class="imagetable" id="mytable">
		<tr>
			<th><Strong>ItemImage</Strong>
			</th>
			<th><Strong>Quantity</Strong>
			</th>
			<th><Strong>Price</Strong>
			</th>
		</tr>
		<s:iterator value="itemList" var="item">
			<tr>
				<td>
					<!--<s:property value="itemImage" />-->
				</td>
				<td><s:property value="quantity" />
				</td>
				<td><s:property value="price" />
				</td>
			</tr>
		</s:iterator>
	</table>
	<s:form action="cancel-order">
		<p>
			SHIPPING_STATUS ::
			<s:property value="shippingStatus" />
			<br></br> TRACKING_NO ::
			<s:if test="shippingStatus=='NOT_YET_SHIPPED'">
				<!-- Remember in the DB see that you store it as it is case sensitive chk if there is a work arnd -->
				<a href="javascript:update('<s:property value="orderID"/>')"><s:property
						value="shippingID" />
				</a>
			</s:if>
			<s:else>
   		Order ID <s:property value="orderID" />
			</s:else>
			<s:hidden name="orderID" />
			<s:if test="shippingStatus=='NOT_YET_SHIPPED'">
				<s:submit name="cancelOrder" value="cancelOrder" align="left" />
			</s:if>

		</p>
	</s:form>
	<s:form action="">
		<s:if test="shippingStatus=='SHIPPED'">
			<a href="delivered-order.action?orderID=<s:property value="orderID"/>">Confirm Delivery</a>
		</s:if>
	</s:form>
</body>
</html>




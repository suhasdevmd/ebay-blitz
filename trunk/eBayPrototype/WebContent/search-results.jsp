<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results Page</title>
<link href="table.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">

function update(value){
  var url="tracking-info?shippingID=value";
  window.open(url,"_blank","directories=no, status=no,width=1000, height=400,top=0,left=0");
}
</script>
</head>
<body>


	<s:actionmessage/>

	<s:form >
	
	<table cellspacing="50">
			<tr>
				<th><h3>Image</h3></th>
				<th><h3>Name</h3></th>
				<th><h3>Price</h3></th>
				<!-- <th><h3>Duration</h3></th> -->
				<th><h3>Description</h3></th>
			</tr>
	</table>
	<div style="width: 100%; height: 400px; overflow: auto;">
	<table>
			<s:iterator value="productList" var="obj">
				<tr>
				    <td><img src="productimages/<s:property value="image1"/>"  alt="<s:property value="image1"/>"></td> 
				<td>
					<s:url var="Name" action="products"><s:param name="productID"><s:property value="productID"/></s:param></s:url>
					<s:a href="%{#Name}">
						<s:property value="Name"/>
					</s:a>
				
				</td>
				<td><s:property value="Price" /></td>
				<%-- <td><s:property value="Duration" /></td> --%>
				<td><s:property value="Description"/></td>
				</tr>
			</s:iterator>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	
	
	
	
	
	
	
	
	
	
<!--  <table>
		<tr>
			<th >Image</th>
			<th >Name</th>
			<th >Price</th>
			<th>Duration</th>
			<th >Description</th>
		</tr>

		<s:iterator value="productList">
			<tr>
			    <td width="200"><s:property value="Image"/></td> 
				<td width="200">
					<s:url var="Name" action="products?productID"> </s:url>
					<s:a href="%{#Name}">
						<s:property value="Name" />
					</s:a>
				
				</td>
				<td width="200"><s:property value="Price" /></td>
				<td width="200"><s:property value="Duration" /></td>
				<td width="200"><s:property value="Description"/></td>
				
			</tr>
		</s:iterator>
	</table>

	
	
	-->
	
</s:form>

</body>
</html>
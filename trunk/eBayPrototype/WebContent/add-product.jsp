<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<title>Add product</title>

<script type="text/javascript">
	var counter = 2;
	$(document).ready(function() {
		$("#addButton").click(function() {
			if (counter > 10) {
				alert("Only 10 attributes allowed");
				return false;
			}
			var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDiv' + counter);
			newTextBoxDiv.after().html('<label>Attribute #' + counter + ' : </label>'	+ '<input type="text" name="attr' + counter + 
	      	'" id="attr' + counter + '" value="" >' + '<input type="text" name="val' + counter + 
	      	'" id="val' + counter + '" value="" >');
			newTextBoxDiv.appendTo("#TextBoxesGroup");
			counter++;
		});

		$("#removeButton").click(function() {
			if (counter == 1) {
				alert("No more attributes to remove");
				return false;
			}
			counter--;
			$("#TextBoxDiv" + counter).remove();
		});
	});
</script>

</head>
<body>
<s:actionerror/>
<s:actionmessage/>
	<form id="myForm" action="addProductToDB" method="post" enctype="multipart/form-data">
	<table>
		<tr><td>Enter product name* :</td><td><s:textfield id="productName" name="productName"/></td></tr>
		<tr><td>Enter product price* :</td><td><s:textfield id="productPrice" name="productPrice"/></td></tr>
		<tr><td>Enter product quantity* :</td><td><s:textfield id="productQty" name="productQty"/></td></tr>
		<tr><td>Enter product brand* :</td><td><s:textfield id="productBrand" name="productBrand"/></td></tr>
		</table>
		
		<s:file name="userImage" label="User Image" placeholder="image" />
		
		<p>Select category</p><s:select name="category"
			headerValue="Select Category" list="%{productNames}" /><br />
		<p>Select condition</p><s:radio name="conditionID" label="Select condition" 
		list="#{'1':'New','2':'Used'}" value="1"/><br />

		<p>Enter more details about the product :</p>
		<br />
		
		<div id='TextBoxesGroup'>
			<div id="TextBoxDiv1">
				<label>Attribute #1 : </label>
				<input type='text' id='attr1'>
				<input type='text' id='val1'>
			</div>
		</div>
		<input type='button' value='Add attribute' id='addButton'>
		<input type='button' value='Remove attribute' id='removeButton'>
		<s:hidden id="attrVals" name="attrVals" value="default value"/>
		<s:submit></s:submit>
		<script>
			$('#myForm').submit(function() {
				var productName = $("#productName").val();
				var productPrice = $("#productPrice").val();
				var productQty = $("#productQty").val();
				var productBrand = $("#productBrand").val();
				
				if(jQuery.trim(productName).length == 0 ||
					jQuery.trim(productPrice).length == 0 ||
					jQuery.trim(productQty).length == 0 ||
					jQuery.trim(productBrand).length == 0) {
					alert("All required fields not filled.");
					return false;
				}
				
				var msg = '';
				for (i=1; i<counter; i++) {
					
					if ($('#attr' + i).val().length <= 0){
						alert("Some fields are empty");
						return false;
					}
					msg += $('#attr' + i).val() + " : " + $('#val' + i).val() + "\n";
				}
				$('#attrVals').val(msg);
				return true;
			});
		</script>
	</form>
</body>
</html>
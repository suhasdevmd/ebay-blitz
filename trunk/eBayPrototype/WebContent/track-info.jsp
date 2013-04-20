<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>--!>

<!--<script>
	$(document).ready(function() {
		

		$("#myform #button").click(function() {
			
			document.myform.close();
		});
	});
</script>
!-->
<title>Tracking Information</title>
</head>
<body>
<p><h4>Tracking No <s:property value="trackingNo"/></h4>
<br>
<form name="myform">
<p>
<s:property value="trackingDetails"/>
</p>
<input type="button" id="button" value="close" onclick="self.close();" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" />
</title>
</head>
<body>


	<div style="margin-left: 100px;width: 1100px;">
		<tiles:insertAttribute name="HomePageHeader" />
	</div>

	<div  style="margin-left: 100px;width: 1100px;">
		<tiles:insertAttribute name="HomePageBody" />
	</div>

	<div  style="margin-left: 100px;width: 1100px;">
		<tiles:insertAttribute name="HomePageFooter" />
	</div>
</body>
</html>
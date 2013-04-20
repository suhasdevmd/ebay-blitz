<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Feedbacks</title>
</head>
<body>






	<table style="margin-left: 30px; margin-right: 20px;" border="1">

		<tr>
			<th align="center"><h3>Name</h3></th>
			<th align="center"><h3>Details</h3></th>
			<th align="center"><h3>Date</h3></th>
		</tr>
		<s:iterator value="feedbacks">
			<tr>
				<td><s:property value="username" /></td>

				<td><a
					href="viewfeedback.action?feedback_id=<s:property value = "feedbackID" />"><s:property
							value="details" />
				</a></td>
				<td><s:property value="date" /></td>
			</tr>
		</s:iterator>

	</table>



</body>
</html>
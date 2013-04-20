<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Category</title>

<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/simplePagination.css"/>
<script>

$(document).ready(function() {
    $("#catgory").pagination({
        items: 100,
        itemsOnPage: 4,
        cssStyle: 'light-theme'
    });
});

</script>
</head>
<body>


	<!-- Display all the category details  -->
	<div>
		Display Category details


		<s:form>

			<table
				style="border: 2px solid black; border-width: 1px; margin-bottom: 30px; padding: 5px;"
				align="center" id="catgory">

				<tr>
					<th align="center"><h3>Name</h3>
					</th>
					<th align="center"><h3>Has Child</h3>
					</th>
					<th align="center"><h3>Parent Category</h3>
					</th>
					<th align="center"><h3>Update</h3>
					</th>
					<th align="center"><h3>Delete</h3>
					</th>
				</tr>
				<s:iterator value="categories">
					<tr>
						<td><s:property value="name" />
						</td>

						<s:hidden value="phKey"></s:hidden>

						<%-- <td><a href="viewfeedback.action?feedback_id=<s:property value = "feedbackID" />">
					<s:property value="details" /> </a></td> --%>

						<td align="center"><s:property value="hasChild" />
						</td>
						<td align="center"><s:property value="parent" />
						</td>
						<td><a
							href="viewfeedback.action?phKey=<s:property value = "phKey" />">
								<s:property value="details" /> Update</a>
						</td>
						<td><a
							href="deleteCategory.action?phKey=<s:property value = "phKey" />">
								<s:property value="details" /> Delete</a>
						</td>
					</tr>
				</s:iterator>

			</table>
		</s:form>



	</div>

	<hr />


	<!-- Add category detail -->

	<s:form action="addCategory" method="POST">
		<div>
			Add Category details <br /> <br />

			<div>


				<div>
					<s:textfield name="addCategory" theme="simple"></s:textfield>
					<s:submit name="addCatgry" value="Add Category" theme="simple"></s:submit>
				</div>
			</div>

			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror />
				</div>
			</s:if>

		</div>
	</s:form>




	<hr />


	<!-- Add Sub category details  -->

	<s:form action="addSubCategory">
		<div>
			Add Subcategory details <br /> <br /> <br />
			<div>
				<s:select label="Select a Category" headerKey="-1"
					headerValue="Select Category" list="categoryList" name="category"
					value="2" theme="simple"/>


				<s:textfield name="subCategory" theme="simple"></s:textfield>
				<s:submit name="AddSubCategory" value="Add Sub Category"
					theme="simple"></s:submit>

			</div>
		</div>

	</s:form>
</body>
</html>
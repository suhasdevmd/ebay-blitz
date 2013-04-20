<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advanced Search </title>
<script>
function validate(id)
    {
	
      var obj=document.getElementById(id);
      if(obj.value)
      {
            if(isNaN(obj.value)) 
            {
               alert('Please enter only numbers');
                return;
            }

      }
    }
</script>
</head>
<body>
<s:form action="advanced-search" method="post">
<s:textfield label="ItemName" name="mysearch"  > </s:textfield>
<br>
<s:textfield label="Category" name="category" > </s:textfield>
<br>
<p>Enter the price range of the item to search for ::</p>
<s:textfield label="From Rs" name="from"  id="from" onchange="validate(this.id)"></s:textfield>
<s:textfield label="To Rs" name="to" id="to" onchange="validate(this.id)"></s:textfield>
<s:submit value="Search" name="search"></s:submit>
</s:form>
</body>
</html>
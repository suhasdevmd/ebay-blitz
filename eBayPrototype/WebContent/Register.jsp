<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register as an eBay member</title>

<script type="text/javascript">

   //Created / Generates the captcha function    
    function DrawCaptcha()
    {
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        var f = Math.ceil(Math.random() * 10)+ '';  
        var g = Math.ceil(Math.random() * 10)+ '';  
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("txtCaptcha").value = code;
    }

    // Validate the Entered input aganist the generated security code function   
    function ValidCaptcha(){
        
        if (str1 == str2) return true;        
        return false;
        
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
  
    function validateForm() {
    
		var val = true;
		var a = document.forms["myForm"]["firstName"].value;
		var b = document.forms["myForm"]["lastName"].value;
		var c = document.forms["myForm"]["address1"].value;
		var d = document.forms["myForm"]["city"].value;
		var e = document.forms["myForm"]["state"].value;
		var f = document.forms["myForm"]["pinCode"].value;
		var g = document.forms["myForm"]["telephone"].value;
		var h = document.forms["myForm"]["email"].value;
		var i = document.forms["myForm"]["re_enterEmail"].value;
		var j = document.forms["myForm"]["userName"].value;
		var k = document.forms["myForm"]["password"].value;
		var l = document.forms["myForm"]["re_enterPassword"].value;
		var m = document.forms["myForm"]["day"].value;
		var n = document.forms["myForm"]["month"].value;
        var o = document.forms["myForm"]["year"].value;
		var p = document.forms["myForm"]["secretQuestion"].value;
		var q = document.forms["myForm"]["secretAnswer"].value;
		var r = document.forms["myForm"]["country"].value;
		var s = document.forms["myForm"]["captcha"].value;
		var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('txtInput').value);
        var atpos=h.indexOf("@");
		var dotpos=h.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=h.length)
		  {
		  alert("Not a valid e-mail address");
		  val = false;
		  }
		if(g.length<10 || g.length>10)
		{
			  alert("Not a valid phone number");
			  val = false;
			  }
		if(h != i) {
			alert("The email addresses are not matching");
			val = false;
		}
		if(k != l) {
			alert("The passwords are not matching");
			val = false;
		}
		if(str1 != str2) {
			alert("Type the text as per the image shown");
			val = false;
		}
		if (a == null || a == "" || b == null || b == "" || d == null || d == "" || e == null || e == ""
			|| f == null || f == "" || g == null || g == "" || h == null ||
			h == "" || i == null || i == "" || j == null || j== "" || k == null
			|| k == "" || l == null || l == "" || m == null || m == "" || n == null
			|| n == "" || o == null || o == "" || p == null || p == "" || q == null || q == ""
            || r == "" || r == null || s == "" || s == null || document.myForm.ebayAgreement.Checked==false ||
			document.myForm.paisaPayAgreement.Checked==false) {
		alert("All required fields must be filled out");
		val = false;
	}
		return val;
		
	}
    
    </script>
</head>
<body onload="DrawCaptcha();">

	<s:form action="register.action" name="myForm" method="post"
		theme="simple" >
		<h2>Register as an eBay member</h2>
	Register now to bid, buy or sell on eBay. It's easy and free.
	<br>
		<br>
	Already registered or want to change your account info? <a
			href="loginfirst.action">Sign in now</a>
		<br>
		<br>
		<h3 style="display: inline;">Tell us about yourself</h3> - All fields are required
	<br>
		<br>
		<table>
			<tr>
				<td>First name</td>
				<td>Last name</td>
			</tr>

			<tr>
				<td><s:textfield name="firstName" required="true" /></td>
				<td><s:textfield name="lastName" required="true" /></td>
			</tr>
			<tr>
				<td>Home address</td>
			</tr>
			<tr>
				<td><s:textfield name="address1" required="true" /></td>
			</tr>
			<tr>
				<td><s:textfield name="address2" /></td>
			</tr>
			<tr>
				<td>City</td>
			</tr>
			<tr>
				<td><s:textfield name="city" required="true" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td>Pin Code</td>
				<td>Country or region</td>
			</tr>
			<tr>
				<td><s:select label="State" headerKey="Select your state"
						headerValue="Select your state"
						list="{'Andaman and Nicobar Islands', 'Andhra Pradesh', 'Arunachal Pradesh', 'Assam', 'Bihar', 'Chandigarh', 'Delhi', 'Gujarat', 'Haryana', 'Himachal Pradesh', 'Jammu and Kashmir', 'Karnataka', 'Kerala', 'Madhya Pradesh', 'Punjab', 'Rajasthan', 'Sikkim', 'TamilNadu', 'Uttar Pradesh', 'West Bengal'}"
						name="state">
					</s:select>
				</td>
				<td><s:textfield name="pinCode" required="true" />
				</td>
				<td><s:select label="Country" headerKey="Country"
						headerValue="India"
						list="{'Pakistan', 'Sri Lanka', 'United States', 'United Kingdom', 'Canada', 'Afghanistan', 'Australia', 'Bangladesh', 'Belgium', 'Brazil', 'China', 'France', 'Germany', 'Kenya', 'South Africa'}"
						name="country">
					</s:select><br>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><h6>Example:400050</h6>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>Primary telephone number</td>
			</tr>
			<tr>
				<td><s:textfield name="telephone" />
				</td>
			</tr>
			<tr>
				<td>Example: 09812345678 for Mobile</td>
				<td>or 022 25123456 for Landline</td>
			</tr>
			<tr>
				<td>We will contact you if we have quest</td>
				<td>ions about your account</td>
			</tr>
			<tr></tr>
			<tr>
				<td>Email address</td>
			</tr>
			<tr>
				<td><s:textfield name="email" />
				</td>
			</tr>
			<tr>
				<td>Re-enter your email address</td>
			</tr>
			<tr>
				<td><s:textfield name="re_enterEmail" />
				</td>
			</tr>
			<tr>
				<td>Please use a valid email address that</td>
				<td>you frequently access.</td>
			</tr>
		</table>
		<br>
		<h3 style="display: inline;">Choose your user ID and password</h3> - All fields are required
		<br>
		<br>
		<table>
			<tr>
				<td>Create your eBay user ID</td>
			</tr>
			<tr>
				<td><s:textfield name="userName" />
				</td>
			</tr>
			<tr>
				<td>Use letters or numbers, but not ( )</td>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Create your password</td>
			</tr>
			<tr>
				<td><s:password name="password" />
				</td>
			</tr>
			<tr>
				<td>caSe sensiTive.</td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Re-enter your password</td>
			</tr>
			<tr>
				<td><s:password name="re_enterPassword" />
				</td>
			</tr>
			<tr>
				<td>Pick a secret question</td>
			</tr>
			<tr>
			<tr>
				<td><s:select label="secretQuestion"
						headerKey="Select your secret question"
						headerValue="Select your secret question"
						list="{'Who is your favourite cricket player?', 'What is your mother`s maiden name?', 'Who is your favourite film star?', 'What is the name of your first school', 'What is your pet`s name'}"
						name="secretQuestion">
					</s:select>
				</td>
			</tr>
			<tr>
				<td>Your secret answer</td>
			</tr>
			<tr>
				<td><s:textfield name="secretAnswer" />
				</td>
			</tr>
			<tr>
				<td>If you forget your password, we'll verify your identity
					with your secret question</td>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Your date of birth</td>
				<td></td>
			</tr>
 <tr>
				<td>
					<s:select label="day" headerKey="--Day--"
						headerValue="--Day--"
						list="{'01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', 
						        '12', '13', '14', '15', '16', '17', '18', '19', '20',
						        '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'}"
						name="day">
					</s:select> <s:select label="month" headerKey="--Month--"
						headerValue="--Month--"
						list="{'01', '02', '03', '04', '05', '06', '07',
						       '08', '09', '10', '11', '12'}"
						name="month">
					</s:select> <s:select label="year" headerKey="--Year--" headerValue="--Year--"
						list="{'1975', '1976', '1977', '1978', '1979', '1980', '1981', '1982', '1983',
						        '1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992',
						         '1993', '1994', '1995'}"
						name="year">
					</s:select>
				</td>
			</tr>

			<tr>
				<td>You must be at least 18 years old to use eBay.</td>
			</tr>
		</table>
		<br>
		<h3>Terms of use and your privacy</h3>
		<br>
		For added security, please enter the verification code hidden in the image.
		<br>
		<br>
		<table>
			<tr>
				<td><s:textfield id="txtCaptcha"
						style="background-image:url(1.jpg); text-align:center; border:none;
            font-weight:bold; font-family:Modern" />
					<s:textfield id="txtInput" name="captcha" /></td>
			</tr>
			<tr>
				<td><input type="button" id="btnrefresh" value="Refresh"
						name="commandButton" onclick="DrawCaptcha();" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<br>
		<b><u>eBay User Agreement, the eBay Rules and Policies and the
				Privacy Policy</u>
		</b>
		<br>
		<br>
		<b>Please check the box below:</b>
		<br>
		<s:checkbox name="eBayAgreement" fieldValue="true" />
		<br>
That by clicking on the box I agree that I have read and understood the eBay User Agreement, the eBay <br>
Rules & Policies & the Privacy Policy (hereinafter referred as the "User Agreement & eBay Policies")<br>
 and unconditionally accept to be legally bound by the following:<br>
		<br>
1) That I have had reasonable opportunity and time to read, understand and take proper advice;<br>
2) That while using the services & facilities on the eBay Website www.ebay.in, I unequivocally<br>
   &nbsp;&nbsp;&nbsp;&nbsp;agree & undertake to abide by and comply with the User Agreement & eBay Policies;<br>
3) I agree that the User Agreement & eBay Policies are in all respects fair, reasonable and<br>
   &nbsp;&nbsp;&nbsp;&nbsp;necessary in order to protect the users of www.ebay.in and the legitimate business interests of<br>
   &nbsp;&nbsp;&nbsp;&nbsp;eBay;<br>
4) I agree that I have provided true, accurate, current and complete information about myself as<br>
   &nbsp;&nbsp;&nbsp;&nbsp;prompted by eBay's registration form (such information being the "Registration Data") and<br>
   &nbsp;&nbsp;&nbsp;&nbsp;nothing contained therein is false, inaccurate or misleading;<br>
5) I agree that eBay is only providing a platform for communication and it is agreed that the contract<br>
   &nbsp;&nbsp;&nbsp;for sale of any of the products or services shall be a strictly bipartite contract between myself and<br>
   &nbsp;&nbsp;&nbsp;other registered Users;<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - I accept that the manner, terms and conditions of delivery, payment, insurance etc. are to be<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;independently agreed upon when transacting with the other registered Users;<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - At no time shall any right, title or interest over the items vest with eBay nor shall eBay have<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;any obligations or liabilities in respect of such contract;<br>
6) I understand that the information I provide will be collected by eBay India Private Ltd and stored<br>
   &nbsp;&nbsp;&nbsp;&nbsp;and processed by eBay Inc. located San Jose, CA, USA;<br>
		<br>
		<b><u>PaisaPay User Agreement</u>
		</b>
		<br>
		<br>
		<b>Please check the box below:</b>
		<br>
		<s:checkbox name="paisaPayAgreement" fieldValue="true" />
		<br>
That by clicking on the box I agree that I have read and understood the PaisaPay User Agreement<br>
(hereinafter referred as the ("PaisaPay UA") and unconditionally accept to be legally bound by the<br>
following:<br>
		<br>
1) That my acceptance of the PaisaPay UA has been given of my own free will after having<br>
   &nbsp;&nbsp;&nbsp;&nbsp;reasonable opportunity and time to read, understand and take proper advice;<br>
2) That while using PaisaPay services, I unequivocally agree & undertake to abide by and comply<br>
   &nbsp;&nbsp;&nbsp;&nbsp;with the PaisaPay UA.<br>
3) I agree that the PaisaPay UA are in all respects fair, reasonable and necessary in order to<br>
   &nbsp;&nbsp;&nbsp;&nbsp;protect the users of PaisaPay services and the legitimate business interests of PaisaPay;<br>
4) I agree that PaisaPay is only a service provider and is not responsible for any non-performance or<br>
   &nbsp;&nbsp;&nbsp;&nbsp;breach of contract between users of PaisaPay.<br>
		<br>
		<s:submit id="continue" name="commandButton" value="Continue" onclick="return validateForm();"/>
	</s:form>
</body>
</html>
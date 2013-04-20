<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tile Header</title>
<link rel="stylesheet" type="text/css" href="css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/hdr.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/dropdown.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* $(".admin").click(function() {
			var X = $(this).attr('id');

			if (X == 1) {
				$(".submenu").hide();
				$(this).attr('id', '0');
			} else {

				$(".submenu").show();
				$(this).attr('id', '1');
			}

		}); */

		
		//mouse over function
		
		
		$(".admin").mouseover(function() {
			var X = $(this).attr('id');

			if (X == 1) {
				$(".submenu").hide();
				$(this).attr('id', '0');
			} else {

				$(".submenu").show();
				$(this).attr('id', '1');
			}

		});

		
		$(".admin").mouseout(function(){
			$(".submenu").hide();
		  });
		
		
		//Mouseup textarea false
		$(".submenu").mouseup(function() {
			return false
		});
		$(".admin").mouseup(function() {
			return false
		});

		//Textarea without editing.
		$(document).mouseup(function() {
			$(".submenu").hide();
			$(".admin").attr('id', '');
		});

	});
</script>


</head>
<body>


	<div>
		<div class="pcontent">
			<div>


				<a class="gh-hdn" href="#mainContent">Skip to main content</a>
				<div id="gh" class="gh-wgh-site-203">
					<table id="gh-t">
						<tbody>
							<tr>
								<td id="gh-l"><a href="homepage.action" id="gh-la">eBay<img alt=""
										src="img/padding.gif" id="gh-logo" border="0"> </a>
								</td>





								<td id="gh-u"><s:if test="#session.login">

										<span id="gh-ug">Hi, <b><s:property value="%{#session.userdetails.firstName}"/></b>! (<a
											class="gh-a"
											href="signoutaction"
											rel="nofollow">Sign out</a>)</span>
										<!--bucks-->
										<span id="gh-um"> </span>

									</s:if> <s:else>
										<span id="gh-ug">Welcome! <a class="gh-a"
											href="loginfirst.action" rel="nofollow">Sign in</a> or <a
											class="gh-a" href="registration.action" id="registerLink"
											rel="nofollow">register</a>.</span>


									</s:else></td>







							</tr>
						</tbody>
					</table>




					<div style="float: left; clear: both;">
						<ul id="gh-eb" class="gh-clearfix">
							<li class="gh-eb-li" id="gh-eb-My"><a class="gh-eb-li-a"
								href="myEbay.action">My eBay</a>
							</li>
							<li class="gh-eb-li" id="gh-eb-paisapay"><a
								class="gh-eb-li-a" href="deals.action">Deals</a>
							</li>
							<li class="gh-eb-li" id="gh-eb-Sell"><a class="gh-eb-li-a"
								href="seller.action">Sell</a>
							</li>
					
							
							<s:if test="%{#session.userdetails.role == 'admin'}">

							<li class="gh-eb-li" id="gh-eb-Cust"><a class="gh-eb-li-a"
								href="adminhome.action?value=admin">Administration</a>
							</li>
	
							</s:if>

							<!-- <li class="gh-eb-li" id="gh-eb-Cust"><a class="gh-eb-li-a"
							href="adminFunction.action">Admin</a>
						</li>
 -->



							<!-- <div class="dropdown"> 
							<a class="admin"> <span>Administration1</span> </a>
							<div class="submenu" style="display: none;">

								<ul class="root">
									<li><a href="#manageusers">Manage Users</a>
									</li>


									<li><a href="#managecategories">Manage Categories</a>
									</li>
									<li><a href="#viewfeedback">View FeedBacks</a>
									</li>

								</ul>
							</div>
					 </div> -->
							<li class="gh-eb-li gh-eb-li-last" id="gh-cart"><a
								class="gh-eb-li-a" href="cart.action">Cart</a>
							</li>
						</ul>
					</div>
					<div class="gh-sbox gh-clearfix" id="_nkw">
						<form action="getsearch" method="get" id="gh-f">
							<s:textfield name="mysearch" id="mysearch" />
							<s:select list="%{#session.categoryList}" name="category"
								id="category" headerKey="-1" headerValue="--All Categories--" />
							<!-- 
							<input name="_nkw" id="gh-ac" value=""
								title="Enter your search keyword" maxlength="300" size="50"
								class="gh-tb" type="text"><select name="_sacat"
								id="gh-cat" size="1" class="gh-sb"
								title="Select a category for search"><option value="0"
									selected="selected">All Categories &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; &nbsp;</option>
								<option value="293">Audio &amp; Home Entertainment</option>
								<option value="131090">Auto Accessories &amp; Parts</option>
								<option value="267">Books &amp; Magazines</option>
								<option value="625">Cameras &amp; Optics</option>
								<option value="9800">Cars &amp; Bikes</option>
								<option value="116365">Charity</option>
								<option value="11450">Clothing &amp; Accessories</option>
								<option value="11116">Coins &amp; Notes</option>
								<option value="1">Collectibles</option>
								<option value="13361">Fitness &amp; Sports</option>
								<option value="1249">Games, Consoles &amp; Accessories</option>
								<option value="11700">Home &amp; Kitchen</option>
								<option value="20710">Home Appliances</option>
								<option value="281">Jewellery &amp; Diamonds</option>
								<option value="160">Laptops &amp; Computer Peripherals</option>
								<option value="11071">LCD, LED &amp; Televisions</option>
								<option value="162260">Memory Cards, Pen Drives &amp;
									HDD</option>
								<option value="14416">Mobile Accessories</option>
								<option value="15032">Mobile Phones</option>
								<option value="11232">Movies &amp; Music</option>
								<option value="619">Musical Instruments</option>
								<option value="26395">Perfumes, Cosmetics &amp; Health</option>
								<option value="174982">Shoes &amp; Other Footwear</option>
								<option value="169977">Stamps</option>
								<option value="92470">Stationery &amp; Office Supplies</option>
								<option value="631">Tools &amp; Hardware</option>
								<option value="220">Toys, Games &amp; Baby</option>
								<option value="14324">Watches</option>
								<option value="99">Everything Else</option>
							</select>-->
							<input value="Search" id="gh-btn" type="submit" _sp="m570.l1313"
								style="display: inline-block;"><a
								title="Advanced search" id="gh-advS" _sp="m570.l2614"
								href="getsearch?mychoice=advancedSearch">Advanced search</a><input
								type="hidden" name="_from" value="R40">
						</form>
					</div>



					<div class="gh-cb">
						<b class="gh-cb1"></b><b class="gh-cb2"></b><b class="gh-cb3"></b><b
							class="gh-cb4"></b>
					</div>
				</div>
				<a name="mainContent"></a>

			</div>

		</div>
	</div>



</body>
</html>
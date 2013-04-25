<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<%-- <script>
	$(document).ready(function() {
		$(".divSubMenu").hide();
	
		$('#MainCategoryMenu').each(function(){
			$("#MainCategoryMenu").hover(function() {
				$("#divSubMenu").slideToggle('slow');
				}, function() {
				$("#divSubMenu").hide();
			});
		});
	});
</script> --%>

<!-- DYNAMIC DROP DOWN MENU CSS STARTS HERE -->
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/header.css">

<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
<script src="jquery-1.9.1.js"></script>
<script src="ui/jquery.ui.core.js"></script>
<script src="ui/jquery.ui.widget.js"></script>
<script src="ui/jquery.ui.mouse.js"></script>
<script src="ui/jquery.ui.button.js"></script>
<script src="ui/jquery.ui.draggable.js"></script>
<script src="ui/jquery.ui.position.js"></script>
<script src="ui/jquery.ui.resizable.js"></script>
<script src="ui/jquery.ui.button.js"></script>
<script src="ui/jquery.ui.dialog.js"></script>
<link rel="stylesheet" href="demos.css">
<script>
	$(document).ready(function() {

		$('#dialog-message').hide();
		
		$('#product').click(function() {
			$('#dialog-message').slideToggle('slow');
		});
	});

	/* $(document).ready(function(){
	 $("#dialog-message").dialog({
	 modal : true,
	 buttons : {
	 OK : function() {
	 $(this).dialog("close");
	 }
	 }
	 });
	 }); */
</script>

<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<!-- 
      jQuery-menu-aim: the following styles are used to customize bootstrap's
      dropdowns and popover to play a little nicer w/ this example. They are
      personal choices and not necessary for your use of jQuery-menu-aim.
      jQuery-menu-aim is HTML/style-agnostic, it simply fires events when menu
      items should be activated.
      You can choose to do whatever you want w/ those events.
    -->
<style>
.MainCategoryMenu{
	margin-left: 20px;
	margin-top: 20px;
}
.divSubMenu{
	position: relative;
	margin-left: 3em;
	display: block;
} 

#divSubSubMenu{
	position: relative;
	margin-left: 3em;
	display: block;
}

.popover {
	width: 400px;
	-webkit-border-top-left-radius: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-top-left-radius: 0px;
	border-bottom-left-radius: 0px;
	overflow: hidden;
}

.popover-content {
	text-align: center;
}

.popover-content img {
	height: 212px;
	max-width: 250px;
}

.dropdown-menu>li>a:hover {
	background-image: none;
	color: white;
	background-color: rgb(0, 129, 194);
	background-color: rgba(0, 129, 194, 0.5);
}

.dropdown-menu>li>a.maintainHover {
	color: white;
	background-color: #0081C2;
}
</style>

<!-- DYNAMIC DROP DOWN MENU CSS ENDS HERE -->

<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
#hpFeaturedItems {
	width: 615px
}

#hpFeaturedItems .titleBar {
	height: 30px;
	background-color: #fc0
}

#hpFeaturedItems .titleBarLeft {
	background: transparent url(img/panel_transparent.gif) no-repeat scroll
		top left;
	float: left;
	margin-left: 0;
	padding-left: 15px
}

#hpFeaturedItems .titleBarRight {
	background: transparent url(img/panel_transparent.gif) no-repeat scroll
		top right;
	margin-right: 0;
	padding-right: 15px
}

#hpFeaturedItems .titleText {
	color: #5d5d5d;
	font-size: medium;
	font-family: Arial;
	font-weight: Bold;
	padding-top: 5px
}

#hpFeaturedItems .contentContainerText {
	padding: 13px 15px 0 15px
}

* html #hpFeaturedItems .contentContainerText {
	width: 95%
}

#hpFeaturedItems .contentContainerImg {
	padding: 10px 15px 0 15px
}

* html #hpFeaturedItems .contentContainerImg {
	width: 95%
}

#hpFeaturedItems .textViewLeft {
	padding: 0;
	margin: 0;
	float: left;
	width: 284px;
	overflow: hidden
}

#hpFeaturedItems .textViewRight {
	padding: 0;
	margin-left: 15px;
	margin-top: 0;
	margin-bottom: 0;
	float: left;
	width: 284px;
	overflow: hidden
}

#hpFeaturedItems .textViewClear {
	clear: both;
	visibility: hidden;
	height: 1px
}

#hpFeaturedItems .textViewContent {
	color: #00f;
	font-size: small;
	font-family: Arial
}

#hpFeaturedItems .textViewList {
	margin-left: 15px;
	margin-top: 0;
	margin-bottom: 0;
	padding: 0;
	text-align: left
}

#hpFeaturedItems .bottomBar {
	width: 100%;
	text-align: right;
	height: 15px;
	border-top: 1px solid #dedede
}

#hpFeaturedItems .imgViewItem {
	width: 112px;
	float: left;
	font-size: small;
	font-family: Arial;
	color: #00f;
	overflow: hidden
}

#hpFeaturedItems .imgViewItemSpace {
	padding-left: 5px
}

#hpFeaturedItems .imgContainer {
	height: 64px;
	width: 64px;
	border: 1px solid #666;
	margin: 0;
	padding: 0;
	text-align: center;
	vertical-align: middle;
	overflow: hidden
}

#hpFeaturedItems .imgViewItem a {
	text-decoration: none
}

#hpFeaturedItems .imgViewItem a:hover {
	text-decoration: underline
}

#hpFeaturedItems .imgViewItemTitle {
	padding-top: 5px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eBay India - Online Shopping Mall: Free Auctions,
	Shop/Buy/Sell Mobiles, Cameras, Apparel, Computers, Bollywood Clothes
	&amp; Indian Products</title>
</head>

<body id="body">






<div style="margin-left: 30px;margin-top: 5px;color: black; box-shadow: 0 10px 6px -6px #777;background: #DBE1E1;width: 300px;">
	<s:if test="pd.size() > 0">


		<div id="product" style="margin-left: 30px;font-size: 15px;">Product Out of Stock</div>

		<div id="dialog-message" title="Product Out of stock" style="margin-left: 30px;">
			<p>
				<span class="ui-icon ui-icon-circle-check"
					style="float: left; margin: 0 7px 50px 0;"></span> The following
				products sold by you are out of stock.
			</p>
			<p>
				Kindly look into this and <b> make sure the product is available</b>.



			</p>
			<p>


				<s:iterator var="i" step="1" value="pd" status="v">
					<s:property value="#v.count" />.
				<s:property></s:property>
					<br />
				</s:iterator>

			</p>
		</div>

	</s:if>

</div>










	<div></div>
	<div align="center">


		<div class="ContentContainer" id="TopContainer">

			<div>
				<div class="pcontent">
					<div>

						<a class="gh-hdn" href="#mainContent">Skip to main content</a>
						<div id=gh class="gh-w gh-site-203">

							<table id=gh-t>
								<tr>
									<td id=gh-l><a href="" id=gh-la>eBay<img alt=""
											src="img/padding.gif" id="gh-logo" border="0"> </a></td>


									<%-- <s:if test="%{#session.login == true}"></s:if> --%>


									<td id="gh-u"><s:if test="#session.login">

											<span id="gh-ug">Hi, <b><s:property
														value="%{#session.userdetails.firstName}" /> </b>! (<a
												class="gh-a" href="signoutaction" rel="nofollow">Sign
													out</a>) </span>
											<!--bucks-->
											<span id="gh-um"> </span>

										</s:if> <s:else>
											<span id="gh-ug">Welcome! <a class="gh-a"
												href="loginfirst.action" rel="nofollow">Sign in</a> or <a
												class="gh-a" href="registration.action" id="registerLink"
												rel="nofollow">register</a>. </span>


										</s:else></td>

								</tr>
							</table>

							<ul id=gh-eb class=gh-clearfix>
								<li class=gh-eb-li id=gh-eb-My><a class="gh-eb-li-a"
									href="myEbay.action">My eBay</a></li>
								<li class=gh-eb-li id=gh-eb-Sell><a class="gh-eb-li-a"
									href="seller.action">Sell</a></li>

								<s:if test="%{#session.userdetails.role == 'admin'}">

									<li class="gh-eb-li" id="gh-eb-Cust"><a class="gh-eb-li-a"
										href="adminhome.action?value=admin">Administration</a></li>

								</s:if>


								<!-- <li class=gh-eb-li id=gh-eb-Cust><a class="gh-eb-li-a"
									href="loginfirst.action">Sign In</a></li> -->

								<li class=gh-eb-li id=gh-cart><a class="gh-eb-li-a"
									href="cart.action">Cart</a></li>
							</ul>
							<div class="gh-sbox gh-clearfix" id=_nkw>
								<!-- THE MAIN SEARCH BAR -->
								<form action="getsearch" method="get" id=gh-f>
									<s:textfield name="mysearch" id="mysearch" />
									<s:select list="%{#session.categoryList}" name="category"
										id="category" headerKey="-1" headerValue="--All Categories--" />








									<!-- 
									<input autocomplete=on name=_nkw id=gh-ac value=""
										title="Enter your search keyword" maxlength=300 size=50
										class=gh-tb type=text> <select name=_sacat id=gh-cat
										size=1 class=gh-sb title="Select a category for search">
										<option value="0" selected="selected">All Categories
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</option>
									</select>-->
									<input value="Search" id=gh-btn type=submit /> <a
										title="Advanced search" id="gh-advS"
										href="getsearch?mychoice=advancedSearch">Advanced search</a>
								</form>
							</div>

							<ul class="gh-nav gh-clearfix">
								<li class="gh-nav-li"><p class="gh-nav-li-a">CATEGORIES</p>
								</li>

								<!-- ####################DYNAMIC DROPDOWN CODE STARTS HERE##################### -->
								<div class="nav-collapse collapse">
									<ul class="nav">
										<li class="active gh-nav-li" id="gh-nav-arw"><a
											class="dropdown-toggle gh-nav-li-a" data-toggle="dropdown"
											href="#"><b id=gh-nav-arwb>&nbsp;</b> </a> <!-- jQuery-menu-aim: this <ul> defines the dropdown main menu and its contents.
							                  This is just one of many possible examples for defining the menu's HTML.
							                  jQuery-menu-aim is agnostic to your HTML structure, it only fires events to
							                  be used as you please. -->

											<ul class="dropdown-menu" role="menu">

												<s:iterator value="%{#session.homepageMenu}" var="mainMenu"
													status="stat">
													<div id="MainCategoryMenu" class="MainCategoryMenu">

														<li data-submenu-id="menu"><s:property
																value="baseCategory" /></li>
														<div id="divSubMenu" class="divSubMenu">
															<ul>

																<s:iterator value="#mainMenu.childCategory"
																	var="subMenu" status="stat">

																	<s:iterator>

																		<li data-submenu-id="submenu"><a
																			href="categories.action?CategoryID=<s:property value="#subMenu.key" />">
																				<s:property value="#subMenu.value.baseCategory" />
																		</a></li>

																		<!-- Level2 Starts-->
																		<div id="divSubSubMenu">
																			<s:iterator value="#subMenu.value.childCategory"
																				var="subSubMenu" status="stat">
																				<s:iterator>
																					<li data-submenu-id="subsubmenu"><a
																						href="categories.action?CategoryID=<s:property value="#subSubMenu.key" />">
																							<s:property
																								value="#subSubMenu.value.baseCategory" /> </a></li>

																					<!-- Level3 Starts-->
																					<div id="divSubSubMenu">
																						<s:iterator
																							value="#subSubMenu.value.childCategory"
																							var="level3Menu" status="stat">
																							<s:iterator>
																								<li data-submenu-id="level3Menu"><a
																									href="categories.action?CategoryID=<s:property value="#level3Menu.key" />">
																										<s:property
																											value="#level3Menu.value.baseCategory" /> </a></li>
																							</s:iterator>
																						</s:iterator>
																					</div>
																					<!-- Level3 Ends-->

																				</s:iterator>
																			</s:iterator>
																		</div>
																		<!-- Level2 Ends-->

																	</s:iterator>

																</s:iterator>

															</ul>
														</div>
													</div>
												</s:iterator>


											</ul></li>
									</ul>
								</div>

								<!-- DYNAMIC DROPDOWN CODE ENDS HERE -->

								<!-- <li class="gh-nav-li"><a class="gh-nav-li-a" href="">GLOBAL
										EASYBUY</a></li>
								<li class="gh-nav-li"><a class="gh-nav-li-a" href="">FASHION</a>
								</li>
								<li class="gh-nav-li"><a target="_blank"
									class="gh-nav-li-a" href="">HOLIDAYS</a></li>
								<li class="gh-nav-li"><a target="_blank"
									class="gh-nav-li-a" href="">INSURANCE</a></li>  -->
								<li class="gh-nav-li"><a target="_blank"
									class="gh-nav-li-a" href="deals.action">DEALS</a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>



			<div>
				<a href="deals.action"> <img alt="" src="img/DOW_1104113.jpg">
				</a>
			</div>

			<br />
			<div></div>
			<div>
				<div class="pcontent">
					<div id="categories">
						<div id="categories">
							<div>
								<div>
									<div>
										<div class="r3 c gy-br">
											<div class="gy">
												<div>
													<div class="r3_hm"
														style="border-width: 1px 1px 0; padding: 0; height: 5px; font-size: 0; overflow: hidden;"></div>
												</div>
												<div class="r3_hm">
													<div>
														<h2 class="g-m g-m0">eBay Categories</h2>
													</div>
												</div>
											</div>
											<div class="r3_c c-sgf">
												<div class="r3_cm po">
													<div>
														<div>
															<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<!-- <td valign="top" class="catContent"><h3>
																			<a title="Clothing &amp; Accessories" href="">Clothing
																				&amp; Accessories</a>
																		</h3> <br>
																		<h3>
																			<a title="Shoes &amp; Other Footwear" href="">Shoes
																				&amp; Other Footwear</a>
																		</h3> <br>
																		<h3>
																			<a title="Auto Accessories &amp; Parts" href="">Auto
																				Accessories &amp; Parts</a>
																		</h3> <br>
																		<h3>
																			<a title="Books &amp; Magazines" href="">Books
																				&amp; Magazines</a>
																		</h3> <br>
																		<h3>
																			<a title="Cameras &amp; Optics" href="">Cameras
																				&amp; Optics</a>
																		</h3> <br>
																		<h3>
																			<a title="Cars, Bikes &amp; CVs" href="">Cars,
																				Bikes &amp; CVs</a>
																		</h3> <br>
																		<h3>
																			<a title="Coins &amp; Notes" href="">Coins &amp;
																				Notes</a>
																		</h3> <br>
																		<h3>
																			<a title="Collectibles" href="">Collectibles</a>
																		</h3> <br></td>
																	<td valign="top" class="catContent"><h3>
																			<a title="Consumer Electronics" href="">Consumer
																				Electronics</a>
																		</h3> <br>
																		<h3>
																			<a title="Fitness &amp; Sports" href="">Fitness
																				&amp; Sports</a>
																		</h3> <br>
																		<h3>
																			<a title="Fun Stuff" href="">Fun Stuff</a>
																		</h3> <br>
																		<h3>
																			<a title="Home, Decor &amp; Furnishings" href="">Home
																				&amp; Kitchen</a>
																		</h3> <br>
																		<h3>
																			<a title="Jewellery &amp; Diamonds" href="">Jewellery
																				&amp; Diamonds</a>
																		</h3> <br>
																		<h3>
																			<a title="Kitchen &amp; Home Appliances" href="">Home
																				Appliances</a>
																		</h3> <br>
																		<h3>
																			<a title="Laptops &amp; Computer Peripherals" href="">Laptops
																				&amp; Computer Peripherals</a>
																		</h3> <br>
																		<h3>
																			<a title="LCD, LED &amp; Plasma Television" href="">LCD,
																				LED &amp; Plasma Television</a>
																		</h3> <br></td>
																	<td valign="top" class="catContent"><h3>
																			<a title="Memory Cards, Pen Drives &amp; HDD" href="">Memory
																				Cards, Pen Drives &amp; HDD</a>
																		</h3> <br>
																		<h3>
																			<a title="Mobile Accessories" href="">Mobile
																				Accessories</a>
																		</h3> <br>
																		<h3>
																			<a title="Mobile Phones" href="">Mobile Phones</a>
																		</h3> <br>
																		<h3>
																			<a title="Movies &amp; Music" href="">Movies
																				&amp; Music</a>
																		</h3> <br>
																		<h3>
																			<a title="Musical Instruments" href="">Musical
																				Instruments</a>
																		</h3> <br>
																		<h3>
																			<a title="Perfumes, Cosmetics &amp; Health" href="">Perfumes,
																				Cosmetics &amp; Health</a>
																		</h3> <br>
																		<h3>
																			<a title="Services &amp; Real Estate" href="">Services
																				&amp; Real Estate</a>
																		</h3> <br>
																		<h3>
																			<a title="Stamps" href="">Stamps</a>
																		</h3> <br></td>
																	<td valign="top" class="catContent"><h3>
																			<a title="Stationery &amp; Office Supplies" href="">Stationery
																				&amp; Office Supplies</a>
																		</h3> <br>
																		<h3>
																			<a title="Tools &amp; Office Supplies" href="">Tools
																				&amp; Hardware</a>
																		</h3> <br>
																		<h3>
																			<a title="Toys, Games &amp; Baby" href="">Toys,
																				Games &amp; Baby</a>
																		</h3> <br>
																		<h3>
																			<a title="Travel" href="">Travel</a>
																		</h3> <br>
																		<h3>
																			<a title="Video &amp; Computer Games" href="">Games,
																				Consoles &amp; Accessories</a>
																		</h3> <br>
																		<h3>
																			<a title="Watches" href="">Watches</a>
																		</h3> <br>
																		<h3>
																			<a title="Everything Else" href="">Everything
																				Else</a>
																		</h3> <br></td> -->
																	<td valign="top" class="catContent"><h3>
																			<a title="Mobiles"
																				href="categories.action?CategoryID=1">Mobiles</a>
																		</h3></td>
																	<td valign="top" class="catContent"><h3>
																			<a title="Movies"
																				href="categories.action?CategoryID=3">Movies</a>
																		</h3></td>
																	<td valign="top" class="catContent"><h3>
																			<a title="Books"
																				href="categories.action?CategoryID=2">Books</a>
																		</h3></td>
																</tr>
															</table>
														</div>
													</div>
												</div>
												<div class="r3_fm r3_s">
													<!-- <a href="">Visit all categories</a>  -->
												</div>
											</div>
										</div>
									</div>
								</div>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>








		<div class="ContentContainer" id="CenterContainer">

			<div class="WideSectionContainer" id="WideSectionContainer1">

				<div>
					<div class="pcontent">
						<div id="hpFeaturedItems">
							<div>
								<div>
									<div>
										<div class="r3 c gy-br">
											<div class="gy">
												<div class="r3_hm">
													<div>From our Sellers</div>
												</div>
											</div>
											<div class="r3_c c-sgf">
												<div class="r3_cm">
													<div>
														<div>
															<table>
																<tr>
																	<s:iterator value="#session.productData"
																		var="productData">
																		<td><div class="imgViewItem">
																				<!-- PUT THE IMAGES FOR THE PRODUCTS IN A DIV LIKE THIS -->
																				<img
																					src="productimages/<s:property value="image1"/>"
																					alt="Product Image" border="0" height="80px"
																					width="80px">
																				<div class="imgViewItemTitle">
																					<!-- PUT THE LINK FOR THE PRODUCT MENTIONED ABOVE -->
																					<a
																						href="products.action?productID=<s:property value="#productData.id"/>"><s:property
																							value="#productData.name" /> </a>
																				</div>
																			</div></td>
																	</s:iterator>
																</tr>
															</table>
														</div>
													</div>
												</div>
												<div class="r3_fm r3_s">
													<!-- <a href="">See all featured items</a> -->
												</div>
											</div>
										</div>
									</div>
								</div>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="ContentContainer ClearBoth" id="BottomContainer">
			<div>
				<div class="pcontent">
					<div class="hpf-cn">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="hpf-fs2">
								<td class="fcont_h">Inside eBay</td>
								<td class="fsep_w"></td>
								<td class="fcont_h">eBay sites</td>
								<td class="fsep_w"></td>
								<td class="fcont_h">Companies</td>
							</tr>
							<tr class="hpf-fs1">
								<td class="fcont_b"><div class="fnode">
										<div class="fnode_n">
											<div>
												<a title="Media Centre" href="">Media Centre</a>
											</div>
											<div>
												<a title="Sell Internationally" href="">Sell
													Internationally</a>
											</div>
											<div>
												<a title="Charity Fundraising" href="">Charity
													Fundraising</a>
											</div>
											<div>
												<a title="eBay Explained" href="">eBay Explained</a>
											</div>
											<div>
												<a title="Careers" href="">Careers</a>
											</div>
											<div>
												<a title="Affiliates" href="">Affiliates</a>
											</div>
											<div>
												<a title="Developers" href="">Developers</a>
											</div>
											<div>
												<a title="eBay Toolbar" href="">eBay Toolbar</a>
											</div>
											<div>
												<a title="VeRO" href="">VeRO</a>
											</div>
										</div>
									</div></td>
								<td class="fsep_g"></td>
								<td class="fcont_b"><div class="fnode">
										<div class="fnode_n">
											<div>
												<a title="Argentina Home Page" href="">Argentina</a>
											</div>
											<div>
												<a title="Australia Home Page" href="">Australia</a>
											</div>
											<div>
												<a title="">Austria</a>
											</div>
											<div>
												<a title="">Belgium</a>
											</div>
											<div>
												<a title="">Brazil</a>
											</div>
											<div>
												<a title="">Canada</a>
											</div>
											<div>
												<a title="">China</a>
											</div>
											<div>
												<a title="">France</a>
											</div>
											<div>
												<a title="">Germany</a>
											</div>
											<div>
												<a title="">Hong Kong</a>
											</div>
											<div>
												<a title="">India</a>
											</div>
											<div>
												<a title="">Ireland</a>
											</div>
										</div>
										<div class="fnode_n">
											<div>
												<a title="">Italy</a>
											</div>
											<div>
												<a title="">Korea</a>
											</div>
											<div>
												<a title="">Malaysia</a>
											</div>
											<div>
												<a title="">Mexico</a>
											</div>
											<div>
												<a title="">Netherlands</a>
											</div>
											<div>
												<a title="">New Zealand</a>
											</div>
											<div>
												<a title="">Philippines</a>
											</div>
											<div>
												<a title="">Poland</a>
											</div>
											<div>
												<a title="">Singapore</a>
											</div>
											<div>
												<a title="">Spain</a>
											</div>
											<div>
												<a title="">Sweden</a>
											</div>
											<div>
												<a title="">Switzerland</a>
											</div>
										</div>
										<div class="fnode_n">
											<div>
												<a title="">Taiwan</a>
											</div>
											<div>
												<a title="">Thailand</a>
											</div>
											<div>
												<a title="">Turkey</a>
											</div>
											<div>
												<a title="">United Kingdom</a>
											</div>
											<div>
												<a title="">United States</a>
											</div>
											<div>
												<a title="">Vietnam</a>
											</div>
										</div>
									</div></td>
								<td class="fsep_g"></td>
								<td class="fcont_b"><div class="fnode">
										<div class="fnode_n">
											<div>
												<a title="B2B Motors" href="">B2B Motors</a>
											</div>
											<div>
												<a title="India Export Bazaar" href="">India Export
													Bazaar</a>
											</div>
											<div>
												<a title="Safe Trading Tips" href="">Safe Trading Tips</a>
											</div>
											<div>
												<a title="Want It Now" href="">Want It Now</a>
											</div>
											<div>
												<a title="Media Centre" href="">Media Centre</a>
											</div>
											<div>
												<a title="eBay Shops" href="">eBay Shops</a>
											</div>
										</div>
									</div></td>
							</tr>
							<tr style="height: 25px"></tr>
						</table>
					</div>
				</div>
			</div>
			<div>
				<div class="pcontent">
					<div id=glbfooter class=coreFooterLinks>
						<div>
							<div id=rtm_html_1650 style="height: 0px; display: none;"></div>
							<div id=rtm_html_1651 style="height: 0px; display: none;"></div>
						</div>
						<table width="100%">
							<tr valign=top class=g-hlp>
								<td>2013 - Blitzstrahl</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
	<style type="text/css">
.c-sgf .r3_fm {
	padding-bottom: 8px !important;
	border-bottom: 1px solid #ccc !important
}
</style>

	<!-- DROPDOWN MENU'S SUB-CATEGORIES START HERE -->
	<!--
							      jQuery-menu-aim: the following defines each submenu's content. There are a million
							      and one ways to do this, places to structure the HTML, etc. This is just one example.
							      jQuery-menu-aim is agnostic to your HTML structure, it only fires events to be used
							      as you please.
							    -->
	<div id="submenu-patas" class="popover">
		<h3 class="popover-title">Patas</h3>
		<div class="popover-content">
			<img src="img/patas.png">
		</div>
	</div>
	<div id="submenu-snub-nosed" class="popover">
		<h3 class="popover-title">Golden Snub-Nosed</h3>
		<div class="popover-content">
			<img src="img/snub-nosed.png">
		</div>
	</div>
	<div id="submenu-duoc-langur" class="popover">
		<h3 class="popover-title">Duoc Langur</h3>
		<div class="popover-content">
			<img src="img/duoc-langur.png">
		</div>
	</div>
	<div id="submenu-pygmy" class="popover">
		<h3 class="popover-title">Baby Pygmy Marmoset</h3>
		<div class="popover-content">
			<img src="img/pygmy.png">
		</div>
	</div>
	<div id="submenu-tamarin" class="popover">
		<h3 class="popover-title">Black Lion Tamarin</h3>
		<div class="popover-content">
			<img src="img/tamarin.png">
		</div>
	</div>
	<div id="submenu-monk" class="popover">
		<h3 class="popover-title">Monk Saki</h3>
		<div class="popover-content">
			<img src="img/monk.png">
		</div>
	</div>
	<div id="submenu-gabon" class="popover">
		<h3 class="popover-title">Gabon</h3>
		<div class="popover-content">
			<img src="img/gabon.png">
		</div>
	</div>
	<div id="submenu-grivet" class="popover">
		<h3 class="popover-title">Grivet</h3>
		<div class="popover-content">
			<img src="img/grivet.png">
		</div>
	</div>
	<div id="submenu-red-leaf" class="popover">
		<h3 class="popover-title">Red Leaf</h3>
		<div class="popover-content">
			<img src="img/red-leaf.png">
		</div>
	</div>
	<div id="submenu-king-colobus" class="popover">
		<h3 class="popover-title">King Colobus</h3>
		<div class="popover-content">
			<img src="img/colobus.png">
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="JS/jquery.menu-aim.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		var $menu = $(".dropdown-menu");

		// jQuery-menu-aim: <meaningful part of the example>
		// Hook up events to be fired on menu row activation.
		$menu.menuAim({
			activate : activateSubmenu,
			deactivate : deactivateSubmenu
		});
		// jQuery-menu-aim: </meaningful part of the example>

		// jQuery-menu-aim: the following JS is used to show and hide the submenu
		// contents. Again, this can be done in any number of ways. jQuery-menu-aim
		// doesn't care how you do this, it just fires the activate and deactivate
		// events at the right times so you know when to show and hide your submenus.
		function activateSubmenu(row) {
			var $row = $(row), submenuId = $row.data("submenuId"), $submenu = $("#"
					+ submenuId), offset = $menu.offset(), height = $menu
					.outerHeight(), width = $menu.outerWidth();

			// Show the submenu
			$submenu.css({
				display : "block",
				top : offset.top,
				left : offset.left + width - 5, // main should overlay submenu
				height : height - 4
			// padding for main dropdown's arrow
			});

			// Keep the currently activated row's highlighted look
			$row.find("a").addClass("maintainHover");
		}

		function deactivateSubmenu(row) {
			var $row = $(row), submenuId = $row.data("submenuId"), $submenu = $("#"
					+ submenuId);

			// Hide the submenu and remove the row's highlighted look
			$submenu.css("display", "none");
			$row.find("a").removeClass("maintainHover");
		}

		$(document).click(function() {
			// Simply hide the submenu on any click. Again, this is just a hacked
			// together menu/submenu structure to show the use of jQuery-menu-aim.
			$(".popover").css("display", "none");
		});
	</script>
	<!-- DEROPDOWN MENU'S SUB-CATEGORIES END HERE -->
</body>
</html>

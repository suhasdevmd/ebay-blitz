<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select shipping and payment method</title>
<link rel="stylesheet" type="text/css"
	href="css/createorder/createorder.css">
<link rel="stylesheet" type="text/css" href="css/all.min.css">

<style type="text/css">
.sp-txt {
	font: normal 1.231em trebuchet, "trebuchet MS";
	float: left;
	color: #333;
	padding-right: 5px
}

.sp-w table {
	padding-top: 6px
}

.sp-w td {
	text-align: right;
	vertical-align: top
}

.sp-d,.sp-a,.sp-c {
	position: relative;
	margin-left: 4px;
	padding: 10px 0 0 29px;
	background: repeat-x 0 -263px;
	font: normal 1em arial
}

.sp-a,.sp-c {
	position: relative;
	margin-left: 4px;
	background: repeat-x 0 -33px;
	padding: 10px 3px 0 29px
}

.sp-d,.sp-a {
	color: #777
}

.sp-c {
	color: #333
}

.sp-c u {
	background: no-repeat 0 0;
	position: absolute;
	right: -1px;
	top: 0;
	width: 10px;
	height: 10px
}

.sp-d,.sp-a,.sp-c,.sp-c u {
	background-image:
		url(http://q.ebaystatic.com/aw/pics/cmp/ds2/sprSignPost.png)
}

.sp-bpd {
	padding-bottom: 20px
}

.btn-w,.btn-b,.btn-b input,.btn-b b,.btn-b a {
	background: transparent none no-repeat 0 0;
	height: 25px;
	display: inline-block;
	outline: none
}

.btn-w {
	text-align: left;
	height: 26px
}

.btn-p {
	padding: 0 8px 0 8px
}

.btn-h {
	display: none
}

.btn-m {
	margin: 8px 0
}

.btn-b {
	background-position: 100% -35px;
	padding: 0 3px 0 0;
	vertical-align: middle;
	z-index: 2
}

.btn-b input,.btn-b b,.btn-b a {
	border: 0;
	color: #fff;
	font: bold small Arial !important;
	padding: 2px 15px 3px;
	cursor: pointer;
	margin: 0 -3px;
	white-space: nowrap
}

.btn-bo {
	background-position: 100% -105px
}

.btn-bo input,.btn-bo a {
	background-position: 0 -70px
}

.btn-bp {
	background-position: 100% -175px
}

.btn-bp input,.btn-bp a {
	background-position: 0 -140px;
	padding: 3px 14px 2px 16px
}

.btn-bd {
	background-position: 100% -245px;
	cursor: default
}

.btn-bd input,.btn-bd b,.btn-bd a {
	background-position: 0 -210px;
	cursor: default;
	color: #f5f5f5
}

.btn-b b,.btn-b a {
	padding: 4px 17px 6px;
	height: auto
}

.btn-w,.btn-b,.btn-b b,.btn-b a {
	position: relative !important
}

.btn-b a,.btn-b a:hover,.btn-b a:visited,.btn-b a:active {
	text-decoration: none;
	color: #fff !important
}

.btn-b b {
	display: none
}

.btn-bp a {
	padding: 5px 16px 5px 18px
}

.btn-w i {
	background: #3c58c5 none repeat scroll 0 0;
	border: 2px outset;
	color: #3c58c5;
	margin: 1px 0 1px 4px;
	padding: 2px 5px 1px;
	position: absolute;
	white-space: nowrap;
	font-size: .923em
}

.pbn-P,.pbn-P input,.pbn-P b,.pbn-P a {
	background-image: url()
}

.sbn-S,.sbn-S input,.sbn-S b,.sbn-S a {
	background-image: url()
}

.coreFooterLinks a:active,.coreFooterLinks a:focus,.coreFooterLinks a:hover,.coreFooterLinks a:link
	{
	font-family: Verdana;
	font-size: x-small;
	color: #00c;
	display: inline-block
}

.gh-nav a:active,.gh-nav a:focus,.gh-nav a:hover,.gh-nav a:link {
	font-family: Arial;
	font-size: small;
	color: #333
}

.coreFooterLinks a:visited {
	font-family: Verdana;
	font-size: x-small
}

.coreFooterLegalNotice {
	font-family: Verdana;
	font-size: x-small;
	color: #666
}

.footerBG {
	padding: 1px 0 5px 0
}

.footerBGPost {
	padding: 1px 0 5px 0
}

.footerBG img,.footerBGPost img {
	margin-right: 6px
}

.footerBG .bgLinkTD,.footerBGPost .bgLinkTD {
	white-space: nowrap
}

.gh-vs {
	border: 1px solid #666;
	width: 340px;
	background-color: #efefef
}

.gh-vs .gh-cw {
	padding: 10px 0
}

.gh-vs .gh-cbtn {
	background-image: url();
	background-repeat: no-repeat;
	background-position: bottom left;
	background-color: transparent;
	cursor: pointer;
	display: inline;
	float: right;
	height: 16px;
	width: 16px;
	position: absolute;
	top: 10px;
	right: 5px;
	padding: 0
}

.gh-vs .gh-ttl {
	color: #333;
	font-weight: bold;
	font-size: medium;
	padding: 0 15px
}

.gh-vs .gh-ct {
	clear: both;
	padding: 10px 15px 0
}

.gh-hdn {
	font-size: 0;
	height: 0;
	margin-top: 10px;
	overflow: hidden;
	width: 0;
	visibility: hidden
}

.gh-fol {
	border: 1px solid #ccc;
	background-color: #fff;
	position: absolute;
	margin-top: -85px;
	padding: 10px;
	width: 250px;
	z-index: 10000;
	display: none
}

.gh-fol div {
	float: left;
	width: 234px
}

.gh-fol-a {
	float: left
}

.gh-fol a b {
	background: transparent url() no-repeat;
	width: 16px;
	height: 16px;
	display: block
}

.gh-ovr {
	position: absolute;
	left: -1000px;
	z-index: 10000
}

.gh-iovr {
	float: left;
	position: relative;
	background-color: #fff;
	border: 1px solid #ccc
}

.gh-ext {
	font-size: 0;
	margin-top: -1px;
	position: absolute;
	top: 0;
	left: 0;
	background: #fff;
	border-top: 1px solid #fff
}

.ebayfooter {
	font-family: Verdana;
	font-size: x-small;
	color: #666
}

.pagewidth {
	width: 100%;
	min-width: 760px
}

* html .pageminwidth {
	padding-left: 760px
}

* html .pagecontainer {
	margin-left: -760px;
	position: relative
}

* html .pageminwidth,* html .pagecontainer,* html .pagelayout {
	height: 1px
}

.brclear {
	clear: both;
	height: 0;
	margin: 0;
	font-size: 1px;
	line-height: 0;
	display: block
}

div.BreadCrumb {
	border: 0;
	padding: 0;
	margin: 0
}

div.btnMsgBar span.msg {
	font-family: Arial, Helvetica, sans-serif;
	font-size: small;
	white-space: nowrap
}

div.btnMsgBar input.btnMsgBar-bTxt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: small;
	text-align: center;
	text-decoration: none;
	white-space: nowrap;
	cursor: pointer
}

.cr-hr {
	padding: 0 0 10px;
	margin: 0 0 12px;
	border-bottom: 1px solid #ccc;
	color: #333;
	font: bold 1.231em Trebuchet, "Trebuchet MS"
}

.cr-mz {
	margin: 0
}

.cr-c .cr-hr {
	padding: 0 0 5px;
	margin: 0 0 5px
}

.cr-nr .cr-hr {
	margin: 0;
	border: 0
}

.cr-lt .cr-hr {
	font-weight: normal;
	font-size: 1.385em;
	padding-bottom: 9px;
	margin-bottom: 8px
}

.cr-brd,.cr-bt {
	border: 1px solid #ccc;
	padding: 9px 11px
}

.cr-bt .cr-hr {
	margin: -2px 0 0;
	border: 0;
	padding: 0 0 3px
}

.cr-bt .cr-cnt {
	padding: 0
}

.cr-st .cr-hr {
	font-size: 1.077em;
	font-weight: bold
}

.cr-cp .cr-hr {
	padding: 5px 15px;
	margin: 0
}

.cr-cp .cr-cnt {
	padding: 12px 15px
}
</style>

</head>
<body id="body">

	<div></div>
	<div class="pagewidth">
		<div class="pageminwidth">
			<div class="pagelayout">
				<div class="pagecontainer">
					<div class="GlobalNavigation" id="GlobalNavigation">
						<div>

							<a class="gh-hdn" href="#mainContent">Skip to main content</a>
							<div id="gh" class="gh-w gh-site-203">
								<table id="gh-t">
									<tbody>
										<tr>
											<td id="gh-l"><a href="homepage.action"
												_sp="m570.l2586" id="gh-la">eBay<img alt="" src=""
													id="gh-logo" border="0"> </a>
											</td>
											<td id="gh-u">
												<!--bucks--> <!--/bucks-->
											</td>
										</tr>
									</tbody>
								</table>
								<div class="gh-cb">
									<b class="gh-cb1"></b><b class="gh-cb2"></b><b class="gh-cb3"></b><b
										class="gh-cb4"></b>
								</div>
							</div>
							<a name="mainContent"></a>

						</div>
					</div>
					<div class="AreaNavigation" id="AreaNavigation"></div>
					<div class="AreaTitle" id="AreaTitle">
						<table class="widthpercent">
							<tbody>
								<tr>
									<td><div class="sp-w">
											<table cellspacing="0" cellpadding="0">
												<tbody>
													<tr>
														<td style="width: 50%"><div class="sp-c">
																<u></u>Order
															</div>
														</td>
														<td style="width: 50%"><div class="sp-d">Pay
																Securely</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</td>
									<td align="right"><span><font
											style="font-size: 20px; color: #948e8c; font-weight: bold; vertical-align: middle">&lt;
										</font><a href="" style="color: #0033ff;"
											title="Back to item description"><font>Back to
													item description</font> </a> </span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="PageLevelMessageArea" id="PageLevelMessageArea">
						<div id="qtyerrid"></div>
					</div>
					<div class="CentralArea" id="CentralArea">
						<table style="width: 100%">
							<tbody>
								<tr>
									<td><!-- <form name="pageForm" autocomplete="OFF" action=""
											method="post" id="SSPMformID"> -->
											<s:form method="post" action="paymentgateway.action">
											<s:hidden name="sellerID" />
											<div class="mainHeader">
												<div>
													<div class="mainHeader">
														<div>
															<div class="pageIntroSC" style="padding-top: 15px;">
																<div style="color: #333333">
																	Please verify the shipping address, and click the <b>Continue</b>
																	button at the bottom of the page.
																</div>
																<span align="right"
																	style="float: right; margin-top: -15px;"><span><a
																		href="javascript:void()"><img src=""
																			id="livechathelp" name="livechathelp" border="0">
																	</a> </span> </span>
															</div>
															<div>
																<table class="cr-w cr-nr" cellspacing="0"
																	cellpadding="0" style="Width: 100%">
																	<tbody>
																		<tr>
																			<td><div class="cr-hr">
																					<div class="itemsumstyle">
																						<b>Review the items you are buying and your
																							order total</b>
																					</div>
																				</div>
																			</td>
																		</tr>
																		<s:iterator value="sessionCart">
																			<tr>
																				<td><div class="cr-cnt">
																						<div>
																							<div
																								style="margin-left: -10px; margin-right: -10px; margin-top: -7px;"
																								class="sellerinst">
																								<table
																									style="width: 100%; cellspacing: 0px; cellpadding: 0px; border: 0px;">
																									<tbody>
																										<tr>
																											<td class="txt-black13bold"
																												style="width: 71%; text-align: right;">Price</td>
																											<td style="width: 14%;"><span
																												class="txt-black13bold"
																												style="text-align: middle; padding-left: 70px;">Quantity</span>
																											</td>
																											<td class="txt-black13bold"
																												style="width: 15%; text-align: right; padding-right: 10px;">Sub-total</td>
																										</tr>
																									</tbody>
																								</table>
																							</div>
																							<s:iterator value="cartProduct">
																								<div>
																									<div
																										style="color: #333333; border-bottom: 1px solid #cccccc">
																										<div id="390570221687"
																											style="display: inline-block; width: 100%;">
																											<div>
																												<div class="item-summ-body-image">
																													<div style="Height: 80px; Width: 80px;">
																														<a href=""><!-- <img src="img/logo.gif"
																															alt="" border="0">  -->
																															
																															
																															<img src="productimages/<s:property value="image1"/>"
																															alt="Product Image" border="0" height="80px" width="80px"> 
																															</a>
																													</div>
																												</div>
																												<div class="item-summ-body-title-57"
																													style="padding-bottom: 10px;">
																													<div>
																														<div class="item-summ-body-titleinline">

																															<!-- product id to be added in the link 
																												and product name to be displayed
																												-->

																															<a href="" style="color: #0033ff;"><s:property
																																	value="name" /> </a>
																														</div>
																													</div>
																													<div id="v4-0"></div>
																													<div>
																														<b class="item-summ-bseller-pad">From
																															seller:</b>
																														<div class="item-summ-body-titleinline"
																															style="color: #0033ff;">
																															<a title="Member id giftoscope" href=""><b
																																class="g-hdn">Member id </b><span
																																class="mbg-nw"><s:property
																																		value="sellerUserName" />
																																		 
																																		</span> </a> <span
																																class="mbg-l"> ( <a
																																class="mbg-fb" title="" href=""><b
																																	class="g-hdn">Feedback Score Of</b> <s:property
																																		value="feedbackScore" /> </a><img
																																src="img/iconGreenStar_25x25.gif"
																																height="25" width="25" class="mbg-star"
																																title="" alt="">) </span> <span
																																class="mbg-l"><a href=""><img
																																	src="img/psIcon_50x25.gif" height="25"
																																	width="50"
																																	alt="Member is a PowerSeller"
																																	title="Member is a PowerSeller"
																																	border="0"> </a> </span>
																														</div>
																													</div>
																												</div>
																												<div class="single-item-summ-body-price">
																													Rs.
																													<s:property value="price" />
																												</div>
																												<div class="single-item-summ-body-qty">
																													<s:property value="quantitySelected" />
																													<input type="hidden" name="req_quantity"
																														id="req_quantity" value="1">
																												</div>
																												<div class="stDiv">
																													<table class="amountTable">
																														<tbody>
																															<tr>
																																<td class="symDivTd"><div
																																		class="symDiv">Rs.</div>
																																</td>
																																<td class="priceDivTd"><div
																																		class="priceDiv" id="regsubtotal">
																																		<s:property value="subTotal" />
																																	</div>
																																</td>
																															</tr>
																														</tbody>
																													</table>
																												</div>
																												<input type="hidden" name="req_item"
																													id="req_item" value="390570221687"><input
																													type="hidden" name="req_variation"
																													id="req_variation" value="0">
																											</div>
																										</div>
																									</div>
																								</div>
																							</s:iterator>
																						</div>
																					</div>
																				</td>
																			</tr>
																		</s:iterator>
																	</tbody>
																</table>
															</div>
															<div class="tbl1viewaddr1"></div>
															<div>
																<div class="left-blue-box">
																	<div>
																		<div style="color: #333333">
																			<div class="cr-w">
																				<div class="cr-hr">
																					<div>
																						<b><div>
																								<span>Your shipping address</span>
																							</div> </b>
																					</div>
																				</div>
																				<div class="cr-cnt">
																					<div style="height: 150px; padding-left: 5px">
																						<div>
																							<input type="hidden" id="addDsplCountry"
																								value="com.ebay.darwin.app.spark.pres.AddressLayoutIN">
																							<div class="g-std" id="addrrow">
																								<div id="addrrow">
																									<b> <s:property value="contactName"/> <s:hidden name="contactName"/> </b>
																								</div>
																								<div id="addrrow">
																									<span> <s:property value="address"/> <s:hidden name="address"/> </span>
																								</div>
																								<div id="addrrow">
																									<span><s:property value="city"/> <s:hidden name="city"/> </span>
																								</div>
																								<div id="addrrow">
																									<span><s:property value="state"/> <s:hidden name="state"/> </span>
																								</div>
																								<div id="addrrow">
																									<span><s:property value="pincode"/> <s:hidden name="pincode"/> </span>
																								</div>
																								<div id="addrrow">
																									<span><s:property value="country"/> <s:hidden name="country"/> </span>
																								</div>
																								<div id="addrrow"></div>
																							</div>
																						</div>
																						
																						
																			<!-- Change address to be done //////////	 -->			
																						
																						<!-- <div style="padding-top: 10px;">
																							<a name="uaddress" href="changeshippingaddress"
																								class="ChangeAddressLink"
																								style="color: #0033ff;">Change shipping
																								address</a>
																						</div> -->
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="right-blue-box">
																	<div style="color: #333333">
																		<div>
																			<div>
																				<div>
																					<div class="cr-w">
																						<div class="cr-hr">
																							<div class="shipmethod">
																								<span><b>Order Total and Shipping
																										Charges</b> </span>
																							</div>
																						</div>
																						<s:iterator value="sessionCart">
																							<div class="cr-cnt">
																								<div>
																									<div>
																										<div class="sub-div" style="height: 115px;"
																											id="gxoshippingid">
																											<div class="sub-div-ltotal">Total</div>
																											<div class="sub-div-mtotal"
																												style="width: 7.7%">Rs.</div>
																											<div class="sub-div-rtotal"> <s:property value="total"/> </div>
																											<div class="taxmessage">The item price
																												is inclusive of all applicable taxes.</div>
																										</div>
																									</div>
																								</div>
																							</div>
																						</s:iterator>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div
																style="float: right; margin-right: 3px; font-family: Arial; font-size: 13px; text-align: right; width: 100%">
																<div id="switchsmdiv" style="display: none;">
																	<div>
																		<a id="switchshipping" href="javascript:">Click
																			here </a>
																		<div style="display: inline;" id="switchmsgdiv"></div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>


											<div>
												<s:hidden name="pageFlag" value="Buy"/>
												<div class="btnMsgBar">
													<input class="continuebutton btnMsgBar-bTxt" type="hidden">
													<span id="disspncontinue" style="vertical-align: middle; display: none;">
														<b id="continuedisable" class="btn-w btn-m btn-p">
															<i>Continue &gt;</i>
															<span id="spn_continue" class="btn-b moz btn-bd sbn-S">
																<input id="but_continue" name="" value="Continue &gt;" type="submit" disabled="">
																<b id="txt_continue">Continue &gt;</b> 
															</span>
														</b> 
													</span>
													<span id="spncontinue"
														style="vertical-align: middle; display: inline;"><b
														id="continue" class="btn-w btn-m btn-p"><i>Continue
																&gt;</i><span id="spn_continue" class="btn-b pbn-P"><input
																id="but_continue" name="" value="Continue &gt;"
																type="submit"><b id="txt_continue">Continue
																	&gt;</b> </span> </b> </span>&nbsp;&nbsp;<span class="msg"></span>
												</div>
											</div>
										<!-- </form> -->
										</s:form>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="SupportiveNavigation" id="SupportiveNavigation">
						<script>
							var pageID = 'CreateOrder';
							var pageName = 'SIPSelectShippingPayment';
						</script>
						<div class="aboveFooter"></div>
						<div id="glbfooter" class="coreFooterLinks">
							<div>
								<div id="rtm_html_1650" style="height: 0px; display: none;"></div>
								<div id="rtm_html_1651" style="height: 0px; display: none;"></div>
							</div>
							<table width="100%">
								<tbody>
									<tr>
										<td class="g-pipe"><ul role="directory" id="gf-l">
												<li><a role="link"
													href="homepage.action">About eBay</a>
												</li>
												<li><a role="link"
													href="deals.action">Announcements</a>
												</li>
												<li><a _sp="m571.l2894" role="link"
													href="homepage.action">Buy Hub</a>
												</li>
												<li><a role="link"
													href="registration.action">Register</a>
												</li>
												<li><a role="link"
													href="">Security
														&amp; Resolution Centre</a>
												</li>
												<li><a role="link"
													href="">Feedback
														Forum</a>
												</li>
												<li><a _sp="m571.l1625" role="link"
													href="homepage.actionl">Site Map</a>
												</li>
												<li><a role="link"
													href="homepage.action">Customer
														Support</a>
												</li>
												<li><a role="link"
													href="deals.action">Advertise with
														us</a>
												</li>
											</ul>
										</td>
									</tr>
									<tr valign="top" class="g-hlp">
										<td class="g-nav coreFooterLegalNotice">Copyright ©
											1995-2013 eBay Inc. All Rights Reserved. Designated
											trademarks and brands are the property of their respective
											owners. Use of this Web site constitutes acceptance of the
											eBay <a _sp="m571.l2612" href="">User Agreement</a> and <a
											_sp="m571.l2613" href="">Privacy Policy</a>. <br> <br>
											<a href="">eBay official time&nbsp;</a>
										</td>
									</tr>
								</tbody>
							</table>
							<div id="cobrandFooter"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
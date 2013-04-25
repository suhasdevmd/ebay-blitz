
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns:fb="" xmlns:og="">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title></title>

<link rel="stylesheet" type="text/css" href="css/product2.css">
<link rel="stylesheet" type="text/css" href="css/product1.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#quantityAvail").hide();

		$("#v4-37qtyId").change(function() {
			var qtyTF = parseInt(($("#v4-37qtyId").val()),10);
			//alert(qtyTF);
			var qtyAvail = parseInt($("#quantityAvail").val(),10);
			//alert(qtyAvail);
			if(qtyAvail == 0){
				alert("Available Quantity is 0. This product cannot be bought");
				$("#v4-37qtyId").val("1");
				
			}
			if (qtyTF <= 0) {
				alert("Quantity selected cannot be Zero or lesser. Please select a different Quantity");
				$("#v4-37qtyId").val("1");
			}
			if (qtyTF > qtyAvail) {
				alert("Exceeded the maximum Quantity Available.");
				$("#v4-37qtyId").val("1");
			}
		});

	});
</script>


</head>
<body style="text-align: left" id="body">


	<div></div>
	<div id="vi-container" class="vi-c_0">
		<div id="vi-top">
			<%-- <div>


				<a class="gh-hdn" href="#mainContent">Skip to main content</a>
				<div id=gh class="gh-w gh-site-203">
					<table id=gh-t>
						<tr>
							<td id=gh-l><a href="" _sp=m570.l2586 id=gh-la>eBay<img
									alt="" src="" border="0"> </a></td>
							<td id=gh-u><span id=gh-ug><noscript>
										Welcome, {{bold}}{{boldend}} (<a class=gh-a
											href=https://signin.ebay.in/ws/eBayISAPI.dll?SignIn>Not
											you</a>)
									</noscript> </span> <!--bucks--> <span id=gh-um><bucks /> </span> <!--/bucks-->
							</td>
						</tr>
					</table>
					<ul id=gh-eb class=gh-clearfix>
						<li class=gh-eb-li id=gh-eb-search><form action="" method=get
								id=gh-eb-searchForm>
								<input type=hidden value=R40 name=_from><input
									type=hidden value=m570.l2736 name=_trksid><input
									type=text name=_nkw id=gh-eb-searchTxt
									title="Enter your search keyword"><input type=submit
									id=gh-eb-searchBtn value="Go">
							</form></li>
						<li class=gh-eb-li id=gh-eb-My><a _sp="m570.l2919"
							class="gh-eb-li-a" href="">My eBay</a></li>
						<li class=gh-eb-li id=gh-eb-paisapay><a _sp="m570.l3903"
							class="gh-eb-li-a" href="">My PaisaPay</a></li>
						<li class=gh-eb-li id=gh-eb-Sell><a _sp="m570.l1528"
							class="gh-eb-li-a" href="">Sell</a></li>
						<li class=gh-eb-li id=gh-eb-Comm><a _sp="m570.l1540"
							class="gh-eb-li-a" href="">Community</a></li>
						<li class=gh-eb-li id=gh-eb-Cust><a _sp="m570.l1545"
							class="gh-eb-li-a" href="">Customer Support</a></li>
						<li class=gh-eb-li id=gh-cart><a _sp="m570.l2633"
							class="gh-eb-li-a" href="">Cart</a></li>
					</ul>
					<div class=gh-cb>
						<b class=gh-cb1></b><b class=gh-cb2></b><b class=gh-cb3></b><b
							class=gh-cb4></b>
					</div>
					<ul class="gh-nav gh-clearfix">
						<li class="gh-nav-li"><a class="gh-nav-li-a" _sp="m570.l1620"
							href="">CATEGORIES</a></li>
						<li class="gh-nav-li" id="gh-nav-arw"><a class="gh-nav-li-a"
							href="#"><b id=gh-nav-arwb>&nbsp;</b> </a></li>
						<li class="gh-nav-li"><a class="gh-nav-li-a" href="">GLOBAL
								EASYBUY</a></li>
						<li class="gh-nav-li"><a class="gh-nav-li-a" href="">FASHION</a>
						</li>
						<li class="gh-nav-li"><a target="_blank" class="gh-nav-li-a"
							href="">HOLIDAYS</a></li>
						<li class="gh-nav-li"><a target="_blank" class="gh-nav-li-a"
							href="">INSURANCE</a></li>
						<li id=gh-rp3><a id="gh-rp3a" href=""><i class=gh-hdn>DEALS</i>
						</a></li>
					</ul>
				</div>
				<a name="mainContent"></a>
				

			</div> --%>

			<div id="viGspShptoPanelOly_Outer" class="g-hdn"
				style="visibility: hidden; width: 245px">
				<div id="cnviGspShptoPanel">

					<a id="viGspShptoPanel_stA" href="javascript:;" class="g-hdn">Start
						of Layer</a><a id="viGspShptoPanel_enA" href="javascript:;"
						class="g-hdn">End of Layer</a>
				</div>
			</div>
			<div class="vi-cmb">
				<div class="vi-ih-header">
					<table cellpadding="0" cellspacing="0" border="0"
						class="vi-ih-area_nav">
						<tr>
							<td valign="top"><span id="ngviback" class="sbt"><s:iterator
										value="productDetails">
										<a
											href="categories.action?CategoryID=<s:property value="categoryID"/>"
											title="Back to search results">Back to search results </a>
									</s:iterator> </span>
							</td>
							<td valign="top" class="vi-ih-pipe-cell">&#160;|&#160;</td>
							<td valign="top"><table style="margin-top: 0px;">
									<tr>
										<td></td>
										<td valign="top"><div>
												<div class="bbc-in bbc bbc-nav">
													<b class="g-hdn">Bread Crumb Link</b>
													<ul class="in">
														<!-- <li><a href="" _sp="p4340.l2706">Mobile Phones</a>
														</li>-->
													</ul>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>

			<table class="vi_sme_banner_layout">
				<td width="100%"><div id="promotionBanner"></div>
				</td>
				<td width="100%"></td>
			</table>
		</div>
		<table id="vi-tTbl" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td colspan="1" rowspan="1" id="vi-tTblC1" class="vi-ip_0"><div
						class="vi-ipic1">
						<span class="shig" id="freeShippingIcon"><img
							src="img/s.gif" height="1" width="1" alt="FREE shipping"
							class="sale0 vi-fshig"><span id="spclOffers"></span> </span>
						<form name="ssFrm" action="" target="ssFrmWin" method="post">
							<s:iterator value="productDetails">
								<input type="hidden" name="ssr" value="1">
								<input type="hidden" name="iurls" value="0#">
								<input type="hidden" name="dtid" id="dtid" value="0">
								<input type="hidden" name="vs" value="1">
								<input type="hidden" name="sh" value="1">
								<input type="hidden" name="title"
									value="<s:property value="name" />">
							</s:iterator>
						</form>
						<div>
							<table border="0" cellpadding="0" cellspacing="0">

								<tr>
									<%-- <s:iterator value="productDetails"> --%>
									<td class="vs_w-a"><div class="ict-w1" id="vv4-34"
											title="<s:property value="name" />">
											<div class="ic-w300 ic-cntr">
												<div class="ic-w300 ic-m" id="vv4-34_idiv">
													<center>
														<span></span><img id="i_vv4-34" height="300" width="300"
															src="productimages/<s:property value="image1"/>"
															alt="<s:property value="name" />">

													</center>
												</div>
												<a id="vv4-34_a" class="ic-cp" href="javascript:;"></a>
												<div id="vv4-34_bdiv" class="ic-p ic-b1"
													style="height: 298px; width: 298px;">
													<div id="vv4-34_t" class="ic-thr">
														<span></span>
													</div>
													<div id="vv4-34_e" class="ic-err">
														<span></span>
													</div>
												</div>
											</div>
											<div class="tbr-c" id="vv4-34_TB">
												<ul class="tbr-w">
													<!-- <li title="Show larger and alternate views" class="tbr-l"><a
															id="vv4-34_TB_0" href="javascript:;"><span
																class="ict-enl">Enlarge</span> </a>
														</li>-->
												</ul>
											</div>
										</div>
									</td>
									<%-- </s:iterator> --%>
								</tr>
							</table>
						</div>
						<div>
							<%-- <img src="productimages/<s:property value="image1"/>" width="302px" alt=""> --%>
						</div>

					</div>
				</td>
				<td colspan="1" rowspan="1" id="vi-tTblS" class="vi-tTblS"></td>
				<td colspan="1" rowspan="1" id="vi-tTblC2" class="vi-tc_0 vi-tc_0"><span>
						<s:iterator value="productDetails">
							<h1 class="vi-is1-titleH1">
								<s:property value="name" />
							</h1>

							<h2 class="vi-is1-titleH2">
								<s:property value="brand" />
							</h2>
						</s:iterator> </span>
					<div class="vi-is1-pt5"></div>
					<div id="vi_dd" class="vi-dd"></div> <s:form method="Post"
						action="">
						<table width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td rowspan="3" valign="top" id="isclmn" class="vi-tTblS">

									<table class="vi-is1" style="margin-left: 0px !important"
										cellpadding="0" cellspacing="0" border="0">
										<s:iterator value="productDetails">
											<tr>
												<th class="vi-is1-lbl">Item condition:</th>
												<td colspan="3" class="vi-is1-clr"><span
													class="vi-is1-condText"><s:property
															value="productCondition" /> </span>
												</td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="4" height="10"></td>
										</tr>
										<s:iterator value="productDetails">
											<tr>
												<th class="vi-is1-lbl">Time left:</th>
												<td colspan="3" class="vi-is1-clr"><span
													class="vi-is1-dt"><span class="vi-is1-tml"><s:property
																value="duration" /> Hours </span><span class="vi-is1-dt-eu"><span>
														</span><span class="vi-is1-t"> </span> </span> </span><span class="vi-is1-s7">
														<span class="vi-is1-misc"> </span> </span></td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="4" height="10"></td>
										</tr>
										<s:iterator value="productDetails">
											<tr id="">
												<th class="vi-is1-lbl" id="">Quantity:</th>
												<td colspan="3" class="vi-is1-clr"><div>
														<div class="vi-is1-s5">
															<div id="eiv4-37qtyId" class="vi-is1-errorIcon">
																<img src="" height="1" width="1" class="vi-err-img"
																	alt="Error icon">
															</div>

															<div>

																<%-- <s:textfield size="4" name="quantity" value="1"
																	id="v4-37qtyId" class="vi-is1-mqtyTb" theme="simple" />
																<span class="vi-is1-mqtyDiv"> Available</span>
 --%>
																<s:textfield size="4" name="quantity" value="1"
																	id="v4-37qtyId" class="vi-is1-mqtyTb" theme="simple" />
																<span class="vi-is1-mqtyDiv"> <s:property
																		value="quantityAvailable" /> Available</span>
																
															</div>
														</div>

													</div>
												</td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="4" height="10"></td>
										</tr>
										<tr>
											<td colspan="4" height="10" class="vi-is1-solid"></td>
										</tr>
										<s:iterator value="productDetails" var="mainArrayList">
											<tr>
												<th class="vi-is1-lblp vi-is1-solidBg">Price:</th>

												<td class="vi-is1-solid vi-is1-tbll"><span><span
														class="vi-is1-prcp" id="v4-27">Rs.</span> </span> <s:set
														var="disc" value="%{'no'}" /> <s:iterator
														value="#mainArrayList.description" var="map">
														<s:iterator>
															<s:if test='%{#map.key == "newprice"}'>
																<span><span class="vi-is1-prcp" id="v4-27"><s:property
																			value="#map.value" /> </span> </span> Actual Price :  <span><span
																	class="vi-is1-prcp" id="v4-27"><del>
																			Rs.
																			<s:property value="price" />
																		</del> </span> </span>
																<s:set var="disc" value="%{'yes'}" />
															</s:if>
														</s:iterator>
													</s:iterator> <span><span class="vi-is1-prcp" id="v4-27"><s:if
																test="%{#disc=='no'}">
																	Rs.<s:property value="price" />
															</s:if> </span> </span>
												</td>

												<td colspan="2" class="vi-is1-solid vi-is1-tblb"><div>
														<!-- <b id="v4-33binLnk" class="bn-w bn-pad psb-S"><i>Buy
																	It Now</i><span id="spn_v4-33binLnk"
																class="bn-b psb-b psb-S"> <s:submit
																		name="buttonName" value="Buy_Now" theme="simple" action="buynow"/>
																	
																 <s:hidden name="price" id="bprice" />
																	<s:hidden name="name" id="bname" /> <s:hidden name="sellerID" />
																	 <b id="txt_v4-33binLnk">Buy It Now</b> </span> </b>-->

													</div>
												</td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="4" height="10" class="vi-is1-solid"></td>
										</tr>
										<tr>
											<td colspan="4" height="10" class="vi-is1-solid_bevel"><div
													class="vi-is1-bevel"></div>
											</td>
										</tr>
										<tr>
											<td colspan="4" height="10" class="vi-is1-solid"></td>
										</tr>
										<s:iterator value="productDetails" var="mainArrayList">
											<tr>
												<th class="vi-is1-lblp vi-is1-solidBg"></th>
												<td class="vi-is1-solid vi-is1-tbll"><span
													class="vi-is1-s8">Or combine multiple purchases:</span>
												</td>
												<td colspan="2" class="vi-is1-solid vi-is1-tblb"><div>
														<b id="v4-23" class="bn-w bn-pad psb-S"><i>Add to
																Cart</i><span id="spn_v4-23" class="bn-b psb-b psb-S">
																<%-- <a
																id="but_v4-23"
																href="cart.action?productID=<s:property value="productID"/>& price=<s:property value="price"/>& productName=<s:property value="name"/>& sellerID=<s:property value="sellerID"/>& quantity=<s:property value="quantity"/>& fromProductjsp=1"
																title="">Add to Cart</a> --%> <s:submit
																	name="buttonName" value="Add To Cart" theme="simple"
																	action="cart" /> <s:set var="chk" value="price" /> <s:iterator
																	value="#mainArrayList.description" var="map">
																	<s:iterator>
																		<s:if test='%{#map.key == "newprice"}'>
																			<s:set var="chk" value="#map.value" />
																		</s:if>
																	</s:iterator>
																</s:iterator> <s:hidden name="price" value="%{#chk}" /> <s:hidden
																	name="name" /> <s:hidden name="sellerID" /> <s:hidden
																	name="fromProductjsp" value="1" /> <s:hidden id="quantityAvail" name="quantityAvailable"></s:hidden> <b id="txt_v4-23">Add
																	to Cart</b> </span> </b>
													</div>
												</td>
											</tr>
										</s:iterator>

										<tr>
											<td colspan="4" height="10" class="vi-is1-solid"></td>
										</tr>
										<tr id="watchItemMiddleRow">
											<td class="vi-is1-solid vi-is1-lbl"><div id="v4-29"></div>
											</td>
											<td class="vi-is1-solid" id="watchLabelDiv"><div
													id="v4-30"></div>
											</td>
											<td colspan="2" class="vi-is1-solid vi-is1-tblb"><div>
													<div>
														<div id="dd_addToList" class="ul-dd g-xs">
															<div id="ddv_addToList">
																<span id="ttlsp_addToList" class="ul-tl"><a
																	href="addToWishlist.action?productID=<s:property value="productID"/>"
																	id="-99_ttl_addToList" sw="true" w="t" i="-99"
																	n="Watch list">Add to Watch list</a> </span><span
																	class="ul-di"><a href="javascript:;"
																	id="img_addToList"></a> </span>
															</div>
															<div id="pnl_addToList" style="display: none;"
																class="ul-pn">
																<a href="javascript:;" id="s_addToList" class="g-hdn">Start
																	of panel</a>
																<ul id="ul_addToList" class="ul-it">
																	<li><a href="javascript:;" id="-99_ita_addToList"
																		sw="true" w="t" i="-99" n="Watch list">Add to
																			Watch list</a>
																	</li>
																	<li><a
																		href="addToWishlist.action?productID=<s:property value="productID"/>"
																		id="-97_ita_addToList" d="t" i="-97" wsh="t"
																		n="Wish list">Add to Wish list</a>
																	</li>
																</ul>
																<div class="ul-sp"></div>
																<div id="ftdv_addToList">
																	<a href="" id="s_ita_addToList" nw="true" i="s"
																		n="addNew">Sign in for more lists</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</td>
								<td height="28px"><div align="right"
										style="margin-bottom: 8px;">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td nowrap="nowrap" width="100%" align="right"><span><span
														class="watchlinkSpan" id="linkTopAct"><img src=""
															alt=""><a rel="nofollow" title="" id="WtchItm"
															href="addToWishlist.action?productID=<s:property value="productID"/>">Add
																to Watch list</a> </span> </span><span><span id="dwnArr"></span><span
														id="upArr" class="z_1"></span> </span><img src="" alt="">
												</td>
											</tr>
										</table>
										<div>
											<div>
												<div>
													<div id="errorDiv" class="watchouterdiv1_5"
														style="display: none">
														You have reached your maximum guest watch list limit of 10
														items.<br>Please remove some items from your watch
														list in <a href="">My eBay</a> if you want to add more.
													</div>
													<div id="masterDiv" class="watchItem watchOuterDiv"
														style="display: none">
														<div class="guestLine">
															This item has been added to your guest watch list in <a
																href="">My eBay</a>.
														</div>
														<div id="middleDiv" class="watchInfo"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="vi-b1 vi-lc vi-b1" id="vieu_si"><div>
										<table cellpadding="0" cellspacing="0"
											class="s-content-eu s-content">
											<tbody>
												<tr>
													<td><h2 class="sit">Seller information</h2>
													</td>
												</tr>
												<tr>
													<td><div class="s-details">
															<div class="mbg">
																<a
																	title="Member id <s:property value="sellerUserName"/>"
																	href="sellerInformation.action?sellerID=<s:property value="sellerID"/>&productID=<s:property value="productID"/>"><b
																	class="g-hdn">Member id </b><b><span class="mbg-nw"><s:property
																				value="sellerUserName" /> </span> </b> </a> <span class="mbg-l">
																	( <a class="mbg-fb" title="Feedback Score"
																	href="sellerInformation.action?sellerID=<s:property value="sellerID"/>&productID=<s:property value="productID"/>"><b
																		class="g-hdn">Feedback Score Of</b> <s:property
																			value="feedbackScore" /> </a><img
																	src="img/iconGreenStar_25x25.gif" height="25"
																	width="25"
																	title="Teal star icon for feedback score in between 1 to 1000"
																	alt="Teal star icon for feedback score in between 1 to 1000"
																	class="mbg-star">) </span> <span class="mbg-l"><a
																	href="sellerInformation.action?sellerID=<s:property value="sellerID"/>&productID=<s:property value="productID"/>"><img
																		src="img/psIcon_50x25.gif" height="25" width="50"
																		alt="Member is a PowerSeller"
																		title="Member is a PowerSeller" border="0"> </a> </span>
															</div>
															<br> <span class="s-gray z_a"><s:property
																	value="positiveFeedback" />%&#160;Positive feedback</span>
														</div>
														<div class="sRuleDotted"></div>
													</td>
												</tr>
												<tr>
													<td>
														<!-- <div class="bdg sl-eu">
															<div>
																<a href="" rel="nofollow">Ask a question</a>
															</div>
															<div class="s-f-da">
																<a href="" rel="nofollow">Save this seller</a>
															</div>
															<div class="s-f-da">
																<span class="s-f-da"><a href="">See other
																		items <b class="g-hdn">from this seller</b> </a> </span>
															</div>
														</div>-->
													</td>
												</tr>
												<tr></tr>
												<tr></tr>
											</tbody>
											<div class="spc1"></div>
										</table>

									</div>
								</td>
							</tr>
							<tr>

							</tr>
						</table>
					</s:form>
					<div></div>
				</td>
			</tr>
		</table>

		<div id="vi-content" class="vi-mdtt" style="clear: both;">
			<div id="VisualPreviewContent"></div>
			<div class="rtm-pad">
				<div class="vi-cmb" id="rtm_html_911" style="height: 16; width: 470"></div>
			</div>
			<div class="vi-cd">
				<div id="vi_tabs">
					<div>
						<div>
							<table cellspacing="0" cellpadding="0" id="vi_tabs_wrp"
								class="tb tb-nw" width="100%">
								<tr role="tablist">
									<td class="tb-act" id="vi_tabs_0_td" width="1"><a
										role="tab" class="tb-a" href="javascript:;" id="vi_tabs_0"
										title=""><span class="tb-txt"><h2
													class="vi-tab-hdr g-m g-m0">Description</h2> </span> </a>
									</td>
								</tr>
							</table>
						</div>
						<div class="tb-cw">
							<div id="vi_tabs_0_cnt" class="tb-cntOn" role="tabpanel">
								<div>
									<div class="vi-cd">
										<span style="float: left;" class="vi-br">Seller assumes
											all responsibility for this listing.</span>
										<div class="vi-cd vi-cmb"></div>
										<div class="vi-iw">
											<div class="cr-w cr-bt c-gy-bdr">
												<div class="cr-cnt">
													<table cellpadding="0" cellspacing="0" width="100%"
														class="vi-ia-attrGroup">
														<tr>
															<td id="vi-ia-attrTableFirstRowTd"><h3
																	class="vi-ia-attrGroupTitle vi-ds2-subt">General
																	Information</h3>
															</td>
														</tr>
														<tr>
															<td>
																<table cellpadding="0" cellspacing="0" width="100%">

																	<tr>
																		<th nowrap="nowrap" id="v4-39" align="left"
																			class="vi-ia-hdAl vi-ia-attrLabel vi-ia-attrColPadding">Name:</th>
																		<s:iterator value="productDetails">
																			<td headers="v4-39" class="vi-ia-attrColPadding"
																				width="50.0%"><div>
																					<s:property value="name" />
																				</div>
																			</td>
																		</s:iterator>
																		<th nowrap="nowrap" id="v4-40" align="left"
																			class="vi-ia-hdAl vi-ia-attrLabel vi-ia-attrColPadding">Brand:
																		</th>
																		<s:iterator value="productDetails">
																			<td headers="v4-40" class="vi-ia-attrColPadding"
																				width="50.0%"><s:property value="brand" />
																			</td>
																		</s:iterator>
																	</tr>
																	<tr>
																		<th nowrap="nowrap" id="v4-41" align="left"
																			class="vi-ia-hdAl vi-ia-attrLabel vi-ia-attrColPadding">Price:
																		</th>
																		<s:iterator value="productDetails">
																			<td headers="v4-41" class="vi-ia-attrColPadding"
																				width="50.0%">Rs. <s:property value="price" />
																			</td>
																		</s:iterator>
																		<th nowrap="nowrap" id="v4-42" align="left"
																			class="vi-ia-hdAl vi-ia-attrLabel vi-ia-attrColPadding">Condition:</th>
																		<s:iterator value="productDetails">
																			<td headers="v4-42" class="vi-ia-attrColPadding"
																				width="50.0%"><s:property
																					value="productCondition" />
																			</td>
																		</s:iterator>
																	</tr>

																</table>
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
										<div class="vi-iw">
											<div class="cr-w cr-bt c-gy-bdr">
												<div class="cr-cnt">
													<div class="vi-ia-attRow vi-ia-attLabelLastTd">
														<h3 class="vi-c-phdr vi-ds2-subt">Detailed Product
															Information</h3>
														<table width="100%">
															<tr>
																<td>
																	<?xml version="1.0" encoding="utf-8"?> <!-- <table cellpadding="0" cellspacing="0" border="0"
																		width="100%">
																		<tr>
																			<td colspan="2"><font
																				face="Arial, Helvetica, sans-serif" size="2"><b>Product
																						Identifiers</b> </font></td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Brand</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Lava</font>
																			</td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Model</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">C81</font>
																			</td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Colour</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Grey</font>
																			</td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Capacity</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">64
																					MB</font></td>
																		</tr>
																		<tr>
																			<td colspan="2"><br class="br" /></td>
																		</tr>
																		<tr>
																			<td colspan="2"><font
																				face="Arial, Helvetica, sans-serif" size="2"><b>Key
																						Features</b> </font></td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Type</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Smartphone</font>
																			</td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Cellular
																					Band</font></td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">GSM
																					900/1800 (Dual Band)</font></td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Style</font>
																			</td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Bar,
																					Touch</font></td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Screen
																					Size</font></td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">3.5
																					in.</font></td>
																		</tr>
																		<tr>
																			<td width="35%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">Display
																					Technology</font></td>
																			<td width="65%" valign="top"><font
																				face="Arial, Helvetica, sans-serif" size="2">HVGA</font>
																			</td>
																		</tr>
																	</table> -->
																	<table cellpadding="0" cellspacing="0" border="0"
																		width="100%">
																		<s:actionerror />
																		<s:actionmessage />
																		<s:iterator value="productDetails" var="mainArrayList">
																			<s:iterator value="#mainArrayList.description"
																				var="map">
																				<s:iterator>
																					<tr>
																						<td width="35%" valign="top"><font
																							face="Arial, Helvetica, sans-serif" size="2"><s:property
																									value="#map.key" /> </font>
																						</td>
																						<td width="65%" valign="top"><font
																							face="Arial, Helvetica, sans-serif" size="2"><s:property
																									value="#map.value" /> </font>
																						</td>
																					</tr>
																				</s:iterator>
																			</s:iterator>
																		</s:iterator>
																	</table></td>
															</tr>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="vi-bottom">
			<div class="vi-btb-blinks">
				<span id="v4-50"><s:iterator value="productDetails">
						<a
							href="categories.action?CategoryID=<s:property value="categoryID"/>"
							class="vi-btb-Lt">Back to search results</a>
					</s:iterator> </span><a href="" id="_rtop" class="vi-btb-Rt">Return to top</a>
			</div>
		</div>
	</div>
	<h1>
		<s:iterator>
			<s:property value="name" />
		</s:iterator>
	</h1>
</body>
</html>
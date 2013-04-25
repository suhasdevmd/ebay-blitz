<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>eBay.in Deals - All Deals in One Place. Deals on Mobiles,
	DSLR's, Compact Cameras, LCDs & LEDs, Tablets, Laptops and more</title>
<link rel="Shortcut Icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="Keywords"
	content="deals,bargains,mobile phones,digicams,lpatops,lcd,computers,eBay,india" />
<meta name="Description"
	content="eBay.in Deals - All Deals in One Place. Deals on Mobiles, DSLR's, Compact Cameras, LCDs & LEDs, Tablets, Laptops and more" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<link rel="stylesheet" type="text/css" href="css/font.css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.sudoSlider.js"></script>
</head>
<body id="body">
	<div class="no-container" id="bgDivLeft" style="width: 272px;"></div>
	<div class="container1 container1Main">
		<div class="container1">
			<link rel="Shortcut Icon" href="img/fav.ico" type="image/x-icon" />
			<link rel="stylesheet" type="text/css" href="css/modify.css">
			<!--cacheStatus: false-->
			<script>
				var _GlobalNavHeaderUtf8Encoding = true;
			</script>
			<script
				src="js/qicc5beyw2zejm0u4bus2lv3u.js#SYS-ZAM_vjo_e748i_1_Ear_en_IN"></script>
			<script
				src="js/mve5335yeu3nfkzbgoppwrpbj.js#GH-ZAM_ReskinEbayStatic_e748i_1_Ear_en_IN"></script>
			<script type="text/javascript">
				var evrxv = 'Sign up for Deals';
				vjo
						.ctype("vjo.darwin.core.ebayheader.cart.Cart")
						.needs(
								[//"vjo.dsf.typeextensions.string.Comparison",
								"vjo.dsf.cookie.VjCookieJar",
										"vjo.dsf.Element",
										"vjo.dsf.client.Browser" ])
						.props(
								{

									//> public void init(String pId,String pServerUrl,String pCartLink)
									init : function(pId, pServerUrl, pCartLink) {

										var oC = vjo.dsf.client.Browser, sc = vjo.darwin.core.ebayheader.cart.Cart;
										sc.sId = pId;
										sc.sCartLink = pCartLink;
										sc.bUpdated = false;
										//check for certain browsers, disable BTA for browser versions < IE5, < Opera 7.5 and < NS7.X
										if ((oC.bNav && oC.iVer < 7)
												|| (oC.bOpera && (oC.iVer + oC.fMinorVer) < 0.5)
												|| (oC.bIE && oC.iVer < 5))
											return;
										if (!sc.isSignedIn())
											return;
										if (sc.isCartReadDone()) {
											sc.update(sc.sId, sc.sCartLink);
										} else {
											sc.doRequest(pServerUrl);
										}
									},

									// allocated into separate function to better unit test and be able to override
									/**Modified access specifier to public since it is not used locally*/
									//> public void doRequest(String pServerUrl)
									doRequest : function(pServerUrl) {
										if (pServerUrl && pServerUrl.length > 1) {
											document
													.write('<img height="1" width="1" src="' + pServerUrl + '" style="display:none;">');
										}
									},

									/**Modified access specifier to public since it is not used locally*/
									//> public boolean isSignedIn()
									isSignedIn : function() {
										var c = this.vj$.VjCookieJar
												.readCookie("ebaysignin");
										return c && c.is('in');
									},

									//> public void update(String pId,String pCartLink)
									update : function(pId, pCartLink) {
										var sc = vjo.darwin.core.ebayheader.cart.Cart;
										sc.sId = pId;
										sc.sCartLink = pCartLink;
										// read ebx
										if (!sc.isSignedIn())
											return;
										var oL = vjo.dsf.Element.get(sc.sId), c;
										if (oL && sc.isCartReadDone()) {
											c = sc.getCount();
											if (c > 0 && !sc.bUpdated) {
												oL.innerHTML = '&nbsp;<a href="'+sc.sCartLink+'">('
														+ c + ')</a>';
												sc.bUpdated = true;
											}
										}
									},

									/**Modified access specifier to public since it is not used locally*/
									//> public boolean isCartReadDone()
									isCartReadDone : function() {
										var VJ = this.vj$.VjCookieJar;
										var c = VJ.readCookie("ebay", "sbf");
										if (c == 'true') {
											return true;
										} else
											return VJ.getBitFlag(c, 22) == 1;
									},

									/**Modified access specifier to public since it is not used locally*/
									//> public String getCount()
									getCount : function() {
										return this.vj$.VjCookieJar.readCookie(
												"dp1", "exc")
												|| "";
									}
								}).endType();
			</script>
			<script type="text/javascript">
				(function() {
					var _d = vjo.dsf.EventDispatcher;
					var _r = vjo.Registry;
					_d
							.add(
									'body',
									'load',
									function(event) {
										this
												.update("glb_cart",
														"http://orders.ebay.in/ws/eBayISAPI.dll?ShoppingCartMgmt");
									}, vjo.darwin.core.ebayheader.cart.Cart);
				})();
			</script>
			<!--[if IE 8]><style type="text/css">#idbtn{position:relative;top:5px;}</style><![endif]-->
			<div id="gnheader" class="gh-w">
				<div id="cobrandHeader"></div>
				<a href="#mainContent" rel="nofollow"
					style="display: block; position: absolute; left: -9999px">Skip
					to main content</a>
				<div>
					<!-- headerType=BASIC:HOMEPAGE:CGI-->
					<div>
						<script>
							new vjo.darwin.tracking.impression.Manager(
									"A67vBsqc*")
						</script>
					</div>
					<div class="gh-log">
						<!-- CODE STARTS HERE -->
						<div style="float: left; width: 240px;">
							<img src="img/Deals/ebaylogo_new.jpg"
								style="position: relative; top: 12px;" width="224" height="53"
								border="0" usemap="#Map_header" />
							<map name="Map_header" id="Map_header">
								<area shape="rect" coords="4,5,114,52" href="homepage.action"
									target="_top" alt="ebay homepage" />
								<area shape="rect" coords="116,5,222,51" href="homepage.action"
									target="_top" alt="dealfinder homepage" />
							</map>
						</div>
						<div
							style="font-weight: bold; float: left; margin-top: 15px; color: #666;">
							<!-- <form name="_sub" action="subscribe.php" method="post"
								onsubmit="var a=document.getElementById('dgfc').value;if(a==evrxv)return false;return true;">
								<input type="text" id="dgfc" name="dgfc" value=""
									style="color: #999999;"
									onfocus="if(this.value==evrxv)this.value='';"
									onblur="if(this.value=='')this.value=evrxv;" />&nbsp;<input
									id="idbtn" type="button"
									style="background: url('img/Deals/signup.jpg') no-repeat scroll 0 0 white; width: 63px; height: 21px; border: none;"
									title="Subscribe to our deals" value=""
									onclick="$(this).parent().submit();" />
							</form> -->
							<script type="text/javascript">
								document.getElementById('dgfc').value = evrxv;
							</script>
							<span class="greeting gh-ui" style="margin: 5px 0px 0px 0px;"><script
									type="text/javascript">
								vjo.darwin.core.greetings.VjGreetingsClient
										.writePersonalHeader(
												"Sign in",
												"loginfirst.action",
												"register",
												"registration.action",
												"Sign out",
												"signoutaction",
												"Welcome! ##1## or ##2##",
												"Hi, <b>##3##<\/b> (##1##)! ##2##",
												"Hi, (<b>##1##<\/b>)! (<a href=\"loginfirst.action\">Not you<\/a>?)",
												"Hello! <a href=\"loginfirst.action\"><\/a>.",
												"<img src=\"img/Deals/iconWarnRed_16x16.gif\" height=\"16\" width=\"16\" alt=\"Alert\">",
												"<span id=\"bta\">##1##<\/span>",
												" | You have <a href=\"http://my.ebay.in/ws/eBayISAPI.dll?MyEbay&amp;gbh=1&amp;ssPageName=STRK:ME:LNLK&amp;CurrentPage=MyeBayMyMessages\">##1## alert<\/a>.",
												" | You have <a href=\"http://my.ebay.in/ws/eBayISAPI.dll?MyEbay&amp;gbh=1&amp;ssPageName=STRK:ME:LNLK&amp;CurrentPage=MyeBayMyMessages\">##1## alerts<\/a>.",
												"1", "", true)
							</script> </span>
						</div>
						<div style="clear: both;"></div>
						<!--span class="gh-lg"><a href="http://www.ebay.in" rel="nofollow"> <img src="https://securepics.ebaystatic.com/aw/pics/in/logos/logoEbay_x45.gif" alt="eBay" border="0"></img></a></span><span class="coupon rebate" id="rbt" style="display:none"><img src="https://securepics.ebaystatic.com/aw/pics/promo/magic/pmoGleam10_150x23.gif" alt="">Must use Buy It Now and PayPal.<br/> <a href="http://www.ebay.in" target="_blank">See conditions</a><script type="text/javascript">vjo.darwin.core.ebayheader.rebate.RebateBox.Refresh("rbt", "10", "<img src=\"https://securepics.ebaystatic.com/aw/pics/icons/iconRedeemCoupon20x20.gif\" alt=\"Coupon\" border=\"0\" height=\"20\" width=\"20\"><\/img> <a href=\"http://my.ebay.in/ws/eBayISAPI.dll?MyeBay&amp;CurrentPage=MyeBayIncentives&amp;gbh=1\">You have coupons available<\/a>")</script></span><span></span-->
					</div>
					<div class="gh-rph">
						<img src="img/Deals/icons.jpg" />
						<!--span class="addllinks"><img src="https://securepics.ebaystatic.com/aw/pics/cart.gif" height="15" width="15"> <a href="http://orders.ebay.in/ws/eBayISAPI.dll?ShoppingCartMgmt">My Shopping Cart</a><span id="glb_cart"></span><script type="text/javascript">vjo.darwin.core.ebayheader.cart.Cart.init("glb_cart", "http://payments.ebay.in/ws/eBayISAPI.dll?GetCartDetails", "http://orders.ebay.in/ws/eBayISAPI.dll?ShoppingCartMgmt");</script> | <a href="http://orders.ebay.in/ws/eBayISAPI.dll?MyPaisaPaySummary">My PaisaPay</a> | <a href="http://pages.ebay.in/sitemap.html">Site Map</a></span-->
					</div>
					<div class="gh-cl"></div>
					<div class="gh-col">
						<b class="gh-c1"></b><b class="gh-c2"></b><b class="gh-c3"></b><b
							class="gh-c4"></b><b class="gh-c5"></b><b class="gh-c6"></b><b
							class="gh-c7"></b>
						<div class="gh-clr"></div>
					</div>
					<script type="text/javascript">
						var includeHost = "http://include.ebaystatic.com/";
					</script>
					<script src="js/ebaybase_v4_e7461in.js"></script>
					<script src="js/ebaysup_e7461in.js"></script>
					<script type="text/javascript">
						if (document.documentMode != 8
								&& document.compatMode != "CSS1Compat")
							ebay.oDocument._getControl("headerCommon")._exec(
									"writeStyleSheet");
					</script>
					<noscript>
						<link rel="stylesheet" type="text/css" href="css/ebay.css">
					</noscript>
					<div class="gh-ovr" id="gbh_ovl">
						<div class="gh-iovr"></div>
					</div>
					<a name="mainContent"></a>
				</div>
			</div>
			<script type="text/javascript">
				var _gaq = _gaq || [];
				_gaq.push([ '_setAccount', 'UA-29477980-1' ]);
				_gaq.push([ '_trackPageview' ]);
				(function() {
					var ga = document.createElement('script');
					ga.type = 'text/javascript';
					ga.async = true;
					ga.src = ('https:' == document.location.protocol ? 'https://ssl'
							: 'http://www')
							+ '.google-analytics.com/ga.js';
					var s = document.getElementsByTagName('script')[0];
					s.parentNode.insertBefore(ga, s);
				})();
			</script>
			<div style="padding-bottom: 10px;">&nbsp;</div>
		</div>
		<link rel="stylesheet" type="text/css" href="css/deals_v3.css" />

		<div class="container1 containerTextHldr">
			<div class="containerText">
				<div class="containerTextCont" style="float: left;">
					<a href="list.php?cat=1"> Mobiles </a>
					<!-- nbsp;<span class="tlct">(&nbsp;<s:iterator value="productTypeList1" status="type1List" var="tl1"><s:property value="#type1List.count"/></s:iterator>
						items&nbsp;)</span> -->
				</div>
				<div class="moreDeals">
					<a
						href="categories.action?CategoryID=<s:property value="categoryID1"/>">See
						more &gt;&gt;</a>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div class="container1 container">
			<div style="position: relative;">
				<div class="slider">
					<ul>
						<li><table width="792" border="0" cellspacing="0"
								cellpadding="0">
								<tr align="center">
									<s:iterator value="productTypeList1" status="type1List"
										var="tl1">
										<s:if test="%{#type1List.index < 4}">
											<td width="4" class="nodealCol">&nbsp;</td>
											<td width="193" class="dealCol"><div class="mdt">
													<s:property value="name" />
												</div>
												<div class="dealImg">
													<a href="#" target="_top" style="text-decoration: none;"><img
														src="productimages/<s:property value="image1"/>"
														class="lazy"
														data-original="productimages/<s:property value="image1"/>"
														width="93" height="140" border="0" style="top: 0px;">
														<noscript>
															<img src="productimages/<s:property value="image1"/>"
																alt="Product Image" border="0" height="80px"
																width="80px">
														</noscript> </a>
												</div> <!--div class="mdtSubTitle"></div-->
												<div class="priceDiv">
													<s:iterator value="#tl1.description" var="map">
														<s:if test='%{#map.key == "newprice"}'>
															<span class="WebRupee WebRupeeMain">Rs.</span>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="priceinfoDiv">
													MRP <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:property value="price" />
													| Save <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:iterator value="#tl1.description" var="map">
														<s:if test='%{#map.key == "save"}'>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="dealButton">
													<div style="float: left;">
														<span class="discDiv">-<s:iterator
																value="#tl1.description" var="map">
																<s:if test='%{#map.key == "discount"}'>
																	<s:property value="#map.value" />
																</s:if>
															</s:iterator>
															<s:property value="disc" />%
														</span>
													</div>
													<div style="float: right; padding-right: 5px;">
														<a
															href="products.action?productID=<s:property value="productID"/>"
															target="_top" style="text-decoration: none;"><img
															height="20" border="0" width="70"
															src="img/Deals/getit.jpg" /> </a>
													</div>
												</div></td>
											<td width="4" class="nodealCol">&nbsp;</td>
										</s:if>
									</s:iterator>
								</tr>
							</table></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container1 containerTextHldr">
			<div class="containerText">
				<div class="containerTextCont" style="float: left;">
					<a href="list.php?cat=1"> Movies </a>
					<!-- &nbsp;<span class="tlct">(&nbsp;<s:iterator value="productTypeList2" status="type2List" var="tl2"><s:property value="#type2List.count"/></s:iterator>
						items&nbsp;)</span> -->
				</div>
				<div class="moreDeals">
					<a
						href="categories.action?CategoryID=<s:property value="categoryID2"/>">See
						more &gt;&gt;</a>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div class="container1 container">
			<div style="position: relative;">
				<div class="slider">
					<ul>
						<li><table width="792" border="0" cellspacing="0"
								cellpadding="0">
								<tr align="center">
									<s:iterator value="productTypeList2" status="type2List"
										var="tl1">
										<s:if test="%{#type2List.index < 4}">
											<td width="4" class="nodealCol">&nbsp;</td>
											<td width="193" class="dealCol"><div class="mdt">
													<s:property value="name" />
												</div>
												<div class="dealImg">
													<a href="#" target="_top" style="text-decoration: none;"><img
														src="productimages/<s:property value="image1"/>"
														class="lazy"
														data-original="productimages/<s:property value="image1"/>"
														width="93" height="140" border="0" style="top: 0px;">
														<noscript>
															<img src="productimages/<s:property value="image1"/>"
																alt="Product Image" border="0" height="80px"
																width="80px">
														</noscript> </a>
												</div> <!--div class="mdtSubTitle"></div-->
												<div class="priceDiv">
													<s:iterator value="#tl2.description" var="map">
														<s:if test='%{#map.key == "newprice"}'>
															<span class="WebRupee WebRupeeMain">Rs.</span>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="priceinfoDiv">
													MRP <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:property value="price" />
													| Save <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:iterator value="#tl2.description" var="map">
														<s:if test='%{#map.key == "save"}'>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="dealButton">
													<div style="float: left;">
														<span class="discDiv">-<s:iterator
																value="#tl2.description" var="map">
																<s:if test='%{#map.key == "discount"}'>
																	<s:property value="#map.value" />
																</s:if>
															</s:iterator>
															<s:property value="disc" />%
														</span>
													</div>
													<div style="float: right; padding-right: 5px;">
														<a
															href="products.action?productID=<s:property value="productID"/>"
															target="_top" style="text-decoration: none;"><img
															height="20" border="0" width="70"
															src="img/Deals/getit.jpg" /> </a>
													</div>
												</div></td>
											<td width="4" class="nodealCol">&nbsp;</td>
										</s:if>
									</s:iterator>
								</tr>
							</table></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container1 containerTextHldr">
			<div class="containerText">
				<div class="containerTextCont" style="float: left;">
					<a href="list.php?cat=1"> Books </a>
					<!-- &nbsp;<span class="tlct">(&nbsp;<s:iterator value="productTypeList3" status="type3List" var="tl3"><s:property value="#type3List.count"/></s:iterator>
						items&nbsp;)</span> -->
				</div>
				<div class="moreDeals">
					<a
						href="categories.action?CategoryID=<s:property value="categoryID3"/>">See
						more &gt;&gt;</a>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div class="container1 container">
			<div style="position: relative;">
				<div class="slider">
					<ul>
						<li><table width="792" border="0" cellspacing="0"
								cellpadding="0">
								<tr align="center">
									<s:iterator value="productTypeList3" status="type3List"
										var="tl3">
										<s:if test="%{#type3List.index < 4}">
											<td width="4" class="nodealCol">&nbsp;</td>
											<td width="193" class="dealCol"><div class="mdt">
													<s:property value="name" />
												</div>
												<div class="dealImg">
													<a href="#" target="_top" style="text-decoration: none;"><img
														src="productimages/<s:property value="image1"/>"
														class="lazy"
														data-original="productimages/<s:property value="image1"/>"
														width="93" height="140" border="0" style="top: 0px;">
														<noscript>
															<img src="productimages/<s:property value="image1"/>"
																alt="Product Image" border="0" height="80px"
																width="80px">
														</noscript> </a>
												</div> <!--div class="mdtSubTitle"></div-->
												<div class="priceDiv">
													<s:iterator value="#tl3.description" var="map">
														<s:if test='%{#map.key == "newprice"}'>
															<span class="WebRupee WebRupeeMain">Rs.</span>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="priceinfoDiv">
													MRP <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:property value="price" />
													| Save <span class="WebRupee WebRupeeInfo">Rs.</span>
													<s:iterator value="#tl3.description" var="map">
														<s:if test='%{#map.key == "save"}'>
															<s:property value="#map.value" />
														</s:if>
													</s:iterator>
												</div>
												<div class="dealButton">
													<div style="float: left;">
														<span class="discDiv">-<s:iterator
																value="#tl3.description" var="map">
																<s:if test='%{#map.key == "discount"}'>
																	<s:property value="#map.value" />
																</s:if>
															</s:iterator>
															<s:property value="disc" />%
														</span>
													</div>
													<div style="float: right; padding-right: 5px;">
														<a
															href="products.action?productID=<s:property value="productID"/>"
															target="_top" style="text-decoration: none;"><img
															height="20" border="0" width="70"
															src="img/Deals/getit.jpg" /> </a>
													</div>
												</div></td>
											<td width="4" class="nodealCol">&nbsp;</td>
										</s:if>
									</s:iterator>
								</tr>
							</table></li>
					</ul>
				</div>
			</div>
		</div>
		<!--div class="container1 moreDeals"><a href="list.php?cat=17">See more &gt;&gt;</a></div-->
		<div style="clear: both;" class="container1"></div>
		<div class="container1 authTop">
			<link href="js/jquery-ui.css" rel="stylesheet" type="text/css" />
			<script src="js/jquery-ui.min.js"></script>
			<div class="authText">
				eBay.in Deals - Your Deal Retreat! <br /> <br />A new
				user-friendly platform that showcases all the deals featured on eBay
				while making your search much easier!
			</div>
			<div class="authAccord">
				<div id="accordion">
					<h3>
						<a href="#">What should I know about eBay.in Deals?</a>
					</h3>
					<div>
						It's raining Deals all through the year! With so many deals around
						you, there's a lot of room for confusion! We admit that searching
						for the right deals on specific products is not an easy job. So we
						got down to business and created the <b>eBay.in Deals</b>, just
						for you! <br /> <br />Find the best of deals under one roof at <b>eBay.in
							Deals</b> - A deal haven where you can trace all active deals on eBay
						India! Save time on extensive searching and let retail therapy
						work its wonder!
					</div>
					<h3>
						<a href="#">How does it work?</a>
					</h3>
					<div>All you have to do is choose a category from the options
						displayed on the top. With the help of sorting filters, refine
						your search to indicate the item of your choice and hit Find. This
						will fetch you all the deals currently active on the site for that
						particular product. The deals displayed are refreshed every week
						to include new launches and hot hits!</div>
					<h3>
						<a href="#">What will I find on eBay.in Deals?</a>
					</h3>
					<div>
						You will find countless deals on Laptops, Mobiles, DSLRs, Compact
						Cameras, Tablets, LCDs and more by Brand Giants like Samsung,
						Apple, Nikon, Blackberry, HTC, Nokia, Sony, FujiFilm, etc. <br />
						<br />No, we aren't forgetting Lifestyle! Find great deals on
						perfumes, watches, toys and nutrition too.
					</div>
					<h3>
						<a href="#">Free Shipping Bonanza!</a>
					</h3>
					<div>
						All the deals featured on <b>eBay.in Deals</b> provide shipping
						services that are absolutely free! Most of these deals provide
						flexible payment modes like EMI, Debit Card, Credit Cards and Cash
						on Delivery. <br /> <br />So when looking for a great shopping
						experience and discounted rates on all your favourite products and
						new launches, let <b>eBay.in Deals</b> lead the way for you!
					</div>
				</div>
			</div>
		</div>
		<!--div class="container1">
				<div style="float: left; background-color: #ffffff; padding-top: 10px;">
					<a href="http://deals.ebay.in/dotstyle/" style="text-decoration: none;padding-left:0px;">
						<img src="images/dotstyle.jpg" width="146" height="74" border="0" />
					</a>
					<a href="http://deals.ebay.in/deals/" style="text-decoration: none;padding-left:105px;">
						<img src="images/dow.jpg" width="95" height="72" border="0" />
					</a>
					<a href="http://deals.ebay.in/FoneZone/" style="text-decoration: none;padding-left:105px;">
						<img src="images/fonezone.jpg" width="180" height="56" border="0" />
					</a>
					<a href="http://deals.ebay.in/CameraZone/" style="text-decoration: none;padding-left:85px;">
						<img src="images/camerazone.jpg" width="202" height="56" border="0" />
					</a>
				</div>
				<div style="clear:both;"></div>
			</div-->


	</div>
	<div class="no-container" id="bgDivRight" style="width: 272px;">
		<div>
			<a class="sp-tp" href="javascript:;" id="ddTop"
				style="visibility: hidden;" title="Go to top"></a>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.lazyload.min.js"></script>
	<script type="text/javascript" src="js/counter_v1.js?nc=1365746874"></script>
	<script type="text/javascript">
		/*           */
		var google_conversion_id = 1011260784;
		var google_conversion_label = "WZu7CIjrogMQ8Lqa4gM";
		var google_custom_params = window.google_tag_params;
		var google_remarketing_only = true;
		/*     */
	</script>
	<script type="text/javascript" src="js/conversion.js"></script>
	<noscript>
		<div style="display: inline;">
			<img height="1" width="1" style="border-style: none;" alt=""
				src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/1011260784/?value=0&amp;label=WZu7CIjrogMQ8Lqa4gM&amp;guid=ON&amp;script=0" />
		</div>
	</noscript>
</body>
</html>
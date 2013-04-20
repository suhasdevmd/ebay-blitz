<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META name="XslBuildInfo"
	content="2013-03-15 12:44:06,,, uk`1d72f+2;ac,RcmdId MyEbayMyeBayMyAccounts,RlogId p4n%7Cceb%7Coiwi%3C%3Dpie3a57d.0%3Ecf-13dcbbe8b14-0xe9">
<title>Administration</title>
<link type="text/css" href="css/admin/adminhome.css" rel="stylesheet">

<link type="text/css" href="css/admin/adminhome1.css" rel="stylesheet">
<link type="text/css" href="css/admin/adminhome2.css" rel="stylesheet">
<link type="text/css" href="css/admin/adminhome3.css" rel="stylesheet">
<link type="text/css" href="css/admin/adminhome4.css" rel="stylesheet">



<style type="text/css">
.h_CustomLabel {
	text-align: center;
}

.h_SaleDate {
	text-align: left;
}

.h_Action {
	
}

.c_SaleDate {
	text-align: left
}
</style>



<script type="text/javascript">

function checkvalue() { 
	cat=document.getElementById('category').value; 
	subcat=document.getElementById('subcategory').value;
	
	
	if(!cat.match(/\S/)){
	alert ('Category cannot be empty.');
	return false;
	}
		
		return true;
	 
		
}


function checksub() { 
	 
	subcat=document.getElementById('subcategory').value;
	if (!subcat.match(/\S/)){
		 alert ("Subcategory cannot be empty.");
		 return false;
		}
		
		
		return true;
}
	



</script>


</head>
<body bgcolor="#ffffff">
	<div id="content">
		<div id="lyrGrayout_sec"
			style="visibility: hidden; position: absolute; z-index: 1"></div>
		<div id="urlOverLay"
			style="visibility: hidden; position: absolute; z-index: 2"></div>
		<div id="lyrProgressIndicator_sec1" class="dlgBdr"
			style="background-color: #eeeef8; visibility: hidden; position: absolute; z-index: 3">
			<div class="idtHrz"
				style="position: relative; text-align: center; top: 50%">
				<img border="0" alt=""
					src="http://pics.ebaystatic.com/aw/pics/express/images/imgLoading.gif">
				<div id="lyrProgressIndicator_msg" style="margin-top: 10px;"></div>
			</div>
		</div>
		<div id="SMSoldListingsActionOverLay"
			style="visibility: hidden; position: absolute; z-index: 2; border: solid 1px #666"></div>
		<form action="javascript:void(0);">
			<div id="outer_contentdiv"
				style="visibility: hidden; position: absolute; z-index: 2; width: 550px; height: 460px">
				<a href="javascript:void(0);" id="close_image" style="display: none"><span
					id="v4-8closebtn" class="basOlp-cbutton"><img
						src="http://pics.ebaystatic.com/aw/pics/buttons/btnClose_16x16.gif"
						border="0" alt="Close"> </span> </a>
				<div id="inner_contentdiv"></div>
				<button class="CloseForBtn" id="close_button" name="close_button"
					style="display: none; top: 400px;">
					<span class="b1"><span class="b2"><span class="b3">Close</span>
					</span> </span>
				</button>
			</div>
		</form>
		<div id="Shell">
			<a name="top"></a>
			<div class="pagewidth">
				<div class="pageminwidth">
					<div class="pagelayout">
						<div class="pagecontainer">
							<!-- Begin eBay Header -->
							<!--2013-03-15 12:44:06,,, uk`1d72f+2;ac,RcmdId MyEbayMyeBayMyAccounts,RlogId p4n%7Cceb%7Coiwi%3C%3Dpie3a57d.0%3Ecf-13dcbbe8b14-0xe9-->
							<div>

								<a class="gh-hdn" href="#mainContent">Skip to main content</a>
								<div id=gh class="gh-w gh-site-203"></div>
								<a name="mainContent"></a>

							</div>


							<%-- <table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td valign="middle" class="bc"><a
										href="http://www.ebay.in/?&amp;ssPageName=STRK:ME:BRED">Home</a>
										&gt; <a
										href="http://my.ebay.in/ws/eBayISAPI.dll?MyeBay&amp;ssPageName=STRK:ME:BRED">My
											eBay</a> &gt; <strong>My Account</strong>
									</td>
								</tr>
							</table> --%>
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								bgcolor="#7D81D7">
								<tr>
									<td>
										<div id="areaTitle"
											style="background: url(http://pics.ebaystatic.com/aw/pics/globalAssets/ltCurve.gif) no-repeat left top; background-color: #003ED0; border-color: #000066;">
											<h1 style="white-space: nowrap; color: #F1F1F1">Administration</h1>
											<div
												style="background-image: url(http://pics.ebaystatic.com/aw/pics/in/areaTitles/atMyeBay2.gif); overflow: hidden;">
												<div></div>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div id="bodyContent">
							<div class="leftClass" id="LeftNav">
								<table cellpadding="0" cellspacing="0" border="0" width="165"
									class="mt12" style="min-height: 500px;">
									<tr class="nbg">
										<td width="1" class="nlb" height="20"><img
											src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
											height="1" alt=""></td>
										<td class="mev" height="20" valign="middle" align="left"
											width="140">
											<h2 style="font-size: 13px;">
												<span> Admin Home </span>
											</h2>
										</td>
										<td class="roundtop" width="19" height="20" bgcolor="#d6dcfe"><img
											src="http://pics.ebaystatic.com/aw/pics/s.gif" width="19"
											height="20" alt=""></td>
									</tr>
									<tr>
										<td class="nb" width="100%" colspan="3">
											<dl id="c">
												<dt class="notgreylabel">
													<a href="manageUsers" id="my_MyeBaySummary">Manage
														Users</a>
												</dt>
											</dl>
											<div class="sep"></div>
											<dl id="c">
												<dt class="notgreylabel">
													<a href="adminhome.action?value=managecat"
														id="my_MyeBayAllBuying">Manage Categories</a>
												</dt>

											</dl>
											<div class="sep"></div>
											<dl id="c">
												<dt class="notgreylabel">
													<a href="viewfeedback" id="my_MyeBayShoppingCart">View
														Feedbacks </a>
												</dt>
											</dl>
											<div class="sep"></div>


											<dl id="c">
												<dt class="notgreylabel">
													<a href="manageorder" id="my_MyeBayShoppingCart">Manage
														Order </a>
												</dt>
											</dl>
											<div class="sep"></div></td>


									</tr>
								</table>
								<div class="s"></div>
								<a name="MiniLinks" id="MiniLinksAnchor"></a><img
									src="http://pics.ebaystatic.com/aw/pics/s.gif" height="15"
									width="1" alt=""><a name="" id="Anchor"></a> <img
									src="http://pics.ebaystatic.com/aw/pics/s.gif" height="15"
									width="1" alt="">
							</div>
							<div class="centerClass" id="ContainerWrapper">
								<div id="Container">
									<a name="" id="Anchor"></a>
									<%-- <table border="0" width="100%" cellpadding="1" cellspacing="0"
										bgcolor="#cecece">
										<tr width="100%">
											<td>
												<table border="0" width="100%" cellpadding="0"
													cellspacing="0" bgcolor="#FFFFFF" height="42">
													<tr>
														<td width="100%" class="A4" rowspan="2"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" hspace="6"
															alt=""><span class="A4B">Hello, </span><a
															href="http://myworld.ebay.in/suhasdevmd"><b
																class="g-hdn">Member id</b><span class="A4B">suhasdevmd</span>
														</a><img src="http://pics.ebaystatic.com/aw/pics/s.gif"
															width="4" border="0" alt=" ">(<a
															href="http://feedback.ebay.in/ws/eBayISAPI.dll?ViewFeedback&amp;userid=suhasdevmd&amp;ssPageName=STRK:ME:UFS"><b
																class="g-hdn">Feedback Score Of </b>0</a>) <br>
														</td>
														<td valign="middle" align="right"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" height="1"
															width="1" alt=""></td>
														<td rowspan="2"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" hspace="6"
															alt="">
														</td>
													</tr>
													<tr>
														<td width="150"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" height="1"
															width="150" alt="">
														</td>
													</tr>
												</table></td>
										</tr>
									</table> --%>
									<img src="http://pics.ebaystatic.com/aw/pics/s.gif" height="10"
										width="150" alt="">
									<table border="0" cellpadding="0" cellspacing="0" width="100%"></table>
									<img src="http://pics.ebaystatic.com/aw/pics/s.gif" height="8"
										width="1" alt="">


									<table cellpadding="0" cellspacing="0" border="0" width="100%">
										<tr>
											<td bgColor="#9999cc" colspan="3"><img height="2"
												src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
												alt=""></td>
										</tr>
										<tr bgColor="#d6dcfe" height="26">
											<td width="13"><img
												src="http://pics.ebaystatic.com/aw/pics/s.gif" width="13"
												height="1" alt=" " title=""></td>
											<td align="left" width="100%">
												<h2 class="A4B">Manage Category/Subcategory</h2>
											</td>
											<td align="right" bgcolor="#E2E7FE">
												<table cellpadding="0" cellspacing="0" border="0"
													height="100%">
													<tr height="100%">
														<td bgcolor="#ffffff" width="1" align="right"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" alt="">
														</td>
														<!-- <td noWrap="true" align="right"><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" width="4"
															alt=""><a
															href="http://pages.ebay.in/help/account/closing-account.html"
															target="_blank">Close My Account<b class="g-hdn">
																	- opens in a new window or tab</b> </a><img
															src="http://pics.ebaystatic.com/aw/pics/s.gif" width="4"
															alt=""></td> -->
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td bgColor="#9999cc" colspan="3"><img height="2"
												src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
												alt=""></td>
										</tr>
										<tr>
											<td><img src="http://pics.ebaystatic.com/aw/pics/s.gif"
												vspace="8" alt=""></td>
										</tr>
									</table>
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td></td>
										</tr>
										<tr>
											<td><img src="http://pics.ebaystatic.com/aw/pics/s.gif"
												height="10" width="1" alt=""></td>
										</tr>
									</table>
									<span id=""> <!--     manage category code starts ----------------------------- -->




										<div>
											<b>Category details</b>


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
														<!-- <th align="center"><h3>Update</h3>
														</th> -->
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
															<%-- <td><a
																href="viewfeedback.action?phKey=<s:property value = "phKey" />">
																	<s:property value="details" /> Update</a>
															</td> --%>
															<td><a
																href="deleteCategory.action?phKey=<s:property value = "phKey" />">
																	<s:property value="details" /> Delete</a>
															</td>
														</tr>
													</s:iterator>

												</table>
											</s:form>



										</div>

										<hr /> <!-- Add category detail --> <s:form
											action="addCategory" method="POST">
											<div>
												<b>Add Category details</b> <br /> <br />

												<div>


													<div>
														<s:textfield name="addCategory" theme="simple" id="category"></s:textfield>
														<s:submit name="addCatgry" value="Add Category"
															theme="simple" onclick="return checkvalue();"></s:submit>
													</div>
												</div>

												<s:if test="hasActionErrors()">
													<div class="errors">
														<s:actionerror />
													</div>
												</s:if>

											</div>
										</s:form>




										<hr /> <!-- Add Sub category details  --> <s:form
											action="addSubCategory">
											<div>
												<b>Add Subcategory details</b> <br /> <br /> <br />
												<div>
													<s:select label="Select a Category" headerKey="-1"
														headerValue="Select Category" list="categoryList"
														name="category" value="2" theme="simple" />


													<s:textfield name="subCategory" theme="simple"  id="subcategory"></s:textfield>
													<s:submit name="AddSubCategory" value="Add Sub Category"
														theme="simple" onclick="return checksub();"></s:submit>

												</div>
											</div>

										</s:form> <!-- manage category code ends ----------------------------------- -->




										<%-- 
										<table bgcolor="#ffcc00" border="0" cellpadding="1"
											cellspacing="0" width="100%">
											<tr>
												<td>
													<table bgcolor="#ffffff" border="0" cellpadding="0"
														cellspacing="0" width="100%">
														<tr width="100%">
															<td width="100%">
																<table border="0" cellpadding="3" cellspacing="0"
																	width="100%">
																	<tr bgcolor="#ffffcc" valign="center" height="25"
																		width="100%">
																		<td width="5"><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="5" height="1" alt="">
																		</td>
																		<td width="100%" class="A2B">Block / Unblock
																			users based on the feedback rating</td>
																	</tr>
																</table></td>
														</tr>
														<tr bgcolor="#ffcc00" width="100%">
															<td width="100%"><img
																src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
																height="1" alt="">
															</td>
														</tr>
														<tr>
															<td>
																<table cellspacing="0" cellpadding="3" width="100%"
																	border="0">
																	<tr>
																		<td><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="1" height="2" alt="">
																		</td>
																		<td><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="16" height="2" alt="">
																		</td>
																		<td width="100%"><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="400" height="2" alt="">
																		</td>
																	</tr>
																	<tr valign="top">
																		<td><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="5" height="1" alt="">
																		</td>
																		<!-- <td width="16"><img width="16" height="16"
																			src="http://pics.ebaystatic.com/aw/pics/in/checkout/syi1_16x16.gif"
																			alt=" ">
																		</td> -->
																		<!-- <td width="100%" class="A2">
																			<p>
																				<span class="A2B666">Fill out the Sell Your
																					Item form</span><br>The Sell Your Item form is where
																				you'll create your eBay listing. <a
																					href="http://pages.ebay.in/help/sell/listing_ov.html">Learn
																					more</a> about listing an item, or <a
																					href="http://sell.ebay.in/sell">go to the Sell
																					Your Item form</a>.
																			</p>
																		</td> -->


																		<!-- --------------------------------------------------------------------------- -->


																		<div>

																			<form action="ManageUserPostAction" method="post">


																				<br /> <br />

																				<table align="center" id="outer"
																					style="border: 2px solid black; border-width: 2px;">

																					<tr id="outer">
																						<th align="center"><h3>Seller Name</h3></th>
																						<th align="center"><h3>Average Rating</h3></th>
																						<th align="center"><h3>Block/Unblock</h3></th>
																					</tr>
																					<s:iterator value="sellerList">
																						<tr id="outer">
																							<td id="outer"><s:property value="name" />
																							</td>
																							<td id="outer"><s:set name="avg"
																									value="avgRating"></s:set> <s:if
																									test="%{#avg > 0}">
																									<s:property value="avgRating" />
																								</s:if> <s:else>-</s:else>
																							</td>
																							<td id="outer"><s:checkbox label=" "
																									name="SellerBlockList" fieldValue="%{Id}"
																									value="selectedDefault" theme="simple" /></td>

																						</tr>
																					</s:iterator>

																				</table>

																				<div align="right" style="margin-top: 40px;">
																					<input type="submit" name="UpdateBlockList"
																						value="UpdateBlockList" id="mysubmit"
																						align="right" />
																				</div>


																			</form>

																		</div>



















																	</tr>
																	<tr>
																		<td colspan="3"><img
																			src="http://pics.ebaystatic.com/aw/pics/s.gif"
																			width="1" height="1" alt="">
																		</td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
											</tr>
										</table> <img src="http://pics.ebaystatic.com/aw/pics/s.gif"
										vspace="15" alt=""> </span><a name="RecentFeedback"
										id="RecentFeedbackAnchor"></a> --%>






										<form name="RecentFeedback" method="post"
											action="http://my.ebay.in/ws/eBayISAPI.dll">
											<input type="hidden" name="MfcISAPICommand" value="MyeBay"><input
												type="hidden" name="CurrentPage" value="MyeBayMyAccounts"><input
												type="hidden" name="ReturnURL"
												value="http://mesgmy.ebay.in/ws/eBayISAPI.dll?ViewMyMessages&amp;&amp;FClassic=true&amp;ssPageName=STRK:ME:MMX&amp;CurrentPage=MyeBayMyMessages&amp;_trksid=p3984.m2295.l3912"><input
												type="hidden" name="View" value="RecentFeedback"><input
												type="hidden" name="SessionId" value="0"><input
												type="hidden" value="1" name="RecentFeedback.Page">
											<!-- <table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr bgcolor="#9C9C9C">
												<td colspan="3"><img height="1"
													src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
													alt=""></td>
											</tr>
											<tr height="25" width="100%" bgcolor="#D6DEFF">
												<td align="left"><img
													src="http://pics.ebaystatic.com/aw/pics/s.gif" width="16"
													alt=""></td>
												<td align="left" width="99%">
													<h3 class="B">Recent Feedback</h3>(<a
													href="http://feedback.ebay.in/ws/eBayISAPI.dll?ViewFeedback&amp;userid=suhasdevmd">View
														all Feedback</a>)

													<td noWrap="true" align="right"><a
													href="http://feedback.ebay.in/ws/eBayISAPI.dll?ReviseFeedbackInitiate">Request
														Feedback Revision</a><img
													src="http://pics.ebaystatic.com/aw/pics/s.gif" width="10"
													alt="">
												</td>
												</td>
												<td align="right"></td>
											</tr>
											<tr bgColor="#ffffff" width="100%">
												<td colspan="3"><img height="1"
													src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
													alt=""></td>
											</tr>
											<tr bgColor="#fed73b" width="100%">
												<td colspan="3"><img height="1"
													src="http://pics.ebaystatic.com/aw/pics/s.gif" width="1"
													alt=""></td>
											</tr>
										</table> -->
											<!-- <table cellSpacing="0" cellPadding="3" width="100%" border="0">
											<tr>
												<td>There are no Feedback messages to display.<br>
												</td>
											</tr>
										</table> 
										<hr height="1">-->
											<table cellpadding="1" cellspacing="0" border="0"
												width="100%" bgcolor="white">
												<tr>
													<td nowrap="true" valign="top" align="right">
														<table border="0" cellpadding="0" cellspacing="0"
															width="100%">
															<tr>
																<td nowrap align="right"><a href="#top">Back to
																		top</a></td>
															</tr>
														</table></td>
												</tr>
											</table>
										</form> <img src="http://pics.ebaystatic.com/aw/pics/s.gif"
										height="15" width="1" alt=""><a name="" id="Anchor"></a>
										<div style="width: 728; margin-bottom: 10px;" align="center">
											<div style="float: left"></div>
											<div style="float: right"></div>
											<div style="clear: both"></div>
										</div>
										<div style="margin: 10px 0 0 0;"></div> <img
										src="http://pics.ebaystatic.com/aw/pics/s.gif" height="15"
										width="1" alt="">
										<div id="footWrap">
											<div id="bContent">
												<table cellspacing="0" cellpadding="0" width="100%"
													border="0">
													<tr>
														<td></td>
													</tr>
												</table>
											</div>
											<div id="myEbayFooter" class="footerClass">

												<!--Begin eBay Footer-->
											</div>
										</div>
								</div>
							</div>
						</div>
						<!--End eBay Footer-->

					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="height: 500px;"></div>

	<div id="DialogBoxWrapper" style="display: none;" class="myactions"></div>
	<div id="menuPop" style="display: none;" class="menPop"></div>

	<div id="option_layer"
		style="position: absolute; z-index: 2; visibility: hidden"></div>

</body>
</html>

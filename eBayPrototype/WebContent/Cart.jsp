<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="css/cart1.css">
<link rel="stylesheet" type="text/css" href="css/cart2.css">
<link rel="stylesheet" type="text/css" href="css/cart3.css">


</head>
<body id="body">




	<div class="pagewidth">
		<div class="pageminwidth">
			<div class="pagelayout">
				<div class="pagecontainer">

					<div class="AreaTitle" id="AreaTitle">
						<div class="tbl1txt5">
							<div>
								<div class="tbl1totalco38">My Shopping Cart</div>
								<div class="tbl1totalco39">
									<span style="float: right"><h4 class="fontnormal">
											<a href=""><img src="" height="20" width="20" alt="Back"
												style="margin-right: 5px;" align="absmiddle" border="0">
											</a>
										</h4> <span><a href=""><b style="padding-right: 9px;">Back</b>
										</a> </span> </span>
								</div>
							</div>
						</div>
					</div>
					<div class="PageLevelMessageArea" id="PageLevelMessageArea">
						<div></div>
					</div>
					<div class="CentralArea" id="CentralArea">
						<table width="100%">
							<tbody>
								<tr>
									<td><div class="main-Div">
											<div class="main-Div">
												<div class="static-content">
													<br>
													<ul>
														<li class="margin-bottom">Your shopping cart might
															contain items from different sellers.</li>
														<li>To buy items from a specific seller, click the <b>Proceed</b>
															button below the seller's items.</li>
													</ul>

												</div>
												<div>
													<div>
														<div style="margin-bottom: 10px;"
															class="txt-black45bold bluegrayboxld">
															<div style="padding-left: 15px; padding-top: 5px;">Items
																in my cart</div>
														</div>
														<div>
															<div>
																<table width="100%" cellpadding="0" cellspacing="0"
																	border="0">
																	<body>
																	<tr>
																		<td width="75%" align="right"><div
																				style="padding-right: 60px">
																				<b>Price</b>
																			</div></td>
																		<td width="15%"><b>Quantity</b></td>
																		<td width="10%"><b>Sub-total</b></td>
																	</tr>

																</table>
																<div></div>
																<div>
																	<s:iterator value="sessionCart">
																		<div
																			style="margin: 10px 7px 10px 7px; font-size: small;"
																			class="txt-black45bold bluegrayboxld">
																			<div style="padding-left: 15px; padding-top: 5px;">
																				<div>
																					<div>
																						From seller:<span style="padding-left: 5px"><div
																								class="mbg">
																								<a href="sellerInformation.action?sellerID=<s:property value="sellerID"/>& productID=<s:property value="productID"/>" ></b><span
																									class="mbg-nw"> <s:property
																											value="sellerUserName" /> </span> </a> <span
																									class="mbg-l"> ( <a class="mbg-fb"
																									title="" href=""><b
																										class="g-hdn">Feedback Score Of</b> <s:property
																											value="feedbackScore" /> </a><img src="img/iconGreenStar_25x25.gif"
																									height="25" width="25" class="mbg-star"
																									title=""
																									alt="Green star icon for feedback score in between 5,000 to 9,999">)
																								</span> <span class="mbg-l"><a href=""><img
																										src="img/psIcon_50x25.gif" height="25" width="50"
																										alt="Member is a PowerSeller"
																										title="" border="0">
																								</a> </span>
																							</div> </span>
																					</div>
																				</div>
																			</div>
																		</div>
																		<div>
																			<div>
																				<form id="cartForm1" name="cartForm1" action="" method="post">

																					<input type="hidden" value="ShoppingCartMgmt"
																						name="MfcISAPICommand" /><input type="hidden"
																						name="bucketid" value="1" id="bucketid" /><input
																						type="hidden" name="sellerid" value="906839407"
																						id="sellerid" />

																					<s:iterator value="cartProduct">
																						<div>
																							<div>
																								<div style="display: inline-block; width: 100%;">
																									<div class="item-SummaryDiv"
																										style="position: relative;">
																										<div class="item-image">
																											<div style="Height: 80px; Width: 80px;">
																												<%-- <s:iterator> --%>
																													<a
																														href="product.action?productID=<s:property value="productID" />"><img
																														src="productimages/<s:property value="image1"/>"
																														alt='<s:property value="name"/>' height="80px" width="80px"
																														border="0"> </a>
																												<%-- </s:iterator> --%>
																											</div>
																										</div>


																										<div class="item-detailsDiv"
																											style="padding-top: 10px;">

																											<div>
																												<%-- <s:iterator> --%>
																												<div id="price">
																													<span
																														style="float: right; padding-right: 30px;">Rs.
																														<s:property value="price" /></span>
																												</div>
																												<a href="product.action?productID=<s:property value="productID" />"> <s:property value="name" />
																												</a>
																												
																												<%-- </s:iterator> --%>
																												<div></div>
																												<div id="v4-0"></div>
																											</div>
																										</div>
																										<div class="item-quantity">
																											<!-- <input name="bx_quantity" type="text"
											style="text-align: center" autocomplete="off" size="5"
											maxlength="5" class="item-quantityValue" value="1"> -->
																											<%-- <s:textfield id="quantitySelected" name="quantitySelected"
																												class="item-quantityValue" size="5"
																												cssStyle="text-align: center"
																												autocomplete="off" maxlength="5"
																												theme="simple" disabled="true">
																											</s:textfield> --%>
																											
																											
																										<s:property value="quantitySelected"/>	
																											
																										</div>
																										<div class="item-summ-body-subtotal-ssm">
																											<div style="float: left; padding-left: 0px;">Rs.</div>
																											<div style="float: right"><s:property value="subTotal" /> </div>
																										</div>
																										<div class="item-links"
																											style="position: absolute; bottom: 5px; right: 0px;">
																											<span>
																												<div id="link_300883651689_wrap"
																													class="basOlp-olp">
																													<div id="link_300883651689"
																														class="basOlp-oly">
																														<div class="basOlp-sdowbox">
																															<div class="basOlp-n">
																																<div class="basOlp-scn">
																																	<div class="basOlp-scn"></div>
																																</div>
																															</div>
																															<div class="basOlp-ctent"
																																id="link_300883651689olpshadow"></div>
																															<div class="basOlp-s">
																																<div class="basOlp-scn">
																																	<div class="basOlp-scn"></div>
																																</div>
																															</div>
																														</div>
																														<div id="link_300883651689olpctnbox"
																															class="basOlp-ctentbox">
																															<div id="link_300883651689_cnt_n"
																																class="basOlp-n">
																																<div class="basOlp-cn">
																																	<div class="basOlp-cn"></div>
																																</div>
																															</div>
																															<div class="basOlp-ctent"
																																id="link_300883651689olpcontent">
																																<div class="basOlp-hdr"
																																	id="link_300883651689olpctnhd">
																																	<div class="basOlp-hdr"
																																		id="link_300883651689olpctenttitle">
																																		<div>
																																			<span class="basOlp-cbutton"
																																				id="link_300883651689closebtn"></span>
																																		</div>
																																	</div>
																																</div>
																																<div class="basOlp-cc"></div>
																															</div>
																															<div class="basOlp-s">
																																<div class="basOlp-cn">
																																	<div class="basOlp-cn"></div>
																																</div>
																															</div>
																														</div>
																													</div>
																												</div>
																												|<a	href="cart.action?productID=<s:property value="productID"/>& removeFlag=1 ">Remove</a>|
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																						
																			</div>
																	</s:iterator>
																	<div style="margin-top: 0px;">
																		<table width="100%" style="background-image: url('""')>
																			<tr>
																				<td style="text-align: left"><div
																						class="tbl1totalco50">

																						<div style="padding-top: 8px;">

																							<div></div>
																						</div>
																						
																						<div style="padding-top: 5px;">
																							<span><b id="btn_v4-3"
																								class="bn-w bn-m bn-pad psb-S"><i>Proceed</i><span
																									id="spn_btn_v4-3" class="bn-b psb-b psb-S">
																										<!-- <input id="but_btn_v4-3" name="continue"
																										value="Proceed" title="" type="submit"> -->
																										<a id="but_btn_v4-3" name="continue" 
																										href="createorder.action?sellerID=<s:property value="sellerID"/>">Proceed</a> <b
																										id="txt_btn_v4-3">Proceed</b> </span> </b> </span><span
																								style="padding-left: 5px">The next step
																								is to select shipping method.</span>
																						</div>
																						
																					</div>
																				</td>
																				<td style="text-align: right; width: 206px"><div>
																						<div class="totalDivMain">
																							<div
																								style="float: left; width: 40%; text-align: right">Total:</div>
																							<div
																								style="float: left; width: 23%; text-align: right">Rs.</div>
																							<div style="float: right; width: 35%"><s:property value="total"/> </div>
																						</div>
																					</div>
																					<div class="updatelink">
																						<input type="hidden" name="action"
																							value="continue"><input type="hidden"
																							name="bucketid" value="1"><a href="updateCart.action?sellerID=<s:property value="sellerID"/>& updateTotal=1"
																							id="v4-4">Update total</a>
																					</div></td>
																			</tr>
																		</table>

																	</div>
																</div>
															</div>
															<div></div>
															</s:iterator>
														</div>
														
</body>
</html>
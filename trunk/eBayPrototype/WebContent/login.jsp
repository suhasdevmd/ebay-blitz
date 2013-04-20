<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>

<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/all.css">
</head>
<body>


	<div class="pagewidth">
		<div class="pageminwidth">
			<div class="pagelayout">
				<div class="pagecontainer">
					<div class="GlobalNavigation" id="GlobalNavigation">
						<div>


							<a class="gh-hdn" href="#mainContent">Skip to main content</a>
							<div id="gh" class="gh-wgh-site-203">
								<table id="gh-t">
									<tbody>
										<tr>
											<td id="gh-l"><a href="http://www.ebay.in" id="gh-la">eBay<img
													alt=""
													src="https://securepics.ebaystatic.com/aw/pics/s.gif"
													id="gh-logo" border="0"> </a></td>
											<td id="gh-u"></td>
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
						<div>
							<div>
								<div class="pt-c pt-rl pt-mar">
									<h1 class="pt-ct pt-tl">
										<div class="shpt">
											<span id="mainContent" class="sd-ds3Pt">Welcome to
												eBay</span>
										</div>
									</h1>
								</div>
							</div>

						</div>
					</div>
					<div class="PageLevelMessageArea" id="PageLevelMessageArea">
						<div></div>
					</div>
					<div class="CentralArea" id="CentralArea">
						<div class="sd-el">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tbody>
									<tr>
										<td valign="top"><div>
												<div>
													<div id="mainCnt" class="sd-bc">
														<div id="rContainer" class="sd-rCont"
															style="height: 331px;">
															<div class="sd-rcc" id="newUserCnt"
																style="margin-top: 106.5px;">
																<div class="sd-txtA">New to eBay?</div>
																<div class="sd-rts">Get started now. It's fast and
																	easy!</div>


																<!--  form for submitting the registration details  -->

																<s:form method="post" name="RegisterEnterInfo"
																	action="registration.action">
																	
																	
																	<div>
																		<!-- <input type="submit" name="register_signin"
																			title="Register" value="Register"
																			id="register_signin" class="btn btn-scnd sd-sgnBtn"> -->
																			
																			
																		<s:submit name="register_signin" id="register_signin"
																		value="Register" cssClass="btn btn-scnd sd-sgnBtn"></s:submit>	
																			
																			
																	</div>
																</s:form>


																<!-- form ends  -->
																<div></div>
															</div>
														</div>
														<div class="sd-lCont sd-lCont">
															<div>
																<span class="sd-txtA">Sign in</span>
																<div class="sd-spl">
																	<div>
																		<span><a href="javascript:;" class="sd-bhla"
																			id="v4-2"><span class="g-hdn">Sign in for
																					Help</span><b class="sd-bhli"> </b> </a>
																			<div id="bubbleCntOly_Outer" class="g-hdn"
																				style="visibility: hidden; width: 285px">
																				<div id="cnbubbleCnt">
																					<div>
																						<div class="sd-ttOvlC">
																							<div>
																								<div tabindex="0">Find out how to resolve
																									problems signing in, or learn about easy ways
																									to protect your account on eBay.</div>
																								<div class="sd-flnk">
																									<ul class="sd-lipn">
																										<li><a
																											href="http://pages.ebay.in/help/new/contextual/signin.html"
																											id="v4-0">Get sign in help<b
																												class="g-hdn">&nbsp;- opens in a new
																													window or tab</b> </a></li>
																										<li><a
																											href="http://pages.ebay.in/help/new/contextual/account_protection.html"
																											id="v4-1">Protect your account<b
																												class="g-hdn">&nbsp;- opens in a new
																													window or tab</b> </a></li>
																									</ul>
																								</div>
																							</div>
																						</div>
																					</div>
																					<a id="bubbleCnt_stA" href="javascript:;"
																						class="g-hdn">Start of Layer</a><a
																						id="bubbleCnt_enA" href="javascript:;"
																						class="g-hdn">End of Layer</a>
																				</div>
																			</div> </span>
																	</div>
																</div>
															</div>
															<div>


																<!--  form for submitting the sign in details  -->
																<!-- ////////////////////////////////////////// -->

															<s:actionerror/>


																<span><s:form name="Login" id="Login"
																		method="post" action="login.action">

																		<div>
																			<div class="disTxt"></div>
																			<div class="sd-uid">
																				<div class="sd-ezp">
																					<span><span class="sd-eym"></span> </span>
																				</div>
																				<div></div>
																				<div class="sd-sd">
																					<span class="sd-unl"><label for="userid">User
																							ID&nbsp;&nbsp;</label> </span>
																					<span>
																					
																					<!-- <input size="40"
																						maxlength="64" class="txtBxF" value="suhasdevmd"
																						name="userid" id="userid"> --> 
																						
																						
																						<s:textfield name="username" id="username"
																						maxlength="64" cssClass="txtBxF" size="40" theme="simple"></s:textfield>
																						
																						</span>
																				</div>
																				<div>
																					<span class="sd-unl"><label for="pass">Password&nbsp;&nbsp;</label>
																					</span>
																					
																					
																					<span>
																					
																					
																					
																					<!-- <input size="40" maxlength="64"
																						class="txtBxF" value="" name="pass" id="pass"
																						type="password"> --> 
																					
																					<s:password name="pass" id="pass" cssClass="txtBxF" 
																					maxlength="64" size="40" theme="simple"></s:password>	
																					
																					
																					</span>
																					<div>
																						<span class="sd-sv">Forgot your <a
																							href="https://scgi.ebay.in/ws/eBayISAPI.dll?UserIdRecognizerShow">user
																								ID</a> or <a
																							href="https://scgi.ebay.in/ws/eBayISAPI.dll?FYPShow">password</a>?</span>
																					</div>
																				</div>
																			</div>
																		</div>
																		<div class="sd-ezp">
																			<div class="sd-km">
																				<b class="sd-pcs"><input type="checkbox"
																					name="keepMeSignInOption" value="1" id="signed_in"
																					checked="checked"> </b><span class="sd-pcsm"><label
																					for="signed_in">Stay signed in</label> </span><span
																					class="sd-sgn">(Uncheck if you're on a
																					shared computer)</span>
																			</div>
																		</div>
																		<div class="sd-sb">
																			<!-- <input type="submit" name="sgnBt" title="Sign in"
																				value="Sign in" id="sgnBt"
																				class="btn btn-prim sd-sgnBtn"> -->


																			<s:submit name="sgnBt" value="Sign in" id="sgnBt"
																				cssClass="btn btn-prim sd-sgnBtn"></s:submit>

																		</div>
																		<div>
																			<object id="kgsl"
																				data="data:application/x-silverlight-2,"
																				type="application/x-silverlight-2" width="0"
																				height="0">
																				<param name="source"
																					value="https://secureinclude.ebaystatic.com/aw/pics/flash/global/features/krb/dist/krb.xap">
																				<param name="onLoad" value="onSilverlightLoad">
																				<param name="enableHtmlAccess" value="true">
																				<param name="onError" value="onSilverlightError">
																				<param name="background" value="Transparent">
																				<param name="windowless" value="true">
																				<param name="minRuntimeVersion" value="4.0.50826.0">
																				<param name="autoUpgrade" value="false">
																			</object>
																		</div>

																	</s:form> </span>
															</div>
														</div>
													</div>
												</div>
											</div></td>
									</tr>
								</tbody>
							</table>
							<div class="sd-bb">
								<div>
									<img src="img/signin_ebay_in_guarantee.jpg"
										alt="eBay.in Guarantee - opens in a new window or tab"
										class="sd-ebpd" style="width: 980px;" usemap="#ConfigMap">
									<map name="ConfigMap">
										<area
											href="http://pages.ebay.in/aboutebay/eBay_Guarantee.html"
											target="_blank"
											alt="eBay.in Guarantee - opens in a new window or tab"
											coords="0,0,975,100">
									</map>
								</div>
							</div>
						</div>

					</div>
					<div class="SupportiveNavigation" id="SupportiveNavigation">

					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>
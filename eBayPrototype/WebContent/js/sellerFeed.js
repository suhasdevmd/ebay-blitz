//<!--
//1@@m7

function EbayHTMLForm(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayHTMLForm";this.base=EbayHTML;this.base(pParent,pName,pName,false,pCfg);this.getElem=function(){return this.getDocElem(arguments[0],'forms');};this.enable=function(){};this.getElementValue=ebHTMLFormGetElementValue;this.setElementValue=ebHTMLFormSetElementValue;this.getElements=ebHTMLFormGetElements;this.getElement=ebHTMLFormGetElement;this.setAction=ebHTMLFormSetAction;this.getAction=ebHTMLFormGetAction;this.setTarget=ebHTMLFormSetTarget;this.getTarget=ebHTMLFormGetTarget;this.submit=ebHTMLFormSubmit;this.clear=ebHTMLFormClear;this.subscribeEvents("onsubmit");this.onBeforeSubmit=null;this.onAfterSubmit=null;}
function ebHTMLFormGetElements()
{var e=this.eElem;return e?e.elements:new Array;}
function ebHTMLFormGetElement(pName)
{var elems=this.getElements();return elems[pName]?elems[pName]:null;}
function ebHTMLFormGetElementValue(pName)
{var elems=this.getElements();if(elems[pName]&&elems[pName].value)
return elems[pName].value;return"";}
function ebHTMLFormSetElementValue(pName,pValue)
{var elems=this.getElements(),elem=elems[pName];if(elem)
{if(elem.length)
{for(var i=0,len=elem.length;i<len;i++)
elem[i].value=pValue;}
else
elem.value=pValue;}}
function ebHTMLFormSetAction(pAction)
{var e=this.eElem;if(e)
e.action=pAction;}
function ebHTMLFormGetAction()
{var e=this.eElem;if(e)
return e.action;}
function ebHTMLFormSetTarget(pTarget)
{var e=this.eElem;if(e)
e.target=pTarget;}
function ebHTMLFormGetTarget()
{var e=this.eElem;if(e)
return e.target;}
function ebHTMLFormSubmit()
{if(this.onBeforeSubmit)
this.onBeforeSubmit();var e=this.eElem;if(e)
{e.submit();if(this.onAfterSubmit)
this.onAfterSubmit();}
else
this.throwError("Element '"+this.sElemName+"' does not exist on the page","submit");}
function ebHTMLFormClear()
{var elems=this.getElements(),len=elems.length;for(i=0;i<len;i++)
{var elem=elems[i];var type=elem.type;switch(type)
{case"text":case"textarea":elem.value="";break;case"checkbox":elem.checked=false;break;case"select-one":elem.selectedIndex=0;}}}

//2@@m6

function EbayHTMLLayer(pParent,pName,pDisabled,pCfg)
{if(!this.objType)
this.objType="EbayHTMLLayer";this.base=EbayHTML;this.base(pParent,pName,pName,pDisabled,pCfg);this.aBindEvents=new Array;this.getElem=ebHTMLLayerGetElem;this.getValue=ebHTMLLayerGetValue;this.setValue=ebHTMLLayerSetValue;}
function ebHTMLLayerGetElem(pName)
{var s=pName,d=this.oDocument.doc;if(d.getElementById)
return d.getElementById(s);else if(d.all)
return d.all(s);this.throwWarning("Not supported","getElem");}
function ebHTMLLayerGetValue(pIsText)
{if(this.eElem)
{if(pIsText)
{if(this.oDocument.oGlobals.oClient.bFirefox)
return this.eElem.textContent;else
return this.eElem.innerText;}
else
return this.eElem.innerHTML;}
else
return"";}
function ebHTMLLayerSetValue(pVal,pIsText)
{if(this.eElem)
{if(pIsText)
{if(this.oDocument.oGlobals.oClient.bFirefox)
this.eElem.textContent=pVal;else
this.eElem.innerText=pVal;}
else
this.eElem.innerHTML=pVal;}}

//3@@m11

function EbayHTMLAnchor(pParent,pName,pDisabled,pCfg)
{if(!this.objType)
this.objType="EbayHTMLAnchor";this.base=EbayHTML;this.base(pParent,pName,pName,pDisabled,pCfg);this.getElem=ebHTMLAnchorGetElem;this.enableBase=this.enable;this.enable=ebHTMLAnchorEnable;this.subscribeEvents("onclick");}
function ebHTMLAnchorGetElem(pName)
{var d=this.oDocument.doc,l=null,len=null;l=d.links[pName];if(l)return l;if(d.getElementById)
l=d.getElementById(pName);if(l)return l;if(d.all)
l=d.all[pName];if(l)return l;if(d.layers)
{var lyrs=d.layers;len=lyrs.length;for(var i=0;i<len;i++)
{l=this.getElem(lyrs[i].document,pName);if(l)
return l;}}
len=d.links.length;for(var j=0;j<len;j++)
{l=d.links[j];if(typeof(l.name)=="undefined")
{if(l.onclick)
{var oc=l.onclick.toString();if(oc.indexOf("{#"+pName+"#}")!=-1)
return l;}}
else
{if(l.name==pName)
return l;}
l=null;}
return l;}
function ebHTMLAnchorEnable(pEnable)
{var cur=(pEnable)?"hand":"default";var el=this.eElem;if(el&&el.style)
{el.style.cursor=cur;el.style.color=pEnable?"":"gray";}
this.enableBase(pEnable);}
function setEbayLink(pS)
{return true;}

//4@@m7

function EbayHTMLImage(pParent,pName,pDisabled,pSource,pDisabledSource,pCfg)
{if(!this.objType)
this.objType="EbayHTMLImage";this.base=EbayHTML;this.base(pParent,pName,pName,pDisabled,pCfg);this.sEnabledSource=this.sDisabledSource=pSource;if(pDisabledSource)
this.sDisabledSource=pDisabledSource;this.getElem=ebHTMLImageGetElem;this.source=ebHTMLImageSource;this.enableBase=this.enable;this.enable=ebHTMLImageEnable;this.subscribeEvents("onclick","onmouseover","onmouseout");}
function ebHTMLImageGetElem(pName)
{return this.getDocElem(pName,'images');}
function ebHTMLImageSource(pSrc,pText)
{var im=this.eElem;if(typeof(im)=='undefined')
return;if(typeof(pSrc)=="undefined")
return(im)?im.src:"";else
{im.src=pSrc;if(pText!=null)
im.alt=pText;}}
function ebHTMLImageEnable(pEnable)
{with(this)
{enableBase(pEnable);if(sDisabledSource&&eElem)
eElem.src=(pEnable)?sEnabledSource:sDisabledSource;}}

//5@@m10

function EbayFlashUtil(pParent,pName)
{if(!this.objType)
this.objType="EbayFlashUtil";this.base=EbayBaseControl;this.base(pParent,pName);this.iSessionId=Math.ceil(Math.random()*1000000);this.getObjectRef=function(psName)
{if(this.oGlobals.oClient.bIE)
return window[psName];else
return window.document[psName];}
this.getControlVersion=function()
{var version,axo,e;try
{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7");version=axo.GetVariable("$version");}
catch(e)
{}
if(!version)
{try
{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6");version="WIN 6,0,21,0";axo.AllowScriptAccess="always";version=axo.GetVariable("$version");}
catch(e)
{}}
if(!version)
{try
{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.3");version=axo.GetVariable("$version");}
catch(e)
{}}
if(!version)
{try
{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.3");version="WIN 3,0,18,0";}
catch(e)
{}}
if(!version)
{try
{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash");version="WIN 2,0,0,11";}
catch(e)
{version=-1;}}
return version;}
this.getPlayerVersion=function()
{var flashVer=-1,oCL=this.oGlobals.oClient;if(navigator.plugins!=null&&navigator.plugins.length>0)
{if(navigator.plugins["Shockwave Flash 2.0"]||navigator.plugins["Shockwave Flash"])
{var swVer2=navigator.plugins["Shockwave Flash 2.0"]?" 2.0":"";var flashDescription=navigator.plugins["Shockwave Flash"+swVer2].description;var descArray=flashDescription.split(" ");var tempArrayMajor=descArray[2].split(".");var versionMajor=tempArrayMajor[0];var versionMinor=tempArrayMajor[1];if(descArray[3]!="")
tempArrayMinor=descArray[3].split("r");else
tempArrayMinor=descArray[4].split("r");var versionRevision=tempArrayMinor[1]>0?tempArrayMinor[1]:0;var flashVer=versionMajor+"."+versionMinor+"."+versionRevision;}}
else if(oCL.bIE&&oCL.bWin&&!oCL.bOpera)
flashVer=this.getControlVersion();return flashVer;}
this.detectFlashPlayer=function(pMajorVer,pMinorVer,pRev)
{var versionStr=this.getPlayerVersion(),oCL=this.oGlobals.oClient,aVer=[];if(versionStr==-1)
return false;else if(versionStr!=0)
{if(oCL.bIE&&oCL.bWin&&!oCL.bOpera)
{var tempArray=versionStr.split(" ");var tempString=tempArray[1];aVer=tempString.split(",");}
else
aVer=versionStr.split(".");var vMaj=aVer[0],vMin=aVer[1],vRev=aVer[2];if(vMaj>parseFloat(pMajorVer))
return true;else if(vMaj==parseFloat(pMajorVer))
{if(vMin>parseFloat(pMinorVer))
return true;else if(vMin==parseFloat(pMinorVer))
{if(vRev>=parseFloat(pRev))
return true;}}
return false;}}
this.getVersion=function()
{var fv=0,cl=this.oGlobals.oClient;if(cl.bIE&&cl.bWin&&!cl.bOpera)
{for(var i=10;i>=3;i--)
{if(cl.activeXLibLoaded("ShockwaveFlash.ShockwaveFlash."+i))
{fv=i;break;}}}
else
{if(navigator.plugins["Shockwave Flash"])
{var pd=navigator.plugins["Shockwave Flash"].description;var aDesc=pd.split(" ");if(aDesc.length&&aDesc[2])
fv=aDesc[2].split('.')[0];}
if(cl.bWebTV)fv=3;}
return fv;}
this.js2as=function(pConfig)
{var c=pConfig;var args=ebay.oUtils.oJSON.toJSON(c.aArgs);var o={sName:"gateway",aParameters:{Mod:c.sName,Func:c.sFunction,Args:args},sOutputDiv:"EbayFlashUtilOutputDiv"};this.writeFlash(o);}
this.initProject=function(pName,pCfg)
{pCfg.sName=pName;this.writeFlash(pCfg);}
this.writeFlash=function(pConfig)
{var c=pConfig,oD=this.oDocument;var writeObject=true;var version=this.getVersion();var install=c.bForceInstallFlash||false;if(version>=8||install)
{var html=this.getHTML(c);if(c.sOutputDiv)
{var d=new EbayHTMLLayer(this,c.sOutputDiv);d.bind();if(d.eElem)
{d.eElem.innerHTML=html;}}
else
{this.parent.write(html);}
oD.win[c.sName]=oD.getUIElem(c.sName);}}
this.getHTML=function(pConfig)
{var c=pConfig;var sub_domain=this.parent.oGlobals.oEnvironment.sIncludeHost;var bUseHttps=false,oCL=this.oGlobals.oClient,bObj=oCL.bIE&&oCL.bWin&&!oCL.bOpera;if(sub_domain.indexOf("https://")!=-1)
{bUseHttps=true;}
if(typeof(c.bUseSecureIncludePool)!="undefined"&&c.bUseSecureIncludePool==true)
{sub_domain=sub_domain.replace("http://include","http://secureinclude");}
if(sub_domain.indexOf("aw/pics/")==-1)
sub_domain+="aw/pics/";var swfpath=c.sSwfPath||sub_domain+"flash/global/features/"+c.sName+"/dist/"+c.sName+".swf";var obj=new EbayHtmlSourceNode("object");obj.id=c.sId||c.sName||"";if(!bObj)
{var e=obj.createNode("embed");e.name=c.sId||c.sName||"";e.type="application/x-shockwave-flash";e.pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash";}
obj.width=c.iWidth||"0";obj.height=c.iHeight||"0";if(e)
{e.width=c.iWidth||"0";e.height=c.iHeight||"0";}
if(bUseHttps)
obj.codebase=c.sCodebase||"https://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0";else
obj.codebase=c.sCodebase||"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0";obj.classid=c.sClassId||"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000";var p1=obj.createNode("param");p1.name="movie";p1.value=swfpath;if(e)
e.src=swfpath;var p2=obj.createNode("param");p2.name="wmode";p2.value=c.bWindowMode?"transparent":"";if(e)
e.wmode=c.bWindowMode?"transparent":"";var p3=obj.createNode("param");p3.name="salign";p3.value=c.sSAlign||"lt";if(e)
e.salign=c.sSAlign||"lt"
var p4=obj.createNode("param");p4.name="scale";p4.value=c.sScale||"noscale";if(e)
e.scale=c.sScale||"noscale";var p5=obj.createNode("param");p5.name="menu";p5.value=c.bMenu?"true":"false";if(e)
e.menu=c.bMenu?"true":"false";if(!c.aParameters)
c.aParameters=new Object();c.aParameters.Host="http://"+this.parent.oGlobals.oEnvironment.sThisPageHost+"/";c.aParameters.SessionId=this.iSessionId;c.aParameters.FrameId=window.name!=""?window.name:"_self";var flashvars="",bFVPrefix=typeof(c.bUseFVPrefix)!='undefined'?c.bUseFVPrefix:true;for(var node in c.aParameters)
{flashvars+=(bFVPrefix?"fv":"")+node+"="+c.aParameters[node]+"&";}
var p6=obj.createNode("param");p6.name="flashvars";p6.value=flashvars;if(e)
e.flashvars=flashvars;var p7=obj.createNode("param");p7.name="allowScriptAccess";p7.value="always";if(e)
e.allowScriptAccess="always";return obj.getHTML();}
this.init=function()
{this.parent.write("<div id='EbayFlashUtilOutputDiv'></div>");}
this.init();}
ebay.oUtils.oFlash=new EbayFlashUtil(ebay.oDocument,"FlashUtil");function EbayFlashProjects(pParent,pName)
{if(!this.objType)
this.objType="EbayFlashProjects";this.base=EbayFlashUtil;this.base(pParent,pName);}
new EbayFlashProjects(ebay.oDocument,"FlashProjects");

//6@@m24

function EbayHTMLFrame(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayHTMLFrame";this.base=EbayHTML;this.base(pParent,pName,pName,false,pCfg);this.eFrameElem=null;this.getElem=ebHTMLFrameGetElem;this.bindHTML=ebHTMLFrameBindHTML;this.bindEvents=this.enable=function(){};this.setSource=ebHTMLFrameSetSource;this.cleanupMemoryBase=this.cleanupMemory;this.cleanupMemory=ebHTMLFrameCleanupMemory;this.resize=ebHTMLFrameResize;this.onBeforeResize=this.onAfterResize=null;}
function ebHTMLFrameGetElem(pName)
{with(this)
{var f=null,oD=oDocument;var d=oD.doc,w=oD.win;if(w.frames)
f=eFrameElem=w.frames[pName];if(d.getElementById)
f=d.getElementById(pName);return f;}}
function ebHTMLFrameBindHTML()
{with(this)
{eElem=getElem(sElemName);if(eElem)
assignJSObject(eElem);}}
function ebHTMLFrameCleanupMemory()
{this.cleanupMemoryBase();this.eFrameElem=null;}
function ebHTMLFrameSetSource(pURL)
{if(pURL==null||pURL.trim()==''){return;}
with(this)
{oDocument.setGlobalParent(this);if(pURL.has("ej2child=true"))
pURL+="&ej2parent="+name;if(eFrameElem&&eFrameElem.location)
eFrameElem.location.replace(pURL);else if(eElem)
eElem.src=pURL;}}
function ebHTMLFrameResize(pMaxWidth)
{with(this)
{if(onBeforeResize)
onBeforeResize();var f=eFrameElem;if(!f||!(f.document||f.contentDocument))
f=getElem(sElemName);if(f&&typeof(f.document)!="unknown")
{var oDoc=f.document?f.document:f.contentDocument,db=oDoc.body,es=eElem.style,c=this.parent.oGlobals.oClient,w="100%",h=db.offsetHeight,oh;if(c.bSafari)
{oh=db.offsetHeight;w=oDoc.width;h=ebay.oDocument.doc.doctype!=null?oDoc.height+15:oDoc.height+1;}
else if(c.bFirefox)
{w=oDoc.width;h=oDoc.height}
else if(c.bWin||c.bOpera)
{w=db.scrollWidth;h=c.bNav&&ebay.oDocument.doc.doctype!=null?db.scrollHeight+30:db.scrollHeight;}
if(pMaxWidth&&c.bFirefox)
w="100%";if(this.oConfig)
{w=this.oConfig.iWidth||w;h=this.oConfig.iHeight||h;}
es.width=(w=="100%")?w:w+"px";es.height=h+"px";if(onAfterResize)
onAfterResize();}}}

//7@@m25

function EbayHTMLOverlay(pParent,pName,pCfg,pDisabled)
{if(!this.objType)
this.objType="EbayHTMLOverlay";this.base=EbayHTMLLayer;this.base(pParent,pName,pDisabled,pCfg);this.isSupported=ebIsBrowserSupported;if(!this.isSupported())
return;this.sPosStyle=pCfg.posStyle||'absolute';this.sTop=pCfg.top;this.iTopPadding=0;this.iLeftPadding=0;this.sLeft=pCfg.left;this.sWidth=pCfg.width?parseInt(pCfg.width):0;this.sHeight=pCfg.height?parseInt(pCfg.height):0;this.sLayerHTML=pCfg.layerHTML||"";this.sContentDiv=pCfg.contentDiv||"";this.bForceReposition=pCfg.bForceReposition||false;this.bNoSetContent=pCfg.bNoSetContent;this.bClearValueOnClose=typeof(pCfg.bClearValueOnClose)!='undefined'?pCfg.bClearValueOnClose:true;this.bCustomHTML=pCfg.customHTML||false;this.bTransparent=pCfg.transparent||false;this.setPosition=ebHTMLOverlaySetPosition;this.centerTop=ebHTMLOverlayCenterTop;this.centerLeft=ebHTMLOverlayCenterLeft;this.setContent=ebHTMLOverlaySetContent;this.closeOverlay=this.close=ebHTMLOverlayCloseOverlay;this.display=ebHTMLOverlayDisplay;}
function ebHTMLOverlayDisplay(pContent)
{with(this)
{if(!eElem)
bind();if(!bNoSetContent)
setContent(pContent);setPosition();show(true);if(this.oConfig.bOnFocus&&(!(oGlobals.oClient.bIE&&oGlobals.oClient.iVer<7)))
{var sFirstInsElem="sFirstInsElem";var oFirstEle=this.eElem.firstChild;if(oFirstEle.id!=sFirstInsElem)
{var anchorTag=document.createElement('a');anchorTag.href="javascript:void(0);";anchorTag.id=sFirstInsElem;anchorTag.style.outline="0px solid #FFFFFF";anchorTag.style.position="absolute";anchorTag.style.left="-10000em";anchorTag.style.opacity=0;anchorTag.style.width="1px";anchorTag.style.height="1px";var sLyrName=this.oConfig.sStartLyrName;if(sLyrName)
anchorTag.innerHTML="<b class='g-hdn'>"+sLyrName+"</b>";try{this.eElem.setAttribute('role','dialog');anchorTag.setAttribute('aria-ignore','true');}catch(e){}
this.eElem.insertBefore(anchorTag,oFirstEle);anchorTag.focus();}
else
oFirstEle.focus(true);}}}
function ebHTMLOverlaySetPosition()
{with(this)
{if(sPosStyle.is('absolute'))
{if(!sTop||bForceReposition)
centerTop();if(!sLeft||bForceReposition)
centerLeft();top(sTop);left(sLeft);}}}
function ebHTMLOverlayCenterTop()
{with(this)
{var oD=oDocument,winHeight=oD.doc.body.clientHeight,cL=oGlobals.oClient;if(!cL.bIE)
winHeight=oD.win.innerHeight;else if(typeof(winHeight)=='undefined'&&cL.iVer>=6)
winHeight=oD.doc.documentElement.clientHeight;var s=oD.doc.body.scrollTop+(winHeight-sHeight)/2;if(document.documentElement)
s+=document.documentElement.scrollTop;sTop=(parseInt(s)+iTopPadding)+'px';return s;}}
function ebHTMLOverlayCenterLeft()
{with(this)
{var winWidth=document.body.clientWidth,cL=oGlobals.oClient;if(!cL.bIE)
winWidth=window.innerWidth;var s=winWidth/2-sWidth/2;sLeft=(parseInt(s)+iLeftPadding)+'px';return s;}}
function ebHTMLOverlaySetContent(pContent)
{with(this)
{if(sContentDiv!='')
{var oL=new EbayHTMLLayer(this,sContentDiv);oL.bind();oL.setValue(pContent);}
else
setValue(pContent);}}
function ebHTMLOverlayCloseOverlay()
{with(this)
{if(bClearValueOnClose)
{var cts=this.controls;if(sContentDiv!=''&&cts[sContentDiv])
{cts[sContentDiv].setValue('&nbsp;');}
else
{setValue('&nbsp;');if(this.oConfig.bOnFocus&&this.oSelectedElem)
{ele=this.controls[this.oSelectedElem.name];if(ele)
ele.focus(true);}}}
show();if(!this.oGlobals.oClient.bFirefox)
cleanupMemory();}}
function ebIsBrowserSupported()
{var cL=this.oGlobals.oClient,bNS4=document.layers;if(bNS4||(cL.bMac&&!cL.bMacppc&&!cL.bMactel))
return false;return true;}

//8@@m14

function EbayHTMLOverlayUrl(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayHTMLOverlayUrl";this.base=EbayHTMLOverlay;this.base(pParent,pName,pCfg);if(!this.isSupported())
return null;this.sUrl=pCfg.url||null;this.sIframeName='if_'+pName;this.sIframeTitle=pCfg.sIframeTitle||null;this.sLayerUI=pCfg.layerHTML;this.bAutoResize=pCfg.autoResize;this.bCloseLink=pCfg.defCloseLink;this.bDowngradeDomain=true;this.bTransparent=pCfg.bTransparent;this.displayBase=this.display;this.display=ebHTMLOverlayUrlDisplay;this.hide=this.closeOverlay;this.closeOverlayBase=this.closeOverlay;this.closeOverlay=ebHTMLOverlayUrlCloseOverlay;this.closeLayerUI=ebHTMLOverlayUrlCloseLayer;this.setCloseLayer=ebHTMLOverlayUrlSetCloseLayer;this.getIFUrl=ebHTMLOverlayUrlGetIFUrl;this.setDowngrade=ebHTMLOverlayUrlSetDowngradeDomain;this.onAfterFrameLoad=ebHTMLOverlayUrlAfterFrameLoad;}
function ebHTMLOverlayUrlDisplay()
{with(this)
{if(!sUrl)
return;var s=getIFUrl();if(oGlobals.oEnvironment.sThisPageRaw==sUrl)
return;if(bCloseLink)
s+=setCloseLayer();displayBase(s);new EbayHTMLFrame(this,sIframeName);}}
function ebHTMLOverlayUrlSetCloseLayer()
{with(this)
{sLayerHTML=closeLayerUI()+sLayerUI;var a=new EbayHTMLAnchor(this,'close');a._registerEvent("onclick","this.parent.hide();return false;");}}
function ebHTMLOverlayUrlCloseLayer()
{var s='';var stl='border-collapse:collapse; border-width:2px 2px 0px 2px; background-color:#EEEEEE;border-style:outset;';with(this)
{var pd=oGlobals.oEnvironment.sPicsDir,img=pd+'icon/iconClose_20x20.gif',w=parseInt(sWidth)+4;s+='<table id="tblClose" width="'+w+'" cellspacing="0" cellpadding="4"';s+='style="'+stl+'">';s+='<tr><td align="right"><a href="#" name="close"><img src="'+img+'" border="0"></a>';s+='</td></tr></table>';}
return s;}
function ebHTMLOverlayUrlGetIFUrl()
{var s='';with(this)
{sUrl=setDowngrade(sUrl);if(sUrl.has("ej2child=true"))
{sUrl+="&ej2parent="+this.name;oDocument.setGlobalParent(this);}
s+='<iframe frameborder="no" border="0" marginwidth="0" marginheight="0"';s+=oConfig.bScrolling?' scrolling="auto"':' scrolling="no"';s+=' id="'+sIframeName+'" title="'+sIframeTitle+'" name="'+sIframeName+'"';s+=' src="'+sUrl+'"';s+=' width="'+sWidth+'" height="'+sHeight+'"';if(oConfig.sIframeClass)
s+=' class="'+oConfig.sIframeClass+'"';if(bTransparent)
s+=' allowtransparency="true"';s+='></iframe>';}
return s;}
function ebHTMLOverlayUrlSetDowngradeDomain(pUrl)
{if(!pUrl.has('downgradeDomain=true')&&this.bDowngradeDomain==true)
{pUrl+=!pUrl.has('?')?'?':'&';pUrl+='downgradeDomain=true';}
return pUrl;}
function ebHTMLOverlayUrlAfterFrameLoad()
{with(this)
{var ifObj=controls[sIframeName];if(!ifObj.eElem)ifObj.bind();if(bAutoResize)
ifObj.resize();if(bCloseLink)
{var e=oDocument.doc.getElementById('tblClose');ifObj.width(parseInt(e.style.width)+4);}}}
function ebHTMLOverlayUrlCloseOverlay()
{with(this)
{var ifObj=controls[sIframeName],cl=oGlobals.oClient;ifObj.bind();if(!cl.bFirefox)
ifObj.setSource(oGlobals.oEnvironment.sPicsDir+'tbx/s.gif');ifObj.cleanupMemory();setTimeout(oUtils.controlPath(this)+'.closeOverlayBase()',100);}}

//9@@m8

function EbaySYI3Grayout(pParent,pName)
{if(!this.objType)
this.objType="EbaySYI3Grayout";this.base=EbayBaseControl;this.base(pParent,pName);this.oLayer=new EbayHTMLLayer(this,'lyrGrayout_sec');this.aSelElems=this.oDocument.doc.getElementsByTagName('SELECT');this.aExcludeSelElems=[];this.bDisableSelElems=true;this.display=function(pWidth,pHeight,pPosArray)
{var oL=this.oLayer,pos=pPosArray;if(!oL.eElem)
oL.bind();oL.width(pWidth+'px');oL.height(pHeight+'px');oL.show(true);oL.left((pos?pos[0]:0)+'px');oL.top((pos?pos[1]:0)+'px');oL.setValue("");if(this.bDisableSelElems)
this.disableSelElems(true);}
this.hide=function()
{var oL=this.oLayer;oL.show(false);if(this.bDisableSelElems)
this.disableSelElems(false);}
this.disableSelElems=function(pDisable)
{if(pDisable)
this.aExcludeSelElems=[];var aS=this.aSelElems,l=aS.length;for(var i=0;i<l;i++)
{if(pDisable&&aS[i].disabled)
this.aExcludeSelElems[this.aExcludeSelElems.length]=aS[i].name;if(!pDisable&&this.oUtils.isInArray(this.aExcludeSelElems,aS[i].name))
continue;aS[i].disabled=pDisable;}}}

//10@@m1

ebay.oDocument.oPage.iAutoLoadCookieBit=19;ebay.oDocument.oPage.hasAutoLoadCookieBit=function()
{var oCJ=ebay.oDocument.oCookieJar,sbf=oCJ.readCookielet('ebay','sbf'),iBit=0;if(sbf)
{iBit=oCJ.getBitFlag(sbf,this.iAutoLoadCookieBit);}
return(iBit)?true:false;}
ebay.oDocument.oPage.setAutoLoadCookieBit=function(pValue)
{var oCJ=ebay.oDocument.oCookieJar,sbf=oCJ.readCookielet('ebay','sbf');sbf=oCJ.setBitFlag(sbf,this.iAutoLoadCookieBit,pValue);oCJ.writeCookielet('ebay','sbf',sbf);}

//11@@m2

function ebayGuestbookAddEntry(pPar,pName,pCfg){if(!this.objType)
this.objType="GuestbookAddEntry";this.base=EbayBaseControl;this.base(pPar,pName);this.oC=pCfg;this.init=function()
{with(this)
{this.oA,this.oObj;aLinks=oC.aAddGBEntry;this.oMask=new EbayMaskLayer(ebay.oDocument.oPage,'EbayOverLayCombo_mask');for(i=0;i<aLinks.length;i++)
{oA=new EbayHTMLAnchor(this,oC.aAddGBEntry[i]);if(!oA.eElem)
oA.bind();if(oA.eElem)
{oObj=oA;oA.eElem.href="javascript:void(0)";}
oA.show(true);oA._registerEvent("onclick","parent.parent.showPopUp")}
if(oC.bOpenOverlay&&this.parent.hasAutoLoadCookieBit()){ebay.oDocument.oPage.clearOptionCookie();this._registerListener(ebay.oDocument._getEvent('load'),this.EVENT_BEFORE,'parent.showPopUp');}}}
this.init();}
ebay.oDocument.oPage.showPopUp=function()
{var o=ebay.oDocument.getConfig("MyWorld.Homepage.GuestbookAddEntry");var oM=ebay.oDocument.oPage.controls['EbayOverLayCombo_mask'];var oDiv=new EbayHTMLOverlayUrl(ebay.oDocument.oPage,o.sAddGBEntryDiv,o);if(!oDiv.eElem)
oDiv.bind();oDiv.sUrl=o.sUrl;oDiv.sWidth=o.sWidth;oDiv.sHeight=o.sHeight;oDiv.bDowngradeDomain=false;if(oM){oM.getDisableControls();oM.show(true);}
var oC=ebay.oDocument.getConfig("MyWorld.Homepage.Guestbook");if(oC){var oTopDiv=new EbayHTMLLayer(ebay.oDocument.oPage,oC.flashLayerName);if(!oTopDiv.eElem)
oTopDiv.bind();oTopDiv.show();var oSpacerDiv=new EbayHTMLLayer(ebay.oDocument.oPage,o.sSpacerDiv);if(!oSpacerDiv.eElem)
oSpacerDiv.bind();oSpacerDiv.height("520px");}
oDiv.iTopPadding=0;if(!this.oGlobals.oClient.bIE)
{oDiv.bForceReposition=true;oDiv.sHeight=parseInt(o.sHeight)+8;}
else{oDiv.bForceReposition=false;oDiv.sTop=ebay.oDocument.oPage.setOverlayPosition(oDiv.sHeight,oDiv.iTopPadding)
if(oC)
oSpacerDiv.height(520);}
if(oC)
oSpacerDiv.show(true);oDiv.display();return false;}
ebay.oDocument.oPage.clearOptionCookie=function()
{this.setAutoLoadCookieBit('0');}
ebay.oDocument.oPage.setOverlayPosition=function(sHeight,iTopPadding)
{var oD=ebay.oDocument;var winHeight=oD.doc.documentElement.clientHeight;var s=oD.doc.body.scrollTop+(winHeight-sHeight)/2;if(oD.doc.documentElement)
s+=oD.doc.documentElement.scrollTop;sTop=(parseInt(s)+iTopPadding)+'px';return s;}

//12@@m2

function EbayMaskLayer(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayMaskLayer";this.base=EbayHTMLLayer;this.base(pParent,pName,pCfg);this.bodyLoc=ebay.oDocument.doc.getElementsByTagName("body")[0];this.aDisableControl=new Array();this._registerListener(ebay.oDocument._getEvent('resize'),this.EVENT_AFTER,'resize');this._registerListener(ebay.oDocument._getEvent('load'),this.EVENT_BEFORE,'_createElement');this.baseShow=this.show;this.show=function(pShow)
{with(this)
{var st=(pShow)?'block':'',db=document.body,bsel=(pShow)?true:false,bShown=false;;top(0);left(0);width(ebay.oGlobals.oClient.getScrollWidth()+'px');height(ebay.oGlobals.oClient.getScrollHeight()+'px');with(eElem.style)
{bShown=display!='none';display=st;opacity=0.35;filter='alpha(Opacity=35)';backgroundColor='#cccccc';}
baseShow(pShow,true);enableControls(!pShow);}}
this.resize=function()
{if(this.eElem&&this.eElem.style.visibility=='visible')
{this.width(ebay.oGlobals.oClient.getScrollWidth()+'px');this.height(ebay.oGlobals.oClient.getScrollHeight()+'px');}}
this._createElement=function()
{with(this)
{if(this.getElem())return;var oDI=ebay.oDocument.oPage.oDebugInfo;oDI.start();var mask=oDocument.doc.createElement('DIV');mask.setAttribute('id',name);with(mask.style)
{position='absolute';display='none';top='0px';left='0px';zIndex=2;}
bodyLoc.appendChild(mask);bind();oDI.add(this.objType+'._createElement()',oDI.end());}}
this.enableControls=function(pEnable)
{with(this)
{for(var i=0;i<aDisableControl.length;i++)
{var e=aDisableControl[i];e['elem'].disabled=pEnable?e['status']:true;}
if(pEnable)
aDisableControl=new Array();}}
this.getDisableControls=function()
{if(this.aDisableControl.length==0)
{var eSel=[],i,d=this.oDocument.doc;if(d.getElementByTag)
eSel=d.getElementByTag('select');else if(d.all)
eSel=d.all.tags('select');this.aDisableControl=new Array();for(i=0;i<eSel.length;i++)
{var e={'elem':eSel[i],'status':eSel[i].disabled};this.aDisableControl.push(e);}}}}

//13@@m2

function DebugInfo()
{this.aStartTime=new Array();this.aData=new Array();this.add=function(pName,pNum)
{if(!this.aData[pName])
{this.aData[pName]=new Array();this.aData[pName]['number']=0;this.aData[pName]['count']=0;}
this.aData[pName]['number']+=pNum;this.aData[pName]['count']++;}
this.serialize=function()
{with(this)
{var strReturn='';for(var n in aData)
{var data=aData[n],dataNum=data['number'],dataCount=data['count'];strReturn+=n+'\n';strReturn+='total = '+dataNum+'\n';strReturn+='average = '+dataNum/(dataCount==0?1:dataCount)+'\n';strReturn+='count = '+dataCount+'\n';strReturn+='==========================\n';}
return strReturn;}}
this.getCurTime=function()
{var d=new Date();return d.getTime();}
this.start=function()
{this.aStartTime.push(this.getCurTime());}
this.end=function()
{return(this.getCurTime()-this.aStartTime.pop());}}
if(!ebay.oDocument.oPage.oDebugInfo)
ebay.oDocument.oPage.oDebugInfo=new DebugInfo();

//14@@m6

ebay.oDocument.oPage.hideHTMLComments=function()
{var c=this.oCommentCfg=this.parent.getConfig("MyWorld.Homepage.Guestbook");if(c)
{var ortLyr=this._getControl(c.flashLayerName);if(!ortLyr)
{ortLyr=new EbayHTMLLayer(this,c.flashLayerName);ortLyr.bind();}
if(ortLyr&&ortLyr.eElem)
ortLyr.eElem.style.visibility='hidden';}}
ebay.oDocument.oPage._registerListener(ebay.oDocument._getEvent("footer"),ebay.oDocument.EVENT_BEFORE,"hideHTMLComments");ebay.oDocument.oPage.initComments=function()
{var c=this.oCommentCfg=this.oCommentCfg||this.parent.getConfig("MyWorld.Homepage.Guestbook");if(c)
{c.writeFlash=(ebay.oUtils.oFlash.getControlVersion()=="WIN 9,0,115,0");if(!c.writeFlash||ebay.oUtils.oFlash.getControlVersion()=="WIN 9,0,115,0")
{var ortLyr=this._getControl(c.flashLayerName);if(!ortLyr)
ortLyr=new EbayHTMLLayer(this,c.flashLayerName);for(var itm in c.data)
{new EbayHTMLAnchor(this,c.ownerAnchorPrefix+itm);new EbayHTMLImage(this,c.ownerImagePrefix+itm);new EbayHTMLAnchor(this,c.userLinkPrefix+itm);new EbayHTMLAnchor(this,c.scoreLinkPrefix+itm);new EbayHTMLImage(this,c.starImagePrefix+itm);new EbayHTMLImage(this,c.storeImagePrefix+itm);new EbayHTMLLayer(this,c.timeLayerPrefix+itm);new EbayHTMLLayer(this,c.textLayerPrefix+itm);}}}}
ebay.oDocument.oPage._registerListener(ebay.oDocument._getEvent("load"),ebay.oDocument.EVENT_BEFORE,"initComments");ebay.oDocument.oPage.processComments=function()
{var c=this.oCommentCfg;var s='';if(c)
{var ortLyr=this._getControl(c.flashLayerName);if(!c.writeFlash||ebay.oUtils.oFlash.getControlVersion()=="WIN 9,0,115,0")
{s+='{';s+='"messages":['
var oOwnA,oOwn,oUsr,oSco,oSta,oStr,oTm,oTxt;var isFirst=true;for(var itm in c.data)
{if(!isFirst)
s+=",";s+='{';s+='"id":'+itm+',';s+='"user":{'
oUsr=this._getControl(c.userLinkPrefix+itm);s+='"id":"'+((oUsr.eElem)?oUsr.eElem.innerHTML:'')+'",';s+='"feedback":{';oSco=this._getControl(c.scoreLinkPrefix+itm);s+='"score":'+((oSco.eElem)?oSco.eElem.innerHTML:'0')+',';s+='"feedbackUrl":"'+((oSco.eElem)?oSco.eElem.href:'')+'",';oSta=this._getControl(c.starImagePrefix+itm);s+='"starUrl":"'+((oSta.eElem)?oSta.eElem.src:'')+'",';oStr=this._getControl(c.storeImagePrefix+itm);s+='"storeUrl":"'+((oStr.eElem)?oStr.eElem.src:'')+'",';oOwnA=this._getControl(c.ownerAnchorPrefix+itm);s+='"myworldUrl":"'+((oOwnA.eElem)?oOwnA.eElem.href:'')+'"';s+='}';s+='},';s+='"isOwner":'+c.data[itm].isOwner+',';s+='"state":'+c.data[itm].state+',';oOwn=this._getControl(c.ownerImagePrefix+itm);s+='"ownerPictureUrl":"'+((oOwn.eElem)?oOwn.eElem.src:'')+'",';oTm=this._getControl(c.timeLayerPrefix+itm);s+='"timeStamp":"'+((oTm.eElem)?oTm.eElem.innerHTML:'')+'",';oTxt=this._getControl(c.textLayerPrefix+itm);var tmp=(oTxt.eElem)?oTxt.eElem.innerHTML:'';if(tmp.indexOf('"')>-1)
tmp=replaceQuote(tmp);s+='"text":"'+tmp+'"';s+='}';isFirst=false;}
s+=']';s+='}';if(ortLyr&&ortLyr.eElem)
{ortLyr.eElem.innerHTML='';var flVrStr='config='+vjo.dsf.Enc.encodeURIComponent(c.settings)+'&data='+vjo.dsf.Enc.encodeURIComponent(s)+'&page='+(c.pageId||"6")+'&portalpage='+(c.portalPageName||"guestbook");var movUrl=c.flashUrl;var h='';h+='<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,115,0" width="'+c.flashWidth+'" height="'+c.flashHeight+'" id="guestbook_107" align="middle">';h+='<param name="allowScriptAccess" value="always" />';h+='<param name="wmode" value="transparent" />';h+='<param name="FlashVars" value="'+flVrStr+'" />';h+='<param name="movie" value="'+movUrl+'" />';h+='<param name="quality" value="high" />';h+='<param name="bgcolor" value="#ffffff" />';h+='<embed src="'+movUrl+'" quality="high" bgcolor="#ffffff" width="'+c.flashWidth+'" height="'+c.flashHeight+'" name="guestbook_107" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" ';h+='FlashVars="'+flVrStr+'"/>';h+='</object>';ortLyr.show(true);ortLyr.setValue(h);}}
else
ortLyr.show(true);}}
ebay.oDocument.oPage._registerListener(ebay.oDocument._getEvent("load"),ebay.oDocument.EVENT_AFTER,"processComments");function replaceQuote(pStr)
{var c,i,l=pStr.length,o='';for(i=0;i<l;i+=1){c=pStr.charAt(i);if(c>=' ')
{if(c==='\\'||c==='"'){o+='\\';}
o+=c;}
else
{switch(c)
{case'\b':o+='\\b';break;case'\f':o+='\\f';break;case'\n':o+='\\n';break;case'\r':o+='\\r';break;case'\t':o+='\\t';break;default:c=c.charCodeAt();o+='\\u00'+Math.floor(c/16).toString(16)+(c%16).toString(16);}}}
return o+'';}
ebay.oDocument.oPage.initGuestbookAddEntry=function()
{var oC=this.parent.getConfig("MyWorld.Homepage.GuestbookAddEntry");if(oC)
new ebayGuestbookAddEntry(this,"GuestbookAddEntry",oC);}

//15@@m3

function EbayBubbleHelp(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayBubbleHelp";this.base=EbayHTML;this.base(pParent,pName,pName,false,pCfg);this.oCfg=pCfg;this.init=function()
{with(this)
{t=this;oBubble=ebay.oDocument.oPage;oBmouse=ebay.oDocument.oMouse;oBubble.oBimg=[];t.oBimg=[];for(var iIndex=0;iIndex<oCfg.sBimg.length;iIndex++)
{var oSource=ebay.oDocument.getUIElem(oCfg.sBimg[iIndex]);if(oSource&&oSource.tagName=="A")
oBubble.oBimg[iIndex]=t.oBimg[iIndex]=new EbayHTMLAnchor(t,oCfg.sBimg[iIndex]);else if(oSource&&(oSource.type=="button"||oSource.type=="submit"))
oBubble.oBimg[iIndex]=t.oBimg[iIndex]=new EbayHTMLLayer(t,oCfg.sBimg[iIndex]);else
oBubble.oBimg[iIndex]=t.oBimg[iIndex]=new EbayHTMLImage(t,oCfg.sBimg[iIndex]);if(!oBimg[iIndex].eElem)
oBimg[iIndex].bind();t.oBimg[iIndex].subscribeEvents("onmouseover");t.oBimg[iIndex].subscribeEvents("onmouseout");t.oBimg[iIndex]._registerEvent("onmouseover","this.parent.imgOver(\""+iIndex+"\")");}}}
this.imgOver=function(pIndex)
{with(this)
{oBubble.oBRdiv=t.oBRdiv=new EbayHTMLLayer(t,oCfg.sBRdiv);if(!oBRdiv.eElem)
oBRdiv.bind();oBRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSE.gif')";oBubble.oBLdiv=t.oBLdiv=new EbayHTMLLayer(t,oCfg.sBLdiv);if(!oBLdiv.eElem)
oBLdiv.bind();oBLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSW.gif')";oBubble.oTLdiv=t.oTLdiv=new EbayHTMLLayer(t,oCfg.sTLdiv);if(!oTLdiv.eElem)
oTLdiv.bind();oTLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNW.gif')";oBubble.oTRdiv=t.oTRdiv=new EbayHTMLLayer(t,oCfg.sTRdiv);if(!oTRdiv.eElem)
oTRdiv.bind();oTRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNE.gif')";iIndex=pIndex;oBubble.oBdiv=t.oBdiv=new EbayHTMLLayer(t,oCfg.sBdiv);oBdiv.subscribeEvents("onmouseover","onmouseout");if(!oBdiv.eElem)
oBdiv.bind();oBdiv.width(oCfg.iBWidth);oBdiv.height(oCfg.iBHeight);iWinw=ebay.oDocument.win.document.documentElement.offsetWidth;iWinh=ebay.oDocument.win.document.documentElement.offsetHeight;iMx=oBmouse.iMouseX;iMy=oBmouse.iMouseY;iDw=parseInt(oBdiv.eElem.style.width);iDh=parseInt(oBdiv.eElem.style.height);iLeft=findLeft(oBimg[iIndex].eElem.offsetParent);iLeft=iLeft+oBimg[iIndex].eElem.offsetLeft;iTop=findTop(oBimg[iIndex].eElem.offsetParent);iTop=iTop+oBimg[iIndex].eElem.offsetTop;if((iWinw-iMx)<iDw)
{oBdiv.eElem.style.left=iLeft-iDw+16+"px";oBLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSW.gif')";oTLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNW.gif')";if(iMy<iDh)
{oBdiv.eElem.style.top=iTop+16+"px";oBRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSE.gif')";oTRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNESel.gif')";}
else
{oBdiv.eElem.style.top=iTop-iDh+"px";oTRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNE.gif')";oBRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSESel.gif')";}}
else
{oBdiv.eElem.style.left=iLeft-5+"px";oBRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSE.gif')";oTRdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNE.gif')";if(iMy<iDh)
{oBdiv.eElem.style.top=iTop+16+"px";oBLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSW.gif')";oTLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNWSel.gif')";}
else
{oBdiv.eElem.style.top=iTop-iDh+"px";oTLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubNW.gif')";oBLdiv.eElem.style.backgroundImage="url('http://pics.ebaystatic.com/aw/pics/bubbleHelp/hlpBubSWSel.gif')";}}
bBmouse=1;showBubble(iIndex);}}
this.findLeft=function(obj)
{with(this)
{var curleft=0;if(obj.offsetParent)
{curleft=obj.offsetLeft;while(obj=obj.offsetParent)
{curleft+=obj.offsetLeft;}}
return curleft;}}
this.findTop=function(obj)
{with(this)
{var curtop=0;if(obj.offsetParent)
{curtop=obj.offsetTop;while(obj=obj.offsetParent)
{curtop+=obj.offsetTop;}}
return curtop;}}
this.showBubble=function(pIndex)
{with(this.parent)
{iIndex=pIndex;if(bBmouse==1)
{oBdiv.eElem.style.display="block";oBdiv._registerEvent("onmouseover","this.parent.divmouseOver(\""+iIndex+"\")");oBdiv._registerEvent("onmouseout","this.parent.mouseOut(\""+iIndex+"\")");oBimg[iIndex]._registerEvent("onmouseout","this.parent.mouseOut(\""+iIndex+"\")");}
else
{oBdiv.eElem.style.display="none";}}}
this.divmouseOver=function(pIndex)
{with(this)
{iIndex=pIndex;bBmouse=1;showBubble(iIndex);}}
this.mouseOut=function(pIndex)
{with(this)
{iIndex=pIndex;bBmouse=0;setTimeout("ebay.oDocument.oPage._getControl(\""+name+"\").showBubble(\""+iIndex+"\")",oCfg.iBDelay);}}
this.init();}

//16@@m1

function EbayDOMMouse(pParent,pName)
{if(!this.objType)
this.objType="EbayDOMMouse";this.base=EbayBaseControl;this.base(pParent,pName);this.iMouseX=this.iMouseY=-1;this.bMonitorDrag=false;this.oDOMEvent=null;with(this)
_registerListener(oDocument._getEvent("unload"),EVENT_BEFORE,"onBeforeDocumentUnload");this.onmousemove=function(pEvent)
{try
{ebay.oDocument.oMouse.setMouseData(pEvent);}
catch(e){}
ebay.oDocument.oMouse.aftermousemove(pEvent);}
this.onmousedown=function(pEvent)
{ebay.oDocument.oMouse.setMouseData(pEvent);jsObj._exec("mousedown");}
this.onmouseup=function(pEvent)
{var od=ebay.oDocument.oMouse;od.setMouseData(pEvent);od.bMonitorDrag=false;jsObj._exec("mouseup");}
this.registerEvents=function()
{with(this.parent)
{registerDocEvent("mousedown","","doc",typeof(doc.onmousedown),"oMouse");registerDocEvent("mouseup","","doc",typeof(doc.onmouseup),"oMouse");doc.onmousemove=this.onmousemove;}}
this.setMouseData=function(pEvent)
{var evt=pEvent||event;this.iMouseX=evt.clientX;this.iMouseY=evt.clientY;this.oDOMEvent=evt;}
this.onBeforeDocumentUnload=function()
{var d=this.oDocument.doc;d.onmousedown=d.onmouseup=onmousemove=null;}
this.aftermousemove=function(){}}
ebay.oDocument.oMouse=new EbayDOMMouse(ebay.oDocument,"Mouse Events");ebay.oDocument.oMouse.registerEvents();

//17@@m1

function EbayScrollDiv(pParent,pName,pCfg)
{if(!this.objType)
this.objType="EbayScrollDiv";this.base=EbayHTML;this.base(pParent,pName,pName,false,pCfg);this.oCfg=pCfg;this.sContent=[];this.iFeedback=0;this.iScroll=0;this.iPadding=pCfg.iPadding;this.init=function()
{with(this)
{t=this;iSpeed=oCfg.iSpeed;bMouse=0;oScroll=ebay.oDocument.oPage;oScroll.oBTable=t.oBTable=new EbayHTMLLayer(t,oCfg.sContent);if(!oBTable.eElem)
oBTable.bind();if(oBTable.eElem)
{oBTable.eElem.style.display="block";oScroll.oContentDiv=[];t.oContentDiv=[];if(oCfg.aContent.length==1)
{oCfg.aContent[1]=oCfg.aContent[0];iFeedback=0;iScroll=1;}
if(oCfg.aContent.length==0)
{iFeedback=1;iScroll=1;oBTable.eElem.style.display="none";}
if(iFeedback==1)
{sContent[0]="0 Feedback received";sContent[1]="0 Feedback received";}
else
{for(i=0;i<oCfg.aContent.length;i++)
{oScroll.oContentDiv[i]=t.oContentDiv[i]=new EbayHTMLLayer(t,oCfg.aContent[i]);if(!oContentDiv[i].eElem)
oContentDiv[i].bind();sContent[i]=oContentDiv[i].getValue();}}
oScroll.oCdiv=t.oCdiv=new EbayHTMLLayer(t,oCfg.sCdiv);if(!oCdiv.eElem)
oCdiv.bind();oScroll.oIdiv=t.oIdiv=new EbayHTMLLayer(t,oCfg.sIdiv);if(!oIdiv.eElem)
oIdiv.bind();oIdiv.setValue(sContent[0]);oIdiv.show(true);oScroll.oIdiv2=t.oIdiv2=new EbayHTMLLayer(t,oCfg.sIdiv2);if(!oIdiv2.eElem)
oIdiv2.bind();oIdiv2.setValue(sContent[1]);oScroll.oPause=t.oPause=new EbayHTMLImage(t,oCfg.sPause);if(!oPause.eElem)
oPause.bind();oScroll.oNext=t.oNext=new EbayHTMLImage(t,oCfg.sNext);if(!oNext.eElem)
oNext.bind();oScroll.oPrev=t.oPrev=new EbayHTMLImage(t,oCfg.sPrev);if(!oPrev.eElem)
oPrev.bind();if(iScroll==1)
{oPause.show(false);oPrev.show(false);oNext.show(false);}
else
this.scrollDiv();}}}
this.scrollDiv=function()
{with(this)
{oIdiv.width(oCdiv.eElem.offsetWidth-(iPadding*2));oIdiv2.width(oCdiv.eElem.offsetWidth-(iPadding*2));getinline(oIdiv,oIdiv2);oIdiv2.show(true);setTimeout("ebay.oDocument.oPage._getControl(\""+name+"\").animateUp()",oCfg.iDelay);}}
this.animateUp=function()
{with(this)
{for(var k=0;k<sContent.length;k++)
{if(sContent[k]==oIdiv2.getValue()){iHiddenDivPointer=k;break;}}
oPause.onclick=function(){scrollStop();};oNext.onclick=function(){oPause.source(oCfg.sPlayBtn);};oPrev.onclick=function(){oPause.source(oCfg.sPlayBtn);};oCdiv.eElem.onmouseover=function(){bMouse=1;};oCdiv.eElem.onmouseout=function(){bMouse=0;};if(parseInt(oIdiv2.eElem.style.top)>(iPadding+5)){oIdiv.eElem.style.top=parseInt(oIdiv.eElem.style.top)-5+"px";oIdiv2.eElem.style.top=parseInt(oIdiv2.eElem.style.top)-5+"px";setTimeout("ebay.oDocument.oPage._getControl(\""+name+"\").animateUp()",iSpeed);}
else{getinline(oIdiv2,oIdiv);swapDivs(oIdiv2,oIdiv);setTimeout("ebay.oDocument.oPage._getControl(\""+name+"\").setMessage()",3000);}}}
this.scrollStop=function()
{with(this)
{if(oPause.source()==oCfg.sPauseBtn)
{oPause.source(oCfg.sPlayBtn);}
else
{oPause.source(oCfg.sPauseBtn);}}}
this.swapDivs=function(oIdiv2,oIdiv){with(this)
{var tempContainer=oIdiv;oIdiv=oIdiv2;oIdiv2=tempContainer;}}
this.getinline=function(oDiv1,oDiv2){with(this)
{oDiv1.eElem.style.top=iPadding+"px";oDiv2.eElem.style.top=Math.max(oCdiv.eElem.offsetHeight,oDiv1.eElem.offsetHeight)+"px";}}
this.setMessage=function(){with(this)
{if(oPause.source()==oCfg.sPlayBtn||bMouse==1)
{oNext.onclick=function(){oIdiv2.setValue(sContent[iHiddenDivPointer]);var i=iHiddenDivPointer;var iCeiling=sContent.length;iHiddenDivPointer=(i+1>iCeiling-1)?0:i+1;oIdiv.setValue(sContent[iHiddenDivPointer]);}
oPrev.onclick=function(){oIdiv2.setValue(sContent[iHiddenDivPointer]);var i=iHiddenDivPointer;var iCeiling=sContent.length;iHiddenDivPointer=(i-1<0)?iCeiling-1:i-1;oIdiv.setValue(sContent[iHiddenDivPointer]);}
setTimeout("ebay.oDocument.oPage._getControl(\""+name+"\").setMessage()",100);}
else
{var i=iHiddenDivPointer;var iCeiling=sContent.length;iHiddenDivPointer=(i+1>iCeiling-1)?0:i+1;oIdiv2.setValue(sContent[iHiddenDivPointer]);animateUp();}}}
this.init();}

//18@@m4

ebay.oDocument.oPage.onBeforeLoad=function()
{var oC=ebay.oDocument.getConfig("MyWorld.Feedback.Slideshow");if(oC){new EbayScrollDiv(this,"Index.Scroll",oC);new EbayBubbleHelp(this,"Index.Bubble",oC);}
var cfg=this.cfg=this.parent.getConfig('MyWorldNewThemeLayer');if(!cfg)
return false;var oForm=new EbayHTMLForm(this,cfg.sFormId);var oOuterLyr=new EbayHTMLLayer(this,cfg.sOuterLayerId);var oOpenLyr=new EbayHTMLAnchor(this,cfg.sOpenLyr);var oCloseLayer=new EbayHTMLAnchor(this,cfg.sCloseLayer);var pTheme=null;var iLen=cfg.aElemDivArray.length;oForm.bind();oOuterLyr.bind();for(var i=0;i<iLen;i++)
{adivs=new EbayHTMLAnchor(this,cfg.aElemDivArray[i]);adivs.onclick=function()
{for(j=0;j<iLen;j++)
{if(cfg.aElemDivArray[j]==this.name)
pTheme=j+1;}
var sUrl=oForm.getAction();sUrl=sUrl+cfg.sParamName+"&newTheme="+pTheme;oForm.setAction(sUrl);oForm.submit();}
adivs.bind();}
oCloseLayer.onclick=function()
{oOuterLyr.show(false);}
oOpenLyr.onclick=function()
{oOuterLyr.show(true);return false;}
oCloseLayer.bind();oOpenLyr.bind();var oImage=new EbayHTMLImage(this,cfg.sProfileImageId);var oSize=cfg.sSize;oImage.bind();if(oImage.height()>oSize)
oImage.height(oSize);if(oImage.width()>oSize)
oImage.width(oSize);}
// b=15853539 -->
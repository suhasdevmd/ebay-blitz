//<!--
//1@@m4

function ebHelpContextualInit()
{ebayDowngradeDomain();}
function ebHelpShowInlinePage(pURL)
{if(window.opener&&!window.opener.closed)
{var oLeadingQ=new RegExp("^\\?"),oQueryStringQuestionMark=new RegExp("^[^\\?]+\\?"),sDocLocSearch=document.location.search,bUrlHasQ=oQueryStringQuestionMark.test(pURL),bDocLocSearchHasQ=oLeadingQ.test(sDocLocSearch);if(bUrlHasQ&&bDocLocSearchHasQ){sDocLocSearch=sDocLocSearch.replace(oLeadingQ,"&");}
var toURL=pURL+sDocLocSearch;window.opener.location.href=toURL;}
else
ebayShowPopupWindow(pURL,"");window.close();}
ebHelpContextualInit();
// b=15987528 -->
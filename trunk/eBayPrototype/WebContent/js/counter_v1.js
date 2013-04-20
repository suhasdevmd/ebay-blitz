var ctdArr = '';
var spareWidth = document.body.clientWidth - parseInt( $( '.container1' ).css( 'width' ) );
var tabPos;
var iImg = new Image();
var _locPath = '';

var searchParams = [ '', '', '', '', '' ]; // 0 - p1_name, 1 - p2_name, 2 - p3_name, 3 - p4_name, 4 - price

if( spareWidth % 2 ) {
	$( '#bgDivLeft' ).css( 'width', ( ( spareWidth - 1 ) / 2 ) + 'px' );
	$( '#bgDivRight' ).css( 'width', ( ( spareWidth + 1 ) / 2 ) + 'px' );
} else {
	$( '#bgDivLeft' ).css( 'width', ( spareWidth / 2 ) + 'px' );
	$( '#bgDivRight' ).css( 'width', ( spareWidth / 2 ) + 'px' );
}

function _popup( id, flag ) {
	if( flag ) {
		var textDiv = '';
		textDiv = $( '#dealHolderDetail_' + id + ' .descOvrlyDiv' ).html();

		// if the overlay has no ItemSpecifics, don't display it..
		if( textDiv != '' ) {
			$( '#' + id ).css( 'display', 'inline' );
		} else {

		}
	} else {
		$( '#' + id ).css( 'display', 'none' );
	}
}

function setOverlayHeight( id ) {
	var minHeight	= parseInt( $( id + ' .descOvrlyDiv' ).css( 'min-height' ) );
	var height		= $( id + ' .descOvrlyDiv table' ).height() + 25;

	if( height > minHeight ) {
		$( id + ' .descOvrlyDiv' ).css( 'height', height + 'px' );
	}
}

function _set( id ) {
	//Get the screen height and width
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();

	//Set heigth and width to mask to fill up the whole screen
	$('#mask').css({'width':maskWidth,'height':maskHeight});

	//transition effect
	$('#mask').fadeIn(1000);
	$('#mask').fadeTo("slow",0.7);

	//Get the window height and width
	var winH = $(window).height();
	var winW = $(window).width();

	$(id).css('top',  '25px');
	$(id).css('left', (winW-$(id).width())/2);

	$(id).fadeIn(2000);

	$('.window .close').click(function (e) {
		//Cancel the link behavior
		e.preventDefault();

		$('#mask').hide();
		$('.window').hide();
	});

	$('#mask').click(function () {
		$(this).hide();
		$('.window').hide();
	});
	setOverlayHeight( id );
}

$(document).keyup(function(e) {
	if(e.keyCode == 27) {
		closeModal();
	}
});

function closeModal() {
	$('#mask').hide();
	$('.window').hide();
}

function resetImage( e ) {
	document.getElementById( e ).src = iImg.src;
}

function changeImage( s, e ) {
	iImg.src = document.getElementById( e ).src;
	document.getElementById( e ).src = s;
}

$(document).ready(function() {
	$( 'a.imgLink' ).mouseover( function( e ) {
		if( $( this ).hasClass( 'focusTab' ) ) {
			// do nothing
		} else {
			$( this ).removeClass( 'noFocusTab' ).addClass( 'focusTab' );
			tabPos	= $( 'a.imgLink' ).index( this );
		}
	});

	$( 'a.imgLink' ).mouseout( function( e ) {
		$( 'a.imgLink:eq(' + tabPos + ')' ).removeClass( 'focusTab' ).addClass( 'noFocusTab' );
	});

	$( 'div.thumbTabs' ).mouseover( function( e ) {
		$( 'div.thumbTabs' ).removeClass( 'activeT' ).addClass( 'inactiveT' );
		$( this ).removeClass( 'inactiveT' ).addClass( 'activeT' );

		var tabPos	= $( 'div.thumbTabs' ).index( this );

		$( 'div.dealTabs' ).removeClass( 'showPane' ).addClass( 'hidePane' );
		$( 'div.dealTabs:eq(' + tabPos + ')' ).removeClass( 'hidePane' ).addClass( 'showPane' );
	});

	$( '.dealcontainer .noctn' ).height( $( '.dealcontainer .noctn' ).parent().height() + 'px' );

	if ( $( ".slider" )[ 0 ] ) {
		$( ".slider" ).sudoSlider({
			beforeAniFunc: function(t){
				//$( this ).trigger( 'scroll' );
			},
			afterAniFunc: function(t){
				$( this ).trigger( 'scroll' );
			}
		});
	}

	// lazy-load images
	if( $("img.lazy").length ) {
		$("img.lazy").show().lazyload({ skip_invisible : false,effect:"fadeIn",failure_limit : 50 });
	}

	if( document.getElementById("ddTop") ) {
		var _4 = navigator.appName;
		if (_4 == "Microsoft Internet Explorer") {
			window.onscroll = function (e) {check_pos();};
		} else {
			window.addEventListener("scroll", function () {check_pos();}, false);
		}
		document.getElementById("ddTop").style.top = parseInt($(window).height()/2) + 'px';
		document.getElementById("ddTop").onclick = function (e) {scrollTop();};
	}

	$(function() {
		$( "#accordion" ).accordion({
			autoHeight: false,
			navigation: true,
			collapsible: true
		});
		// don't show any initially
		$( "#accordion" ).accordion("activate" , false);
	});

	_locPath = location.pathname.split('/').pop() + location.search;
	setLocPath();
});

function clearSelection() {
	if( ( typeof _udf != 'undefined' ) && ( _udf.cat != '' ) ) {
		location.href = location.href.replace( location.search, '' ).replace( 'list.php', _udf.cat );
	} else {
		location.href = location.href;
	}
}

function setLocPath() {
	$('#containerCat a').each(function( o ) {
		if( $( this ).attr( 'href' ) == _locPath ) {
			$( this ).addClass( 'currentSelection' );
			var tabPos	= $( '#containerCat a' ).index( this );
			$( '#sbText' ).html( '<a href="index.php" style="text-decoration:none;">Home</a> >> ' + ( $( '#containerCat a:eq(' + tabPos + ') span' ).text() ) );
		};
	});
}

function getUserSearch( map ) {
	for(var i in _udf) {
		if( i == 'p1_name' ) {
			searchParams[ 0 ] = _udf[ i ];
		} else if( i == 'p2_name' ) {
			searchParams[ 1 ] = _udf[ i ];
		} else if( i == 'p3_name' ) {
			searchParams[ 2 ] = _udf[ i ];
		} else if( i == 'p4_name' ) {
			searchParams[ 3 ] = _udf[ i ];
		} else if( i == 'price' ) {
			itemPrice = _udf[ i ];
			remotePrice = 0;
		} else if( i == 'cat' ) {
			_locPath = _udf[ i ];
			setLocPath();
		} else if( i == 'sortBy' ) {
			sortOrder = _udf[ i ];
			remotePrice = 0;

			var dd = document.getElementById( 'v4-44' );
			for (var j = 0; j < dd.options.length; j++) {
				if( dd.options[j].value === _udf[ i ] ) {
					dd.selectedIndex = j;
					break;
				}
			}
		}
	}

	getSearchResults( map, 1 );
	remotePrice = 1;
}

function setUserPrice() {
	remotePrice = 0;

	if( _udf.price != '' ) {
		var ip = _udf.price.split( '^' );
		$("#slider-range").slider("option", "values", [ parseInt( ip[ 0 ] ), parseInt( ip[ 1 ] ) ] );
		$( "#amount" ).val( "Rs. " + ip[ 0 ] + " - Rs. " + ip[ 1 ] );
	}

	remotePrice = 1;
}

function modifyResultSet( o, map ) {
	if( o == '' ) {
		
	} else {
		switch( o.name ) {
			case 'p1_name':
				if( o.value == '' ) {
					searchParams[ 0 ] = '';
				} else {
					searchParams[ 0 ] = o.value;
				}
				break;
			case 'p2_name':
				if( o.value == '' ) {
					searchParams[ 1 ] = '';
				} else {
					searchParams[ 1 ] = o.value;
				}
				break;
			case 'p3_name':
				if( o.value == '' ) {
					searchParams[ 2 ] = '';
				} else {
					searchParams[ 2 ] = o.value;
				}
				break;
			case 'p4_name':
				if( o.value == '' ) {
					searchParams[ 3 ] = '';
				} else {
					searchParams[ 3 ] = o.value;
				}
				break;
		}
	}

	getSearchResults( map, 0 );
}

function getSearchResults( map, _a ) {
	var fallback = $( '#dataTable' ).html();
	$( '#dataTable' ).html( '<div id="overlay"><img src="images/loading.gif" class="overlayImg" /></div>' );
	$.post( 'getResults.php', { p1_name: searchParams[ 0 ], p2_name: searchParams[ 1 ], p3_name: searchParams[ 2 ], p4_name: searchParams[ 3 ], mapsTo: map, price: itemPrice, sortBy: sortOrder }, function( data ) {
		fallback = '';
		data = data.split( '###' );
		orderSearchBoxes( data[ 1 ] );
		$( '#dataTable' ).html( data[ 2 ] );
		$( '#searchTotal' ).html( '(&nbsp;' + data[ 0 ] + ' items matching your search&nbsp;)' );
		$("img.lazy").show().lazyload({ skip_invisible : false,effect:"fadeIn",failure_limit : 50 });
		$('#searchTotal').animate({
			opacity: 0.25
		}, 1000, function() {
			$('#searchTotal').css('opacity', '1' );
		});

		if( _a ) {
			setUserPrice();
		}
	 }).error(function() {
		$( '#dataTable' ).html( fallback );
		$("img.lazy").show().lazyload({ skip_invisible : false,effect:"fadeIn",failure_limit : 50 });
	});
}

function orderSearchBoxes( o, map ) {
	o = eval('('+o+')');

	if( document.getElementById( 'p1_name' ) ) {
		document.getElementById( 'p1_name' ).length = 0;
		createDropDown( 'p1_name', o.p1_name );
	}

	if( document.getElementById( 'p2_name' ) ) {
		document.getElementById( 'p2_name' ).length = 0;
		createDropDown( 'p2_name', o.p2_name );
	}

	if( document.getElementById( 'p3_name' ) ) {
		document.getElementById( 'p3_name' ).length = 0;
		createDropDown( 'p3_name', o.p3_name );
	}

	if( document.getElementById( 'p4_name' ) ) {
		document.getElementById( 'p4_name' ).length = 0;
		createDropDown( 'p4_name', o.p4_name );
	}
}

function createDropDown( el, ev, map ) {
	if( !document.getElementById( el ) ) {
		return;
	}
	var element = document.getElementById( el );
	ev = ev.split( ',' );
	var selection = '';

	switch ( el ) {
		case 'p1_name':
			selection += searchParams[ 0 ];
			break;
		case 'p2_name':
			selection += searchParams[ 1 ];
			break;
		case 'p3_name':
			selection += searchParams[ 2 ];
			break;
		case 'p4_name':
			selection += searchParams[ 3 ];
			break;
	}

	var opt = document.createElement( "OPTION" );
	opt.text = '-Select All-';
	opt.value = '';
	element.options.add(opt);

	for( var i=0;i<ev.length; i++ ) {
		var opt = document.createElement( "OPTION" );
		opt.text = ev[i];
		opt.value = ev[i];
		if( selection == ev[i] ) {
			opt.selected = "selected";
		}
		element.options.add(opt);
	}
}

function check_pos() {
	var t = this;
	if (parseInt(t.getScrollY()) > 300) {
		document.getElementById("ddTop").style.visibility = "visible";
	} else {
		document.getElementById("ddTop").style.visibility = "hidden";
	}
}

function getScrollY() {
	var _8, d = document.documentElement || document.body;
	if (typeof window.pageYOffset == "number") {
		_8 = window.pageYOffset;
	} else {
		_8 = d.scrollTop;
	}
	return _8;
}

function scrollTop() {
	var t = this;
	var _d = document.getElementById("ddTop");
	if (_d !== null) {
		_d.style.visibility = "hidden";
		this.smoothScroll("body");
	}
}

function smoothScroll( e ) {
	var _f = this.currentYPosition();
	var _e = this.elmYPosition(e);
	var _f = _e > _f ? _e - _f : _f - _e;

	if (_f < 100) {
		scrollTo(0, _e);
		return;
	}

	var _12 = Math.round(_f / 100);
	if (_12 >= 20) {
		_12 = 20;
	}

	var _13 = Math.round(_f / 25);
	var _14 = _e > _f ? _f + _13 : _f - _13;
	var _15 = 0;
	if (_e > _f) {
		for (var i = _f; i < _e; i += _13) {
			setTimeout("window.scrollTo(0, " + _14 + ")", _15 * _12);
			_14 += _13;
			if (_14 > _e) {
				_14 = _e;
			}
			_15++;
		}
		return;
	}
	for (var i = _f; i > _e; i -= _13) {
		setTimeout("window.scrollTo(0, " + _14 + ")", _15 * _12);
		_14 -= _13;
		if (_14 < _e) {
			_14 = _e;
		}
		_15++;
	}
}

function currentYPosition() {
    // Firefox, Chrome, Opera, Safari
    if (self.pageYOffset) {
		return self.pageYOffset;
	}
    // Internet Explorer 6 - standards mode
    if (document.documentElement && document.documentElement.scrollTop) {
        return document.documentElement.scrollTop;
	}
    // Internet Explorer 6, 7 and 8
    if (document.body.scrollTop) {
		return document.body.scrollTop;
	}
    return 0;
}

function elmYPosition( eID ) {
	var elm = document.getElementById( eID );
	var y = elm.offsetTop;
	var node = elm;
	while ( node.offsetParent && node.offsetParent != document.body ) {
		node = node.offsetParent;
		y += node.offsetTop;
	}
	return y;
}

/***********************************************
* Dynamic Countdown script- &copy; Dynamic Drive (http://www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit http://www.dynamicdrive.com/ for this script and 100s more.
***********************************************/

function cdtime(container, targetdate, currentdate) {
	if (!document.getElementById || !document.getElementById(container)) {
		return;
	}

	this.container = document.getElementById(container);
	this.currentTime = new Date(currentdate);
	this.targetdate = new Date(targetdate);
	this.timesup = false;
	this.updateTime();
}

cdtime.prototype.updateTime = function() {
	var thisobj = this;
	this.currentTime.setSeconds( this.currentTime.getSeconds() + 1 );
	setTimeout(function() {
		thisobj.updateTime()
	}, 1000);
}

cdtime.prototype.displaycountdown = function( baseunit, functionref ) {
	this.baseunit = baseunit;
	this.formatresults = functionref;
	this.showresults();
}

cdtime.prototype.showresults = function() {
	var thisobj = this;
	var timediff = ( this.targetdate - this.currentTime ) / 1000;

	if ( timediff < 0 ) {
		this.timesup = true;
		this.container.innerHTML = this.formatresults();
		return;
	}

	var oneMinute = 60; //minute unit in seconds
	var oneHour = 60*60; //hour unit in seconds
	var oneDay = 60*60*24; //day unit in seconds

	var dayfield = Math.floor( timediff / oneDay );
	var hourfield = Math.floor( ( timediff - dayfield * oneDay ) / oneHour );
	var minutefield = Math.floor( ( timediff - dayfield * oneDay - hourfield * oneHour ) / oneMinute );
	var secondfield = Math.floor( ( timediff - dayfield * oneDay - hourfield * oneHour - minutefield * oneMinute ) );

	if ( this.baseunit == "hours" ) { //if base unit is hours, set "hourfield" to be topmost level
		hourfield = dayfield * 24 + hourfield;
		dayfield = "n/a";
	} else if ( this.baseunit == "minutes" ) { //if base unit is minutes, set "minutefield" to be topmost level
		minutefield = dayfield * 24 * 60 + hourfield * 60 + minutefield;
		dayfield = hourfield = "n/a";
	} else if ( this.baseunit == "seconds" ) { //if base unit is seconds, set "secondfield" to be topmost level
		var secondfield = timediff;
		dayfield = hourfield = minutefield = "n/a";
	}

	this.container.innerHTML = this.formatresults( dayfield, hourfield, minutefield, secondfield );
	setTimeout( function() {
		thisobj.showresults()
		}, 1000 );
}

function showTimer() {
	if ( this.timesup == false ) {
		var timeString	= '';

		for( var i = 0; i < arguments.length; i++ ) {
			switch( i ) {
				case 0:
					if( arguments[ i ] != 0 ) {
						timeString	+= arguments[ i ] + 'd : ';
					}
					break;
				case 1:
					if( arguments[ i ] != 0 ) {
						timeString	+= arguments[ i ] + 'h : ';
					}
					break;
				case 2:
					if( arguments[ i ] != 0 ) {
						timeString	+= arguments[ i ] + 'm : ';
					}
					break;
				case 3:
					if( arguments[ i ] != 0 ) {
						timeString	+= arguments[ i ] + 's';
					} else if( timeString != '' ) {
						timeString	+= '00s';
					}
					break;
			}
		}

		return "<span class=\"saleInfo\">Deal ends in</span> <span class='lcdstyle'>" + timeString + "</span>"
	} else {
		return "Time Expired!"
	}
}

function Coupon(){
	var lp = $('#Coupon').css('left');
	if(lp=='0px'){
		$('#Coupon').animate({'left':'-320px'},300);
	}
	else if(lp=='-320px'){
		$('#Coupon').animate({'left':'0px'},300);
	}
}
jQuery(window).scroll(function(){
	add_class_scroll();
});
add_class_scroll();
var scrollWindow = jQuery(window).scrollTop();
var vH = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);
var vW = Math.max(document.documentElement.clientWidth, window.innerWidth || 0);

function add_class_scroll() {
	if(vW < 767){
		if(jQuery(window).scrollTop() > 80){
			$('.navbar-fixed-top').css('top','0px');
		}else{
			$('.navbar-fixed-top').css('top','80px');
		}
	}else{
		if(jQuery(window).scrollTop() > 36){
			$('.navbar-fixed-top').css('top','0px');
		}else{
			$('.navbar-fixed-top').css('top','36px');
		}
	}

	if(jQuery(window).scrollTop() > 36){
		$('#searchScroll').addClass('navbar-fixed-top').css('display','block');
		$('#searchScroll .tab-content').css('border','1px solid rgba(0,0,0,0.3)');	
	}
	else{
		$('#searchScroll').removeClass('navbar-fixed-top').css('display','none');
		$('#searchScroll .tab-content').css('border','0px');
		
	}
}

$('.navbar-fixed-top li a').click(function() {
	if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
		var target = $(this.hash);
		target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
		if (target.length) {
		    $('html,body').animate({
		     	scrollTop: target.offset().top
		    }, 1000);
		    return false;
		}
	}
});

$(document).ready(function(){
	var heightDescription = $('.descriptionImovel').height();
	var heightForm = $('.formImovel').height();
	if(heightDescription < heightForm){
		$('.descriptionImovel').css('height', heightForm + 30);
	}else{
		$('.formImovel').css('height', heightDescription+60);
	}
	jQuery('.lp-banner').show().revolution(
				{
					dottedOverlay:"none",
					delay:6000,
					startwidth:1170,
					startheight:800,   /* MUDAR O TAMANHO */
					hideThumbs:200,
					
					thumbWidth:100,
					thumbHeight:50,
					thumbAmount:5,
					
					navigationType:"bullet",
					navigationArrows:"solo",
					navigationStyle:"round",
					
					touchenabled:"on",
					onHoverStop:"off",
					
					swipe_velocity: 0.7,
					swipe_min_touches: 1,
					swipe_max_touches: 1,
					drag_block_vertical: false,
											
					parallax:"mouse",
					parallaxBgFreeze:"on",
					parallaxLevels:[7,4,3,2,5,4,3,2,1,0],
											
					keyboardNavigation:"off",
					
					navigationHAlign:"off",
					navigationVAlign:"false",
					navigationHOffset:0,
					navigationVOffset:20,
		
					soloArrowLeftHalign:"left",
					soloArrowLeftValign:"center",
					soloArrowLeftHOffset:20,
					soloArrowLeftVOffset:0,
		
					soloArrowRightHalign:"right",
					soloArrowRightValign:"center",
					soloArrowRightHOffset:20,
					soloArrowRightVOffset:0,
							
					shadow:0,
					fullWidth:"on",      /* INVERTER PARA TER O SLIDE NA TELA INTEIRA */
					fullScreen:"on",
		
					spinner:"spinner4",
					
					stopLoop:"off",
					stopAfterLoops:-1,
					stopAtSlide:-1,
		
					shuffle:"off",
					
					autoHeight:"off",						
					forceFullWidth:"off",						
											
					hideTimerBar: "on",					
											
					hideThumbsOnMobile:"off",
					hideNavDelayOnMobile:1500,						
					hideBulletsOnMobile:"off",
					hideArrowsOnMobile:"off",
					hideThumbsUnderResolution:0,
					
					hideSliderAtLimit:0,
					hideCaptionAtLimit:0,
					hideAllCaptionAtLilmit:0,
					startWithSlide:0,
					videoJsPath:"rs-plugin/videojs/",
					fullScreenOffsetContainer: ""	
				});

	$('.collapseSideBar').click(function() {
		$(this).next().slideToggle('slide');
		var icon = $(this).hasClass('closed');
		if(icon == true){
			$(this).addClass('open').removeClass('closed');
		}
		else{
			$(this).removeClass('open').addClass('closed');
		}
	});
});


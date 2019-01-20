jQuery(function($){
	/******************************************
	init
	******************************************/
	var winH = $(window).height();
	$('.box').outerHeight(winH);
	
	$(window).on('resize',function(){
		winH = $(window).height();
		$('.box').outerHeight(winH);
	});
		
});	
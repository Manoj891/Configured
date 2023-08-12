(function(){
    $(function(){
     $(".loading-image").fadeOut("slow");
     $(window).stellar();
    //  $('html').css('overflow', 'hidden');
     $('.animate').waypoint( function( direction ) {        
         var i = 0;
        if( direction === 'down' ) {
            
            i++;
            $(this.element).removeClass('nodisplay');
            $(this.element).addClass('item-animate');
            // $(this.element).addClass('yesdisplay');
            setTimeout(function(){

                $('body .animate.item-animate').each(function(k){
                    var el = $(this);
                    setTimeout( function () {
                        var effect = el.data('animate-effect');
							if ( effect === 'fadeUp') {
								el.addClass('fadeInUp');
							} else if ( effect === 'fadeLeft') {
								el.addClass('fadeInLeft');
							} else if ( effect === 'fadeRight') {
								el.addClass('fadeInRight');
							} else {
								el.addClass('fadeIn');
							}
                        el.removeClass('item-animate');
                    },  k * 200, 'easeInOutExpo' );
                });
                
            }, 100);
            
        }

    } , { offset: '85%' } );
});
}());
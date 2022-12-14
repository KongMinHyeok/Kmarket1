/**
 * 
 */
 $(function(){
    var gnb1 = $('#member_gnb > li:nth-child(1) > a');
	let gnb2 = $('#member_gnb > li:nth-child(2) > a');
	let i1 = $('#member_gnb > li:nth-child(1) > a > i');
	let i2 = $('#member_gnb > li:nth-child(2) > a > i');
	
    gnb1.click(function(e){
        e.preventDefault();
        
        i1.removeClass('off').addClass('on');
        i2.removeClass('on').addClass('off');

        var isOpen = $(this).next().is(':visible');
        console.log(isOpen);

        if(isOpen){
            $(this).next().slideUp(200);
        }else{
			$(gnb2).next().slideUp(200);
            $(this).next().slideDown(200);
        }
    });
    
    gnb2.click(function(e){
        e.preventDefault();
        
        i2.removeClass('off').addClass('on');
        i1.removeClass('on').addClass('off');

        var isOpen = $(this).next().is(':visible');
        console.log(isOpen);

        if(isOpen){
            $(this).next().slideUp(200);
        }else{
			$(gnb1).next().slideUp(200);
            $(this).next().slideDown(200);
        }
    });
    
});
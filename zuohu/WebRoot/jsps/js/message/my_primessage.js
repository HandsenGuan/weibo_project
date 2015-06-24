$(function(){
	$('.list-group-item').click(function(){
		/*
		$(this).parent().css('display','none');
		$(this).parent().next().css('display','block');
		*/

		if($(this).parent().css('display')=='block'){ 
			$(this).parent().css('display','none');
			$(this).parent().next().css('display','block');
		}

	});

	$('#return').click(function(){ 
		
		if($(this).closest('.list-group').css('display')=='block'){ 
			$(this).closest('.list-group').css('display','none');
			$(this).closest('.list-group').prev().css('display','block');
		}
		
	});
	
});
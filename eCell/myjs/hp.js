$('#signup').click(function(){
			
			$("#sec1").removeClass().addClass('animated flipOutX');
			
			
			setTimeout( function(){
					$("#sec1").hide();},1300);
					
			setTimeout( function(){
					$("#sec2").show();},1300);
			
			setTimeout( function(){
				$("#sec2").removeClass().addClass('animated flipInX');},1300);
				
		
});

$('#login').click(function(){
			
			$("#sec2").removeClass().addClass('animated flipOutX');
			
			
			setTimeout( function(){
					$("#sec2").hide();},1300);
					
			setTimeout( function(){
					$("#sec1").show();},1300);
			
			setTimeout( function(){
				$("#sec1").removeClass().addClass('animated flipInX');},1300);
				
				
});


		
		
		

	
	
			
			
			
			
	
<?php $ht=180 ?>

<html>

<head>
<link 	rel="icon" 				type="image/x-icon" 	href="images\favicon.png" />  
<link 	rel="shortcut icon" 	type="image/x-icon" 	href="images\favicon.ico" />
<link 	rel="stylesheet" 		type="text/css" 		href="mycss\maincss.css" />

<title></title>

<script type="text/javascript" src="myjs/rollover.js"></script>
</head>

<body background="images\bg.jpg">
<?php include("includes/header.php"); ?>
<div id="core" style="width:100%;">

<div id="left" style="width:16%; height:<?php echo "$ht" ?>%; float:left;">
<?php include("includes/left.php"); ?>
</div>

<div id="mainbody" style="width:65%; height:<?php echo "$ht" ?>%; float:left;">
	
	<ul type=none><span><center>FAQ</center></span>
	<li><p>How to you Order Online?<br>
	You may choose any mobile phone, accessories & mobile content from our online product catalog and add it to your shopping cart and pay using credit card through our secure payment gateway.
	</li></p><hr>
	
	<li><p>What are the cards accepted?<br>
	Please <a href="pm.php" title="Payment methods">click here</a> to see our payment methods.
	</li></p><hr>
	
	<li><p>How will the delivery be done?<br>
	We process the national delivery only through courier.
	</li></p><hr>
	
	<li><p>How long would the delivery take?<br>
	The products purchased through our online shopping mall will usually be shipped in 7 working days based on the stock status.
	</li></p><hr>
	
	<li><p>Do I have to pay any extra taxes?<br>
	Yes. Regional VAT is added to the cost of order.
	</li></p><hr>
	
	<li><p>Will I get an order confirmation?<br>
	Yes. You will receive a call from our executive once the order is confirmed. If you have provided your email id you will also receive a confirmation via email, which you can print for your reference.
	</li></p><hr>
	
	<li><p>How to Cancel an Order?<br>
	To cancel an order you will have to send cancellation request to our online support department[weCare@eCell.co.in] eCell reserves all the rights for cancellation.
	</li></p><hr>
	
	<li><p>Is the product purchased online cover warranty?<br>
	All products cover the manufacturers warranty.
	</li></p><hr>
	
	<li><p>How Secure is the eCell's Payment gateway?<br>
	www.ecell.co.in process all payments with secure bank Payment gateways.
	</li></p><hr>
	
	<li><p>Do I have to pay any extra charges for shipping/delivery?<br><pre>
<b>Location	 	Rs.	 Additional cost for gift logistics</b>
TamilNadu	 	Rs.50	 Rs.25/-
South India	 	Rs.75	 Rs.50/-
Rest of India		Rs.100	 Rs.75/-
	</pre></li></p>
	
</div>

<div id="ads" style="width:14%; height:<?php echo "$ht" ?>%; float:right;">
<?php include("includes/ads.php"); ?>
</div>

</div>
<?php include("includes/footer.php"); ?>
</body>

</html>
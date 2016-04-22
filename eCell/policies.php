<?php $ht=150 ?>

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
	
	<ul type=none>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<span><center>Policies</center></span><br/>
	
	<li>
	<p> 
	Our policies includes measures like 
	<a href="policies.php?id=#sp" title="Security policy">Security policy</a>, 
	<a href="policies1.php?id=#tou" title="Terms of use">terms of use</a>, 
	<a href="policies2.php?id=#pp" title="Privacy policy">privacy policy</a>, 
	<a href="policies3.php?id=#tos" title="Terms of sale">terms of sale</a>, and 
	<a href="policies4.php?id=#cp" title="Copyright policy">copyright policy</a>. 
	</p>
	<a name="sp" /><hr><br>
	
	<li> [I] Security Policy
		<ul type="disc">
		<li>
		<p>Is it safe to use my Credit/Debit card on eCell?<br>Yes, shopping at eCell is 100% safe. All Credit card and Debit card payments on eCell are processed through secure and trusted payment gateways managed by leading Indian banks. To ensure the security, you can refer our <a href="tm.php" title="TrustMarks" >TrustMarks</a> eCell uses latest 256-bit encryption technology to protect your card information while securely transmitting it to the Banks for processing the payment.
Furthermore, the Banks ask you to enter an online password (also known as 3D Secure password) which acts as an additional layer of security for your card transaction. This 3D Secure password is not printed anywhere on the card and is known only to you, giving you the added assurance that only you can use your card to make purchases on the Internet. This makes your online transaction on eCell extremely safe and secure. 
You can be assured that eCell offers you the highest standards of security currently available on the internet so as to ensure that your shopping experience is private, safe and secure.</p>

		<li>Does eCell store my Credit/Debit card infomation?<br>eCell stores the first 6 and last 4 digits of your card number in a secure and encrypted manner. The first 6 digits (also known as the Bank Identification Number) are used to identify the bank name and country where your card was issued. The first 6 and last 4 digits are together used for fraud detection and prevention purposes.</p>
		
		<li>To view our payment options, please <a href="pm.php" title="Payment Methods">click here</a>.
		
		</ul>
	<br>
	
	
	<form action="" method=get name=poliform><br>
	<a href="policies1.php?id=#tou" title="Terms of use">
	<p align=center><input type="button" class="button" value="Contd..." style="background:#66CCFF; align:center;"></p>
	</a>
	</form>
		
</div>

<div id="ads" style="width:14%; height:<?php echo "$ht" ?>%; float:right;">
<?php include("includes/ads.php"); ?>
</div>

</div>
<?php include("includes/footer.php"); ?>
</body>

</html>
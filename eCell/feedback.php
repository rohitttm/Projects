<?php $ht=100 ?>

<html>

<head>
<link 	rel="icon" 				type="image/x-icon" 	href="images\favicon.png" />  
<link 	rel="shortcut icon" 	type="image/x-icon" 	href="images\favicon.ico" />
<link 	rel="stylesheet" 		type="text/css" 		href="mycss\maincss.css" />

<title>Feedback</title>

<script type="text/javascript" src="myjs/rollover.js"></script>
</head>

<body background="images\bg.jpg">
<?php include("includes/header.php"); ?>
<div id="core" style="width:100%;">

<div id="left" style="width:16%; height:<?php echo "$ht" ?>%; float:left;">
<?php include("includes/left.php"); ?>
</div>

<div id="mainbody" style="width:65%; height:<?php echo "$ht" ?>%; float:left;">
	
	<ul type=none><span><center>Feedback</center></span>
	<li><p>Please rate your experience on eCell.<br> <b>Note</b>: We do not store any personal or account information.<br><br>
	<form name="fb" method=get action="">
	
	What was your primary reason for visiting eCell today?<br>
	<select name="reason" style="width:300; font-size: 16px;">
	<option value="Please choose one..." selected>Please choose one...</option>
	<option value="">To order a mobile</option>
	<option value="">To order a tablet</option>
	<option value="">To order any accessory</option>
	<option value="">To view new offers</option>
	<option value="">To compare fares</option>
	<option value="">Other</option>
	</select>
	<br><br>
	
	Were you able to easily accomplish the purpose of your visit?<br>
	<input type=radio name=r1 value=yes>Yes &emsp; <input type=radio name=r1 value=no>No
	<br><br>
	
	How would you rate the Content of the page?<br>
	<input type=radio name=r2 value="Excellent">Excellent &emsp;
	<input type=radio name=r2 value="Good">Good &emsp;
	<input type=radio name=r2 value="Satisfactory">Satisfactory &emsp;
	<input type=radio name=r2 value="Not Satisfactory">Not satisfactory &emsp;
	<input type=radio name=r2 value="Poor">Poor &emsp;
	<br><br>
	
	How would you rate the Design of the page?<br>
	<input type=radio name=r3 value="Excellent">Excellent &emsp;
	<input type=radio name=r3 value="Good">Good &emsp;
	<input type=radio name=r3 value="Satisfactory">Satisfactory &emsp;
	<input type=radio name=r3 value="Not Satisfactory">Not satisfactory &emsp;
	<input type=radio name=r3 value="Poor">Poor &emsp;
	<br><br>
	
	How would you rate the Ease of Use of the page?<br>
	<input type=radio name=r4 value="Excellent">Excellent &emsp;
	<input type=radio name=r4 value="Good">Good &emsp;
	<input type=radio name=r4 value="Satisfactory">Satisfactory &emsp;
	<input type=radio name=r4 value="Not Satisfactory">Not satisfactory &emsp;
	<input type=radio name=r4 value="Poor">Poor &emsp;
	<br><br><br>

	<center>
	<input class=button type=Submit name=Submit value=Submit  style="height: 30px; width: 100px"/>&emsp;&emsp;
	<input class=button type=Reset name=Reset value=Reset  style="height: 30px; width: 100px"/>
	</center>
	
</div>

<div id="ads" style="width:14%; height:<?php echo "$ht" ?>%; float:right;">
<?php include("includes/ads.php"); ?>
</div>

</div>
<?php include("includes/footer.php"); ?>
</body>

</html>
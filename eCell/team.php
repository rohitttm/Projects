<?php $ht=100 ?>

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

<div id="left" style="width:14%; height:<?php echo "$ht" ?>%; float:left;">
<?php include("includes/left.php"); ?>
</div>

<div id="mainbody" style="width:68%; height:<?php echo "$ht" ?>%; float:left;">
	
	<ul type=none><span><center>Meet the team</center></span>
	<li><br>
	<table border=0>
	<tr align="left">
	<th><img src="images/rohit.jpg"  height=150 width=150>
	</th>
	<th><font face="BlackChancery" color="Gray" size=5>
	&emsp;Rohit Makhija<br>&emsp;<br>&emsp;rohit.makhija6792@gmail.com<br>
	</font>&emsp;<br><br><br></th>
	<th></th>
	<th></th>
	</tr>
	
	
	<tr align="left">
	<th><br><img src="images/ashish.jpg" height=150 width=150>
	</th>
	<th><font face="BlackChancery" color="gray" size=5><br>
	&emsp;Ashish Pinjwani<br>&emsp;<br>&emsp;ashishpinjwaniengg@gmail.com<br>
	</font>&emsp;br><br><br></th>
	</table>
</div>

<div id="ads" style="width:14%; height:<?php echo "$ht" ?>%; float:right;">
<?php include("includes/ads.php"); ?>
</div>

</div>
<?php include("includes/footer.php"); ?>
</body>

</html>
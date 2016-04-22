<?php $ht=100; ?>

<html>

<head>
<link 	rel="icon" 				type="image/x-icon" 	href="images\favicon.png" />  
<link 	rel="shortcut icon" 	type="image/x-icon" 	href="images\favicon.ico" />
<link 	rel="stylesheet" 		type="text/css" 		href="mycss\maincss.css" />

<title>Contact us</title>

<script type="text/javascript" src="myjs/rollover.js"></script>
<script type="text/javascript" >
function over(img){document.getElementById("free").src=img}
function out(img){document.getElementById("free").src=img}
</script>
<script type="text/javascript" src="myjs/jquery.js"></script>
<script type="text/javascript" src="myjs/fade.js"></script>

</head>
</head>

<body background="images\bg.jpg">
<?php include("includes/header.php"); ?>
<div id="core" style="width:100%;">

<div id="left" style="width:16%; height:<?php echo $ht; ?>%; float:left;">
<?php include("includes/left.php"); ?>
</div>

<div id="mainbody" style="width:65%; height:<?php echo $ht; ?>%; float:left; display:none;">

	<ul type=none><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>Contact Us</center></span><br />
	<center><li><font size=6 face=Papyrus>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Feel free to contact us at</li>
	<li>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<b>weCare@eCell.co.in</b></li>
	<li>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	for any kind of feedback or</li>
	<li>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	complaints. We will be happy</li>
	<li>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	to recieve your suggestions.</li>
	<br />
	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<img src="Birda.gif" id="free" onmouseover="over('Birdb.png')" onmouseout="out('Birda.gif')"></li></font></center>
	</ul>

</div>

<div id="ads" style="width:14%; height:<?php echo $ht; ?>%; float:right;">
<?php include("includes/ads.php"); ?>
</div>

</div>
<?php include("includes/footer.php"); ?>
</body>

</html>


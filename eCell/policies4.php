<?php $ht=160 ?>

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

	<a name="cp" /><hr><br>
	
	<li> [V]  Copyright Policy
		<ul type="disc">
		
		<li><p>The users should assume that standard copyright protection applies to all materials and contents displayed on the Website.
		</li></p>

		<li><p>Any redistribution, modification or reproduction of part or all of the contents featured in the Website in any form is prohibited. You may display, print, or download the contents to a local hard disk extracts for your personal, non-commercial use, but only if you acknowledge the Website as the source of the material.
		</li></p>

		<li><p>You are not permitted, except with the express written consent of Jasper, to distribute or commercially exploit the contents on this Website.
		</li></p>

		<li><p>You are also prohibited from transmitting the contents or storing it in any other Website or in other form of electronic retrieval system.
		</li></p>

		<li><p>You are not permitted to use the Marks without the prior consent of Jasper, the vendor or the third party that may own the Marks. If you do so, eCell may, in its sole discretion, terminate Your Account. 
		</li></p>

		<li><p>Any person who knowingly misrepresents that any material or activity is infringing, may be subject to legal liability. Accordingly, if you are not sure whether material available online infringes your copyright, please contact a lawyer.
		</li></p>

		<li><p>The Company Secretary/ Manager- Legal should be contacted only if you believe that your work has been used or copied in a way that constitutes copyright infringement and that such infringement is occurring on the Website or on websites linked to or from the Website, or in connection with the services provided on the Website. All other inquiries directed to the Company Secretary/ Manager- Legal will not be responded to. Such inquiries should be made through the feedback procedure referenced in the Website.
		</li></p>
		
		</ul>
	<br>
				
	<form action="" method=get name=poliform><br>
	<a href="policies.php?id=#sp" title="Security policy">
	<p align=center><input type="button" class="button" value="Back to Security Policies" style="background:#66CCFF; align:center;"></p>
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
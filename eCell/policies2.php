<?php $ht=250 ?>

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
	
	<a name="pp" /><hr><br>
	
	<li> [III] Privacy Policy
		<ul type="disc">
		<p>We value the trust you place in us. That's why we insist upon the highest standards for secure transactions and customer information privacy. Please read the following statement to learn about our information gathering and dissemination practices.</P>

<p><b>Note:
Our privacy policy is subject to change at any time without notice. To make sure you are aware of any changes, please review this policy periodically.</b><p>

	<li><p>When you use our Website, we collect and store your personal information which is provided by you from time to time. Our primary goal in doing so is to provide you a safe, efficient, smooth and customized experience. This allows us to provide services and features that most likely meet your needs, and to customize our Website to make your experience safer and easier. More importantly, while doing so we collect personal information from you that we consider necessary for achieving this purpose.
	</li></p>

	<li><p>Additionally, you may encounter cookies* or other similar devices on certain pages of the Website that are placed by third parties. We do not control the use of cookies by third parties.<br>* A "cookie" is a small piece of information stored by a web server on a web browser so it can be later read back from that browser. Cookies are useful for enabling the browser to remember information specific to a given user. We place both permanent and temporary cookies in your computer's hard drive. The cookies do not contain any of your personally identifiable information.
	</li></p>
	
	<li><p>We use personal information to provide the services you request. To the extent we use your personal information to market to you, we will provide you the ability to opt-out of such uses. We use your personal information to resolve disputes; troubleshoot problems; help promote a safe service; collect money; measure consumer interest in our products and services, inform you about online and offline offers, products, services, and updates; customize your experience; detect and protect us against error, fraud and other criminal activity; enforce our terms and conditions; and as otherwise described to you at the time of collection.
	</li></p>
	
	<li><p>We may share personal information with our other corporate entities and affiliates to help detect and prevent identity theft, fraud and other potentially illegal acts; correlate related or multiple accounts to prevent abuse of our services; and to facilitate joint or co-branded services that you request where such services are provided by more than one corporate entity. Those entities and affiliates may not market to you as a result of such sharing unless you explicitly opt-in.
	</li></p>

	<li><p>By using the Website and/ or by providing your information, you consent to the collection and use of the information you disclose on the Website in accordance with this Privacy Policy, including but not limited to Your consent for sharing your information as per this privacy policy.
	</li></p>
	
	<li><p>If we decide to change our privacy policy, we will post those changes on this page so that you are always aware of what information we collect, how we use it, and under what circumstances we disclose it.
	</li></p>

		</ul>
	<br>
	
			
	<form action="" method=get name=poliform><br>
	<a href="policies3.php?id=#tos" title="Terms of sale">
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
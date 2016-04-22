<?php

session_start();
print_r($_SESSION);
ob_start();
//require 'connect.php';
$error="";
$error1="";


if(isset($_POST['user']))
{
if(!empty($_POST['user']))
	{
	$user=$_POST['user'];
	$_SESSION['username']=$user;
	
	}
else
	{
	$error.="Enter your username. ";
	}
}
if(isset($_POST['pass']))
{
if(!empty($_POST['pass']))
	{
	$pass=$_POST['pass'];
	
	}
else
	{
	$error.="Enter your password. ";
	}
}
if(isset($_POST['login']))
{
	if(!empty($user)&&!empty($pass))
	{
	$query1="SELECT `id`, `username`, `password`, `firstname`, `lastname` FROM `users` WHERE `username`='$user' AND `password`='$pass'";

	if($query_run=mysql_query($query1))	
	{

		$num_rows=mysql_num_rows($query_run);
		if($num_rows==0)
			{
			$error.="No such username and password combination found!! ";
			}
		else if($num_rows==1)
			{
			$user_id=mysql_result($query_run,0,'id');
			$_SESSION['user_id']=$user_id;
			$_SESSION['pass']=$pass;
		
	
				if(isset($_SESSION['script']))
				{
				header('Location:'.$_SESSION['script']);
				}
				else
				{header('Location:index.php');}
			}
	else echo 'query not run'; 
	}
	else 
	{
	
	
	}
	}
}
if(isset($_POST['username']))
{
if(!empty($_POST['username']))
	{
	$username=$_POST['username'];
	
	}
else
	{
	$error1.="Enter username ";
	}
}
if(isset($_POST['password']))
{
if(!empty($_POST['password']))
	{
	$password=$_POST['password'];
	}
else
	{
	$error1.="password ";
	}
}
if(isset($_POST['firstname']))
{
if(!empty($_POST['firstname']))
	{
	$firstname=$_POST['firstname'];
	}
else
	{
	$error1.="Enter firstname ";
	}
}
if(isset($_POST['lastname']))
{
if(!empty($_POST['lastname']))
	{
	$lastname=$_POST['lastname'];
	}
else
	{
	$error1.="Enter lastname ";
	}
}
if(isset($_POST['signup']))
{
if(!empty($username)&&!empty($password)&&!empty($firstname)&&!empty($lastname))
{
$querycheck="SELECT `username` FROM `users` WHERE `username`='$username'";

		if($query_check_run=mysql_query($querycheck))	
		{
		$num=mysql_num_rows($query_check_run);
			if($num==0)
				{
			$query="INSERT INTO  `mobilephones`.`users` (
			`id` ,
			`username` ,
			`password` ,
			`firstname` ,
			`lastname`
			)
			VALUES (
			NULL ,'$username','$password','$firstname','$lastname'
			);";
				mysql_query($query);
				}
			else {$error1.="Username already in use ";}
		}

		else
		{
		$error1.="cannot signup ";
		}
}
}

ob_end_flush();

?>

<html>
<head>
	<meta charset="utf-8" />
	<title>Login</title>
	<link rel="stylesheet" href="mycss/login.css" />
	<link rel="stylesheet" href="mycss/animation.css" />

<link 	rel="icon" 				type="image/x-icon" 	href="images\favicon.png" />  
<link 	rel="shortcut icon" 	type="image/x-icon" 	href="images\favicon.ico" />
<link 	rel="stylesheet" 		type="text/css" 		href="mycss\maincss.css" />

<script type="text/javascript" src="myjs/rollover.js"></script>

	<script src="myjs/jquery_2.js">
	
function validate()
{

	firstnamein = document.signup.firstname.value;
	lastnamein = document.signup.lastname.value;
	emailin = document.signup.emailid.value;
	phonein = document.signup.phoneno.value;
	usernamein = document.signup.username.value;
	passwordin = document.signup.password.value;
	
	if ( ! (firstnamein.length > 0))
	{
		alert("Enter your first name");
		return false;
	}
	
	if ( ! (lastnamein.length > 0))
	{
		alert("Enter your last name");
		return false;
	}
	
	if ( ! (emailin.length > 0))
	{
		alert("Enter your email id");
		return false;
	}

	index = emailin.indexOf("@");
	if ( index == -1 )
	{
		alert("Enter valid email Id");
		return false;
	}
	newindex = emailin.indexOf(".");
	if ( newindex < index + 2 )
	{
		alert("Enter valid email Id");
		return false;
	}
	
	if ( ! (phonein.length > 0))
	{
		alert("Enter your phone no");
		return false;
	}
			
	if ( phonein.length > 0)
		{
			if(!( phonein > 0))
			{
				alert("Enter only numbers in phone no field ");
				return false;
			}
			
			if( phonein.length != 10)
			{
				alert("Length of phone no must be 10");
				return false;
			}
		}
		
	if ( ! (usernamein.length > 0))
	{
		alert("Enter User name");
		return false;
	}
	
	if ( ! (passwordin.length > 0))
	{
		alert("Enter your password");
		return false;
	}
		
	return true;
}


</script>
</head>
<body background="images/fo.jpg">

<div id="header">

<form name="form1" method="get" action="search.php" >
<div id="middle" style="width:100%; background-image: url(fo.jpg); float:center;">

<font size=4><p align="right">
<a name="up" />
<a href="" title="Shopping Cart">Shopping Cart</a> &nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="" title="Wish list">Wish list</a> &nbsp;&nbsp;|&nbsp;&nbsp;  
<a href="login.php" title="Login">Login</a> &nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="theName" size=32 placeholder="Search eCell" title="Search here"/>
<input type="submit" name="submit" class="button" title="Submit"/>
&nbsp;&nbsp;&nbsp;
<label ></label>
</form>
</p></font>

<div id="second" style="width:100%;height:40%">
<table width="100%" border=0>
<tr>
<td rowspan=3 width="40%">
<a href="index.php" title="Homepage"><img src="images\mylogo.jpg" width="80%" /></a>
<td colspan=2><br /><br /><font color="#024174" face="Tempus Sans ITC" size=5><strong>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 C u s t o m e r &nbsp; C a r e : 
 <a href="mailto:weCare@eCell.co.in" title="weCare@eCell.co.in"> w e C a r e @ e C e l l . c o . i n</a>
</strong></font>
 </td>
</tr>

<tr>
<td rowspan=2 width="20%">
<font color="#024174" face="Vani" size=4>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<big>Follow us on:</big>
</font>
</td>
<td></td>
</tr>
<tr>
<td>
<a href="https://www.facebook.com/" title="Facebook"><img src="images\fb.png" width="5%" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://twitter.com/" title="Twitter"><img src="images\twitter.png" width="5%" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="http://www.linkedin.com/" title="LinkedIn"><img src="images\linkedin.png" width="5%" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://plus.google.com/" title="Google plus"><img src="images\g+.png" width="5%" /></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
</table>

<hr color=#343434 size=1 /><br>
<p align=center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="index.php" title="Homepage"  target="_top"><img src="h1.png" height=20% width="7%" id="home" onmouseover="over1('h2.png')" onmouseout="out1('h1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="aboutus.php" title="About Us" target="_top"><img src="ab1.png" height=20% width="7%" id="aboutus" onmouseover="over2('ab2.png')" onmouseout="out2('ab1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="m&t.php" title="Mobiles and Tablets"  target="_top"><img src="m1.png" height=20% width="7%" id="mt" onmouseover="over3('m2.png')" onmouseout="out3('m1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="accessories.php" title="Accessories"  target="_top"><img src="a1.png" height=20% width="7%" id="accessories" onmouseover="over4('a2.png')" onmouseout="out4('a1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="franchisee.php" title="Franchisee" target="_top"><img src="f1.png" height=20% width="7%" id="fr" onmouseover="over5('f2.png')" onmouseout="out5('f1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="contactus.php" title="Contact Us" target="_top"><img src="c1.png" height=20% width="7%" id="contactus" onmouseover="over6('c2.png')" onmouseout="out6('c1.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</p>
<br>
<hr color=#343434 size=1 />
</div>

	
	</div>
<div id="main">
	<div id="left">
		<img src="images/login.jpg"  align=right/>
  </div>
	<div id="right">
		<div id="box">
		<nav>
			<ul align=center>
				<li>&emsp; &emsp; &emsp; <button class="link" id="login" >Login</button></li>
				<li>&emsp; <button class="link" id="signup">Signup</button></li>
			</ul>
		</nav>
		</div>
<div id="sec1">
		<form id="login" name="login" action="login.php" method="post">
				<header><h3>Login</h3></header>
				<?php
				
				echo $error;
						echo '<br>';
				
				?>
				<p align=center>
				USERNAME : <input type="text" name="user" class="rounded"/>
				<br>
				PASSWORD : <input type="password" name="pass"  class="rounded"/>
				<br><br>
				<button  type="submit" name="login" class="button">Submit</button>
				<button type="reset" class="button">Reset</button>
				<br>
				</p>
		</form>
		</div>
		<div id="sec2">
			<form id="signup" name="signup" action="login.php" method="post" onSubmit="return validate()">
			<header><h3>Sign Up<h3></header>
			<?php
				
				echo $error1;
						echo '<br>';
				
				?>
			FIRSTNAME : <input type="text" name="firstname" class="rounded"/>
			<br>
			LASTNAME: <input type="text" name="lastname" class="rounded"/>
			<br>
			USERNAME : <input type="text" name="username" class="rounded"/>
			<br>
			PASSWORD : <input type="password" name="password"  class="rounded"/>
			<br><br>
			<button type="submit" name="signup" class="button">Submit</button>
			<button type="reset" class="button">Reset</button>
			
			</form>
		</div>
	</div>	
</div>
<div id="footer">
<?php include("includes/footer.php");?>
	</div>
	<script src="myjs/hp.js"></script>
</body>
</html>
-->
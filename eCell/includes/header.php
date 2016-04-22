<?php
session_start();
print_R($_SESSION);
?>
<form name="form1" method="get" action="search.php" >
<div id="middle" style="width:85%; background-image: url(fo.jpg); float:center;">

<font size=3><p align="right">

<font size="4"><a name="up" />
<a href="shoppingcart.php" title="Shopping Cart">Shopping Cart</a> &nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="wishlist.php" title="Wish list">Wish list</a> &nbsp;&nbsp;|&nbsp;&nbsp;  

<?php
error_reporting(E_ALL ^ E_NOTICE);
if(isset($_SESSION['pass']))
{
echo '<a href="logout.php" title="Logout"> Logout </a>';
print_R($_SESSION);
}
else
echo '<a href="login.php" title="Login"> Login </a>';

?>

</a> &nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="theName" size=32 placeholder="Search eCell" title="Search here"/>
<input type="submit" name="submit" class="button" title="Submit"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</font>

<label ></label>
</form>

</p></font>

<div id="second" style="width:100%;height:35%; overflow-y:hidden;">
<table width="100%" border=0>
<tr>
<td rowspan=3 width="40%">
<a href="index.php" title="Homepage"><img src="images\mylogo.jpg" width="90%" /></a>
</td>
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

<hr color=#343434 size=1 />
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

<hr color=#343434 size=1 />
</div>

<?php

error_reporting(E_ERROR | E_PARSE);
 session_start();

	require_once('includes/connect.php');  
	
	?>
	<?php
	if(isset($_GET['action']) && $_GET['action'] == "add"){
	    $id = intval($_GET['id']);
		if(isset($_SESSION['cart'][$id])){ 
		$_SESSION['cart'][$id]['quantity']++;
		}else {
		$sql2 = "SELECT * FROM products WHERE id_product={$id}";
		$query2 = mysql_query($sql2);
		
		if(mysql_num_rows($query2)){
		$row2 = mysql_fetch_array ($query2);

		$_SESSION['cart'][$row2['id_product']] = array("quantity" => 1, "price" =>$row2['price']);
		}
		else
		{
		$message = "THIS PRODUCT ID IS INVALID";
		}
	}
	}
?>

<form name="mainbody" action="">
<link rel="stylesheet" type="text/css" href="mycss\maincss.css" />

<p align=center>
<table  cellspacing=15 cellpadding=15>
<tr align="left" width=100%>
<th><font  color="#024174" size=5>>>New Arrivals<br><br></font></th>
<th></th>
<th></th>
</tr><br>
<tr align="center" class="border_bottom">
<th><img src="images/mobiles/micromax7.png" height=300 width=225></th>
<th><img src="images/mobiles/sx1.png" height=300 width=225></th>
<th><img src="images/mobiles/A4.png" height=300 width=225></th>
<tr align="center">
<td><?php
 $sql = "SELECT * FROM products where name='mobile'";
		  $query = mysql_query($sql) or die(mysql_error());
		  while($row=  mysql_fetch_assoc($query)){
		  ?>
		  
		      <?php echo $row['name'];?> <br>
			 
				
			
			<?php
				if(isset($_SESSION['pass']))
				{?>
			<a href="index.php?page=mainbody1&action=add&id=<?php echo $row['id_product']; ?>" >Add To Cart</a>
<a href="wishlist.php?page=wishlist&action=add&id=<?php echo $row['id_product']; ?>" >Add To wishlist</a>
<a href="payment.php">Payment</a>
<?php
}
?>


<?php
}
?><br>
<a href="shoppingcart.php?page=wishlist">Go to wishlist</a>
<a href="shoppingcart.php?page=cart">Go to cart</a>

</td>
<td>Sony Xperia-Z<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
<td>Apple iPhone5 32GB<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
</tr>
</tr>
<tr align="left">
<th><br><font  color="#024174" size=5>>>Best Deals<br><br></font></th>
<th></th>
<th></th>
</tr>
<tr align="center" class="border_bottom">
<th><img src="images/mobiles/sx2.png" height=300  width=225></th>
<th><img src="images/mobiles/Apple10.png" height=300  width=225></th>
<th><img src="images/mobiles/micromax6.png" height=300  width=225></th>
</tr>
<tr align="center">
<td>Sony Xperia-Z<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
<td>Apple iPhone 4s 16GB<br
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
<td>Micromax Canvas2<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
</tr>
<tr align="left">
<th><br><font  color="#024174" size=5>>>Smart Buys<br><br></font></th>
<th></th>
<th></th>
</tr>

<tr align="center" class="border_bottom">
<th><img src="images/mobiles/black6.png" height=300  width=225></th>
<th><img src="images/mobiles/A2.png" height=300  width=225></th>
<th><img src="images/mobiles/h7.png" height=300 width=225></th>
</tr>
</tr>
<tr align="center">
<td>Blackberry Z10<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
<td>Apple iPhone 4 8GB<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
<td>HTC Desire-X<br>
<a href=""><input type="button" class="button" value="Add to Cart"></a>
<a href=""><input type="button" class="button" value="Add to Wish List"></a>
</td>
</tr>
<tr>
<td></td>
<td align=center>
<br><br><br>
<a href="m&t.php">
<input type="button" class="button" value="See more" style="background:#66CCFF; align:left;"><br>Click here to explore the world of mobiles...</a>
</td>
<td>
</td>
</tr>
</table>
</p>
</form>
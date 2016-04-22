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
?><html>
<head>
<link rel="stylesheet" href="transparent.css" type="text/css">
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="hscroll.js">
</script>
</head>
<h1 class="message"><?php if(isset($message)) {echo $message;} ?> </h1>
<h1>Product page</h1>
<table>
	<tr>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	<?php
	      $sql = "SELECT * FROM products ORDER BY name DESC";
		  $query = mysql_query($sql) or die(mysql_error());
		  while($row=  mysql_fetch_assoc($query)){
		  ?>
		  <tr>
		      <td><?php echo $row['name'];?> </td>
			  <td><?php echo $row['description'];?> </td >
				<td>$ <?php echo $row['price'];?> </td >
				<a href="index.php?page=cart">GO TO CART</a>
			</tr>
			
			<?php
			}
			?>
	
	 
</table>
<a href="index.php?page=cart">GO TO CART</a>
</html>
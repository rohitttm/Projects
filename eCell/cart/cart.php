<?php
echo "$_SESSION";
 if(isset($_POST['submit'])){
print_r($_POST);
		foreach($_POST as $key => $value){
				$key = explode("-",$key);
				$key = end($key);
				$key = explode("submit",$key);
				$key = end($key);
				error_reporting(E_ALL ^ E_NOTICE);
				if($_POST['quantity-'.$key] == 0){
					unset($_SESSION['cart'][$key]);
				} else {
					$_SESSION['cart'][$key]['quantity'] = $value;
				}
				
			}
} error_reporting(0);
?>
<h1>View Cart</h1>
<a href="index.php?page=products" title="Go Back To Producs Page">Go Back To Product Page</a>



<form method="post" action="index.php?page=cart">
<fieldset>
	<table>
		<tr>
			<th>Name</th>
			<th>quantity</th>
			<th>Price Per Item</th>
			<th>Total Cost</th>
		</tr>
		<?php
 
		
				$sql = "SELECT * FROM products WHERE id_product IN (";
					foreach ($_SESSION['cart'] as $id => $value) {
			        $sql .= $id . ",";
						
					}
				$sql = substr($sql,0,-1).") ORDER BY name ASC";
				
				$query = mysql_query($sql);
				$total_price = 0;
				if(!empty($query)){
				while($row = mysql_fetch_array($query)){
				
				$quantity = $_SESSION['cart'][$row['id_product']]['quantity'];
				$subtotal = $_SESSION['cart'][$row['id_product']]['quantity']*$row['price'];
				$total_price += $subtotal;
				?>
				<tr>
					<td><?php echo $row['name'];?></td>
					<td><input type="text" name="quantity-<?php echo $row['id_product'];?>" size="5" value="
<?php echo $_SESSION['cart'][$row['id_product']]['quantity'];?>" /></td>
					<td><?php echo "$" . $row['price'];?></td>
					<td><?php echo "$" . $_SESSION['cart'][$row['id_product']]['quantity']*$row['price'];?></td>
					</tr>
					<?php
					}}
					?>
					
					<tr>
					<td></td>
					<td></td>
					<td>Total Price:</td>
					<td><?php echo"$" .$total_price;?></td>
					</tr>
				</table>
			<input type="submit" name="submit" value="Update Chart" /></fieldset>
		</form>
	
		
		<p> TO remove an item set quantity to zero</p>
		
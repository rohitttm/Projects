<html>
<body>
<?php

require_once('includes/connect.php'); 
session_start();
	if(isset($_GET['action']) && $_GET['action'] == "add"){
	    $id = intval($_GET['id']);
		$sql2 = "SELECT * FROM products WHERE id_product={$id}";
		$query = mysql_query($sql2);
		
		
		  while($row=  mysql_fetch_assoc($query)){
		
		?>
		   <table align="center">
		   <th>Name</th>
		   <th>Price</th>
		   <tr>
		  <td> <?php  echo $row['name'];?></td>
		<td><?php   echo $row['price'];?></td>
			</tr>
			</table>
		
		
		
	<?php
	}
	}
?>
</body>
</html>
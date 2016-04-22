<html>
<body>
<?php
if($_POST['s'] == "submit") 
{
   $name = $_POST['name'];
   $cardno = $_POST['card'];
   $passwrd = $_POST['password'];
   
 
   
}
$host='localhost';
$user='root';
$password='';
$connect=mysql_connect($host,$user,$password);
if(!$connect)
{
die('could not connect'.mysql_error());
}
mysql_select_db("debit");



$sql = "INSERT INTO d1(name,cardno,password)  VALUES ('$name', '$cardno','$passwrd')";
		 mysql_query($sql);
?> 
<form method="post" action="debit.php">
Name:<input type="text" name="name" value=""></input></br>
Card No:<input type="text" name="card"  value=""></input></br>
Password:<input type="text" name="password"  value=""></input></br>
<input type="submit" name="s" value="submit"/>

</form>
</body>
</html>
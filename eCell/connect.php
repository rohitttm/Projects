<?php
$host='localhost';
$user='root';
$password='';
$connect=mysql_connect($host,$user,$password);
if(!$connect)
{
die('could not connect'.mysql_error());
}
mysql_select_db("vijay");

?>
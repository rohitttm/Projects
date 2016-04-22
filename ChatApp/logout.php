<?php   
require 'dbfile.php';
include 'core.php';



$id_id=$_SESSION['user_id'];

$query5="UPDATE `usertable` SET `checking`='0' WHERE `ID`='$id_id'";
//updating in table for multiple login
$result5=mysql_query($query5);
//destroying session
session_unset();
session_destroy();
header('Location: loginform.php');


//echo $http_referer;


?>
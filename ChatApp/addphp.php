<?php
session_start();
require 'dbfile.php';

$friendName=$_POST['m'];
$friendID=0;



$query_check="Select * from `usertable` where `username`='$friendName'";
$result_check=mysql_query($query_check);

if(mysql_num_rows($result_check)>0)
{
  while($query_row=mysql_fetch_array($result_check))
  {
    global $friendID;
    $friendID=$query_row['id'];
    echo $friendID;

  }

}
else
{
  $error="Username you entered does not exist";
  $_SESSION['error']=$error;
}

$fw_userId=$_SESSION['user_id'];

$query_insert="Insert into `friends`(`user_id`,`friend_id`) values ('$fw_userId','$friendID') ";
mysql_query($query_insert);
$query_insert1="Insert into `friends`(`user_id`,`friend_id`) values ('$friendID','$fw_userId') ";
mysql_query($query_insert1);
header("Location: list.php");

?>
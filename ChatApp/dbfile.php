<?php
//To connect to the database
//$conn_error = "couldnt establish connection";

$mysql_host = 'localhost';
$mysql_user = 'root';
$mysql_pass = '';

$mysql_db = 'a_database';
//$conn = mysql_connect($mysql_host, $mysql_user, $mysql_pass);
if (@mysql_connect($mysql_host, $mysql_user, $mysql_pass)){

    if (@mysql_select_db($mysql_db)){

        //echo 'Successfully connected'; 
    }

}
?>
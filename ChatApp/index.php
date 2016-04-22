<?php

require 'core.php';
require 'dbfile.php';


//if (isset($_SESSION['user_id'])&&!empty($_SESSION['user_id'])){
    
if (loggedin()){
    $firstname = getuserfield('firstname');
    $surname = getuserfield('lastname');
    echo 'You\'re logged in, '.$firstname.' '.$surname.' <a href="logout.php">Log Out</a><br>';
    
    }else {
    
    include 'loginform.php';
    }


?>
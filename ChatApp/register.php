<?php

//include 'core.php';
require 'dbfile.php';

//if (!loggedin()){
    
    
    
    if(isset($_POST['username'])&&isset($_POST['password'])&&isset($_POST['c_password'])&&isset($_POST['firstname'])&&isset($_POST['surname'])){
   
   
   //load into a variable the values from the user inputs
        $username = $_POST['username'];
        $password = $_POST['password'];
        $c_password = $_POST['c_password'];
        $password_hash = md5($password);
        $firstname = $_POST['firstname'];
        $surname = $_POST['surname'];
   
   
   if (!empty($username)&&!empty($password)&&!empty($c_password)&&!empty($firstname)&&!empty($surname)){
    //checking if the passwords
    if ($password!=$c_password){
        
                echo '<script language="javascript">';
                echo 'alert("Passwords dont match")';
                echo '</script>';
    } else {
        //checking for same user names from the database
        $query = "SELECT `username` FROM `usertable` WHERE `username`='$username'";
        $query_run = mysql_query($query);
        
        if (mysql_num_rows($query_run) == 1){
                echo '<script language="javascript">';
                echo 'alert("The Username '.$username.' already exists.")';
                echo '</script>';
            
            
        }else {
            //insert the correct values in the database
            $query = "INSERT INTO `usertable` VALUES('', '".$username."','".$password_hash."','".$firstname."','".$surname."',0)";
            if ($query_run = mysql_query($query)){
                header('Location: abcd.php');
                
            }else{
                echo '<script language="javascript">';
                echo 'alert("Sorry, We coudnt Register you!")';
                echo '</script>';    
                
            }
        
        }
    }
   }else {
                echo '<script language="javascript">';
                echo 'alert("All fields are required")';
                echo '</script>';
    
   }
   
   }
    //}
    
?>











<html>
	<head>
		<title>Chat Application!</title>
        <link rel='stylesheet' type='text/css' href='stylesheet1.css'/>
	</head>
	<body>


 
 	<div class="container1">
		
		<div class="form-bg1">
			<form action="register.php" method="POST">
				<h2>Register</h2>
				<p><input type="text" name = "username" placeholder="Username"></p>
				<p><input type="password" name ="password" placeholder="Password"></p>
				<p><input type="password" name = "c_password" placeholder="Confirm Password"></p>
				<p><input type="text" name ="firstname" placeholder="First Name"></p>
                <p><input type="text" name ="surname" placeholder="Last Name"></p>
                <input id ="y" type="submit" value="Register">
                
    

			</form>
		</div>
        
     </div>   











<!--<form action="register.php" method="POST">
Username:<br> <input type="text" name="username"><br><br>
Password:<br> <input type="password" name="password"><br><br>
Confirm Password:<br> <input type="password" name="c_password"><br><br>
Firstname:<br> <input type="text" name="firstname"><br><br>
Surname:<br> <input type="text" name="surname"><br><br>
<input type="submit" value="Register">
</form>
-->

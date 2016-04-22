<?php
//to login a user
include 'dbfile.php';
include 'core.php';
//to check if he entered the username and password
if (isset($_POST['username'])&&isset($_POST['password'])){
    $username = $_POST['username'];
    $password = $_POST['password'];
    //converting to md5
    $password_hash = md5($password);
    //checking if the fields are not empty
    if (!empty($username)&&!empty($password)){
        
        $query = "SELECT `id`,`username` FROM `usertable` where `username` = '$username' AND `password` = '$password_hash'";
        //echo $password_hash;
       if  ($query_run = mysql_query($query)){
            $query_num_rows = mysql_num_rows($query_run);
            //running the query
            if ($query_num_rows==0){
                echo '<script language="javascript">';
                echo 'alert("Invalid Username/Password combination")';
                echo '</script>';
                //echo 'Invalid Username/Password combination';
            }
                      
        //checking if it returns the correct value then start a session
        
            else if ($query_num_rows==1){
                while($query_row=mysql_fetch_array($query_run)){

		          $user=$query_row['username'];
                  $_SESSION['user']=$user;
                  //$user1=$_SESSION['user'];
                  
                  //echo $user1;
                  
                  $user_id=$query_row['id'];
                  $_SESSION['user_id']=$user_id;
                  $query1="SELECT `checking` from `usertable` where `id`='$user_id'";
                  $result1=mysql_query($query1);
                  while($row1=mysql_fetch_array($result1)){
                    $status=$row1["checking"];  
                    if($status==0)
                    {
                        $query2="UPDATE `usertable` SET `checking`='1' WHERE `ID`='$user_id'";
               	        $result2=mysql_query($query2);
                        header ('Location: list.php');
                    }
                  }
                  
                  
                  
                  
                
	           	}
                
                
          
            }   
        } 
    }else {
                echo '<script language="javascript">';
                echo 'alert("Please provide a username and password.")';
                echo '</script>';
    
    }

}
?>
<html>
	<head>
		<title>Chat Application!</title>
        <link rel='stylesheet' type='text/css' href='stylesheet.css'/>
	</head>
	<body>


 
 	<div class="container">
		
		<div class="form-bg">
			<form action="" method="POST">
				<h2>Login</h2>
				<p><input type="text" name = "username" placeholder="Username"></p>
				<p><input type="password" name ="password" placeholder="Password"></p><br>
                <button id ="x"  type="submit"></button>
                <a href="register.php" title="New User" id="xyz"></a>
    

			<form>
		</div>
        
     </div>   


</body>
</html>
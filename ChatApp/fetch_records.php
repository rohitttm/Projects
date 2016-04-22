<?php

    include 'dbfile.php';
    
    $name1 = $_GET['name1'];
    $name2 = $_GET['name2'];

    $user_name1;
    $user_name2;
    $username1=array();
    $timestamp=array();
    $message=array();
    $i=0;
//query from database
    $query="
      Select `user1`,`message`, `timestamp` from `messages` where `user1`='$name1' AND `user2` = '$name2'
      UNION
      Select `user1`,`message`, `timestamp` from `messages` where `user1`='$name2' AND `user2` = '$name1'
      ORDER BY `timestamp`
    ";

    $result1=mysql_query($query);
    $query_num_rows = mysql_num_rows($result1);
    if($query_num_rows>0){
      $count = mysql_num_rows($result1);
      while($query_row1=mysql_fetch_array($result1)){

        global $username1,$timestamp,$message;
        global $i;
        global $name1,$name2;
        global $user_name1,$user_name2;

        
          $username1[$i]=$query_row1['user1'];
        
        
        $timestamp[$i]= $query_row1['timestamp'];
        
        $message[$i]=$query_row1['message'];
        //echo $message.'<br>';
        $i++;
      }

      for($x=0;$x<$count;$x++){
        echo nl2br($username1[$x].' - '.$timestamp[$x].' - '.$message[$x]."\n");
      }
    }   
?>

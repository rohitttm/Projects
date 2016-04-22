<?php
    include 'dbfile.php';
    
    $friend_id_1 = $_POST['user1'];
    $friend_id_2 = $_POST['user2'];
    $chat_message_content = $_POST['message'];
    //$timestamp = date('Y-m-d H:i:s');
    $datevalue=new DateTime("now",new DateTimeZone('America/Los_Angeles'));
    $timestamp = (string)$datevalue->format('Y-m-d H:i:s');
    
    $query="INSERT INTO `messages`(`user1`,`user2`,`message`, `timestamp`) values ('$friend_id_1', '$friend_id_2', '$chat_message_content', '$timestamp')";
    

    if ($query_run=mysql_query($query)) {
        echo "New record created successfully";
    } else {
        echo "Error: " ;
    }
?>

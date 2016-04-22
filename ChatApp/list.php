<html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<head>
		<title>Chat Application!</title>
        <link rel='stylesheet' type='text/css' href='stylesheet3.css'/>
	</head>
<body>

<?php

//session_start();
require 'dbfile.php';
//require 'index.php';
//include 'loginform.php';
    require 'core.php';
    $u=$_SESSION['user'];
    echo "<h1 style='color:#F5F5F5;text-align: center;font-weight:bold;/' >Welcome $u!</h1>";
    //echo "<h1>Welcome $u!<br></h1>";
    $user_id=$_SESSION['user_id'];
    //echo $user_id;
    $id1=0;
	$i=0;
	$i1=0;
	$dost_ka_id=array();
	$dost_ka_naam=array();
    
    //If the friend username is not found on the database
        if(isset($_SESSION['error']))
        {
        echo "<h1>".$_SESSION['error']."</h1>";

        }

$_SESSION['error']="";

//echo "<h2>Your friends are as follows:</h2>";

    //checking and running the function from core.php and if its correct then put a display header
    
    $firstname = getuserfield('firstname');
    $surname = getuserfield('lastname');
    echo "<h1 style='color:#F5F5F5;text-align: center;font-weight:bold;/' >You are logged in, $firstname $surname <a href='logout.php' style ='color:#66FF33';'>Log Out</a></h1></h1>";
    //echo "<h2 You are logged in, '.$firstname.' '.$surname.' <a href=/"logout.php/">Log Out</a></h1><br>";
    
    
    
    
	$query = "SELECT * FROM `friends` WHERE `user_id`='$user_id'";
    
    $query_result = mysql_query($query);
    //echo "$query_result";
	
    //echo '$id';
//check for ids and put it into an array
	if(mysql_num_rows($query_result)>0 ){
	   $count=mysql_num_rows($query_result);
		while($query_row=mysql_fetch_array($query_result)){
			global $id1;
			$id1=$query_row['friend_id'];
            global $dost_ka_id;
			$dost_ka_id[$i]=$query_row['friend_id'];
			$i++;

			//$username=$query_row['username'];
			//echo $id1.'  is Online<br>'.'<br>';
		}
	}
    for($x=0;$x<sizeof($dost_ka_id);$x++)
    {
        //put all friends names for the ids just fetched into a new array
    
		$query1="Select `username` from `usertable` where `id`='$dost_ka_id[$x]'";

		$result=mysql_query($query1);

		if(mysql_num_rows($result)>0){
			while($query_row=mysql_fetch_array($result)){

				//$username=$query_row['username'];
	            global $i1;
				global $dost_ka_naam;

	            $dost_ka_naam[$i1]=$query_row['username'];
	            $i1++;
				//echo $username.' is Online<br>'.'<br>';
			}
		}
    }
//if logged in create a new session
	
    if(loggedin()){
		$user_name=$_SESSION['user'];

		
	}
	else {
		header('Location: loginform.php'); 
	}

	function firstMethod(){
		

		session_destroy();
		header('Location: logon.php');
	}
    
    
    
?>
<script type="text/javascript">
   
   
	var ab='<?php echo $count ; ?>';
	var currentuserid='<?php echo $u ; ?>';
    
    var dosti_naam = new Array();
    <?php foreach($dost_ka_naam as $key => $val){ ?>
        dosti_naam.push('<?php echo $val; ?>');
    <?php } ?>
    
    var dosti_ids = new Array();
    <?php foreach($dost_ka_id as $key => $val){ ?>
        dosti_ids.push('<?php echo $val; ?>');
    <?php } ?>
    
    //create new divisions for friends
	for (var x = 0; x < ab; x++) {
	
		var div=document.createElement("div")
		div.id="input_value"+x+'';		
        div.style.width = "20%";
		div.style.height = "20px";
		div.style.background = "#B6B6B4";
        div.style.border = "solid #E5E4E2";
        div.style.marginLeft = "470px";
        div.style.textAlign = "center";
        div.style.fontFamily = "Georgia";
		div.innerHTML = dosti_naam[x];
		div.setAttribute('data-user-id', dosti_ids[x]);
		div.setAttribute('data-user-name', dosti_naam[x]);
        document.body.appendChild(div);
    }
    	var friend_name;
    for (var x = 0; x < ab; x++) {
	//create input field and chat box
        document.getElementById('input_value'+x+'').addEventListener("click", function(x){
	        var user_id = x.toElement.getAttribute('data-user-id');
			friend_name = x.toElement.getAttribute('data-user-name');    
	    	document.getElementById("demo").innerHTML = '';
    		var div = document.createElement('div');
    		div.setAttribute('id', 'chat');
    		div.setAttribute('style', 'height:300px;width:60em;border: 1px solid; overflow:scroll');
            div.style.backgroundImage = "url('2d.jpg')";
    		document.getElementById('demo').appendChild(div);
	  		var input_msg_box = document.createElement("input");
	  		input_msg_box.setAttribute('name', 'usermsg');
	  		input_msg_box.setAttribute('id', 'usermsg');
	  		input_msg_box.setAttribute('type', 'text');
	        input_msg_box.style.marginLeft = "470px"
	        
	  		//create button
	  		
	        var button = document.createElement("input");
	  		button.setAttribute('name', 'submitmsg');
	  		button.setAttribute('id', 'submitmsg');
	  		button.setAttribute('type', 'submit');
	  		button.setAttribute('value', 'Send');
	        button.setAttribute('data-user-name', friend_name);
	  		button.setAttribute('onclick', 'submit_my_msg()');
	        button.style.marginLeft = "15px";
	  		//append the page
	        document.getElementById('demo1').appendChild(input_msg_box);
	        document.getElementById('demo1').appendChild(button);

	        var description = document.createElement('p');
  			description.innerHTML = "Chatting with " + friend_name;
  			document.getElementById('demo').appendChild(description);
	        
		});
	
	
// ajax to carry and take the message to the database between valid users
	function submit_my_msg(){
		var message = document.getElementById('usermsg').value;
		var friend_id_2 = document.getElementById('submitmsg').getAttribute('data-user-name');
		var object = {user1: currentuserid, user2: friend_id_2, message: message};
		$.ajax({ 
			type: "post",
		    url: "post_record.php",
		    data: {user1: currentuserid, user2: friend_id_2, message: message},
		    success:  function(gadha){
		    	console.log(gadha);
		    	fetch_my_msg();
		    }
    	});
	}

//ajax to carry to fetch_records and fetch the values from database
	function fetch_my_msg(){
		var friend_name1 = friend_name;
		$.ajax({ 
		type: "get",
	    url: "fetch_records.php",
	    data: {name1:currentuserid, name2:friend_name1},
	    success:  function(data){
	    	document.getElementById('chat').innerHTML = '';
	    	var data_el = document.createElement('div');
	    	data_el.innerHTML = data;
	    	document.getElementById('chat').appendChild(data_el);
	    	var elem = document.getElementById('chat');
  			elem.scrollTop = elem.scrollHeight;
	    }
    });
		setTimeout(function(){
			fetch_my_msg();
		}, 1000)
	}	

}
 





</script>

<div id="box">
<p id="demo"></p>
<p id="demo1"</p>


<form action="addphp.php" method="post">
<input type="submit" name="fw_submit" value="ADD FRIEND" id="add_friend_button" style="width:20%;height:50px;background-color:red;margin-top:35px">
<input type="text" name="m" id="m1" style="width:200px;height:38px;marginLeft:10px" placeholder="Enter Friend's Username">
</form>

<!-- <form name="message" action="">
<input name="usermsg" type="text" id="usermsg" size="63" />
<input name="submitmsg" type="submit"Â  id="submitmsg" value="Send" /> -->
</div>

</body>
</html>
   
   
   
   
   

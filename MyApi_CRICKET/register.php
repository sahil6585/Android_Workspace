<?php

    include('connect.php');
    
    $mobile = $_POST["mobile"];
    $password = $_POST["password"];
    $location = $_POST["location"];
    $username = $_POST["username"];

    if($mobile=="" && $password=="" && $location=="" && $username=="")
    {
        echo '0';
    }
    else
    {
        $sql ="insert into signup_detail (mobile,password,location,username) values ('$mobile','$password','$location','$username')";
        mysqli_query($con,$sql);
    }
?>

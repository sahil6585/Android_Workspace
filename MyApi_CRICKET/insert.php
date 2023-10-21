<?php

    include('connect.php');
    
    $cricketer_name = $_POST["cricketer_name"];
    $tscore = $_POST["cricketer_total_score"];
    $cage = $_POST["cricketer_age"];
    $hscore = $_POST["cricketer_highest_score"];
    $cwickets = $_POST["cricketer_wickets"];


    if($cricketer_name=="" && $tscore=="" &&  $cage=="" && $hscore=="" && $cwickets=="")
    {
        echo '0';
    }
    else
    {
        $sql ="insert into cricketer_detail (cricketer_name,cricketer_total_score,cricketer_age,cricketer_highest_score,cricketer_wickets) values ('$cricketer_name','$tscore','$cage','$hscore','$cwickets')";
        mysqli_query($con,$sql);
        
    }

?>

<?php

include('connect.php');//1

 $id=$_POST["id"];
 $cname = $_POST["cricketer_name"];
 $tscore = $_POST["cricketer_total_score"];
 $cage = $_POST["cricketer_age"];
 $hscore = $_POST["cricketer_highest_score"];
 $cwickets = $_POST["cricketer_wickets"];



$sql="Update cricketer_detail set cricketer_name='$cname',cricketer_total_score=',$tscore',cricketer_age='$cage',cricketer_highest_score='$hscore',cricketer_wickets='$cwickets' where id='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Updated Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>

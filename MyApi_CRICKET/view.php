<?php
    
    include('connect.php');//1
    
    $sql="select * from cricketer_detail";//2
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        //3
        $value["id"]=$row["id"];
        $value["cricketer_name"]=$row["cricketer_name"];
        $value["cricketer_total_score"]=$row["cricketer_total_score"];
          $value["cricketer_age"]=$row["cricketer_age"];
            $value["cricketer_highest_score"]=$row["cricketer_highest_score"];
              $value["cricketer_wickets"]=$row["cricketer_wickets"];

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>

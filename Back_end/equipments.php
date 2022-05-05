<?php

include "db_info.php";


function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}


if(isset($_POST['equipment_name']) && isset($_POST['location_street']) && isset($_POST['location_building']) && isset($_POST['location_city']) && isset($_POST['time_arrival'])){

    $name =  validate($_POST['equipment_name']);
    $location_s =  validate($_POST['location_street']);
    $location_b =  validate($_POST['location_building']);
    $location_c =  validate($_POST['location_city']);
    $time =  validate($_POST['time_arrival']);

    $query = "SELECT equipment_available FROM equipments_availability where equipment_name = '" . $name . "'";
    $result = mysqli_query($mysqli, $query);

    if(mysqli_num_rows($result) != 0){

        $row = mysqli_fetch_assoc($result);
        $equipment_available = $row['equipment_available'];

        if($equipment_available == 1){
            //Equipment is = 1 means it is available, equipment is != 1 means it is unavailabe (this will be changed manually)
            
            $query2 = $mysqli->prepare("INSERT INTO equipments(equipment_name, location_street, location_building, location_city, time_arrival) VALUES (?, ?, ?, ?, ?);");
            $query2->bind_param("sssss", $name, $location_s, $location_b, $location_c, $time);
            $query2->execute();
        
        }else{
            echo "Equipmment currently unavailable";
        }
    }


   
    
}



?>
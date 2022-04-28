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


    $query = $mysqli->prepare("INSERT INTO equipments(equipment_name, location_street, location_building, location_city, time_arrival) VALUES (?, ?, ?, ?, ?);");
    $query->bind_param("sssss", $name, $location_s, $location_b, $location_c, $time);
    $query->execute();

    
}



?>
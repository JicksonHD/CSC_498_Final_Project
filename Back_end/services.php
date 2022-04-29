<?php


include "db_info.php";

function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}

if(isset($_POST['services_name']) && isset($_POST['location_street']) && isset($_POST['location_building']) && isset($_POST['location_floor	']) && isset($_POST['location_city']) && isset($_POST['time_arrival'])){


    $name_services = validate($_POST['services_name']);
    $location_s_services =  validate($_POST['location_street']);
    $location_b_services =  validate($_POST['location_building']);
    $location_c_services =  validate($_POST['location_city']);
    $location_f_services = validate($_POST['location_floor']);
    $time_services =  validate($_POST['time_arrival']);

    $querry = $mysqli->prepare("INSERT INTO services(services_name, location_street, location_building, location_floor, location_city, time_arrival) VALUES (?,?,?,?,?,?);");
    $querry->bind_param("ssssss", $name_services, $location_s_services, $location_b_services, $location_c_services, $location_f_services, $time_services);
    $querry->execute();

    
}

?>
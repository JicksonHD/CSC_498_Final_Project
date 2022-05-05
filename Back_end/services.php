<?php

include "db_info.php";

function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}

if(isset($_POST['services_name']) && isset($_POST['location_street']) && isset($_POST['location_building']) && isset($_POST['location_floor']) && isset($_POST['location_city']) && isset($_POST['time_arrival'])){


    $name = validate($_POST['services_name']);
    $location_s = validate($_POST['location_street']);
    $location_b = validate($_POST['location_building']);
    $location_f = validate($_POST['location_floor']);
    $location_c = validate($_POST['location_city']);
    $time = validate($_POST['time_arrival']);


    $querry = "SELECT service_available FROM services_availability where services_name = '" . $name . "'";
    $result = mysqli_query($mysqli, $querry);

    if(mysqli_num_rows($result) != 0){

        $row = mysqli_fetch_assoc($result);
        $service_available = $row['service_available'];

        if($service_available == 1){

            $querry2 = $mysqli->prepare("INSERT INTO services(services_name, location_street, location_building, location_floor, location_city, time_arrival) VALUES (?, ?, ?, ?, ?, ?);");
            $querry2->bind_param("ssssss", $name, $location_s, $location_b, $location_f, $location_c, $time);
            $querry2->execute();
        }else{
            echo "Service currently unavailable";
        }
    }


    

}


?>
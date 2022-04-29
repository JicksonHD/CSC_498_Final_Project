<?php



include "db_info.php";


function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}


if(isset($_POST['material_name']) && isset($_POST['material_type']) && isset($_POST['material_quantity']) && isset($_POST['location_street']) && isset($_POST['location_building']) && isset($_POST['location_city'])){

    $name =  validate($_POST['material_name']);
    $location_s =  validate($_POST['location_street']);
    $location_b =  validate($_POST['location_building']);
    $location_c =  validate($_POST['location_city']);
    $quantity =  validate($_POST['material_quantity']);
    $type = validate($_POST['material_type']);


    $query = $mysqli->prepare("INSERT INTO materials(material_name, material_type, material_quantity, location_street, location_building, location_city) VALUES (?, ?, ?, ?, ?, ?);");
    $query->bind_param("ssisss", $name, $type, $quantity, $location_s, $location_b, $location_c);
    $query->execute();

    
}












?>
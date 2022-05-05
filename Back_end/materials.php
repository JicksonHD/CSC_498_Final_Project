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


    $query = "SELECT quantity_available FROM quantities WHERE material_name= '" . $name . "'";
    $result = mysqli_query($mysqli, $query);

    if (mysqli_num_rows($result) != 0) {

        $row = mysqli_fetch_assoc($result);
        $quantity_available = $row['quantity_available'];

        if($quantity_available > $quantity){
            $query2 = $mysqli->prepare("INSERT INTO materials(material_name, material_type, material_quantity, location_street, location_building, location_city) VALUES (?, ?, ?, ?, ?, ?);");
            $query2->bind_param("ssisss", $name, $type, $quantity, $location_s, $location_b, $location_c);
            $query2->execute();

            $remaining_quantity = $quantity_available - $quantity;

            $query3 = $mysqli->prepare("UPDATE quantities SET quantity_available = ? where material_name = ?;");
            $query3->bind_param("is", $remaining_quantity, $name);
            $query3->execute();

            $response['quantity_available'] = $remaining_quantity;
            $json_respnse = json_encode($response);
            echo $json_respnse;

        } 
        else{
            echo "Not enough quantity";
        }   
    }

}













?>
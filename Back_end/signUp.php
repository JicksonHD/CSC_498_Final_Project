<?php

include "db_info.php";

function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}
if (isset($_POST['user_email']) && isset($_POST['user_password']) && isset($_POST['user_number'])){

   
    $email = validate($_POST['user_email']);
    $password = password_hash($_POST['user_password'], PASSWORD_DEFAULT);
    $phone_number = validate($_POST['user_number']);

    
    $sql1 = "SELECT * FROM users WHERE user_email ='$email'";
    $result1 = mysqli_query($mysqli, $sql1);

    if (mysqli_num_rows($result1) != 0) {
        echo("This account already exist");
        exit();
     }
    else{
        $query = $mysqli->prepare("INSERT INTO users(user_email, user_password, user_number) VALUES (?, ?, ?);");
        $query->bind_param("sss", $email, $password, $phone_number);
        $query->execute();
        echo "Account Created!";

    }
}

?>
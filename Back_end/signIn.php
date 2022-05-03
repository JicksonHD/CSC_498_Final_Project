<?php


include "db_info.php";

function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}
if (isset($_POST['user_email']) && isset($_POST['user_password'])) {

$email = validate($_POST['user_email']);
$password =  validate($_POST['user_password']);


    
        $sql ="SELECT * FROM users WHERE user_email = '" .$email. "'";
        $result = mysqli_query($mysqli, $sql);

        if (mysqli_num_rows($result) != 0) {
            $row = mysqli_fetch_assoc($result);

            $dbemail = $row['user_email'];
            $dbpassword = $row['user_password'];

            if ($dbemail == $email && password_verify($password, $dbpassword)) {
                $response[] = $row;
                $json_respnse = json_encode($response);
                echo $json_respnse;
                
               // exit();
            }   
            else{
                echo "Incorrect Username or password";
               // exit();
            }
        }
        else{
            echo "Incorrect Username or password";
           // exit();
        }
    
    }



?>
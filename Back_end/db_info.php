<?php

$db_host = "localhost";
$db_user = "root";
$db_pass = null;
$db_name = "lets_build_db";

$mysqli = new mysqli($db_host,$db_user,$db_pass,$db_name);

if(mysqli_connect_errno()){
    die("Connection failed");
}

?>
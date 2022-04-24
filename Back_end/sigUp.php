<?php

include("db_info.php");

$querry = $mysqli->prepare("SELECT * FROM users;");
$querry->execute();

?>
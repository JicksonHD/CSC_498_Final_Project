<?php

include "db_info.php";

function validate($data){
    $data = trim($data);
    $data = stripslashes($data);
    return $data;
}

if(isset($_POST['task_content'])){

    $tasks = validate($_POST['task_content']);

    $query = $mysqli->prepare("INSERT INTO tasks(task_content) VALUES (?);");
    $query->bind_param("s", $tasks);
    $query->execute();
}

?>
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

    /*
    if (mysqli_num_rows($result) != 0){

        $row = mysqli_fetch_assoc($result);
        $tasks = $row['task_content'];

        $querry = $mysqli->prepare("UPDATE tasks DELETE task_content = ? where task_id = ?;");
        $querry->execute();
    }
    */
}

?>
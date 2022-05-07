<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->emplogIn("employee", $_POST['username'], $_POST['password'])) {
            echo " Employee Login Success";
        } else echo "Username or Password wrong";
    } else echo "Error: Database connection";
}
?>

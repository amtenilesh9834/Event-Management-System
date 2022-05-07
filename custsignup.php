<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_REQUEST['fullname']) && isset($_REQUEST['email']) && isset($_REQUEST['username']) && isset($_REQUEST['password'])) {
    if ($db->dbConnect()) {
        if ($db->custsignUp("customer", $_REQUEST['fullname'], $_REQUEST['email'], $_REQUEST['username'], $_REQUEST['password'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "Error";
?>

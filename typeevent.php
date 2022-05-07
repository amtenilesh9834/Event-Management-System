<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['setype'])) {
    if ($db->dbConnect()) {
        if ($db->typeEvent("typeevent", $_REQUEST['setype'])) {
            echo "Car Added Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

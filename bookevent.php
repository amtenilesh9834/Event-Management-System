<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['totalmember'])) {
    if ($db->dbConnect()) {
        if ($db->fillForm("bookevent", $_REQUEST['totalmember'])) {
            echo "Event Book Success";
        } else echo "Bokk Event Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

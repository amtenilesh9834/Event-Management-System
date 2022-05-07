<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['etype']) && isset($_REQUEST['capacity']) && isset($_REQUEST['address']) && isset($_REQUEST['location'])&& isset($_REQUEST['date']) && isset($_REQUEST['time'])) {
    if ($db->dbConnect()) {
        if ($db->addEvent("addevent", $_REQUEST['etype'], $_REQUEST['capacity'], $_REQUEST['address'], $_REQUEST['location'], $_REQUEST['date'], $_REQUEST['time'])) {
            echo "Event Added Success";
        } else echo "Event Fill Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

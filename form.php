<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['fname']) && isset($_REQUEST['edate']) && isset($_REQUEST['venue']) && isset($_REQUEST['ename'])&& isset($_REQUEST['etype']) && isset($_REQUEST['photo']) && isset($_REQUEST['decor']) && isset($_REQUEST['cater'])) {
    if ($db->dbConnect()) {
        if ($db->fillForm("form", $_REQUEST['fname'], $_REQUEST['edate'], $_REQUEST['venue'], $_REQUEST['ename'], $_REQUEST['etype'], $_REQUEST['photo'], $_REQUEST['decor'], $_REQUEST['cater'])) {
            echo "Event Added Success";
        } else echo "Form Fill Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

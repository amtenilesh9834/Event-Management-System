<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['feed1']) && isset($_REQUEST['feed2']) && isset($_REQUEST['feed4'])) {
    if ($db->dbConnect()) {
        if ($db->custfeedBack("feedback", $_REQUEST['feed1'], $_REQUEST['feed2'], $_REQUEST['feed4'])) {
            echo "FeedBack Submit Success";
        } else echo "Form Fill Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

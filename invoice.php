<?php
require "DataBase.php";
$db = new DataBase();
// echo $_REQUEST['dmono'];
if (isset($_REQUEST['siename']) && isset($_REQUEST['seprice']) && isset($_REQUEST['sphoto']) && isset($_REQUEST['scater']) && isset($_REQUEST['sdecor']) && isset($_REQUEST['sgst']) && isset($_REQUEST['stotal'])) {
    if ($db->dbConnect()) {
        if ($db->addInvoice("invoice", $_REQUEST['siename'], $_REQUEST['seprice'], $_REQUEST['sphoto'], $_REQUEST['scater'], $_REQUEST['sdecor'], $_REQUEST['sgst'], $_REQUEST['stotal'])) {
            echo "Invoice Created Success";
        }
        
         else echo "Invoice Failed";
    } else echo "Error: Database connection";
} else echo "Error Here";
?>

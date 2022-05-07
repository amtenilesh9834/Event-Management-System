<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $Logi;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }
    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function custlogIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $custlogin = true;
            } else $custlogin = false;
        } else $custlogin = false;

        return $custlogin;
    }

    function emplogIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $emplogin = true;
            } else $emplogin = false;
        } else $emplogin = false;

        return $emplogin;
    }

  
    function signUp($users, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $users . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
   
    function custsignUp($customer, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $customer . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function empsignUp($employee, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $employee . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
  
  
    
     function addCar($addcar, $car_no, $car_mod, $car_cap, $d_name, $d_mo_no)
     {
       
        $car_no = $this->prepareData($car_no);
        $car_mod = $this->prepareData($car_mod);
        $car_cap = $this->prepareData($car_cap);
        $d_name = $this->prepareData($d_name);
	$d_mo_no = $this->prepareData($d_mo_no);
        $this->sql =
            "INSERT INTO " . $addcar . " (car_no, car_mod, car_cap, d_name, d_mo_no) VALUES ('" . $car_no . "','" . $car_mod . "','" . $car_cap . "','" . $d_name . "','" . $d_mo_no . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

   function fillForm($form, $fname, $edate, $venue, $ename, $etype, $photo, $decor, $cater)
     {
       
        $form = $this->prepareData($form);
        $edate = $this->prepareData($edate);
        $venue = $this->prepareData($venue);
        $ename = $this->prepareData($ename);		
	$etype = $this->prepareData($etype);
	$photo = $this->prepareData($photo);
	$decor = $this->prepareData($decor);
	$cater = $this->prepareData($cater);

        $this->sql =
            "INSERT INTO " . $form . " (fname, edate, venue, ename, etype, photo, decor, cater) VALUES ('" . $fname . "','" . $edate . "','" . $venue . "','" . $ename . "','" . $etype . "','" . $photo . "','" . $decor . "','" . $cater . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

     function addEvent($addevent, $etype, $capacity, $address, $location, $date, $time)
     {
       
        $etype = $this->prepareData($etype);
        $capacity = $this->prepareData($capacity);
        $address = $this->prepareData($address);
        $location = $this->prepareData($location);
	$date = $this->prepareData($date);
	$time = $this->prepareData($time);
        $this->sql =
            "INSERT INTO " . $addevent . " (etype, capacity, address, location, date, time) VALUES ('" . $etype . "','" . $capacity . "','" . $address . "','" . $location . "','" . $date . "','" . $time . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
   
	function bookEvent($bookevent, $totalmember)
     {
       
        $totalmember = $this->prepareData($totalmember);
        $this->sql =
            "INSERT INTO " . $bookevent . " (totalmember) VALUES ('" . $totalmember . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

	 function addInvoice($invoice, $ename, $eprice, $photo, $cater, $decor, $gst, $total)
     {
       
        $ename = $this->prepareData($ename);
        $eprice = $this->prepareData($eprice);
        $photo = $this->prepareData($photo);
        $cater = $this->prepareData($cater);
    	$decor = $this->prepareData($decor);
	$gst = $this->prepareData($gst);
	$total = $this->prepareData($total);
        $this->sql =
            "INSERT INTO " . $invoice . " (ename, eprice, photo, cater, decor, gst, total) VALUES ('" . $ename . "','" . $eprice . "','" . $photo . "','" . $cater . "','" . $decor . "','" . $gst . "','" . $eprice+$photo+$cater+$decor+$gst  . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

  function typeEvent($typeevent, $setype)
     {
       
        $setype = $this->prepareData($setype);
        $this->sql =
            "INSERT INTO " . $typeevent . " (setype) VALUES ('" . $setype. "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }



    function custfeedBack($feedback, $feed1, $feed2,  $feed4)
    {
  
        $feed1 = $this->prepareData($feed1);
        $feed2 = $this->prepareData($feed2);
        // $feed3 = $this->prepareData($feed3);
        $feed4 = $this->prepareData($feed4);		


     $this->sql =
           "INSERT INTO " . $feedback . " (feed1, feed2, feed4) VALUES ('" . $feed1 . "','" . $feed2 . "','" . $feed4 . "')";
     if (mysqli_query($this->connect, $this->sql)) {
           return true;
      } else return false;
    }
}
?>

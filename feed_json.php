<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"eventmanagement");

$qry="select * from feedback";

$result=mysqli_query($conn,$qry);

while($res=mysqli_fetch_array($result))
{
    $data[]=$res;
}
print(json_encode($data));
?>
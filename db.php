<?php
$conexion = mysqli_connect("127.0.0.1:3307", "root", "", "reto2");
if (!$conexion) {
    die("Connection failed: " . mysqli_connect_error());
}
?>
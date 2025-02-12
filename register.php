<?php
session_start();
header("Cache-Control: no-cache, must-revalidate"); 
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); 
include('db.php');

$usuario = $_POST['usuario'];
$contrasena = $_POST['contrasena'];

$consulta = "SELECT id_agencia, nombre, color_marca FROM agencias WHERE nombre = '$usuario' AND contrasena = '$contrasena'";
$resultado = mysqli_query($conexion, $consulta);

if ($fila = mysqli_fetch_assoc($resultado)) {
    $_SESSION['id_agencia'] = $fila['id_agencia'];
    $_SESSION['nombre_agencia'] = $fila['nombre'];
    $_SESSION['color_marca'] = $fila['color_marca'];
    header("Location: eleccion.php");
    exit();
} else {
    header("Location: index.php?error=1");
    exit();
}

mysqli_free_result($resultado);
mysqli_close($conexion);
?>
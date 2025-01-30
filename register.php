<?php
include('db.php');

$usuario = $_POST['usuario'];
$contrasena = $_POST['contrasena'];

$consulta = "SELECT * FROM agencias WHERE nombre = '$usuario' AND contrasena = '$contrasena'";
$resultado = mysqli_query($conexion, $consulta);

if (mysqli_num_rows($resultado) > 0) {
    header("Location: eleccion.php");
    exit();
} else {
    header("Location: index.php?error=1");
    exit();
}

mysqli_free_result($resultado);
mysqli_close($conexion);
?>


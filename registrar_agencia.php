<?php
require 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre = $_POST['nombre'] ?? '';
    $logo = $_POST['logo'] ?? '';
    $colorMarca = $_POST['color_marca'] ?? '';
    $numeroEmpleados = $_POST['numero_empleados'] ?? '';
    $tipoAgencia = $_POST['tipo_agencia'] ?? '';
    $contrasena = $_POST['contrasena'] ?? '';

    $sql = "INSERT INTO agencias (nombre, logo, color_marca, numero_empleados, tipo_agencia, contrasena) 
            VALUES (?, ?, ?, ?, ?, ?)";

    $stmt = $conexion->prepare($sql);
    $stmt->bind_param("ssssss", $nombre, $logo, $colorMarca, $numeroEmpleados, $tipoAgencia, $contrasena);

    if ($stmt->execute()) {
        echo "<script>alert('Agencia registrada correctamente'); window.location.href='index.php';</script>";
    } else {
        echo "Error al registrar la agencia: " . $conexion->error;
    }

    $stmt->close();
}

$conexion->close();
?>
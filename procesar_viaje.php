<?php
require 'db.php';
session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre = $_POST['nombre'] ?? '';
    $tipoViaje = $_POST['eligeViaje'] ?? '';
    $fechaInicio = $_POST['fechaInicio'] ?? '';
    $fechaFin = $_POST['fechaFin'] ?? '';
    $dias = $_POST['dias'] ?? 0;
    $pais = $_POST['pais'] ?? '';
    $descripcion = $_POST['descripcion'] ?? '';
    $otrosServicios = $_POST['otrosServicios'] ?? '';
    $id_agencia = $_SESSION['id_agencia'] ?? 0;

    if (empty($pais)) {
        die("<script>alert('Error: No se seleccionó un país.'); window.history.back();</script>");
    }

    $sql = "INSERT INTO viajes (nombre, tipo_viaje, fecha_inicio, fecha_fin, duracion, pais_destino, descripcion, servicios_no_incluidos, id_agencia) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    $stmt = $conexion->prepare($sql);
    $stmt->bind_param("ssssisssi", $nombre, $tipoViaje, $fechaInicio, $fechaFin, $dias, $pais, $descripcion, $otrosServicios, $id_agencia);

    if ($stmt->execute()) {
        echo "<script>
                alert('Datos guardados correctamente');
                window.location.href='eleccion.php';
              </script>";
    } else {
        echo "Error al guardar los datos: " . $conexion->error;
    }

    $stmt->close();
    $conexion->close();
}
?>
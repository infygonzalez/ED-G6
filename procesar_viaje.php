<?php
// Incluir archivo de conexión
require 'db.php';

// Verificar si el formulario fue enviado
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre = $_POST['nombre'];
    $tipoViaje = $_POST['eligeViaje'];
    $fechaInicio = $_POST['fechaInicio'];
    $fechaFin = $_POST['fechaFin'];
    $dias = $_POST['dias'];
    $pais = $_POST['paises'];
    $descripcion = $_POST['descripcion'];
    $otrosServicios = $_POST['otrosServicios'];
    $id_agencia = 1; // Valor por defecto

    // Preparar la consulta SQL
    $sql = "INSERT INTO viajes (nombre, tipo_viaje, fecha_inicio, fecha_fin, duracion, pais_destino, descripcion, servicios_no_incluidos, id_agencia) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    $stmt = $conexion->prepare($sql);
    $stmt->bind_param("ssssisssi", $nombre, $tipoViaje, $fechaInicio, $fechaFin, $dias, $pais, $descripcion, $otrosServicios, $id_agencia);
    
    // Ejecutar la consulta
    if ($stmt->execute()) {
        echo "<script>alert('Datos guardados correctamente'); window.location.href='RegistrarViaje.php';</script>";
    } else {
        echo "Error: " . $conexion->error;
    }
    
    $stmt->close();
}

$conexion->close();
?>

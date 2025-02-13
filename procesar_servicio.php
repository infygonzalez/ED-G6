<?php
include 'db.php';

$tipoServicio = $_POST['tipoServicio'] ?? '';
$id_viaje = $_POST['id_viaje'] ?? 0;

if ($tipoServicio == "alojamiento") {
    $nombreHotel = $_POST['nombreHotel'] ?? '';
    $ciudad = $_POST['ciudad'] ?? '';
    $precio = $_POST['precio'] ?? 0;
    $fechaEntrada = $_POST['fechaEntrada'] ?? '';
    $fechaSalida = $_POST['fechaSalida'] ?? '';
    $tipoHabitacion = $_POST['tipoHabitacion'] ?? '';

    $sql_evento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES ('alojamiento', '$id_viaje', '$nombreHotel', '$fechaEntrada', '$precio')";
    if ($conexion->query($sql_evento) === TRUE) {
        $id_evento = $conexion->insert_id;

        $sql = "INSERT INTO alojamientos (id_evento, nombre_hotel, ciudad, precio_euros, fecha_entrada, fecha_salida, tipo_habitacion)
                VALUES ('$id_evento', '$nombreHotel', '$ciudad', '$precio', '$fechaEntrada', '$fechaSalida', '$tipoHabitacion')";
        if ($conexion->query($sql) === TRUE) {
            echo "<script>
                    alert('Datos guardados correctamente');
                    window.location.href='eleccion.php';
                  </script>";
        } else {
            echo "Error al guardar los datos: " . $conexion->error;
        }
    } else {
        echo "Error al guardar los datos: " . $conexion->error;
    }

} elseif ($tipoServicio == "vuelo") {
    $tipoVuelo = $_POST['tipoVuelo'] ?? 'ida';
    $aeropuertoOrigen = $_POST['origen'] ?? '';
    $aeropuertoDestino = $_POST['destino'] ?? '';
    $codigoVuelo = $_POST['codigoVuelo'] ?? '';
    $aerolinea = $_POST['aerolinea'] ?? '';
    $precioVuelo = $_POST['precioVuelo'] ?? 0;
    $fechaSalida = $_POST['fechaSalida'] ?? '';
    $horaSalida = $_POST['horaSalida'] ?? '';
    $duracion = $_POST['duracion'] ?? 0;

    $fechaVuelta = $_POST['fechaVuelta'] ?? NULL;
    $horaVuelta = $_POST['horaVuelta'] ?? NULL;
    $duracionVuelta = $_POST['duracionVuelta'] ?? NULL;
    $codigoVueloVuelta = $_POST['codigoVueloVuelta'] ?? NULL;
    $aerolineaVuelta = $_POST['aerolineaVuelta'] ?? NULL;

    $sql_evento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES ('vuelo', '$id_viaje', '$codigoVuelo', '$fechaSalida', '$precioVuelo')";
    if ($conexion->query($sql_evento) === TRUE) {
        $id_evento = $conexion->insert_id;

        $sql = "INSERT INTO vuelos (id_evento, aeropuerto_origen, aeropuerto_destino, codigo_vuelo, aerolinea, precio_euros, fecha_salida, hora_salida, duracion_viaje, tipo_vuelo, fecha_vuelta, hora_vuelta, duracion_viaje_vuelta, codigo_vuelo_vuelta, aerolinea_vuelta)
                VALUES ('$id_evento', '$aeropuertoOrigen', '$aeropuertoDestino', '$codigoVuelo', '$aerolinea', '$precioVuelo', '$fechaSalida', '$horaSalida', '$duracion', '$tipoVuelo', '$fechaVuelta', '$horaVuelta', '$duracionVuelta', '$codigoVueloVuelta', '$aerolineaVuelta')";
        if ($conexion->query($sql) === TRUE) {
            echo "<script>
                    alert('Datos guardados correctamente');
                    window.location.href='eleccion.php';
                  </script>";
        } else {
            echo "Error al guardar los datos: " . $conexion->error;
        }
    } else {
        echo "Error al guardar los datos: " . $conexion->error;
    }

} elseif ($tipoServicio == "otros") {
    $nombreServicio = $_POST['nombreServicio'] ?? '';
    $fechaServicio = $_POST['fechaServicio'] ?? '';
    $descripcion = $_POST['descripcion'] ?? '';
    $precioServicio = $_POST['precioServicio'] ?? 0;

    $sql_evento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES ('otros', '$id_viaje', '$nombreServicio', '$fechaServicio', '$precioServicio')";
    if ($conexion->query($sql_evento) === TRUE) {
        $id_evento = $conexion->insert_id;

        $sql = "INSERT INTO otroseventos (id_evento, nombre, fecha, descripcion, precio_euros)
                VALUES ('$id_evento', '$nombreServicio', '$fechaServicio', '$descripcion', '$precioServicio')";
        if ($conexion->query($sql) === TRUE) {
            echo "<script>
                    alert('Datos guardados correctamente');
                    window.location.href='eleccion.php';
                  </script>";
        } else {
            echo "Error al guardar los datos: " . $conexion->error;
        }
    } else {
        echo "Error al guardar los datos: " . $conexion->error;
    }
}

$conexion->close();
?>
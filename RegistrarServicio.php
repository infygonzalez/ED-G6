<?php
session_start();
require 'db.php';

$id_agencia = $_SESSION['id_agencia'] ?? 0;
$sql = "SELECT nombre, logo, color_marca FROM agencias WHERE id_agencia = ?";
$stmt = $conexion->prepare($sql);
$stmt->bind_param("i", $id_agencia);
$stmt->execute();
$resultado = $stmt->get_result();
$agencia = $resultado->fetch_assoc();

$nombreAgencia = $agencia['nombre'] ?? 'Agencia';
$logo = $agencia['logo'] ?? '';
$colorMarca = $agencia['color_marca'] ?? '#000000';
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Servicio</title>
    <link rel="stylesheet" href="estilos/estilosServicios.css">
</head>
<body>
    <header class="header">
        <div class="header-left">
            <img src="<?php echo htmlspecialchars($logo); ?>" alt="Logo" class="logo">
        </div>
        <div class="header-center">
            <h1 style="color: <?php echo htmlspecialchars($colorMarca); ?>;"><?php echo htmlspecialchars($nombreAgencia); ?></h1>
        </div>
        <div class="header-right">
            <button class="atras" onclick="atras()">Atrás</button>
            <button class="cerrar-sesion" onclick="logout()">Cerrar Sesión</button>
        </div>
    </header>

    <div class="formulario">
        <?php if (isset($_GET['error'])): ?>
            <div class="error">
                <?php echo htmlspecialchars($_GET['error']); ?>
            </div>
        <?php elseif (isset($_GET['success'])): ?>
            <div class="success">
                Servicio registrado con éxito.
            </div>
        <?php endif; ?>

        <form action="procesar_servicio.php" method="post" class="mensaje_dfb" onsubmit="return validarFormulario()">
            <h1>Registrar Servicio</h1>

            <label for="id_viaje">¿A qué viaje quieres asociar el servicio?</label>
            <select id="id_viaje" name="id_viaje" required>
                <option value="" disabled selected>----Seleccione----</option>
                <?php
                $sql_viajes = "SELECT id_viaje, nombre FROM viajes WHERE id_agencia = ? ORDER BY nombre ASC";
                $stmt_viajes = $conexion->prepare($sql_viajes);
                $stmt_viajes->bind_param("i", $id_agencia);
                $stmt_viajes->execute();
                $resultado_viajes = $stmt_viajes->get_result();
                while ($viaje = $resultado_viajes->fetch_assoc()) {
                    echo '<option value="' . htmlspecialchars($viaje['id_viaje']) . '">' . htmlspecialchars($viaje['nombre']) . '</option>';
                }
                ?>
            </select>

            <label for="tipoServicio">¿Qué servicio quieres registrar?</label>
            <select id="tipoServicio" name="tipoServicio" onchange="mostrarFormulario()" required>
                <option value="" disabled selected>----Seleccione----</option>
                <option value="alojamiento">Alojamiento</option>
                <option value="vuelo">Vuelo</option>
                <option value="otros">Otros Servicios</option>
            </select>

            <div id="form-alojamiento" class="hidden">
                <label for="nombreHotel">Nombre del hotel</label>
                <input type="text" id="nombreHotel" name="nombreHotel" disabled required>

                <label for="ciudad">Ciudad</label>
                <input type="text" id="ciudad" name="ciudad" disabled required>

                <label for="precio">Precio</label>
                <input type="number" id="precio" name="precio" min="0" disabled required>

                <label for="fechaEntrada">Fecha de entrada</label>
                <input type="date" id="fechaEntrada" name="fechaEntrada" disabled required>

                <label for="fechaSalida">Fecha de salida</label>
                <input type="date" id="fechaSalida" name="fechaSalida" disabled required>

                <label for="tipoHabitacion">Tipo de habitación</label>
                <select name="tipoHabitacion" id="tipoHabitacion" disabled required>
                    <option value="" disabled selected>----Seleccione----</option>
                    <option value="habitacionIndividual">Habitación individual</option>
                    <option value="habitacionDoble">Habitación doble</option>
                    <option value="habitacioDobleIndividual">Habitación doble (individual)</option>
                    <option value="habitacionTriple">Habitación triple</option>
                </select>
            </div>

            <div id="form-vuelo" class="hidden">
                <label for="tipoVuelo">Tipo de vuelo</label>
                <select id="tipoVuelo" name="tipoVuelo" onchange="mostrarVuelo()" required>
                    <option value="" disabled selected>----Seleccione----</option>
                    <option value="ida">Ida</option>
                    <option value="ida_vuelta">Ida y vuelta</option>
                </select>

                <div id="form-vuelo-ida" class="vuelo-bloque hidden">
                    <h2>Vuelo de Ida</h2>
                    <label for="origen">Aeropuerto de origen</label>
                    <select id="origen" name="origen" required>
                        <option value="" disabled selected>----Seleccione----</option>
                        <?php
                        $sql_aeropuertos = "SELECT codigo, nombre_aeropuerto FROM codigosaeropuerto ORDER BY nombre_aeropuerto ASC";
                        $resultado_aeropuertos = $conexion->query($sql_aeropuertos);
                        while ($aeropuerto = $resultado_aeropuertos->fetch_assoc()) {
                            echo '<option value="' . htmlspecialchars($aeropuerto['codigo']) . '">' . htmlspecialchars($aeropuerto['nombre_aeropuerto']) . '</option>';
                        }
                        ?>
                    </select>

                    <label for="destino">Aeropuerto de llegada</label>
                    <select id="destino" name="destino" required>
                        <option value="" disabled selected>----Seleccione----</option>
                        <?php
                        $resultado_aeropuertos->data_seek(0); // Reset result pointer
                        while ($aeropuerto = $resultado_aeropuertos->fetch_assoc()) {
                            echo '<option value="' . htmlspecialchars($aeropuerto['codigo']) . '">' . htmlspecialchars($aeropuerto['nombre_aeropuerto']) . '</option>';
                        }
                        ?>
                    </select>

                    <label for="codigoVuelo">Código de vuelo</label>
                    <input type="text" id="codigoVuelo" name="codigoVuelo" required>

                    <label for="aerolinea">Aerolínea</label>
                    <select id="aerolinea" name="aerolinea" required>
                        <option value="" disabled selected>----Seleccione----</option>
                        <?php
                        $sql_aerolineas = "SELECT id_aerolinea, nombre FROM aerolineas ORDER BY nombre ASC";
                        $resultado_aerolineas = $conexion->query($sql_aerolineas);
                        while ($aerolinea = $resultado_aerolineas->fetch_assoc()) {
                            echo '<option value="' . htmlspecialchars($aerolinea['id_aerolinea']) . '">' . htmlspecialchars($aerolinea['nombre']) . '</option>';
                        }
                        ?>
                    </select>

                    <label for="precioVuelo">Precio</label>
                    <input type="number" id="precioVuelo" name="precioVuelo" min="0" required>

                    <label for="fechaSalida">Fecha de salida</label>
                    <input type="date" id="fechaSalida" name="fechaSalida" required>

                    <label for="horaSalida">Hora de salida</label>
                    <input type="time" id="horaSalida" name="horaSalida" required>

                    <label for="duracion">Duración del vuelo (horas)</label>
                    <input type="number" id="duracion" name="duracion" min="0" required>
                </div>

                <div id="form-vuelo-vuelta" class="vuelo-bloque hidden">
                    <h2>Vuelo de Vuelta</h2>
                    <label for="fechaVuelta">Fecha de vuelta</label>
                    <input type="date" id="fechaVuelta" name="fechaVuelta" required>

                    <label for="horaVuelta">Hora de vuelta</label>
                    <input type="time" id="horaVuelta" name="horaVuelta" required>

                    <label for="duracionVuelta">Duración del vuelo de vuelta (horas)</label>
                    <input type="number" id="duracionVuelta" name="duracionVuelta" min="0" required>

                    <label for="codigoVueloVuelta">Código de vuelo de vuelta</label>
                    <input type="text" id="codigoVueloVuelta" name="codigoVueloVuelta" required>

                    <label for="aerolineaVuelta">Aerolínea de vuelta</label>
                    <select id="aerolineaVuelta" name="aerolineaVuelta" required>
                        <option value="" disabled selected>----Seleccione----</option>
                        <?php
                        $resultado_aerolineas->data_seek(0); // Reset result pointer
                        while ($aerolinea = $resultado_aerolineas->fetch_assoc()) {
                            echo '<option value="' . htmlspecialchars($aerolinea['id_aerolinea']) . '">' . htmlspecialchars($aerolinea['nombre']) . '</option>';
                        }
                        ?>
                    </select>
                </div>
            </div>

            <div id="form-otros" class="hidden">
                <label for="nombreServicio">Nombre</label>
                <input type="text" id="nombreServicio" name="nombreServicio" disabled required>

                <label for="fechaServicio">Fecha</label>
                <input type="date" id="fechaServicio" name="fechaServicio" disabled required>

                <label for="descripcion">Descripción</label>
                <textarea id="descripcion" name="descripcion" disabled required></textarea>

                <label for="precioServicio">Precio</label>
                <input type="number" id="precioServicio" name="precioServicio" min="0" disabled required>
            </div>

            <button type="submit">Guardar Servicio</button>
        </form>
    </div>

    <footer class="footer">
        <div class="footer-content">
            <img src="media/copyright.png" alt="Copyright">
            <p>&copy; 2025 Viajes Elorrieta. Todos los derechos reservados.</p>
        </div>
    </footer>

    <script>
        function mostrarFormulario() {
            // Ocultar y deshabilitar todos los formularios
            document.getElementById("form-alojamiento").classList.add("hidden");
            document.getElementById("form-vuelo").classList.add("hidden");
            document.getElementById("form-otros").classList.add("hidden");
            deshabilitarCampos("form-alojamiento");
            deshabilitarCampos("form-vuelo");
            deshabilitarCampos("form-otros");

            // Mostrar y habilitar el formulario seleccionado
            let tipo = document.getElementById("tipoServicio").value;
            if (tipo === "alojamiento") {
                document.getElementById("form-alojamiento").classList.remove("hidden");
                habilitarCampos("form-alojamiento");
            } else if (tipo === "vuelo") {
                document.getElementById("form-vuelo").classList.remove("hidden");
                habilitarCampos("form-vuelo");
            } else if (tipo === "otros") {
                document.getElementById("form-otros").classList.remove("hidden");
                habilitarCampos("form-otros");
            }
        }

        function mostrarVuelo() {
            document.getElementById("form-vuelo-ida").classList.add("hidden");
            document.getElementById("form-vuelo-vuelta").classList.add("hidden");
            deshabilitarCampos("form-vuelo-ida");
            deshabilitarCampos("form-vuelo-vuelta");

            let tipoVuelo = document.getElementById("tipoVuelo").value;
            if (tipoVuelo === "ida") {
                document.getElementById("form-vuelo-ida").classList.remove("hidden");
                habilitarCampos("form-vuelo-ida");
            } else if (tipoVuelo === "ida_vuelta") {
                document.getElementById("form-vuelo-ida").classList.remove("hidden");
                document.getElementById("form-vuelo-vuelta").classList.remove("hidden");
                habilitarCampos("form-vuelo-ida");
                habilitarCampos("form-vuelo-vuelta");
            }
        }

        function deshabilitarCampos(formId) {
            let form = document.getElementById(formId);
            let elements = form.querySelectorAll("input, select, textarea");
            elements.forEach(element => {
                element.disabled = true;
            });
        }

        function habilitarCampos(formId) {
            let form = document.getElementById(formId);
            let elements = form.querySelectorAll("input, select, textarea");
            elements.forEach(element => {
                element.disabled = false;
            });
        }

        function validarFormulario() {
            let tipoServicio = document.getElementById("tipoServicio").value;
            if (tipoServicio === "alojamiento") {
                let fechaEntrada = new Date(document.getElementById("fechaEntrada").value);
                let fechaSalida = new Date(document.getElementById("fechaSalida").value);
                if (fechaEntrada >= fechaSalida) {
                    alert("La fecha de salida debe ser posterior a la fecha de entrada.");
                    return false;
                }
            } else if (tipoServicio === "vuelo") {
                let fechaSalida = new Date(document.getElementById("fechaSalida").value);
                let fechaVuelta = new Date(document.getElementById("fechaVuelta").value);
                if (document.getElementById("tipoVuelo").value === "ida_vuelta" && fechaSalida >= fechaVuelta) {
                    alert("La fecha de vuelta debe ser posterior a la fecha de salida.");
                    return false;
                }
            }
            return true;
        }

        function logout() {
            window.location.href = 'logout.php';
        }

        function atras() {
            window.location.href = 'eleccion.php';
        }
    </script>
</body>
</html>
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

$sql_paises = "SELECT nombre FROM paises ORDER BY nombre ASC";
$resultado_paises = $conexion->query($sql_paises);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Viaje</title>
    <link rel="stylesheet" href="estilos/estilosViaje.css">
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

    <br><br><br>

    <div class="formulario">
        <form action="procesar_viaje.php" method="post" class="mensaje_dfb" onsubmit="return validarFormulario()">
            <div>
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Escriba aquí su nombre" required>
            </div>
            <br>
            <div>
                <label for="tipoViaje">Tipo de viaje</label>
                <select name="eligeViaje" id="eligeViaje" required>
                    <option value="" disabled selected>----Seleccione----</option>
                    <option value="novios">Novios</option>
                    <option value="senior">Senior</option>
                    <option value="grupos">Grupos</option>
                    <option value="GrandesViajes">Grandes Viajes (Destinos exóticos)</option>
                    <option value="combinado">Combinado (Vuelo + Hotel)</option>
                    <option value="escapadas">Escapadas</option>
                    <option value="familiasmenores">Familias con niños menores</option>
                </select>
            </div>
            <br>
            <div>
                <label for="fechaInicio">Fecha de inicio</label>
                <input type="date" id="fechaInicio" name="fechaInicio" required>
            </div>
            <br>
            <div>
                <label for="fechaFin">Fecha de vuelta</label>
                <input type="date" id="fechaFin" name="fechaFin" required>
            </div>
            <br>
            <div>
                <label for="dias">Días</label>
                <input type="number" id="dias" name="dias" readonly onmousedown="return false;">
            </div>
            <br>
            <div>
                <label for="pais">País</label>
                <select name="pais" id="paises" required>
                    <option value="" disabled selected>----Seleccione----</option>
                    <?php while ($fila = $resultado_paises->fetch_assoc()) { ?>
                        <option value="<?php echo htmlspecialchars($fila['nombre']); ?>">
                            <?php echo htmlspecialchars($fila['nombre']); ?>
                        </option>
                    <?php } ?>
                </select>
            </div>
            <br>
            <div>
                <label for="descripcion">Descripción</label>
                <textarea rows="5" cols="30" id="descripcion" name="descripcion" required></textarea>
            </div>
            <br>
            <div>
                <label for="otrosServicios">Otros Servicios</label>
                <textarea rows="5" cols="30" id="otrosServicios" name="otrosServicios" required></textarea>
            </div>
            <br>
            <button class="formulario" type="submit">Enviar datos</button>
        </form>
    </div>

<br><br><br>

    <footer class="footer">
        <div class="footer-content">
            <img src="media/copyright.png" alt="Copyright">
            <p>&copy; 2025 Viajes Elorrieta. Todos los derechos reservados.</p>
        </div>
    </footer>

    <script type="text/javascript" src="funciones.js"></script>
    <script>
        function validarFormulario() {
            let fechaInicio = new Date(document.getElementById("fechaInicio").value);
            let fechaFin = new Date(document.getElementById("fechaFin").value);
            if (fechaInicio >= fechaFin) {
                alert("La fecha de fin debe ser posterior a la fecha de inicio.");
                return false;
            }
            return true;
        }

        document.getElementById("fechaInicio").addEventListener("change", calcularDias);
        document.getElementById("fechaFin").addEventListener("change", calcularDias);

        function calcularDias() {
            let fechaInicio = document.getElementById("fechaInicio").value;
            let fechaFin = document.getElementById("fechaFin").value;
            let diasInput = document.getElementById("dias");

            if (fechaInicio && fechaFin) {
                let inicio = new Date(fechaInicio);
                let fin = new Date(fechaFin);
                let diferenciaTiempo = fin - inicio;
                let diferenciaDias = diferenciaTiempo / (1000 * 60 * 60 * 24);

                if (diferenciaDias >= 0) {
                    diasInput.value = diferenciaDias;
                } else {
                    diasInput.value = "";
                    alert("La fecha de vuelta debe ser posterior a la fecha de inicio.");
                }
            }
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
<?php
session_start();
if (!isset($_SESSION['id_agencia'])) {
    header("Location: index.php");
    exit();
}
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
    <title>Elección</title>
    <link rel="stylesheet" href="estilos/estilos2.css">
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
            <button class="cerrar-sesion" onclick="logout()">Cerrar Sesión</button>
        </div>
    </header>

    <div class="content">
        <h2 class="bienvenido">Bienvenido <span style="color: <?php echo htmlspecialchars($colorMarca); ?>;"><?php echo htmlspecialchars($nombreAgencia); ?></span>, ¿qué servicio desea seleccionar?</h2>
        <div class="buttons">
            <button onclick="registrarViaje()">Registrar Viaje</button>
            <button onclick="registrarServicio()">Registrar Servicio</button>
        </div>
    </div>

    <footer class="footer">
        <div class="footer-content">
            <img src="media/copyright.png" alt="Copyright">
            <p>&copy; 2025 Viajes Elorrieta. Todos los derechos reservados.</p>
        </div>
    </footer>

    <script>
        function logout() {
            window.location.href = 'logout.php';
        }

        function registrarViaje() {
            window.location.href = 'RegistrarViaje.php';
        }

        function registrarServicio() {
            window.location.href = 'RegistrarServicio.php';
        }
    </script>
</body>
</html>
<?php
session_start();
if (isset($_COOKIE['session_expired'])) {
    setcookie('session_expired', '', time() - 3600, '/'); 
    header("Cache-Control: no-cache, must-revalidate"); 
    header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); 
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Viajes Elorrieta</title>
    <meta name="description" content="Inicia sesión en Viajes Elorrieta para gestionar tus viajes y servicios.">
    <meta name="keywords" content="Viajes Elorrieta, iniciar sesión, gestión de viajes, servicios de viajes">
    <meta name="author" content="Viajes Elorrieta">
    <link rel="stylesheet" href="estilos/estilos.css">
</head>
<body>

    <header class="header">
        <nav class="menu">
            <ul>
                <li><a href="quienesSomos.php">Quiénes somos</a></li>
            </ul>
        </nav>
        <div class="header-center">
            <h1 style="color: #d3a14f;">Elorrieta</h1>
        </div>
    </header>


    <div class="login">
        <div class="login-content">
            <h1>Iniciar Sesión</h1>

            <?php if (isset($_GET['error'])): ?>
                <p style="color: red;">Usuario o contraseña incorrectos</p>
            <?php endif; ?>

            <form action="register.php" method="post">
                <input type="text" name="usuario" placeholder="Usuario" required>
                <input type="password" name="contrasena" placeholder="Contraseña" required>
                <button type="submit" name="boton">Ingresar</button>
            </form>
            <br>
            <form action="formulario_registro_agencia.php" method="get">
                <button type="submit">Registrar</button>
            </form>
        </div>
    </div>
    
                <br><br><br><br><br><br><br><br>
      
    <footer class="footer">
        <div class="footer-content">
            <img src="media/copyright.png" alt="Copyright">
            <p>&copy; 2025 Viajes Elorrieta. Todos los derechos reservados.</p>
        </div>
    </footer>

</body>
</html>
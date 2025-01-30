<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <header class="header">
        <nav class="menu">
            <ul>
                <li><a href="#">Quiénes somos</a></li>
                <li><a href="#">Más información</a></li>
            </ul>
        </nav>
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
        </div>
    </div>
</body>
</html>
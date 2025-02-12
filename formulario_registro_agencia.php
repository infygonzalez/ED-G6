<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Agencia</title>
    <link rel="stylesheet" href="estilos/estilosagencia.css">
</head>
<body>

<header class="header">
        <nav class="menu">
            <ul>
                <li><a href="index.php">Inicio</a></li>
            </ul>
        </nav>
        <div class="header-center">
            <h1 style="color: #d3a14f;">Elorrieta</h1>
        </div>
    </header>

    <div class="registro">
        <div class="registro-content">
            <h1>Registrar Agencia</h1>
            <form action="registrar_agencia.php" method="post">
                <input type="text" name="nombre" placeholder="Nombre de la Agencia" required>
                <input type="text" name="logo" placeholder="URL del Logo" required>
                <label for="color_marca" style="color: black;">Color de Marca</label>
                <input type="color" id="color_marca" name="color_marca" value="#000000" required>
                <label for="numero_empleados">Número de Empleados</label>
                <select id="numero_empleados" name="numero_empleados" required>
                    <option value="" disabled selected>Seleccione una opción</option>
                    <option value="Entre 2 y 10 empleados">Entre 2 y 10 empleados</option>
                    <option value="Entre 10 y 100 empleados">Entre 10 y 100 empleados</option>
                    <option value="Entre 100 y 1000 empleados">Entre 100 y 1000 empleados</option>
                </select>
                <label for="tipo_agencia">Tipo de Agencia</label>
                <select id="tipo_agencia" name="tipo_agencia" required>
                    <option value="" disabled selected>Seleccione una opción</option>
                    <option value="Minorista">Minorista</option>
                    <option value="Mayorista">Mayorista</option>
                    <option value="Minorista-Mayorista">Minorista-Mayorista</option>
                </select>
                <label for="contrasena">Contraseña</label>
                <input type="password" name="contrasena" placeholder="Contraseña" required>
                <button type="submit">Registrar</button>
            </form>
        </div>
    </div>

    <footer class="footer">
        <div class="footer-content">
            <img src="media/copyright.png" alt="Copyright">
            <p>&copy; 2025 Viajes Elorrieta. Todos los derechos reservados.</p>
        </div>
    </footer>

</body>
</html>
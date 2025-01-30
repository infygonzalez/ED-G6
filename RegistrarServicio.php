<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registrarServicio</title>
    <link rel="stylesheet" href="estilosServicios.css">
</head>

<body>
    <header class="boton">
        <button onclick="atras()">Atrás</button>
        <button onclick="logout()">LogOut</button>
    </header>

    <div class="formulario" >
        <form name="mensaje_dfb" action="#" method="post" class="mensaje_dfb">
            <div class="select">
                <label for="nombre">Elige viaje</label>
                <select name="eligeViaje" id="eligeViaje">
                    <option value="" disabled selected>----Seleccione----</option>
                    <option value="novios">Novios</option>
                    <option value="senior">Senior</option>
                    <option value="grupos">Grupos</option>
                    <option value="GrandesViajes">Grandes Viajes (Destinos exóticos)</option>
                    <option value="combinado">Combinado (Vuelo + Hotel)</option>
                    <option value="escapadas">Escapadas</option>
                    <option value="familiasmenores">Familias con niños menores</option>
                </select> 
            </div>¿Qué tipo de servicio desea?
            <div class="tipoServicio">
                <label>
                    <input type="radio" name="vuelo" value="vuelo">Vuelo
                  </label>
                  <label>
                    <input type="radio" name="alojamiento" value="alojamiento">Alojamiento
                  </label>
                  <label>
                    <input type="radio" name="otros" value="otros">Otros
                  </label>
            </div>
        </form>

    </div>
    <script type="text/javascript" src="funciones.js"></script>
</body>

</html>
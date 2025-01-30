<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RegistrarViaje</title>
    <link rel="stylesheet" href="estilosViaje.css">
</head>

<body>
    <header class="boton">
        <button onclick="atras()">Atrás</button>
        <button onclick="logout()">LogOut</button>
    </header>


    <br>
    <br>
    <br>

    <div class="formulario">
        <form name="mensaje_dfb" action="#" method="post" class="mensaje_dfb">
            <div>
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Escriba aquí su nombre" required>
            </div>
            <br>
            <div>
                <label for="tipoViaje">Tipo de viaje</label>
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
            </div>
            <br>
            <div>
                <label for="fechaInicio">Fecha de inicio</label>
                <input type="date" id="fechaInicio" name="fechaInicio">
            </div>
            <br>
            <div>
                <label for="fechaFin">Fecha de vuelta</label>
                <input type="date" id="fechaFin" name="fechaFin">
            </div>
            <br>
            <div>
                <label for="dias">Dias</label>
                <input type="number" id="dias" name="dias" readonly onmousedown="return false;">
            </div>
            <br>
            <div>
                <label for="pais">Pais.</label>
                <select name="paises" id="paises">
                    <option value="" disabled selected>----Seleccione----</option>
                    <option value="">Alemania</option>
                    <option value="">Argentina</option>
                    <option value="">Austria</option>
                    <option value="">Belgica</option>
                    <option value="">Brazil</option>
                    <option value="">Canada</option>
                    <option value="">Croacia</option>
                    <option value="">Republica Checa</option>
                    <option value="">Cuba</option>
                    <option value="">China</option>
                    <option value="">Chipre</option>
                    <option value="">Dinamarca</option>
                    <option value="">Egipto</option>
                    <option value="">España</option>
                    <option value="">Estados Unidos</option>
                    <option value="">Estonia</option>
                    <option value="">Finlandia</option>
                    <option value="">Francia</option>
                    <option value="">Grecia</option>
                    <option value="">Guatemala</option>
                    <option value="">Hong-Kong</option>
                    <option value="">Hungria</option>
                    <option value="">India</option>
                    <option value="">Indonesia</option>
                    <option value="">Irlanda</option>
                    <option value="">Islandia</option>
                    <option value="">Israel</option>
                    <option value="">Italia</option>
                    <option value="">Jamaica</option>
                    <option value="">Japon</option>
                    <option value="">Kenia</option>
                    <option value="">Luxemburgo</option>
                    <option value="">Maldivas</option>
                    <option value="">Malta</option>
                    <option value="">Marruecos</option>
                    <option value="">Mexico</option>
                    <option value="">Monaco</option>
                    <option value="">Noruega</option>
                    <option value="">Paises bajos</option>
                    <option value="">Panama</option>
                    <option value="">Peru</option>
                    <option value="">Polonia</option>
                    <option value="">Portugal</option>
                    <option value="">Puerto Rico</option>
                    <option value="">Qatar</option>
                    <option value="">Reino Unido</option>
                    <option value="">Rumania</option>
                    <option value="">Rusia</option>
                    <option value="">Seychelles</option>
                    <option value="">Singapur</option>
                    <option value="">Sudafrica</option>
                    <option value="">Suecia</option>
                    <option value="">Suiza</option>
                    <option value="">Tailandia</option>
                    <option value="">Tanzania</option>
                    <option value="">Tunez</option>
                    <option value="">Turquia</option>
                    <option value="">Venezuela</option>
                    <option value="">Vietnam</option>
                </select>
            </div>
            <br>
            <div>
                <label for="descripcion">Descripcion</label>
                <textarea rows="5" cols="30" id="descripcion" name="descripcion"></textarea>
            </div>
            <br>
            <div>
                <label for="otrosServicios">Otros Servicios</label>
                <textarea rows="5" cols="30" id="otrosServicios" name="otrosServicios"></textarea>
            </div>
            <br>
            <button class="formulario" type="submit">Enviar datos</button>
            <script>window.alert("Datos enviados correctamente")</script>
    </div>


    </form>

    <script type="text/javascript" src="funciones.js"></script>
</body>

</html>
function login() {
    const usuario = document.getElementById("usuario").value;
    const contrasena = document.getElementById("contrasena").value;

    // Aquí puedes agregar la lógica para validar el usuario y la contraseña
    if (usuario === "admin" && contrasena === "1234") {
        window.location.href = "eleccion.php";
    } else {
        document.getElementById("error-message").style.display = "block";
    }
}

document.addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
        login();
    }
});
function index(){
    window.location.href = "index.php"
}
function logout() {
    window.location.replace("index.php");
}

function registrarViaje() {
    window.location.href = "RegistrarViaje.php";
}

function registrarServicio() {
    window.location.href = "RegistrarServicio.php";
}

function atras() {
    window.location.href = "eleccion.php";
}

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

document.getElementById("fechaInicio").addEventListener("change", calcularDias);
document.getElementById("fechaFin").addEventListener("change", calcularDias);
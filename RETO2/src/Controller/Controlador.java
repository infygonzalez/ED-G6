package Controller;
import Model.gestorAgencias;
import Model.Agencia;
public class Controlador {

	public void comprobarAgencia(Agencia Agencia) {
		gestorAgencias gestorAgencias = new gestorAgencias();
		gestorAgencias.comprobarAgencia(Agencia);
	}
	public void crearAgencia() {
		gestorAgencias gestorAgencias = new gestorAgencias();
		gestorAgencias.crearAgencia();
	}
	
}

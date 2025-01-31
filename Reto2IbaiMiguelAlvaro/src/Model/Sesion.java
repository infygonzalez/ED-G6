package Model;

public class Sesion {

	public static int idAgencia;

	public static int getIdAgencia() {
		return idAgencia;
	}

	public static void setIdAgencia(int idAgencia) {
		Sesion.idAgencia = idAgencia;
	}

	@Override
	public String toString() {
		return "Sesion [idAgencia=" + idAgencia + "]";
	}

}

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
		return "" + idAgencia;
	}

	public static String getLogo() {
		String logoUrl = Sesion.getLogo(); 
		return null;
	}

}

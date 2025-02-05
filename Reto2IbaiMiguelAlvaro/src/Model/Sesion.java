package Model;

public class Sesion {

    private static int idAgencia;
    private static String logoUrl; // Nueva variable para almacenar la URL del logo

    public static int getIdAgencia() {
        return idAgencia;
    }

    public static void setIdAgencia(int idAgencia) {
        Sesion.idAgencia = idAgencia;
    }

    public static String getLogo() {
        return logoUrl;
    }

    public static void setLogo(String logoUrl) {
        Sesion.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "ID Agencia: " + idAgencia + ", Logo URL: " + logoUrl;
    }
}

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ESTE DBUTILS SOLO SIRVE PARA EL ORDENADOR DE CLASE DE MORCI, CAMBIALO PARA QUE FUNCIONE
 */
public class DBUtils {

	public static final String URL="jdbc:mysql://localhost:3306/bdalumnos";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWORD = "usuario";
	
	//Creamos la conexion
	public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

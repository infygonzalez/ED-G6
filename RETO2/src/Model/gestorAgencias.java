package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Agencia;
import Model.DBUtils.*;


public class gestorAgencias {
	Connection conexion = null;
	Statement sentencia = null;
	
	public void comprobarAgencia(Agencia agencia) {
		//Dan errores porque hay que meterlo entre try catch//
		Class.forName(DBUtils.DRIVER);
		conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
		sentencia = conexion.createStatement();
	}
}

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Agencia.*;
import Model.DBUtils.*;


public class gestorAgencias {
	
	public void comprobarAgencia(Agencia agencia) {
		Connection conexion = null;
		Statement sentencia = null;
		//Dan errores porque hay que meterlo entre try catch//
		Class.forName(DBUtils.DRIVER);
		conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
		sentencia = conexion.createStatement();
	}
	
	public boolean buscarAgencia(){ //coger el nombre de la agencia introducido en el label de usuario y verificar si está en la base de datos
		
		Connection conexion = null;
		Statement sentencia = null;
		boolean agenciaencontrada = false;
		Class.forName(DBUtils.DRIVER);
		conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
		String sql = SQLQueries.SELECT_NOMBRE_AGENCIAS;
		sentencia = conexion.prepareStatement(sql);
		resultSet=sentencia.executeQuery(sql);
		
		
		
	}
	
	public void crearAgencia(Agencia agencia) {
		Connection conexion = null;
		Statement sentencia = null;
		
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQueries.INSERT_AGENCIAS + agencia.getID() + SQLQueries.SEPARATOR + agencia.getNombre() + SQLQueries.SEPARATOR + agencia.getLogo()
						+ SQLQueries.SEPARATOR + agencia.getColor() + SQLQueries.SEPARATOR + agencia.getNumeroEmpleados() + SQLQueries.SEPARATOR + agencia.getTipoAgencia()
						+ SQLQueries.END_BLOCK;
			sentencia.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

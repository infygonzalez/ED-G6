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
	
	public boolean comprobarAgencia(Agencia agencia) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String nombre = SQLQueries.SELECT_NOMBRE_AGENCIAS; //damos nombre al select que vamos a hacer
		String contr= SQLQueries.SELECT_CONTRA_AGENCIAS;//otra vez lo mismo
		
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DBUtils.getConexion();//Iniciamos la conexion
			stmt = conexion.prepareStatement(nombre);//preparamos la sentencia con la query del nombre
			stmt.setString(1, agencia.getNombre());//le pasamos el nombre de la agencia
			rs = stmt.executeQuery();//ejecuta el resultado
			if (!rs.next()) {
			    return false; // Nombre no encontrado; si lo encuentra, va a verificar la contraseña directamente
			}

			// Verificar si la contraseña coincide
			stmt = conexion.prepareStatement(contr);
			stmt.setString(1, agencia.getNombre());
			stmt.setString(2, agencia.getContra());
			rs = stmt.executeQuery();
			return rs.next(); // devuelve true si coincide la contraseña
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
				
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

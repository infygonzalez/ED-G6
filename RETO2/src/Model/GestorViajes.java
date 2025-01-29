package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.*;

public class GestorViajes {
	
	Viajes viajes = new Viajes();
	
	
	public static void crearViaje(Viajes viajes) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String crearViaje = SQLQueries.INSERT_VIAJE;
		
		try {
			stmt = conexion.prepareStatement(crearViaje);
			
			// Establecer los parámetros
			stmt.setString(1, viajes.getNombre());
			stmt.setString(2, viajes.getDescripcion());
			stmt.setString(3, viajes.getFecFin());
			stmt.setString(4, viajes.getFecFin());
			stmt.setString(5, viajes.getDescripcion());
			stmt.setString(6, viajes.getTipo_viaje());
			stmt.setString(7, viajes.getPais().toString());
			stmt.setString(8, viajes.getAgencia().toString());
			stmt.setString(9, viajes.getServicios());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        // Cierre de recursos
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conexion != null) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar los recursos");
	            e.printStackTrace();
	        }
	    }

	}
	
}




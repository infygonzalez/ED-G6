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
        String crearViaje = SQLQueries.INSERT_VIAJE;

        try {
            conexion = DBUtils.getConexion();  // Se inicializa la conexión
            stmt = conexion.prepareStatement(crearViaje);

            // Establecer los parámetros
            stmt.setString(1, viajes.getNombre());
            stmt.setString(2, viajes.getDescripcion());
            stmt.setString(3, viajes.getTipo_viaje());
            stmt.setString(4, viajes.getFecInicio()); // Corregido
            stmt.setString(5, viajes.getFecFin());
            stmt.setString(6, viajes.getDuracion());
            stmt.setString(7, viajes.getPais().getNombre()); // Asegurar que sea un String
            stmt.setString(8, viajes.getServicios());
            stmt.setInt(9, viajes.getAgencia().getID());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Viaje creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el viaje.");
            }

        } catch (SQLException e) {
            System.out.println("Error SQL al insertar el viaje.");
            e.printStackTrace();
        } finally {
            // Cierre de recursos
            try {
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos.");
                e.printStackTrace();
            }
	    }

	}


	public static Viajes obtenerViajePorNombre(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}




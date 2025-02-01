package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.*;

public class GestorViajes {
	
	Viajes viajes = new Viajes();
	
	
	public static void crearViaje(Viajes viajes) { //METODO SIN TERMINAR, LA BASE DE DATOS HAY QUE EDITARLA CREO
		Connection conexion = null;
        PreparedStatement stmt = null;
        String crearViaje = SQLQueries.INSERT_VIAJE;

        try {
            conexion = DBUtils.getConexion();  // Se inicializa la conexión
            stmt = conexion.prepareStatement(crearViaje);

            // Establecer los parámetros
            stmt.setString(1, viajes.getNombre());
            stmt.setString(2, viajes.getDescripcion());
            stmt.setString(3, viajes.getFecInicio()); // Corregido
            stmt.setString(4, viajes.getFecFin());
            stmt.setString(5, viajes.getDescripcion()); // ¿Duplicado? Verificar si debería ser otro campo
            stmt.setString(6, viajes.getTipo_viaje());
            stmt.setString(7, viajes.getPais().getNombre()); // Asegurar que sea un String
            stmt.setString(8, viajes.getAgencia().getNombre()); // Asegurar que sea un String
            stmt.setString(9, viajes.getServicios());

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
	
	public void mostrarViajes() {
		
	}
	
}




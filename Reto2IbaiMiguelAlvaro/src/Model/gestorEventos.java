package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class gestorEventos {
	
	public void añadirEvento(String tipoEvento) {
		Connection conexion = null;
        PreparedStatement stmt = null;
        String crearEvento = SQLQueries.INSERT_EVENTO;
        
        conexion = DBUtils.getConexion();  // Se inicializa la conexión
        stmt = conexion.prepareStatement(crearEvento);
        
		if(tipoEvento == "Vuelo") {
			
		}
		if(tipoEvento == "Alojamiento") {
			
		}
		if(tipoEvento == "Actividad") {
			
		}
	}

}

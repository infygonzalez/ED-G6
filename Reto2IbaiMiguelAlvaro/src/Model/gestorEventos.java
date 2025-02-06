package Model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class gestorEventos {
    
	public void añadirVueloIda(int idViaje, String nombreEvento, String tipo, String trayecto, String aeropuertoOrigen, String aeropuertoDestino, String fechaIda, String codigoVueloString, String aerolinea, String horarioSalida, String duracion, String precio) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();

	        // Insertar en la tabla eventos
	        String sqlEvento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES (?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlEvento, PreparedStatement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, "vuelo");
	        stmt.setInt(2, idViaje); // Usamos el idViaje proporcionado
	        stmt.setString(3, nombreEvento);
	        stmt.setString(4, fechaIda);
	        stmt.setInt(5, Integer.parseInt(precio));
	        stmt.executeUpdate();

	        // Obtener el id_evento generado
	        rs = stmt.getGeneratedKeys();
	        int idEvento = 0;
	        if (rs.next()) {
	            idEvento = rs.getInt(1);
	        }

	        // Insertar en la tabla vuelos
	        String sqlVuelo = "INSERT INTO vuelos (id_evento, aeropuerto_origen, aeropuerto_destino, codigo_vuelo, aerolinea, precio_euros, fecha_salida, hora_salida, duracion_viaje, tipo_vuelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlVuelo);
	        stmt.setInt(1, idEvento);
	        stmt.setString(2, aeropuertoOrigen);
	        stmt.setString(3, aeropuertoDestino);
	        stmt.setString(4, codigoVueloString);
	        stmt.setString(5, aerolinea);
	        stmt.setBigDecimal(6, new BigDecimal(precio));
	        stmt.setDate(7, Date.valueOf(fechaIda));
	        stmt.setTime(8, Time.valueOf(horarioSalida));
	        stmt.setInt(9, Integer.parseInt(duracion));
	        stmt.setString(10, "ida");
	        stmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
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

	public void añadirVueloVuelta(int idEvento, String fechaVuelta, String codigoVuelta, String aerolineaVuelta, String horarioVuelta, String duracionVuelta) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();

	        // Actualizar el vuelo para agregar la información de vuelta
	        String sql = "UPDATE vuelos SET fecha_vuelta = ?, hora_vuelta = ?, duracion_viaje_vuelta = ?, codigo_vuelo_vuelta = ?, aerolinea_vuelta = ?, tipo_vuelo = 'ida_y_vuelta' WHERE id_evento = ?";
	        stmt = conexion.prepareStatement(sql);
	        stmt.setDate(1, Date.valueOf(fechaVuelta));
	        stmt.setTime(2, Time.valueOf(horarioVuelta));
	        stmt.setInt(3, Integer.parseInt(duracionVuelta));
	        stmt.setString(4, codigoVuelta);
	        stmt.setString(5, aerolineaVuelta);
	        stmt.setInt(6, idEvento); // Aquí deberías obtener el id_evento correspondiente
	        stmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally {
            // Cerrar recursos
            try {
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}

	public void añadirActividad(int idViaje, String nombreEvento, String tipo, String descripcion, String precio, String fechaActividad) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();

	        // Insertar en la tabla eventos
	        String sqlEvento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES (?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlEvento, PreparedStatement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, "otros");
	        stmt.setInt(2, idViaje); // Usamos el idViaje proporcionado
	        stmt.setString(3, nombreEvento);
	        stmt.setString(4, fechaActividad);
	        stmt.setInt(5, Integer.parseInt(precio));
	        stmt.executeUpdate();

	        // Obtener el id_evento generado
	        rs = stmt.getGeneratedKeys();
	        int idEvento = 0;
	        if (rs.next()) {
	            idEvento = rs.getInt(1);
	        }

	        // Insertar en la tabla otroseventos
	        String sqlActividad = "INSERT INTO otroseventos (id_evento, nombre, fecha, descripcion, precio_euros) VALUES (?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlActividad);
	        stmt.setInt(1, idEvento);
	        stmt.setString(2, nombreEvento);
	        stmt.setDate(3, Date.valueOf(fechaActividad));
	        stmt.setString(4, descripcion);
	        stmt.setBigDecimal(5, new BigDecimal(precio));
	        stmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
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

	public void añadirAlojamiento(int idViaje, String nombreEvento, String tipo, String tipoAlojamiento, String ciudad, String precio, String fechaEntrada, String fechaSalida) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();

	        // Insertar en la tabla eventos
	        String sqlEvento = "INSERT INTO eventos (tipo_evento, id_viaje, nombre, fecha, precio) VALUES (?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlEvento, PreparedStatement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, "alojamiento");
	        stmt.setInt(2, idViaje); // Aquí deberías obtener el id_viaje correspondiente
	        stmt.setString(3, nombreEvento);
	        stmt.setString(4, fechaEntrada);
	        stmt.setInt(5, Integer.parseInt(precio));
	        stmt.executeUpdate();

	        int idEvento = obtenerIdEvento(idViaje);

	        // Insertar en la tabla alojamientos
	        String sqlAlojamiento = "INSERT INTO alojamientos (id_evento, nombre_hotel, ciudad, precio_euros, fecha_entrada, fecha_salida, tipo_habitacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        stmt = conexion.prepareStatement(sqlAlojamiento);
	        stmt.setInt(1, idEvento);
	        stmt.setString(2, nombreEvento);
	        stmt.setString(3, ciudad);
	        stmt.setBigDecimal(4, new BigDecimal(precio));
	        stmt.setDate(5, Date.valueOf(fechaEntrada));
	        stmt.setDate(6, Date.valueOf(fechaSalida));
	        stmt.setString(7, tipoAlojamiento);
	        stmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
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
    public int obtenerIdEvento(int idViaje) {
        String sql = "SELECT id_evento FROM eventos WHERE id_viaje = ?";
        try (Connection conexion = DBUtils.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idViaje);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_evento");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // devuelve -1 si no se encuentra un evento asociado al viaje
    }
}

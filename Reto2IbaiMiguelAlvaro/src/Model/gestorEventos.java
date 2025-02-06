package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class gestorEventos {
    
    public void anadirVueloIda(int idViaje,String nombre, String tipo, String trayecto, String aeropuertoOrigen,
                               String aeropuertoDestino, String fechaIda, String codigoVueloString, 
                               String aerolinea, String horarioSalida, String duracion, String precio) {
        String sql = "INSERT INTO vuelos (id_viaje, aeropuerto_origen, aeropuerto_destino, codigo_vuelo, aerolinea, precio_euros, fecha_salida, hora_salida, duracion_viaje, tipo_vuelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = DBUtils.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idViaje);
            stmt.setString(2, aeropuertoOrigen);
            stmt.setString(3, aeropuertoDestino);
            stmt.setString(4, codigoVueloString);
            stmt.setString(5, aerolinea);
            stmt.setBigDecimal(6, new java.math.BigDecimal(precio));
            stmt.setDate(7, java.sql.Date.valueOf(fechaIda));
            stmt.setTime(8, java.sql.Time.valueOf(horarioSalida));
            stmt.setInt(9, Integer.parseInt(duracion));
            stmt.setString(10, tipo);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirVueloVuelta(int idViaje, String fechaVuelta, String codigoVuelta, String aerolineaVuelta, String horarioVuelta, String duracionVuelta) {
        String sql = "UPDATE vuelos SET fecha_vuelta = ?, hora_vuelta = ?, duracion_viaje_vuelta = ?, codigo_vuelo_vuelta = ?, aerolinea_vuelta = ? WHERE id_viaje = ? AND tipo_vuelo = 'ida'";
        
        try (Connection conexion = DBUtils.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(fechaVuelta));
            stmt.setTime(2, java.sql.Time.valueOf(horarioVuelta));
            stmt.setInt(3, Integer.parseInt(duracionVuelta));
            stmt.setString(4, codigoVuelta);
            stmt.setString(5, aerolineaVuelta);
            stmt.setInt(6, idViaje);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirActividad(int idViaje,String nombre, String tipo, String descripcion, String precio, String fechaActividad) {
        String sql = "INSERT INTO otroseventos (id_viaje, nombre, fecha, descripcion, precio_euros) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conexion = DBUtils.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idViaje);
            stmt.setString(2, tipo);
            stmt.setDate(3, java.sql.Date.valueOf(fechaActividad));
            stmt.setString(4, descripcion);
            stmt.setBigDecimal(5, new java.math.BigDecimal(precio));
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirAlojamiento(int idViaje,String nombre, String tipo, String tipoAlojamiento, String ciudad, String precio, String fechaEntrada, String fechaSalida) {
        String sql = "INSERT INTO alojamientos (id_viaje, nombre_hotel, ciudad, precio_euros, fecha_entrada, fecha_salida, tipo_habitacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = DBUtils.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idViaje);
            stmt.setString(2, tipo);
            stmt.setString(3, ciudad);
            stmt.setBigDecimal(4, new java.math.BigDecimal(precio));
            stmt.setDate(5, java.sql.Date.valueOf(fechaEntrada));
            stmt.setDate(6, java.sql.Date.valueOf(fechaSalida));
            stmt.setString(7, tipoAlojamiento);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

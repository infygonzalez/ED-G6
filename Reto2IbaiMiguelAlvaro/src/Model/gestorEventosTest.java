package Model;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

public class gestorEventosTest {
    
    private gestorEventos gestor;
    private Connection conexion;
    
    
    @Before
    public void setUp() throws Exception {
        gestor = new gestorEventos();
        conexion = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        crearTablas(); 
    }
    
    private void crearTablas() throws SQLException {
        conexion.createStatement().execute("CREATE TABLE eventos (id_evento INT AUTO_INCREMENT PRIMARY KEY, tipo_evento VARCHAR(255), id_viaje INT, nombre VARCHAR(255), fecha DATE, precio INT)");
        conexion.createStatement().execute("CREATE TABLE vuelos (id_evento INT, aeropuerto_origen VARCHAR(255), aeropuerto_destino VARCHAR(255), codigo_vuelo VARCHAR(255), aerolinea VARCHAR(255), precio_euros DECIMAL, fecha_salida DATE, hora_salida TIME, duracion_viaje INT, tipo_vuelo VARCHAR(255))");
    }
    
    @Test
    public void testAñadirVueloIda() throws Exception {
        gestor.añadirVueloIda(1, "Evento Prueba", "vuelo", "trayecto1", "JFK", "LAX", "2025-06-10", "AA100", "American Airlines", "12:00:00", "180", "300");
        assertTrue(verificarEventoExistente(1));
    }
    
    @Test
    public void testAñadirVueloVuelta() throws Exception {
        gestor.añadirVueloVuelta(1, "2025-06-20", "AA101", "American Airlines", "14:00:00", "180");
        assertTrue(verificarEventoExistente(1));
    }
    
    @Test
    public void testAñadirActividad() throws Exception {
        gestor.añadirActividad(1, "Tour por la ciudad", "turismo", "Un recorrido por la ciudad", "50", "2025-06-15");
        assertTrue(verificarEventoExistente(1));
    }
    
    @Test
    public void testAñadirAlojamiento() throws Exception {
        gestor.añadirAlojamiento(1, "Hotel Plaza", "alojamiento", "Suite", "Madrid", "200", "2025-06-10", "2025-06-20");
        assertTrue(verificarEventoExistente(1));
    }
    
    @Test
    public void testObtenerIdEvento() throws Exception {
        int idEvento = gestor.obtenerIdEvento(1);
        assertNotEquals(-1, idEvento);
    }
    
    private boolean verificarEventoExistente(int idViaje) throws SQLException {
        var stmt = conexion.createStatement();
        var rs = stmt.executeQuery("SELECT COUNT(*) FROM eventos WHERE id_viaje = " + idViaje);
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }
}

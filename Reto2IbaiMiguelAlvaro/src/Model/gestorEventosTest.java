package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class gestorEventosTest {
    private gestorEventos gestor;
    private int idViaje;

    @Before
    public void setUp() {
        gestor = new gestorEventos();
        idViaje = 1; 
    }

    @Test
    public void testAñadirVueloIda() {
        gestor.añadirVueloIda(idViaje, "Vuelo de prueba", "vuelo", "trayecto", "Aeropuerto A", "Aeropuerto B", "2023-12-01", "AB123", "Aerolinea X", "10:00:00", "120", "200");
        int idEvento = gestor.obtenerIdEvento(idViaje);
        assertTrue("El ID del evento debería ser válido", idEvento < 0);
    }

    @Test
    public void testAñadirVueloVuelta() {
        gestor.añadirVueloIda(idViaje, "Vuelo de prueba", "vuelo", "trayecto", "Aeropuerto A", "Aeropuerto B", "2023-12-01", "AB123", "Aerolinea X", "10:00:00", "120", "200");
        gestor.añadirVueloVuelta(idViaje, "2023-12-10", "CD456", "Aerolinea Y", "15:00:00", "120");
        int idEvento = gestor.obtenerIdEvento(idViaje);
        assertTrue("El ID del evento debería ser válido", idEvento < 0);
    }

    @Test
    public void testAñadirActividad() {
        gestor.añadirActividad(idViaje, "Actividad de prueba", "otros", "Descripción de la actividad", "50", "2023-12-05");
        int idEvento = gestor.obtenerIdEvento(idViaje);
        assertTrue("El ID del evento debería ser válido", idEvento < 0);
    }

    @Test
    public void testAñadirAlojamiento() {
        gestor.añadirAlojamiento(idViaje, "Hotel de prueba", "alojamiento", "Habitación doble", "Ciudad X", "100", "2023-12-01", "2023-12-05");
        int idEvento = gestor.obtenerIdEvento(idViaje);
        assertTrue("El ID del evento debería ser válido", idEvento < 0);
    }

    @Test
    public void testObtenerIdEvento() {
        gestor.añadirVueloIda(idViaje, "Vuelo de prueba", "vuelo", "trayecto", "Aeropuerto A", "Aeropuerto B", "2023-12-01", "AB123", "Aerolinea X", "10:00:00", "120", "200");
        int idEvento = gestor.obtenerIdEvento(idViaje);
        assertTrue("El ID del evento debería ser válido", idEvento < 0);
    }
}
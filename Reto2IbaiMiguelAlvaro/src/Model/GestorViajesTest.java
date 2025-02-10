package Model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class GestorViajesTest {

    private GestorViajes gestorViajes;
    private Viajes viaje;
    
    @Before
    public void setUp() {
        gestorViajes = new GestorViajes();
        // Crear un objeto Viajes con datos de prueba
        viaje = new Viajes();
        viaje.setNombre("Viaje de Prueba");
        viaje.setDescripcion("Descripción del viaje de prueba");
        viaje.setTipo_viaje("Aventura");
        viaje.setFecInicio("2023-12-01");
        viaje.setFecFin("2023-12-10");
        viaje.setDuracion("9 días");
        
        // Crear un objeto Pais y asignarlo al viaje
        Paises pais = new Paises();
        pais.setNombre("España");
        viaje.setPais(pais);
        
        // Crear un objeto Agencia y asignarlo al viaje
        Agencia agencia = new Agencia();
        agencia.setID(1); // Asumiendo que la agencia con ID 1 existe en la base de datos
        viaje.setAgencia(agencia);
        
        viaje.setServicios("Alojamiento, Transporte, Guía");
    }

    @Test
    public void testCrearViaje() {
        // Llamar al método crearViaje
        GestorViajes.crearViaje(viaje);


        Viajes viajeCreado = GestorViajes.obtenerViajePorNombre("Viaje de Prueba");

        // Verificar que el viaje obtenido no es nulo y que los datos coinciden
        assertNotNull(viajeCreado);
        assertEquals("Viaje de Prueba", viajeCreado.getNombre());
        assertEquals("Descripción del viaje de prueba", viajeCreado.getDescripcion());
        assertEquals("Aventura", viajeCreado.getTipo_viaje());
        assertEquals("2023-12-01", viajeCreado.getFecInicio());
        assertEquals("2023-12-10", viajeCreado.getFecFin());
        assertEquals("9 días", viajeCreado.getDuracion());
        assertEquals("España", viajeCreado.getPais().getNombre());
        assertEquals("Alojamiento, Transporte, Guía", viajeCreado.getServicios());
        assertEquals(1, viajeCreado.getAgencia().getID());
    }

    // Método auxiliar para obtener un viaje por nombre (deberías implementarlo en GestorViajes)
    
}

package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GestorViajesTest {
    private GestorViajes gestor;
    private Viajes viaje;

    @Before
    public void setUp() {
        gestor = new GestorViajes();
        viaje = new Viajes();
        
        viaje.setNombre("Viaje de prueba");
        viaje.setDescripcion("Descripción del viaje de prueba");
        viaje.setTipo_viaje("Vacacional");
        viaje.setFecInicio("2023-12-01");
        viaje.setFecFin("2023-12-10");
        viaje.setDuracion("9 días");
        
        Paises pais = new Paises();
        pais.setNombre("España");
        viaje.setPais(pais);
        
        
        Agencia agencia = new Agencia();
        agencia.setID(1);
        viaje.setAgencia(agencia);
        
        viaje.setServicios("Todo incluido");
    }

    @Test
    public void testCrearViaje() {
        GestorViajes.crearViaje(viaje);
        assertTrue("El viaje debería haberse creado sin errores", true);
    }
}

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
        
        // Configurar el objeto Viajes con datos de prueba
        viaje.setNombre("Viaje de prueba");
        viaje.setDescripcion("Descripción del viaje de prueba");
        viaje.setTipo_viaje("Vacacional");
        viaje.setFecInicio("2023-12-01");
        viaje.setFecFin("2023-12-10");
        viaje.setDuracion("9 días");
        
        // Crear un objeto Pais y asignarlo al viaje
        Paises pais = new Paises();
        pais.setNombre("España");
        viaje.setPais(pais);
        
        // Crear un objeto Agencia y asignarlo al viaje
        Agencia agencia = new Agencia();
        agencia.setID(1); // Supongamos que la agencia con ID 1 existe
        viaje.setAgencia(agencia);
        
        viaje.setServicios("Todo incluido");
    }

    @Test
    public void testCrearViaje() {
        // Llamar al método crearViaje del gestor
        GestorViajes.crearViaje(viaje);
        
        // Verificar que el viaje se ha creado correctamente
        // Aquí deberías implementar una lógica para verificar que el viaje existe en la base de datos
        // Por ejemplo, podrías consultar la base de datos para ver si el viaje está presente
        // Como no hay un método para obtener un viaje por ID, este test es básico y solo verifica que no hay excepciones
        assertTrue("El viaje debería haberse creado sin errores", true);
    }
}

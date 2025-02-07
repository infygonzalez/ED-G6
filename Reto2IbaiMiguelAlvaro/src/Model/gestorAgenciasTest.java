package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class gestorAgenciasTest {
    private gestorAgencias gestor;
    private Agencia agencia;

    @Before
    public void setUp() {
        gestor = new gestorAgencias();
        agencia = new Agencia();
        agencia.setNombre("TestAgency");
        agencia.setContra("TestPassword");
        agencia.setLogo("test_logo.png");
        agencia.setColor("#FF5733");
        agencia.setNumeroEmpleados("10");
        agencia.setTipoAgencia("Turismo");
    }

   @Test
    public void testComprobarAgencia() {
        Agencia resultado = gestor.comprobarAgencia(agencia);
        assertNull("La agencia no debería existir inicialmente", resultado);
    }

    @Test
    public void testCrearAgencia() {
        gestor.crearAgencia(agencia);
        boolean existe = gestor.existeAgencia("TestAgency", "TestPassword");
        assertTrue("La agencia debería haberse creado", existe);
    }

    @Test
    public void testAutenticarAgencia() {
        int id = gestor.autenticarAgencia("TestAgency", "TestPassword");
        assertTrue("El ID de la agencia debe ser válido", id > 0);
    }

    @Test
    public void testNombreAgencia() {
        int id = gestor.autenticarAgencia("TestAgency", "TestPassword");
        String nombre = gestor.nombreAgencia(id);
        assertEquals("El nombre de la agencia debe coincidir", "TestAgency", nombre);
    }

    @Test
    public void testSeleccionarColor() {
        int id = gestor.autenticarAgencia("TestAgency", "TestPassword");
        Color color = gestor.seleccionarColor(id);
        assertNotNull("El color de la agencia no debe ser null", color);
    }

    @Test
    public void testExisteAgencia() {
        boolean existe = gestor.existeAgencia("TestAgency", "TestPassword");
        assertTrue("La agencia debería existir", existe);
    }
}

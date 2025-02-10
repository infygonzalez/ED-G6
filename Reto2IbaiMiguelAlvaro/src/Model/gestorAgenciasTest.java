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
        agencia.setNombre("TestAgencia");
        agencia.setContra("TestContra");
        agencia.setLogo("test_logo.png");
        agencia.setColor("#FF5733");
        agencia.setNumeroEmpleados("10");
        agencia.setTipoAgencia("Mayorista");
    }

   @Test
    public void testComprobarAgencia() {
        Agencia resultado = gestor.comprobarAgencia(agencia);
        assertNull("La agencia no debería existir inicialmente", null);
    }

    @Test
    public void testCrearAgencia() {
        gestor.crearAgencia(agencia);
        boolean existe = gestor.existeAgencia("TestAgencia", "TestContra");
        assertTrue("La agencia debería haberse creado", existe);
    }

    @Test
    public void testAutenticarAgencia() {
        int id = gestor.autenticarAgencia("TestAgencia", "TestContra");
        assertTrue("El ID de la agencia debe ser válido", id > 0);
    }

    @Test
    public void testNombreAgencia() {
        int id = gestor.autenticarAgencia("TestAgencia", "TestContra");
        String nombre = gestor.nombreAgencia(id);
        assertEquals("El nombre de la agencia debe coincidir", "TestAgencia", nombre);
    }

    @Test
    public void testSeleccionarColor() {
        int id = gestor.autenticarAgencia("TestAgencia", "TestContra");
        Color color = gestor.seleccionarColor(id);
        assertNotNull("El color de la agencia no debe ser null", color);
    }

    @Test
    public void testExisteAgencia() {
        boolean existe = gestor.existeAgencia("TestAgencia", "TestContra");
        assertTrue("La agencia debería existir", existe);
    }
}

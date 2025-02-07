package Model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class gestorAgenciasTest {

	@Test
	public void testComprobarAgencia(Agencia agencia) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String verificar= SQLQueries.SELECT_CONTRA_AGENCIAS;//otra vez lo mismo
		
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DBUtils.getConexion();//Iniciamos la conexion
			// Verificar si el usuario y la contraseña coincide
			stmt = conexion.prepareStatement(verificar);
			stmt.setString(1, agencia.getNombre());
			stmt.setString(2, agencia.getContra());
			rs = stmt.executeQuery();
			if(rs.next()) {
				agencia = new Agencia();
				agencia.setID(rs.getInt("id_agencia"));
				agencia.setColor(rs.getString("color_marca"));
				agencia.setNombre(rs.getString("nombre"));
				agencia.setNumeroEmpleados(rs.getString("numero_empleados"));
				agencia.setLogo(rs.getString("logo"));
				agencia.setContra(rs.getString("contrasena"));
				agencia.setTipoAgencia(rs.getString("tipo_agencia"));


			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		fail("Not yet implemented");
	}

	@Test
	public void testCrearAgencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutenticarAgencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testNombreAgencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeleccionarColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testExisteAgencia() {
		fail("Not yet implemented");
	}

}

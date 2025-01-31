package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class gestorAgencias {
	
	public boolean comprobarAgencia(Agencia agencia) {
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
			return rs.next(); // devuelve true si coincide la contraseña
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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

	public static void crearAgencia(Agencia agencia) {
	    Connection conexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
	        
	        String sql = "INSERT INTO agencias (nombre, contraseña, logo, color_marca, numero_empleados, tipo_agencia) VALUES (?, ?, ?, ?, ?, ?)";
	        preparedStatement = conexion.prepareStatement(sql);
	        
	        // Establecer los parámetros
	        preparedStatement.setString(1, agencia.getNombre());
	        preparedStatement.setString(2, agencia.getContra());
	        preparedStatement.setString(3, agencia.getLogo());
	        preparedStatement.setString(4, agencia.getColor());
	        preparedStatement.setString(5, agencia.getNumeroEmpleados());
	        preparedStatement.setString(6, agencia.getTipoAgencia());
	        
	        // Ejecutar la actualización
	        preparedStatement.executeUpdate();
	    } catch (ClassNotFoundException e) {
	        System.out.println("No se ha encontrado la clase, mal introducida la agencia");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("SQLException, no se ha podido conectar con la base");
	        e.printStackTrace();
	    } finally {
	        // Cierre de recursos
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (conexion != null) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar los recursos");
	            e.printStackTrace();
	        }
	    }
	}
	public int autenticarAgencia(String usuario, String contraseña) {
	    int idAgencia = -1; // Valor por defecto si la autenticación falla
	    String sql = "SELECT id_agencia FROM agencias WHERE nombre = ? AND contraseña = ?";
	    
	    try (Connection conn = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setString(1, usuario);
	        stmt.setString(2, contraseña);
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            idAgencia = rs.getInt("id_agencia"); // Obtiene el ID de la agencia
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return idAgencia;
	}
}

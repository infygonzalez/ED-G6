package Model;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class gestorAgencias {
	
	public Agencia comprobarAgencia(Agencia agencia) {
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


				return agencia;
			}
			return null; 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	        
	        String sql = "INSERT INTO agencias (nombre, contrasena, logo, color_marca, numero_empleados, tipo_agencia) VALUES (?, ?, ?, ?, ?, ?)";
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
	    String sql = "SELECT id_agencia FROM agencias WHERE nombre = ? AND contrasena = ?";
	    
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
	public String nombreAgencia(int id) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String nombre = null; // Variable para almacenar el resultado

	    try {
	        // Establecer la conexión
	        Class.forName(DBUtils.DRIVER);
	        conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);

	        // Preparar la consulta
	        stmt = conexion.prepareStatement(SQLQueries.SELECT_NOMBRE_AGENCIA);
	        stmt.setInt(1, id);

	        // Ejecutar la consulta
	        rs = stmt.executeQuery();

	        // Obtener el resultado
	        if (rs.next()) {
	            nombre = rs.getString(1); // recoge el String de la segunda columna de la BD, es decir, el nombre
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Manejo básico de errores
	    } finally {
	        // Cerrar los recursos
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    return nombre; // Devuelve el nombre de la agencia o null si no se encontró
	}
	
	public Color seleccionarColor(int id) {
		Connection conexion = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String colorString = null;
        Color color = null;
        
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DBUtils.getConexion();
            stmt = conexion.prepareStatement(SQLQueries.SELECT_COLOR_AGENCIA);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {  // Verifica si hay resultados
                colorString = rs.getString(1);
                if (colorString != null && !colorString.isEmpty()) {
                    color = Color.decode(colorString);
                } else {
                    System.out.println("Advertencia: Código de color vacío o nulo.");
                }
            } else {
                System.out.println("Advertencia: No se encontró un color para la agencia con ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato incorrecto en código de color almacenado: " + colorString);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase del driver de la base de datos no encontrada.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error SQL al intentar obtener el color de la agencia.");
            e.printStackTrace();
        } finally {
            // Cerrar recursos en orden inverso de apertura
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
                e.printStackTrace();
            }
        }
        return color;
	}
	
}

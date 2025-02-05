package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import Model.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PanelAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaViajes;
	private JTable tablaEventos;
	private Agencia agenciaColor;
	private JFrame frame;
	private DefaultTableModel modelViajes;
	//private nuevoViaje crear;

	/**
	 * Create the frame.
	 */
	public PanelAgencia(int idAgencia, String nombreID, String logoUrl) {
		gestorAgencias gestor = new gestorAgencias();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Viajes");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2.setBounds(228, 109, 70, 24);
		contentPane.add(lblNewLabel_2);
		
		// Inicializa el modelo de la tabla de viajes
        modelViajes = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Viaje", "Tipo", "Días", "Fecha Inicio", "Fecha Fin", "País" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desactiva la edición de las celdas
            }
        };

        // Crear la tabla y asignarle el modelo
        tablaViajes = new JTable(modelViajes);
        tablaViajes.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && tablaViajes.getSelectedRow() != -1) {
                int filaSeleccionada = tablaViajes.getSelectedRow();
                int idViaje = obtenerIdViajeDesdeFila(filaSeleccionada);
                cargarEventosDeViaje(idViaje);
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(tablaViajes);
        scrollPane.setBounds(47, 152, 464, 129);
        contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Eventos");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setBounds(228, 286, 59, 24);
		contentPane.add(lblNewLabel_1);
		
		tablaEventos = new JTable();
		tablaEventos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Tipo", "Fecha", "Precio"
			}
		));
		tablaEventos.setBounds(47, 321, 466, 94);
		contentPane.add(tablaEventos);
		
		JScrollPane scrollPane_1 = new JScrollPane(tablaEventos);
		scrollPane_1.setBounds(47, 321, 464, 129);
		contentPane.add(scrollPane_1);
		
		JButton btnNewButton = new JButton("Desconectar");
		btnNewButton.setBackground(new Color(255, 91, 96));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame1 = new Login();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(620, 15, 128, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBorrar = new JButton("Borrar viaje");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener la fila seleccionada
		        int filaSeleccionada = tablaViajes.getSelectedRow();
		        
		        if (filaSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para borrar.");
		            return;
		        }

		        // Obtener el nombre del viaje desde la tabla (columna 0)
		        String nombreViaje = (String) modelViajes.getValueAt(filaSeleccionada, 0);

		        // Confirmación antes de eliminar
		        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el viaje: " + nombreViaje + "?", 
		                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

		        if (confirmacion == JOptionPane.YES_OPTION) {
		            Connection conexion = null;
		            PreparedStatement stmt = null;

		            try {
		                // Conectar con la base de datos
		                Class.forName(DBUtils.DRIVER);
		                conexion = DBUtils.getConexion();

		                // Sentencia SQL para eliminar el viaje
		                String sql = "DELETE FROM viajes WHERE nombre = ? AND id_agencia = ?";
		                stmt = conexion.prepareStatement(sql);
		                stmt.setString(1, nombreViaje);
		                stmt.setInt(2, Sesion.getIdAgencia()); // Asegurarse de que pertenece a la agencia

		                int filasAfectadas = stmt.executeUpdate();

		                if (filasAfectadas > 0) {
		                    // Eliminar del modelo de la tabla
		                    modelViajes.removeRow(filaSeleccionada);
		                    JOptionPane.showMessageDialog(null, "Viaje eliminado correctamente.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar el viaje.");
		                }

		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
		            } catch (ClassNotFoundException ex) {
		                ex.printStackTrace();
		            } finally {
		                try {
		                    if (stmt != null) stmt.close();
		                    if (conexion != null) conexion.close();
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
		    }
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setBackground(new Color(98, 143, 200));
		btnBorrar.setBounds(559, 196, 141, 37);
		contentPane.add(btnBorrar);
		
		JButton btnCrearViaje = new JButton("Crear viaje");
		btnCrearViaje.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoViaje frame4 = new NuevoViaje(idAgencia, nombreID, logoUrl);
				frame4.setVisible(true);
				dispose();
			}
		});
		btnCrearViaje.setForeground(Color.WHITE);
		btnCrearViaje.setBackground(new Color(98, 143, 200));
		btnCrearViaje.setBounds(559, 148, 141, 37);
		contentPane.add(btnCrearViaje);
		
		JButton btnEditar = new JButton("Editar viaje");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(98, 143, 200));
		btnEditar.setBounds(559, 244, 141, 37);
		contentPane.add(btnEditar);
		
		JButton btnCrearEvento = new JButton("Crear evento");
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoEvento frame5 = new NuevoEvento(idAgencia, nombreID, logoUrl);
				frame5.setVisible(true);
				dispose();
			}
		});
		btnCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearEvento.setForeground(Color.WHITE);
		btnCrearEvento.setBackground(new Color(98, 143, 200));
		btnCrearEvento.setBounds(559, 318, 141, 37);
		contentPane.add(btnCrearEvento);
		
		JButton btnBorrarEvento = new JButton("Borrar evento");
		btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = tablaViajes.getSelectedRow();
                
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para borrar.");
                    return;
                }

                // Obtener el ID del viaje desde la tabla (columna 0)
                int idViaje = (int) modelViajes.getValueAt(filaSeleccionada, 0);

                // Confirmación antes de eliminar
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el viaje seleccionado?", 
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    Connection conexion = null;
                    PreparedStatement stmt = null;

                    try {
                        // Conectar con la base de datos
                        Class.forName(DBUtils.DRIVER);
                        conexion = DBUtils.getConexion();

                        // Sentencia SQL para eliminar el viaje
                        String sql = "DELETE FROM viajes WHERE id_viaje = ?";
                        stmt = conexion.prepareStatement(sql);
                        stmt.setInt(1, idViaje);

                        int filasAfectadas = stmt.executeUpdate();

                        if (filasAfectadas > 0) {
                            // Eliminar del modelo de la tabla
                            modelViajes.removeRow(filaSeleccionada);
                            JOptionPane.showMessageDialog(null, "Viaje eliminado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar el viaje.");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (stmt != null) stmt.close();
                            if (conexion != null) conexion.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                }
            }
		});
		btnBorrarEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBorrarEvento.setForeground(Color.WHITE);
		btnBorrarEvento.setBackground(new Color(98, 143, 200));
		btnBorrarEvento.setBounds(559, 366, 141, 37);
		contentPane.add(btnBorrarEvento);
		
		JButton btnEditarEvento = new JButton("Editar evento");
		btnEditarEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditarEvento.setForeground(Color.WHITE);
		btnEditarEvento.setBackground(new Color(98, 143, 200));
		btnEditarEvento.setBounds(559, 414, 141, 37);
		contentPane.add(btnEditarEvento);
		
		JButton btnGeneraOferta = new JButton("Generar oferta para cliente");
		btnGeneraOferta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGeneraOferta.setForeground(Color.WHITE);
		btnGeneraOferta.setBackground(new Color(98, 143, 200));
		btnGeneraOferta.setBounds(47, 473, 222, 31);
		contentPane.add(btnGeneraOferta);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(10, 10, 169, 129);
		contentPane.add(panelLogo);
		
		URL imgUrl = null;
        try {
            imgUrl = new URL(logoUrl);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ImageIcon image = new ImageIcon(imgUrl);
        panelLogo.setLayout(null);
        JLabel lblLogo = new JLabel(new ImageIcon(image.getImage().getScaledInstance(169, 129, Image.SCALE_SMOOTH)));
        lblLogo.setBounds(0, 0, 169, 129);
        panelLogo.add(lblLogo);
        
        
        
        JPanel colorAgencia = new JPanel();
        colorAgencia.setBackground(gestor.seleccionarColor(idAgencia));
        colorAgencia.setBounds(0, 0, 758, 110);
        contentPane.add(colorAgencia);
        colorAgencia.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(191, 11, 363, 32);
        colorAgencia.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("¡Bienvenido " + nombreID + "!");
        lblNewLabel.setBounds(76, 5, 211, 21);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        
        JButton btnEditarCuenta = new JButton("Editar");
        btnEditarCuenta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditarCuenta frame7 = new EditarCuenta(idAgencia, nombreID, logoUrl);
        		frame7.setVisible(true);
        		dispose();
        	}
        });
        btnEditarCuenta.setFont(new Font("Verdana", Font.BOLD, 13));
        btnEditarCuenta.setBackground(new Color(61, 194, 95));
        btnEditarCuenta.setBounds(620, 43, 128, 23);
        colorAgencia.add(btnEditarCuenta);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(620, 76, 128, 23);
        colorAgencia.add(panel_1);
        panel_1.setLayout(null);
        
        
        
        JLabel lblIdAgencia = new JLabel("ID Agencia: "+Sesion.getIdAgencia());
        lblIdAgencia.setBounds(0, 0, 118, 22);
        panel_1.add(lblIdAgencia);
        lblIdAgencia.setFont(new Font("Verdana", Font.PLAIN, 13));
        lblIdAgencia.setHorizontalAlignment(SwingConstants.RIGHT);
	/*	if (logoPath != null && !logoPath.isEmpty()) {
		    try {
		        ImageIcon icon;
		        if (logoPath.startsWith("http") || logoPath.startsWith("https")) {
		            // Cargar imagen desde una URL
		            URL url = new URL(logoPath);
		            icon = new ImageIcon(url);
		        } else {
		            // Cargar imagen desde una ruta local
		            icon = new ImageIcon(logoPath);
		        }

		        // Escalar la imagen
		        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		        JLabel logoLabel = new JLabel(new ImageIcon(img));
		        panelLogo.removeAll();  // Limpia el panel antes de agregar la imagen
		        panelLogo.add(logoLabel);
		        panelLogo.revalidate();
		        panelLogo.repaint();
		        
		    } catch (Exception e) {
		        System.out.println("Error al cargar el logo: " + e.getMessage());
		    }
		} else {
		    System.out.println("No se encontró un logo en la sesión.");
		}*/
        cargarDatosViaje(idAgencia);
	}

	private void cargarDatosViaje(int id) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();
	        String sql = "SELECT id_viaje, nombre, tipo_viaje, duracion, fecha_Inicio, fecha_Fin, pais_destino FROM viajes WHERE id_agencia = ?";
	        stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();

	        // Limpiar modelo antes de agregar nuevos datos
	        modelViajes.setRowCount(0);

	        // Agregar filas con datos de la base de datos
	        while (rs.next()) {
	            modelViajes.addRow(new Object[]{
	                rs.getInt("id_viaje"),  // Agregamos id_viaje como columna oculta
	                rs.getString("nombre"),
	                rs.getString("tipo_viaje"),
	                rs.getInt("duracion"),
	                rs.getString("fecha_Inicio"),
	                rs.getString("fecha_Fin"),
	                rs.getString("pais_destino")
	            });
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void cargarEventosDeViaje(int idViaje) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    DefaultTableModel modelEventos = (DefaultTableModel) tablaEventos.getModel();
	    
	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();
	        String sql = "SELECT nombre, tipo_evento, fecha, precio FROM eventos WHERE id_viaje = ?";
	        stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idViaje);
	        rs = stmt.executeQuery();

	        // Limpiar la tabla antes de agregar nuevos datos
	        modelEventos.setRowCount(0);

	        // Agregar filas con datos de la base de datos
	        while (rs.next()) {
	            modelEventos.addRow(new Object[]{
	                rs.getString("nombre"),
	                rs.getString("tipo_evento"),
	                rs.getString("fecha"),
	                rs.getDouble("precio")
	            });
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar los eventos: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private int obtenerIdViajeDesdeFila(int fila) {
	    return (int) modelViajes.getValueAt(fila, 0); // Columna 0 tiene el id_viaje
	}
	
	private String obtenerLogoURLDesdeBD(int idAgencia) {
	    Connection conexion = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String logoUrl = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DBUtils.getConexion();
	        String sql = "SELECT logo FROM agencias WHERE id_agencia = ?";
	        stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idAgencia);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            logoUrl = rs.getString("logo"); // Obtener la URL almacenada en TEXT
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return logoUrl;
	}

	private void cargarLogo(int idAgencia) {
	    JPanel panelLogo = new JPanel();
	    panelLogo.setBounds(0, 0, 186, 129);
	    contentPane.add(panelLogo);

	    // Obtener la URL del logo desde la base de datos
	    String logoUrl = obtenerLogoURLDesdeBD(idAgencia);

	    if (logoUrl != null && !logoUrl.isEmpty()) {
	        try {
	            ImageIcon icon = new ImageIcon(new java.net.URL(logoUrl));
	            Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	            JLabel logoLabel = new JLabel(new ImageIcon(img));
	            panelLogo.removeAll();  // Elimina imágenes previas
	            panelLogo.add(logoLabel);
	            panelLogo.revalidate();
	            panelLogo.repaint();
	        } catch (Exception e) {
	            System.out.println("Error al cargar el logo desde la URL: " + e.getMessage());
	            // Puedes mostrar un mensaje de error o un icono por defecto
	            JLabel errorLabel = new JLabel("Logo no disponible");
	            panelLogo.removeAll();
	            panelLogo.add(errorLabel);
	            panelLogo.revalidate();
	            panelLogo.repaint();
	        }
	    } else {
	        System.out.println("No se encontró un logo en la base de datos.");
	        // Puedes mostrar un mensaje o un icono por defecto
	        JLabel noLogoLabel = new JLabel("No logo");
	        panelLogo.removeAll();
	        panelLogo.add(noLogoLabel);
	        panelLogo.revalidate();
	        panelLogo.repaint();
	    }
	}


}
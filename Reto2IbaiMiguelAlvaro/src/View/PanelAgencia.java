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
import java.io.FileWriter;
import java.io.IOException;
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
		setResizable(false);
		gestorAgencias gestor = new gestorAgencias();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 565);
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
            new String[] { "Viaje", "Nombre", "Tipo", "Días", "Fecha Inicio", "Fecha Fin", "País" }
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
        scrollPane.setBounds(23, 152, 509, 129);
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
		scrollPane_1.setBounds(23, 321, 509, 129);
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
		        int filaSeleccionada = tablaViajes.getSelectedRow();

		        if (filaSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para borrar.");
		            return;
		        }

		        // Obtener el ID del viaje desde la tabla (columna 0)
		        int idViaje = (int) modelViajes.getValueAt(filaSeleccionada, 0);

		        int confirmacion = JOptionPane.showConfirmDialog(null, 
		            "¿Estás seguro de que deseas eliminar el viaje seleccionado?", 
		            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

		        if (confirmacion == JOptionPane.YES_OPTION) {
		            Connection conexion = null;
		            PreparedStatement stmtEliminarEventos = null;
		            PreparedStatement stmtEliminarViaje = null;

		            try {
		                // Conectar con la base de datos
		                Class.forName(DBUtils.DRIVER);
		                conexion = DBUtils.getConexion();
		                conexion.setAutoCommit(false); // Iniciar transacción

		                // Eliminar eventos relacionados
		                String sqlEventos = "DELETE FROM eventos WHERE id_viaje = ?";
		                stmtEliminarEventos = conexion.prepareStatement(sqlEventos);
		                stmtEliminarEventos.setInt(1, idViaje);
		                stmtEliminarEventos.executeUpdate();

		                // Eliminar el viaje
		                String sqlViaje = "DELETE FROM viajes WHERE id_viaje = ? AND id_agencia = ?";
		                stmtEliminarViaje = conexion.prepareStatement(sqlViaje);
		                stmtEliminarViaje.setInt(1, idViaje);
		                stmtEliminarViaje.setInt(2, Sesion.getIdAgencia());

		                int filasAfectadas = stmtEliminarViaje.executeUpdate();

		                if (filasAfectadas > 0) {
		                    conexion.commit(); // Confirmar cambios
		                    modelViajes.removeRow(filaSeleccionada);
		                    JOptionPane.showMessageDialog(null, "Viaje eliminado correctamente.");
		                } else {
		                    conexion.rollback(); // Revertir cambios en caso de fallo
		                    JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar el viaje.");
		                }

		            } catch (SQLException | ClassNotFoundException ex) {
		                try {
		                    if (conexion != null) conexion.rollback();
		                } catch (SQLException rollbackEx) {
		                    rollbackEx.printStackTrace();
		                }
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
		            } finally {
		                try {
		                    if (stmtEliminarEventos != null) stmtEliminarEventos.close();
		                    if (stmtEliminarViaje != null) stmtEliminarViaje.close();
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
		btnBorrar.setBounds(559, 228, 141, 53);
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
		btnCrearViaje.setBounds(559, 148, 141, 53);
		contentPane.add(btnCrearViaje);
		
		JButton btnCrearEvento = new JButton("Crear evento");
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaViajes.getSelectedRow();
				int idViaje = (int) modelViajes.getValueAt(filaSeleccionada, 0);//almacenamos la id del viaje seleccionado
				NuevoEvento frame5 = new NuevoEvento(idAgencia, nombreID, logoUrl, idViaje);
				frame5.setVisible(true);
				dispose();
			}
		});
		btnCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearEvento.setForeground(Color.WHITE);
		btnCrearEvento.setBackground(new Color(98, 143, 200));
		btnCrearEvento.setBounds(559, 318, 141, 53);
		contentPane.add(btnCrearEvento);
		
		JButton btnBorrarEvento = new JButton("Borrar evento");
		btnBorrarEvento.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int filaSeleccionada = tablaEventos.getSelectedRow();
		        
		        if (filaSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona un evento para borrar.");
		            return;
		        }

		        // Obtener el nombre del evento desde la tabla (columna 0)
		        String nombreEvento = (String) tablaEventos.getValueAt(filaSeleccionada, 0);
		        
		        // Obtener el ID del viaje seleccionado en la tabla de viajes
		        int filaViajeSeleccionada = tablaViajes.getSelectedRow();
		        if (filaViajeSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje antes de borrar un evento.");
		            return;
		        }
		        int idViaje = (int) modelViajes.getValueAt(filaViajeSeleccionada, 0);
		        
		        // Confirmación antes de eliminar
		        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el evento: " + nombreEvento + "?", 
		                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

		        if (confirmacion == JOptionPane.YES_OPTION) {
		            Connection conexion = null;
		            PreparedStatement stmt = null;

		            try {
		                // Conectar con la base de datos
		                Class.forName(DBUtils.DRIVER);
		                conexion = DBUtils.getConexion();

		                // Sentencia SQL para eliminar el evento
		                String sql = "DELETE FROM eventos WHERE nombre = ? AND id_viaje = ?";
		                stmt = conexion.prepareStatement(sql);
		                stmt.setString(1, nombreEvento);
		                stmt.setInt(2, idViaje);

		                int filasAfectadas = stmt.executeUpdate();

		                if (filasAfectadas > 0) {
		                    // Eliminar del modelo de la tabla
		                    DefaultTableModel modelEventos = (DefaultTableModel) tablaEventos.getModel();
		                    modelEventos.removeRow(filaSeleccionada);
		                    JOptionPane.showMessageDialog(null, "Evento eliminado correctamente.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar el evento.");
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
		btnBorrarEvento.setBounds(559, 397, 141, 53);
		contentPane.add(btnBorrarEvento);
		
		JButton btnGeneraOferta = new JButton("Generar oferta para cliente");
		btnGeneraOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarOfertaCliente();
			}
		});
		btnGeneraOferta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGeneraOferta.setForeground(Color.WHITE);
		btnGeneraOferta.setBackground(new Color(98, 143, 200));
		btnGeneraOferta.setBounds(47, 473, 222, 31);
		contentPane.add(btnGeneraOferta);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 179, 110);
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
        lblLogo.setBounds(0, 0, 179, 110);
        panelLogo.add(lblLogo);
        
        
        
        JPanel colorAgencia = new JPanel();
        colorAgencia.setBackground(gestor.seleccionarColor(idAgencia));
        colorAgencia.setBounds(0, 0, 758, 110);
        contentPane.add(colorAgencia);
        colorAgencia.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(191, 11, 414, 32);
        colorAgencia.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("¡Bienvenido " + nombreID + "!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 5, 394, 21);
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
	                rs.getInt("id_viaje"),
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
	private void generarOfertaCliente() {
	    int filaSeleccionada = tablaViajes.getSelectedRow();
	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para generar la oferta.");
	        return;
	    }

	    // Obtener los datos del viaje seleccionado
	    String nombreViaje = (String) modelViajes.getValueAt(filaSeleccionada, 1);
	    String tipoViaje = (String) modelViajes.getValueAt(filaSeleccionada, 2);
	    int duracion = (int) modelViajes.getValueAt(filaSeleccionada, 3);
	    String fechaInicio = (String) modelViajes.getValueAt(filaSeleccionada, 4);
	    String fechaFin = (String) modelViajes.getValueAt(filaSeleccionada, 5);
	    String paisDestino = (String) modelViajes.getValueAt(filaSeleccionada, 6);

	    // Construir el contenido de la oferta
	    StringBuilder oferta = new StringBuilder();
	    oferta.append("*** OFERTA DE VIAJE ***\n\n");
	    oferta.append("Nombre del Viaje: " + nombreViaje + "\n");
	    oferta.append("Tipo de Viaje: " + tipoViaje + "\n");
	    oferta.append("Duración: " + duracion + " días\n");
	    oferta.append("Fecha de Inicio: " + fechaInicio + "\n");
	    oferta.append("Fecha de Fin: " + fechaFin + "\n");
	    oferta.append("Destino: " + paisDestino + "\n\n");
	    oferta.append("Eventos incluidos:\n");

	    // Obtener los eventos relacionados con el viaje
	    DefaultTableModel modelEventos = (DefaultTableModel) tablaEventos.getModel();
	    for (int i = 0; i < modelEventos.getRowCount(); i++) {
	        String nombreEvento = (String) modelEventos.getValueAt(i, 0);
	        String tipoEvento = (String) modelEventos.getValueAt(i, 1);
	        String fechaEvento = (String) modelEventos.getValueAt(i, 2);
	        double precioEvento = (double) modelEventos.getValueAt(i, 3);
	        oferta.append("- " + nombreEvento + " (" + tipoEvento + ", " + fechaEvento + ") - Precio: " + precioEvento + "€\n");
	    }

	    try {
	        // Guardar la oferta en un archivo de texto
	        FileWriter writer = new FileWriter("Oferta_" + nombreViaje.replace(" ", "_") + ".txt");
	        writer.write(oferta.toString());
	        writer.close();
	        JOptionPane.showMessageDialog(null, "Oferta generada exitosamente en un archivo de texto.");
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al generar la oferta: " + e.getMessage());
	    }
	}
	

}
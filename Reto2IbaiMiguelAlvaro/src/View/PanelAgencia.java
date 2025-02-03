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
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import Model.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestorAgencias gestor = new gestorAgencias();
					int id = Sesion.getIdAgencia();
					String nombreID = gestor.nombreAgencia(id);
					PanelAgencia frame = new PanelAgencia(id, nombreID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelAgencia(int idAgencia, String nombreID) {
		gestorAgencias gestor = new gestorAgencias();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido!");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(298, 11, 161, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(0, 0, 185, 110);
		contentPane.add(lblIcono);
		
		JLabel lblNewLabel_2 = new JLabel("Viajes");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2.setBounds(228, 109, 70, 24);
		contentPane.add(lblNewLabel_2);
		
		modelViajes = new DefaultTableModel(); 
		tablaViajes = new JTable();
		tablaViajes.setRowSelectionAllowed(false);
		tablaViajes.setSurrendersFocusOnKeystroke(true);
		tablaViajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Crear un modelo de tabla personalizado que no permita edición
		DefaultTableModel modeloNoEditable = new DefaultTableModel(
		    new Object[][] {
		        {null, null, null, null, null, null},
		        {null, null, null, null, null, null},
		    },
		    new String[] {
		        "Viajes", "Tipo", "Dias", "Fecha Inicio", "Fecha fin", "Pais"
		    }
		) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Desactiva la edición para todas las celdas
		    }
		};

		// Asignar el modelo a la tabla
		tablaViajes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Viaje", "Tipo", "Dias", "Fecha Inicio", "Fecha fin", "Pais"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaViajes.getColumnModel().getColumn(1).setPreferredWidth(101);
		tablaViajes.getColumnModel().getColumn(2).setPreferredWidth(101);
		tablaViajes.getColumnModel().getColumn(3).setPreferredWidth(84);
		tablaViajes.getColumnModel().getColumn(4).setPreferredWidth(84);
		tablaViajes.getColumnModel().getColumn(5).setPreferredWidth(83);
		
		// Configurar posición y agregar al contentPane
		tablaViajes.setBounds(20, 183, 466, 87);
		contentPane.add(tablaViajes);
		
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
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBounds(620, 15, 128, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblIdAgencia = new JLabel("ID Agencia: "+Sesion.getIdAgencia());
		lblIdAgencia.setBounds(449, 11, 161, 24);
		contentPane.add(lblIdAgencia);
		
		JButton btnBorrar = new JButton("Borrar viaje");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setBackground(new Color(98, 143, 200));
		btnBorrar.setBounds(559, 196, 141, 37);
		contentPane.add(btnBorrar);
		
		JButton btnCrearViaje = new JButton("Crear viaje");
		btnCrearViaje.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoViaje frame4 = new NuevoViaje(idAgencia, nombreID);
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
				NuevoEvento frame5 = new NuevoEvento(idAgencia, nombreID);
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
		
		JLabel lblNombreAgencia = new JLabel("Nombre: "+ nombreID);
		lblNombreAgencia.setBounds(449, 33, 161, 24);
		contentPane.add(lblNombreAgencia);
		
		JPanel colorAgencia = new JPanel();
		colorAgencia.setBackground(gestor.seleccionarColor(idAgencia));
		colorAgencia.setBounds(0, 0, 758, 110);
		contentPane.add(colorAgencia);
		
		cargarDatosViaje();
	}

	private void cargarDatosViaje() {
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DBUtils.getConexion();
            rs = stmt.executeQuery("SELECT id, nombre, edad FROM usuarios");;

            // Agregar filas con datos de la base de datos
            while (rs.next()) {
                modelViajes.addRow(new Object[]{
                    rs.getInt("nombre"),
                    rs.getString("tipo_viaje"),
                    rs.getInt("duracion"),
                    rs.getString("fecha_Inicio"),
                    rs.getString("fecha_Fin"),
                    rs.getString("pais_destino")
                    
                });
            }
            
            // Cerrar conexiones
            rs.close();
            stmt.close();
            conexion.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
		
	}
}
package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaViajes;
	private JTable tablaEventos;
	private JLabel lblColor;
	private Agencia agenciaColor;
	private JFrame frame;
	//private nuevoViaje crear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String nombreAgencia) {
				try {
					PanelAgencia frame = new PanelAgencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelAgencia() {
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
		lblIcono.setBounds(0, 0, 185, 141);
		contentPane.add(lblIcono);
		
		JLabel lblNewLabel_2 = new JLabel("Viajes");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2.setBounds(228, 109, 70, 24);
		contentPane.add(lblNewLabel_2);
		
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
				"Viajes", "Tipo", "Dias", "Fecha Inicio", "Fecha fin", "Pais"
			}
		));
		tablaViajes.getColumnModel().getColumn(1).setPreferredWidth(101);
		tablaViajes.getColumnModel().getColumn(2).setPreferredWidth(101);
		tablaViajes.getColumnModel().getColumn(3).setPreferredWidth(84);
		tablaViajes.getColumnModel().getColumn(4).setPreferredWidth(84);
		tablaViajes.getColumnModel().getColumn(5).setPreferredWidth(83);
		
		// Configurar posición y agregar al contentPane
		tablaViajes.setBounds(20, 183, 466, 87);
		contentPane.add(tablaViajes);
		
		JButton btnCrearViaje = new JButton("Crear Viaje");
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 NuevoViaje frame3 = new NuevoViaje();
				 frame3.setVisible(true);
				 dispose();
			}
		});
		btnCrearViaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrearViaje.setBounds(559, 154, 120, 23);
		contentPane.add(btnCrearViaje);
		
		JScrollPane scrollPane = new JScrollPane(tablaViajes);
		scrollPane.setBounds(47, 152, 466, 123);
		contentPane.add(scrollPane);
		
		JButton btnBorrarViaje = new JButton("Borrar Viaje");
		btnBorrarViaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBorrarViaje.setBounds(559, 205, 120, 23);
		contentPane.add(btnBorrarViaje);
		
		JButton btnEditarViaje = new JButton("Editar Viaje");
		btnEditarViaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnEditarViaje.setBounds(559, 252, 120, 23);
		contentPane.add(btnEditarViaje);
		
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
		scrollPane_1.setBounds(47, 321, 464, 116);
		contentPane.add(scrollPane_1);
		
		JButton btnCrearEventos = new JButton("Crear Eventos");
		btnCrearEventos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrearEventos.setBounds(559, 324, 120, 23);
		contentPane.add(btnCrearEventos);
		
		JButton btnBorrarEventos = new JButton("Borrar Eventos");
		btnBorrarEventos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBorrarEventos.setBounds(559, 369, 120, 23);
		contentPane.add(btnBorrarEventos);
		
		JButton btnEditarViajes = new JButton("Editar Viajes");
		btnEditarViajes.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnEditarViajes.setBounds(559, 414, 120, 23);
		contentPane.add(btnEditarViajes);
		
		JButton btnGenerarOferta = new JButton("Generar oferta para cliente");
		btnGenerarOferta.setFont(new Font("Verdana", Font.BOLD, 11));
		btnGenerarOferta.setBounds(47, 481, 222, 23);
		contentPane.add(btnGenerarOferta);
		
		JButton btnNewButton = new JButton("Desconectar");
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
		
		lblColor = new JLabel("");
		lblColor.setForeground(Color.BLACK);
		lblColor.setBounds(0, 0, 758, 110);
		lblColor.setBackground(agenciaColor(agenciaColor));
		contentPane.add(lblColor);
		
		JLabel lblIdAgencia = new JLabel("ID Agencia: ");
		lblIdAgencia.setBounds(559, 462, 120, 31);
		contentPane.add(lblIdAgencia);
		
	}

	private Color agenciaColor(Agencia agenciaColor) {
		Color colordefault = Color.white;
		return colordefault;
	}
}
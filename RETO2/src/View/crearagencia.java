package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Agencia;
import Model.gestorAgencias;

import java.nio.file.StandardCopyOption;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class crearagencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtColor;
	private JTextField txtLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearagencia frame = new crearagencia();
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
	public crearagencia() {
		JFrame frame = new JFrame("Subir Archivo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea tu perfil");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(131, 10, 171, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Agencia (Usuario):");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 50, 193, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 75, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(238, 47, 186, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(238, 73, 186, 20);
		contentPane.add(txtContraseña);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 100, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Logo:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 113, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Color de la Agencia(hexadecimal):");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 154, 218, 14);
		contentPane.add(lblNewLabel_4);
		
		txtColor = new JTextField();
		txtColor.setBounds(238, 152, 186, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numero de empleados:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(10, 190, 145, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox numeroEmple = new JComboBox();
		numeroEmple.setFont(new Font("Verdana", Font.PLAIN, 11));
		numeroEmple.setModel(new DefaultComboBoxModel(new String[] {"Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"}));
		numeroEmple.setBounds(165, 187, 198, 22);
		contentPane.add(numeroEmple);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de agencia:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(10, 225, 110, 14);
		contentPane.add(lblNewLabel_6);
		
		JComboBox tipoAgencia = new JComboBox();
		tipoAgencia.setModel(new DefaultComboBoxModel(new String[] {"Mayorista", "Minorista", "Mayorista-Minorista"}));
		tipoAgencia.setBounds(117, 222, 157, 22);
		contentPane.add(tipoAgencia);
		
		txtLogo = new JTextField();
		txtLogo.setFont(new Font("Verdana", Font.ITALIC, 11));
		txtLogo.setText("Introduce la URL de internet");
		txtLogo.setBounds(66, 113, 318, 20);
		contentPane.add(txtLogo);
		txtLogo.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear Agencia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String contrase = txtContraseña.getText();
				String logo = txtLogo.getText();
				String color = txtColor.getText();
				String empleados = numeroEmple.getSelectedItem().toString();
				String tipoagencia = tipoAgencia.getSelectedItem().toString();
				
				mandarAgencia(usuario, contrase, logo, color, empleados, tipoagencia);
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.setBounds(131, 285, 171, 23);
		contentPane.add(btnNewButton);
	}
	
	public void mandarAgencia(String nombre, String contra,String logo, String color, String empleados, String tipoAgencia) {
		Agencia agencia = new Agencia();
		agencia.setNombre(nombre);
		agencia.setContra(contra);
		agencia.setLogo(logo);
		agencia.setColor(color);
		agencia.setNumeroEmpleados(empleados);
		agencia.setTipoAgencia(tipoAgencia);
		gestorAgencias.crearAgencia(agencia);
	}
}

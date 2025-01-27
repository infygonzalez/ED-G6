package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.*;
import View.*;
import javax.swing.SwingConstants;


public class login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JLabel lblMensaje;
	Agencia agencia = new Agencia();
	gestorAgencias gestor = new gestorAgencias();
	private JTextField txtContraseña;

	/**
	 * Create the panel.
	 */
	public login(Agencia agencia) {
		setForeground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesion");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(162, 5, 126, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_Usuario = new JLabel("Usuario:");
		lblNewLabel_Usuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_Usuario.setBounds(67, 71, 55, 14);
		add(lblNewLabel_Usuario);
		
		JLabel lblNewLabel_Contraseña = new JLabel("Contraseña:");
		lblNewLabel_Contraseña.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_Contraseña.setBounds(67, 120, 81, 14);
		add(lblNewLabel_Contraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtUsuario.setBounds(197, 68, 160, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreusu = txtUsuario.getText();
				String contraseña = txtContraseña.getText();
				validarAgencia(nombreusu, contraseña, agencia, gestor);
			}
		});
		btnValidar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnValidar.setBackground(Color.GRAY);
		btnValidar.setBounds(67, 181, 89, 23);
		add(btnValidar);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					crearagencia frame = new crearagencia();
					frame.setVisible(true);
			}
		});
		btnCrearUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrearUsuario.setBackground(Color.GRAY);
		btnCrearUsuario.setBounds(243, 181, 114, 23);
		add(btnCrearUsuario);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMensaje.setBounds(67, 240, 306, 14);
		add(lblMensaje);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(197, 118, 160, 20);
		add(txtContraseña);
		txtContraseña.setColumns(10);
		

	}
	public void validarAgencia(String nombreusu, String contraseña,Agencia agencia, gestorAgencias gestor) {
		agencia.setNombre(nombreusu);
		agencia.setContra(contraseña);
		if (gestor.comprobarAgencia(agencia)==true) {
			lblMensaje.setText("Inicio de sesion correcto");
			panelAgencia frame = new panelAgencia();
			frame.setVisible(true);
		}else {
			lblMensaje.setText("Error, Usuario o contraseña incorrectos");
		}
	}
}

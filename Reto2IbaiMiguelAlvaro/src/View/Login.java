package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.*;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNombre.setBounds(141, 88, 78, 31);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtNombre.setBounds(292, 88, 150, 31);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblContraseña.setBounds(141, 156, 104, 31);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(292, 156, 150, 31);
		contentPane.add(txtContraseña);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agencia agencia = new Agencia();
				gestorAgencias gestor = new gestorAgencias();
				String nombre = txtNombre.getText();
				String contraseña = txtContraseña.getText();
				validarCredenciales(agencia, nombre, contraseña, gestor);
				
			}
		});
		btnValidar.setForeground(new Color(255, 255, 255));
		btnValidar.setBackground(new Color(98, 143, 200));
		btnValidar.setBounds(141, 253, 141, 31);
		contentPane.add(btnValidar);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuenta frame2 = new CrearCuenta();
				frame2.setVisible(true);
				dispose();
			}
		});
		btnCrearCuenta.setForeground(new Color(255, 255, 255));
		btnCrearCuenta.setBackground(new Color(98, 143, 200));
		btnCrearCuenta.setBounds(301, 253, 141, 31);
		contentPane.add(btnCrearCuenta);
	}
	public void validarCredenciales(Agencia agencia, String nombre, String contraseña, gestorAgencias gestor) {
		agencia.setNombre(nombre);
		agencia.setContra(contraseña);
		if (gestor.comprobarAgencia(agencia)==true) {
			int id = gestor.autenticarAgencia(nombre, contraseña);
			if (id != -1) {
			    Sesion.setIdAgencia(id); // Guarda el ID de la agencia en la sesión
			    System.out.println("Sesión iniciada con ID: " + Sesion.getIdAgencia());
			} else {
			    System.out.println("Credenciales incorrectas");
			}
			int idAgencia = Sesion.getIdAgencia();
			String nombreID = gestor.nombreAgencia(id);
			PanelAgencia frame3 = new PanelAgencia(idAgencia, nombreID);
			frame3.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

}

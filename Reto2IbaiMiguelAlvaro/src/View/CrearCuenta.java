package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import Controller.Controlador;
import Model.Agencia;
import Model.Sesion;
import Model.gestorAgencias;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrearCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtContrase;
	private JTextField txtLogo;
	private JTextField txtColor;

	/**
	 * Create the frame.
	 */
	public CrearCuenta() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea tu perfil");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(253, 11, 131, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Agencia (Usuario):");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(79, 80, 232, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(79, 117, 232, 26);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(362, 82, 181, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContrase = new JTextField();
		txtContrase.setColumns(10);
		txtContrase.setBounds(362, 117, 181, 26);
		contentPane.add(txtContrase);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 154, 532, 17);
		contentPane.add(separator);
		
		JLabel lblLogo = new JLabel("Logo:");
		lblLogo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLogo.setBounds(79, 162, 168, 26);
		contentPane.add(lblLogo);
		
		txtLogo = new JTextField();
		txtLogo.setColumns(10);
		txtLogo.setBounds(253, 164, 290, 26);
		contentPane.add(txtLogo);
		
		JLabel lblColorDeLa = new JLabel("Color de la agencia (hexadecimal):");
		lblColorDeLa.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblColorDeLa.setBounds(79, 199, 232, 26);
		contentPane.add(lblColorDeLa);
		
		JPanel panel = new JPanel();
		panel.setBounds(493, 201, 50, 24);
		contentPane.add(panel);
		
		
		txtColor = new JTextField();
		txtColor.setText("#");
		// Añadir DocumentListener al JTextField para detectar cambios
        txtColor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarColor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarColor();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarColor();
            }
            
            // Método que valida y actualiza el color del panel
            private void actualizarColor() {
                String hexColor = txtColor.getText().trim();
                
                // Validación de color hexadecimal
                if (Controlador.validacionColor(hexColor)) {
                    try {
                        // Cambiar el color del panel si es válido
                        panel.setBackground(Color.decode(hexColor));
                    } catch (Exception ex) {
                        // Si el color no se puede interpretar correctamente, dejar blanco
                        panel.setBackground(Color.WHITE);
                    }
                } else {
                    // Si no es un color válido, mostrar color blanco
                    panel.setBackground(Color.WHITE);
                }
            }
        });
		txtColor.setColumns(10);
		txtColor.setBounds(362, 201, 121, 26);
		contentPane.add(txtColor);
		
		JLabel lblNumEmpleados = new JLabel("Numero de empleados:");
		lblNumEmpleados.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNumEmpleados.setBounds(79, 236, 232, 26);
		contentPane.add(lblNumEmpleados);
		
		JComboBox comboBoxNEmple = new JComboBox();
		comboBoxNEmple.setModel(new DefaultComboBoxModel(new String[] {"", "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"}));
		comboBoxNEmple.setBounds(303, 238, 240, 26);
		contentPane.add(comboBoxNEmple);
		
		JComboBox comboBoxTipoAgencia = new JComboBox();
		comboBoxTipoAgencia.setModel(new DefaultComboBoxModel(new String[] {"", "Mayorista", "Minorista", "Mayorista-Minorista"}));
		comboBoxTipoAgencia.setBounds(303, 279, 240, 26);
		contentPane.add(comboBoxTipoAgencia);
		
		JLabel lblTipoDeAgencia = new JLabel("Tipo de agencia:");
		lblTipoDeAgencia.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTipoDeAgencia.setBounds(79, 277, 232, 26);
		contentPane.add(lblTipoDeAgencia);
		
		JButton btnCrear = new JButton("Crear cuenta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtNombre.getText();
				String contrase = txtContrase.getText();
				String logo = txtLogo.getText();
				String color = txtColor.getText();
				String empleados = comboBoxNEmple.getSelectedItem().toString();
				String tipoagencia = comboBoxTipoAgencia.getSelectedItem().toString();
				
				gestorAgencias gestor = new gestorAgencias();
					
					if(comboBoxNEmple.getSelectedItem().equals("") || comboBoxTipoAgencia.getSelectedItem().equals("") && txtLogo.getText().contains("") && txtNombre.getText().contains("") && txtContrase.getText().contains("") && txtColor.getText().contains("")) {
						JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
						
					} else if (gestor.existeAgencia(usuario, contrase)) {
					    JOptionPane.showMessageDialog(null, "El nombre de usuario y contraseña ya están en uso.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					    return;
					} else {
						mandarAgencia(usuario, contrase, logo, color, empleados, tipoagencia);
						JOptionPane.showMessageDialog(null, "Se ha añadido correctamente", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
						Login frame1 = new Login();
						frame1.setVisible(true);
						dispose();
					}
					
			}
		});
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setBackground(new Color(98, 143, 200));
		btnCrear.setBounds(422, 344, 121, 31);
		contentPane.add(btnCrear);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(98, 143, 200));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame1 = new Login();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(307, 344, 88, 31);
		contentPane.add(btnAtras);
	
	
		
	}
	public void mandarAgencia(String nombre, String contra, String logo, String color, String empleados, String tipoAgencia) {
	    Agencia agencia = new Agencia();
	    agencia.setNombre(nombre);
	    agencia.setContra(contra);
	    agencia.setLogo(logo);
	    agencia.setColor(color);
	    agencia.setNumeroEmpleados(empleados);
	    agencia.setTipoAgencia(tipoAgencia);

	    // Guardar el logo en la sesión
	    Sesion.setLogo(logo);
	    
	    gestorAgencias.crearAgencia(agencia);
	}

}

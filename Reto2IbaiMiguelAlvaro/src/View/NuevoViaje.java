package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Model.*;
 

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDias;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private JButton btnBorrar;
	private JButton btnGuardar;

	

	/**
	 * Create the frame.
	 */
	public NuevoViaje(int id, String nombreID, String logoUrl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreViaje = new JLabel("Nombre viaje:");
		lblNombreViaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNombreViaje.setBounds(71, 64, 121, 35);
		contentPane.add(lblNombreViaje);

		txtNombre = new JTextField();
		txtNombre.setBounds(237, 72, 212, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTipoViaje = new JLabel("Tipo de viaje:");
		lblTipoViaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTipoViaje.setBounds(71, 110, 121, 35);
		contentPane.add(lblTipoViaje);

		JComboBox<String> comboBoxViaje = new JComboBox<>();
		comboBoxViaje.setModel(new DefaultComboBoxModel(new String[] {"", "Novios", "Senior", "Grupos", "Grandes viajes (destinos exóticos)", "Combinado (vuelo+hotel)", "Escapadas", "Familias con niños menores"}));
		comboBoxViaje.setBounds(237, 117, 212, 22);
		contentPane.add(comboBoxViaje);

		JLabel lblInicioViaje = new JLabel("Inicio viaje:");
		lblInicioViaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblInicioViaje.setBounds(71, 152, 121, 35);
		contentPane.add(lblInicioViaje);

		dateInicio = new JDateChooser();
		dateInicio.setBounds(237, 163, 212, 20);
		contentPane.add(dateInicio);

		JLabel lblFinViaje = new JLabel("Fin viaje:");
		lblFinViaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFinViaje.setBounds(71, 201, 121, 35);
		contentPane.add(lblFinViaje);

		dateFin = new JDateChooser();
		dateFin.setBounds(237, 213, 212, 20);
		contentPane.add(dateFin);

		JLabel lblDias = new JLabel("Días:");
		lblDias.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDias.setBounds(71, 247, 121, 35);
		contentPane.add(lblDias);

		txtDias = new JTextField();
		txtDias.setBounds(237, 255, 86, 20);
		txtDias.setEditable(false);
		contentPane.add(txtDias);
		txtDias.setColumns(10);
		
		JLabel lblPaises = new JLabel("Países:");
		lblPaises.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPaises.setBounds(71, 293, 121, 35);
		contentPane.add(lblPaises);
		
		JComboBox<String> comboBoxPaises = new JComboBox<String>();
		comboBoxPaises.setModel(new DefaultComboBoxModel(new String[] {"", "ALEMANIA", "ARGENTINA", "AUSTRIA", "BÉLGICA", "BRASIL", "CANADA", "CROACIA", "REPUBLICA CHECA", "CUBA", "CHINA", "CHIPRE", "DINAMARCA", "EGIPTO", "ESPAÑA", "ESTADOS UNIDOS", "ESTONIA", "FINLANDIA", "FRANCIA", "GRECIA", "GUATEMALA", "HONG-KONG", "HUNGRIA", "INDIA", "INDONESIA", "IRLANDA", "ISLANDIA", "ISRAEL", "ITALIA", "jAMAICA", "JAPÓN", "KENIA", "LUXEMBURGO", "MALDIVAS", "MALTA", "MARRUECOS", "MEXICO", "MÓNACO", "NORUEGA", "PAISES BAJOS", "PANAMÁ", "PERÚ", "POLONIA", "PORTUGAL", "PUERTO RICO", "QATAR", "REINO UNIDO", "RUMANIA", "RUSIA", "SEYCHELLES", "SINGAPUR", "SUDÁFRICA", "SUECIA", "SUIZA", "TAILANDIA", "TANZANIA (INCLUYE ZANZIBAR)", "TÚNEZ", "TURQUIA", "VENEZUELA", "VIETNAM"}));
		comboBoxPaises.setBounds(237, 300, 212, 22);
		contentPane.add(comboBoxPaises);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDescripcion.setBounds(71, 353, 121, 35);
		contentPane.add(lblDescripcion);
		
		TextArea txtAreaDescripcion = new TextArea();
		txtAreaDescripcion.setBounds(237, 348, 301, 72);
		contentPane.add(txtAreaDescripcion);
		
		JLabel lblServicios = new JLabel("Servicios no inc:");
		lblServicios.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblServicios.setBounds(71, 444, 121, 35);
		contentPane.add(lblServicios);
		
		TextArea txtAreaServicios = new TextArea();
		txtAreaServicios.setBounds(237, 437, 301, 72);
		contentPane.add(txtAreaServicios);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardar.setBackground(new Color(73, 120, 171));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paises paises = new Paises();
				String nombre = txtNombre.getText();
				String tipoViaje = comboBoxViaje.getSelectedItem().toString();
				String fecInicio = dateInicio.getDate().toString();
				String fecFin = dateFin.getDate().toString();
				String dias = txtDias.getText();
				String descripcion = txtAreaDescripcion.getText();
				String servicios = txtAreaServicios.getText();
				String nombrepais = comboBoxPaises.getSelectedItem().toString();
				paises.setNombre(nombrepais);
				if (nombre.isEmpty() || tipoViaje.isEmpty() || comboBoxPaises.getSelectedItem().toString().isEmpty() || 
			            descripcion.isEmpty() || servicios.isEmpty() || dateInicio == null || dateFin == null) {
			            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }else {
					mandarViaje( nombre,  tipoViaje,  fecInicio,  fecFin,  dias, descripcion,  servicios,  paises,  id);
					PanelAgencia frame3 = new PanelAgencia(id, nombreID, logoUrl);
					frame3.setVisible(true);
					dispose();
				}
				
			}

			
		});
		btnGuardar.setBounds(443, 537, 95, 47);
		contentPane.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(new Color(73, 120, 171));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				comboBoxViaje.setSelectedItem("");
				dateInicio.setDate(null);
				dateFin.setDate(null);
				comboBoxPaises.setSelectedItem("");
				txtAreaDescripcion.setText("");
				txtAreaServicios.setText("");
			}
		});
		btnBorrar.setBounds(342, 537, 95, 47);
		contentPane.add(btnBorrar);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAgencia frame4 = new PanelAgencia(id, nombreID, logoUrl);
				frame4.setVisible(true);
				dispose();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtras.setBackground(new Color(73, 120, 171));
		btnAtras.setBounds(237, 537, 95, 47);
		contentPane.add(btnAtras);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(574, 27, 199, 209);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);
		
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
        lblLogo.setBounds(0, 0, 199, 209);
        panelLogo.add(lblLogo);

        
        

		// Agregar PropertyChangeListener a los JDateChooser
		PropertyChangeListener listener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				calcularDiferenciaDias();
			}
		};

		dateInicio.addPropertyChangeListener("date", listener);
		dateFin.addPropertyChangeListener("date", listener);
	}

	
	private void calcularDiferenciaDias() {
		
		if (dateInicio.getDate() != null && dateFin.getDate() != null) {
			LocalDate inicio = dateInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate fin = dateFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (inicio.isAfter(fin)) {
				JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.", "Error", JOptionPane.WARNING_MESSAGE);
				txtDias.setText("");
				dateFin.setDate(null);
				return; 
			}

			long diasDiferencia = ChronoUnit.DAYS.between(inicio, fin);
			txtDias.setText(String.valueOf(diasDiferencia));
		} else {
			txtDias.setText("");
		}
	}
	
	public void mandarViaje(String nombre, String tipoViaje, String fecInicio, String fecFin, String dias,
			String descripcion, String servicios, Paises paises, int id) {
		
		Viajes viajes = new Viajes();
		Agencia agencia = new Agencia();
		agencia.setID(id);
		viajes.setNombre(nombre);
		viajes.setDescripcion(descripcion);
		viajes.setDuracion(dias);
		viajes.setFecFin(fecFin);
		viajes.setFecInicio(fecInicio);
		viajes.setPais(paises);
		viajes.setServicios(servicios);
		viajes.setAgencia(agencia);
		
		GestorViajes.crearViaje(viajes);
		
	}
}

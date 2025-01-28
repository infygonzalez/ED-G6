package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class nuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDias;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoViaje frame = new nuevoViaje();
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
	public nuevoViaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(573, 0, 185, 141);

		contentPane.add(lblIcono);
		
		JLabel lblNombreViaje = new JLabel("Nombre viaje:");
		lblNombreViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreViaje.setBounds(71, 64, 121, 35);
		contentPane.add(lblNombreViaje);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(237, 72, 212, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipoViaje = new JLabel("Tipo de viaje:");
		lblTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoViaje.setBounds(71, 110, 121, 35);
		contentPane.add(lblTipoViaje);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Novios", "Senior", "Grupos", "Grandes viajes (destinos exóticos)", "Combinado (vuelo+hotel)", "Escapadas", "Familias con niños menores"}));
		comboBox.setBounds(237, 117, 212, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Días:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(71, 247, 121, 35);
		contentPane.add(lblNewLabel_2);
		
		dateInicio = new JDateChooser();
		dateInicio.setBounds(237, 163, 212, 20);
		contentPane.add(dateInicio);
		
		JLabel lblInicioViaje = new JLabel("Inicio viaje:");
		lblInicioViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInicioViaje.setBounds(71, 152, 121, 35);
		contentPane.add(lblInicioViaje);
		
		dateFin = new JDateChooser();
		dateFin.setBounds(237, 213, 212, 20);
		contentPane.add(dateFin);
		
		JLabel lblFinViaje = new JLabel("Fin viaje:");
		lblFinViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFinViaje.setBounds(71, 201, 121, 35);
		contentPane.add(lblFinViaje);
		
		txtDias = new JTextField();
		txtDias.setBounds(237, 255, 86, 20);
		contentPane.add(txtDias);
		txtDias.setColumns(10);
		txtDias.setEditable(false);
				
		try {
            Date fechaSeleccionada = dateInicio.getDate();
            int dias = Integer.parseInt(txtDias.getText());

            // Usando Calendar para restar días
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaSeleccionada);
            calendario.add(Calendar.DAY_OF_YEAR, - dias);

            // Estableciendo la fecha resultante
            dateFin.setDate(calendario.getTime());
            
        } catch (Exception e) {
        	
        }
	}
	
}

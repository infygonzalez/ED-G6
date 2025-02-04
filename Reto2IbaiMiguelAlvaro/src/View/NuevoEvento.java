package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Scrollbar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import Model.Sesion;
import Model.gestorAgencias;
import Model.gestorEventos;

import com.toedter.components.JLocaleChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEvento;
	private JTextField txtHora;
	private JLabel lblTipoEvento;
	private JComboBox comboBoxTipoEvento;
	private JPanel panelVuelo;
	private JPanel panelVueloVuelta;
	private JPanel panelActividades;
	private JComboBox comboBoxTrayecto;
	private JLabel lblFechaIda;
	private JLabel lblCodigovuelo;
	private JLabel lblAerolinea;
	private JLabel lblPrecio;
	private JLabel lblHoraSalida;
	private JLabel lblDuración;
	private JTextField txtCodigoVuelo;
	private JTextField txtAerolinea;
	private JTextField txtDuracion;
	private JTextField txtCodigoVuelta;
	private JTextField txtAerolineaVuelta;
	private JLabel lblDuracionVuelta;
	private JTextField txtDuracionVuelta;
	private JPanel panelAlojamiento;
	private JLabel lblPrecioAlojamiento;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JTextField txtCiudad;
	private JTextField txtPrecioAlojamiento;
	private JTextField txtPrecioVuelo;
	private JLabel lblPrecioActividad;
	private JTextField txtPrecioActividad;
	private JLabel lblFechaActividad;
	private JDateChooser dateChooserIda_1;

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
					NuevoEvento frame = new NuevoEvento(id, nombreID);
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
	public NuevoEvento(int idAgencia, String nombreID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvento = new JLabel("Nombre de evento:");
		lblEvento.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEvento.setBounds(92, 70, 137, 26);
		contentPane.add(lblEvento);
		
		lblTipoEvento = new JLabel("Tipo de evento:");
		lblTipoEvento.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTipoEvento.setBounds(92, 107, 137, 26);
		contentPane.add(lblTipoEvento);
		
		txtNombreEvento = new JTextField();
		txtNombreEvento.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtNombreEvento.setBounds(309, 75, 185, 20);
		contentPane.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		comboBoxTipoEvento = new JComboBox();
		comboBoxTipoEvento.setFont(new Font("Verdana", Font.PLAIN, 13));
		comboBoxTipoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipoEvento.getSelectedItem().equals("Vuelo")) {
					panelVuelo.setVisible(true);
					panelAlojamiento.setVisible(false);
					panelActividades.setVisible(false);
				} else if(comboBoxTipoEvento.getSelectedItem().equals("Alojamiento")) {
					panelVuelo.setVisible(false);
					panelAlojamiento.setVisible(true);
					panelActividades.setVisible(false);
				} else if(comboBoxTipoEvento.getSelectedItem().equals("Actividad")) {
					panelVuelo.setVisible(false);
					panelAlojamiento.setVisible(false);
					panelActividades.setVisible(true);
				} else if(comboBoxTipoEvento.getSelectedItem().equals("")) {
					panelVuelo.setVisible(false);
					panelAlojamiento.setVisible(false);
					panelActividades.setVisible(false);
				}
				
			}
		});
		comboBoxTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"", "Vuelo", "Alojamiento", "Actividad"}));
		comboBoxTipoEvento.setBounds(309, 111, 185, 22);
		contentPane.add(comboBoxTipoEvento);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipoEvento = comboBoxTipoEvento.getSelectedItem().toString();
				gestorEventos gestor = new gestorEventos();
				gestor.añadirEvento(tipoEvento);
				
				PanelAgencia frame3 = new PanelAgencia(idAgencia, nombreID);
				frame3.setVisible(true);
				dispose();
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardar.setBackground(new Color(73, 120, 171));
		btnGuardar.setBounds(476, 508, 137, 40);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAgencia frame3 = new PanelAgencia(idAgencia, nombreID);
				frame3.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelar.setBackground(new Color(73, 120, 171));
		btnCancelar.setBounds(329, 508, 137, 40);
		contentPane.add(btnCancelar);
		
		panelVuelo = new JPanel();
		panelVuelo.setBounds(0, 131, 939, 365);
		contentPane.add(panelVuelo);
		panelVuelo.setLayout(null);
		panelVuelo.setVisible(false);
		
		panelVueloVuelta = new JPanel();
		panelVueloVuelta.setBounds(532, 126, 397, 202);
		panelVuelo.add(panelVueloVuelta);
		panelVueloVuelta.setLayout(null);
		
		JLabel lblFechaVuelta = new JLabel("Fecha vuelta:");
		lblFechaVuelta.setBounds(0, 0, 109, 17);
		lblFechaVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		panelVueloVuelta.add(lblFechaVuelta);
		
		JDateChooser dateChooserVuelta = new JDateChooser();
		dateChooserVuelta.setBounds(153, 0, 185, 22);
		panelVueloVuelta.add(dateChooserVuelta);
		
		JLabel lblCdigoVueloDe = new JLabel("Código vuelo vuelta:");
		lblCdigoVueloDe.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCdigoVueloDe.setBounds(0, 33, 153, 26);
		panelVueloVuelta.add(lblCdigoVueloDe);
		
		txtCodigoVuelta = new JTextField();
		txtCodigoVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtCodigoVuelta.setColumns(10);
		txtCodigoVuelta.setBounds(153, 38, 185, 20);
		panelVueloVuelta.add(txtCodigoVuelta);
		
		JLabel lblAerolineaVuelta = new JLabel("Aerolinea vuelta:");
		lblAerolineaVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAerolineaVuelta.setBounds(0, 71, 153, 26);
		panelVueloVuelta.add(lblAerolineaVuelta);
		
		txtAerolineaVuelta = new JTextField();
		txtAerolineaVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtAerolineaVuelta.setColumns(10);
		txtAerolineaVuelta.setBounds(153, 76, 185, 20);
		panelVueloVuelta.add(txtAerolineaVuelta);
		
		Calendar then = Calendar.getInstance();
        int hour2 = then.get(Calendar.AM_PM);
        int minute2 = then.get(Calendar.MINUTE);
        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setValue(then.getTime());
        JSpinner spinnerHorarioVuelta1 = new JSpinner(model2);
        spinnerHorarioVuelta1.setFont(new Font("Verdana", Font.PLAIN, 13));
        spinnerHorarioVuelta1.setLocation(153, 110);
        spinnerHorarioVuelta1.setSize(86, 22);
        JSpinner.DateEditor de_spinnerHorarioVuelta= new JSpinner.DateEditor(spinnerHorarioVuelta1, "HH:mm");
        spinnerHorarioVuelta1.setEditor(de_spinnerHorarioVuelta);
        spinnerHorarioVuelta1.setPreferredSize(new Dimension(80, 30));
        panelVueloVuelta.add(spinnerHorarioVuelta1);
		
		JLabel lblHorarioVuelta = new JLabel("Horario vuelta:");
		lblHorarioVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblHorarioVuelta.setBounds(0, 108, 153, 26);
		panelVueloVuelta.add(lblHorarioVuelta);
		
		lblDuracionVuelta = new JLabel("Duracion vuelta:");
		lblDuracionVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDuracionVuelta.setBounds(0, 143, 153, 20);
		panelVueloVuelta.add(lblDuracionVuelta);
		
		txtDuracionVuelta = new JTextField();
		txtDuracionVuelta.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtDuracionVuelta.setColumns(10);
		txtDuracionVuelta.setBounds(153, 145, 86, 20);
		panelVueloVuelta.add(txtDuracionVuelta);
		panelVueloVuelta.setVisible(false);
		
		JLabel lblTrayecto = new JLabel("Trayecto:");
		lblTrayecto.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTrayecto.setBounds(94, 11, 137, 26);
		panelVuelo.add(lblTrayecto);
		
		JLabel lblAeropuertoOrigen = new JLabel("Aeropuerto de origen:");
		lblAeropuertoOrigen.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoOrigen.setBounds(94, 48, 153, 26);
		panelVuelo.add(lblAeropuertoOrigen);
		
		comboBoxTrayecto = new JComboBox();
		comboBoxTrayecto.setFont(new Font("Verdana", Font.PLAIN, 13));
		comboBoxTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTrayecto.getSelectedItem().equals("Ida")) {
					panelVueloVuelta.setVisible(false);
					lblPrecio.setText("Precio: ");
				} else if (comboBoxTrayecto.getSelectedItem().equals("Ida y vuelta")) {
					panelVueloVuelta.setVisible(true);
					lblPrecio.setText("Precio Total: ");
				}
					
			}
		});
		comboBoxTrayecto.setModel(new DefaultComboBoxModel(new String[] {"", "Ida", "Ida y vuelta"}));
		comboBoxTrayecto.setBounds(309, 15, 185, 22);
		panelVuelo.add(comboBoxTrayecto);
		
		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto de destino:");
		lblAeropuertoDestino.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoDestino.setBounds(94, 85, 153, 26);
		panelVuelo.add(lblAeropuertoDestino);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setFont(new Font("Verdana", Font.PLAIN, 13));
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"", "Acapulco", "Lanzarote", "Malaga", "Alicante", "Amman", "Amsterdam", "Atenas", "Barcelona", "Berlin", "Bilbao", "Badajoz", "Bagkok", "Bogota", "Boston", "Bruselas", "Brasilia", "Buenos Aires", "El Cairo", "Casablanca", "Caracas", "Paris, Aeropuerto Charles de Gaulle", "Dinamarca", "Detroit", "Dublin", "Dusseldof", "San Sebastian", "Frankfurt", "Fuenteventura", "La Gomera", "Gerona", "Granada", "Ginebra", "Hamburgo", "Helsinki", "Houston", "Ibiza", "Estambul", "Nueva York", "Kingston", "Los Angeles", "Le Bourget", "La Coruña LCG", "Gatwick", "Heathrow", "PERU, Lima", "Lisboa", "Gran Canaria", "Lyon", "Madrid", "Mahon", "Melbourne", "Mexico D.F", "Miami", "Milan", "Murcia", "Moscu", "Marsella", "Munich", "Nairobi", "Cordoba", "Orly", "Oslo", "Asturias", "Philadelfia PHL", "Palma de Mayorca", "Pamplona", "Praga", "Marrakech", "Reus", "Rio de Janeiro", "Sao Paulo", "Santiago de Compostela", "Santo Domingo", "Santander", "Seatle", "San Francisco", "Salamanca", "Santa Cruz de la Palma", "Standed", "Estocolmo", "Stuttgart", "Sydney", "Tenerife Norte", "Tenerife Sur", "Tunez", "Hierro", "Vigo", "Viena", "Vitoria", "Valencia", "Washington", "Varsovia", "Jerez de la Frontera", "Montreal, Quebec", "Otawwa, Ontario YOW", "Toronto, Ontario YTO", "Vancouver", "Zaragoza", "Zurich"}));
		comboBoxOrigen.setBounds(309, 52, 185, 22);
		panelVuelo.add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setFont(new Font("Verdana", Font.PLAIN, 13));
		comboBoxDestino.setModel(new DefaultComboBoxModel(new String[] {"", "Acapulco", "Lanzarote", "Malaga", "Alicante", "Amman", "Amsterdam", "Atenas", "Barcelona", "Berlin", "Bilbao", "Badajoz", "Bagkok", "Bogota", "Boston", "Bruselas", "Brasilia", "Buenos Aires", "El Cairo", "Casablanca", "Caracas", "Paris, Aeropuerto Charles de Gaulle", "Dinamarca", "Detroit", "Dublin", "Dusseldof", "San Sebastian", "Frankfurt", "Fuenteventura", "La Gomera", "Gerona", "Granada", "Ginebra", "Hamburgo", "Helsinki", "Houston", "Ibiza", "Estambul", "Nueva York", "Kingston", "Los Angeles", "Le Bourget", "La Coruña LCG", "Gatwick", "Heathrow", "PERU, Lima", "Lisboa", "Gran Canaria", "Lyon", "Madrid", "Mahon", "Melbourne", "Mexico D.F", "Miami", "Milan", "Murcia", "Moscu", "Marsella", "Munich", "Nairobi", "Cordoba", "Orly", "Oslo", "Asturias", "Philadelfia PHL", "Palma de Mayorca", "Pamplona", "Praga", "Marrakech", "Reus", "Rio de Janeiro", "Sao Paulo", "Santiago de Compostela", "Santo Domingo", "Santander", "Seatle", "San Francisco", "Salamanca", "Santa Cruz de la Palma", "Standed", "Estocolmo", "Stuttgart", "Sydney", "Tenerife Norte", "Tenerife Sur", "Tunez", "Hierro", "Vigo", "Viena", "Vitoria", "Valencia", "Washington", "Varsovia", "Jerez de la Frontera", "Montreal, Quebec", "Otawwa, Ontario YOW", "Toronto, Ontario YTO", "Vancouver", "Zaragoza", "Zurich"}));
		comboBoxDestino.setBounds(309, 89, 185, 22);
		panelVuelo.add(comboBoxDestino);
		
		lblFechaIda = new JLabel("Fecha Ida:");
		lblFechaIda.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaIda.setBounds(94, 122, 153, 26);
		panelVuelo.add(lblFechaIda);
		
		lblCodigovuelo = new JLabel("Código vuelo:");
		lblCodigovuelo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCodigovuelo.setBounds(94, 159, 153, 26);
		panelVuelo.add(lblCodigovuelo);
		
		lblAerolinea = new JLabel("Aerolinea:");
		lblAerolinea.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAerolinea.setBounds(94, 196, 153, 26);
		panelVuelo.add(lblAerolinea);
		
		lblHoraSalida = new JLabel("Horario salida:");
		lblHoraSalida.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblHoraSalida.setBounds(94, 233, 153, 26);
		panelVuelo.add(lblHoraSalida);
		
		Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(now.getTime());
        JSpinner spinnerHorarioSalida = new JSpinner(model);
        spinnerHorarioSalida.setFont(new Font("Verdana", Font.PLAIN, 13));
        spinnerHorarioSalida.setLocation(309, 237);
        spinnerHorarioSalida.setSize(86, 22);
        JSpinner.DateEditor de_spinnerHorarioSalida = new JSpinner.DateEditor(spinnerHorarioSalida, "HH:mm");
        spinnerHorarioSalida.setEditor(de_spinnerHorarioSalida);
        spinnerHorarioSalida.setPreferredSize(new Dimension(80, 30));
        panelVuelo.add(spinnerHorarioSalida);
		
		lblDuración = new JLabel("Duracion:");
		lblDuración.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDuración.setBounds(94, 270, 153, 20);
		panelVuelo.add(lblDuración);
		
		JDateChooser dateChooserIda = new JDateChooser();
		dateChooserIda.setBounds(309, 126, 185, 22);
		panelVuelo.add(dateChooserIda);
		
		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(309, 164, 185, 20);
		panelVuelo.add(txtCodigoVuelo);
		
		txtAerolinea = new JTextField();
		txtAerolinea.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtAerolinea.setColumns(10);
		txtAerolinea.setBounds(309, 201, 185, 20);
		panelVuelo.add(txtAerolinea);
		
		txtDuracion = new JTextField();
		txtDuracion.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(309, 270, 86, 20);
		panelVuelo.add(txtDuracion);
		
		JButton btnBuscarViaje = new JButton("Buscar Viaje");
		btnBuscarViaje.setForeground(Color.WHITE);
		btnBuscarViaje.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnBuscarViaje.setBackground(new Color(73, 120, 171));
		btnBuscarViaje.setBounds(532, 69, 153, 26);
		panelVuelo.add(btnBuscarViaje);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(94, 302, 153, 26);
		panelVuelo.add(lblPrecio);
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		txtPrecioVuelo = new JTextField();
		txtPrecioVuelo.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtPrecioVuelo.setBounds(309, 307, 86, 20);
		panelVuelo.add(txtPrecioVuelo);
		txtPrecioVuelo.setColumns(10);
		
		panelActividades = new JPanel();
		panelActividades.setBounds(0, 131, 939, 379);
		contentPane.add(panelActividades);
		panelActividades.setLayout(null);
		panelActividades.setVisible(false);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDescripcion.setBounds(94, 11, 137, 26);
		panelActividades.add(lblDescripcion);
		
		JTextArea txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setWrapStyleWord(true);
		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtAreaDescripcion.setBounds(309, 15, 224, 96);
		panelActividades.add(txtAreaDescripcion);
		
		lblPrecioActividad = new JLabel("Precio:");
		lblPrecioActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPrecioActividad.setBounds(94, 122, 153, 26);
		panelActividades.add(lblPrecioActividad);
		
		txtPrecioActividad = new JTextField();
		txtPrecioActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtPrecioActividad.setColumns(10);
		txtPrecioActividad.setBounds(309, 126, 86, 22);
		panelActividades.add(txtPrecioActividad);
		
		lblFechaActividad = new JLabel("Fecha: ");
		lblFechaActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaActividad.setBounds(94, 159, 153, 26);
		panelActividades.add(lblFechaActividad);
		
		dateChooserIda_1 = new JDateChooser();
		dateChooserIda_1.setBounds(309, 164, 185, 20);
		panelActividades.add(dateChooserIda_1);
		
		panelAlojamiento = new JPanel();
		panelAlojamiento.setBounds(0, 133, 949, 352);
		contentPane.add(panelAlojamiento);
		panelAlojamiento.setLayout(null);
		panelAlojamiento.setVisible(false);
		
		JLabel lblTipoAlojamiento = new JLabel("Tipo Alojameinto:");
		lblTipoAlojamiento.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTipoAlojamiento.setBounds(94, 11, 137, 26);
		panelAlojamiento.add(lblTipoAlojamiento);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCiudad.setBounds(94, 48, 153, 26);
		panelAlojamiento.add(lblCiudad);
		
		lblPrecioAlojamiento = new JLabel("Precio: ");
		lblPrecioAlojamiento.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPrecioAlojamiento.setBounds(94, 85, 153, 26);
		panelAlojamiento.add(lblPrecioAlojamiento);
		
		lblFechaEntrada = new JLabel("Fecha entrada:");
		lblFechaEntrada.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaEntrada.setBounds(94, 122, 153, 26);
		panelAlojamiento.add(lblFechaEntrada);
		
		lblFechaSalida = new JLabel("Fecha salida:");
		lblFechaSalida.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaSalida.setBounds(580, 122, 153, 26);
		panelAlojamiento.add(lblFechaSalida);
		
		JDateChooser dateChooserFechaEntrada = new JDateChooser();
		dateChooserFechaEntrada.setBounds(309, 126, 185, 22);
		panelAlojamiento.add(dateChooserFechaEntrada);
		
		JDateChooser dateChooserFechaSalida = new JDateChooser();
		dateChooserFechaSalida.setBounds(684, 126, 185, 22);
		panelAlojamiento.add(dateChooserFechaSalida);
		
		JComboBox comboBoxTipoAlojamiento = new JComboBox();
		comboBoxTipoAlojamiento.setFont(new Font("Verdana", Font.PLAIN, 13));
		comboBoxTipoAlojamiento.setModel(new DefaultComboBoxModel(new String[] {"Habitación doble", "Habitación  Individual", "Habitación  Doble (individual)", "Habitación  Triple"}));
		comboBoxTipoAlojamiento.setBounds(309, 13, 185, 22);
		panelAlojamiento.add(comboBoxTipoAlojamiento);
		
		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(309, 52, 185, 22);
		panelAlojamiento.add(txtCiudad);
		
		txtPrecioAlojamiento = new JTextField();
		txtPrecioAlojamiento.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtPrecioAlojamiento.setColumns(10);
		txtPrecioAlojamiento.setBounds(309, 89, 86, 20);
		panelAlojamiento.add(txtPrecioAlojamiento);
		
		JButton btnBuscarAlojamiento = new JButton("Buscar Alojamiento");
		btnBuscarAlojamiento.setForeground(Color.WHITE);
		btnBuscarAlojamiento.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnBuscarAlojamiento.setBackground(new Color(73, 120, 171));
		btnBuscarAlojamiento.setBounds(94, 159, 160, 28);
		panelAlojamiento.add(btnBuscarAlojamiento);
		panelActividades.setVisible(false);
		
		
		
		
	}
}

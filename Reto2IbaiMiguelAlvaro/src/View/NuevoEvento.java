package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Scrollbar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;
import com.toedter.components.JLocaleChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEvento;
	private JTextField txtCodigoVuelo;
	private JTextField txtAerolinea;
	private JTextField txtPrecio;
	private JTextField txtHora;
	private JTextField txtDuracion;
	private JLabel lblTipoEvento;
	private JComboBox comboBoxTipoEvento;
	private JLabel lblTrayecto;
	private JComboBox comboBoxTrayecto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoEvento frame = new NuevoEvento();
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
	public NuevoEvento() {
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
		txtNombreEvento.setBounds(309, 75, 185, 20);
		contentPane.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		comboBoxTipoEvento = new JComboBox();
		comboBoxTipoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipoEvento.getSelectedItem().equals("vuelo")) {
					lblTrayecto.setVisible(true);
					comboBoxTrayecto.setVisible(true);
				}
			}
		});
		comboBoxTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"", "Vuelo", "Alojamiento", "Actividad"}));
		comboBoxTipoEvento.setBounds(309, 111, 185, 22);
		contentPane.add(comboBoxTipoEvento);
		
		
		lblTrayecto = new JLabel("Trayecto:");
		lblTrayecto.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTrayecto.setBounds(92, 144, 137, 26);
		contentPane.add(lblTrayecto);
		lblTrayecto.setVisible(false);
		
		comboBoxTrayecto = new JComboBox();
		comboBoxTrayecto.setModel(new DefaultComboBoxModel(new String[] {"", "Ida", "Ida y vuelta"}));
		comboBoxTrayecto.setBounds(309, 148, 185, 22);
		contentPane.add(comboBoxTrayecto);
		comboBoxTrayecto.setVisible(false);
		
		JLabel lblAeropuertoOrigen = new JLabel("Aeropuerto de origen:");
		lblAeropuertoOrigen.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoOrigen.setBounds(92, 181, 153, 26);
		contentPane.add(lblAeropuertoOrigen);
		lblAeropuertoOrigen.setVisible(false);
		
		JComboBox comboBoxAeropuertoOrigen = new JComboBox();
		comboBoxAeropuertoOrigen.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante  \tALC", "Asturias \tOVD", "Barcelona\tBCN", "Córdoba \tODB", "Gerona \t\tGRO", "Granada \tGRX", "Ibiza \t\tIBZ", "La Coruña \tLCG", "Lanzarote \tACE", "Madrid\t\tMAD", "MAHON\tMAH", "Murcia \t\tMJV", "Pamplona \tPNA", "Salamanca \tSLM", "Santa Cruz de la Palma \t\tSPC", "Santiago de Compostela \tSCQ", "Valencia \tVLC", "Vigo \tVGO", "Zaragoza\tZAZ", "Badajoz \tBJZ", "Bilbao\tBIO", "VITORIA\tVIT", "Tenerife Norte \tTFN", "Tenerife Sur \tTFS", "SANTANDER\tSDR", "SAN SEBASTIAN\tEAS", "REUS\tREU", "PALMA DE MALLORCA\tPMI", "MALAGA\tAGP", "JEREZ DE LA FRONTERA\tXRY", "GRAN CANARIA \tLPA", "FUERTEVENTURA\tFUE", "HIERRO \tVDE", "LA GOMERA\tGMZ", "Montreal, Québec \tYMQ", " CANADA Ottawa, Ontario YOW\tYOW", "CANADA Toronto, Ontario YTO\tYTO", "CANADA VANCOUVER  \tYVR", "Boston \tBOS", "Houston \tHOU", "Miami\tMIA", "LOS ANGELES\tLAX", "Nueva York \t JFK", "DETROIT\tDTT", "Philadelphia PHL \tPHL", "SAN FRANCISCO\tSFO", "Seattle \tSEA", "WASHINGTON\tWAS", " REPUBLICA DOMINICANA (Santo Domingo) \tSDQ", "JAMAICA (kingston)\tKIN", "Buenos Aires \tBUE", "BRASIL (Rio de Janeiro )\tRIO", " BRASIL (Sao Paulo )\tSAO", "COLOMBIA Bogotá \tBOG", "PERU ( Lima)\tLIM", "VENEZUELA ( CARACAS)\tCCS", "AUSTRIA (Viena )\tVIE", "REPUBLICA CHECA (Praga )\tPRG", "FINLANDIA (Helsinki )\tHEL", "FRANCIA (lyon)\tLYS", "FRANCIA,París (aeropuerto Charles de Gaulle)\tCDG", "FRANCIA ,Le Bourget,\tLBG", "FRANCIA (ORLY)\tORY", "FRANCIA (Marsella)\tMRS", "ALEMANIA (Berlín )\tBER", "ALEMANIA (Dusseldorf )\tDUS", "ALEMANIA (Frankfurt )\tFRA", "ALEMANIA (Munich )\tMUC", "ALEMANIA (hamburgo)\tHAM", "GRECIA ( Atenas)\tATH", "IRLANDA (DUBLIN)\tDUB", " ITALIA (Milán )\tMIL", "BOSTON\tBOS", "DETROIT\tDTT", " San Francisco\tSFO", " México D.F.\tMEX", "MÉXICO (ACAPULCO)\tACA", "BRASIL (brasilia)\tBSB", "Washington\tWAS", "ALEMANIA (Stuttgart) \tSTR", "SAN FRANCISCO\tSFO", "DINAMARCA \tCPH", "BELGICA (Bruselas )\tBRU", "HOLANDA Amsterdam \tAMS", "NORUEGA (oslo)\tOSL", "POLONIA (Varsovia ) WAW \tWAW", "PORTUGAL (lisboa)\tLIS", "SUECIA (Estocolmo)\tSTO", " RUSIA (Moscú ) MOW \tMOW", "SUIZA (Ginebra )\tGVA", "SUIZA (Zurich)\tZRH", "TURQUIA (ESTAMBUL)\tIST", "LONDRES (GATWICK)\tLGH", "LONDRES Heathrow\tLHR", "LONDRES ( Stanted)\tSTN", " EGIPTO El Cairo \tCAI", "KENIA ( Nairobi)\tNBO", " MARRUECOS (Casablanca) \tCAS", "MARRUECOS (Marrakech)\tRAK", "Túnez \tTUN", "JORDANIA (Ammán ) AMM\tAMM", "TAILANDIA Bagkok \tBKK", " AUSTRALIA Melbourne \tMEL", "AUSTRALIA (SIYNEY)\tSYD"}));
		comboBoxAeropuertoOrigen.setBounds(309, 185, 304, 22);
		contentPane.add(comboBoxAeropuertoOrigen);
		comboBoxAeropuertoOrigen.setVisible(false);
		
		JComboBox comboBoxAeropuertoDestino = new JComboBox();
		comboBoxAeropuertoDestino.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante \tALC", "Asturias \tOVD", "Barcelona\tBCN", "Córdoba \tODB", "Gerona \tGRO", "Granada \tGRX", "Ibiza \tIBZ", "La Coruña LCG\tLCG", "Lanzarote \tACE", "Madrid\tMAD", "MAHON\tMAH", "Murcia \tMJV", "Pamplona \tPNA", "Salamanca \tSLM", "Santa Cruz de la Palma \tSPC", "Santiago de Compostela \tSCQ", "Valencia \tVLC", "Vigo \tVGO", "Zaragoza\tZAZ", "Badajoz \tBJZ", "Bilbao\tBIO", "VITORIA\tVIT", "Tenerife Norte \tTFN", "Tenerife Sur \tTFS", "SANTANDER\tSDR", "SAN SEBASTIAN\tEAS", "REUS\tREU", "PALMA DE MALLORCA\tPMI", "MALAGA\tAGP", "JEREZ DE LA FRONTERA\tXRY", "GRAN CANARIA \tLPA", "FUERTEVENTURA\tFUE", "HIERRO \tVDE", "LA GOMERA\tGMZ", "Montreal, Québec \tYMQ", " CANADA Ottawa, Ontario YOW\tYOW", "CANADA Toronto, Ontario YTO\tYTO", "CANADA VANCOUVER  \tYVR", "Boston \tBOS", "Houston \tHOU", "Miami\tMIA", "LOS ANGELES\tLAX", "Nueva York \t JFK", "DETROIT\tDTT", "Philadelphia PHL \tPHL", "SAN FRANCISCO\tSFO", "Seattle \tSEA", "WASHINGTON\tWAS", " REPUBLICA DOMINICANA (Santo Domingo) \tSDQ", "JAMAICA (kingston)\tKIN", "Buenos Aires \tBUE", "BRASIL (Rio de Janeiro )\tRIO", " BRASIL (Sao Paulo )\tSAO", "COLOMBIA Bogotá \tBOG", "PERU ( Lima)\tLIM", "VENEZUELA ( CARACAS)\tCCS", "AUSTRIA (Viena )\tVIE", "REPUBLICA CHECA (Praga )\tPRG", "FINLANDIA (Helsinki )\tHEL", "FRANCIA (lyon)\tLYS", "FRANCIA,París (aeropuerto Charles de Gaulle)\tCDG", "FRANCIA ,Le Bourget,\tLBG", "FRANCIA (ORLY)\tORY", "FRANCIA (Marsella)\tMRS", "ALEMANIA (Berlín )\tBER", "ALEMANIA (Dusseldorf )\tDUS", "ALEMANIA (Frankfurt )\tFRA", "ALEMANIA (Munich )\tMUC", "ALEMANIA (hamburgo)\tHAM", "GRECIA ( Atenas)\tATH", "IRLANDA (DUBLIN)\tDUB", " ITALIA (Milán )\tMIL", "BOSTON\tBOS", "DETROIT\tDTT", " San Francisco\tSFO", " México D.F.\tMEX", "MÉXICO (ACAPULCO)\tACA", "BRASIL (brasilia)\tBSB", "Washington\tWAS", "ALEMANIA (Stuttgart) \tSTR", "SAN FRANCISCO\tSFO", "DINAMARCA \tCPH", "BELGICA (Bruselas )\tBRU", "HOLANDA Amsterdam \tAMS", "NORUEGA (oslo)\tOSL", "POLONIA (Varsovia ) WAW \tWAW", "PORTUGAL (lisboa)\tLIS", "SUECIA (Estocolmo)\tSTO", " RUSIA (Moscú ) MOW \tMOW", "SUIZA (Ginebra )\tGVA", "SUIZA (Zurich)\tZRH", "TURQUIA (ESTAMBUL)\tIST", "LONDRES (GATWICK)\tLGH", "LONDRES Heathrow\tLHR", "LONDRES ( Stanted)\tSTN", " EGIPTO El Cairo \tCAI", "KENIA ( Nairobi)\tNBO", " MARRUECOS (Casablanca) \tCAS", "MARRUECOS (Marrakech)\tRAK", "Túnez \tTUN", "JORDANIA (Ammán ) AMM\tAMM", "TAILANDIA Bagkok \tBKK", " AUSTRALIA Melbourne \tMEL", "AUSTRALIA (SIYNEY)\tSYD"}));
		comboBoxAeropuertoDestino.setBounds(309, 219, 304, 22);
		contentPane.add(comboBoxAeropuertoDestino);
		comboBoxAeropuertoDestino.setVisible(false);
		
		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto de destino:");
		lblAeropuertoDestino.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoDestino.setBounds(92, 215, 153, 26);
		contentPane.add(lblAeropuertoDestino);
		lblAeropuertoDestino.setVisible(false);
		
		JLabel lblFechaIda = new JLabel("Fecha de ida:");
		lblFechaIda.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaIda.setBounds(92, 252, 153, 26);
		contentPane.add(lblFechaIda);
		lblFechaIda.setVisible(false);

		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(309, 258, 185, 20);
		contentPane.add(dateChooser);
		dateChooser.setVisible(false);
		
		JLabel lblCodigoVuelo = new JLabel("Código del vuelo:");
		lblCodigoVuelo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCodigoVuelo.setBounds(92, 289, 153, 26);
		contentPane.add(lblCodigoVuelo);
		lblCodigoVuelo.setVisible(false);
		
		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setBounds(309, 294, 86, 20);
		contentPane.add(txtCodigoVuelo);
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setVisible(false);
		
		JLabel lblAerolinea = new JLabel("Aerolínea:");
		lblAerolinea.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAerolinea.setBounds(92, 326, 153, 26);
		contentPane.add(lblAerolinea);
		lblAerolinea.setVisible(false);
		
		txtAerolinea = new JTextField();
		txtAerolinea.setBounds(309, 331, 185, 20);
		contentPane.add(txtAerolinea);
		txtAerolinea.setColumns(10);
		txtAerolinea.setVisible(false);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(309, 362, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setVisible(false);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPrecio.setBounds(92, 363, 153, 26);
		contentPane.add(lblPrecio);
		lblPrecio.setVisible(false);
		
		JLabel lblHoraSalida = new JLabel("Hora de salida (hh:mm):");
		lblHoraSalida.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblHoraSalida.setBounds(92, 400, 167, 26);
		contentPane.add(lblHoraSalida);
		lblHoraSalida.setVisible(false);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(309, 405, 86, 20);
		contentPane.add(txtHora);
		txtHora.setVisible(false);
		
		JLabel lblDuracion = new JLabel("Duración n(hh:mm):");
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDuracion.setBounds(92, 431, 153, 26);
		contentPane.add(lblDuracion);
		lblDuracion.setVisible(false);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(309, 436, 86, 20);
		contentPane.add(txtDuracion);
		txtDuracion.setVisible(false);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardar.setBackground(new Color(73, 120, 171));
		btnGuardar.setBounds(476, 508, 137, 40);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelar.setBackground(new Color(73, 120, 171));
		btnCancelar.setBounds(329, 508, 137, 40);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
		
		
		
		
	}
}

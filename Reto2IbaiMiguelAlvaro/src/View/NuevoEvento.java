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

import com.toedter.components.JLocaleChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Calendar;
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
		txtNombreEvento.setBounds(309, 75, 185, 20);
		contentPane.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		comboBoxTipoEvento = new JComboBox();
		comboBoxTipoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipoEvento.getSelectedItem().equals("vuelo")) {
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
		
		comboBoxTrayecto = new JComboBox();
		comboBoxTrayecto.setModel(new DefaultComboBoxModel(new String[] {"", "Ida", "Ida y vuelta"}));
		comboBoxTrayecto.setBounds(309, 148, 185, 22);
		contentPane.add(comboBoxTrayecto);
		
		JLabel lblAeropuertoOrigen = new JLabel("Aeropuerto de origen:");
		lblAeropuertoOrigen.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoOrigen.setBounds(92, 181, 153, 26);
		contentPane.add(lblAeropuertoOrigen);
		
		JComboBox comboBoxAeropuertoOrigen = new JComboBox();
		comboBoxAeropuertoOrigen.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante  \tALC", "Asturias \tOVD", "Barcelona\tBCN", "Córdoba \tODB", "Gerona \t\tGRO", "Granada \tGRX", "Ibiza \t\tIBZ", "La Coruña \tLCG", "Lanzarote \tACE", "Madrid\t\tMAD", "MAHON\tMAH", "Murcia \t\tMJV", "Pamplona \tPNA", "Salamanca \tSLM", "Santa Cruz de la Palma \t\tSPC", "Santiago de Compostela \tSCQ", "Valencia \tVLC", "Vigo \tVGO", "Zaragoza\tZAZ", "Badajoz \tBJZ", "Bilbao\tBIO", "VITORIA\tVIT", "Tenerife Norte \tTFN", "Tenerife Sur \tTFS", "SANTANDER\tSDR", "SAN SEBASTIAN\tEAS", "REUS\tREU", "PALMA DE MALLORCA\tPMI", "MALAGA\tAGP", "JEREZ DE LA FRONTERA\tXRY", "GRAN CANARIA \tLPA", "FUERTEVENTURA\tFUE", "HIERRO \tVDE", "LA GOMERA\tGMZ", "Montreal, Québec \tYMQ", " CANADA Ottawa, Ontario YOW\tYOW", "CANADA Toronto, Ontario YTO\tYTO", "CANADA VANCOUVER  \tYVR", "Boston \tBOS", "Houston \tHOU", "Miami\tMIA", "LOS ANGELES\tLAX", "Nueva York \t JFK", "DETROIT\tDTT", "Philadelphia PHL \tPHL", "SAN FRANCISCO\tSFO", "Seattle \tSEA", "WASHINGTON\tWAS", " REPUBLICA DOMINICANA (Santo Domingo) \tSDQ", "JAMAICA (kingston)\tKIN", "Buenos Aires \tBUE", "BRASIL (Rio de Janeiro )\tRIO", " BRASIL (Sao Paulo )\tSAO", "COLOMBIA Bogotá \tBOG", "PERU ( Lima)\tLIM", "VENEZUELA ( CARACAS)\tCCS", "AUSTRIA (Viena )\tVIE", "REPUBLICA CHECA (Praga )\tPRG", "FINLANDIA (Helsinki )\tHEL", "FRANCIA (lyon)\tLYS", "FRANCIA,París (aeropuerto Charles de Gaulle)\tCDG", "FRANCIA ,Le Bourget,\tLBG", "FRANCIA (ORLY)\tORY", "FRANCIA (Marsella)\tMRS", "ALEMANIA (Berlín )\tBER", "ALEMANIA (Dusseldorf )\tDUS", "ALEMANIA (Frankfurt )\tFRA", "ALEMANIA (Munich )\tMUC", "ALEMANIA (hamburgo)\tHAM", "GRECIA ( Atenas)\tATH", "IRLANDA (DUBLIN)\tDUB", " ITALIA (Milán )\tMIL", "BOSTON\tBOS", "DETROIT\tDTT", " San Francisco\tSFO", " México D.F.\tMEX", "MÉXICO (ACAPULCO)\tACA", "BRASIL (brasilia)\tBSB", "Washington\tWAS", "ALEMANIA (Stuttgart) \tSTR", "SAN FRANCISCO\tSFO", "DINAMARCA \tCPH", "BELGICA (Bruselas )\tBRU", "HOLANDA Amsterdam \tAMS", "NORUEGA (oslo)\tOSL", "POLONIA (Varsovia ) WAW \tWAW", "PORTUGAL (lisboa)\tLIS", "SUECIA (Estocolmo)\tSTO", " RUSIA (Moscú ) MOW \tMOW", "SUIZA (Ginebra )\tGVA", "SUIZA (Zurich)\tZRH", "TURQUIA (ESTAMBUL)\tIST", "LONDRES (GATWICK)\tLGH", "LONDRES Heathrow\tLHR", "LONDRES ( Stanted)\tSTN", " EGIPTO El Cairo \tCAI", "KENIA ( Nairobi)\tNBO", " MARRUECOS (Casablanca) \tCAS", "MARRUECOS (Marrakech)\tRAK", "Túnez \tTUN", "JORDANIA (Ammán ) AMM\tAMM", "TAILANDIA Bagkok \tBKK", " AUSTRALIA Melbourne \tMEL", "AUSTRALIA (SIYNEY)\tSYD"}));
		comboBoxAeropuertoOrigen.setBounds(309, 185, 304, 22);
		contentPane.add(comboBoxAeropuertoOrigen);
		
		JComboBox comboBoxAeropuertoDestino = new JComboBox();
		comboBoxAeropuertoDestino.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante \tALC", "Asturias \tOVD", "Barcelona\tBCN", "Córdoba \tODB", "Gerona \tGRO", "Granada \tGRX", "Ibiza \tIBZ", "La Coruña LCG\tLCG", "Lanzarote \tACE", "Madrid\tMAD", "MAHON\tMAH", "Murcia \tMJV", "Pamplona \tPNA", "Salamanca \tSLM", "Santa Cruz de la Palma \tSPC", "Santiago de Compostela \tSCQ", "Valencia \tVLC", "Vigo \tVGO", "Zaragoza\tZAZ", "Badajoz \tBJZ", "Bilbao\tBIO", "VITORIA\tVIT", "Tenerife Norte \tTFN", "Tenerife Sur \tTFS", "SANTANDER\tSDR", "SAN SEBASTIAN\tEAS", "REUS\tREU", "PALMA DE MALLORCA\tPMI", "MALAGA\tAGP", "JEREZ DE LA FRONTERA\tXRY", "GRAN CANARIA \tLPA", "FUERTEVENTURA\tFUE", "HIERRO \tVDE", "LA GOMERA\tGMZ", "Montreal, Québec \tYMQ", " CANADA Ottawa, Ontario YOW\tYOW", "CANADA Toronto, Ontario YTO\tYTO", "CANADA VANCOUVER  \tYVR", "Boston \tBOS", "Houston \tHOU", "Miami\tMIA", "LOS ANGELES\tLAX", "Nueva York \t JFK", "DETROIT\tDTT", "Philadelphia PHL \tPHL", "SAN FRANCISCO\tSFO", "Seattle \tSEA", "WASHINGTON\tWAS", " REPUBLICA DOMINICANA (Santo Domingo) \tSDQ", "JAMAICA (kingston)\tKIN", "Buenos Aires \tBUE", "BRASIL (Rio de Janeiro )\tRIO", " BRASIL (Sao Paulo )\tSAO", "COLOMBIA Bogotá \tBOG", "PERU ( Lima)\tLIM", "VENEZUELA ( CARACAS)\tCCS", "AUSTRIA (Viena )\tVIE", "REPUBLICA CHECA (Praga )\tPRG", "FINLANDIA (Helsinki )\tHEL", "FRANCIA (lyon)\tLYS", "FRANCIA,París (aeropuerto Charles de Gaulle)\tCDG", "FRANCIA ,Le Bourget,\tLBG", "FRANCIA (ORLY)\tORY", "FRANCIA (Marsella)\tMRS", "ALEMANIA (Berlín )\tBER", "ALEMANIA (Dusseldorf )\tDUS", "ALEMANIA (Frankfurt )\tFRA", "ALEMANIA (Munich )\tMUC", "ALEMANIA (hamburgo)\tHAM", "GRECIA ( Atenas)\tATH", "IRLANDA (DUBLIN)\tDUB", " ITALIA (Milán )\tMIL", "BOSTON\tBOS", "DETROIT\tDTT", " San Francisco\tSFO", " México D.F.\tMEX", "MÉXICO (ACAPULCO)\tACA", "BRASIL (brasilia)\tBSB", "Washington\tWAS", "ALEMANIA (Stuttgart) \tSTR", "SAN FRANCISCO\tSFO", "DINAMARCA \tCPH", "BELGICA (Bruselas )\tBRU", "HOLANDA Amsterdam \tAMS", "NORUEGA (oslo)\tOSL", "POLONIA (Varsovia ) WAW \tWAW", "PORTUGAL (lisboa)\tLIS", "SUECIA (Estocolmo)\tSTO", " RUSIA (Moscú ) MOW \tMOW", "SUIZA (Ginebra )\tGVA", "SUIZA (Zurich)\tZRH", "TURQUIA (ESTAMBUL)\tIST", "LONDRES (GATWICK)\tLGH", "LONDRES Heathrow\tLHR", "LONDRES ( Stanted)\tSTN", " EGIPTO El Cairo \tCAI", "KENIA ( Nairobi)\tNBO", " MARRUECOS (Casablanca) \tCAS", "MARRUECOS (Marrakech)\tRAK", "Túnez \tTUN", "JORDANIA (Ammán ) AMM\tAMM", "TAILANDIA Bagkok \tBKK", " AUSTRALIA Melbourne \tMEL", "AUSTRALIA (SIYNEY)\tSYD"}));
		comboBoxAeropuertoDestino.setBounds(309, 219, 304, 22);
		contentPane.add(comboBoxAeropuertoDestino);
		
		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto de destino:");
		lblAeropuertoDestino.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAeropuertoDestino.setBounds(92, 215, 153, 26);
		contentPane.add(lblAeropuertoDestino);
		
		JLabel lblFechaIda = new JLabel("Fecha de ida:");
		lblFechaIda.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFechaIda.setBounds(92, 252, 153, 26);
		contentPane.add(lblFechaIda);

		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(309, 258, 185, 20);
		contentPane.add(dateChooser);
		
		JLabel lblCodigoVuelo = new JLabel("Código del vuelo:");
		lblCodigoVuelo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCodigoVuelo.setBounds(92, 289, 153, 26);
		contentPane.add(lblCodigoVuelo);
		
		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setBounds(309, 294, 86, 20);
		contentPane.add(txtCodigoVuelo);
		txtCodigoVuelo.setColumns(10);
		
		JLabel lblAerolinea = new JLabel("Aerolínea:");
		lblAerolinea.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblAerolinea.setBounds(92, 326, 153, 26);
		contentPane.add(lblAerolinea);
		
		txtAerolinea = new JTextField();
		txtAerolinea.setBounds(309, 331, 185, 20);
		contentPane.add(txtAerolinea);
		txtAerolinea.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(309, 362, 86, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblPrecio.setBounds(92, 363, 153, 26);
		contentPane.add(lblPrecio);
		
		JLabel lblHoraSalida = new JLabel("Hora de salida (hh:mm):");
		lblHoraSalida.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblHoraSalida.setBounds(92, 393, 167, 26);
		contentPane.add(lblHoraSalida);
		
		Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(now.getTime());
        JSpinner spinner = new JSpinner(model);
        spinner.setLocation(309, 393);
        spinner.setSize(86, 26);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(editor);
        spinner.setPreferredSize(new Dimension(80, 30));
		contentPane.add(spinner);
		
		JLabel lblDuracion = new JLabel("Duración n(hh:mm):");
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDuracion.setBounds(92, 431, 153, 26);
		contentPane.add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(309, 436, 86, 20);
		contentPane.add(txtDuracion);
		
		JButton btnGuardar = new JButton("Guardar");
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
		
		
		
		
	}
}

package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Agencia;
import Model.gestorAgencias;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.JTextField;


public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private login panelogin;
	private JLabel lblTextoBienvenida;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			Agencia agencia = new Agencia();
			public void run() {
				try {
					Bienvenida frame = new Bienvenida(agencia);
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
	public Bienvenida(Agencia agencia) {
		setTitle("Viajes Erreka-Mari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		URL imgURL = getClass().getClassLoader().getResource("Gemini_Generated_Image_tbwwatbwwatbwwat(2).jpg");
		panelogin = new login(agencia);
		panelogin.setLayout(new BorderLayout());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTextoBienvenida = new JLabel("Bienvenido (Click para iniciar sesion)");
		lblTextoBienvenida.setLabelFor(contentPane);
		lblTextoBienvenida.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTextoBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoBienvenida.setBounds(37, 11, 360, 69);
		contentPane.add(lblTextoBienvenida);
		
		ImageIcon icono = new ImageIcon(imgURL);
		JButton btnBienvenida = new JButton(icono);
		btnBienvenida.setContentAreaFilled(false); // No dibuja fondo para mostrar la imagen
        btnBienvenida.setBorderPainted(false);    // No dibuja borde
		btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(panelogin);
				revalidate(); // Revalidar el JFrame para que se actualice
                repaint();    // Repaint para que el cambio sea reflejado
			}
		});
		btnBienvenida.setBounds(0, 0, 434, 261);
		contentPane.add(btnBienvenida);
	}
}

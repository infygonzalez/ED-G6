package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private login panelogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setTitle("Viajes Erreka-Mari");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		URL imgURL = getClass().getClassLoader().getResource("Gemini_Generated_Image_tbwwatbwwatbwwat(2).jpg");
		panelogin = new login();
		panelogin.setLayout(new BorderLayout());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextoBienvenida = new JLabel("Bienvenido (Click para iniciar sesion)");
		lblTextoBienvenida.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTextoBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoBienvenida.setBounds(38, 87, 360, 69);
		contentPane.add(lblTextoBienvenida);
		
		ImageIcon icono = new ImageIcon(imgURL);
		JButton btnBienvenida = new JButton(icono);
		
		btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(panelogin);
				revalidate(); // Revalidar el JFrame para que se actualice
                repaint();    // Repaint para que el cambio sea reflejado
			}
		});
		btnBienvenida.setVerticalAlignment(SwingConstants.TOP);
		btnBienvenida.setBounds(0, 0, 434, 261);
		contentPane.add(btnBienvenida);
	}
}

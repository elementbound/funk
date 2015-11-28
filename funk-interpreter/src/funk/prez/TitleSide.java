package funk.prez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Window.Type;

public class TitleSide {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleSide window = new TitleSide();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TitleSide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Funk Presentation");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPageTitle = new JLabel("Page Title");
		lblPageTitle.setForeground(Color.WHITE);
		lblPageTitle.setBackground(Color.BLACK);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().add(lblPageTitle, BorderLayout.NORTH);
		
		JLabel lblSecondaryTitle = new JLabel("Secondary Title");
		lblSecondaryTitle.setForeground(Color.LIGHT_GRAY);
		lblSecondaryTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSecondaryTitle.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblSecondaryTitle, BorderLayout.WEST);
	}

}

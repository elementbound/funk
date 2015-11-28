package funk.prez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class ListSlide {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListSlide window = new ListSlide();
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
	public ListSlide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblPageTitle = new JLabel("Page Title");
		lblPageTitle.setVerticalAlignment(SwingConstants.TOP);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblPageTitle.setForeground(Color.WHITE);
		frame.getContentPane().add(lblPageTitle, BorderLayout.NORTH);
		
		JPanel ohGodWhyPanel = new JPanel();
		ohGodWhyPanel.setBackground(Color.BLACK);
		frame.getContentPane().add(ohGodWhyPanel, BorderLayout.CENTER);
		ohGodWhyPanel.setLayout(null);
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(32, 0, 434, 222);
		ohGodWhyPanel.add(textPanel);
		textPanel.setBackground(Color.BLACK);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		
		JPanel bulletPointPanel = new JPanel();
		bulletPointPanel.setForeground(new Color(255, 255, 255));
		bulletPointPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		bulletPointPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		bulletPointPanel.setBackground(Color.BLACK);
		textPanel.add(bulletPointPanel);
		bulletPointPanel.setLayout(new BoxLayout(bulletPointPanel, BoxLayout.X_AXIS));
		
		JLabel lblDot = new JLabel("\u2022 ");
		lblDot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDot.setForeground(Color.LIGHT_GRAY);
		bulletPointPanel.add(lblDot);
		
		JLabel lblBulletPoint = new JLabel("Bullet point");
		bulletPointPanel.add(lblBulletPoint);
		lblBulletPoint.setForeground(Color.WHITE);
		lblBulletPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBulletPoint.setVerticalAlignment(SwingConstants.TOP);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

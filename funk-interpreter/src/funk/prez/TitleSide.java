package funk.prez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import javafx.scene.input.KeyCode;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TitleSide {

	private JFrame frame;

	private String title = "Page title";
	private String sectitle = "Secondary title";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleSide window = new TitleSide();
					
					window.setTitle("Funk Symbol Table Support");
					window.setSecondaryTitle("Presentation now with 70% more plot twist!");
					
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setSecondaryTitle(String title) {
		this.sectitle = title;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void show() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println("Next slide!");
				else if(arg0.getKeyCode() == KeyEvent.VK_UP && arg0.isControlDown())
					System.out.println("Fullscreen!");
				else if(arg0.getKeyCode() == KeyEvent.VK_DOWN && arg0.isControlDown())
					System.out.println("Windowed!");
			}
		});
		
		frame.setTitle("Funk Presentation");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPageTitle = new JLabel(title);
		lblPageTitle.setForeground(Color.WHITE);
		lblPageTitle.setBackground(Color.BLACK);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().add(lblPageTitle, BorderLayout.NORTH);
		
		JLabel lblSecondaryTitle = new JLabel("    "+sectitle);
		lblSecondaryTitle.setForeground(Color.LIGHT_GRAY);
		lblSecondaryTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSecondaryTitle.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblSecondaryTitle, BorderLayout.WEST);
		
		frame.setVisible(true);
	}

}

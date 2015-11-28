package funk.prez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

public class ListSlide extends Slide {
	private JFrame frame;
	
	private String title = "Page Title"; 
	private List<String> bulletPointTexts = new ArrayList<>();
	
	public void setTitle(String title) {
		this.title = title; 
	}
	
	public void addBullet(String text) {
		bulletPointTexts.add(text);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListSlide window = new ListSlide();
					
					window.setTitle("Attenshun!");
					window.addBullet("Shit's gonna go down!");
					window.addBullet("Right on this slide!");
					window.addBullet("Brace yourselves!");
					
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public ListSlide() {
		frame = null;
		resetFrame();
	}
	
	public void show() {
		JLabel lblPageTitle = new JLabel(title);
		lblPageTitle.setVerticalAlignment(SwingConstants.TOP);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblPageTitle.setForeground(Color.WHITE);
		frame.getContentPane().add(lblPageTitle, BorderLayout.NORTH);
		
		JPanel ohGodWhyPanel = new JPanel();
		ohGodWhyPanel.setBackground(Color.BLACK);
		frame.getContentPane().add(ohGodWhyPanel, BorderLayout.CENTER);
		ohGodWhyPanel.setLayout(null);
		
		JPanel textPanel = new JPanel();
		textPanel.setBounds(32, 16, 434, 222);
		ohGodWhyPanel.add(textPanel);
		textPanel.setBackground(Color.BLACK);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		
		for(String text : bulletPointTexts) {
			System.out.printf("Added text: %s\n", text);
			
			JPanel bulletPointPanel = new JPanel();
			bulletPointPanel.setForeground(new Color(255, 255, 255));
			bulletPointPanel.setAlignmentY(Component.TOP_ALIGNMENT);
			bulletPointPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
			bulletPointPanel.setBackground(Color.BLACK);
			textPanel.add(bulletPointPanel);
			bulletPointPanel.setLayout(new BoxLayout(bulletPointPanel, BoxLayout.X_AXIS));
			
			JLabel lblDot = new JLabel("\u2022 ");
			lblDot.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDot.setForeground(Color.LIGHT_GRAY);
			bulletPointPanel.add(lblDot);
			
			JLabel lblBulletPoint = new JLabel(text);
			bulletPointPanel.add(lblBulletPoint);
			lblBulletPoint.setForeground(Color.WHITE);
			lblBulletPoint.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblBulletPoint.setVerticalAlignment(SwingConstants.TOP);
		}
		
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void hide() {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
	}
	
	//
	
	private void resetFrame() {
		if(frame != null)
			frame.dispose();
		
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					nextSlide();
				else if(arg0.getKeyCode() == KeyEvent.VK_UP && arg0.isControlDown())
					fullscreen();
				else if(arg0.getKeyCode() == KeyEvent.VK_DOWN && arg0.isControlDown())
					windowed();
			}
		});
		
		frame.setTitle("Funk Presentation");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void fullscreen() {
		super.fullscreen();
		
		resetFrame();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.show();
	}
	
	@Override
	public void windowed() {
		super.windowed();
		
		resetFrame();
		frame.setUndecorated(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setExtendedState(JFrame.NORMAL);
		this.show();
	}
}

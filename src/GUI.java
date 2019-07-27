import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Law Office of William Ray Ford: Virtual Assistant");
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(1226, 749);
		frame.setResizable(false);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("icon.png");
		Image logo = null;
		try {
			logo = ImageIO.read(input);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setIconImage(logo);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(SystemColor.windowBorder);
		pnlMenu.setBounds(0, 0, 210, 709);
		panel.add(pnlMenu);
		pnlMenu.setLayout(null);	
		
		JPanel pnlMainMenu = (new MainMenuFrame()).getPanel();
		panel.add(pnlMainMenu);
		pnlMainMenu.setVisible(true);
		
		JPanel pnlTaskFinder = (new TaskFinderFrame()).getPanel();
		panel.add(pnlTaskFinder);
		pnlTaskFinder.setVisible(false);
		
		JPanel pnlNewClient = new JPanel();
		pnlNewClient.setBounds(210, 0, 1010, 709);
		panel.add(pnlNewClient);
		pnlNewClient.setVisible(false);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(0, 0, 211, 211);
		pnlMenu.add(lblIcon);
		Image imageIcon = (new ImageIcon(this.getClass().getResource("icon.png")).getImage().getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(),
		        Image.SCALE_SMOOTH));
		lblIcon.setIcon(new ImageIcon(imageIcon));
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlTaskFinder.setVisible(false);
				pnlNewClient.setVisible(false);
				pnlMainMenu.setVisible(true);
			}
		});
		btnMainMenu.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		btnMainMenu.setBounds(0, 212, 211, 41);
		pnlMenu.add(btnMainMenu);
		
		JButton btnTaskFinder = new JButton("Task Finder");
		btnTaskFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMainMenu.setVisible(false);
				pnlNewClient.setVisible(false);
				pnlTaskFinder.setVisible(true);
			}
		});
		btnTaskFinder.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		btnTaskFinder.setBounds(0, 252, 211, 41);
		pnlMenu.add(btnTaskFinder);
		
		JButton btnNewClient = new JButton("New Client Setup");
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMainMenu.setVisible(false);
				pnlNewClient.setVisible(true);
				pnlTaskFinder.setVisible(false);
			}
		});
		btnNewClient.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		btnNewClient.setBounds(0, 292, 211, 41);
		pnlMenu.add(btnNewClient);
	}
}

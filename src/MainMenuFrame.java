import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuFrame {

	private JPanel mainMenu;
	
	public MainMenuFrame() {
		mainMenu = initialize();
	}
	
	public JPanel getPanel() {
		return mainMenu;
	}
	
	private JPanel initialize() {
		JPanel pnlMainMenu = new JPanel();
		pnlMainMenu.setBackground(SystemColor.windowBorder);
		pnlMainMenu.setBounds(210, 0, 1010, 709);
		pnlMainMenu.setLayout(null);
		
		JButton btnEmail = new JButton("");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("https://mail.aol.com/webmail-std/en-us/suite");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmail.setFont(new Font("Baskerville Old Face", Font.PLAIN, 54));
		btnEmail.setHorizontalAlignment(SwingConstants.CENTER);
		btnEmail.setBounds(0, 0, 507, 355);
		pnlMainMenu.add(btnEmail);
		Image imageEmail = (new ImageIcon(this.getClass().getResource("email.jpg")).getImage().getScaledInstance(btnEmail.getWidth() + 55, btnEmail.getHeight() + 2,
		        Image.SCALE_SMOOTH));
		btnEmail.setIcon(new ImageIcon(imageEmail));
		
		JButton btnCourts = new JButton("Courthouses");
		btnCourts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("https://www.courts.state.md.us/");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCourts.setFont(new Font("Baskerville Old Face", Font.PLAIN, 53));
		btnCourts.setHorizontalAlignment(SwingConstants.CENTER);
		btnCourts.setBounds(508, 0, 502, 355);
		pnlMainMenu.add(btnCourts);
		Image imageCourts = (new ImageIcon(this.getClass().getResource("courthouse.jpg")).getImage().getScaledInstance(btnCourts.getWidth() + 55, btnCourts.getHeight(),
		        Image.SCALE_SMOOTH));
		btnCourts.setIcon(new ImageIcon(imageCourts));
		
		JButton btnOdyssey = new JButton("");
		btnOdyssey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("https://maryland.tylerhost.net/ofsweb#");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOdyssey.setFont(new Font("Baskerville Old Face", Font.PLAIN, 54));
		btnOdyssey.setHorizontalAlignment(SwingConstants.CENTER);
		btnOdyssey.setBounds(0, 356, 507, 353);
		pnlMainMenu.add(btnOdyssey);
		Image imageOdy = (new ImageIcon(this.getClass().getResource("odyssey.jpg")).getImage().getScaledInstance(btnOdyssey.getWidth() + 55, btnOdyssey.getHeight(),
		        Image.SCALE_SMOOTH));
		btnOdyssey.setIcon(new ImageIcon(imageOdy));
		
		JButton btnUSPS = new JButton("USPS");
		btnUSPS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("https://www.usps.com/");
					Desktop.getDesktop().browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUSPS.setFont(new Font("Baskerville Old Face", Font.PLAIN, 54));
		btnUSPS.setHorizontalAlignment(SwingConstants.CENTER);
		btnUSPS.setBounds(508, 356, 545, 353);
		Image imageUSPS = (new ImageIcon(this.getClass().getResource("USPS.jpg")).getImage().getScaledInstance(btnUSPS.getWidth(), btnUSPS.getHeight() + 45,
		        Image.SCALE_SMOOTH));
		btnUSPS.setIcon(new ImageIcon(imageUSPS));
		pnlMainMenu.add(btnUSPS);
		
		return pnlMainMenu;
	}
	
}

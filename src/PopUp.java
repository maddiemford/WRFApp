import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class PopUp {

	public JFrame frame;
	private Task task;

	/**
	 * Create the application.
	 */
	public PopUp(Task t) {
		task = t;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Task");
		frame.setBounds(100, 100, 659, 652);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 637, 596);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JTextArea txtrClientName = new JTextArea();
		txtrClientName.setEditable(false);
		txtrClientName.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrClientName.setBackground(SystemColor.menu);
		txtrClientName.setText("Client Name:");
		txtrClientName.setBounds(15, 28, 142, 32);
		txtrClientName.setBorder(null);
		panel.add(txtrClientName);
		
		
		JTextArea txtrPlaintiffsName = new JTextArea();
		txtrPlaintiffsName.setEditable(false);
		txtrPlaintiffsName.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrPlaintiffsName.setBackground(SystemColor.menu);
		txtrPlaintiffsName.setText("Plaintiff's Name:");
		txtrPlaintiffsName.setBounds(15, 77, 142, 32);
		txtrPlaintiffsName.setBorder(null);
		panel.add(txtrPlaintiffsName);
		
		JTextArea txtrCaseNo = new JTextArea();
		txtrCaseNo.setEditable(false);
		txtrCaseNo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrCaseNo.setBackground(SystemColor.menu);
		txtrCaseNo.setText("Case No:");
		txtrCaseNo.setBounds(15, 125, 142, 32);
		txtrCaseNo.setBorder(null);
		panel.add(txtrCaseNo);
		
		JTextArea txtrWorkToBe = new JTextArea();
		txtrWorkToBe.setEditable(false);
		txtrWorkToBe.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrWorkToBe.setBackground(SystemColor.menu);
		txtrWorkToBe.setText("Work to be done:");
		txtrWorkToBe.setBounds(15, 220, 155, 32);
		txtrWorkToBe.setBorder(null);
		panel.add(txtrWorkToBe);
		
		JButton btnPostpone = new JButton("Postpone");
		btnPostpone.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnPostpone.setBounds(249, 533, 142, 45);
		panel.add(btnPostpone);
		
		JTextArea txtrExcelRow = new JTextArea();
		txtrExcelRow.setEditable(false);
		txtrExcelRow.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrExcelRow.setBackground(SystemColor.menu);
		txtrExcelRow.setText("Excel Row:");
		txtrExcelRow.setBounds(15, 173, 142, 31);
		txtrExcelRow.setBorder(null);
		panel.add(txtrExcelRow);
		
		JTextArea txtrClientNameInput = new JTextArea();
		txtrClientNameInput.setEditable(false);
		txtrClientNameInput.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrClientNameInput.setBackground(SystemColor.menu);
		txtrClientNameInput.setBounds(172, 29, 448, 32);
		txtrClientNameInput.setBorder(null);
		txtrClientNameInput.append(task.getClient());
		panel.add(txtrClientNameInput);
		
		JTextArea txtrPlaintiffsNameInput = new JTextArea();
		txtrPlaintiffsNameInput.setEditable(false);
		txtrPlaintiffsNameInput.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrPlaintiffsNameInput.setBackground(SystemColor.menu);
		txtrPlaintiffsNameInput.setBounds(172, 78, 448, 32);
		txtrPlaintiffsNameInput.setBorder(null);
		txtrPlaintiffsNameInput.append(task.getPlaintiff());
		panel.add(txtrPlaintiffsNameInput);
		
		JTextArea txtrCaseNoInput = new JTextArea();
		txtrCaseNoInput.setEditable(false);
		txtrCaseNoInput.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrCaseNoInput.setBackground(SystemColor.menu);
		txtrCaseNoInput.setBounds(172, 126, 448, 32);
		txtrCaseNoInput.setBorder(null);
		txtrCaseNoInput.append(task.getCaseNo());
		panel.add(txtrCaseNoInput);
		
		JTextArea txtrExcelRowInput = new JTextArea();
		txtrExcelRowInput.setEditable(false);
		txtrExcelRowInput.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrExcelRowInput.setBackground(SystemColor.menu);
		txtrExcelRowInput.setBounds(172, 174, 448, 31);
		txtrExcelRowInput.setBorder(null);
		txtrExcelRowInput.append(Integer.toString(task.getRowNum()));
		panel.add(txtrExcelRowInput);
		
		JScrollPane toBeScroll = new JScrollPane();
		toBeScroll.setBounds(172, 220, 448, 270);
		toBeScroll.setBorder(null);
		panel.add(toBeScroll);
		
		JTextArea txtrWorkToBeInput = new JTextArea();
		txtrWorkToBeInput.setLineWrap(true);
		txtrWorkToBeInput.setEditable(false);
		txtrWorkToBeInput.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtrWorkToBeInput.setBackground(SystemColor.menu);
		txtrWorkToBeInput.setBorder(null);
		txtrWorkToBeInput.append(task.getTask());
		toBeScroll.setViewportView(txtrWorkToBeInput);
	}
}

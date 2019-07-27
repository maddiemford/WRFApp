import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.toedter.calendar.JDateChooser;

public class TaskFinderFrame {
	private JPanel taskFinder;
	
	public TaskFinderFrame() {
		taskFinder = initialize();
	}
	
	public JPanel getPanel() {
		return taskFinder;
	}
	
	private JPanel initialize() {
		JPanel pnlTaskFinder = new JPanel();
		pnlTaskFinder.setBackground(SystemColor.menu);
		pnlTaskFinder.setBounds(210, 0, 1010, 709);
		pnlTaskFinder.setLayout(null);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1011, 648);
		pnlTaskFinder.add(scrollPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 16, 245, 29);
		pnlTaskFinder.add(dateChooser);
		dateChooser.setBackground(SystemColor.menu);
		
		JButton btnGetTasksFor = new JButton("Get tasks for:");
		btnGetTasksFor.setBackground(SystemColor.menu);
		btnGetTasksFor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		btnGetTasksFor.setBounds(27, 16, 132, 29);
		pnlTaskFinder.add(btnGetTasksFor);
		
		TaskFinderFrame frame = this;
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(667, 20, 167, 25);
		pnlTaskFinder.add(progressBar);
		btnGetTasksFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dateChooser.getDate() == null) {
					System.out.println("Please choose a date");
				} else {
					DateFormat dateFormat = new SimpleDateFormat("M/d/yy");
					// Code modified from https://stackoverflow.com/questions/7391877/how-to-add-checkboxes-to-jtable-swing
					Object[] columnNames = {"Done", "Client", "To Do", ""};
				    Object[][] data = frame.getDateData(dateFormat.format(dateChooser.getDate()));
				    DefaultTableModel model = new DefaultTableModel(data, columnNames);
				    JTable table = new JTable(model) {
				    	private static final long serialVersionUID = 1L;
					        @Override
					        public Class getColumnClass(int column) {
					        	switch (column) {
					        		case 0:
					        			return Boolean.class;
					                case 1:
					                	return String.class;
					                case 2:
					                	return String.class;
					                default:
					                	return Task.class;
					            }
					        }
					        public boolean isCellEditable(int row, int column) { 
					        	if (column == 0) {
					        		return true;
					        	} else return false;               
					        };
				    	};
				  
				    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				    table.getTableHeader().setReorderingAllowed(false);
				    table.getTableHeader().setResizingAllowed(false);
				    table.getColumnModel().getColumn(0).setPreferredWidth(45);
				    table.getColumnModel().getColumn(1).setPreferredWidth(230);
				    table.getColumnModel().getColumn(2).setPreferredWidth(715);
				    table.getColumnModel().getColumn(3).setPreferredWidth(0);
				    table.addMouseListener(new MouseAdapter() {
				        public void mousePressed(MouseEvent mouseEvent) {
				            JTable table =(JTable) mouseEvent.getSource();
				            Point point = mouseEvent.getPoint();
				            int row = table.rowAtPoint(point);
				            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
				            	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				            	int r = table.getSelectedRow();
				            	Object[] columnData = new Object[4];
				            	for (int i  = 0; i < 4; i++) {
				            		columnData[i] = dtm.getValueAt(r, i);
				            	}
				        		EventQueue.invokeLater(new Runnable() {
				        			public void run() {
				        				try {
				        					PopUp window = new PopUp((Task)columnData[3]);
				        					window.frame.setVisible(true);
				        				} catch (Exception e) {
				        					e.printStackTrace();
				        				}
				        			}
				        		});				                
				            }
				        }
				    });
					scrollPane.setViewportView(table);
				}
			}
		});
		
		return pnlTaskFinder;
	}
	
	private Object[][] getDateData(String date) {
		Workbook workbook = null;
        try {
			workbook =  WorkbookFactory.create(new File("C:\\Users\\0wner\\Desktop\\ClientFollowUpLedger1.xlsx"));
		} catch (EncryptedDocumentException | IOException e) {
			System.out.println("Please close the FollowUpLedger to use this tool.");
        	System.exit(0);
        } 
        ArrayList<Task> tasks = new ArrayList<>();
        DataFormatter f = new DataFormatter();
        Sheet ledger = workbook.getSheetAt(0);
        System.out.println(date);
        for (Row r : ledger) {
        	Cell d = r.getCell(10);
        	if (f.formatCellValue(d).equals(date)) {
        		tasks.add(new Task(r));
        	}
        }
        Object[][] data = new Object[tasks.size()][4];
        for (int i = 0; i < tasks.size(); i++) {
        	data[i][0] = tasks.get(i).isDone();
        	data[i][1] = tasks.get(i).getClient();
        	data[i][2] = tasks.get(i).getTask();
        	data[i][3] = tasks.get(i);
        }
        System.out.println(tasks.size());
		return data;
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class mainpg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable datagrid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpg frame = new mainpg();
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
	public mainpg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 41, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Your Credit Score :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(21, 31, 251, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				int returnValue = jf.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						XSSFWorkbook work = new XSSFWorkbook(new FileInputStream(jf.getSelectedFile()));
						
						XSSFSheet sheet = work.getSheetAt(0);
						XSSFRow row = null;
						
						int i=0; double j;
						while((row = sheet.getRow(i))!=null) {
							j= row.getCell(1).getNumericCellValue();
							System.out.println("Cust Name :: "+row.getCell(0).getStringCellValue());
							System.out.println("Cust Id :: "+row.getCell(1).getNumericCellValue());
							System.out.println("Cust Add :: "+row.getCell(2).getNumericCellValue());
							System.out.println("total"+j);
							i++;
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnUpload.setForeground(Color.WHITE);
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpload.setBackground(new Color(46, 41, 79));
		btnUpload.setBounds(66, 603, 225, 41);
		contentPane.add(btnUpload);
		
		datagrid = new JTable();
		datagrid.setBackground(new Color(46, 48, 79));
		datagrid.setBounds(66, 109, 1214, 456);
		contentPane.add(datagrid);
	}
}

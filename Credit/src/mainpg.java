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
					mainpg frame = new mainpg(null, null, null, null, null, null);
					frame.setVisible(true);
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param t6 
	 * @param t5 
	 * @param t4 
	 * @param t3 
	 * @param t2 
	 * @param t1 
	 */
	public mainpg(String t1, String t2, String t3, String t4, String t5, String t6) {
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
		
		JLabel f1 = new JLabel(t1);
		f1.setForeground(new Color(255, 255, 255));
		f1.setBackground(new Color(46, 41, 79));
		f1.setBounds(66, 78, 77, 21);
		contentPane.add(f1);
		
		JLabel f2 = new JLabel(t2);
		f2.setForeground(Color.WHITE);
		f2.setBackground(new Color(46, 41, 79));
		f2.setBounds(153, 78, 77, 21);
		contentPane.add(f2);
		
		JLabel f3 = new JLabel(t3);
		f3.setForeground(Color.WHITE);
		f3.setBackground(new Color(46, 41, 79));
		f3.setBounds(240, 78, 77, 21);
		contentPane.add(f3);
		
		JLabel f4 = new JLabel(t4);
		f4.setForeground(Color.WHITE);
		f4.setBackground(new Color(46, 41, 79));
		f4.setBounds(327, 78, 77, 21);
		contentPane.add(f4);
		
		JLabel f5 = new JLabel(t5);
		f5.setForeground(Color.WHITE);
		f5.setBackground(new Color(46, 41, 79));
		f5.setBounds(414, 78, 77, 21);
		contentPane.add(f5);
		
		JLabel f6 = new JLabel(t6);
		f6.setForeground(Color.WHITE);
		f6.setBackground(new Color(46, 41, 79));
		f6.setBounds(501, 78, 77, 21);
		contentPane.add(f6);
	}
	
}

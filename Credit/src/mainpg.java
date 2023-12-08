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
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
//import javax.swing.JTable;



public class mainpg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	static double i1,i2,i3,i4,i5,i6,i7;
	static JLabel m1 = new JLabel();
	static JLabel m2 = new JLabel();
	static JLabel m3 = new JLabel();
	static JLabel m4 = new JLabel();
	static JLabel m5 = new JLabel();
	static JLabel m6 = new JLabel();
	static JLabel m7 = new JLabel();
	static JLabel m8 = new JLabel();
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
		//String z;
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
						
						int i=1; 
						while((row = sheet.getRow(i))!=null) {							
							System.out.println("month :: "+row.getCell(0).getStringCellValue());						
							System.out.println("name :: "+row.getCell(1).getStringCellValue());
							System.out.println("age :: "+row.getCell(2).getNumericCellValue());
							System.out.println("job :: "+row.getCell(3).getStringCellValue());						
							System.out.println("annincome :: "+row.getCell(4).getNumericCellValue());
							System.out.println("monthly  :: "+row.getCell(5).getNumericCellValue());
							System.out.println("no. of credit cards :: "+row.getCell(6).getNumericCellValue());
							System.out.println("intrest rate:: "+row.getCell(7).getNumericCellValue());
							System.out.println("delays :: "+row.getCell(8).getNumericCellValue());
							System.out.println("outstanding :: "+row.getCell(9).getNumericCellValue());
							System.out.println("total emi :: "+row.getCell(10).getNumericCellValue());
							System.out.println("credit score:: "+row.getCell(11).getStringCellValue());
							i++;
							i1=row.getCell(4).getNumericCellValue();
							i2=row.getCell(6).getNumericCellValue();
							i3=row.getCell(7).getNumericCellValue();
							i4=row.getCell(2).getNumericCellValue();
							i5=row.getCell(8).getNumericCellValue();
							i6=row.getCell(9).getNumericCellValue();
							i7=row.getCell(10).getNumericCellValue();
							
							
							m1.setText(row.getCell(0).getStringCellValue());
							m2.setText(String.valueOf(i1));
							m3.setText(String.valueOf(i2));
							m4.setText(String.valueOf(i3));
							m5.setText(String.valueOf(i4));
							m6.setText(String.valueOf(i5));
							m7.setText(String.valueOf(i6));
							m8.setText(String.valueOf(i7));						
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
		f4.setBounds(327, 78, 142, 21);
		contentPane.add(f4);
		
		JLabel f5 = new JLabel(t5);
		f5.setForeground(Color.WHITE);
		f5.setBackground(new Color(46, 41, 79));
		f5.setBounds(479, 78, 77, 21);
		contentPane.add(f5);
		
		JLabel f6 = new JLabel(t6);
		f6.setForeground(Color.WHITE);
		f6.setBackground(new Color(46, 41, 79));
		f6.setBounds(566, 78, 142, 21);
		contentPane.add(f6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 48, 79));
		panel.setBounds(64, 112, 1226, 484);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ocup = new JLabel("Occupation");
		ocup.setFont(new Font("Tahoma", Font.BOLD, 12));
		ocup.setForeground(new Color(255, 255, 255));
		ocup.setBounds(10, 10, 112, 27);
		panel.add(ocup);
		
		JLabel lblAnnualmonthlyIncome = new JLabel("Ann/Mon Income");
		lblAnnualmonthlyIncome.setForeground(Color.WHITE);
		lblAnnualmonthlyIncome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnnualmonthlyIncome.setBounds(10, 55, 112, 27);
		panel.add(lblAnnualmonthlyIncome);
		
		JLabel lblNoOfCred = new JLabel("No. of Cred Cards");
		lblNoOfCred.setForeground(Color.WHITE);
		lblNoOfCred.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfCred.setBounds(8, 96, 112, 27);
		panel.add(lblNoOfCred);
		
		JLabel lblIntrestRate = new JLabel("Intrest Rate");
		lblIntrestRate.setForeground(Color.WHITE);
		lblIntrestRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntrestRate.setBounds(9, 140, 112, 27);
		panel.add(lblIntrestRate);
		
		JLabel age = new JLabel("Age");
		age.setForeground(Color.WHITE);
		age.setFont(new Font("Tahoma", Font.BOLD, 12));
		age.setBounds(10, 181, 112, 27);
		panel.add(age);
		
		JLabel lblDelayedPayments = new JLabel("Delayed Payments");
		lblDelayedPayments.setForeground(Color.WHITE);
		lblDelayedPayments.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDelayedPayments.setBounds(10, 225, 112, 27);
		panel.add(lblDelayedPayments);
		
		JLabel lblOutstandingDebt = new JLabel("Outstanding Debt");
		lblOutstandingDebt.setForeground(Color.WHITE);
		lblOutstandingDebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutstandingDebt.setBounds(10, 277, 112, 27);
		panel.add(lblOutstandingDebt);
		
		JLabel lblTotalEmimon = new JLabel("Total EMI/Mon");
		lblTotalEmimon.setForeground(Color.WHITE);
		lblTotalEmimon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalEmimon.setBounds(10, 328, 112, 27);
		panel.add(lblTotalEmimon);
		
	//	JLabel m1 = new JLabel();
		m1.setForeground(Color.WHITE);
		m1.setFont(new Font("Tahoma", Font.BOLD, 12));
		m1.setBounds(154, 10, 112, 27);
		panel.add(m1);
		
		
		//JLabel m2 = new JLabel("");
		m2.setForeground(Color.WHITE);
		m2.setFont(new Font("Tahoma", Font.BOLD, 12));
		m2.setBounds(154, 55, 112, 27);
		panel.add(m2);
		
	//	JLabel m3 = new JLabel("");
		m3.setForeground(Color.WHITE);
		m3.setFont(new Font("Tahoma", Font.BOLD, 12));
		m3.setBounds(154, 96, 112, 27);
		panel.add(m3);
		
		//JLabel m4 = new JLabel("");
		m4.setForeground(Color.WHITE);
		m4.setFont(new Font("Tahoma", Font.BOLD, 12));
		m4.setBounds(154, 140, 112, 27);
		panel.add(m4);
		
		//JLabel m5 = new JLabel("");
		m5.setForeground(Color.WHITE);
		m5.setFont(new Font("Tahoma", Font.BOLD, 12));
		m5.setBounds(154, 181, 112, 27);
		panel.add(m5);
		
		//JLabel m6 = new JLabel();
		m6.setForeground(Color.WHITE);
		m6.setFont(new Font("Tahoma", Font.BOLD, 12));
		m6.setBounds(154, 225, 112, 27);
		panel.add(m6);
		
		//JLabel m7 = new JLabel();
		m7.setForeground(Color.WHITE);
		m7.setFont(new Font("Tahoma", Font.BOLD, 12));
		m7.setBounds(154, 277, 112, 27);
		panel.add(m7);
		
		//JLabel m8 = new JLabel();
		m8.setForeground(Color.WHITE);
		m8.setFont(new Font("Tahoma", Font.BOLD, 12));
		m8.setBounds(154, 328, 112, 27);
		panel.add(m8);
	}
}

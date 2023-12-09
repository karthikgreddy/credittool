import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
//import javax.swing.JTable;



public class mainpg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	static double i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
	static JLabel credlabel = new JLabel();
	static XSSFRow row;
	static JLabel suglabel = new JLabel();
	static JLabel n2 = new JLabel();
	static JLabel n3 = new JLabel();
	static JLabel m1 = new JLabel();
	static JLabel m2 = new JLabel();
	static JLabel m3 = new JLabel();
	static JLabel m4 = new JLabel();
	static JLabel m5 = new JLabel();
	static JLabel m6 = new JLabel();
	static JLabel n1 = new JLabel();
	static JLabel m7 = new JLabel();
	static JLabel m8 = new JLabel();
	static JLabel m9 = new JLabel();
	static JLabel m10 = new JLabel();
	static JLabel m11 = new JLabel();
	
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
		JButton btnUpload = new JButton("UPLOAD & GENERATE");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	 								// uploading and generating the score			
				JFileChooser jf = new JFileChooser();
				int returnValue = jf.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						XSSFWorkbook work = new XSSFWorkbook(new FileInputStream(jf.getSelectedFile()));
						
						XSSFSheet sheet = work.getSheetAt(0);
						
						
						int i=1; 
						while((row = sheet.getRow(i))!=null) {														
							i++;
							
							i1=row.getCell(1).getNumericCellValue();
							i2=row.getCell(2).getNumericCellValue();
							i3=row.getCell(3).getNumericCellValue();
							i4=row.getCell(4).getNumericCellValue();
							i5=row.getCell(5).getNumericCellValue();
							i6=row.getCell(6).getNumericCellValue();
							i7=row.getCell(7).getNumericCellValue();
							i8=row.getCell(8).getNumericCellValue();
							i9=row.getCell(9).getNumericCellValue();
							i10=row.getCell(10).getNumericCellValue();
							 /////Dynamic setting of Labels																				
							m1.setText(row.getCell(0).getStringCellValue());
							m2.setText(String.valueOf(i1));
							m3.setText(String.valueOf(i2));
							m4.setText(String.valueOf(i3));
							m5.setText(String.valueOf(i4));
							m6.setText(String.valueOf(i5));
							m7.setText(String.valueOf(i6));
							m8.setText(String.valueOf(i7));	
							m9.setText(String.valueOf(i8));
							m10.setText(String.valueOf(i9));
							m11.setText(String.valueOf(i10));
							
							
								
							}
						n1.setVisible(true);
						n2.setVisible(true);
						if(i1>20000.00 && i6<5 && i7<1000.00 && i3>2) {
							credlabel.setText("YOUR CREDIT SCORE SHOULD BE BETWEEN '670-739'");
							credlabel.setForeground(new Color(0, 255, 0));
							suglabel.setText("Continue the Present Trend");
							n3.setText("You can take 3+loans,1.5-credit of monthly income");
							
						    }
						else if(i6>7 && i7>1000.00 && i5>14)
						{
							credlabel.setText("YOUR CREDIT SCORE SHOULD BE BETWEEN '300-579'");
							credlabel.setForeground(new Color(255, 0, 0));
							suglabel.setText("Pay on time,clear Outstanding,reduce intrest rate");
							n3.setText("You can take 0-loans,0.17-credit of montly income");
						}
						else
						{
							credlabel.setText("YOUR CREDIT SCORE SHOULD BE BETWEEN '580-669'");
							credlabel.setForeground(new Color(255, 255, 0));
							suglabel.setText("Increase the Loans,Improve Monthly Balance as well the Cred Ratio.");
							n3.setText("You can take 2-loans,0.85-credit of monthly income");
						}
							
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"Error,Please Contact Admin");
						e1.printStackTrace();
					}					
					
				}
			}
		});
		
			
		btnUpload.setForeground(Color.WHITE);
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpload.setBackground(new Color(46, 41, 79));
		btnUpload.setBounds(66, 603, 251, 41);
		contentPane.add(btnUpload);
		
		JLabel f1 = new JLabel(t1);
		f1.setFont(new Font("Tahoma", Font.BOLD, 12));
		f1.setForeground(new Color(255, 255, 255));
		f1.setBackground(new Color(46, 41, 79));
		f1.setBounds(66, 78, 77, 21);
		contentPane.add(f1);
		
		JLabel f2 = new JLabel(t2);
		f2.setFont(new Font("Tahoma", Font.BOLD, 12));
		f2.setForeground(Color.WHITE);
		f2.setBackground(new Color(46, 41, 79));
		f2.setBounds(153, 78, 77, 21);
		contentPane.add(f2);
		
		JLabel f3 = new JLabel(t3);
		f3.setFont(new Font("Tahoma", Font.BOLD, 12));
		f3.setForeground(Color.WHITE);
		f3.setBackground(new Color(46, 41, 79));
		f3.setBounds(240, 78, 77, 21);
		contentPane.add(f3);
		
		JLabel f4 = new JLabel(t4);
		f4.setFont(new Font("Tahoma", Font.BOLD, 12));
		f4.setForeground(Color.WHITE);
		f4.setBackground(new Color(46, 41, 79));
		f4.setBounds(327, 78, 184, 21);
		contentPane.add(f4);
		
		JLabel f5 = new JLabel(t5);
		f5.setFont(new Font("Tahoma", Font.BOLD, 12));
		f5.setForeground(Color.WHITE);
		f5.setBackground(new Color(46, 41, 79));
		f5.setBounds(521, 78, 113, 21);
		contentPane.add(f5);
		
		JLabel f6 = new JLabel(t6);
		f6.setFont(new Font("Tahoma", Font.BOLD, 12));
		f6.setForeground(Color.WHITE);
		f6.setBackground(new Color(46, 41, 79));
		f6.setBounds(644, 78, 142, 21);
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
		
		JLabel lblAnnualmonthlyIncome = new JLabel("Ann Inc.");
		lblAnnualmonthlyIncome.setForeground(Color.WHITE);
		lblAnnualmonthlyIncome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnnualmonthlyIncome.setBounds(10, 47, 112, 27);
		panel.add(lblAnnualmonthlyIncome);
		
		JLabel lblNoOfCred = new JLabel("Monthly Inc");
		lblNoOfCred.setForeground(Color.WHITE);
		lblNoOfCred.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfCred.setBounds(10, 84, 112, 27);
		panel.add(lblNoOfCred);
		
		JLabel lblIntrestRate = new JLabel("No. of Loans");
		lblIntrestRate.setForeground(Color.WHITE);
		lblIntrestRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntrestRate.setBounds(10, 121, 112, 27);
		panel.add(lblIntrestRate);
		
		JLabel age = new JLabel("No. of Cred Cards");
		age.setForeground(Color.WHITE);
		age.setFont(new Font("Tahoma", Font.BOLD, 12));
		age.setBounds(10, 158, 112, 27);
		panel.add(age);
		
		JLabel lblDelayedPayments = new JLabel("Intrest rate");
		lblDelayedPayments.setForeground(Color.WHITE);
		lblDelayedPayments.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDelayedPayments.setBounds(10, 195, 112, 27);
		panel.add(lblDelayedPayments);
		
		JLabel lblOutstandingDebt = new JLabel("Delayed Payments");
		lblOutstandingDebt.setForeground(Color.WHITE);
		lblOutstandingDebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutstandingDebt.setBounds(10, 232, 112, 27);
		panel.add(lblOutstandingDebt);
		
		JLabel lblTotalEmimon = new JLabel("Outstanding Debt");
		lblTotalEmimon.setForeground(Color.WHITE);
		lblTotalEmimon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalEmimon.setBounds(10, 269, 112, 27);
		panel.add(lblTotalEmimon);
		
	//	JLabel m1 = new JLabel();
		m1.setForeground(Color.WHITE);
		m1.setFont(new Font("Tahoma", Font.BOLD, 12));
		m1.setBounds(154, 10, 112, 27);
		panel.add(m1);
		
		
		//JLabel m2 = new JLabel("");
		m2.setForeground(Color.WHITE);
		m2.setFont(new Font("Tahoma", Font.BOLD, 12));
		m2.setBounds(154, 47, 112, 27);
		panel.add(m2);
		
	//	JLabel m3 = new JLabel("");
		m3.setForeground(Color.WHITE);
		m3.setFont(new Font("Tahoma", Font.BOLD, 12));
		m3.setBounds(154, 84, 112, 27);
		panel.add(m3);
		
		//JLabel m4 = new JLabel("");
		m4.setForeground(Color.WHITE);
		m4.setFont(new Font("Tahoma", Font.BOLD, 12));
		m4.setBounds(154, 121, 112, 27);
		panel.add(m4);
		
		//JLabel m5 = new JLabel("");
		m5.setForeground(Color.WHITE);
		m5.setFont(new Font("Tahoma", Font.BOLD, 12));
		m5.setBounds(154, 158, 112, 27);
		panel.add(m5);
		
		//JLabel m6 = new JLabel();
		m6.setForeground(Color.WHITE);
		m6.setFont(new Font("Tahoma", Font.BOLD, 12));
		m6.setBounds(154, 195, 112, 27);
		panel.add(m6);
		
		//JLabel m7 = new JLabel();
		m7.setForeground(Color.WHITE);
		m7.setFont(new Font("Tahoma", Font.BOLD, 12));
		m7.setBounds(154, 232, 112, 27);
		panel.add(m7);
		
		//JLabel m8 = new JLabel();
		m8.setForeground(Color.WHITE);
		m8.setFont(new Font("Tahoma", Font.BOLD, 12));
		m8.setBounds(154, 269, 112, 27);
		panel.add(m8);
		credlabel.setForeground(new Color(0, 0, 0));
		credlabel.setHorizontalAlignment(SwingConstants.CENTER);
		credlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
	    //JLabel credlabel = new JLabel("");
		//credlabel.setForeground(new Color(0, 0, 0));
		credlabel.setBounds(437, 63, 571, 77);
		panel.add(credlabel);
		
		JLabel lblCredUtilRatio = new JLabel("Cred Util Ratio");
		lblCredUtilRatio.setForeground(Color.WHITE);
		lblCredUtilRatio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCredUtilRatio.setBounds(10, 314, 112, 27);
		panel.add(lblCredUtilRatio);
		
		JLabel lblTotalEmi = new JLabel("Total EMI");
		lblTotalEmi.setForeground(Color.WHITE);
		lblTotalEmi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalEmi.setBounds(10, 351, 112, 27);
		panel.add(lblTotalEmi);
		
		JLabel lblMonthlyBalance = new JLabel("Monthly Balance");
		lblMonthlyBalance.setForeground(Color.WHITE);
		lblMonthlyBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonthlyBalance.setBounds(10, 388, 112, 27);
		panel.add(lblMonthlyBalance);
		
		//JLabel m9 = new JLabel();
		m9.setForeground(Color.WHITE);
		m9.setFont(new Font("Tahoma", Font.BOLD, 12));
		m9.setBounds(154, 314, 112, 27);
		panel.add(m9);
		
		//JLabel m10 = new JLabel();
		m10.setForeground(Color.WHITE);
		m10.setFont(new Font("Tahoma", Font.BOLD, 12));
		m10.setBounds(154, 351, 112, 27);
		panel.add(m10);
		
		//JLabel m11 = new JLabel();
		m11.setForeground(Color.WHITE);
		m11.setFont(new Font("Tahoma", Font.BOLD, 12));
		m11.setBounds(154, 388, 112, 27);
		panel.add(m11);
		
		//JLabel suglabel = new JLabel();
		suglabel.setForeground(new Color(199, 218, 124));
		suglabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		suglabel.setBounds(353, 166, 823, 63);
		panel.add(suglabel);
		
		//n1 = new JLabel("CryptoCurenncy and Blockchain Transactions Excluded!");
		n1.setText("*CryptoCurrency Transactions are Excluded*");
		n1.setVisible(false);
		n1.setForeground(Color.RED);
		n1.setBounds(10, 452, 270, 22);
		panel.add(n1);
		
		//JLabel n2 = new JLabel();
		n2.setText("*This System is Refrained from Analyzing Applicant's Social Media*");
		n2.setVisible(false);
		n2.setForeground(Color.RED);
		n2.setBounds(284, 452, 377, 22);
		panel.add(n2);
		
		JLabel lblNewLabel_1 = new JLabel("The above score is just and approximate value closley following Govt Guidelines");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(492, 150, 516, 13);
		panel.add(lblNewLabel_1);
		
	//	JLabel n3 = new JLabel();
		n3.setForeground(new Color(255, 255, 255));
		n3.setFont(new Font("Tahoma", Font.BOLD, 15));
		n3.setHorizontalAlignment(SwingConstants.CENTER);
		n3.setBounds(521, 239, 413, 27);
		panel.add(n3);
	}
}

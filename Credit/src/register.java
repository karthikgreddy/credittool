import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField f1;
	private JTextField f2;
	private JTextField f3;
	private JTextField f4;
	private JTextField f5;
	private JTextField f6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 732);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 51, 73));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 41, 79));
		panel.setBounds(988, 0, 225, 695);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlreadyRegistered = new JLabel("Already Registered?\r\nLog-In");
		lblAlreadyRegistered.setBounds(10, 255, 213, 71);
		panel.add(lblAlreadyRegistered);
		lblAlreadyRegistered.setForeground(new Color(255, 187, 119));
		lblAlreadyRegistered.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnLogin = new JButton("LOG-IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home frame = new home();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBackground(new Color(23, 85, 213));
		btnLogin.setBounds(69, 315, 92, 31);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(84, 200, 64, 64);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setRequestFocusEnabled(false);
		lblNewLabel_2.setIcon(new ImageIcon(register.class.getResource("/Images/businessman-64.png")));
		
		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(405, 36, 232, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(391, 178, 104, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(391, 229, 104, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("N.I Number");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(391, 286, 104, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email-id");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(391, 342, 104, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone Number");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(389, 396, 125, 22);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Address");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(388, 446, 104, 22);
		contentPane.add(lblNewLabel_1_5);
		
		f1 = new JTextField();
		f1.setBounds(559, 182, 96, 19);
		contentPane.add(f1);
		f1.setColumns(10);
		
		f2 = new JTextField();
		f2.setColumns(10);
		f2.setBounds(558, 228, 96, 19);
		contentPane.add(f2);
		
		f3 = new JTextField();
		f3.setColumns(10);
		f3.setBounds(559, 291, 96, 19);
		contentPane.add(f3);
		
		f4 = new JTextField();
		f4.setColumns(10);
		f4.setBounds(559, 347, 96, 19);
		contentPane.add(f4);
		
		f5 = new JTextField();
		f5.setColumns(10);
		f5.setBounds(559, 401, 96, 19);
		contentPane.add(f5);
		
		f6 = new JTextField();
		f6.setColumns(10);
		f6.setBounds(559, 451, 96, 19);
		contentPane.add(f6);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String databaseURL = "jdbc:ucanaccess://register.mdb";
				String t1,t2,t3,t4,t5,t6;
				t1= f1.getText();t2= f2.getText();t3= f3.getText();t4= f4.getText();t5= f5.getText();t6=f6.getText();
				try {
					Connection connection = DriverManager.getConnection(databaseURL);
					System.out.println("Connected to DataBase");
					Statement statement = connection.createStatement();
					String sql ="insert into REG values ('" + t1 + "','" + t2 + "','"+t3+"','"+t4+"','"+t5+"','"+t6+"')";
					statement.executeUpdate(sql);
					mainpg frame = new mainpg();
					frame.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Your Details have been Saved");
						dispose();
					} 
				 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(46, 51, 73));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(409, 526, 225, 41);
		contentPane.add(btnNewButton);
	}
}

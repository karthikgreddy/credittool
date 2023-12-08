//mport java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField l1;
	private JTextField l2;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1209, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 51, 73));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREDIT SCORING TOOL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(408, 33, 362, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(31, 100, 175));
		panel.setForeground(new Color(128, 128, 64));
		panel.setBounds(133, 159, 415, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(163, 28, 69, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2.setBounds(90, 140, 90, 21);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_3.setBounds(90, 201, 90, 21);
		panel.add(lblNewLabel_1_3);
		
		l1 = new JTextField();
		l1.setBounds(201, 144, 96, 19);
		panel.add(l1);
		l1.setColumns(10);
		
		l2 = new JTextField();
		l2.setColumns(10);
		l2.setBounds(201, 205, 96, 19);
		panel.add(l2);
		
		JButton btnNewButton = new JButton("LOG-IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String databaseURL = "jdbc:ucanaccess://reddydb.mdb";
				
				try {
					Connection connection = DriverManager.getConnection(databaseURL);
					System.out.println("Connected to DataBase");
					String t1= l1.getText();
					String t2=l2.getText();
					
					Statement statement = connection.createStatement();
					String sql ="select * from CRED where username='"+t1+"' and password='"+t2+"'";
					ResultSet rs = statement.executeQuery(sql);
					if(rs.next()) {
						mainpg frame = new mainpg(null, null, null, null, null, null);
						frame.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Your Details are Valid.");
						dispose();
					}
					else {
						home frame = new home();
						//frame.setVisible(true);
						JOptionPane.showMessageDialog(frame,"Invalid Credentials");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(31, 100, 175));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(51, 329, 316, 39);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(128, 128, 64));
		panel_1.setBackground(new Color(31, 100, 175));
		panel_1.setBounds(658, 159, 415, 472);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("REGISTER");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(151, 28, 111, 21);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Username");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2_1.setBounds(108, 137, 90, 21);
		panel_1.add(lblNewLabel_1_2_1);
		
		r1 = new JTextField();
		r1.setColumns(10);
		r1.setBounds(219, 141, 96, 19);
		panel_1.add(r1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Password");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_3_1.setBounds(108, 198, 90, 21);
		panel_1.add(lblNewLabel_1_3_1);
		
		r2 = new JTextField();
		r2.setColumns(10);
		r2.setBounds(219, 197, 96, 19);
		panel_1.add(r2);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_3_1_1.setBounds(67, 251, 142, 21);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		r3 = new JTextField();
		r3.setColumns(10);
		r3.setBounds(219, 255, 96, 19);
		panel_1.add(r3);
		
		JButton btnSignup = new JButton("SIGN-UP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String databaseURL = "jdbc:ucanaccess://reddydb.mdb";
				
				String t11= r1.getText();
				String t12=r2.getText();
				String t13=r3.getText();
					if(t12.equals(t13)) {
					
				try {
					Connection connection = DriverManager.getConnection(databaseURL);
					System.out.println("Connected to DataBase");
					Statement statement = connection.createStatement();
					String sql ="insert into CRED values ('" + t11 + "','" + t12 + "')";
					statement.executeUpdate(sql);
					new register(t11).setVisible(true);
						JOptionPane.showMessageDialog(null, "Your Details have been registered.");
						dispose();
					} 
				 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					else {
						home frame = new home();
						frame.setVisible(false);
						JOptionPane.showMessageDialog(frame,"Entered Passwords do not Match");
					}
					
				
			}
		});
		btnSignup.setForeground(Color.BLACK);
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignup.setBackground(new Color(31, 100, 175));
		btnSignup.setBounds(49, 329, 316, 39);
		panel_1.add(btnSignup);
	}
}

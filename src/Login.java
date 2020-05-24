import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
public class Login extends JFrame {


	private JFrame Login;
	private JButton btnLogn;
	private JFrame Start;
	private JLabel lblPhoneNumber;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblPassword;
	private JCheckBox rdbtnCustomer ;
	private JCheckBox rdbtnAdmin ;
	private JButton btnLogin;
	private JButton btnSignup;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	public  Login() {

		Login = new JFrame();

		Login.getContentPane().setBackground(new Color(250, 128, 114));
		Login.setBounds(300, 90, 900, 600);

		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login.setTitle("LogIn");
		Login.setSize(471, 495);
		Login.getContentPane().setLayout(null);

		rdbtnAdmin = new JCheckBox("Admin");
		rdbtnAdmin.setBounds(136, 112, 139, 29);
		Login.getContentPane().add(rdbtnAdmin);

		rdbtnCustomer = new JCheckBox("Customer");
		rdbtnCustomer.setBounds(136, 168, 152, 29);
		Login.getContentPane().add(rdbtnCustomer);

		btnSignup = new JButton("SignUp");
		btnSignup.setBounds(160, 330, 115, 29);
		Login.getContentPane().add(btnSignup);

		btnLogin = new JButton("OK");
		btnLogin.setBounds(160, 223, 115, 29);
		Login.getContentPane().add(btnLogin);

		JLabel lblNewToOfss = new JLabel("New to OFSS?");
		lblNewToOfss.setBounds(166, 308, 181, 20);
		Login.getContentPane().add(lblNewToOfss);
		Login.setVisible(true);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag=true;
				if(rdbtnCustomer.isSelected()||rdbtnAdmin.isSelected())
					LoginPage();

				else
					JOptionPane.showMessageDialog(Login, "CHOOSE");}
		});

		btnSignup.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Login.setVisible(false);

				SignUp sn = new SignUp();
				sn.setVisible(true);

			}
		});

		Login.getContentPane().add(btnSignup);


	}
	public void LoginPage() {
		Start = new JFrame();

		Start.getContentPane().setBackground(new Color(250, 128, 114));
		Start.setBounds(300, 90, 900, 600);

		Start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Start.setTitle("LogIn");
		Start.setSize(471, 495);
		Start.getContentPane().setLayout(null);

		btnLogn = new JButton("LogIn");
		btnLogn.setBounds(192, 257, 115, 29);
		Start.getContentPane().add(btnLogn);

		btnLogn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Boolean flag=true;
				Start.setVisible(false);
				try {	
					String number=textField.getText();
					String password=textField_1.getText();
					Management m=new Management();

					if(rdbtnCustomer.isSelected()) {

						boolean entercustomer=m.searchCustomer(number, password);
						System.out.println(entercustomer);
						if(entercustomer==true)
						{	
							Start.setVisible(false);
							Login.setVisible(false);
							Customerframe cf=new Customerframe();
							cf.FRAME( m.fList,m.cList,m.cList.get(m.findcustomerid(number, password)));
							cf.setVisible(true);
						}
						else {
							textField.setText("");
							textField_1.setText("");
							JOptionPane.showMessageDialog(Start, "Wrong password or phone number");
						}
					}
					if(rdbtnAdmin.isSelected()) {
						boolean enteradmin=m.searchAdmin(number, password);
						if(enteradmin==true) {
							Start.setVisible(false);

							AdminMenu admin=new AdminMenu(m.aList.get(m.findAdminid(number, password)));
							admin.setVisible(true);

						}

						else {
							textField.setText("");
							textField_1.setText("");
							JOptionPane.showMessageDialog(Start, "Wrong password or phone number");
						}
					}

				} catch (QueueFull | IOException | QueueEmpty e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});



		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(55, 91, 188, 20);
		Start.getContentPane().add(lblPhoneNumber);

		textField = new JTextField();
		textField.setBounds(192, 88, 146, 26);
		Start.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(192, 148, 146, 26);
		Start.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 151, 69, 20);
		Start.getContentPane().add(lblPassword);
		Start.setVisible(true);

	}
	public JFrame getStart() {
		return Start;
	}


}

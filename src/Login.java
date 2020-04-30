import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField textpassword;
	private JFrame LogIn;



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


	public Login() {

		LogIn = new JFrame();
		setTitle("LogIn");
		LogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LogIn.setBounds(100, 100, 525, 402);

		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setForeground(SystemColor.windowBorder);
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogin = new JButton("LogIn");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////KULLANICI ISIMLERI GELÝCEK

				if(txtUserName.getText().equals("cme2210") &&
						textpassword.getText().equals("pass"))
				{
					LogIn.setVisible(false);
					Menu mp = new Menu();
					mp.getFrame().setVisible(true);

				}
				else
				{
					txtUserName.setText("");
					textpassword.setText("");

					JOptionPane.showMessageDialog(LogIn, "Wrong password or user name!");

				}
			}
		});
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnLogin.setBounds(190, 175, 115, 29);
		contentPane.add(btnLogin);

		txtUserName = new JTextField();
		txtUserName.setBackground(Color.WHITE);
		txtUserName.setBounds(232, 62, 146, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		textpassword = new JPasswordField();
		textpassword.setBackground(Color.WHITE);
		textpassword.setBounds(232, 117, 146, 26);
		contentPane.add(textpassword);
		textpassword.setColumns(10);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblUsername.setBounds(86, 65, 107, 20);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPassword.setBounds(86, 120, 96, 20);
		contentPane.add(lblPassword);

		JLabel lblHave = new JLabel("New to OFSS? ");
		lblHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblHave.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblHave.setBounds(85, 220, 329, 20);
		contentPane.add(lblHave);

		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBackground(Color.GRAY);
		btnSignup.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				LogIn.setVisible(false);

				SignUp sn = new SignUp();
				sn.getSýgnUp().setVisible(true);

			}
		});
		btnSignup.setBounds(190, 243, 115, 29);
		contentPane.add(btnSignup);
	}




}

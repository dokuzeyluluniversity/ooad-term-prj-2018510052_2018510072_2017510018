import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Create extends JFrame {

	private JPanel contentPane;
	private JFrame UserForm;
	private JTextField txtUserName;
	private JTextField txtSurName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public void  CreateMenu(boolean flag) {
		UserForm = new JFrame();
		UserForm.setTitle("SignUp");
		UserForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserForm.setBounds(100, 100, 589, 449);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserForm.setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setBackground(Color.WHITE);
		txtUserName.setBounds(232, 61, 146, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtSurName = new JPasswordField();
		txtSurName.setBackground(Color.WHITE);
		txtSurName.setBounds(232, 229, 146, 26);
		contentPane.add(txtSurName);
		txtSurName.setColumns(10);



		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	boolean flag2=true;
			if(textField.getText().equals("")&&textField_1.getText().equals("")&&textField_2.getText().equals(""))
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				JOptionPane.showMessageDialog(UserForm, "Fill All Of Your Information!");

			}

			else if(flag) 
			{
				UserForm.setVisible(false);
				Menu mp = new Menu();
				mp.cMenu(flag2);
				mp.getFrame().setVisible(true);
			}
			else if(!flag)
			{
				flag2=false;
				UserForm.setVisible(false);
				Menu mp = new Menu();
				mp.cMenu(flag2);

				mp.getFrame().setVisible(true);
			}

			}
		});
		btnOk.setBounds(261, 304, 89, 23);
		UserForm.getContentPane().add(btnOk);

		JLabel lblUsername = new JLabel("Name:");
		lblUsername.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblUsername.setBounds(60, 106, 112, 20);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPassword.setBounds(60, 232, 112, 20);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(232, 103, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSurname.setBounds(58, 148, 89, 20);
		contentPane.add(lblSurname);

		textField_1 = new JTextField();
		textField_1.setBounds(232, 145, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPhoneNumber.setBounds(60, 190, 157, 20);
		contentPane.add(lblPhoneNumber);

		textField_2 = new JTextField();
		textField_2.setBounds(232, 187, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblUsername_1 = new JLabel("UserName:");
		lblUsername_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblUsername_1.setBounds(57, 64, 115, 20);
		contentPane.add(lblUsername_1);


	}

	public JFrame getUserForm() {
		return UserForm;
	}


	public void setUserForm(JFrame UserForm) {
		this.UserForm = UserForm;
	}
}

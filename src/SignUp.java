import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;

public class SignUp extends JFrame {
	private JFrame S�gnUp;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SignUp() {
		S�gnUp = new JFrame();
		S�gnUp.setTitle("SignUp");
		S�gnUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		S�gnUp.setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		S�gnUp.setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(new Color(250, 128, 114));
		rdbtnAdmin.setBounds(88, 50, 155, 29);
		contentPane.add(rdbtnAdmin);

		JRadioButton rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBackground(new Color(250, 128, 114));
		rdbtnUser.setBounds(88, 111, 155, 29);
		contentPane.add(rdbtnUser);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtnUser);
		btnG.add(rdbtnAdmin);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ 		boolean flag=true;
			if(rdbtnUser.isSelected()) {
				Create c= new Create();
				c.CreateMenu(flag);
				c.getUserForm().setVisible(true);
				S�gnUp.setVisible(false);

			}
			else if(rdbtnAdmin.isSelected()) {
				flag=false;
				Create c= new Create();
				c.CreateMenu(flag);
				c.getUserForm().setVisible(true);
				S�gnUp.setVisible(false);
			}

			}

		});
		btnOk.setBounds(218, 193, 89, 23);
		S�gnUp.getContentPane().add(btnOk);


	}

	public JFrame getS�gnUp() {
		return S�gnUp;
	}


	public void setS�gnUp(JFrame S�gnUp) {
		this.S�gnUp = S�gnUp;
	}

}

// Java program to implement 
// a Simple Registration Form 
// using Java Swing 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.IOException; 

public class SignUp extends JFrame implements ActionListener { 

	private JRadioButton rdbtnNewRadioButton;
	private Container c; 
	private JLabel title; 
	private JLabel name; 
	private JLabel surname; 
	private JTextField tname; 
	private JTextField sname; 
	private JLabel mno; 
	private JLabel cmno; 
	private JTextField tmno; 
	private JTextField ctmno; 
	private JLabel add; 
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset; 
	private JLabel lblPassword;
	private JLabel res;
	private JLabel lblTown;
	private JLabel lblCity;
	private JLabel lblDescription;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnNewRadioButton_1;

	public SignUp() 
	{
		getContentPane().setBackground(new Color(250, 128, 114)); 
		setTitle("Sign Up"); 
		setBounds(300, 90, 476, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Sign Up"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(200, 16); 
		c.add(title); 

		name = new JLabel("Name*"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(70, 98); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 30); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		surname = new JLabel("Surname*"); 
		surname.setFont(new Font("Arial", Font.PLAIN, 20)); 
		surname.setSize(100, 20); 
		surname.setLocation(70, 148);  
		c.add(surname); 

		sname = new JTextField(); 
		sname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sname.setSize(190, 30); 
		sname.setLocation(200, 140); 
		c.add(sname); 


		cmno = new JLabel("Country Code*"); 
		cmno.setFont(new Font("Arial", Font.PLAIN, 10)); 
		cmno.setSize(150, 20); 
		cmno.setLocation(200, 170); 
		c.add(cmno); 

		ctmno = new JTextField(); 
		ctmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ctmno.setSize(50, 30); 
		ctmno.setLocation(200, 190); 
		c.add(ctmno); 

		mno = new JLabel("Phone Number*"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 10)); 
		mno.setSize(94, 20); 
		mno.setLocation(312, 170); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(130, 30); 
		tmno.setLocation(260, 190); 
		c.add(tmno); 

		add = new JLabel("Street"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(100, 20); 
		add.setLocation(70, 277); 
		c.add(add);

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setFont(new Font("Arial", Font.PLAIN, 15)); 
		term.setSize(250, 20); 
		term.setLocation(106, 474); 
		c.add(term); 

		sub = new JButton("Sign Up"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(106, 506); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(256, 506); 
		reset.addActionListener(this); 
		c.add(reset);

		lblPassword = new JLabel("Password*");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(70, 236, 121, 20);
		getContentPane().add(lblPassword);

		res = new JLabel("");
		res.setBounds(500, 62, 299, 20);
		getContentPane().add(res);

		lblTown = new JLabel("Town");
		lblTown.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTown.setBounds(70, 318, 69, 20);
		getContentPane().add(lblTown);

		lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCity.setBounds(70, 366, 69, 20);
		getContentPane().add(lblCity);

		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDescription.setBounds(70, 402, 121, 24);
		getContentPane().add(lblDescription);

		passwordField = new JPasswordField();
		passwordField.setBounds(200, 236, 190, 26);
		getContentPane().add(passwordField);

		textField = new JTextField();
		textField.setBounds(200, 402, 190, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 360, 190, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(200, 316, 190, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(200, 278, 190, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setBounds(70, 59, 150, 29);
		getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.setBounds(232, 58, 155, 29);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNumber = new JLabel("Number*");
		lblNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumber.setBounds(70, 200, 100, 20);
		getContentPane().add(lblNumber);

		setVisible(true); 
	} 

	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) { 
			if(!(tname.getText().equals("")||sname.getText().equals("")||ctmno.getText().equals("")||tmno.getText().equals("")||passwordField.getText().equals(""))) {
				if (term.isSelected()) { 

					try {
						Management m = new Management();
						String data=  "Phone Number : "+ ctmno.getText()+"\t"+tmno.getText() + "\n"
								+"Password : "+passwordField.getText()+"\n";
						if(rdbtnNewRadioButton.isSelected())
						{
							String info=  tname.getText()+","+sname.getText()+","+textField_3.getText()+","+textField_2.getText()+","+
									textField_1.getText()+","+textField.getText()+","+ctmno.getText()+","+tmno.getText()+","+passwordField.getText();
							Admin newAdmin = new Admin(tname.getText(),sname.getText(),new Address(textField_3.getText(),textField_2.getText(),textField_1.getText(),textField.getText()),new Phone(ctmno.getText(),tmno.getText()),passwordField.getText());
							newAdmin.createAdmin(newAdmin, m.aList);
							m.selectfile(m.findAdminid(newAdmin.getPhone().getNumber(),newAdmin.getPassword() )+","+info,1);
				

						}
						else if (rdbtnNewRadioButton_1.isSelected()) {

							String info=  tname.getText()+","+sname.getText()+","+textField_3.getText()+","+textField_2.getText()+","+
									textField_1.getText()+","+textField.getText()+","+ctmno.getText()+","+tmno.getText()+","+passwordField.getText();

							
							Customer newCustomer = new Customer(tname.getText(),sname.getText(),new Address(textField_3.getText(),textField_2.getText(),textField_1.getText(),textField.getText()),new Phone(ctmno.getText(),tmno.getText()),passwordField.getText());
							newCustomer.CreateCustomer(newCustomer, m.cList);
						m.selectfile(m.findcustomerid(newCustomer.getPhone().getNumber(),newCustomer.getPassword() )+","+info,2);
						
					
						}
						
						res.setText("Sign Up Successfully!"); 
						setVisible(false);
						Login l=new Login();

					} catch (QueueFull | IOException | QueueEmpty e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				else { 
				
					res.setText("Please accept the terms & conditions!"); 
				} 
			}
			else {
				tname.setText("");
				sname.setText("");
				ctmno.setText("");
				tmno.setText("");
				passwordField.setText("");
				textField.setText("");
				textField_1.setText("");
				JOptionPane.showMessageDialog(getContentPane(),	"Fill the * ones");
			}
		}
		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			sname.setText(def); 
			tmno.setText(def); 
			ctmno.setText(def); 
			res.setText(def); 
			term.setSelected(false); 		
			passwordField.setText(def);
			textField.setText(def);
			textField_1.setText(def);
			textField_2.setText(def);
			textField_3.setText(def);
		} 
	} 
} 


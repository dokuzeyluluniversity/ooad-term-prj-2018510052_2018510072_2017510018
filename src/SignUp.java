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
	private JTextArea tout; 
	private JTextArea resadd; 
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
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Sign Up"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 16); 
		c.add(title); 

		name = new JLabel("Name*"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(70, 98); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		surname = new JLabel("Surname*"); 
		surname.setFont(new Font("Arial", Font.PLAIN, 20)); 
		surname.setSize(100, 20); 
		surname.setLocation(70, 148);  
		c.add(surname); 

		sname = new JTextField(); 
		sname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sname.setSize(190, 20); 
		sname.setLocation(200, 150); 
		c.add(sname); 


		cmno = new JLabel("Country Code*"); 
		cmno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		cmno.setSize(150, 20); 
		cmno.setLocation(70, 198); 
		c.add(cmno); 

		ctmno = new JTextField(); 
		ctmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ctmno.setSize(50, 20); 
		ctmno.setLocation(200, 200); 
		c.add(ctmno); 

		mno = new JLabel("Phone Number*"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mno.setSize(150, 20); 
		mno.setLocation(70, 220); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(190, 20); 
		tmno.setLocation(260, 200); 
		c.add(tmno); 

		add = new JLabel("Street"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(100, 20); 
		add.setLocation(70, 297); 
		c.add(add);

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setFont(new Font("Arial", Font.PLAIN, 15)); 
		term.setSize(250, 20); 
		term.setLocation(150, 460); 
		c.add(term); 

		sub = new JButton("Sign Up"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 504); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(300, 504); 
		reset.addActionListener(this); 
		c.add(reset); 

		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(300, 400); 
		tout.setLocation(500, 100); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout);

		resadd = new JTextArea(); 
		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		resadd.setSize(200, 75); 
		resadd.setLocation(580, 175); 
		resadd.setLineWrap(true); 
		c.add(resadd);

		lblPassword = new JLabel("Password*");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(70, 256, 121, 20);
		getContentPane().add(lblPassword);

		res = new JLabel("");
		res.setBounds(500, 62, 299, 20);
		getContentPane().add(res);

		lblTown = new JLabel("Town");
		lblTown.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTown.setBounds(70, 338, 69, 20);
		getContentPane().add(lblTown);

		lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCity.setBounds(70, 386, 69, 20);
		getContentPane().add(lblCity);

		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDescription.setBounds(70, 422, 121, 24);
		getContentPane().add(lblDescription);

		passwordField = new JPasswordField();
		passwordField.setBounds(200, 256, 106, 26);
		getContentPane().add(passwordField);

		textField = new JTextField();
		textField.setBounds(200, 422, 216, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 380, 146, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(200, 336, 146, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(200, 298, 146, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setBounds(70, 59, 155, 29);
		getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.setBounds(271, 59, 155, 29);
		getContentPane().add(rdbtnNewRadioButton_1);

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
							newAdmin.createAdmin(newAdmin.getID_admin(),newAdmin, m.aList);
							m.selectfile(newAdmin.getID_admin()+","+info,1);
							
							System.out.println(newAdmin.toString());

						}
						else if (rdbtnNewRadioButton_1.isSelected()) {

							String info=  tname.getText()+","+sname.getText()+","+textField_3.getText()+","+textField_2.getText()+","+
									textField_1.getText()+","+textField.getText()+","+ctmno.getText()+","+tmno.getText()+","+passwordField.getText();

							
							Customer newCustomer = new Customer(tname.getText(),sname.getText(),new Address(textField_3.getText(),textField_2.getText(),textField_1.getText(),textField.getText()),new Phone(ctmno.getText(),tmno.getText()),passwordField.getText());
							newCustomer.CreateCustomer(newCustomer, m.cList);
							m.selectfile(newCustomer.getID_customer()+","+info,2);
						
							System.out.println(m.cList.toString());
						}
						tout.setText(data ); 
						tout.setEditable(false); 
						res.setText("Sign Up Successfully!"); 
						setVisible(false);
						Login l=new Login();

					} catch (QueueFull | IOException | QueueEmpty e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				else { 
					tout.setText(""); 
					resadd.setText(""); 
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
			tout.setText(def); 
			term.setSelected(false); 
			resadd.setText(def); 
			passwordField.setText(def);
			textField.setText(def);
			textField_1.setText(def);
			textField_2.setText(def);
			textField_3.setText(def);
		} 
	} 



} 




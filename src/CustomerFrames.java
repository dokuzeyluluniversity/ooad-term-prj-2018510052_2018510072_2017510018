import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CustomerFrames extends JFrame {
	
	private  JFrame  Restaurantlist;
	private  JFrame SetCustomerInfo;
	private  JFrame GiveOrder;
	private JPanel contentPane;
	private JPanel contentPane1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblDescription;
	private JTextField textField_8;
	private JTextField budget;
	private JTextField food;
	private JTextField[] res=new JTextField[2];
	public JFrame getGiveOrder() {
		return GiveOrder;
	}
	public JFrame getSetCustomerInfo() {
		return SetCustomerInfo;
	}
	
	public JFrame getRestaurantlist()
	{
		return Restaurantlist;
	}
	public void Restaurantlist() {
		Restaurantlist=new JFrame();
		Restaurantlist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Restaurantlist.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Restaurantlist.setContentPane(contentPane);
		Restaurantlist.getContentPane().setBackground(new Color(240, 128, 128));
		contentPane.setLayout(null);
		
		
		JButton btnrest = new JButton("OK");
		btnrest.setBounds(194, 402, 115, 29);
		getContentPane().add(btnrest);
		btnrest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Management m;
				try {
					m = new Management();
					for (int i = 0; i < m.rList.size(); i++) {
						res[i].setText(m.rList.get(i));
						food.setBounds(162, 123+2*i, 146+2*i, 26+2*i);
						contentPane.add(res[i]);
						res[i].setColumns(10);
						
					}
				} catch (QueueFull | IOException | QueueEmpty e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				JOptionPane.showMessageDialog(contentPane, "CHOOSED");}
		});
	}
	public void GiveOrder() {
		GiveOrder=new JFrame();
		GiveOrder.setTitle("GIVE ORDER");
		GiveOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GiveOrder.setBounds(100, 100, 450, 300);
		
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(250, 128, 114));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		GiveOrder.setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblBudget = new JLabel("BUDGET");
		lblBudget.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBudget.setForeground(new Color(0, 0, 255));
		lblBudget.setBounds(54, 49, 93, 20);
		contentPane1.add(lblBudget);
		
		budget = new JTextField();
		budget.setBounds(162, 46, 146, 26);
		contentPane1.add(budget);
		budget.setColumns(10);
		
		JLabel lblFood = new JLabel("FOOD");
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFood.setForeground(new Color(0, 0, 205));
		lblFood.setBounds(54, 126, 69, 20);
		contentPane1.add(lblFood);
		
		food = new JTextField();
		food.setBounds(162, 123, 146, 26);
		contentPane1.add(food);
		food.setColumns(10);
		
		JButton btnord = new JButton("OK");
		btnord.setBounds(173, 184, 115, 29);
		contentPane1.add(btnord);
		btnord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getRestaurantlist().setVisible(true);
				getGiveOrder().setVisible(false);
				Restaurantlist();
				
					JOptionPane.showMessageDialog(contentPane, "CHOOSED");}
		});
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrames frame = new CustomerFrames();
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
	public void CustomerFrames() {
		
	}
	public void SetCustomerInfo() {
		SetCustomerInfo=new JFrame();
		SetCustomerInfo.setTitle("SET INFORMATION");
		SetCustomerInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SetCustomerInfo.setBounds(100, 100, 529, 520);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SetCustomerInfo.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 48, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(15, 90, 69, 20);
		contentPane.add(lblSurname);
		
		JLabel lblCountrycode = new JLabel("CountryCode");
		lblCountrycode.setBounds(15, 126, 92, 20);
		contentPane.add(lblCountrycode);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(15, 148, 104, 20);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(15, 198, 69, 20);
		contentPane.add(lblPassword);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(15, 234, 69, 20);
		contentPane.add(lblStreet);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setBounds(15, 269, 69, 20);
		contentPane.add(lblTown);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(15, 303, 69, 20);
		contentPane.add(lblCity);
		
		textField = new JTextField();//name
		textField.setBounds(148, 45, 211, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//surname
		textField_1.setBounds(148, 87, 211, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();//countrycode
		textField_2.setBounds(148, 123, 54, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();//phone number
		textField_3.setBounds(205, 123, 154, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();//password
		textField_4.setBounds(148, 195, 211, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();//street
		textField_5.setBounds(148, 231, 211, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();//town
		textField_6.setBounds(148, 266, 211, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();//city
		textField_7.setBounds(148, 300, 211, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(377, 419, 115, 29);
		contentPane.add(btnOk);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(15, 354, 92, 20);
		contentPane.add(lblDescription);
		
		textField_8 = new JTextField();//desc
		textField_8.setBounds(148, 335, 211, 59);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Management	m = new Management();
					System.out.println("name,surname,address(street,town,city,description),phone(country code,number),password(leave only a comma between them)");
					m.cList.get(m.getCustomerid()).setUser(textField.getText(),textField_1.getText(), new Address(textField_5.getText(),textField_6.getText(),textField_7.getText(),textField_8.getText()),
							new Phone(textField_2.getText(),textField_3.getText()),textField_4.getText());
					System.out.println("Your information changed successfully!");
					System.out.println(m.cList.get(m.getCustomerid()).toString());
				
				} catch (QueueEmpty | QueueFull | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					JOptionPane.showMessageDialog(contentPane, "CHOOSED");}
		});
	}
}

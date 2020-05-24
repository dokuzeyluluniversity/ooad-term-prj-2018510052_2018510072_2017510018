import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SetUserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField street;
	private JTextField town;
	private JTextField city;
	private JTextField surname;
	private JTextField description;
	private JTextField cCode;
	private JTextField number;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblStreetName;
	private JLabel lblTown;
	private JLabel lblCity;
	private JLabel lblDescription;
	private JLabel lblCountryCode;
	private JLabel lblPhoneNumber;
	private JButton btnSave;
	private JTextField currentPassword;
	private JLabel lblCurrentPassword;
	private JPasswordField passwordField;
	private JLabel label_1;
	private JPasswordField passwordField_1;
	private JLabel label_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JTextField rName;
	private JLabel lblRestaurantName;


	/**
	 * Create the frame.
	 */
	public SetUserInfo(Admin a, boolean isUser) {
		setTitle(isUser?"SET USER INFORMATION":"SET RESTAURANT INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, isUser?"Set User Information":"Set Restaurant Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 625, 353);
		contentPane.add(panel);
		panel.setLayout(null);

		cCode = new JTextField();
		cCode.setBounds(70, 149, 116, 22);
		panel.add(cCode);
		cCode.setColumns(10);

		lblCountryCode = new JLabel("Country Code");
		lblCountryCode.setBounds(70, 131, 89, 16);
		panel.add(lblCountryCode);

		street = new JTextField();
		street.setBounds(70, 101, 116, 22);
		panel.add(street);
		street.setColumns(10);

		lblStreetName = new JLabel("Street");
		lblStreetName.setBounds(70, 84, 89, 16);
		panel.add(lblStreetName);

		number = new JTextField();
		number.setBounds(198, 149, 116, 22);
		panel.add(number);
		number.setColumns(10);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(198, 131, 94, 16);
		panel.add(lblPhoneNumber);

		town = new JTextField();
		town.setBounds(198, 101, 116, 22);
		panel.add(town);
		town.setColumns(10);

		lblTown = new JLabel("Town");
		lblTown.setBounds(198, 84, 56, 16);
		panel.add(lblTown);

		city = new JTextField();
		city.setBounds(326, 101, 116, 22);
		panel.add(city);
		city.setColumns(10);

		lblCity = new JLabel("City");
		lblCity.setBounds(326, 84, 56, 16);
		panel.add(lblCity);

		description = new JTextField();
		description.setBounds(454, 101, 116, 22);
		panel.add(description);
		description.setColumns(10);

		lblDescription = new JLabel("Description");
		lblDescription.setBounds(454, 84, 77, 16);
		panel.add(lblDescription);

		name = new JTextField();
		surname = new JTextField();
		passwordField = new JPasswordField();
		passwordField_1 = new JPasswordField();
		rName = new JTextField();
		if(isUser==true) {
			name.setBounds(70, 55, 116, 22);
			panel.add(name);
			name.setColumns(10);
			name.setText(a.getName());

			lblName = new JLabel("Name");
			lblName.setBounds(70, 38, 33, 16);
			panel.add(lblName);


			surname.setBounds(198, 55, 116, 22);
			panel.add(surname);
			surname.setColumns(10);

			lblSurname = new JLabel("Surname");
			lblSurname.setBounds(198, 38, 56, 16);
			panel.add(lblSurname);


			passwordField.setBounds(213, 211, 121, 22);
			panel.add(passwordField);

			label_1 = new JLabel("New Password");
			label_1.setBounds(213, 194, 84, 16);
			panel.add(label_1);


			passwordField_1.setBounds(213, 254, 121, 22);
			panel.add(passwordField_1);

			label_2 = new JLabel("Type Again");
			label_2.setBounds(213, 235, 84, 16);
			panel.add(label_2);

			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(199, 191, 152, 98);
			panel.add(separator);
		}
		else {

			rName.setBounds(70, 56, 126, 22);
			panel.add(rName);
			rName.setColumns(10);

			lblRestaurantName = new JLabel("Restaurant Name");
			lblRestaurantName.setBounds(70, 37, 116, 16);
			panel.add(lblRestaurantName);
		}

		currentPassword = new JPasswordField();
		currentPassword.setColumns(10);
		currentPassword.setBounds(70, 211, 116, 22);
		panel.add(currentPassword);

		lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(70, 194, 102, 16);
		panel.add(lblCurrentPassword);

		separator_1 = new JSeparator();
		separator_1.setBounds(70, 185, 265, 117);
		panel.add(separator_1);

		btnSave = new JButton("Save");
		if(isUser) {
			name.setText(a.getName());surname.setText(a.getSurname());cCode.setText(a.getPhone().getCountry_code());number.setText(a.getPhone().getNumber());
			street.setText(a.getAddress().getStreetName());town.setText(a.getAddress().getTown());city.setText(a.getAddress().getCity());description.setText(a.getAddress().getDescription());
		}
		else {
			rName.setText(a.getRestaurant().getRestaurant_name());cCode.setText(a.getRestaurant().getPhone().getCountry_code());number.setText(a.getRestaurant().getPhone().getNumber());
			street.setText(a.getRestaurant().getAddress().getStreetName());town.setText(a.getRestaurant().getAddress().getTown());city.setText(a.getRestaurant().getAddress().getCity());description.setText(a.getRestaurant().getAddress().getDescription());
		}


		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(passwordField.getText()+" "+passwordField_1.getText()+" "+currentPassword.getText());
				if(passwordField.getText().equals("")&&passwordField_1.getText().equals("")&&currentPassword.getText().equals(a.getPassword())) {//if the password hasn't changed.
					if(isUser) {
						a.setUser(name.getText(), surname.getText(), new Address(street.getText(),town.getText(),city.getText(),description.getText()), 
								new Phone(cCode.getText(),number.getText()), a.getPassword());
						try {//saving admin's data into the text file
							Management m = new Management();
							m.selectfile(m.findAdminid(a.getPhone().getNumber(),a.getPassword())+","+name.getText()+","+surname.getText()+","+	street.getText()+","+town.getText()+","+city.getText()+","+description.getText()+","+ 
									cCode.getText()+","+number.getText()+","+a.getPassword(),1);
						} catch (QueueFull | IOException | QueueEmpty e1) {
							e1.printStackTrace();
						}
					}
					else {
						a.setRestaurant(new Restaurant(rName.getText(), 
								new Address(street.getText(),town.getText(),city.getText(),description.getText()), 
								new Phone(cCode.getText(),number.getText())));
						try {//saving restaurant's data into the text file.
							Management m = new Management();
							m.selectfile(m.findAdminid(a.getPhone().getNumber(),a.getPassword())+","+rName.getText()+","+	street.getText()+","+town.getText()+","+city.getText()+","+description.getText()+","+ 
									cCode.getText()+","+number.getText()+","+a.getRestaurant().isShutDown(),3);
						} catch (QueueFull | IOException | QueueEmpty e1) {
							e1.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(getContentPane(),	"Your information has been changed.");
					setVisible(false);
					try {
						AdminMenu aMenu = new AdminMenu(a);
						aMenu.setVisible(true);
					} catch (QueueEmpty | QueueFull e1) {e1.printStackTrace();}
				}
				else {
					if(currentPassword.getText().equals(a.getPassword())) {//if old password entered correctly
						if(passwordField.getText().equals(passwordField_1.getText())) {//if the new passwords correct
							
							try {//saving admin's data into the text file
								Management m = new Management();
								m.selectfile(m.findAdminid(a.getPhone().getNumber(),a.getPassword())+","+name.getText()+","+surname.getText()+","+	street.getText()+","+town.getText()+","+city.getText()+","+description.getText()+","+ 
										cCode.getText()+","+number.getText()+","+passwordField.getText(),1);
							} catch (QueueFull | IOException | QueueEmpty e1) {
								e1.printStackTrace();
							}
							setVisible(false);
							try {
								AdminMenu aMenu = new AdminMenu(a);
								aMenu.setVisible(true);
							} catch (QueueEmpty | QueueFull e1) {e1.printStackTrace();}
							a.setUser(name.getText(), surname.getText(), new Address(street.getText(),town.getText(),city.getText(),description.getText()), 
									new Phone(cCode.getText(),number.getText()), passwordField.getText());
							JOptionPane.showMessageDialog(getContentPane(),	"Your information and password has been changed.");
						}
						else {
							JOptionPane.showMessageDialog(getContentPane(),	"Something went wrong. You entered different passwords.");
							currentPassword.setText("");passwordField.setText("");passwordField_1.setText("");
						}
					}
					else {//if old password entered wrong.
						JOptionPane.showMessageDialog(getContentPane(),	"Something went wrong. You should enter correct password.");
						currentPassword.setText("");passwordField.setText("");passwordField_1.setText("");
					}
				}
			}
		});
		btnSave.setBounds(264, 315, 97, 25);
		panel.add(btnSave);
	}
}

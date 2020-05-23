import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class AdminMenu extends JFrame {
	private JTable customerTable;
	private JTable foodMenu;
	private JTextField fName;
	private JTextField ingredients;
	private JTextField price;

	/**
	 * Launch the application.
	 * @throws QueueFull 
	 */
	

	/**
	 * Create the frame.
	 * @throws QueueEmpty 
	 * @throws QueueFull 
	 */
	public AdminMenu(Admin a) throws QueueEmpty, QueueFull {
		setResizable(false);
		setTitle("ONLINE FOOD SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 488);
		getContentPane().setLayout(null);

		JPanel customer = new JPanel();
		customer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customers in Line", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		customer.setBounds(28, 55, 809, 194);
		getContentPane().add(customer);
		customer.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 18, 791, 133);
		customer.add(scrollPane);


		/*String [][] cQueue = new String[a.getRestaurant().getCustomerqueue().size()][4];
		for (int i = 0; i < cQueue.length; i++) {
			if(a.getRestaurant().getCustomerqueue().size()>i) {
				cQueue[i]=((Customer)a.getRestaurant().getCustomerqueue().peek()).getCurrentOrderedFood(a.getRestaurant()).split("-");
			}
		}*/

		String [][] cQueue = new String[a.getRestaurant().getCustomerqueue().size()][5];
		for (int i = 0; i < cQueue.length; i++) {
			cQueue[i]=((Customer)a.getRestaurant().getCustomerqueue().peek()).toString().split("-");
			a.getRestaurant().getCustomerqueue().enqueue(a.getRestaurant().getCustomerqueue().dequeue());
		}
		customerTable = new JTable();
		scrollPane.setViewportView(customerTable);
		customerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		customerTable.setModel(new DefaultTableModel(cQueue,new String[] {"Order", "Name", "Surname", "Phone", "Address"}));
		//customerTable.getColumnModel().getColumn(0).setPreferredWidth(161);

		JButton btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
				int response = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to remove customer?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(getContentPane(),	"Customer has been removed.");
					try {
						a.getRestaurant().getCustomerqueue().dequeue();
					} catch (QueueEmpty e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					model.removeRow(0);
				}
			}
		});
		btnRemoveCustomer.setBounds(305, 156, 144, 25);
		customer.add(btnRemoveCustomer);

		JPanel food = new JPanel();
		food.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		food.setBounds(366, 262, 471, 172);
		getContentPane().add(food);
		food.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 13, 449, 117);
		food.add(scrollPane_1);

		foodMenu = new JTable();
		scrollPane_1.setViewportView(foodMenu);
		foodMenu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String [][] aFood = new String[a.getRestaurant().getFood().size()][4];
		for (int i = 0; i < aFood.length; i++) {
			if(a.getRestaurant().getFood().size()>i)
				aFood[i]=a.getRestaurant().getFood().get(i).toString().split("-");
		}
		foodMenu.setModel(new DefaultTableModel(aFood,new String[] {"Food Name", "Ingredients", "Price"}));

		JButton btnNewButton = new JButton("Remove Food From Menu");
		btnNewButton.setBounds(130, 143, 206, 25);
		food.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) foodMenu.getModel();
				int selectedRow=0;
				try {
					selectedRow = foodMenu.getSelectedRow();
					JOptionPane.showMessageDialog(getContentPane(),	model.getValueAt(selectedRow, 0)+" is removed");
					model.removeRow(selectedRow);
					a.getRestaurant().removeFood(a.getRestaurant().getFood().get(selectedRow));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getContentPane(),	"You should select a row to delete.");
				}
			}
		});
		foodMenu.getColumnModel().getColumn(2).setPreferredWidth(50);

		JPanel addFood = new JPanel();
		addFood.setBorder(new TitledBorder(null, "Add New Food to the Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addFood.setBounds(28, 262, 294, 150);
		getContentPane().add(addFood);
		addFood.setLayout(null);

		fName = new JTextField();
		fName.setBounds(28, 41, 116, 22);
		addFood.add(fName);
		fName.setColumns(10);

		ingredients = new JTextField();
		ingredients.setBounds(28, 86, 244, 22);
		addFood.add(ingredients);
		ingredients.setColumns(10);

		price = new JTextField();
		price.setBounds(156, 41, 116, 22);
		addFood.add(price);
		price.setColumns(10);

		JLabel lblFoodName = new JLabel("Food Name");
		lblFoodName.setBounds(28, 26, 74, 16);
		addFood.add(lblFoodName);

		JLabel lblIngredients = new JLabel("Ingredients");
		lblIngredients.setBounds(28, 69, 74, 16);
		addFood.add(lblIngredients);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(156, 26, 56, 16);
		addFood.add(lblPrice);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fName.getText().equals("")||ingredients.getText().equals("")||price.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(),	"You should fill all fields to add food.");
				}
				else {
					a.getRestaurant().getFood().add(new Food(fName.getText(), ingredients.getText(), Integer.parseInt(price.getText()), a.getRestaurant()));
					DefaultTableModel model = (DefaultTableModel) foodMenu.getModel();
					model.addRow(new Object[]{fName.getText(), ingredients.getText(), price.getText()});
					JOptionPane.showMessageDialog(getContentPane(),	fName.getText()+ " is added into your menu.");
					fName.setText("");ingredients.setText("");price.setText("");
				}
			}
		});
		btnOk.setBounds(98, 112, 97, 25);
		addFood.add(btnOk);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.ORANGE);
		menuBar.setBounds(0, 0, 199, 26);
		getContentPane().add(menuBar);

		JMenu mnUser = new JMenu("USER SETTINGS");
		mnUser.setIcon(new ImageIcon(AdminMenu.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		mnUser.setForeground(Color.GRAY);
		mnUser.setBackground(Color.LIGHT_GRAY);
		mnUser.setFont(new Font("Californian FB", Font.PLAIN, 23));
		menuBar.add(mnUser);

		JMenuItem mn�tmSetUserInfo = new JMenuItem("Set User Information");
		mn�tmSetUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SetUserInfo frame = new SetUserInfo(a,true);
				setVisible(false);
				frame.setVisible(true);
				
			}
		});
		mn�tmSetUserInfo.setIcon(new ImageIcon(AdminMenu.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		mnUser.add(mn�tmSetUserInfo);

		JMenuItem mn�tmSetRestaurantInformation = new JMenuItem("Set Restaurant Information");
		mn�tmSetRestaurantInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetUserInfo frame = new SetUserInfo(a,false);
				customerTable.removeAll();
				setVisible(false);
				frame.setVisible(true);
			}
		});
		mn�tmSetRestaurantInformation.setIcon(new ImageIcon(AdminMenu.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		mnUser.add(mn�tmSetRestaurantInformation);

		JMenuItem mn�tmShutDownRestaurant = new JMenuItem("Shut Down Restaurant");
		mn�tmShutDownRestaurant.setIcon(new ImageIcon(AdminMenu.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		mn�tmShutDownRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to delete your account?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(AdminMenu.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
				if(response == JOptionPane.YES_OPTION) {
					a.getRestaurant().setShutDown(true);
					JOptionPane.showMessageDialog(getContentPane(),	"Your restaurant has been shut downed.");
					System.exit(0);
				}
			}
		});
		mnUser.add(mn�tmShutDownRestaurant);

		JLabel lblNewLabel = new JLabel(a.getRestaurant().getRestaurant_name());
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 25));
		lblNewLabel.setBounds(431, 13, 378, 35);
		getContentPane().add(lblNewLabel);


	}
}

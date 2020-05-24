import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Customerframe extends JFrame {


	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JMenuBar Settings;
	private JMenuItem mnýtmLogout;
	private JMenuItem mnýtmSetUserInformation;
	private JMenu mnNewMenu;
	private JTextField budget;
	private JTextField food;
	DefaultTableModel model;
	private JTable table_2;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Customerframe(ArrayList<Admin> aList,ArrayList<Food> fList,ArrayList<Customer> cList,Customer c) {

		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Display Orders", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(44, 261, 446, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 31, 418, 137);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
				},
				new String[] {
						"Food Name", "Restaurant Name", "Price"
				}
				));


		table.getColumnModel().getColumn(0).setPreferredWidth(159);
		table.getColumnModel().getColumn(1).setPreferredWidth(184);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Display Food", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(34, 32, 456, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 16, 426, 150);
		panel_1.add(scrollPane_1);

		String [][] allfood=new String[fList.size()][4];

		for (int i = 0; i < allfood.length  ; i++) {

			allfood[i]=fList.get(i).toString().split("-");
			/*	String s="makarna,irem,tuz,3";
			String [] sp=s.split(",");
			allfood[0][0]=sp[0];
			allfood[0][1]=sp[1];
			allfood[0][2]=sp[2];
			allfood[0][3]=sp[3];
			String s2="çorba,irem,tuz,44";
			String [] sp2=s2.split(",");
			allfood[1][0]=sp2[0];
			allfood[1][1]=sp2[1];
			allfood[1][2]=sp2[2];
			allfood[1][3]=sp2[3];
			String s3="makarna,irem,tuz,30";
			String [] sp3=s3.split(",");
			allfood[2][0]=sp3[0];
			allfood[2][1]=sp3[1];
			allfood[2][2]=sp3[2];
			allfood[2][3]=sp3[3];

			 */
		}
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {
						"Food Name","Ingredients","Price","Restaurant Name"
		}
				));

		table_1.getColumnModel().getColumn(0).setPreferredWidth(153);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(167);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane_1.setViewportView(table_1);
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setBounds(168, 171, 115, 29);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int j = 0; j < c.getOrders().size(); j++) {
					DefaultTableModel model2 = (DefaultTableModel) table.getModel();
					model2.addRow(new Object[]{c.getOrders().get(j)});
				}

			}
		});
		JButton btnNewButton = new JButton("G\u0131ve Order");
		btnNewButton.setBounds(181, 171, 115, 29);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int selectedRow = table_1.getSelectedRow();
					for (int i = 0; i < aList.size(); i++) {
						
						if(((String)table_1.getValueAt(selectedRow, 3)).trim().equals(aList.get(i).getRestaurant().getRestaurant_name().trim())) {
							Management m = new Management();
							m.selectfile(m.findAdminid(aList.get(i).getPhone().getNumber(), aList.get(i).getPassword())+";"+m.findcustomerid(c.getPhone().getNumber(), c.getPassword())+";"+
									table_1.getValueAt(selectedRow, 0)+";"+((String)table_1.getValueAt(selectedRow, 3)).replace("[", "").replace("]", "") +";"+table_1.getValueAt(selectedRow, 2), 5);
							
							aList.get(i).getRestaurant().setCustomerqueue(c);
							//System.out.println(cList.get(c.getID_customer()).getName());
							c.setOrders(aList.get(i).getRestaurant().FindFood(aList.get(i).getRestaurant(), food.getText()));
							JOptionPane.showMessageDialog(getContentPane(),	"Your order has been received!");
							
						}
						else {
							System.out.println(aList.get(i).getRestaurant().getRestaurant_name()+"      "+table_1.getValueAt(selectedRow, 3));
						}

					}

				} catch (Exception e1) {

				}
			}
		});

		Settings = new JMenuBar();
		Settings.setBounds(0, 0, 139, 31);
		contentPane.add(Settings);

		mnNewMenu = new JMenu("Settings");
		Settings.add(mnNewMenu);

		mnýtmLogout = new JMenuItem("LogOut");
		mnNewMenu.add(mnýtmLogout);
		mnýtmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login l =new Login();
				l.setVisible(true);

			}
		});

		mnýtmSetUserInformation = new JMenuItem("Set User Information");
		mnNewMenu.add(mnýtmSetUserInformation);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Food", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(562, 32, 343, 200);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		food = new JTextField();
		food.setBounds(115, 95, 146, 26);
		panel_2.add(food);
		food.setColumns(10);

		budget = new JTextField();
		budget.setBounds(115, 50, 146, 26);
		panel_2.add(budget);
		budget.setColumns(10);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean flag=false;

				for (int i = 0; i < allfood.length; i++) {

					if(Integer.valueOf(budget.getText())>=Integer.valueOf(allfood[i][2])&&food.getText().equals(allfood[i][0])) {
						flag=true;
						model = (DefaultTableModel) table_1.getModel();
						model.addRow(new Object[]{food.getText(), allfood[i][1],allfood[i][2], allfood[i][3]});
					}

				}

				if(flag==false) {
					food.setText("");budget.setText("");
					JOptionPane.showMessageDialog(getContentPane(),	"Not Found!");
				}


			}
		});





		btnSearch.setBounds(115, 152, 115, 29);
		panel_2.add(btnSearch);

		JLabel lblNewLabel = new JLabel("Budget");
		lblNewLabel.setBounds(31, 53, 69, 20);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Food");
		lblNewLabel_1.setBounds(36, 98, 69, 20);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "All Foods", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(556, 261, 355, 200);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 18, 343, 169);
		panel_3.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				allfood,
				new String[] {
						"Food Name", "Ingredients", "Price", "Restaurant Name"
				}
				));
		scrollPane_2.setViewportView(table_2);
	}
}

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
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FRAME extends JFrame {
	public FRAME() {
	}

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRAME frame = new FRAME();
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
	public void cFRAME(ArrayList<Admin> aList,Customer c,ArrayList<Food> fList) {
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Display Orders", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(44, 230, 426, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 31, 405, 103);
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
		panel_1.setBounds(34, 32, 436, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 16, 415, 150);
		panel_1.add(scrollPane_1);
		String [][] allfood=new String[fList.size()][4];
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Food Name", "Restaurant Name", "Ingredients", "Price"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(153);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(167);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane_1.setViewportView(table_1);
		
		Settings = new JMenuBar();
		Settings.setBounds(0, 0, 139, 31);
		contentPane.add(Settings);
		
		mnNewMenu = new JMenu("Settings");
		Settings.add(mnNewMenu);
		
		mnýtmLogout = new JMenuItem("LogOut");
		mnNewMenu.add(mnýtmLogout);
		
		mnýtmSetUserInformation = new JMenuItem("Set User Information");
		mnNewMenu.add(mnýtmSetUserInformation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Give Order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(570, 55, 343, 210);
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
	}
}

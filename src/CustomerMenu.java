
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.BorderLayout;


public class CustomerMenu extends JFrame {

	private JFrame frame;
	private JRadioButton rbtnsetinfo;
	private JRadioButton rbtnOrder;
	private JRadioButton rbtnDisplayorders;
	private JRadioButton rbtnDisplayAllP;
	private JRadioButton rbtnDisplayAllS;
	private JRadioButton rbtnSearch;
	private JRadioButton rbtnadd;
	private JRadioButton rbtnExit;
	private JRadioButton rbtnshutdown;


	public  CustomerMenu(String number ,String password) 
	{

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 286);
		frame.getContentPane().setBackground(new Color(250, 128, 114));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //specify one of several options for the close button, Exit the application
		frame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("OPTIONS");
		lblMenu.setBounds(123, 30, 118, 14);
		frame.getContentPane().add(lblMenu);


		rbtnsetinfo = new JRadioButton("Set User Information");
		rbtnsetinfo.setBounds(60, 51, 181, 23);
		rbtnsetinfo.setSelected(true);
		frame.getContentPane().add(rbtnsetinfo);


		rbtnOrder = new JRadioButton("Give Order");
		rbtnOrder.setBounds(60, 77, 323, 23);
		frame.getContentPane().add(rbtnOrder);

		rbtnDisplayorders = new JRadioButton("Display All Orders");
		rbtnDisplayorders.setBounds(60, 103, 213, 23);
		frame.getContentPane().add(rbtnDisplayorders);



		rbtnExit = new JRadioButton("Exit");
		rbtnExit.setBounds(60, 155, 109, 23);
		frame.getContentPane().add(rbtnExit);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rbtnsetinfo);
		btnG.add(rbtnDisplayorders);
		btnG.add(rbtnOrder);
		btnG.add(rbtnDisplayAllP);
		btnG.add(rbtnDisplayAllS);
		btnG.add(rbtnSearch);
		btnG.add(rbtnExit);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (rbtnsetinfo.isSelected())
				{
					CustomerFrames cf=new CustomerFrames();
					cf.SetCustomerInfo(number,password);
					cf.getSetCustomerInfo().setVisible(true);

					frame.setVisible(false);
				}
				else if(rbtnOrder.isSelected())
				{
					CustomerFrames cf=new CustomerFrames();
					cf.GiveOrder();
					cf.getGiveOrder().setVisible(true);
					frame.setVisible(false);

				}


			}
		});
		btnOk.setBounds(218, 193, 89, 23);
		frame.getContentPane().add(btnOk);

	}





	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

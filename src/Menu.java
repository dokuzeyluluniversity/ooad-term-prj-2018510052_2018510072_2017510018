
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.BorderLayout;


public class Menu extends JFrame {
	public Menu() {

	}

	private JFrame frame;
	private JRadioButton rbtnsetinfo;
	private JRadioButton rbtnDisplayAllP;
	private JRadioButton rbtnDisplayAllS;
	private JRadioButton rbtnSearch;
	private JRadioButton rbtnadd;
	private JRadioButton rbtnExit;
	private JRadioButton rbtnshutdown;


	public void cMenu(boolean flag) 
	{

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 286);
		frame.getContentPane().setBackground(new Color(250, 128, 114));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //specify one of several options for the close button, Exit the application
		frame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("OPTIONS");
		lblMenu.setBounds(123, 30, 46, 14);
		frame.getContentPane().add(lblMenu);
		

		rbtnsetinfo = new JRadioButton("Set User Information");
		rbtnsetinfo.setBounds(60, 51, 109, 23);
		rbtnsetinfo.setSelected(true);
		frame.getContentPane().add(rbtnsetinfo);

		////////CUSTOMER
		if(flag) {
			rbtnDisplayAllP = new JRadioButton("Give Order");
			rbtnDisplayAllP.setBounds(60, 77, 323, 23);
			frame.getContentPane().add(rbtnDisplayAllP);
			//////budget gircek, istediði food girilcek  restaurantlar sýralýncak
			rbtnDisplayAllS = new JRadioButton("Display All Orders");
			rbtnDisplayAllS.setBounds(60, 103, 213, 23);
			frame.getContentPane().add(rbtnDisplayAllS);

		}////admin
		else {
			rbtnDisplayAllP = new JRadioButton("Remove Food");
			rbtnDisplayAllP.setBounds(60, 77, 323, 23);
			frame.getContentPane().add(rbtnDisplayAllP);

			rbtnadd = new JRadioButton("Add Food");
			rbtnadd.setBounds(60, 77, 323, 23);
			frame.getContentPane().add(rbtnadd);

			rbtnDisplayAllS = new JRadioButton("Display All Customers");
			rbtnDisplayAllS.setBounds(60, 103, 213, 23);
			frame.getContentPane().add(rbtnDisplayAllS);

			rbtnshutdown = new JRadioButton("Shut Down Restaurant");
			rbtnshutdown.setBounds(60, 130, 213, 23);
			frame.getContentPane().add(rbtnshutdown);

		}

		rbtnExit = new JRadioButton("Exit");
		rbtnExit.setBounds(60, 155, 109, 23);
		frame.getContentPane().add(rbtnExit);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rbtnsetinfo);
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
					Framesmenu f=new Framesmenu();
				
					//f.SetInformationAdmin();
					f.getAdmin().setVisible(true);
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

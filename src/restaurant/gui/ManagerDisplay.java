package restaurant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import restaurant.filesWork.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ManagerDisplay extends JFrame {

	private JPanel contentPane;
	Orders orders;
	SpecificTables spTables;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ManagerDisplay(Orders orders,SpecificTables spTables) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCustomers = new JButton("Daily review");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Manager2nd m2=new Manager2nd(orders,spTables);
			m2.setVisible(true);dispose();
			}
		});
		btnCustomers.setBounds(257, 78, 163, 36);
		contentPane.add(btnCustomers);
		
		JButton btnDishes = new JButton("Chef display");
		btnDishes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CookerDisplay cood=new CookerDisplay(orders,spTables);
				cood.setVisible(true);dispose();
			}
		});
		btnDishes.setBounds(257, 116, 163, 36);
		contentPane.add(btnDishes);
		
		JButton btnTables = new JButton("Waiter Display");
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaiterDisplay wd=new WaiterDisplay(orders,spTables);
				wd.setVisible(true);dispose();
			}
		});
		btnTables.setBounds(257, 154, 163, 36);
		contentPane.add(btnTables);
		
		JButton btnstatistics = new JButton("Statistics");
		btnstatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Statistics st=new Statistics(orders,spTables);
			st.setVisible(true);dispose();
			}
		});
		btnstatistics.setBounds(257, 192, 163, 38);
		contentPane.add(btnstatistics);
		
		JLabel lblNewLabel = new JLabel("Only manager is allowed to acces this screen");
		lblNewLabel.setBounds(145, 227, 275, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(257, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("managerpic2.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(0, 0, 254, 230);
		contentPane.add(lblNewLabel_2);
	}
}

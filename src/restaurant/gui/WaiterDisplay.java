package restaurant.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import java.awt.Font;

public class WaiterDisplay extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	SpecificTables spTables;
	Orders order;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public WaiterDisplay(Orders order,SpecificTables spTables) {
		Customer c=new Customer();SpecificTable spTable=new SpecificTable();Orders od=new Orders();List<Order> odList=new ArrayList<>();
		try {
		od.setOrders(order.getOrders());
		}catch(NullPointerException e) {
			od.setOrders(odList);
		}
		SpecificTables speciTables=new SpecificTables();
		List<SpecificTable> speciList=new ArrayList<>();
		try {
			speciTables.setSpTables(spTables.getSpTables());
		}catch(NullPointerException e) {
			speciTables.setSpTables(speciList);
		}
		try {
			c.takeData();
		}catch(JAXBException e) {
			System.out.println("caught jaxb");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(257, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("Waiterpic2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 0, 152, 253);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(154, 77, 279, 138);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		//table_1.setBounds(154, 77, 279, 138);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"Customer", "Table", "Seats", "Smoker"}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables= new boolean[] {
					false,false,false,false
			};
			public boolean isCellEditable(int row,int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		for(SpecificTable t:speciTables.getSpTables()) {
			DefaultTableModel model=(DefaultTableModel)table_1.getModel();
			model.addRow(new Object [] {t.getCustomerName(),t.getTableNumber(),t.getNoofseats(),t.isSmoking()});
			}
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstDisplay fd=new FirstDisplay(order,spTables);
				fd.setVisible(true);dispose();
			}
		});
		btnNewButton.setBounds(294, 221, 126, 28);
		btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton);
	}
}

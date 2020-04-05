package restaurant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Orders orders;SpecificTables spTables;
private JLabel lblNewLabel_1;
	
	
	public SignUp(Orders orders,SpecificTables spTables) {
		User newUser=new User();Customer c=new Customer();ToUpdate to=new ToUpdate();
		try {
			c.takeData();
		}catch(JAXBException e) {
			System.out.println("error in new user reading");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(89, 64, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblUsername.setBounds(70, 106, 80, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(70, 151, 80, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(145, 61, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setOpaque(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(145, 103, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setOpaque(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(145, 148, 143, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConfirm = new JButton("Sign Me Up");
		btnConfirm.setOpaque(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setBorder(null);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			newUser.setName(textField.getText());newUser.setUsername(textField_1.getText());
			newUser.setPassword(textField_2.getText());newUser.setRole("Client");
			c.userList.add(newUser);
			try {
				to.signUp(c.userList, c.tableList, c.dishList);
			} catch (JAXBException e) {
				System.out.println("error in writing new user to file");
			}
			FirstDisplay fd=new FirstDisplay(orders,spTables);
			fd.setVisible(true);dispose();
			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnConfirm.setBounds(172, 189, 116, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			FirstDisplay fd=new FirstDisplay(orders,spTables);
			fd.setVisible(true);dispose();
		}});
		btnCancel.setBounds(182, 215, 97, 25);
		btnCancel.setOpaque(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		contentPane.add(btnCancel);
		
		lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("signup.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(-47, -36, 493, 300);
		contentPane.add(lblNewLabel_1);
		
	}
}

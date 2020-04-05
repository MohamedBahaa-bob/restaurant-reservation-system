package restaurant.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import restaurant.Users.Cooker;
import restaurant.Users.Customer;
import restaurant.Users.Manager;
import restaurant.filesWork.Orders;
import restaurant.filesWork.SpecificTables;
import restaurant.filesWork.ToUpdate;
import restaurant.filesWork.UserData;
import restaurant.Users.Waiter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import java.awt.Font;

public class FirstDisplay extends JFrame {
	Customer c=new Customer();
	Orders orders;SpecificTables spTables;

	private JPanel contentPane;
	private JTextField textField_2;
	private JRadioButton rdbtnManager;
	private JRadioButton rdbtnWaiter;
	private JRadioButton rdbtnCooker;
	private JRadioButton rdbtnClient;
	private final javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Orders orders=null;ToUpdate to=new ToUpdate();
				try {
					orders=to.readUpdated();
				} catch (JAXBException e1) {
				}
				SpecificTables spTables=null;
				try {
					spTables=to.readUpdatedTables();
				} catch (Exception e) {
					//e.printStackTrace();
				}
				try {
				FirstDisplay frame = new FirstDisplay(orders,spTables);
				frame.setVisible(true);
			}catch(Exception e) {}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstDisplay(Orders orders,SpecificTables spTables) {
		UserData data=new UserData();Manager manager=new Manager();Waiter waiter=new Waiter();Cooker cooker=new Cooker();
		try{
			data.takeData();
		}catch(JAXBException e) {
			JOptionPane.showMessageDialog(rootPane,"Error in finding source file");
		}
		try{
			manager.takeData();
		}catch(JAXBException e1) {
			//JOptionPane.showMessageDialog(rootPane,"Error in finding source file");
		}
		try{
			waiter.takeData();
		}catch(JAXBException e2) {
			//JOptionPane.showMessageDialog(rootPane,"Error in finding source file");
		}
		try{
			cooker.takeData();
		}catch(JAXBException e3) {
			//JOptionPane.showMessageDialog(rootPane,"Error in finding source file");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseMainDish = new JLabel("Username:");
		lblChooseMainDish.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblChooseMainDish.setBounds(40, 74, 80, 17);
		contentPane.add(lblChooseMainDish);
		
		JLabel lblInsertPass = new JLabel("Password:");
		lblInsertPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInsertPass.setBounds(40, 110, 80, 14);
		contentPane.add(lblInsertPass);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_2.setBorder(null);
		textField_2.setBounds(118, 72, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(257, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		rdbtnManager = new JRadioButton("Manager",false);
		rdbtnManager.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buttonGroup.add(rdbtnManager);
		rdbtnManager.setBackground(Color.WHITE);

		rdbtnManager.setBounds(50, 147, 89, 23);
		contentPane.add(rdbtnManager);
		
		rdbtnWaiter = new JRadioButton("Waiter",false);
		rdbtnWaiter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buttonGroup.add(rdbtnWaiter);
		rdbtnWaiter.setBackground(Color.WHITE);

		rdbtnWaiter.setBounds(154, 147, 86, 23);
		contentPane.add(rdbtnWaiter);
		
	    rdbtnCooker = new JRadioButton("Cooker",false);
	    rdbtnCooker.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    buttonGroup.add(rdbtnCooker);
	    rdbtnCooker.setForeground(Color.BLACK);
	    rdbtnCooker.setBackground(Color.WHITE);
	  
		rdbtnCooker.setBounds(244, 147, 80, 23);
		contentPane.add(rdbtnCooker);
		
		rdbtnClient = new JRadioButton("Client",false);
		rdbtnClient.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buttonGroup.add(rdbtnClient);
		rdbtnClient.setBackground(Color.WHITE);
		
		rdbtnClient.setBounds(328, 147, 80, 23);
		contentPane.add(rdbtnClient);
		
		btnNewButton = new JButton("Sign Up");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			SignUp su=new SignUp(orders,spTables);
			su.setVisible(true);dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(235, 192, 89, 24);
		contentPane.add(btnNewButton);
		
		JButton btnSignIn = new JButton("Log In");
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignIn.setBackground(Color.WHITE);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean selected1=false,selected2=false,selected3=false,selected4=false,same;
				selected1=rdbtnManager.isSelected();
				selected2=rdbtnWaiter.isSelected();
				selected3=rdbtnCooker.isSelected();
				selected4=rdbtnClient.isSelected();
				String str= passwordField.getText();
				String string=textField_2.getText();
				if(selected1) {
				same=manager.compareWithDB(string,str);
				if(same) {
					ManagerDisplay md= new ManagerDisplay(orders,spTables);
					md.setVisible(true);dispose();	
				}}else if(selected2) {
					same=waiter.compareWithDB(string,str);
					if(same) {
					WaiterDisplay wd=new WaiterDisplay(orders,spTables);
					wd.setVisible(true);dispose();
					}
				}else if(selected3) {
					same=cooker.compareWithDB(string,str);
					if(same) {
						CookerDisplay cood=new CookerDisplay(orders,spTables);
						cood.setVisible(true);dispose();
					}
				}else if(selected4) {
					same=data.compareWithDB(string,str);
					if(same) {
						TableDisplay tb=new TableDisplay(orders,data.getNameOfUser(string, str,"Client"),spTables);
						tb.setVisible(true);dispose();
					}
				}else {
					JOptionPane.showMessageDialog(rootPane,"You didn't select role");
				}
				
				}
		});
		btnSignIn.setBounds(128, 192, 89, 23);
		contentPane.add(btnSignIn);
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 13));
		passwordField.setBorder(null);
		passwordField.setBounds(118, 107, 124, 20);
		contentPane.add(passwordField);
		
		
	}
}

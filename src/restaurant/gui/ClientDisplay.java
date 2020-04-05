package restaurant.gui;

import java.awt.BorderLayout;
import javax.xml.bind.JAXBContext;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ClientDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField finalText;
	private JLabel lblNewLabel_1;
	private JEditorPane editorPane;
	Orders orders;SpecificTables spTables;
	float appetizerTotal=0,mainCourseTotal=0,dessertTotal=0,finalTotal=0;
	float[]dishPrice,dishPrice1,dishPrice2;
	int[] dishCount,dishCount1,dishCount2;
	
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ClientDisplay(Orders orders,int tableNumber,SpecificTables spTables,String customerName) {
		Customer c=new Customer();Order d=new Order();Orders od=new Orders();List<Order> odList=new ArrayList<>();
		ToUpdate to=new ToUpdate();
		try {
			od.setOrders(orders.getOrders());
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
		setBounds(550, 200, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(505, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(460, 77, 220, 275);
		Image img2= new ImageIcon(this.getClass().getResource("client.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(c.getDishNames("Appetizer",0));
		dishCount=new int[comboBox.getItemCount()];dishPrice=new float[comboBox.getItemCount()];
		dishPrice=c.getDishPrice("Appetizer");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange()==ItemEvent.SELECTED) {
				textField.setText(String.valueOf(dishCount[comboBox.getSelectedIndex()]));
			}
				
			}
		});
		comboBox.setSelectedIndex(0);
		comboBox.setEditable(false);
		comboBox.setBounds(20, 37, 164, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(c.getDishNames("Main_course",0));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(20, 113, 164, 22);
		dishCount1=new int[comboBox_1.getItemCount()];dishPrice1=new float[comboBox_1.getItemCount()];
		dishPrice1=c.getDishPrice("Main_course");
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange()==ItemEvent.SELECTED) {
				textField_2.setText(String.valueOf(dishCount1[comboBox_1.getSelectedIndex()]));
			}
				
			}
		});
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(c.getDishNames("desert",0));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(20, 196, 164, 22);
		dishCount2=new int[comboBox_2.getItemCount()];dishPrice2=new float[comboBox_2.getItemCount()];
		dishPrice2=c.getDishPrice("desert");
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange()==ItemEvent.SELECTED) {
				textField_3.setText(String.valueOf(dishCount2[comboBox_2.getSelectedIndex()]));
			}
				
			}
		});
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(textField.getText())>0) {
				textField.setText(String.valueOf(Integer.valueOf(textField.getText())-1));
				dishCount[comboBox.getSelectedIndex()]-=1;appetizerTotal-=dishPrice[comboBox.getSelectedIndex()];
				finalTotal-=dishPrice[comboBox.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
				}
				}
		});
		button.setBounds(213, 37, 41, 23);
		contentPane.add(button);
		
		textField = new JTextField("0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(264, 38, 37, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textField.setText(String.valueOf(Integer.valueOf(textField.getText())+1));
			dishCount[comboBox.getSelectedIndex()]+=1;appetizerTotal+=dishPrice[comboBox.getSelectedIndex()];
			finalTotal+=dishPrice[comboBox.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
			}
		});
		button_1.setBounds(311, 37, 41, 23);
		contentPane.add(button_1);
		
		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.valueOf(textField_2.getText())>0) {
				textField_2.setText(String.valueOf(Integer.valueOf(textField_2.getText())-1));
				dishCount1[comboBox_1.getSelectedIndex()]-=1;mainCourseTotal-=dishPrice1[comboBox_1.getSelectedIndex()];
				finalTotal-=dishPrice1[comboBox_1.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
				}
				}
		});
		button_4.setBounds(213, 112, 41, 23);
		contentPane.add(button_4);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("0");
		textField_2.setBounds(264, 113, 35, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(String.valueOf(Integer.valueOf(textField_2.getText())+1));
				dishCount1[comboBox_1.getSelectedIndex()]+=1;mainCourseTotal+=dishPrice1[comboBox_1.getSelectedIndex()];
				finalTotal+=dishPrice1[comboBox_1.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
			}
		});
		button_5.setBounds(311, 112, 41, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(textField_3.getText())>0) {
				textField_3.setText(String.valueOf(Integer.valueOf(textField_3.getText())-1));
				dishCount2[comboBox_2.getSelectedIndex()]-=1;dessertTotal-=dishPrice2[comboBox_2.getSelectedIndex()];
				finalTotal-=dishPrice2[comboBox_2.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
				}
				}
		});
		button_6.setBounds(213, 195, 41, 23);
		contentPane.add(button_6);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("0");
		textField_3.setBounds(266, 196, 35, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(String.valueOf(Integer.valueOf(textField_3.getText())+1));
				dishCount2[comboBox_2.getSelectedIndex()]+=1;dessertTotal+=dishPrice2[comboBox_2.getSelectedIndex()];
				finalTotal+=dishPrice2[comboBox_2.getSelectedIndex()];finalText.setText("$ "+String.valueOf(finalTotal));
			}
		});
		button_7.setBounds(311, 195, 41, 23);
		contentPane.add(button_7);
		
		
		ActionListener messagePrint = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstDisplay fd=new FirstDisplay(od,spTables);
				fd.setVisible(true);
			}
			};
			final Timer mytimer= new Timer(1000, messagePrint);
		
		JButton btnDone = new JButton("Confirm");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d.setAppetizerNames(c.getDishNames("appetizer"));d.setMainCourseNames(c.getDishNames("main_course"));
				d.setDessertNames(c.getDishNames("desert"));
				appetizerTotal*=1.1;mainCourseTotal*=1.15;dessertTotal*=1.2;
				finalTotal=appetizerTotal+mainCourseTotal+dessertTotal;
				d.setAppetizerPrices(appetizerTotal);d.setMainCoursePrices(mainCourseTotal);
				d.setDessertPrices(dessertTotal);
				d.setTotal(finalTotal);d.setTableNumber(tableNumber);d.setCustomerName(customerName);
				d.setAppetizerCount(dishCount);d.setMainCourseCount(dishCount1);d.setDessertCount(dishCount2);
				d.setSpecialReq(editorPane.getText());
				finalText.setText("Total:$ "+finalTotal);
				od.getOrders().add(d);
				try {
					to.writeFile(od,speciTables);
				} catch (JAXBException e) {
					System.out.println("error in writing");
				}
				mytimer.start();
				mytimer.setRepeats(false);
				dispose();
			}
		});
		btnDone.setBounds(20, 290, 99, 39);
		contentPane.add(btnDone);
		
		
		JLabel lblAppetizers = new JLabel("Appetizers");
		lblAppetizers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppetizers.setBounds(20, 12, 164, 14);
		contentPane.add(lblAppetizers);
		
		JLabel lblMainCourses = new JLabel("Main Courses");
		lblMainCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainCourses.setBounds(20, 79, 164, 23);
		contentPane.add(lblMainCourses);
		
		JLabel lblDesserts = new JLabel("Desserts");
		lblDesserts.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesserts.setBounds(20, 163, 164, 22);
		contentPane.add(lblDesserts);
		
		finalText = new JTextField();
		finalText.setEditable(false);
		finalText.setHorizontalAlignment(SwingConstants.CENTER);
		finalText.setBounds(20, 257, 99, 20);
		contentPane.add(finalText);
		finalText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Special requests:");
		lblNewLabel_2.setBounds(176, 233, 125, 29);
		contentPane.add(lblNewLabel_2);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		editorPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		editorPane.setBounds(165, 257, 258, 72);
		contentPane.add(editorPane);
	}
}

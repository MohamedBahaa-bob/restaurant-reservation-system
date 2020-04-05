package restaurant.gui;            
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class TableDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	int[]specificTableNumbers;int finalTableNumber;
	int[] spSeats;
	boolean[] spSmoking;
	int finalSeats;
	boolean finalSmoking,finalReserved;
	Table table;Orders orders;SpecificTables spTables;
	String[] comboBoxDisplay;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public TableDisplay(Orders orders,String customerName,SpecificTables spTables) {
		Customer c=new Customer();SpecificTable spTable=new SpecificTable();SpecificTables speciTables=new SpecificTables();
		List<SpecificTable> speciList=new ArrayList<>();Orders od=new Orders();List<Order> odList=new ArrayList<>();
		try {
		od.setOrders(orders.getOrders());
		}catch(NullPointerException e) {
			od.setOrders(odList);
		}
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
		int count=c.numberOfTables().size();int[]tableNumber=new int[count],numberOfSeats=new int[count];
		boolean[]smoking=new boolean[count];int i=0;
		for(Table table:c.numberOfTables()) {
			tableNumber[i]=table.getNumber();numberOfSeats[i]=table.getNumber_of_seats();
			smoking[i]=table.isSmoking();i++;
		}
		
		int [] reservedTables=new int[count];int y=0;
		for(Order order:od.getOrders()) {
			reservedTables[y]=order.getTableNumber();y++;
		}
		//for(y;y<count;y++) reservedTables[y]=-1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumberOfSeats = new JLabel("Desired Number Of Seats");
		lblNumberOfSeats.setForeground(Color.WHITE);
		lblNumberOfSeats.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNumberOfSeats.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfSeats.setBounds(56, 81, 183, 20);
		contentPane.add(lblNumberOfSeats);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField.setBorder(null);
		textField.setBackground(Color.DARK_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(118, 112, 55, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSmoking = new JLabel("Smoking");
		lblSmoking.setForeground(Color.WHITE);
		lblSmoking.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblSmoking.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmoking.setBounds(397, 81, 77, 20);
		contentPane.add(lblSmoking);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setForeground(Color.WHITE);
		rdbtnYes.setOpaque(false);
		rdbtnYes.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		buttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(364, 117, 77, 23);
		contentPane.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setOpaque(false);
		rdbtnNo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		rdbtnNo.setSelected(true);
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNo.setBounds(443, 117, 85, 23);
		contentPane.add(rdbtnNo);
		
		JTextArea lblChoose = new JTextArea();
		lblChoose.setOpaque(false);
		lblChoose.setEditable(false);
		lblChoose.setLineWrap(true);
		lblChoose.setForeground(Color.WHITE);
		lblChoose.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChoose.setBounds(24, 192, 224, 43);
		contentPane.add(lblChoose);
		
		ActionListener messagePrint = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChoose.setText(" ");
			}
			};
		Timer mytime=new Timer(1000,messagePrint);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(finalTableNumber!=0) {
			spTable.setCustomerName(customerName);spTable.setTableNumber(finalTableNumber);
			spTable.setNoofseats(finalSeats);
			spTable.setSmoking(finalSmoking);
			speciTables.getSpTables().add(spTable); 
			ClientDisplay cd=new ClientDisplay(od,finalTableNumber,speciTables,customerName);
			cd.setVisible(true);dispose();
			}
			else {
				lblChoose.setText("Please choose a table");mytime.start();mytime.setRepeats(false);
			}
			}
		});
		btnNext.setBounds(585, 328, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnShowAvailableTables = new JButton("Show Available Tables");
		btnShowAvailableTables.setForeground(Color.WHITE);
		btnShowAvailableTables.setContentAreaFilled(false);
		btnShowAvailableTables.setOpaque(false);
		btnShowAvailableTables.setBorderPainted(false);
		btnShowAvailableTables.setBorder(null);
		btnShowAvailableTables.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnShowAvailableTables.addActionListener(new ActionListener() {
			boolean flag=false;
			public void actionPerformed(ActionEvent arg0) {
				int tableTypeCounter=0,k=0,number;
				try {
					number=Integer.parseInt(textField.getText());
				if(tableTypeCounter>=0 && number>0) {
					//System.out.println("table number:"+tableTypeCounter);
					comboBox.setBounds(0,0,0,0);
					comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 15));
					contentPane.add(comboBox);
					comboBox = new JComboBox();
					comboBox.setBounds(364, 166, 230, 20);
					comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 15));
					contentPane.add(comboBox);
				}
				else {
					lblChoose.setText("Please choose a valid number");mytime.start();mytime.setRepeats(false);
				}
				tableTypeCounter=0;k=0;boolean yesButton=rdbtnYes.isSelected(),noButton=rdbtnNo.isSelected();
				if(yesButton) {
					boolean reserved=false;
					for(int i=0;i<count;i++) {
						reserved=false;
						for(int x=0;x<count;x++) if(reservedTables[x]==tableNumber[i] && smoking[i]==true) reserved=true;
						if(reserved==false && smoking[i]==true && numberOfSeats[i]-Integer.valueOf(textField.getText())<=3
								&& numberOfSeats[i]-Integer.valueOf(textField.getText())>=0) {
							tableTypeCounter++;
						}
					}
					comboBoxDisplay=new String[tableTypeCounter];specificTableNumbers=new int[tableTypeCounter];
					spSeats = new int[tableTypeCounter];
					spSmoking=new boolean[tableTypeCounter];
					for(int i=0;i<count;i++) {
						reserved=false;
						for(int x=0;x<count;x++) if(reservedTables[x]==tableNumber[i] && smoking[i]==true) reserved=true;
						if(reserved==false && smoking[i]==true && numberOfSeats[i]-Integer.valueOf(textField.getText())<=3
								&& numberOfSeats[i]-Integer.valueOf(textField.getText())>=0) {
						comboBoxDisplay[k]="Table Number:"+tableNumber[i]+"      Seats:"+numberOfSeats[i];
						comboBox.addItem(comboBoxDisplay[k]);specificTableNumbers[k]=tableNumber[i];
						spSeats[k]=numberOfSeats[i];
						spSmoking[k]=smoking[i];
						k++;
						}
					}
				}
				if(noButton) {
					boolean reserved;
					for(int i=0;i<count;i++) {
						reserved=false;
						for(int x=0;x<count;x++) if(reservedTables[x]==tableNumber[i] && smoking[i]==false) {
							reserved=true;
						}
						if(reserved==false && smoking[i]==false &&  numberOfSeats[i]-Integer.valueOf(textField.getText())>=0) {
							tableTypeCounter++;
						}
					}
					comboBoxDisplay=new String[tableTypeCounter];specificTableNumbers=new int[tableTypeCounter];
					spSeats = new int[tableTypeCounter];
					spSmoking=new boolean[tableTypeCounter];
					for(int i=0;i<count;i++) {
						reserved=false;
						for(int x=0;x<count;x++) if(reservedTables[x]==tableNumber[i]) {
							reserved=true;
						}
						if (reserved==true) continue;
						if(reserved==false && smoking[i]==false && numberOfSeats[i]-Integer.valueOf(textField.getText())>=0) {
						comboBoxDisplay[k]="Table Number:"+tableNumber[i]+"      Seats:"+numberOfSeats[i];
						comboBox.addItem(comboBoxDisplay[k]);specificTableNumbers[k]=tableNumber[i];
						spSeats[k]=numberOfSeats[i];
						spSmoking[k]=smoking[i];
						k++;
						}
					}
				}
				if(tableTypeCounter>0) {
				comboBox.setSelectedIndex(0);
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
					if(event.getStateChange()==ItemEvent.SELECTED) {
						finalTableNumber=specificTableNumbers[comboBox.getSelectedIndex()];
						finalSeats=spSeats[comboBox.getSelectedIndex()];
						finalSmoking=spSmoking[comboBox.getSelectedIndex()];
						flag=true;
					}
					}
				});
				if(flag==false) {finalTableNumber=specificTableNumbers[comboBox.getSelectedIndex()];
				finalSeats=spSeats[comboBox.getSelectedIndex()];
				finalSmoking=spSmoking[comboBox.getSelectedIndex()];
				}}
				else {
					if(tableTypeCounter==0 && number>0){
						lblChoose.setText("Tables with that number of seats are all reserved");mytime.start();mytime.setRepeats(false);
					}
				}
				}catch(NumberFormatException e){
					lblChoose.setText("Please insert valid number");mytime.start();mytime.setRepeats(false);
				}
				}
				
		});
		btnShowAvailableTables.setBounds(56, 158, 183, 35);
		contentPane.add(btnShowAvailableTables);
		
		comboBox=new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Mr."+customerName);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(226, 35, 203, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(505, 0, 177, 77);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		Image img2= new ImageIcon(this.getClass().getResource("tableBack3.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(-12, -38, 780, 400);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}


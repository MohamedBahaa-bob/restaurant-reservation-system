package restaurant.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.xml.bind.JAXBException;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import java.util.List;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Manager2nd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	SpecificTables spTables;
	Orders order;
	int count=0;
	SpecificTable st=new SpecificTable();
	private JTextArea textArea;

	
	public Manager2nd(Orders order,SpecificTables spTables) {
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
		setBounds(550, 200, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 330, 319);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{163, 4, 0};
		gbl_panel.rowHeights = new int[]{22, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setText("Today Orders:\n\n");
		
		int i=0,j=0,counter=0;
		float totalIncome=0;
		for(Order d:od.getOrders()) {
			totalIncome+=d.getTotal();
			String[]appetizerNames=c.getDishNames("appetizer",0);
			String[] mainCourseNames=c.getDishNames("main_course",0);
			String[] dessertNames=c.getDishNames("desert",0);
			for(i=0;i<appetizerNames.length;i++)counter++;
			for(i=0;i<mainCourseNames.length;i++)counter++;
			for(i=0;i<dessertNames.length;i++)counter++;
			count++;
			}
		int[] tNumber= new int[count];
		String[] cName= new String[count];
		float[] orderTotal=new float[count];
		String[][] appNames = new String[count][counter];
		Integer[][] appCount=new Integer[count][counter];
		int[] appLength=new int[count];
		int[] mcLength=new int[count];
		int[] dLength=new int[count];
		for(SpecificTable t:speciTables.getSpTables()) {
		tNumber[j]=t.getTableNumber();cName[j]=t.getCustomerName();j++;}
		j=0;
			for(Order d:od.getOrders()) {
				String[]appetizerNames=c.getDishNames("appetizer",0);
				int[] appetizerCount=d.getAppetizerCount();
				String[] mainCourseNames=c.getDishNames("main_course",0);
				int[] mainCourseCount=d.getMainCourseCount();
				String[] dessertNames=c.getDishNames("desert",0);
				int[] dessertCount=d.getDessertCount();
				orderTotal[j]=d.getTotal();
				int k=0;
				for(i=0;i<appetizerNames.length;i++) {
				if(appetizerCount[i]!=0) {
			    appNames[j][k]=appetizerNames[i];
			    appCount[j][k]=appetizerCount[i];k++;
			    }}
				for(i=0;i<mainCourseNames.length;i++) {
					if(mainCourseCount[i]!=0) {
					appNames[j][k]=mainCourseNames[i];
					appCount[j][k]=mainCourseCount[i];k++;
				}}
				for(i=0;i<dessertNames.length;i++) {
					if(dessertCount[i]!=0) {
					appNames[j][k]=dessertNames[i];
					appCount[j][k]=dessertCount[i];k++;
				}}
				appLength[j]=appetizerNames.length;
				mcLength[j]=mainCourseNames.length;
				dLength[j]=dessertNames.length;
			    j++;
			    }
			for(j=0;j<count;j++) {
				textArea.append("Table "+tNumber[j]+"\n");
				textArea.append("Customer: "+cName[j]+"\n");
				textArea.append("Order:\n");
				textArea.append("Count\tDish name\tPrice\n");
				int k=0;
				for(i=0;i<appLength[j];i++) {
					if(appCount[j][k]!=null) {
						textArea.append(appCount[j][k]+"x\t"+appNames[j][k]+"\n");k++;
					}
				}for(i=0;i<mcLength[j];i++) {
					if(appCount[j][k]!=null) {
						textArea.append(appCount[j][k]+"x\t"+appNames[j][k]+"\n");k++;
					}
				}for(i=0;i<dLength[j];i++) {
					if(appCount[j][k]!=null) {
						textArea.append(appCount[j][k]+"x\t"+appNames[j][k]+"\n");k++;
					}
				}
				textArea.append("Total:  "+orderTotal[j]+"\n");
				textArea.append("\n");
				}
		
		lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(505, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Today Income:");
		lblNewLabel.setBounds(10, 332, 96, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setText(String.valueOf(totalIncome));
		textField.setBounds(106, 329, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerDisplay md=new ManagerDisplay(od,speciTables);
				md.setVisible(true);dispose();
			}
		});
		btnNewButton.setBounds(550, 284, 109, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstDisplay fd=new FirstDisplay(order,spTables);
				fd.setVisible(true);dispose();
			}
		});
		btnNewButton_1.setBounds(550, 315, 109, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("managerpic12.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(358, 93, 267, 148);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Statistics");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics st= new Statistics(order,spTables);
				st.setVisible(true);dispose();	
			}
		});
		btnNewButton_2.setBounds(550, 254, 109, 25);
		contentPane.add(btnNewButton_2);
	}
}

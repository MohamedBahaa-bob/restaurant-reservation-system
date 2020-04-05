package restaurant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;

public class CookerDisplay extends JFrame {
    private JLabel lblNewLabel;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextArea textArea_1;
	private JTextArea textArea;
	SpecificTables spTables;Orders order;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CookerDisplay(Orders order,SpecificTables spTables) {
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
		
		lblNewLabel = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("cooker2.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 0, 250, 353);
		contentPane.add(lblNewLabel);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(505, 0, 177, 77);
		contentPane.add(lblNewLabel_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(481, 80, 200, 234);
		textArea_1.setText("Client's requests:\n");
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstDisplay fd=new FirstDisplay(order,spTables);
				fd.setVisible(true);dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(550, 315, 120, 33);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 0, 230, 353);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setText("Today dishes:\n\n");
		
		for(Order d:od.getOrders()) {
			int tableNumber=d.getTableNumber();
			String[]appetizerNames=d.getAppetizerNames();
			int[] appetizerCount=d.getAppetizerCount();
			String[] mainCourseNames=d.getMainCourseNames();
			int[] mainCourseCount=d.getMainCourseCount();
			String[] dessertNames=d.getDessertNames();
			int[] dessertCount=d.getDessertCount();
			if(d.getSpecialReq().length()>1) {
			textArea_1.append("Table: "+tableNumber+"\n");
			textArea_1.append(d.getSpecialReq()+"\n");}
			textArea.append("Table Number:"+tableNumber+"\n");
			textArea.append("Count\tDish name\n");
			for(int i=0;i<appetizerNames.length;i++) {
				if(appetizerCount[i]!=0) {
				textArea.append(appetizerCount[i]+"x\t"+appetizerNames[i]+"\n");
			}}
			for(int i=0;i<mainCourseNames.length;i++) {
				if(mainCourseCount[i]!=0) {
				textArea.append(mainCourseCount[i]+"x\t"+mainCourseNames[i]+"\n");
			}}
			for(int i=0;i<dessertNames.length;i++) {
				if(dessertCount[i]!=0) {
				textArea.append(dessertCount[i]+"x\t"+dessertNames[i]+"\n");
			}}
			textArea.append("\n");
		}


		
	}
}

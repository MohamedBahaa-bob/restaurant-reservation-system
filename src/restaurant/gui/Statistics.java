package restaurant.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import restaurant.Users.Customer;
import restaurant.filesWork.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.xml.bind.JAXBException;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class Statistics extends JFrame {

	private JPanel contentPane;
	//Order or=new Order();
	private final JPanel panel = new JPanel();
	private final JButton btnNewButton = new JButton("sorted by orders");
	private final JPanel guiPanel = new JPanel();
	private JLabel lblNewLabel;
	Orders orders;
	SpecificTables spTables;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Statistics(Orders order,SpecificTables spTables) {
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
		setBounds(550, 200, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		buttonGroup.add(btnNewButton);
		btnNewButton.setSelected(true);
		
		panel.setLayout(null);
		int i=0,j=0,salad=0,cake=0,fries=0,chicken=0,soup=0,beef=0,pie=0;
		float greek=0,molten=0,fried=0,grilled=0,mushroom=0,apple=0,steak=0;
		for(Order d:od.getOrders()) {
			String[]appetizerNames=d.getAppetizerNames();
			String[] mainCourseNames=d.getMainCourseNames();
			String[] dessertNames=d.getDessertNames();
			int[] appetizerCount=d.getAppetizerCount();
			int[] mainCourseCount=d.getMainCourseCount();
			int[] dessertCount=d.getDessertCount();
			for(j=0;j<appetizerNames.length;j++) {
			if(appetizerNames[j].equals("Greek Salad")&& appetizerCount[j]!=0) {
				salad+=appetizerCount[j];
				greek+=appetizerCount[j]*35*1.1;}
			if(appetizerNames[j].equals("Fried Potatoes") && appetizerCount[j]!=0) {
				fries+=appetizerCount[j];
			    fried+=appetizerCount[j]*30*1.1;}}
			for(j=0;j<mainCourseNames.length;j++) {
			if(mainCourseNames[j].equals("Mushroom Soup") && mainCourseCount[j]!=0) {
				soup+=mainCourseCount[j];
				mushroom+=mainCourseCount[j]*60*1.15;}
			if(mainCourseNames[j].equals("Grilled Chicken") && mainCourseCount[j]!=0) {
				chicken+=mainCourseCount[j];
				grilled+=mainCourseCount[j]*75*1.15;}
			if(mainCourseNames[j].equals("Beef Steak") && mainCourseCount[j]!=0) {
				beef+=mainCourseCount[j];
				steak+=mainCourseCount[j]*80*1.15;}}
			for(j=0;j<dessertNames.length;j++) {
			if(dessertNames[j].equals("Molten Cake") && dessertCount[j]!=0) {
				cake+=dessertCount[j];
				molten+=dessertCount[j]*60*1.2;}
			if(dessertNames[j].equals("Apple Pie") && dessertCount[j]!=0) {
				pie+=dessertCount[j];
				apple+=dessertCount[j]*50*1.2;}}
			}
		int[] plateArray={salad,fries,soup,cake,chicken,beef,pie};
		float[] priceArray= {greek,fried,mushroom,molten,grilled,steak,apple};
		String[] bestPlates=new String[7];
		String[] bestIncome=new String[7];
		Arrays.parallelSort(plateArray);
		Arrays.parallelSort(priceArray);
		/*for(i=0;i<7;i++) {
			System.out.println(plateArray[i]+"\n");
			System.out.println(priceArray[i]+"\n");
		}*/
		boolean a=true,b=true,h=true,d=true,e=true,f=true,g=true;
		for(i=6;i>=2;i--) {
			if(plateArray[i]==salad && a) {
				bestPlates[i]="Greek Salad";
				a=false;j++;
				continue;
			}if(plateArray[i]==fries && b) {
				bestPlates[i]="Fried Potatoes";
				b=false;j++;
				continue;
			}if(plateArray[i]==chicken && h) {
				bestPlates[i]="Grilled Chicken";
				h=false;j++;
				continue;
			}if(plateArray[i]==beef && d) {
				bestPlates[i]="Beef Steak";
				d=false;j++;
				continue;
			}if(plateArray[i]==soup && e) {
				bestPlates[i]="mushroom soup";
				e=false;j++;
				continue;
			}if(plateArray[i]==pie && f) {
				bestPlates[i]="Apple Pie";
				f=false;j++;continue;
			}if(plateArray[i]==cake && g) {
				bestPlates[i]="Molten Cake";
				g=false;j++;continue;
			}j++;
		}
		boolean a2=true,b2=true,c2=true,d2=true,e2=true,f2=true,g2=true;
		for(i=6;i>=2;i--) {
			if(Float.compare(priceArray[i],greek)==0 && a2) {
				bestIncome[i]="Greek Salad";
				a2=false;continue;
			}if(Float.compare(priceArray[i],fried)==0 && b2) {
				bestIncome[i]="Fried Potatoes";
				b2=false;continue;
			}if(Float.compare(priceArray[i],grilled)==0 && c2) {
				bestIncome[i]="Grilled Chicken";
				c2=false;continue;
			}if(Float.compare(priceArray[i],steak)==0 && d2) {
				bestIncome[i]="Beef Steak";
				d2=false;continue;
			}if(Float.compare(priceArray[i],mushroom)==0 && e2) {
				bestIncome[i]="mushroom soup";
				e2=false;continue;
			}if(Float.compare(priceArray[i],apple)==0 && f2) {
				bestIncome[i]="Apple Pie";
				f2=false;continue;
			}if(Float.compare(priceArray[i],molten)==0 && g2) {
				bestIncome[i]="Molten Cake";
				g2=false;continue;
			}
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int i;
				for(i=6;i>=2;i--) {
					System.out.println(plateArray[i]+"\n"+bestPlates[i]+"\n");
				}*/
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.setValue(plateArray[4], "Plates", bestPlates[4]);
				dcd.setValue(plateArray[2], "Plates", bestPlates[2]);
				dcd.setValue(plateArray[5], "Plates", bestPlates[5]);
				dcd.setValue(plateArray[6], "Plates", bestPlates[6]);
				dcd.setValue(plateArray[3], "Plates", bestPlates[3]);
				
				JFreeChart jChart= ChartFactory.createBarChart("Plates Review", "Plates", "Number of orders", dcd);
				CategoryPlot plot=jChart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.black);
				
				ChartFrame chartFrame= new ChartFrame("Plates Review",jChart,true);
				chartFrame.setVisible(false);
				ChartPanel chartPanel=new ChartPanel(jChart);
				
				guiPanel.removeAll();
				guiPanel.add(chartPanel);
				guiPanel.updateUI();
				
			}
		});
		btnNewButton.doClick();
				
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerDisplay md= new ManagerDisplay(od,speciTables);
				md.setVisible(true);dispose();	
			}
		});
		btnNewButton_1.setBounds(806, 312, 137, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstDisplay fd= new FirstDisplay(od,speciTables);
				fd.setVisible(true);dispose();	
			}
		});
		btnNewButton_2.setBounds(806, 372, 137, 46);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("sort by Income");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int i;
				for(i=6;i>=2;i--) {
					System.out.println(priceArray[i]+"\n"+bestIncome[i]+"\n");
				}*/
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.setValue(priceArray[4], "Plates", bestIncome[4]);
				dcd.setValue(priceArray[2], "Plates", bestIncome[2]);
				dcd.setValue(priceArray[5], "Plates", bestIncome[5]);
				dcd.setValue(priceArray[6], "Plates", bestIncome[6]);
				dcd.setValue(priceArray[3], "Plates", bestIncome[3]);
				
				JFreeChart jChart= ChartFactory.createBarChart("Plates Review", "Plates", "Plates incomings", dcd);
				CategoryPlot plot=jChart.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.black);
				
				ChartFrame chartFrame= new ChartFrame("Plates Review",jChart,true);
				chartFrame.setVisible(false);
				ChartPanel chartPanel=new ChartPanel(jChart);
				
				guiPanel.removeAll();
				guiPanel.add(chartPanel);
				guiPanel.updateUI();
				
			}
		});
		buttonGroup.add(btnNewButton_3);
		btnNewButton_3.setBounds(93, 367, 167, 38);
		panel.add(btnNewButton_3);
		
		btnNewButton.setBounds(425, 367, 167, 38);
		panel.add(btnNewButton);
		guiPanel.setBounds(0, 46, 672, 297);
		panel.add(guiPanel);
		guiPanel.setLayout(new BoxLayout(guiPanel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Best Plates Chart:");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(166, 8, 306, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(795, 0, 177, 77);
		Image img1= new ImageIcon(this.getClass().getResource("RestaurantLogo11.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1000, 450);
		Image img2= new ImageIcon(this.getClass().getResource("statBackground3.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel);
		contentPane.add(panel);
		
	
		lblNewLabel.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel);
		contentPane.add(panel);
		
	}
}

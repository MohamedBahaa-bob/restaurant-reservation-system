package restaurant.Users;
import restaurant.*;
import restaurant.filesWork.UserData;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class Customer extends UserData {
	int seats,i;boolean smoking;Scanner scan=new Scanner(System.in);
	float totalApp,totalMainDish,totalDessert;
	int[] starterCount=new int[2];int[] mainDishCount=new int[3];int[] dessertCount=new int[2];
	public String[] getDishNames(String type) {
		int counter=0,j=0;
	for(i=0;i<dishName.size();i++){
		if(dishType.get(i).equalsIgnoreCase(type)) {
			counter++;
		}
			}
	String []dishNames=new String[counter];float[] dishPrices=new float[counter];
	for(i=0;i<dishName.size();i++) {
		if(dishType.get(i).equalsIgnoreCase(type)) {
			dishPrices[j]=dishPrice.get(i);
			dishNames[j]=dishName.get(i);j++;
		}
	}
	return dishNames;
	}
	public String[] getDishNames(String type,int counter) {
		int j=0;
	for(i=0;i<dishName.size();i++){
		if(dishType.get(i).equalsIgnoreCase(type)) {
			counter++;
		}
			}
	String []dishNames=new String[counter];float[] dishPrices=new float[counter];
	for(i=0;i<dishName.size();i++) {
		if(dishType.get(i).equalsIgnoreCase(type)) {
			dishPrices[j]=dishPrice.get(i);
			dishNames[j]=dishName.get(i)+"\t$"+dishPrices[j];j++;
		}
	}
	return dishNames;
	}
	public float[] getDishPrice(String type) {
		int counter=0,j=0;
	for(i=0;i<dishName.size();i++){
		if(dishType.get(i).equalsIgnoreCase(type)) {
			counter++;
		}
			}
	float[] dishPrices=new float[counter];
	for(i=0;i<dishName.size();i++) {
		if(dishType.get(i).equalsIgnoreCase(type)) {
			dishPrices[j]=dishPrice.get(i);
			j++;
			}
	}
	return dishPrices;
	}
}


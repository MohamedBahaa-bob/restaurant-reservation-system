package restaurant.filesWork;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UserData{
	String filePath = new File("src/restaurant/filesWork/input.xml").getAbsolutePath();
	File file=new File(filePath);
	Users users1=new Users();	User user1=new User(); 		public List<User> userList=new ArrayList<>();
	Tables tables1=new Tables();Table table1=new Table(); public List<Table> tableList=new ArrayList<>();
	Dishes dishes1=new Dishes();Dish dish1=new Dish(); public List<Dish> dishList=new ArrayList<>();
	protected List<String> dishName=new ArrayList<>(); protected List<String>dishType=new ArrayList<>();protected List<Float>dishPrice=new ArrayList<>();
	public void takeData() throws JAXBException{
		JAXBContext jaxbcontext =JAXBContext.newInstance(Restaurant.class);
		Unmarshaller unmarshaller=jaxbcontext.createUnmarshaller();
		Restaurant restaurant=(Restaurant) unmarshaller.unmarshal(file);
		for(User user:restaurant.getUsers().getUsers()) {
			userList.add(user);
		}
		users1.setUsers(userList);
		for(Table table:restaurant.getTables().getTables()) {
			tableList.add(table);
		}
		tables1.setTables(tableList);
		for(Dish dish:restaurant.getDishes().getDishes()) {
			dishList.add(dish);dishName.add(dish.getName());dishType.add(dish.getType());dishPrice.add(dish.getPrice());
		}
		dishes1.setDishes(dishList);
	}
	    public boolean compareWithDB(String username,String password) {
		boolean isRole=false,msg=true;int i=0;String role="Client";
		//System.out.println(userList.get(i).getUsername());
		while(userList.size()>i && isRole==false) {
			if(userList.get(i).getUsername().contentEquals(username) && userList.get(i).getPassword().contentEquals(password)) {
				if(userList.get(i).getRole().contentEquals(role)) {
					isRole=true;
					msg=false;
					break;
				}else {
					JOptionPane.showMessageDialog(null,"Username doesn't match chosen role");
					msg=false;
				}
			}/*else {
				JOptionPane.showMessageDialog(null,"Incorrect Username or password");
			}*/
			i++;
		}
		if(msg) {
			JOptionPane.showMessageDialog(null,"Incorrect Username or password");
		}
		return isRole;
	}
	    public String getNameOfUser(String username,String password,String role) {
			String nameOfUser=null;int i=0;
			while(userList.size()>i) {
				if(userList.get(i).getUsername().contentEquals(username) && userList.get(i).getPassword().contentEquals(password)) {
					if(userList.get(i).getRole().contentEquals(role)) {
						nameOfUser=userList.get(i).getName();
						break;
					}
				}
			i++;
			}
			return nameOfUser;
		}
	    public List<Table> numberOfTables() {
	    	return tableList;
	    }
}

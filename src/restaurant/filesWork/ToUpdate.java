package restaurant.filesWork;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class ToUpdate {
	public Orders readUpdated() throws JAXBException{
		String filePath = new File("src/restaurant/filesWork/Updated.xml").getAbsolutePath();
		File file=new File(filePath);
		Orders orders=new Orders();List<Order>odList=new ArrayList<>();UserData d=new UserData();
		orders.setOrders(odList);
		JAXBContext jaxbcontext =JAXBContext.newInstance(UpdateOrders.class);
		Unmarshaller unmarshaller=jaxbcontext.createUnmarshaller();
		UpdateOrders od=(UpdateOrders)unmarshaller.unmarshal(file);
		for(Order order:od.getOrders().getOrders()) {
		orders.getOrders().add(order);
		}
		return orders;
		}
		public SpecificTables readUpdatedTables() throws JAXBException{
		String filePath = new File("src/restaurant/filesWork/Updated.xml").getAbsolutePath();
		File file=new File(filePath);
		SpecificTables spTables=new SpecificTables();List<SpecificTable>spList=new ArrayList<>();
		spTables.setSpTables(spList);
		JAXBContext jaxbcontext =JAXBContext.newInstance(UpdateOrders.class);
		Unmarshaller unmarshaller=jaxbcontext.createUnmarshaller();
		UpdateOrders spread=(UpdateOrders)unmarshaller.unmarshal(file);
		for(SpecificTable sp:spread.getSpTables().getSpTables()) {
		spTables.getSpTables().add(sp);
		}
		return spTables;
		}
		public void writeFile(Orders orders,SpecificTables spTables) throws JAXBException{
		String filePath = new File("src/restaurant/filesWork/Updated.xml").getAbsolutePath();
		File file=new File(filePath);
		JAXBContext jaxbcontext =JAXBContext.newInstance(UpdateOrders.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		UpdateOrders update=new UpdateOrders();
		update.setOrders(orders);update.setSpTables(spTables);
		marshaller.marshal(update,file);
		}
		public void signUp(List<User> userList,List<Table> tableList,List<Dish> dishList)throws JAXBException{
		String filePath = new File("src/restaurant/filesWork/input.xml").getAbsolutePath();
		File file=new File(filePath);
		JAXBContext jaxbcontext =JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		Restaurant restaurant=new Restaurant();Users users=new Users();Tables tables=new Tables();Dishes dishes=new Dishes();
		users.setUsers(userList);tables.setTables(tableList);dishes.setDishes(dishList);
		restaurant.setUsers(users);restaurant.setTables(tables);restaurant.setDishes(dishes);
		marshaller.marshal(restaurant, file);
		}
		}
		@XmlRootElement(name="updated")
		@XmlAccessorType(XmlAccessType.FIELD)
		class UpdateOrders {
		@XmlElement(name="orders")
		private Orders orders=null;
		private SpecificTables spTables=null;
		public SpecificTables getSpTables() {
		return spTables;
		}

		public void setSpTables(SpecificTables spTables) {
		this.spTables = spTables;
		}

		public Orders getOrders() {
		return orders;
		}

		public void setOrders(Orders orders) {
		this.orders = orders;
		}
		}




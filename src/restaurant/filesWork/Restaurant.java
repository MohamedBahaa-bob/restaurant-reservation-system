package restaurant.filesWork;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name="restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {
	@XmlElement(name="users")
	private Users users=null;
	@XmlElement(name="tables")
	private Tables tables=null;
	@XmlElement(name="dishes")
	private Dishes dishes=null;

	public Dishes getDishes() {
		return dishes;
	}

	public void setDishes(Dishes dishes) {
		this.dishes = dishes;
	}

	public Tables getTables() {
		return tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}

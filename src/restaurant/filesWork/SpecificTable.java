package restaurant.filesWork;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reserved_table")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecificTable{
@XmlElement(name="customer_name")
String customerName;
@XmlElement(name="table_number")
int tableNumber;
@XmlElement(name="number_of_seats")
int noofseats;
boolean smoking;
public int getNoofseats() {
return noofseats;
}
public void setNoofseats(int noofseats) {
this.noofseats = noofseats;
}
public boolean isSmoking() {
return smoking;
}
public void setSmoking(boolean smoking) {
this.smoking = smoking;
}
public String getCustomerName() {
return customerName;
}
public void setCustomerName(String customerName) {
this.customerName = customerName;
}
public int getTableNumber() {
return tableNumber;
}
public void setTableNumber(int tableNumber) {
this.tableNumber = tableNumber;
}
}

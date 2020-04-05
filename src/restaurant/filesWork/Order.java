package restaurant.filesWork;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order{
@XmlElement(name="table_number")
int tableNumber;
@XmlElement(name="customer_name")
String customerName;
@XmlElement(name="appetizer")
String[] appetizerNames;
@XmlElement(name="appetizer_count")
int[] appetizerCount;
@XmlElement(name="main_course")
String[]mainCourseNames;
@XmlElement(name="main_course_count")
int[] mainCourseCount;
@XmlElement(name="dessert")
String[] dessertNames;
@XmlElement(name="count")
int[] dessertCount;
@XmlElement(name="total")
float total;
@XmlElement(name="special_request")
private String specialReq;
float  appetizerPrices,mainCoursePrices,dessertPrices;
public String getCustomerName() {
return customerName;
}
public void setCustomerName(String customerName) {
this.customerName = customerName;
}
public String getSpecialReq() {
return specialReq;
}
public void setSpecialReq(String specialReq) {
this.specialReq = specialReq;
}
public int[] getAppetizerCount() {
return appetizerCount;
}
public void setAppetizerCount(int[] appetizerCount) {
this.appetizerCount = appetizerCount;
}
public int[] getMainCourseCount() {
return mainCourseCount;
}
public void setMainCourseCount(int[] mainCourseCount) {
this.mainCourseCount = mainCourseCount;
}
public int[] getDessertCount() {
return dessertCount;
}
public void setDessertCount(int[] dessertCount) {
this.dessertCount = dessertCount;
}
public String[] getAppetizerNames() {
return appetizerNames;
}
public void setAppetizerNames(String[] appetizerNames) {
this.appetizerNames = appetizerNames;
}
public String[] getMainCourseNames() {
return mainCourseNames;
}
public void setMainCourseNames(String[] mainCourseNames) {
this.mainCourseNames = mainCourseNames;
}
public String[] getDessertNames() {
return dessertNames;
}
public void setDessertNames(String[] dessertNames) {
this.dessertNames = dessertNames;
}
public float getAppetizerPrices() {
return appetizerPrices;
}
public void setAppetizerPrices(float appetizerPrices) {
this.appetizerPrices = appetizerPrices;
}
public float getMainCoursePrices() {
return mainCoursePrices;
}
public void setMainCoursePrices(float mainCoursePrices) {
this.mainCoursePrices = mainCoursePrices;
}
public float getDessertPrices() {
return dessertPrices;
}
public void setDessertPrices(float dessertPrices) {
this.dessertPrices = dessertPrices;
}
public float getTotal() {
return total;
}
public void setTotal(float total) {
this.total = total;
}
public int getTableNumber() {
return tableNumber;
}
public void setTableNumber(int tableNumber) {
this.tableNumber = tableNumber;
}
}
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer extends User{
	private int  ID_customer;
	private static int count = 1; 
	private  ArrayList<Food> orders=new ArrayList<Food>();
	public Customer(String name, String surname, Address address, Phone phone, String password) {
		super(name, surname, address, phone, password);
		setID_customer(count);
		// TODO Auto-generated constructor stub
	}

	public int getID_customer() {
		return ID_customer;
	}
	public void setID_customer(int iD_customer) {
		ID_customer = iD_customer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList getOrders() {
		return orders;
	}
	public void setOrders(Food orders) {
		this.orders.add(orders);
	} 
	public void DisplayAllOrders() {
		for (int i = 0; i < orders.size(); i++) {
			System.out.println("order no: "+i+1+" "+orders.get(i));
		}
	}
	@Override
	public String toString() {
		return "orders=" + orders + "-" + getName() + "-" + getSurname() + "-" + getPhone()+ "-" + getAddress() ;
	}
	public void CreateCustomer(Customer c, ArrayList<Customer> a) {
		a.add(c);
		count++;
	}
	public String getCurrentOrderedFood(Restaurant r) {
		String s= "";
		for (int i = 0; i < orders.size(); i++) {
			for (int j = 0; j < orders.get(i).getRestaurant_list().size(); j++) {
				if(orders.get(i).getRestaurant_list().get(j).getRestaurant_name().equals(r.getRestaurant_name()))
					s= orders.get(i).currentToString();
			}
		}
		return s + "-" +getName() + "-" + getSurname() + "-" + getPhone()+ "-" + getAddress();
	}

	public String getOrderedFood(Restaurant r) {
		String s= "";
		for (int i = 0; i < orders.size(); i++) {
			for (int j = 0; j < orders.get(i).getRestaurant_list().size(); j++) {
				if(orders.get(i).getRestaurant_list().get(j).getRestaurant_name().equals(r.getRestaurant_name()))
					s= orders.get(i).currentToString();
			}
		}
		return s ;
	}



}

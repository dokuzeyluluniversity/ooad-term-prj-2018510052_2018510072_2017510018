import java.util.ArrayList;
import java.util.Queue;

public class Restaurant {
	private String  restaurant_name;
	private String ship_min;
	private Address address ;
	private Phone phone;
	private ArrayList<Food> food; 
	private Queue customerqueue ;
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getShip_min() {
		return ship_min;
	}
	public void setShip_min(String ship_min) {
		this.ship_min = ship_min;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public ArrayList<Food> getFood() {
		return food;
	}
	public void setFood(ArrayList<Food> food) {
		this.food = food;
	}
	public Queue getCustomerqueue() {
		return customerqueue;
	}
	public void setCustomerqueue(Queue customerqueue) {
		this.customerqueue = customerqueue;
	}
	
}

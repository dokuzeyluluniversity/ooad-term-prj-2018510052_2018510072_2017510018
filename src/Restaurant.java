import java.util.ArrayList;
import java.util.Queue;
public class Restaurant {
	private String  restaurant_name;
	private String ship_min;
	private Address address ;
	private Phone phone;
	private ArrayList<Food> food; 
	private Queue<Customer>customerqueue ;
	public Restaurant(String restaurant_name, String ship_min, Address address, Phone phone, ArrayList<Food> food,
			Queue<Customer> customerqueue) {
		this.restaurant_name = restaurant_name;
		this.ship_min = ship_min;
		this.address = address;
		this.phone = phone;
		this.food = food;
		this.customerqueue = customerqueue;
	}
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
	public void addFood(Food f) {
		food.add(f);
	}
	public void removeFood(Food f) {
		for (int i = 0; i < food.size(); i++) {
			if(food.get(i).getFood_name().equals(f.getFood_name())) {
				food.remove(i);
				return;
			}
		}
	}
	public void displayQueue() {
		for (int i = 0; i < customerqueue.size(); i++) {
			System.out.println(customerqueue.toString());
		}
	}
	@Override
	public String toString() {
		return "Restaurant [restaurant_name=" + restaurant_name + ", ship_min=" + ship_min + ", address=" + address
				+ ", phone=" + phone + ", food=" + food + ", customerqueue=" + customerqueue + "]";
	}
	
	
}

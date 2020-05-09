import java.util.ArrayList;

public class Customer extends User{
	private int  ID_customer;
	private static int count = 1; 
	private ArrayList<String> orders;
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
	public void setOrders(ArrayList orders) {
		this.orders = orders;
	} 
	public void DisplayAllOrders() {
		for (int i = 0; i < orders.size(); i++) {
			System.out.println("order no: "+i+1+" "+orders.get(i));
		}
	}
	@Override
	public String toString() {
		return "Customer [ID_customer=" + ID_customer + ", orders=" + orders + ", getName()=" + getName()
		+ ", getSurname()=" + getSurname() + ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone()
		+ "]";
	}
	public void CreateCustomer(Customer c, ArrayList<Customer> a) {
		a.add(c);
		count++;
	}
	public void Order (Restaurant rest, Food food, Customer c) {
		
	}

}

import java.util.ArrayList;

public class Customer extends User{
	private int  ID_customer;
	private int count; 
	private ArrayList orders;
	
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
	@Override
	public String toString() {
		return "Customer [ID_customer=" + ID_customer + ", count=" + count + ", orders=" + orders + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void DisplayAllOrders() {}
	public void CreateCustomer(User user) {}
	public void Order (Restaurant rest, Food food) {}
	
}

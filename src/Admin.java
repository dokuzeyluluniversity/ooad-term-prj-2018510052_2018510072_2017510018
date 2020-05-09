import java.util.ArrayList;

public class Admin extends User{
	private int  ID_admin;
	private static int count = 1 ;
private Restaurant restaurant;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Admin(String name, String surname, Address address, Phone phone, String password) {
		super(name, surname, address, phone,password);
		setID_admin(count);
		this.restaurant = new Restaurant(String.valueOf(count),"",new Address("","","",""),new Phone("",""));
		
	}
	public int getID_admin() {
		return ID_admin;
	}
	public void setID_admin(int iD_admin) {
		ID_admin = iD_admin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getAddress()=" + getAddress().toString() + ", getPhone()=" + getPhone().toString() + ", password= "+ getPassword();
	}
	public void createAdmin(Admin ad, ArrayList<Admin> a) {
		a.add(ad);
		count++;
	}
	
	
	
}

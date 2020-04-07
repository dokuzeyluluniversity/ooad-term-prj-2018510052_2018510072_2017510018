import java.util.ArrayList;

public class Admin extends User{
	public Admin(String name, String surname, Address address, Phone phone) {
		super(name, surname, address, phone);
		setID_admin(count);
		// TODO Auto-generated constructor stub
	}
	private int  ID_admin;
	private static int count = 1 ;
	
	
	
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
		return "Admin [ID_admin=" + ID_admin + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone() + "]";
	}
	public void createAdmin(Admin ad, ArrayList<Admin> a) {
		a.add(ad);
		count++;
	}
	
	
	
}

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
					s= orders.get(i).toString();
			}
		}
		return s + "-" +getName() + "-" + getSurname() + "-" + getPhone()+ "-" + getAddress();
	}
	public void Order (ArrayList<Admin> aList,ArrayList<Customer> cList,int CustomerId ) throws QueueFull {
		boolean budgetflag=false;
		Scanner sn =new Scanner(System.in);

		do{
			System.out.print("Please enter your budget : " );
			String s1 =sn.next();
			System.out.print("What would you like to eat ? : " );
			String s2 =sn.next();
			Scanner s3=new Scanner(System.in);
			String  choise="";

			for (int i = 0; i < aList.size()  ; i++) {

				for (int j = 0; j < aList.get(i).getRestaurant().getFood().size() ; j++) {

					if(aList.get(i).getRestaurant().getFood().get(j).getFood_name().equals(s2))
					{

						if(Integer.parseInt(s1) >= aList.get(i).getRestaurant().getFood().get(j).getPrice() && !aList.get(i).getRestaurant().isShutDown())
						{
							budgetflag=true;


							System.out.println("Restaurant name : "+aList.get(i).getRestaurant().getRestaurant_name());

						}

					}

				}

			}
			System.out.println("Select a restaurant : ");
			choise=s3.nextLine();
			for (int i = 0; i < aList.size(); i++) {
				if(choise.equals(aList.get(i).getRestaurant().getRestaurant_name())&& !aList.get(i).getRestaurant().isShutDown())
				{
					aList.get(i).getRestaurant().setCustomerqueue(cList.get(CustomerId));
					cList.get(CustomerId).setOrders(aList.get(i).getRestaurant().FindFood(aList.get(i).getRestaurant(), s2));
					System.out.println("YOUR ORDER IS COMPLETED ! " +"restaurant = "+aList.get(i).getRestaurant().getRestaurant_name());
					aList.get(i).getRestaurant().displayQueue();
				}
			}

			if(!budgetflag)
			{
				System.out.println(" ENTER BUDGET AGAIN!");

			}
		}while(!budgetflag);

	}

}

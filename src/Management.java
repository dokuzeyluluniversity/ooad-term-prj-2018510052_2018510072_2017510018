import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.REBIND;

public class Management {
	public ArrayList<Admin> aList = new ArrayList<Admin>();
	ArrayList<Customer> cList = new ArrayList<Customer>();
	ArrayList<Food> fList = new ArrayList<Food>();
	Management() throws QueueFull, IOException, QueueEmpty{

		boolean loop=false;
		takeData();
		/*do {

			Menu();
		}while(!loop);*/
	}
	
	public void selectfile(String User,int i) throws IOException{
		if(i==1)
		{
			File file =new File("Admin.txt");//1
			writeFile(User,1,file);

		}
		else if(i==2)
		{    File cust =new File("Customers.txt");//2
		writeFile(User,2,cust);

		}
		else if(i==3)
		{   File ord =new File("Ords.txt");
		writeFile(User,3,ord);

		}

	}
	public void writeFile(String text,int i,File fileName) throws IOException {


		BufferedWriter writer = new BufferedWriter(
				new FileWriter(fileName, true)  //Set true for append mode
				);  
		writer.newLine();   //Add new line
		writer.write(text);
		writer.close();
	}
	public void takeData() throws IOException
	{

		File f =new File("Admin.txt");
		if(!f.exists())
		{
			f.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(f)); 

		String st; 
		while ((st = br.readLine()) != null) {
			if(!st.equals(""))
			{

				String sp[] =st.split(",");
				aList.add(new Admin(sp[0],sp[1],new Address("","","",""),new Phone("",sp[2]),sp[3]));

			}


		}
		f =new File("Customers.txt");
		if(!f.exists())
		{
			f.createNewFile();
		}
		BufferedReader br2 = new BufferedReader(new FileReader(f)); 

		String st1; 
		while ((st1 = br2.readLine()) != null) {

			if(!st1.equals(""))
			{
				String sp[] =st1.split(",");
				cList.add(new Customer(sp[0],sp[1],new Address("","","",""),new Phone("",sp[2]),sp[3]));

			}


		}



	}
	public Boolean searchCustomer(String phone,String password) {
		boolean enter = false;

		int customerId = 0;
		for (int i = 0; i < cList.size(); i++) {
			if(cList.get(i).getPhone().getNumber().equals(phone)&&cList.get(i).getPassword().equals(password)) {//user entered the system
				enter = true;
				Customerid(customerId,i);
			}
		}
		return enter;
	}
	public Boolean searchAdmin(String phone,String password) {
		boolean enter = false;

		int adminId = 0;
		for (int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getPhone().getNumber().equals(phone)&&aList.get(i).getPassword().equals(password)) {//user entered the system
				enter = true;
				Adminid(adminId,i);
			}

		}
		return enter;
	}
	public int Adminid(int adminId ,int i) {

		return adminId=i;
	}
	public int Customerid(int customerId,int i) {

		return customerId=i;
	}

	public boolean Menu( ) throws IOException, QueueEmpty, QueueFull {


		Scanner s = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);//for strings
		System.out.println("1 - Admin\n2 - Customer\n3 - Sign-Up \n4 - Exit");
		int answer = s.nextInt();

		if(answer == 1) {//admin
			boolean enter = false;
			int adminId = 0;
			do {
				Boolean user=true;
				//Login l=new Login();
				//search();
			} while (!enter);



			do {
				System.out.println("1-SET INFORMATION");//
				System.out.println("2-REMOVE FOOD");//*
				System.out.println("3-ADD FOOD");//*
				System.out.println("4-DISPLAY CUSTOMERS");//*
				System.out.println("5-SHUT DOWN THE RESTAURANT");//*
				System.out.println("6-DISPLAY MENU");//*
				System.out.println("7-REMOVE CUSTOMER");//*
				System.out.println("8-EXIT");//*
				answer = s.nextInt();
				if(answer == 1) {//set information

					System.out.println("1-Change your PERSONAL information");
					System.out.println("2-Change RESTAURANT'S information");
					answer = s.nextInt();
					if(answer == 1) {//personal info
						Framesmenu frame=new Framesmenu();
						frame.SetInformationAdmin(aList);
						frame.getAdmin().setVisible(true);
						System.out.println(aList.get(adminId).toString());
						System.out.println("name,surname,address(street,town,city,description),phone(country code,number),password(leave only a comma between them)");
						System.out.println(aList.get(adminId).toString());
						String info = sn.nextLine();
						String[] split = info.split(",");
						aList.get(adminId).setUser(split[0], split[1], new Address(split[2],split[3],split[4],split[5]),new Phone(split[6],split[7]), split[8]);
						System.out.println("Your information changed successfully");
						System.out.println(aList.get(adminId).toString());
					}
					else {//restaurants info
						System.out.println("restaurantName,address(street,town,city,description),phone(country code,number)");
						System.out.println(aList.get(adminId).getRestaurant().toString());
						String info = sn.nextLine();
						String[] split = info.split(",");
						aList.get(adminId).getRestaurant().setRestaurant(split[0], new Address(split[1],split[2],split[3],split[4]),new Phone(split[5],split[6]));
						System.out.println("Your information changed successfully!");
						System.out.println(aList.get(adminId).getRestaurant().toString());

					}
				}
				else if(answer == 2 && !aList.get(adminId).getRestaurant().isShutDown()) {//removing food
					System.out.println(aList.get(adminId).getRestaurant().getFood().toString());
					System.out.println("Enter food name you want to delete!");
					String ans = sn.nextLine();
					boolean control = false;
					for (int i = 0; i < aList.get(adminId).getRestaurant().getFood().size(); i++) {
						if(aList.get(adminId).getRestaurant().getFood().get(i).getFood_name().equals(ans)) {
							aList.get(adminId).getRestaurant().removeFood(aList.get(adminId).getRestaurant().getFood().get(i));
							control = true;
							System.out.println("Successfully removed!");
						}
					}
					if(!control) {
						System.err.println("Please control your menu before entering the food name!");
					}
				}
				else if(answer == 3 && !aList.get(adminId).getRestaurant().isShutDown()) {//add food
					boolean isFoodExist = false;
					System.out.println("Please enter the food informations(foodName,ingredients,price)");
					String info = sn.nextLine();
					String[] split = info.split(",");
					aList.get(adminId).getRestaurant().addFood(new Food(split[0],split[1],Integer.valueOf(split[2]),aList.get(adminId).getRestaurant()));
					System.out.println(aList.get(adminId).getRestaurant().getFood().toString());
					for (int i = 0; i < fList.size(); i++) {
						if(fList.get(i).getFood_name().equalsIgnoreCase(split[0])) {
							fList.get(i).getRestaurant_list().add(aList.get(adminId).getRestaurant());
							isFoodExist = true;
						}
					}
					if(!isFoodExist) {//adding new food to the food arrayList
						fList.add(new Food(split[0],split[1],Integer.valueOf(split[2]),aList.get(adminId).getRestaurant()));
					}
				}
				else if(answer == 4 && !aList.get(adminId).getRestaurant().isShutDown()) {//display customers
					aList.get(adminId).getRestaurant().displayQueue();
				}
				else if(answer == 5 && !aList.get(adminId).getRestaurant().isShutDown()){//shut down !!
					aList.get(adminId).getRestaurant().setShutDown(true);
					System.out.println("Restaurant is now closed!");
				}
				else if(answer == 6) {//display menu
					for (int i = 0; i < aList.size(); i++) {
						for (int j = 0; j < aList.get(i).getRestaurant().getFood().size(); j++) {
							System.out.println(aList.get(i).getRestaurant().getFood().get(j));
						}
					}
				}
				else if(answer == 7) {//REMOVE CUSTOMER FROM THE QUEUE
					Customer removedCustomer = (Customer) aList.get(adminId).getRestaurant().getCustomerqueue().peek();
					System.out.println("Removed Customer: "+removedCustomer.getName()+" "+removedCustomer.getSurname());
					aList.get(adminId).getRestaurant().getCustomerqueue().dequeue();
				}
				else if(answer == 8) {
					return true;
				}
				else System.err.println("Invalid input!Try Again!");
			} while (answer!=8);

		}
		else if( answer == 3) {//sign up
			System.out.print("1 - Admin\n2 - Customer\n");
			answer = s.nextInt();
			String info ="";
			if(answer == 1){//admin info enter
				System.out.print("name,surname,phone,password(leave only a comma between them)");
				info = sn.nextLine();
				selectfile(info,1);
				String[] split = info.split(",");
				Admin newAdmin = new Admin(split[0],split[1],new Address("","","",""),new Phone("",split[2]),split[3]);
				newAdmin.createAdmin(newAdmin, aList);
				System.out.println(newAdmin.toString());

			}
			else {//customer info enter
				System.out.print("name,surname,phone,password(leave only a comma between them)");
				info = sn.nextLine();

				selectfile(info,2);
				String[] split = info.split(",");
				Customer newCustomer = new Customer(split[0],split[1],new Address("","","",""),new Phone("",split[2]),split[3]);
				newCustomer.CreateCustomer(newCustomer, cList);System.out.println(newCustomer.toString());

			}
		}
		else if(answer==2) {//customer
			boolean enter = false;
			int customerId = 0;
			do {
				System.out.print("Phone: ");
				String phone = s.next();

				System.out.print("Password: ");
				String password = s.next();

				for (int i = 0; i < cList.size(); i++) {
					if(cList.get(i).getPhone().getNumber().equals(phone)&&cList.get(i).getPassword().equals(password)) {//user entered the system
						enter = true;
						customerId = i;
					}
				}
				if(!enter) System.err.println("Something went wrong!Enter again.");
			} while (!enter);

			do {
				System.out.println("1-SET INFORMATION");
				System.out.println("2-GIVE ORDER");
				System.out.println("3-DISPLAY ALL ORDERS");
				System.out.println("4-DISPLAY ALL FOODS");
				System.out.println("5-EXIT");
				answer = s.nextInt();

				if(answer == 1) {//set information
					System.out.println("Change your personal information");
					System.out.println("name,surname,address(street,town,city,description),phone(country code,number),password(leave only a comma between them)");
					System.out.println(cList.get(customerId).toString());
					String info = sn.nextLine();
					String[] split = info.split(",");
					cList.get(customerId).setUser(split[0], split[1], new Address(split[2],split[3],split[4],split[5]),new Phone(split[6],split[7]), split[8]);
					System.out.println("Your information changed successfully!");
					System.out.println(cList.get(customerId).toString());

				}
				else if(answer == 2 ) {//give order
					cList.get(customerId).Order(aList, cList, customerId);

				}
				else if(answer == 3 ) {//display orders
					for (int i = 0; i < cList.get(customerId).getOrders().size(); i++) {

						System.out.println(cList.get(customerId).getOrders().get(i));

					}


				}
				else if(answer == 4) {//display all food
					for (int i = 0; i < fList.size(); i++) {
						System.out.println(fList.get(i).getFood_name());
						for (int j = 0; j < fList.get(i).getRestaurant_list().size() ; j++) {
							System.out.println("--->"+fList.get(i).getRestaurant_list().get(j));
						}
					}
				}
				else if(answer == 5) {

					return true;

				}
				else System.err.println("Invalid input!Try Again!");
			} while (answer!=5);



		}
		else if(answer==4) {
			System.exit(0);
		}
		else System.err.println("Invalid input!Try Again!");
		return false;
	}


}


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
	ArrayList<Admin> aList = new ArrayList<Admin>();
	ArrayList<Customer> cList = new ArrayList<Customer>();
	ArrayList<Food> fList = new ArrayList<Food>();
	Management() throws QueueFull, IOException, QueueEmpty{
		//adding admin into the admin arraylist
		fList.add(new Food("pizza", "sucuk-domates", 30, new Restaurant("konyal�", "30",new Address("sstr","town","city","desc"),new Phone("5684638","234"))));
		fList.add(new Food("kavurma", "yumurta-domates", 30, new Restaurant("konyal�", "30",new Address("sstr","town","city","desc"),new Phone("5684638","234"))));
		fList.add(new Food("mant�", "k�yma-domates", 30, new Restaurant("konyal�", "30",new Address("sstr","town","city","desc"),new Phone("5684638","234"))));
		fList.add(new Food("lahmacun", "k�yma-�e�ni-domates", 30, new Restaurant("konyal�", "30",new Address("sstr","town","city","desc"),new Phone("5684638","234"))));

		Admin ad = new Admin("ali","veli",new Address("gd","town","city","desc"),new Phone("","1"),"k");
		ad.createAdmin(ad, aList);
		ad.getRestaurant().getFood().add(new Food("makarna","domates, patl�can",40,ad.getRestaurant()));
		ad.getRestaurant().getFood().add(new Food("menemen","domat, patl�can",80,ad.getRestaurant()));
		ad.getRestaurant().setCustomerqueue(new Customer("mehmet","���k",new Address("sstr","town","city","desc"),new Phone("5684638","234"),"dkjfbgsj"));
		ad.getRestaurant().setCustomerqueue(new Customer("asl�","duru",new Address("ssgftr","towdyn","cdyity","ddyesc"),new Phone("56846dy38","23dy4"),"dkjfbgdysj"));
		Admin addsd = new Admin("samet","bar��",new Address("sstr","town","city","desc"),new Phone("5684638","234"),"dkjfbgsj");
		ad.createAdmin(addsd, aList);
		Customer cd=new Customer("ali","veli",new Address("gd","town","city","desc"),new Phone("","1"),"k");
		Customer cd2=new Customer("semih","at�l",new Address("gd","town","city","desc"),new Phone("","2"),"k");
		Customer cd3=new Customer("seda","ses",new Address("gd","town","city","desc"),new Phone("","3"),"k");
		cd.CreateCustomer(cd, cList);
		cd.CreateCustomer(cd2, cList);
		cd.CreateCustomer(cd3, cList);
		ad.getRestaurant().getCustomerqueue().enqueue(cd.toString());
		ad.getRestaurant().getCustomerqueue().enqueue(cd2.toString());
		ad.getRestaurant().getCustomerqueue().enqueue(cd3.toString());
		//Customer list will be created like adminlist arraylist
		for (int i = 0; i < cList.size(); i++) {
			System.out.println(cList.get(i));
		}
		Menu();


	}
	public void keepdata(String customer,String Admin) throws IOException {

		File file=new File("Customer.txt");  ;
		FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);

		bWriter.write(customer);

		if (file.exists()) {

			Scanner rd=new Scanner(file);
			while(rd.hasNextLine()) {
				//	String str=rd.nextLine();
				//	String split[]=str.split(",");
				bWriter.write(customer);


			}
		}





	}



	public void Menu( ) throws IOException, QueueEmpty {
		Scanner s = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);//for strings
		System.out.println("1- admin\n2- user\n3- sign up");
		int answer = s.nextInt();
		if(answer == 1) {//admin
			boolean enter = false;
			int adminId = 0;
			do {
				System.out.print("phone: ");
				String phone = s.next();

				System.out.print("password: ");
				String password = s.next();

				for (int i = 0; i < aList.size(); i++) {
					if(aList.get(i).getPhone().getNumber().equals(phone)&&aList.get(i).getPassword().equals(password)) {//user entered the system
						enter = true;
						adminId = i;
					}
				}
				if(!enter) System.out.println("something went wrong!Enter again.");
			} while (!enter);



			do {
				System.out.println("1-SET INFORMATION");
				System.out.println("2-REMOVE FOOD");
				System.out.println("3-ADD FOOD");
				System.out.println("4-DISPLAY CUSTOMERS");
				System.out.println("5-SHUT DOWN THE RESTAURANT");
				System.out.println("6-DISPLAY MENU");
				System.out.println("7-REMOVE CUSTOMER");
				System.out.println("8-EXIT");
				answer = s.nextInt();
				if(answer == 1) {//set information
					System.out.println("1-change your personal information");
					System.out.println("2-change restaurant's information");
					answer = s.nextInt();
					if(answer == 1) {//personal info
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
						System.out.println("Your information changed successfully");
						System.out.println(aList.get(adminId).getRestaurant().toString());

					}
				}
				else if(answer == 2 && !aList.get(adminId).getRestaurant().isShutDown()) {//removing food
					System.out.println(aList.get(adminId).getRestaurant().getFood().toString());
					System.out.println("enter food name you want to delete.");
					String ans = sn.nextLine();
					boolean control = false;
					for (int i = 0; i < aList.get(adminId).getRestaurant().getFood().size(); i++) {
						if(aList.get(adminId).getRestaurant().getFood().get(i).getFood_name().equals(ans)) {
							aList.get(adminId).getRestaurant().removeFood(aList.get(adminId).getRestaurant().getFood().get(i));
							control = true;
							System.out.println("Successfully removed.");
						}
					}
					if(!control) {
						System.out.println("Please control your menu before entering the food name.");
					}
				}
				else if(answer == 3 && !aList.get(adminId).getRestaurant().isShutDown()) {//add food
					boolean isFoodExist = false;
					System.out.println("please enter the food informations(foodName,ingredients,price");
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
				else if(answer == 5 && !aList.get(adminId).getRestaurant().isShutDown()){
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
					System.exit(0);
				}
				else System.out.println("Invalid input!Try Again!");
			} while (answer!=6);

		}
		else if( answer == 3) {//sign up
			System.out.println("Admin or Customer?");
			answer = s.nextInt();
			String info ="";
			if(answer == 1){//admin info enter
				System.out.print("name,surname,phone,password(leave only a comma between them)");
				info = sn.nextLine();
				keepdata("",info);
				String[] split = info.split(",");
				Admin newAdmin = new Admin(split[0],split[1],new Address("","","",""),new Phone(split[2],""),split[3]);
				newAdmin.createAdmin(newAdmin, aList);System.out.println(newAdmin.toString());

			}
			else {//customer info enter
				System.out.print("name,surname,phone,password(leave only a comma between them)");
				info = sn.nextLine();
				keepdata(info,"");
				String[] split = info.split(",");
				Customer newCustomer = new Customer(split[0],split[1],new Address("","","",""),new Phone(split[2],""),split[3]);
				newCustomer.CreateCustomer(newCustomer, cList);System.out.println(newCustomer.toString());

			}
		}
		else {//customer
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
				if(!enter) System.out.println("something went wrong!Enter again.");
			} while (!enter);

			do {
				System.out.println("1-SET INFORMATION");
				System.out.println("2-GIVE ORDER");
				System.out.println("3-DISPLAY ALL ORDERS");
				System.out.println("4-DISPLAY ALL FOODS");
				System.out.println("5-EXIT");
				answer = s.nextInt();
				/*
				 * set info
				 * give order
				 * display previous orders
				 * exit
				 */
				if(answer == 1) {//set information
					System.out.println("change your personal information");
					System.out.println("name,surname,address(street,town,city,description),phone(country code,number),password(leave only a comma between them)");
					System.out.println(cList.get(customerId).toString());
					String info = sn.nextLine();
					String[] split = info.split(",");
					cList.get(customerId).setUser(split[0], split[1], new Address(split[2],split[3],split[4],split[5]),new Phone(split[6],split[7]), split[8]);
					System.out.println("Your information changed successfully");
					System.out.println(cList.get(customerId).toString());

				}
				else if(answer == 2) {//give order

				}
				else if(answer == 3) {//display all orders

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
					System.exit(0);
				}
				else System.out.println("Invalid input!Try Again!");
			} while (answer!=4);

		}
	}


}


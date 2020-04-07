import java.util.ArrayList;
import java.util.List;

public class man {
	
	man(){
		//adding admin into the admin arraylist
		ArrayList<Admin> a = new ArrayList<Admin>();
		Admin ad = new Admin("name","surname",new Address("sstr","town","city","desc"),new Phone("5684638","234"));
		ad.createAdmin(ad, a);
		Admin addsd = new Admin("ndhgdfhsame","dhfsurname",new Address("sstr","town","city","desc"),new Phone("5684638","234"));
		ad.createAdmin(addsd, a);
		
		//Customer list will be created like adminlist arraylist
		
		
		
		}



}


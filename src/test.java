import java.awt.EventQueue;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws QueueFull, IOException, QueueEmpty {
		// TODO Auto-generated method stub
		Admin a = new Admin("melisa", "beys�meng�", new Address("109", "buca", "izmir", "hanzade yurt"), new Phone("000", "123"), "1");
		a.getRestaurant().setRestaurant("Melisa'n�n Baklavalar�", a.getAddress(), a.getPhone());
		a.getRestaurant().addFood(new Food("f�st�kl� baklava", "f�st�k,yufka,tereya��,�erbet", 150, a.getRestaurant()));
		a.getRestaurant().addFood(new Food("cevizli baklava", "ceviz,yufka,tereya��,�erbet", 90, a.getRestaurant()));
		a.getRestaurant().setCustomerqueue(new Customer("ali", "duran", new Address("12", "buca", "izmir", "manav kar��s�"), new Phone("0", "1h2"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("ahmet", "duran", new Address("23", "bornova", "izmir", "okul kar��s�"), new Phone("0", "182"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("salih", "duran", new Address("1232", "konak", "izmir", "dershane kar��s�"), new Phone("0", "1872"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("mehmet", "duran", new Address("132", "karaba�lar", "izmir", "lise kar��s�"), new Phone("0", "1972"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("batu", "duran", new Address("132", "�i�li", "izmir", "d�nerci �st�"), new Phone("0", "1972"), "123"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

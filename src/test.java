import java.awt.EventQueue;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws QueueFull, IOException, QueueEmpty {
		// TODO Auto-generated method stub
		Admin a = new Admin("melisa", "beysümengü", new Address("109", "buca", "izmir", "hanzade yurt"), new Phone("000", "123"), "1");
		a.getRestaurant().setRestaurant("Melisa'nýn Baklavalarý", a.getAddress(), a.getPhone());
		a.getRestaurant().addFood(new Food("fýstýklý baklava", "fýstýk,yufka,tereyaðý,þerbet", 150, a.getRestaurant()));
		a.getRestaurant().addFood(new Food("cevizli baklava", "ceviz,yufka,tereyaðý,þerbet", 90, a.getRestaurant()));
		a.getRestaurant().setCustomerqueue(new Customer("ali", "duran", new Address("12", "buca", "izmir", "manav karþýsý"), new Phone("0", "1h2"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("ahmet", "duran", new Address("23", "bornova", "izmir", "okul karþýsý"), new Phone("0", "182"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("salih", "duran", new Address("1232", "konak", "izmir", "dershane karþýsý"), new Phone("0", "1872"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("mehmet", "duran", new Address("132", "karabaðlar", "izmir", "lise karþýsý"), new Phone("0", "1972"), "123"));
		a.getRestaurant().setCustomerqueue(new Customer("batu", "duran", new Address("132", "çiðli", "izmir", "dönerci üstü"), new Phone("0", "1972"), "123"));
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

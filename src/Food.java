import java.util.ArrayList;

public class Food {
	private String  food_name; 
	private Restaurant restaurant_list;  
	private ArrayList<String> ingredients; 
	private int price;
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public Restaurant getRestaurant_list() {
		return restaurant_list;
	}
	public void setRestaurant_list(Restaurant restaurant_list) {
		this.restaurant_list = restaurant_list;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void addRestaurant(Restaurant rest) {}
}

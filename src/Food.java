import java.util.ArrayList;
public class Food {
	private String  food_name; 
	private ArrayList<Restaurant>restaurant_list;  
	private ArrayList<String> ingredients; 
	private int price;
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public ArrayList<Restaurant>getRestaurant_list() {
		return restaurant_list;
	}
	public void setRestaurant_list(ArrayList<Restaurant>restaurant_list) {
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
	@Override
	public String toString() {
		return "Food [food_name=" + food_name + ", restaurant_list=" + restaurant_list + ", ingredients=" + ingredients
				+ ", price=" + price + "]";
	}
	public Food(String food_name, ArrayList<Restaurant> restaurant_list, ArrayList<String> ingredients, int price) {
		this.food_name = food_name;
		this.restaurant_list = restaurant_list;
		this.ingredients = ingredients;
		this.price = price;
	}
	public void addRestaurant(Restaurant rest) {
		restaurant_list.add(rest);
	}
}

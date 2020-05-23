import java.util.ArrayList;
public class Food {
	private String  food_name; 
	private ArrayList<Restaurant>restaurant_list;  
	private ArrayList<String> ingredients =new ArrayList<String>(); 
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
		String restName = "";
		for (int i = 0; i < restaurant_list.size(); i++) {
			restName+=restaurant_list.get(i).getRestaurant_name()+" ";
		}
		return food_name  + "-" + ingredients + "-" + price+ "-" + restName;
	}
	public Food(String food_name, String ingredients, int price, Restaurant restaurant) {
		this.food_name = food_name;
		addRestaurant(restaurant);
		this.ingredients.add(ingredients);
		this.price = price;
		
	}
	public void addRestaurant(Restaurant rest) {
		restaurant_list = new ArrayList<Restaurant>();
		restaurant_list.add(rest);
	}
	
}

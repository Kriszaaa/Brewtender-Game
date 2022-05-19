	package component.recipe;

import java.util.ArrayList;
import java.util.Arrays;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;

public class RecipeStorage {
	
	protected static Beverage coffee = new Beverage("Coffee","Richly-flavored coffee made using complex processes suck as grinding and drip filtration.",1);
	protected static Beverage tea = new Beverage("Tea","High-quality tea leaves have been used to brew this tea. Has a rich fragrance.",1);
	protected static Beverage juice = new Beverage("Juice","Large and full orange have been hand-juiced to make this delicious sweet-and-sour extract.",1);
	
	protected static Flavoring milk = new Flavoring("Milk","Milk brought in from specific supply channels. The mouthfeel is incredibly smooth, and the aftertaste is sweet.",1);
	protected static Flavoring cocoa = new Flavoring("Cocoa Paste","Processed from the cocoa fruit. Its unique aroma can be used to add a rich flavor to the drink.",1);
	protected static Flavoring caramel = new Flavoring("Caramel","This boiled syrup has a thick texture and rich sweetness.",1);
	protected static Flavoring lemon = new Flavoring("Lemon","This vibrantly colored fruit has an intense sourness that can produce some unexpected results.",1);
	protected static Flavoring mint = new Flavoring("Mint","Freshly picked leaves that can be used to add a cooling taste.",1);
	protected static Flavoring soda = new Flavoring("Soda","A liquid that bubbles over. It has no taste, but its mouthfeel packs a punch",1);
	
	protected static ArrayList<Ingredient> baseingredient  = new ArrayList(Arrays.asList(coffee,tea,juice,milk,cocoa,caramel,lemon,soda,mint));
	protected static ArrayList<Recipe> allrecipes;
	
	public static ArrayList<Recipe> getAllrecipes() {
		return allrecipes;
	}
	public static String getIngredient(String name) {
		for (Ingredient i:baseingredient) {
			if(name.equals(i.getName())) {
				return i.getDescription();
			}
		}
		return "No such Ingredient";
	}
	public static void setAllrecipes(ArrayList<Recipe> allRecipes) {
		allrecipes = allRecipes;
	}
	public static void createRecipes() {
		return;
	}
}

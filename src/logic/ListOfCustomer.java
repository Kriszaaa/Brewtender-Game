package logic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
import component.Recipe;
import component.RecipeStorage;
import container.Size;

public class ListOfCustomer {
	
	private static ArrayList<Customer> CustomerList;
	
	private static Beverage coffee = new Beverage("Coffee","Richly-flavored coffee made using complex processes suck as grinding and drip filtration.",1);
	private static Beverage tea = new Beverage("Tea","High-quality tea leaves have been used to brew this tea. Has a rich fragrance.",1);
	private static Beverage juice = new Beverage("Juice","Large and full orange have been hand-juiced to make this delicious sweet-and-sour extract.",1);
	
	private static Flavoring milk = new Flavoring("Milk","Milk brought in from specific supply channels. The mouthfeel is incredibly smooth, and the aftertaste is sweet.",1);
	private static Flavoring cocoa = new Flavoring("Cocoa Paste","Processed from the cocoa fruit. Its unique aroma can be used to add a rich flavor to the drink.",1);
	private static Flavoring caramel = new Flavoring("Caramel","This boiled syrup has a thick texture and rich sweetness.",1);
	private static Flavoring lemon = new Flavoring("Lemon","This vibrantly colored fruit has an intense sourness that can produce some unexpected results.",1);
	private static Flavoring mint = new Flavoring("Mint","Freshly picked leaves that can be used to add a cooling taste.",1);
	private static Flavoring soda = new Flavoring("Soda","A liquid that bubbles over. It has no taste, but its mouthfeel packs a punch",1);
	
	
	
	public static void generateCustomerList(Mode mode) {
		
		if(mode.equals(Mode.EASY)) {
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			String rand_des;
			ArrayList<Ingredient> rand_rep;
			Random rand = new Random();
			int randnum;
			for(int i=0;i<20;i++) {
				randnum = rand.nextInt(RecipeStorage.getAllrecipes().size());
				rand_des = RecipeStorage.getAllrecipes().get(randnum).getDescription();
				rand_rep = RecipeStorage.getAllrecipes().get(randnum).getListofingredient();
				customerList.add(new Customer(rand_des,rand_rep,randomSize()));
			}
			setCustomerList(customerList);
		}else {
			
		}
	}
	
	public static ArrayList<Customer> getCustomerList() {
		return CustomerList;
	}

	public static void setCustomerList(ArrayList<Customer> customerList) {
		CustomerList = customerList;
	}

	public static Size randomSize() {
		Random rand = new Random();
		int randnum = rand.nextInt(3);
		if (randnum == 0) {
			return Size.SMALL;
		}else if(randnum == 1) {
			return Size.MEDIUM;
		}else{
			return Size.LARGE;
		}
	}
}

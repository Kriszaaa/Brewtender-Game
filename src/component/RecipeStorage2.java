package component;

import java.util.ArrayList;
import java.util.Arrays;

import logic.Customer;

public class RecipeStorage2 {
	
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
	
	private static String h1_des = "I want Brightcrown with more cooling and sour taste";
	private static String h2_des = "I want Dusk with more fizzy";
	private static String h3_des = "I want Athenaeum with much more sweetness";
	private static String h4_des = "I want Caramel Pinecone with more cooling and more sweet";
	private static String h5_des = "I want Foamy Reef with more sour and sweetness";
	private static String h6_des = "I want Golden Eden with more smooth taste";
	private static String h7_des = "I want Moonlit Alley with much more unique aroma";
	
	private static String h8_des = "I want Night of Swirling Stars with more cooling and smooth taste";
	private static String h9_des = "I want Stroke of Night with much more rich flavor";
	private static String h10_des = "I want Birch Sap with more rich fragrance";
	private static String h11_des = "I want Barbatos' Boon with more sour taste";
	private static String h12_des = "Give me the menu that have tea and sour taste";
	private static String h13_des = "Give me the menu that have Juice that's fizzy";

	private static String h14_des = "Give me the menu that have tea with smooth taste";
	private static String h15_des = "Give me the menu that have juice with much more smooth taste";
	
	private static ArrayList<Ingredient> h1 = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 2),tea,mint,lemon));
	private static ArrayList<Ingredient> h2 = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),tea,soda));
	private static ArrayList<Ingredient> h3 = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 3),Flavoring.setCondense(caramel, 2)));
	private static ArrayList<Ingredient> h4 = new ArrayList(Arrays.asList(coffee,milk,Flavoring.setCondense(caramel, 2),mint));
	private static ArrayList<Ingredient> h5 = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 2),soda,lemon,caramel));
	private static ArrayList<Ingredient> h6 = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 2),Flavoring.setCondense(milk, 2)));
	private static ArrayList<Ingredient> h7 = new ArrayList(Arrays.asList(coffee,milk,Flavoring.setCondense(cocoa, 3)));
	private static ArrayList<Ingredient> h8 = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 3),coffee,mint));
	private static ArrayList<Ingredient> h9 = new ArrayList(Arrays.asList(coffee,tea,milk,Flavoring.setCondense(cocoa, 2)));
	private static ArrayList<Ingredient> h10 = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),lemon,tea));
	private static ArrayList<Ingredient> h11 = new ArrayList(Arrays.asList(juice,soda,mint,lemon));
	private static ArrayList<Ingredient> h12 = new ArrayList(Arrays.asList(Beverage.setCondense(tea, 2),lemon));
	private static ArrayList<Ingredient> h13 = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),soda));
	private static ArrayList<Ingredient> h14 = new ArrayList(Arrays.asList(Beverage.setCondense(tea, 2),milk));
	private static ArrayList<Ingredient> h15 = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 3),juice));
	
	private static ArrayList<Recipe> allrecipes;
	
	public static void createRecipes() {
		
		Recipe h1_reps = new Recipe(h1_des,h1);
		Recipe h2_reps = new Recipe(h2_des,h2);
		Recipe h3_reps = new Recipe(h3_des,h3);
		Recipe h4_reps = new Recipe(h4_des,h4);
		Recipe h5_reps = new Recipe(h5_des,h5);
		Recipe h6_reps = new Recipe(h6_des,h6);
		Recipe h7_reps = new Recipe(h7_des,h7);
		Recipe h8_reps = new Recipe(h8_des,h8);
		Recipe h9_reps = new Recipe(h9_des,h9);
		Recipe h10_reps = new Recipe(h10_des,h10);
		Recipe h11_reps = new Recipe(h11_des,h11);
		Recipe h12_reps = new Recipe(h12_des,h12);
		Recipe h13_reps = new Recipe(h13_des,h13);
		
		Recipe h14_reps = new Recipe(h14_des,h14);
		Recipe h15_reps = new Recipe(h15_des,h15);
		
		ArrayList<Recipe> allrecipes = new ArrayList<Recipe>(Arrays.asList(h1_reps,h2_reps,h3_reps,h4_reps,h5_reps,h6_reps,h7_reps,
																			h8_reps,h9_reps,h10_reps,h11_reps,h12_reps,h13_reps,
																			h14_reps,h15_reps));
		setAllrecipes(allrecipes);
		
	}

	public static ArrayList<Recipe> getAllrecipes() {
		return allrecipes;
	}
	public static void setAllrecipes(ArrayList<Recipe> allrecipes) {
		RecipeStorage2.allrecipes = allrecipes;
	}
	
	
	
}

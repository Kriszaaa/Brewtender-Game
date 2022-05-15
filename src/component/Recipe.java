package component;

import java.util.ArrayList;
import java.util.Arrays;

import logic.Customer;

public class Recipe {
	
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
	
	
	private static ArrayList<Ingredient> atn = new ArrayList(Arrays.asList(Ingredient.setCondense(coffee, 3)));
	private static ArrayList<Ingredient> cp = new ArrayList(Arrays.asList(coffee,milk,caramel));
	private static ArrayList<Ingredient> fr = new ArrayList(Arrays.asList(Ingredient.setCondense(coffee, 2),soda));
	private static ArrayList<Ingredient> ge = new ArrayList(Arrays.asList(Ingredient.setCondense(coffee, 2),milk));
	private static ArrayList<Ingredient> ma = new ArrayList(Arrays.asList(coffee,milk,cocoa));
	private static ArrayList<Ingredient> nss = new ArrayList(Arrays.asList(Ingredient.setCondense(milk, 2),coffee));
	private static ArrayList<Ingredient> sn = new ArrayList(Arrays.asList(coffee,tea,milk));
	
	private static ArrayList<Ingredient> bb = new ArrayList(Arrays.asList(juice,soda,mint));
	private static ArrayList<Ingredient> bs = new ArrayList(Arrays.asList(Ingredient.setCondense(juice, 2),lemon));
	private static ArrayList<Ingredient> dd = new ArrayList(Arrays.asList(Ingredient.setCondense(juice, 2),soda));
	private static ArrayList<Ingredient> gvs = new ArrayList(Arrays.asList(Ingredient.setCondense(juice, 3)));
	private static ArrayList<Ingredient> sck = new ArrayList(Arrays.asList(Ingredient.setCondense(juice, 2),milk));
	private static ArrayList<Ingredient> scl = new ArrayList(Arrays.asList(Ingredient.setCondense(milk, 3),juice));
	
	private static ArrayList<Ingredient> bw = new ArrayList(Arrays.asList(tea,milk,mint));
	private static ArrayList<Ingredient> b = new ArrayList(Arrays.asList(Ingredient.setCondense(milk, 2),tea));
	private static ArrayList<Ingredient> d = new ArrayList(Arrays.asList(Ingredient.setCondense(juice, 2),tea));
	private static ArrayList<Ingredient> lc = new ArrayList(Arrays.asList(tea,milk,cocoa));
	private static ArrayList<Ingredient> lp = new ArrayList(Arrays.asList(tea,milk,caramel));
	private static ArrayList<Ingredient> mg = new ArrayList(Arrays.asList(Ingredient.setCondense(tea, 3)));
	private static ArrayList<Ingredient> sa = new ArrayList(Arrays.asList(Ingredient.setCondense(tea, 2),milk));
	private static ArrayList<Ingredient> tb = new ArrayList(Arrays.asList(Ingredient.setCondense(tea, 2),lemon));
	
	private static String atn_des = "Athenaeum";
	private static String cp_des = "Caramel Pinecone";
	private static String fr_des = "Foamy Reef";
	private static String ge_des = "Golden Eden";
	private static String ma_des = "Moonlit Alley";
	private static String nss_des = "Night of Swirling Stars";
	private static String sn_des = "Stroke of Night";
	
	private static String bb_des = "Barbatos' Boon";
	private static String bs_des = "Birch Sap";
	private static String dd_des = "Dawning Dew";
	private static String gvs_des = "Gray Valley Sunset";
	private static String sck_des = "Snow-Covered Kiss";
	private static String scl_des = "Sweet Cider Lake";
	
	private static String bw_des = "Boreal Watch";
	private static String b_des = "Brightcrown";
	private static String d_des = "Dusk";
	private static String lc_des = "Laughter and Cheer";
	private static String lp_des = "Love Poem";
	private static String mg_des = "Misty Garden";
	private static String sa_des = "Scholar's Afternoon";
	private static String tb_des = "Tart Brilliance";
	
	private static String atn_rep = "Coffee + Coffee + Coffee";
	private static String cp_rep = "Coffee + Milk + Caramel";
	private static String fr_rep = "Coffee + Coffee + Fizzy Water";
	private static String ge_rep = "Coffee + Coffee + Milk";
	private static String ma_rep = "Coffee + Milk + Cocoa Paste";
	private static String nss_rep = "Coffee + Milk + Milk";
	private static String sn_rep = "Coffee + Tea + Milk";
	
	private static String bb_rep = "Juice + Fizzy Water + Mint";
	private static String bs_rep = "Juice + Juice + Lemon";
	private static String dd_rep = "Juice + Juice + Fizzy Water";
	private static String gvs_rep = "Juice + Juice + Juice";
	private static String sck_rep = "Juice + Juice + Milk";
	private static String scl_rep = "Juice + Milk + Milk";
	
	private static String bw_rep = "Tea + Milk + Mint";
	private static String b_rep = "Tea + Milk + Milk";
	private static String d_rep = "Tea + Juice + Juice";
	private static String lc_rep = "Tea + Milk + Cocoa Paste";
	private static String lp_rep = "Tea + Milk + Caramel";
	private static String mg_rep = "Tea + Tea + Tea";
	private static String sa_rep = "Tea + Tea + Milk";
	private static String tb_rep = "Tea + Tea + Lemon";
	
	
	
}

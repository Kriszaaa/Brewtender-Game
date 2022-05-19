package component.recipe;

import java.util.ArrayList;
import java.util.Arrays;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
import logic.Customer;

public class EasyRecipe extends RecipeStorage{

		private static ArrayList<Customer> CustomerList;
		
		
		
		private static ArrayList<Ingredient> atn = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 3)));
		private static ArrayList<Ingredient> cp = new ArrayList(Arrays.asList(coffee,milk,caramel));
		private static ArrayList<Ingredient> fr = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 2),soda));
		private static ArrayList<Ingredient> ge = new ArrayList(Arrays.asList(Beverage.setCondense(coffee, 2),milk));
		private static ArrayList<Ingredient> ma = new ArrayList(Arrays.asList(coffee,milk,cocoa));
		private static ArrayList<Ingredient> nss = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 2),coffee));
		private static ArrayList<Ingredient> sn = new ArrayList(Arrays.asList(coffee,tea,milk));
		
		private static ArrayList<Ingredient> bb = new ArrayList(Arrays.asList(juice,soda,mint));
		private static ArrayList<Ingredient> bs = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),lemon));
		private static ArrayList<Ingredient> dd = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),soda));
		private static ArrayList<Ingredient> gvs = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 3)));
		private static ArrayList<Ingredient> sck = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),milk));
		private static ArrayList<Ingredient> scl = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 2),juice));
		
		private static ArrayList<Ingredient> bw = new ArrayList(Arrays.asList(tea,milk,mint));
		private static ArrayList<Ingredient> b = new ArrayList(Arrays.asList(Flavoring.setCondense(milk, 2),tea));
		private static ArrayList<Ingredient> d = new ArrayList(Arrays.asList(Beverage.setCondense(juice, 2),tea));
		private static ArrayList<Ingredient> lc = new ArrayList(Arrays.asList(tea,milk,cocoa));
		private static ArrayList<Ingredient> lp = new ArrayList(Arrays.asList(tea,milk,caramel));
		private static ArrayList<Ingredient> mg = new ArrayList(Arrays.asList(Beverage.setCondense(tea, 3)));
		private static ArrayList<Ingredient> sa = new ArrayList(Arrays.asList(Beverage.setCondense(tea, 2),milk));
		private static ArrayList<Ingredient> tb = new ArrayList(Arrays.asList(Beverage.setCondense(tea, 2),lemon));
		
		//name
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
		
		
		//recipes
		/*private static String atn_rep = "Coffee + Coffee + Coffee";
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
		*/
		
		public static void createRecipes() {
			
			//System.out.println(atn.get(0).getConcentration()+" "+atn.get(0).getName());
			
			
			Recipe atn_reps = new Recipe(atn_des,atn);
			Recipe cp_reps = new Recipe(cp_des,cp);
			Recipe fr_reps = new Recipe(fr_des,fr);
			Recipe ge_reps = new Recipe(ge_des,ge);
			Recipe ma_reps = new Recipe(ma_des,ma);
			Recipe nss_reps = new Recipe(nss_des,nss);
			Recipe sn_reps = new Recipe(sn_des,sn);
			
			Recipe bb_reps = new Recipe(bb_des,bb);
			Recipe bs_reps = new Recipe(bs_des,bs);
			Recipe dd_reps = new Recipe(dd_des,dd);
			Recipe gvs_reps = new Recipe(gvs_des,gvs);
			Recipe sck_reps = new Recipe(sck_des,sck);
			Recipe scl_reps = new Recipe(scl_des,scl);
			
			Recipe bw_reps = new Recipe(bw_des,bw);
			Recipe b_reps = new Recipe(b_des,b);
			Recipe d_reps = new Recipe(d_des,d);
			Recipe lc_reps = new Recipe(lc_des,lc);
			Recipe lp_reps = new Recipe(lp_des,lp);
			Recipe mg_reps = new Recipe(mg_des,mg);
			Recipe sa_reps = new Recipe(sa_des,sa);
			Recipe tb_reps = new Recipe(tb_des,tb);
			
			ArrayList<Recipe> allrecipes = new ArrayList<Recipe>(Arrays.asList(atn_reps,cp_reps,fr_reps,ge_reps,ma_reps,nss_reps,sn_reps,
															bb_reps,bs_reps,dd_reps,gvs_reps,sck_reps,scl_reps,
															bw_reps,b_reps,d_reps,lc_reps,lp_reps,mg_reps,sa_reps,tb_reps));
			setAllrecipes(allrecipes);
		}


}

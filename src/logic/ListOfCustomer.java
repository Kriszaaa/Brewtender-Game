package logic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
import component.recipe.EasyRecipe;
import component.recipe.HardRecipe;
import component.recipe.RecipeStorage;
import container.Size;

public class ListOfCustomer {
	
	private static String rand_des;
	private static ArrayList<Ingredient> rand_rep;
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private static Random rand = new Random();
	private static int randnum;
	private static int number_of_customer = 50;
	
	public static void generateCustomerList() {
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		for(int i=0;i<number_of_customer;i++) {
			randnum = rand.nextInt(RecipeStorage.getAllrecipes().size());
			rand_des = RecipeStorage.getAllrecipes().get(randnum).getDescription();
			rand_rep = RecipeStorage.getAllrecipes().get(randnum).getListofingredient();
			customerList.add(new Customer(rand_des,rand_rep,randomSize()));
		}
		setCustomerList(customerList);
	}
	
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(ArrayList<Customer> newcustomerList) {
		customerList = newcustomerList;
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

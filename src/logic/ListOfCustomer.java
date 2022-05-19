package logic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
import component.recipe.EasyRecipe;
import component.recipe.HardRecipe;
import container.Size;

public class ListOfCustomer {
	
	private static ArrayList<Customer> CustomerList;

	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private static String rand_des;
	private static ArrayList<Ingredient> rand_rep;
	private static Random rand = new Random();
	private static int randnum;
	private static int number_of_customer = 50;
	
	public static void generateCustomerList(Mode mode) {
		
		if(mode.equals(Mode.EASY)) {
				
			for(int i=0;i<number_of_customer;i++) {
				randnum = rand.nextInt(EasyRecipe.getAllrecipes().size());
				rand_des = EasyRecipe.getAllrecipes().get(randnum).getDescription();
				rand_rep = EasyRecipe.getAllrecipes().get(randnum).getListofingredient();
				customerList.add(new Customer(rand_des,rand_rep,randomSize()));
			}
			setCustomerList(customerList);
		}else {
			
			for(int i=0;i<number_of_customer;i++) {
				randnum = rand.nextInt(HardRecipe.getAllrecipes().size());
				rand_des = HardRecipe.getAllrecipes().get(randnum).getDescription();
				rand_rep = HardRecipe.getAllrecipes().get(randnum).getListofingredient();
				customerList.add(new Customer(rand_des,rand_rep,randomSize()));
			}
			setCustomerList(customerList);
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

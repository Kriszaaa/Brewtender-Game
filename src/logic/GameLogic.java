package logic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Random;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
import component.RecipeStorage;
import container.Glass;
import container.Size;

import exception.ServeFailedException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class GameLogic {

	private static Timer playerTimer;
	private static int playerScore;
	
	private static Glass glass;
	private static ArrayList<Customer> CustomerList;
	private String errorText = "";
	private static Mode mode;
	private static ArrayList<String> ErrorText = new ArrayList(Arrays.asList("","",""));
	private static int trytimes = 3;
	private static int orderrunner = 0;
	private static Customer presentcustomer;
			
	public static void selectMode(Mode choosenMode) {
		mode = choosenMode;
	}
	public static void startGame() {
		glass = new Glass();
		System.out.println("start");
		startRunOrder();
	}
	public static void startRunOrder() {
		
		RecipeStorage.createRecipes();
		ListOfCustomer.generateCustomerList(Mode.EASY);
		CustomerList = ListOfCustomer.getCustomerList();
		presentcustomer = CustomerList.get(orderrunner);
		/*for(int i = 0;i<20;i++) {
			//System.out.println(CustomerList.get(i).getDescription()+" "+CustomerList.get(i).getRecipes()+" "+CustomerList.get(i).getSize());
			for(Ingredient j:CustomerList.get(i).getDrink()) {
				System.out.print(j.getName()+" "+j.getConcentration()+"\n");
			}
		}*/
	}
	public static void callNextCustomer() {
		trytimes = 3;
		orderrunner += 1;
		presentcustomer = CustomerList.get(orderrunner);
	}
	public static void chooseMode() {
		
	}
	public static void endGame() {
		
	}
	public static boolean Serve(Glass glass,Customer customer) {
		
		System.out.println("serve");
		System.out.println(customer.getRecipes());
		try {
			if(DrinkValidator.checkDrink(customer,glass)) {
				callNextCustomer();
				return true;
			}else {
				System.out.print("Wrong Ingredient");
				
				//test
				System.out.println();
				for(Ingredient i:glass.getDrink()) {
					System.out.print(i.getName()+" "+i.getConcentration()+"\n");
				}
				System.out.println("Customer");
				for(Ingredient i:customer.getDrink()) {
					System.out.print(i.getName()+" "+i.getConcentration()+"\n");
				}
				//test
				
				
				trytimes -= 1;
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Wrong Ingredients");
				
				alert.setHeaderText(null);
				ButtonType tryagain = new ButtonType("");
				if(trytimes <= 0) {
					String errortext = "Customer get upset. Why you so noob man.";
					alert.setContentText(errortext);
					alert.getButtonTypes().clear();
					
					tryagain = new ButtonType("Sad");
					alert.getButtonTypes().add(tryagain);
					
					Optional<ButtonType> option = alert.showAndWait();
					
					if(option.get() == tryagain) {
						alert.close();
					}
					callNextCustomer();
					return true;
				}else {
					//random encourage sentences
					Random rand = new Random();
					int randnum = rand.nextInt(3);
					String errortext = ErrorText.get(randnum);
					alert.setContentText(errortext);
					alert.getButtonTypes().clear();
					
					//Text on Button
					tryagain = new ButtonType("Try("+trytimes+")");
					alert.getButtonTypes().add(tryagain);
					
					Optional<ButtonType> option = alert.showAndWait();
					
					if(option.get() == tryagain) {
						alert.close();
					}
					return false;
				}
				
			}
		}catch(ServeFailedException e) {
			//e.printErrormessage();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ServeFail");
			
			alert.setHeaderText(null);
			
			
			alert.setContentText(e.getMessage());
			alert.getButtonTypes().clear();
			
			ButtonType ok = new ButtonType("ok");
			alert.getButtonTypes().add(ok);
			
			Optional<ButtonType> option = alert.showAndWait();
			
			if(option.get() == ok) {
				alert.close();
			}
			return false;
		}
	}
	public static Ingredient createIngredientFromName(String s){
		switch(s) {
			case "Coffee":
				return new Beverage("Coffee");
			case "Tea":
				return new Beverage("Tea");
			case "Juice":
				return new Beverage("Juice");
			case "Cocoa Paste":
				return new Flavoring("Cocoa Paste");
			case "Caramel":
				return new Flavoring("Caramel");
			case "Mint":
				return new Flavoring("Mint");
			case "Lemon":
				return new Flavoring("Lemon");
			case "Soda":
				return new Flavoring("Soda");
			case "Milk":
				return new Flavoring("Milk");
			default:
				return null;
		}
	}
	public static void clearGlass() {
		System.out.println("clear");
		glass = new Glass();
	}
	
	public static Glass getGlass() {
		return glass;
	}

	public static Customer getPresentcustomer() {
		return presentcustomer;
	}
	public static int getConcentrationWithId(String s) {
		
		for(Ingredient i:glass.getDrink()) {
			if(s.equals(i.getName())) {
				return i.getConcentration();
			}
		}
		return 0;
	}

	public static void addIngredientToGlass(String name) {
		Ingredient ingredient = createIngredientFromName(name);
		glass.addIngredient(ingredient);
	}
	public static void setglassSize(Size size) {
		glass.setSize(size);
		//System.out.println(glass.getSize());
	}
	public static String getCustomerOrder() {
		return (presentcustomer.getDescription()+" "+presentcustomer.getSize());
	}
}

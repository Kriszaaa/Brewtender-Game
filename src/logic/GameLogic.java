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
			System.out.println(CustomerList.get(i).getDescription()+" "+CustomerList.get(i).getRecipes()+" "+CustomerList.get(i).getSize());
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
	public static void Serve(Glass glass,Customer customer) {
		
		System.out.println("serve");
		try {
			if(DrinkValidator.checkDrink(customer,glass)) {
				callNextCustomer();
			}else {
				System.out.print("Wrong Ingredient");
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Wrong Ingredients");
				
				alert.setHeaderText(null);
				Random rand = new Random();
				int randnum = rand.nextInt(3);
				String errortext = ErrorText.get(randnum);
				alert.setContentText(errortext);
				alert.getButtonTypes().clear();
				
				ButtonType tryagain = new ButtonType("Try("+trytimes+")");
				trytimes -= 1;
				alert.getButtonTypes().add(tryagain);
				
				Optional<ButtonType> option = alert.showAndWait();
				
				if(option.get() == tryagain) {
					alert.close();
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
		glass = new Glass();
	}
	
	public static Glass getGlass() {
		return glass;
	}

	public static Customer getPresentcustomer() {
		return presentcustomer;
	}

	public static void addIngredientToGlass(String name) {
		Ingredient ingredient = createIngredientFromName(name);
		glass.addIngredient(ingredient);
	}
	public static void setglassSize(Size size) {
		glass.setSize(size);
		//System.out.println(glass.getSize());
	}
}

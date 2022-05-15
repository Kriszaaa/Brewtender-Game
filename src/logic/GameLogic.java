package logic;


import java.util.Hashtable;
import java.util.Optional;

import component.Beverage;
import component.Flavoring;
import component.Ingredient;
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
	
	private String errorText = "";
	
			
	public static void startCountDownTimer(int pl) {

		Thread thread = new Thread(() -> {
			try {
				runCountDownTimer(pl);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		thread.start();
	}
	public static void startGame() {
		glass = new Glass();
		System.out.println("start");
	}
	public static void runCountDownTimer(int pl) throws InterruptedException {
		
	}
	public static void beginTurns(int pl) {

	}
	public static void chooseMode() {
		
	}
	public static void endGame() {
		
	}
	public static void Serve(Glass glass,Customer customer) {
		try {
			if(DrinkValidator.checkDrink(customer,glass)) {
				callNextCustomer();
			}else {
				System.out.print("Wrong Ingredient");
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
				Platform.exit();
			}
		}
	}
	public static void callNextCustomer() {
		
		
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
	
	public static void addIngredientToGlass(String name) {
		Ingredient ingredient = createIngredientFromName(name);
		glass.addIngredient(ingredient);
	}
}

package logic;


import java.util.Hashtable;

import container.Glass;
import container.Size;
import exception.ServeFailedException;
import javafx.application.Platform;

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
			e.printErrormessage();
		}
	}
	public static void callNextCustomer() {
		
		
	}
}

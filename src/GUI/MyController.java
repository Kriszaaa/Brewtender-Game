package GUI;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import logic.GameLogic;
import logic.Timer;

public class MyController implements Initializable{
	
	@FXML
	private Button coffee,tea,juice,milk,mint,lemon,soda,cocoa,caramel;
	private Button StartButton,NewGameButton;
	
	public void start(ActionEvent e) {
		GameLogic.startGame();
		startCountdown();
	}
	public void clear(ActionEvent e) {
		GameLogic.clearGlass();
	}
	public void serve(ActionEvent e) {
		
	}
	public void customerOrder(ActionEvent e) {
		
	}
	public void newGame(ActionEvent e) {

	}
	
	public void add(ActionEvent e) {
		Button btn = (Button) e.getSource();
		switch(btn.getId()) {
			case "coffee":
				GameLogic.addIngredientToGlass("Coffee");
				break;
			case "tea":
				GameLogic.addIngredientToGlass("Tea");
				break;
			case "juice":
				GameLogic.addIngredientToGlass("Juice");
				break;
			case "milk":
				GameLogic.addIngredientToGlass("Milk");
				break;
			case "mint":
				GameLogic.addIngredientToGlass("Mint");
				break;
			case "lemon":
				GameLogic.addIngredientToGlass("Lemon");
				break;
			case "soda":
				GameLogic.addIngredientToGlass("Soda");
				break;
			case "cocoa":
				GameLogic.addIngredientToGlass("Cocoa Paste");
				break;
			case "caramel":
				GameLogic.addIngredientToGlass("Caramel");
				break;
		}
			
	}
	
	public void startCountdown(){
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Timer timer = new Timer(5,0);
					for(int i=1;i<=10;i++) {
						
						Thread.sleep(1000);
						timer.decrementTimer(1);
						//System.out.println(timer.toString());
					}
				} catch(Exception e) {
					
				}
			}
			
		});
		thread.start();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}

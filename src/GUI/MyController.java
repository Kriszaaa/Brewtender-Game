package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import container.Size;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameLogic;
import logic.Timer;

public class MyController implements Initializable{
	
	@FXML
	private Button coffee,tea,juice,milk,mint,lemon,soda,cocoa,caramel;
	
	@FXML
	private Button StartButton,NewGameButton,serveButton;
	
	@FXML
	private Button small,medium,large;
	
	@FXML
	private Text timerText;
	
	Timer timer = new Timer(5,0);
	static volatile boolean exit = false;
	
	public void start(ActionEvent e) {
		GameLogic.startGame();
		startCountdown();
		exit = false;
	}
	public void clear(ActionEvent e) {
		GameLogic.clearGlass();
	}
	public void serve(ActionEvent e) {
		GameLogic.Serve(GameLogic.getGlass(), GameLogic.getPresentcustomer());
	}
	public void customerOrder(ActionEvent e) {
		
	}
	public void newGame(ActionEvent e) {
		
		timer.setMinute(5);
		timer.setSeconds(0);
		timerText.setText(timer.toString());
		exit = true;
		
	}
	public void fillSize(ActionEvent e) {
		Button btn = (Button) e.getSource();
		switch(btn.getId()) {
		case "small":
			GameLogic.setglassSize(Size.SMALL);
			break;
		case "medium":
			GameLogic.setglassSize(Size.MEDIUM);
			break;
		case "large":
			GameLogic.setglassSize(Size.LARGE);
			break;
		}
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
						timer.setMinute(5);
						timer.setSeconds(0);
						for(int i=1;i<=300;i++) {
							while(!exit) {
							
							timer.decrementTimer(1);
							timerText.setText(timer.toString());
							Thread.sleep(1000);
							//System.out.println(timer.toString());
							}
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

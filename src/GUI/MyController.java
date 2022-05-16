package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import container.Glass;
import container.Size;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.Timer;

public class MyController implements Initializable{
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	
	
	 
	 public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("recipePage.fxml"));
		  Stage stage = new Stage();
		  stage.setTitle("Recipes");
		  stage.setScene(new Scene(root, 450, 450));
		  stage.show();
		 }
	
	@FXML
	private Button coffee,tea,juice,milk,mint,lemon,soda,cocoa,caramel;
	
	@FXML
	private Button StartButton,NewGameButton,serveButton,clearButton;
	
	@FXML
	private Button small,medium,large;
	
	@FXML
	private Text timerText,orderText,coffeeNumberText,teaNumberText,juiceNumberText;
	
	@FXML
	private Text milkNumberText,mintNumberText,lemonNumberText,sodaNumberText,cocoaNumberText,caramelNumberText;
	

	
	Timer timer = new Timer(5,0);
	static volatile boolean exit = false;
	
	public void start(ActionEvent e) {
		GameLogic.startGame();
		orderText.setText(GameLogic.getCustomerOrder());
		startCountdown();
		exit = false;
		StartButton.setDisable(true);
	}
	public void clear(ActionEvent e) {
		GameLogic.clearGlass();
		coffee.setStyle(null);
		tea.setStyle(null);
		juice.setStyle(null);
		milk.setStyle(null);
		mint.setStyle(null);
		lemon.setStyle(null);
		soda.setStyle(null);
		cocoa.setStyle(null);
		caramel.setStyle(null);
		small.setStyle(null);
		medium.setStyle(null);
		large.setStyle(null);
		
		coffeeNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Coffee")));
		teaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Tea")));
		juiceNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Juice")));
		milkNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Milk")));
		mintNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Mint")));
		lemonNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Lemon")));
		sodaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Soda")));
		cocoaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Cocoa Paste")));
		caramelNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Caramel")));
	}
	public void serve(ActionEvent e) {
		if(GameLogic.Serve(GameLogic.getGlass(), GameLogic.getPresentcustomer())) {
			orderText.setText(GameLogic.getCustomerOrder());
			clear(e);
		}
	}
	public void customerOrder(ActionEvent e) {
		
	}
	public void newGame(ActionEvent e) {
		
		timer.setMinute(5);
		timer.setSeconds(0);
		timerText.setText(timer.toString());
		exit = true;
		StartButton.setDisable(false);
		GameLogic.clearGlass();
		orderText.setText("Order");
		coffee.setStyle(null);
		tea.setStyle(null);
		juice.setStyle(null);
		milk.setStyle(null);
		mint.setStyle(null);
		lemon.setStyle(null);
		soda.setStyle(null);
		cocoa.setStyle(null);
		caramel.setStyle(null);
		small.setStyle(null);
		medium.setStyle(null);
		large.setStyle(null);
		coffeeNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Coffee")));
		teaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Tea")));
		juiceNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Juice")));
		milkNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Milk")));
		mintNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Mint")));
		lemonNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Lemon")));
		sodaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Soda")));
		cocoaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Cocoa Paste")));
		caramelNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Caramel")));
		
	}
	public void fillSize(ActionEvent e) {
		Button btn = (Button) e.getSource();
		switch(btn.getId()) {
		case "small":
			GameLogic.setglassSize(Size.SMALL);
			small.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
			medium.setStyle(null);
			large.setStyle(null);
			break;
		case "medium":
			GameLogic.setglassSize(Size.MEDIUM);
			medium.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
			small.setStyle(null);
			large.setStyle(null);
			break;
		case "large":
			GameLogic.setglassSize(Size.LARGE);
			large.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
			small.setStyle(null);
			medium.setStyle(null);
			break;
		}
	}
	public void add(ActionEvent e) {
		Button btn = (Button) e.getSource();
		if (GameLogic.getGlass().addable()) {
			switch(btn.getId()) {
				case "coffee":
					GameLogic.addIngredientToGlass("Coffee");
					coffee.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					coffeeNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Coffee")));
					break;
				case "tea":
					GameLogic.addIngredientToGlass("Tea");
					tea.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					teaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Tea")));
					break;
					
				case "juice":
					GameLogic.addIngredientToGlass("Juice");
					juice.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					juiceNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Juice")));
					break;
				case "milk":
					GameLogic.addIngredientToGlass("Milk");
					milk.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					milkNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Milk")));
					break;
				case "mint":
					GameLogic.addIngredientToGlass("Mint");
					mint.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					mintNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Mint")));
					break;
				case "lemon":
					GameLogic.addIngredientToGlass("Lemon");
					lemon.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					lemonNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Lemon")));
					break;
				case "soda":
					GameLogic.addIngredientToGlass("Soda");
					soda.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					sodaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Soda")));
					break;
				case "cocoa":
					GameLogic.addIngredientToGlass("Cocoa Paste");
					cocoa.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					cocoaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Cocoa Paste")));
					break;
				case "caramel":
					GameLogic.addIngredientToGlass("Caramel");
					caramel.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					caramelNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Caramel")));
					break;
			}
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

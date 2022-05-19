package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import component.recipe.EasyRecipe;
import component.recipe.RecipeStorage;
import container.Glass;
import container.Size;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameLogic;
import logic.GradingScore;
import logic.Mode;
import logic.Timer;

public class MyController implements Initializable{
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 private AudioClip buttonclick = new AudioClip(ClassLoader.getSystemResource("Buttonclick.wav").toString());
	 private AudioClip pick = new AudioClip(ClassLoader.getSystemResource("berry_pick.wav").toString());
	 private AudioClip pouring = new AudioClip(ClassLoader.getSystemResource("pouringasmalldrink.wav").toString());
	 
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

	@FXML
	private TableColumn<?, ?> menuList;
	
	@FXML
	private ImageView background;

	
	Timer timer = new Timer(5,0);
	static volatile boolean exit = false;
	
	 
	public void switchToRecipe(ActionEvent event) throws IOException {
		  buttonclick.play();
		  Parent root = FXMLLoader.load(getClass().getResource("recipePage.fxml"));
		  Stage stage = new Stage();
		  scene = new Scene(root);
	      
		  stage.setTitle("Recipes");
		  stage.setScene(scene);
		  stage.show();
	}
	
	 public void switchToScoreScene(boolean end) throws IOException {
		    if (end == true) {
		    	
		        Parent root = FXMLLoader.load(getClass().getResource("scorePage.fxml"));
		        Scene SceneMenu = new Scene(root);
		        Stage stage = (Stage)StartButton.getScene().getWindow();
		        
		        String css1 = this.getClass().getResource("scorePage.css").toExternalForm();
			    SceneMenu.getStylesheets().add(css1);
			    
		        stage.setScene(SceneMenu);
		        stage.show();
		    }
	}
	 
	
	public void start(ActionEvent e) {
		GameLogic.startGame();
		
		coffee.setTooltip(new Tooltip(RecipeStorage.getIngredient("Coffee")));
		tea.setTooltip(new Tooltip(RecipeStorage.getIngredient("Tea")));
		juice.setTooltip(new Tooltip(RecipeStorage.getIngredient("Juice")));
		milk.setTooltip(new Tooltip(RecipeStorage.getIngredient("Milk")));
		mint.setTooltip(new Tooltip(RecipeStorage.getIngredient("Mint")));
		lemon.setTooltip(new Tooltip(RecipeStorage.getIngredient("Lemon")));
		cocoa.setTooltip(new Tooltip(RecipeStorage.getIngredient("Cocoa Paste")));
		caramel.setTooltip(new Tooltip(RecipeStorage.getIngredient("Caramel")));
		soda.setTooltip(new Tooltip(RecipeStorage.getIngredient("Soda")));
		
		orderText.setText(GameLogic.getCustomerOrder());
		startCountdown();
		exit = false;
		StartButton.setDisable(true);
		buttonclick.play();
	}
	public void clear(ActionEvent e) {
		buttonclick.play();
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
		buttonclick.play();
		if(GameLogic.Serve(GameLogic.getGlass(), GameLogic.getPresentcustomer())) {
			orderText.setText(GameLogic.getCustomerOrder());
			clear(e);
		}
	}
	
	public void newGame(ActionEvent e) {
		
		buttonclick.play();
		exit = true;
		timer.setMinute(5);
		timer.setSeconds(0);
		timerText.setText(timer.toString());
		StartButton.setDisable(false);
		this.GAMEEND();
		GameLogic.setZeroScore();
		
	}
	public void showDescription() {
		
	}
	
	public void fillSize(ActionEvent e) {
		buttonclick.play();
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
					pouring.play();
					break;
				case "tea":
					GameLogic.addIngredientToGlass("Tea");
					tea.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					teaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Tea")));
					pouring.play();
					break;
					
				case "juice":
					GameLogic.addIngredientToGlass("Juice");
					juice.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					juiceNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Juice")));
					pouring.play();
					break;
				case "milk":
					GameLogic.addIngredientToGlass("Milk");
					milk.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					milkNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Milk")));
					pouring.play();
					break;
				case "mint":
					GameLogic.addIngredientToGlass("Mint");
					mint.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					mintNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Mint")));
					pick.play();
					break;
				case "lemon":
					GameLogic.addIngredientToGlass("Lemon");
					lemon.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					lemonNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Lemon")));
					pick.play();
					break;
				case "soda":
					GameLogic.addIngredientToGlass("Soda");
					soda.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					sodaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Soda")));
					pouring.play();
					break;
				case "cocoa":
					GameLogic.addIngredientToGlass("Cocoa Paste");
					cocoa.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					cocoaNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Cocoa Paste")));
					pick.play();
					break;
				case "caramel":
					GameLogic.addIngredientToGlass("Caramel");
					caramel.setStyle("-fx-border-color: #00FF00; -fx-border-width:2; -fx-border-radius:5");
					caramelNumberText.setText(String.valueOf(GameLogic.getConcentrationWithId("Caramel")));
					pick.play();
					break;
			}
		}
			
	}
	
	public void GAMEEND() {
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
	
	public void startCountdown(){
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(!exit) {
					try {
						timer.setMinute(5);
						timer.setSeconds(0);
							for(int i=1;i<=300;i++) {
								if(!exit) {
								timer.decrementTimer(1);
								timerText.setText(timer.toString());
								Thread.sleep(1000);
								//System.out.println(timer.toString());
								}
								//System.out.println("ppppppp");
							}
						exit = true;
					} catch(Exception e) {
						
					}
				}
				GAMEEND();
			}
		});
		
		Thread thread2 = new Thread(() ->{
			try {
				thread.join();
				if(Timer.getMinute()<=0 && Timer.getSeconds()<= 0) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							try {
							
								switchToScoreScene(exit);
							}catch(IOException e) {
								e.printStackTrace();
							}
						}
					});
				}
			}catch(Exception e) {
				
			}
		});
		
		thread.start();
		thread2.start();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//System.out.print(easyButton.getScene());
		//coffee.setTooltip(new Tooltip(RecipeStorage.getIngredient("Coffee")));
	}
}

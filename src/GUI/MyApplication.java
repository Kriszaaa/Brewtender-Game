package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
	    try{
	      
	        Parent root=FXMLLoader.load(getClass().getResource("gamePage.fxml"));
	        primaryStage.setTitle("Bartender");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	     }catch(Exception e){
	        e.printStackTrace();
	     }
	}
	public static void main(String [] args){
	    launch(args);
	}

}

package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class MyApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
	    try{
	      
	        Parent root=FXMLLoader.load(getClass().getResource("frontPage.fxml"));
	        primaryStage.setTitle("Bartender");
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        String css = this.getClass().getResource("frontPage.css").toExternalForm();
	        scene.getStylesheets().add(css);
	        
	        primaryStage.show();
	       
	    	
	     }catch(Exception e){
	        e.printStackTrace();
	     }
	}
	public static void main(String [] args){
	    launch(args);
	}

}

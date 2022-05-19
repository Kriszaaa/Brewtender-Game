package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.Mode;

public class frontPageController implements Initializable{

	
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button easyButton,hardButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private AudioClip buttonclick = new AudioClip(ClassLoader.getSystemResource("Buttonclick.wav").toString());
	
	public void switchToScene1(ActionEvent event) throws IOException {
		 
		  buttonclick.play();
		  
		  root = FXMLLoader.load(getClass().getResource("gamePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  String css = this.getClass().getResource("gamePage.css").toExternalForm();
	      scene.getStylesheets().add(css);
		  stage.setScene(scene);
		  stage.show();
		  Button btn = (Button) event.getSource();
		  switch(btn.getId()) {
			case "easyButton":
				GameLogic.chooseMode(Mode.EASY);
				break;
			case "hardButton":
				GameLogic.chooseMode(Mode.HARD);
				break;
		  }
	 }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String image_path = (ClassLoader.getSystemResource("bar.png").toString());
		Image image = new Image(image_path);
		anchorPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                									BackgroundPosition.DEFAULT,new BackgroundSize(1.0, 1.0, true, true, false, false))));

	}

}

package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.Grade;

public class ScoreController implements Initializable{
	
	private Stage stage;
	
	@FXML
	private Button newGameButton,QuitButton;
	
	@FXML
	private ImageView background;
	
	@FXML
	private Text grade,score;
	
	private AudioClip buttonclick = new AudioClip(ClassLoader.getSystemResource("Buttonclick.wav").toString());
	//private Image image;
	
	public void switchToFrontPage(ActionEvent event) throws IOException {
		
			buttonclick.play();
			GameLogic.setZeroScore();
			Parent root = FXMLLoader.load(getClass().getResource("frontPage.fxml"));
	        Scene scene = new Scene(root);
	        String css = this.getClass().getResource("frontPage.css").toExternalForm();
	        scene.getStylesheets().add(css);
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	        stage.setTitle("Bartender");
	        stage.show();
	}
	public void exit() {
		buttonclick.play();
		Platform.exit();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method 
		String image_path = (ClassLoader.getSystemResource("goodjob.jpg").toString());
		Image image = new Image(image_path);
		if(Grade.gradingInt(GameLogic.getScore()) == 2) {
			image_path = (ClassLoader.getSystemResource("noob.jpg").toString());
			image = new Image(image_path);
		}
		grade.setText(Grade.grading(GameLogic.getScore()));
		score.setText(""+GameLogic.getScore());
        background.setImage(image);
		
	}

}


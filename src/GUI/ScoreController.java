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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.GradingScore;

public class ScoreController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button newGameButton,QuitButton;
	
	@FXML
	private ImageView background;
	
	@FXML
	private Text grade,score;
	//private Image image;
	
	public void switchToFrontPage(ActionEvent event) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("frontPage.fxml"));
	        Scene scene = new Scene(root);
			String css = this.getClass().getResource("frontPage.css").toExternalForm();
			scene.getStylesheets().add(css);
			GameLogic.setZeroScore();
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	        stage.show();
	}
	public void exit() {
		Platform.exit();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stu
		Image image = new Image("file:images/goodjob.jpg");
		//System.out.println(GradingScore.GradingInt(GameLogic.getScore()));
		if(GradingScore.GradingInt(GameLogic.getScore()) == 2) {
			image = new Image("file:images/noob.jpg");
		}
		grade.setText(GradingScore.Grading(GameLogic.getScore()));
		score.setText(""+GameLogic.getScore());
        background.setImage(image);
		
	}

}


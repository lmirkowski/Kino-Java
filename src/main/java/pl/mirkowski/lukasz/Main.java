package pl.mirkowski.lukasz;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	
	private static Stage primaryStage;
	
		
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	private static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			setPrimaryStage(primaryStage);
			
			Parent parent = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
			   
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

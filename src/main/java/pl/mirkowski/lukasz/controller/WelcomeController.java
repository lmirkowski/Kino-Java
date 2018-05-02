package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.mirkowski.lukasz.Main;


public class WelcomeController {

	@FXML
	private Button btn_repertIRezerw;

	@FXML
	private Button btn_panelAdm;
	
	@FXML
    void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
    }

	@FXML
	void panelAdmAction(MouseEvent event) throws IOException {

		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);

	}

	@FXML
	void repertuarAction(MouseEvent event) throws IOException {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/view/RepertuarView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
		scene.setFill(Color.TRANSPARENT);

	}

}

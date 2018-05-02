package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.service.LoginService;


public class AdminLoginController {

	@FXML
	private PasswordField pf_admin_pass;

	@FXML
	private TextField tf_admin_usrname;

	@FXML
	private Button btn_admin_login;

	@FXML
	private Button btn_admin_back;
	
	@FXML
    void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
    }

	private LoginService loginService;

	//metoda initialize
	public void initialize() {

		loginService = new LoginService();
	}

	@FXML
	void adminBackAction(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void adminLoginAction(MouseEvent event) throws IOException {
		String login = tf_admin_usrname.getText();
		String password = pf_admin_pass.getText();
		boolean isLogin = loginService.login(login, password);

		if (isLogin) {

			Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminPanelView.fxml"));
			Scene scene = new Scene(parent);
			Main.getPrimaryStage().setScene(scene);
		} else {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Enter valid login or password");
			error.setTitle("Wrong login or password");
			error.show();
		}

	}

}

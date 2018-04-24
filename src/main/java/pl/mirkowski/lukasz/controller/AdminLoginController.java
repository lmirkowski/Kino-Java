package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;

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
    void adminBackAction(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void adminLoginAction(MouseEvent event) {

    }
    
    

}

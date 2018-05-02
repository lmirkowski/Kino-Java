package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;

public class AdminPanelViewController {

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_movies;

    @FXML
    private Button btn_reservation;

    @FXML
    private Button btn_seans;
    
    @FXML
    void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
    }

    @FXML
    void logOutAction(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminView.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void showMoviesAdmin(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminMoviesTable.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);

    }

    @FXML
    void showReservationAdmin(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminReservationTable.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void showSeansAdmin(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminSeansTable.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

}

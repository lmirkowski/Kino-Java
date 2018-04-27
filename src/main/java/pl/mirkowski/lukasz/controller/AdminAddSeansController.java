package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Seans;
import pl.mirkowski.lukasz.service.SeansService;

public class AdminAddSeansController {

	@FXML
	private TextField tf_data;

	@FXML
	private TextField tf_godzina;

	@FXML
	private TextField tf_film;

	@FXML
	private Button btn_dodaj_seans;

	@FXML
	private Button btn_clear;

	@FXML
	private Button btn_back;

	@FXML
	private Button btn_log_out;

	@FXML
	private TextField tf_sala;

	@FXML
	void addSeansToDatabase(MouseEvent event) {
		if (isNotCompleted()) {

			// komunikat dla u¿ytkownika gdy pola s¹ nie wype³nione
			showAlertFormNotCompleted();

		} else {
			SeansService seansService = new SeansService();
			Seans seans = getSeansData();
			seansService.save(seans);
		}
	}

	@FXML
	void back(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminPanelView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void clear(MouseEvent event) {
		tf_data.clear();
		tf_godzina.clear();
		tf_film.clear();
		tf_sala.clear();

	}

	@FXML
	void logOut(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	private Seans getSeansData() {

		String data = tf_data.getText();
		String godzina = tf_godzina.getText();
		int film = Integer.parseInt(tf_film.getText());
		int sala = Integer.parseInt(tf_sala.getText());

		return new Seans(data, godzina, film, sala);
	}

	private boolean isNotCompleted() {
		return "".equals(tf_data.getText()) || "".equals(tf_godzina.getText()) || "".equals(tf_film.getText())
				|| "".equals(tf_sala.getText());
	}

	private void showAlertFormNotCompleted() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Uwaga!!!");
		alert.setContentText("Nale¿y uzupe³niæ wszystkie pola");
		alert.setTitle("Nale¿y uzupe³niæ wszystkie pola");
		alert.show();
	}

}

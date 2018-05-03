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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Client;
import pl.mirkowski.lukasz.service.ClientService;

public class ClientController {

	@FXML
	private ImageView img_close;

	@FXML
	private Button btn_dalej;

	@FXML
	private Button btn_goback;

	@FXML
	private Button btn_clear;

	@FXML
	private TextField tf_name;

	@FXML
	private TextField tf_surname;

	@FXML
	private TextField tf_email;

	@FXML
	private TextField tf_telefon;

	@FXML
	void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
	}

	@FXML
	void clearData(MouseEvent event) {
		tf_name.clear();
		tf_surname.clear();
		tf_email.clear();
		tf_telefon.clear();
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/SeansView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void next(MouseEvent event) {
		if (isNotCompleted()) {

			showAlertFormNotCompleted();

		} else {
			ClientService clientService = new ClientService();
			Client client = getFormData();
			clientService.save(client);
		}

	}

	private Client getFormData() {
		String imie = tf_name.getText();
		String nazwisko = tf_surname.getText();
		String email = tf_email.getText();
		String telefon = tf_telefon.getText();

		return new Client(imie, nazwisko, email, telefon);

	}

	private boolean isNotCompleted() {
		return "".equals(tf_name.getText()) || "".equals(tf_surname.getText()) || "".equals(tf_email.getText())
				|| "".equals(tf_telefon.getText());
	}

	private void showAlertFormNotCompleted() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("B³¹d");
		alert.setContentText("Proszê uzupe³niæ wszyskie pola!");
		alert.setTitle("Nie wype³nione wszystkie pola!");
		alert.show();
	}

}

package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.scene.paint.Color;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Klient;
import pl.mirkowski.lukasz.model.Rezerwacje;
import pl.mirkowski.lukasz.service.KlientService;
import pl.mirkowski.lukasz.service.ReservationService;

public class KlientController {

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
	void next(MouseEvent event) throws IOException {
		if (isNotCompleted()) {

			showAlertFormNotCompleted();

		} else {
			boolean isValidEmail = validateMail();

			if (!isValidEmail) {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("B³êdny adres email!");
				error.setHeaderText("B³¹d");
				error.setContentText(
						"B³êdny adres email: " + tf_email.getText() + "\n" + "Proszê podaæ poprawny adres email.");
				error.show();
				return;
			}
			
			KlientService klientService = new KlientService();
			Klient klient = getFormData();
			klientService.save(klient);

			int id = klient.getId();
			Main.setSelectedKlientId(id);

			ReservationService reservationService = new ReservationService();
			Rezerwacje rezerwacje = getData();
			reservationService.saveToRezerwacje(rezerwacje);
			
			int idrezerwacje = rezerwacje.getIdrezerwacje();
			Main.setSelectedReservationId(idrezerwacje);
			
			Parent parent = FXMLLoader.load(getClass().getResource("/view/SummaryView.fxml"));
			Scene scene = new Scene(parent);
			Main.getPrimaryStage().setScene(scene);
			scene.setFill(Color.TRANSPARENT);
			
		}

	}
	
	private boolean validateMail() {
		String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tf_email.getText());
		boolean isValidEmail = matcher.matches();
		return isValidEmail;
	}

	private Rezerwacje getData() {
		int seans_idseans = Main.getSelectedSeansId();
		int klient_idklient = Main.getSelectedKlientId();
		return new Rezerwacje(seans_idseans, klient_idklient);
	}

	private Klient getFormData() {
		String imie = tf_name.getText();
		String nazwisko = tf_surname.getText();
		String email = tf_email.getText();
		String telefon = tf_telefon.getText();

		return new Klient(imie, nazwisko, email, telefon);

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

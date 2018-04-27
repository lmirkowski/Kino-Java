package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.service.FilmService;


public class AdminAddMovieController {

	@FXML
	private TextField tf_title;

	@FXML
	private TextField tf_rezyser;

	@FXML
	private TextField tf_gatunek;

	@FXML
	private TextField tf_rok;

	@FXML
	private TextField tf_czas;

	@FXML
	private TextField tf_kraj;

	@FXML
	private TextField tf_ogrw;

	@FXML
	private TextArea ta_opis;

	@FXML
	private TextArea ta_obsada;

	@FXML
	private Button btn_dodaj_film;

	@FXML
	private Button btn_clear;

	@FXML
	private Button btn_back;

	@FXML
	private Button btn_log_out;

	@FXML
	void addMovieToDatabase(MouseEvent event) {
		if (isNotCompleted()) {

			// komunikat dla u¿ytkownika gdy pola s¹ nie wype³nione
			showAlertFormNotCompleted();

		} else {
			FilmService filmService = new FilmService();
			Film film = getMovieData();
			filmService.save(film);
		}

	}

	@FXML
	void back(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminMoviesTable.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void clear(MouseEvent event) {
		tf_czas.clear();
		tf_gatunek.clear();
		tf_kraj.clear();
		tf_ogrw.clear();
		tf_rezyser.clear();
		tf_rok.clear();
		tf_title.clear();
		ta_obsada.clear();
		ta_opis.clear();
	}

	@FXML
	void logOut(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminPanelView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	private Film getMovieData() {

		String title = tf_title.getText();
		String rezyser = tf_rezyser.getText();
		int rokProd = Integer.parseInt(tf_rok.getText());
		String czas_trwania = tf_czas.getText();
		String kraj = tf_kraj.getText();
		String obsada = ta_obsada.getText();
		String ogr_wiek = tf_ogrw.getText();
		String gatunek = tf_gatunek.getText();
		String opis = ta_opis.getText();

		return new Film(title, rezyser, rokProd, czas_trwania, kraj, obsada, ogr_wiek, gatunek, opis);
	}
	
	

	private boolean isNotCompleted() {
		return "".equals(tf_title.getText()) || "".equals(tf_rezyser.getText())
				|| "".equals(tf_rok.getText()) || "".equals(tf_czas.getText())
				|| "".equals(tf_ogrw.getText()) || "".equals(tf_gatunek.getText()) || "".equals(ta_opis.getText());

	}

	private void showAlertFormNotCompleted() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Uwaga!!!");
		alert.setContentText("Nale¿y uzupe³niæ wszystkie wymagane pola");
		alert.setTitle("Nale¿y uzupe³niæ wszystkie wymagane pola");
		alert.show();
	}

}

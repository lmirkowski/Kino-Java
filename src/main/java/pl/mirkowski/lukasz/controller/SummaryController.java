package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.mail.MailService;
import pl.mirkowski.lukasz.model.Reservation;
import pl.mirkowski.lukasz.service.ReservationService;

public class SummaryController {

	@FXML
	private ImageView img_close;

	@FXML
	private Button btn_send;

	@FXML
	private Button btn_backtorep;

	@FXML
	private TableView<Reservation> tbl_rezerwacje;

	@FXML
	private TableColumn<Reservation, Integer> col_nr_rezerw;

	@FXML
	private TableColumn<Reservation, String> col_title;

	@FXML
	private TableColumn<Reservation, String> col_data;

	@FXML
	private TableColumn<Reservation, String> col_godzina;

	@FXML
	private TableColumn<Reservation, String> col_sala;

	@FXML
	private TableColumn<Reservation, String> col_imie;

	@FXML
	private TableColumn<Reservation, String> col_nazwisko;

	@FXML
	private TableColumn<Reservation, String> col_email;

	@FXML
	private TableColumn<Reservation, Integer> col_telefon;

	@FXML
	void closeWindow(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	void goBackToRep(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/RepertuarView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void sendEmail(MouseEvent event) {

		MailService mailService = new MailService();

		try {
			mailService.sendMail(col_email.getCellData(0), "Reservation", getFormData());
		} catch (MessagingException e) {
			Alert errorSendMail = new Alert(AlertType.ERROR);
			errorSendMail.setTitle("Nie uda³o siê wys³aæ maila!");
			errorSendMail.setHeaderText("B³¹d");
			errorSendMail.setContentText(e.getMessage());
			errorSendMail.show();
		}

	}

	private ReservationService reservationService;

	private void setCellValue() {
		col_nr_rezerw.setCellValueFactory(new PropertyValueFactory<>("idrezerwacje"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		col_godzina.setCellValueFactory(new PropertyValueFactory<>("godzina"));
		col_sala.setCellValueFactory(new PropertyValueFactory<>("nazwa_sali"));
		col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
		col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		col_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));

	}

	private void loadDataToColumns() {
		reservationService = new ReservationService();

		List<Reservation> reservations = reservationService.getSelected(Main.getSelectedReservationId());

		ObservableList<Reservation> data = FXCollections.observableArrayList(reservations);
		tbl_rezerwacje.setItems(null);
		tbl_rezerwacje.setItems(data);

	}

	public void initialize() {

		loadDataToColumns();
		setCellValue();

	}

	private String getFormData() {

		String imie = col_imie.getCellData(0);
		String nazwisko = col_nazwisko.getCellData(0);
		Integer nrRezerw = col_nr_rezerw.getCellData(0);
		String title = col_title.getCellData(0);
		String sala = col_sala.getCellData(0);

		return "Dziêkujemy za z³o¿enie rezerwacji. Przy zakupie biletu w kasie kina prosimy o powo³anie siê na numer rezerwacji.\n \n"
				+ "\nNumer Twojej rezerwacji: " + nrRezerw + "\nImiê: " + imie + "\nNazwisko: " + nazwisko
				+ "\nTytu³ filmu: " + title + "\nSala: " + sala;
	}

}

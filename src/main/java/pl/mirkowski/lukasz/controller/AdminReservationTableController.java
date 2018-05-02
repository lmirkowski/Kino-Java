package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Reservation;
import pl.mirkowski.lukasz.service.ReservationService;

public class AdminReservationTableController {

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
	private Button btn_usun_rezerwacje;

	@FXML
	private Button btn_back;

	@FXML
	private Button btn_logout;
	
	@FXML
    void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
    }

	@FXML
	void deleteReservation(MouseEvent event) {
		if (Objects.isNull(tbl_rezerwacje.getSelectionModel())
				|| Objects.isNull(tbl_rezerwacje.getSelectionModel().getSelectedItem())) {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Please select Item before clicked Delete");
			error.setTitle("No selected item!");
			error.show();
			return;

		}
		int id = tbl_rezerwacje.getSelectionModel().getSelectedItem().getIdrezerwacje();
		reservationService.delete(id);
		loadDataToColumns();
		// metoda zrefaktoryzowana z metody initialize -- nabicie danymi tabeli
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminPanelView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void logOut(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
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
		List<Reservation> reservations = reservationService.getAll();

		ObservableList<Reservation> data = FXCollections.observableArrayList(reservations);
		tbl_rezerwacje.setItems(null);
		tbl_rezerwacje.setItems(data);

	}

	public void initialize() {

		loadDataToColumns();
		setCellValue();

	}
}

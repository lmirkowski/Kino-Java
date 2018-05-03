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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Seans;
import pl.mirkowski.lukasz.service.SeansService;

public class SeansController {

	@FXML
	private ImageView img_close;

	@FXML
	private Button btn_rezerwacja;

	@FXML
	private Button btn_goback;

	@FXML
	private TableView<Seans> tbl_seans;

	@FXML
	private TableColumn<Seans, String> col_data;

	@FXML
	private TableColumn<Seans, String> col_godzina;

	@FXML
	void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/MovieView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void reservationAction(MouseEvent event) throws IOException {
		if (Objects.isNull(tbl_seans.getSelectionModel())
				|| Objects.isNull(tbl_seans.getSelectionModel().getSelectedItem())) {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("B³¹d");
			error.setContentText("Proszê zaznaczyæ wybrany seans!");
			error.setTitle("Nie wybrano seansu!");
			error.show();
			return;

		}
		int id = tbl_seans.getSelectionModel().getSelectedItem().getIdseans();
		Main.setSelectedSeansId(id);; 			
		Parent parent = FXMLLoader.load(getClass().getResource("/view/ClientView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
		scene.setFill(Color.TRANSPARENT);

	}

	private SeansService seansService;

	private void setCellValue() {
		col_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		col_godzina.setCellValueFactory(new PropertyValueFactory<>("godzina"));
	}

	private void loadDataToColumns() {
		seansService = new SeansService();
		List<Seans> seans = (List<Seans>) seansService.showSeansWhenChosenFilm(Main.getSelectedFilmId());

		ObservableList<Seans> data = FXCollections.observableArrayList(seans);
		tbl_seans.setItems(null);
		tbl_seans.setItems(data);

	}

	public void initialize() {

		loadDataToColumns();
		setCellValue();

	}

}

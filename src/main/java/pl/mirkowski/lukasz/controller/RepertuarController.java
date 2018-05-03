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
import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.service.FilmService;

public class RepertuarController {

	@FXML
	private TableView<Film> tbl_repertuar;

	@FXML
	private TableColumn<Film, String> col_title;

	@FXML
	private TableColumn<Film, String> col_prod;

	@FXML
	private TableColumn<Film, String> col_gatunek;

	@FXML
	private TableColumn<Film, String> col_ogr;

	@FXML
	private ImageView img_close;


	@FXML
	private Button btn_opis_filmu;
	
	@FXML
    private Button btn_rezerwacja;


	@FXML
	private Button btn_goback;

	@FXML
	void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void showMovie(MouseEvent event) throws IOException {
		
		if (Objects.isNull(tbl_repertuar.getSelectionModel())
				|| Objects.isNull(tbl_repertuar.getSelectionModel().getSelectedItem())) {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("B³¹d");
			error.setContentText("Proszê zaznaczyæ wybrany film!");
			error.setTitle("Nie wybrano filmu!");
			error.show();
			return;

		}
		int id = tbl_repertuar.getSelectionModel().getSelectedItem().getIdfilm();
		Main.setSelectedFilmId(id); 			
		Parent parent = FXMLLoader.load(getClass().getResource("/view/MovieView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
		scene.setFill(Color.TRANSPARENT);
	}
	private FilmService filmService;

	private void setCellValue() {
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_prod.setCellValueFactory(new PropertyValueFactory<>("kraj"));
		col_gatunek.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
		col_ogr.setCellValueFactory(new PropertyValueFactory<>("ogr_wiek"));

	}

	private void loadDataToColumns() {
		filmService = new FilmService();
		List<Film> films = filmService.getAll();

		ObservableList<Film> data = FXCollections.observableArrayList(films);
		tbl_repertuar.setItems(null);
		tbl_repertuar.setItems(data);

	}
	
	@FXML
    void reservationAction(MouseEvent event) {

    }

	public void initialize() {

		loadDataToColumns();
		setCellValue();

	}

}

package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.service.FilmService;

public class MovieController {

	@FXML
	private ImageView img_close;

	@FXML
	private TableView<Film> tbl_movies;

	@FXML
	private TableColumn<Film, String> col_title;

	@FXML
	private TableColumn<Film, String> col_rezyser;

	@FXML
	private TableColumn<Film, Integer> col_rok;

	@FXML
	private TableColumn<Film, String> col_czastrw;

	@FXML
	private TableColumn<Film, String> col_prod;

	@FXML
	private TableColumn<Film, String> col_obsada;

	@FXML
	private TableColumn<Film, String> col_ogr;

	@FXML
	private TableColumn<Film, String> col_gatunek;

	@FXML
	private TableColumn<Film, String> col_opis;

	@FXML
	private Button btn_goback;

	@FXML
	private Button btn_rezerwacja;

	@FXML
	void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/RepertuarView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void reservationAction(MouseEvent event) {

	}

	private FilmService filmService;

	private void setCellValue() {
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_rezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
		col_rok.setCellValueFactory(new PropertyValueFactory<>("rok_prod"));
		col_czastrw.setCellValueFactory(new PropertyValueFactory<>("czas_trwania"));
		col_prod.setCellValueFactory(new PropertyValueFactory<>("kraj"));
		col_obsada.setCellValueFactory(new PropertyValueFactory<>("obsada"));
		col_ogr.setCellValueFactory(new PropertyValueFactory<>("ogr_wiek"));
		col_gatunek.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
		col_opis.setCellValueFactory(new PropertyValueFactory<>("opis"));

	}

	private void loadDataToColumns() {
		filmService = new FilmService();
		Film chosenFilm = filmService.selectFilmFromRepertuar(Main.getSelectedFilmId());

		ObservableList<Film> data = FXCollections.observableArrayList(chosenFilm);
		tbl_movies.setItems(null);
		tbl_movies.setItems(data);

	}

	private void setWrapCellFactory(TableColumn<Film, String> tableColumn) {
		tableColumn.setCellFactory(tbl_movies -> {
			TableCell<Film, String> cell = new TableCell<>();
			Text text = new Text();
			cell.setGraphic(text);
			text.wrappingWidthProperty().bind(cell.widthProperty());
			text.textProperty().bind(cell.itemProperty());
			return cell;
		});
	}

	private void setCellWrapable() {
		setWrapCellFactory(col_opis);
		setWrapCellFactory(col_czastrw);
		setWrapCellFactory(col_gatunek);
		setWrapCellFactory(col_obsada);
		setWrapCellFactory(col_ogr);
		setWrapCellFactory(col_prod);
		setWrapCellFactory(col_rezyser);
		setWrapCellFactory(col_title);

	}
		
	public void initialize() {
		
		setCellWrapable();

		loadDataToColumns();
		setCellValue();
		
	}

}

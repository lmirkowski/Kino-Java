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
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;
import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.service.FilmService;

public class AdminMoviesTableController {

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
    private Button btn_dodaj_film;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_usun_film;

    @FXML
    void addMovie(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminAddMovie.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void deleteSelectedMovie(MouseEvent event) {
    	if (Objects.isNull(tbl_movies.getSelectionModel())
				|| Objects.isNull(tbl_movies.getSelectionModel().getSelectedItem())) {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Please select Item before clicked Delete");
			error.setTitle("No selected item!");
			error.show();
			return;

		}
		int id = tbl_movies.getSelectionModel().getSelectedItem().getIdfilm();
		filmService.delete(id);
		loadDataToColumns(); // metoda zrefaktoryzowana z metody initialize -- nabicie danymi tabeli
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
		List<Film> films = filmService.getAll();

		ObservableList<Film> data = FXCollections.observableArrayList(films);
		tbl_movies.setItems(null);
		tbl_movies.setItems(data);
		
    }
    
    public void initialize() {
    	
    	loadDataToColumns();
    	setCellValue();
    	
    }

}

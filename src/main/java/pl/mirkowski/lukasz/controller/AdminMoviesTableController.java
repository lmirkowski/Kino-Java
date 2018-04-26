package pl.mirkowski.lukasz.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

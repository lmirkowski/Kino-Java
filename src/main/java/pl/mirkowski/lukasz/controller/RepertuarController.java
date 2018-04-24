package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private Button btn_back;
    

    @FXML
    private ComboBox<?> cb_choose_day;

    @FXML
    private Button btn_filmlist;

    @FXML
    void backToWelcomeView(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
    	Scene scene = new Scene(parent);
    	Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void showFilmList(MouseEvent event) {

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
    
    public void initialize() {
    	
    	loadDataToColumns();
    	setCellValue();
    	
    }

}

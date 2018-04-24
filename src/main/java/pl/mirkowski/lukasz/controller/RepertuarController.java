package pl.mirkowski.lukasz.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.Main;

public class RepertuarController {

    @FXML
    private TableView<?> tbl_repertuar;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableColumn<?, ?> col_prod;

    @FXML
    private TableColumn<?, ?> col_gatunek;

    @FXML
    private TableColumn<?, ?> col_ogr;

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

}

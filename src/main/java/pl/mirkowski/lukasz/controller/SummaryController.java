package pl.mirkowski.lukasz.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.mirkowski.lukasz.model.Seans;

public class SummaryController {

    @FXML
    private ImageView img_close;

    @FXML
    private Button btn_dalej;

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
System.exit(0);
    }

    @FXML
    void goBack(MouseEvent event) {

    }

    @FXML
    void next(MouseEvent event) {

    }
    
    

}

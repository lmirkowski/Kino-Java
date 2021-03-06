package pl.mirkowski.lukasz.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import pl.mirkowski.lukasz.Main;

import pl.mirkowski.lukasz.model.Seans;

import pl.mirkowski.lukasz.service.SeansService;

public class AdminSeansTableController {

	@FXML
	private TableView<Seans> tbl_seans;

	@FXML
	private TableColumn<Seans, String> col_data;

	@FXML
	private TableColumn<Seans, String> col_godzina;

	@FXML
	private TableColumn<Seans, Integer> col_film;

	@FXML
	private TableColumn<Seans, Integer> col_sala;

	@FXML
	private Button btn_dodaj_seans;

	@FXML
	private Button btn_back;

	@FXML
	private Button btn_logout;

	@FXML
	private Button btn_usun_seans;
	
	@FXML
    void closeWindow(MouseEvent event) {
		Main.getPrimaryStage().close();
    }

	@FXML
	void addSeans(MouseEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminAddSeans.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
	}

	@FXML
	void deleteSelectedSeans(MouseEvent event) {
		if (Objects.isNull(tbl_seans.getSelectionModel())
				|| Objects.isNull(tbl_seans.getSelectionModel().getSelectedItem())) {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Please select Item before clicked Delete");
			error.setTitle("No selectrd item!");
			error.show();
			return;

		}
		int id = tbl_seans.getSelectionModel().getSelectedItem().getIdseans();
		seansService.delete(id);
		loadDataToColumns();
		; // metoda zrefaktoryzowana z metody initialize -- nabicie danymi tabeli
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

	private SeansService seansService;

	private void setCellValue() {
		col_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		col_godzina.setCellValueFactory(new PropertyValueFactory<>("godzina"));
		col_film.setCellValueFactory(new PropertyValueFactory<>("film_idfilm"));
		col_sala.setCellValueFactory(new PropertyValueFactory<>("sala_idsala"));

	}

	private void loadDataToColumns() {
		seansService = new SeansService();
		List<Seans> seans = seansService.getAll();

		ObservableList<Seans> data = FXCollections.observableArrayList(seans);
		tbl_seans.setItems(null);
		tbl_seans.setItems(data);

	}

	public void initialize() {

		loadDataToColumns();
		setCellValue();

		tbl_seans.setEditable(true);
		editCells();

	}

	private void editDateCell() {
		col_data.setCellFactory(TextFieldTableCell.forTableColumn());
		col_data.setOnEditCommit(new EventHandler<CellEditEvent<Seans, String>>() {
			@Override
			public void handle(CellEditEvent<Seans, String> t) {
				((Seans) t.getTableView().getItems().get(t.getTablePosition().getRow())).setData(t.getNewValue());

				Seans selectedItem = tbl_seans.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editHourCell() {
		col_godzina.setCellFactory(TextFieldTableCell.forTableColumn());
		col_godzina.setOnEditCommit(new EventHandler<CellEditEvent<Seans, String>>() {
			@Override
			public void handle(CellEditEvent<Seans, String> t) {
				((Seans) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGodzina(t.getNewValue());

				Seans selectedItem = tbl_seans.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editFilmCell() {
		col_film.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		col_film.setOnEditCommit(new EventHandler<CellEditEvent<Seans, Integer>>() {
			@Override
			public void handle(CellEditEvent<Seans, Integer> t) {
				((Seans) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setFilm_idfilm(t.getNewValue());

				Seans selectedItem = tbl_seans.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editSalaCell() {
		col_sala.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		col_sala.setOnEditCommit(new EventHandler<CellEditEvent<Seans, Integer>>() {
			@Override
			public void handle(CellEditEvent<Seans, Integer> t) {
				((Seans) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setSala_idsala(t.getNewValue());

				Seans selectedItem = tbl_seans.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editCells() {
		editDateCell();
		editHourCell();
		editFilmCell();
		editSalaCell();
	}

	private void updateCell(Seans selectedItem) {
		seansService.update(selectedItem);
	}

}

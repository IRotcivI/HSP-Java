package appli.meditrack;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.Chambre;
import repository.ChambreRepository;

import java.sql.SQLException;

public class TableauChambresController {


    @FXML
    private TableView<Chambre> getChambres;

    @FXML
    private TableColumn<Chambre, Integer> numeroProperty;

    @FXML
    private TableColumn<Chambre, String> typeProperty;

    @FXML
    private TableColumn<Chambre, String> disponibleProperty;

    @FXML
    public void initialize() throws SQLException {
        getChambres();
    }
    @FXML
    public void getChambres() throws SQLException {
        ObservableList<Chambre> chambresList = ChambreRepository.getChambres();


        numeroProperty.setCellValueFactory(cellData -> cellData.getValue().numeroProperty().asObject());
        typeProperty.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        disponibleProperty.setCellValueFactory(cellData -> cellData.getValue().disponibleProperty());


        getChambres.setItems(chambresList);
    }

    private void showInfo(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
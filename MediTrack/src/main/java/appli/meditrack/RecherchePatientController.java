package appli.meditrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.FichePatient;
import repository.RecherchePatientRepository;

import java.sql.SQLException;
import java.util.List;

public class RecherchePatientController {

    @FXML
    private TableColumn<FichePatient, String> columnEmail;

    @FXML
    private TableColumn<FichePatient, String> columnNom;

    @FXML
    private TableColumn<FichePatient, String> columnPrenom;

    @FXML
    private TableColumn<FichePatient, String> columnSecu;

    @FXML
    private Label labelStatus;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FichePatient> tableViewPatients;

    private RecherchePatientRepository rep = new RecherchePatientRepository();

    @FXML
    void rechercherPatient(ActionEvent event) {
        String secu = searchField.getText().trim();

        if (secu.isEmpty()) {
            labelStatus.setText("Veuillez entrer un numéro de sécurité sociale.");
            return;
        }

        try {
            List<FichePatient> patients = rep.recherchePatient(secu);
            if (patients.isEmpty()) {
                labelStatus.setText("Aucun patient trouvé.");
                tableViewPatients.getItems().clear();
            } else {
                columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                columnSecu.setCellValueFactory(new PropertyValueFactory<>("secu"));
                columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                ObservableList<FichePatient> observablePatients = FXCollections.observableArrayList(patients);
                tableViewPatients.setItems(observablePatients);
                labelStatus.setText("");
            }
        } catch (SQLException e) {
            labelStatus.setText("Erreur lors de la recherche.");
            e.printStackTrace();
        }
    }
}

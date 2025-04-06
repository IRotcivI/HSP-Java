package appli.meditrack;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dossier;
import repository.DossierRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionDossiersController {

    @FXML
    private TableView<Dossier> tableViewDossiers;

    @FXML
    private TableColumn<Dossier, String> columnNomPatient;

    @FXML
    private TableColumn<Dossier, String> columnDateArrivee;

    @FXML
    private TableColumn<Dossier, String> columnHeureArrivee;

    @FXML
    private TableColumn<Dossier, String> columnDescription;

    @FXML
    private TableColumn<Dossier, String> columnDecision;

    @FXML
    private Label labelStatus;

    private final ObservableList<Dossier> dossiers = FXCollections.observableArrayList();

    private DossierRepository dossierRepository = new DossierRepository();

    @FXML
    public void initialize() {
        columnNomPatient.setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
        columnDateArrivee.setCellValueFactory(new PropertyValueFactory<>("dateArrivee"));
        columnHeureArrivee.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnDecision.setCellValueFactory(new PropertyValueFactory<>("decision"));

        loadDossiersFromDatabase();
        tableViewDossiers.setItems(dossiers);
    }

    private void loadDossiersFromDatabase() {
        String query = "SELECT d.id_dossier, d.date, d.heureArrive, d.description, d.decision, fp.nom " +
                "FROM dossier d " +
                "JOIN fiche_patient fp ON d.ref_patient = fp.id_patient";

        Database db = new Database();
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idDossier = resultSet.getInt("id_dossier");
                String dateArrivee = resultSet.getString("date");
                String heureArrivee = resultSet.getString("heureArrive");
                String description = resultSet.getString("description");
                String decision = resultSet.getString("decision");
                String nomPatient = resultSet.getString("nom");

                Dossier dossier = new Dossier(idDossier, dateArrivee, heureArrivee, description, decision, nomPatient);
                dossiers.add(dossier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            labelStatus.setText("Erreur lors du chargement des dossiers.");
        }
    }


    @FXML
    public void consulterDossier() {
        Dossier selectedDossier = tableViewDossiers.getSelectionModel().getSelectedItem();
        if (selectedDossier != null) {
            labelStatus.setText("Consultation du dossier de : " + selectedDossier.getNomPatient());
        } else {
            labelStatus.setText("Aucun dossier sélectionné.");
        }
    }

    @FXML
    public void supprimerDossier() throws SQLException {
        Dossier selectedDossier = tableViewDossiers.getSelectionModel().getSelectedItem();
        if (selectedDossier != null) {
            int idDossier = Integer.parseInt(selectedDossier.getDossierId());
            dossierRepository.supprimerDossier(idDossier);
            dossiers.remove(selectedDossier);
            labelStatus.setText("Dossier supprimé");
        } else {
            labelStatus.setText("Aucun dossier sélectionné.");
        }
    }


    @FXML
    public void marquerTraite() throws SQLException {
        Dossier selectedDossier = tableViewDossiers.getSelectionModel().getSelectedItem();
        if (selectedDossier != null) {
            int idDossier = Integer.parseInt(selectedDossier.getDossierId());
            dossierRepository.marquerDossier(idDossier);
            labelStatus.setText("Dossier marqué comme LU.");
        } else {
            labelStatus.setText("Aucun dossier sélectionné.");
        }
    }
}

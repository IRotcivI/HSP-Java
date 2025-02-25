package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ApresConnexionController {

    @FXML
    private StackPane contenuDynamique;

    @FXML
    void deconnexion(ActionEvent event) {

    }

    @FXML
    void ouvrirAPropos(ActionEvent event) {

    }

    @FXML
    void ouvrirCreationPatient(ActionEvent event) throws IOException {
        Parent fiche_patient = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesPatients/FichePatient.fxml"));
        Scene scene = new Scene(fiche_patient);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirDemandes(ActionEvent event) {

    }

    @FXML
    void ouvrirGestionDossiers(ActionEvent event) {

    }

    @FXML
    void ouvrirGestionProduits(ActionEvent event) {

    }

    @FXML
    void ouvrirLiberationChambre(ActionEvent event) {

    }

    @FXML
    void ouvrirListeHospitalisations(ActionEvent event) {

    }

    @FXML
    void ouvrirListeProduits(ActionEvent event) {

    }

    @FXML
    void ouvrirManuel(ActionEvent event) {

    }

    @FXML
    void ouvrirReapprovisionnement(ActionEvent event) {

    }

    @FXML
    void ouvrirRecherchePatient(ActionEvent event) throws IOException {
        Parent recherche_patient = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesPatients/RecherchePatients.fxml"));
        Scene scene = new Scene(recherche_patient);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ouvrirCreationDossier() throws IOException {
        Parent creer_dossier = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesPatients/creerUnDossier.fxml"));
        Scene scene = new Scene(creer_dossier);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void quitter(ActionEvent event) {

    }

}

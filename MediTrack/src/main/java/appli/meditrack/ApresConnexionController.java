package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ApresConnexionController {

    @FXML
    private StackPane contenuDynamique;

    @FXML
    void deconnexion(ActionEvent event) throws IOException {
        // Charger la nouvelle page
        Parent deco = FXMLLoader.load(getClass().getResource("/Fxml/ConnexionPage.fxml"));
        Scene scene = new Scene(deco);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        currentStage.close();
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
    void ouvrirFormulaireAjoutUtilisateur(ActionEvent event) throws IOException {
        Parent fiche_patient = FXMLLoader.load(getClass().getResource("/Fxml/InscriptionPage.fxml"));
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
    void ouvrirGestionDossiers(ActionEvent event) throws IOException {
        Parent gestion_dossier = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesPatients/GererLesDossiers.fxml"));
        Scene scene = new Scene(gestion_dossier);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirGestionStock(ActionEvent event) throws IOException {
        Parent gestion_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesStocks/GestionStock.fxml"));
        Scene scene = new Scene(gestion_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirListeStock(ActionEvent event) throws IOException {
        Parent gestion_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesStocks/ProduitsFournisseurs.fxml"));
        Scene scene = new Scene(gestion_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirLiberationChambre(ActionEvent event) throws IOException {
        Parent liberer_chambre = FXMLLoader.load(getClass().getResource("/Fxml/Hospitalisation/Chambre.fxml"));
        Scene scene = new Scene(liberer_chambre);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirListeHospitalisations(ActionEvent event) throws IOException {
        Parent ajouter_chambre = FXMLLoader.load(getClass().getResource("/Fxml/Hospitalisation/GestionChambre.fxml"));
        Scene scene = new Scene(ajouter_chambre);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirListeProduits(ActionEvent event) throws IOException {
        Parent liste_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesStocks/ListeProduits.fxml"));
        Scene scene = new Scene(liste_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirListeUtilisateur(ActionEvent event) throws IOException {
        Parent liste_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesUtilisateurs/ListeUtilisateurs.fxml"));
        Scene scene = new Scene(liste_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
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
        System.exit(0);
    }

}

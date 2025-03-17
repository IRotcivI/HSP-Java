package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Produit;
import repository.FournisseurRepository;
import model.Fournisseur;
import repository.ProduitRepository;

import java.io.IOException;

public class GestionFournisseurController {

    @FXML
    private TextField nom;
    @FXML
    private TextField voie;
    @FXML
    private TextField rue;
    @FXML
    private TextField ville;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;

    @FXML
    private Label labelErreur;
    @FXML
    private Label labelReussi;
    @FXML
    private Button btnAjouter;

    private final FournisseurRepository fournisseurRepository = new FournisseurRepository();

    @FXML
    void ouvrirAjouterFournisseur(ActionEvent event) throws IOException {
        Parent gestion_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesStocks/CreationFournisseur.fxml"));
        Scene scene = new Scene(gestion_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ajouterFournisseur() {
        // Récupération des valeurs des champs
        String nomValue = nom.getText();
        String voieValue = voie.getText();
        String rueValue = rue.getText();
        String villeValue = ville.getText();
        String telephoneValue = telephone.getText();
        String emailValue = email.getText();

        // Vérification des champs vides
        if (nomValue.isEmpty() || voieValue.isEmpty() || rueValue.isEmpty() || villeValue.isEmpty() || telephoneValue.isEmpty() || emailValue.isEmpty()) {
            labelErreur.setText("Tous les champs doivent être remplis.");
            return;
        }

        // Vérification du format de l'email
        if (!emailValue.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            labelErreur.setText("Veuillez entrer une adresse email valide.");
            return;
        }

        // Vérification du format du numéro de téléphone
        if (!telephoneValue.matches("^\\d{10}$")) {
            labelErreur.setText("Le numéro de téléphone doit contenir 10 chiffres.");
            return;
        }

        // Création de l'objet Fournisseur
        Fournisseur fournisseur = new Fournisseur(nomValue, voieValue, rueValue, villeValue, telephoneValue, emailValue);

        // Enregistrement dans la base via le repository
        boolean status = fournisseurRepository.ajouterFournisseur(fournisseur);

        if (status) {
            labelReussi.setText("Fournisseur ajouté avec succès, vous pouvez ajouter un autre fournisseur ou fermer cette page.");
            labelErreur.setText("");  // Effacer le message d'erreur si l'ajout réussit

            // Réinitialisation des champs
            nom.clear();
            voie.clear();
            rue.clear();
            ville.clear();
            telephone.clear();
            email.clear();
        } else {
            labelErreur.setText("Erreur lors de l'ajout du fournisseur.");
        }

    }

}

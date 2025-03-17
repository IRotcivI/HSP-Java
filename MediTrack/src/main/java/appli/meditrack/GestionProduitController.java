package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Produit;
import repository.ProduitRepository;

import java.io.IOException;

public class GestionProduitController {

    @FXML
    private TextField libelle;

    @FXML
    private TextField description;

    @FXML
    private ChoiceBox<String> niveauDangerosite;

    @FXML
    private Label messageLabel;  // Label pour afficher les messages

    @FXML
    void ouvrirAjouterProduit(ActionEvent event) throws IOException {
        Parent gestion_produit = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesStocks/CreationProduits.fxml"));
        Scene scene = new Scene(gestion_produit);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void creationProduit(ActionEvent event) {
        try {
            // Récupérer les valeurs du formulaire
            String libelleProduit = libelle.getText();
            String descriptionProduit = description.getText();
            String niveauDanger = niveauDangerosite.getValue();

            // Vérifier que tous les champs sont remplis
            if (libelleProduit.isEmpty() || descriptionProduit.isEmpty() || niveauDanger == null) {
                messageLabel.setText("Veuillez remplir tous les champs !");
                messageLabel.setStyle("-fx-text-fill: purple;");
                return;
            }

            // Créer un objet Produit
            Produit produit = new Produit(libelleProduit, descriptionProduit, niveauDanger);

            // Ajouter le produit à la base de données
            ProduitRepository.ajouterProduit(produit);

            // Afficher un message de succès
            messageLabel.setText("Produit ajouté avec succès, vous pouvez ajouter d'autres produits ou quitter cette page.");
            messageLabel.setStyle("-fx-text-fill: green;");
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("Erreur lors de l'ajout du produit.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}

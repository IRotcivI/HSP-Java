package appli.meditrack;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Produit;
import repository.ProduitRepository;

public class AjoutProduitController {

    @FXML private TextField libelle;
    @FXML private TextField description;
    @FXML private ChoiceBox<String> niveauDangerosite;
    @FXML private Label messageLabel;
    @FXML private Button annulerProduitButton;

    private final ProduitRepository produitRepository = new ProduitRepository();

    @FXML
    private void initialize() {
        niveauDangerosite.setItems(FXCollections.observableArrayList(
                "1 (faible)", "2 (moyen)", "3 (élevé)", "4 (très élevé)"
        ));
    }

    @FXML
    void creationProduit(ActionEvent event) {
        String libelleProduit = libelle.getText();
        String descriptionProduit = description.getText();
        String niveauDanger = niveauDangerosite.getValue();

        if (libelleProduit.isEmpty() || descriptionProduit.isEmpty() || niveauDanger == null) {
            messageLabel.setText("Veuillez remplir tous les champs !");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        Produit produit = new Produit(libelleProduit, descriptionProduit, niveauDanger);
        produitRepository.ajouterProduit(produit);

        messageLabel.setText("Produit ajouté avec succès !");
        messageLabel.setStyle("-fx-text-fill: green;");

        fermerFenetre(event);
    }

    @FXML
    void fermerFenetre(ActionEvent event) {
        ((Stage) annulerProduitButton.getScene().getWindow()).close();
    }
}

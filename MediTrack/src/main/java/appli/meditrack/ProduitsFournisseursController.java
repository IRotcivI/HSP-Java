package appli.meditrack;

import com.mysql.cj.protocol.Message;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Commande;
import model.Produit;
import model.ProduitFournisseur;
import repository.CommandeRepository;
import repository.ProduitFournisseurRepository;

import javax.swing.*;
import java.util.List;

public class ProduitsFournisseursController {

    @FXML
    private TableView<ProduitFournisseur> tableAssociations;
    @FXML
    private TableColumn<ProduitFournisseur, String> colProduitLibelle;
    @FXML
    private TableColumn<ProduitFournisseur, String> colFournisseurNom;
    @FXML
    private TableColumn<ProduitFournisseur, Double> colPrix;

    public Button boutonCommander;

    @FXML private TextField champQuantite;

    @FXML private Label Message;

    private final ProduitFournisseurRepository produitFournisseurRepository = new ProduitFournisseurRepository();
    private final CommandeRepository commandeRepository = new CommandeRepository();


    @FXML
    private void initialize() {
        loadAssociations();
        setupTableAssociations();

    }

    private void setupTableAssociations() {
        // Lier les cellules de la table aux propriétés de ProduitFournisseur
        colProduitLibelle.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLibelle()));

        colFournisseurNom.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNom()));

        colPrix.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrix()).asObject());
    }


    private void loadAssociations() {
        // Récupérer les associations depuis le repository
        List<ProduitFournisseur> associations = produitFournisseurRepository.getProduitFournisseurs();
        // Charger les associations dans la TableView
        ObservableList<ProduitFournisseur> observableAssociations = FXCollections.observableArrayList(associations);
        tableAssociations.setItems(observableAssociations);
    }


    @FXML
    private void commanderProduit() {
        ProduitFournisseur produitFournisseur = tableAssociations.getSelectionModel().getSelectedItem();

        if (produitFournisseur == null) {
            Message.setText("Veuillez sélectionner un produit.");
            Message.setStyle(Message.getStyle() + " -fx-text-fill: red;");
            return;
        }

        int quantite;
        try {
            quantite = Integer.parseInt(champQuantite.getText());
            if (quantite <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            Message.setText("Veuillez entrer une quantité valide.");
            Message.setStyle(Message.getStyle() + " -fx-text-fill: red;");
            return;
        }

        Commande commande = new Commande(
                produitFournisseur.getIdProduit(),
                produitFournisseur.getIdFournisseur(),
                quantite,
                produitFournisseur.getPrix()
        );

        CommandeRepository repo = new CommandeRepository();
        boolean success = repo.enregistrerCommande(commande);

        if (success) {
            Message.setText("Commande enregistrée avec succès !");
            Message.setStyle(Message.getStyle() + " -fx-text-fill: green;");
        } else {
            Message.setText("Erreur lors de l'enregistrement de la commande.");
            Message.setStyle(Message.getStyle() + " -fx-text-fill: red;");
        }
    }




}

package appli.meditrack;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.ProduitFournisseur;
import repository.ProduitFournisseurRepository;

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

    private final ProduitFournisseurRepository produitFournisseurRepository = new ProduitFournisseurRepository();

    @FXML
    private void initialize() {
        setupTableAssociations();
        loadAssociations();
    }

    private void setupTableAssociations() {
        // Lier les cellules de la table aux propriétés des objets ProduitFournisseur
        colProduitLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelle()));
        colFournisseurNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        colPrix.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrix()).asObject());
    }

    private void loadAssociations() {
        // Récupérer les associations depuis le repository
        List<ProduitFournisseur> associations = produitFournisseurRepository.getProduitFournisseurs();
        // Charger les associations dans la TableView
        ObservableList<ProduitFournisseur> observableAssociations = FXCollections.observableArrayList(associations);
        tableAssociations.setItems(observableAssociations);
    }
}

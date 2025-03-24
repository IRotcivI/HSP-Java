package appli.meditrack;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
        colProduitLibelle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduit().getLibelle()));
        colFournisseurNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFournisseur().getNom()));
        colPrix.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrix()).asObject());
    }

    private void loadAssociations() {
        List<ProduitFournisseur> associations = produitFournisseurRepository.getProduitFournisseurs();
        tableAssociations.setItems(FXCollections.observableArrayList(associations));
    }

}

package appli.meditrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Fournisseur;
import model.Produit;
import repository.FournisseurRepository;
import repository.ProduitRepository;
import java.io.IOException;
import java.util.List;

public class GestionStockController {

    private final FournisseurRepository fournisseurRepository = new FournisseurRepository();
    private final ProduitRepository produitRepository = new ProduitRepository();

    // Tableaux pour afficher les produits et fournisseurs
    @FXML private TableView<Produit> tableProduits;
    @FXML private TableColumn<Produit, String> colLibelle;
    @FXML private TableColumn<Produit, String> colDescription;
    @FXML private TableColumn<Produit, String> colNiveauDangerosite;

    @FXML private TableView<Fournisseur> tableFournisseurs;
    @FXML private TableColumn<Fournisseur, Integer> colId;
    @FXML private TableColumn<Fournisseur, String> colNom;

    /**
     * Initialise les données des tables
     */
    @FXML
    private void initialize() {
        setupTableProduits();
        setupTableFournisseurs();
        loadProduits();
        loadFournisseurs();
    }

    private void setupTableProduits() {
        colLibelle.setCellValueFactory(cellData -> cellData.getValue().libelleProperty());
        colDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        colNiveauDangerosite.setCellValueFactory(cellData -> cellData.getValue().niveauDangerositeProperty());
    }

    private void setupTableFournisseurs() {
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
    }

    private void loadProduits() {
        List<Produit> produits = produitRepository.getProduits();
        tableProduits.setItems(FXCollections.observableArrayList(produits));
    }

    private void loadFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.getFournisseurs();
        tableFournisseurs.setItems(FXCollections.observableArrayList(fournisseurs));
    }

    /**
     * Ouvre la fenêtre d'ajout de produit
     */
    @FXML
    void ouvrirAjouterProduit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/gestionDesStocks/AjoutProduits.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Ajouter un Produit");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Ouvre la fenêtre d'ajout de fournisseur
     */
    @FXML
    void ouvrirAjouterFournisseur() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/gestionDesStocks/AjoutFournisseur.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Ajouter un Fournisseur");
        stage.setScene(new Scene(root));
        stage.show();
    }
}

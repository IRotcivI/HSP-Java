package appli.meditrack;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produit;
import repository.FournisseurRepository;
import repository.ProduitRepository;

import java.sql.*;
import java.util.List;


public class ListeProduitsController {

    private final ProduitRepository produitRepository = new ProduitRepository();

    // Tableaux pour afficher les produits et fournisseurs
    @FXML private TableView<Produit> tableProduits;
    @FXML private TableColumn<Produit, String> colLibelle;
    @FXML private TableColumn<Produit, String> colDescription;
    @FXML private TableColumn<Produit, String> colNiveauDangerosite;

    private ObservableList<Produit> produitsList = FXCollections.observableArrayList();

    private final ProduitRepository repository = new ProduitRepository();

    @FXML
    public void initialize() throws SQLException {
        setupTableProduits();
        loadProduits();
    }
    private void setupTableProduits() {
        colLibelle.setCellValueFactory(cellData -> cellData.getValue().libelleProperty());
        colDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        colNiveauDangerosite.setCellValueFactory(cellData -> cellData.getValue().niveauDangerositeProperty());
    }

    private void loadProduits() {
        List<Produit> produits = produitRepository.getProduits();
        tableProduits.setItems(FXCollections.observableArrayList(produits));
    }
}


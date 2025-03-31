package appli.meditrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Fournisseur;
import model.Produit;
import repository.FournisseurRepository;
import repository.ProduitRepository;

import java.sql.SQLException;
import java.util.List;

public class GererDemandeController {

    private final FournisseurRepository fournisseurRepository = new FournisseurRepository();
    private final ProduitRepository produitRepository = new ProduitRepository();

    // Tableaux pour afficher les produits et fournisseurs
    @FXML private TableView<Produit> tableProduits;
    @FXML private TableColumn<Produit, String> colLibelle;
    @FXML private TableColumn<Produit, String> colDescription;
    @FXML private TableColumn<Produit, String> colNiveauDangerosite;

    @FXML private TableView<Fournisseur> tableFournisseurs;
    @FXML private TableColumn<Fournisseur, String> colNom;
    @FXML private TableColumn<Fournisseur, String> colVoie;
    @FXML private TableColumn<Fournisseur, String> colRue;
    @FXML private TableColumn<Fournisseur, String> colVille;
    @FXML private TableColumn<Fournisseur, String> colTelephone;
    @FXML private TableColumn<Fournisseur, String> colEmail;

    private ObservableList<Produit> produitsList = FXCollections.observableArrayList();
    private final ProduitRepository repository = new ProduitRepository();

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
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colTelephone.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
    }

    private void loadProduits() {
        List<Produit> produits = produitRepository.getProduits();
        tableProduits.setItems(FXCollections.observableArrayList(produits));
    }

    private void loadFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.getFournisseurs();
        tableFournisseurs.setItems(FXCollections.observableArrayList(fournisseurs));
    }



}


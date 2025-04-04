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
import model.ProduitFournisseur;
import repository.FournisseurRepository;
import repository.ProduitRepository;
import repository.ProduitFournisseurRepository;

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
    @FXML private TableColumn<Fournisseur, String> colNom;
    @FXML private TableColumn<Fournisseur, String> colVoie;
    @FXML private TableColumn<Fournisseur, String> colRue;
    @FXML private TableColumn<Fournisseur, String> colVille;
    @FXML private TableColumn<Fournisseur, String> colTelephone;
    @FXML private TableColumn<Fournisseur, String> colEmail;


    @FXML private TextField prixTextField;
    @FXML private Button AssocierButton;
    public Button ajouterFournisseurButton;
    @FXML private Label messageLabel;

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
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colVoie.setCellValueFactory(cellData -> cellData.getValue().voieProperty());
        colRue.setCellValueFactory(cellData -> cellData.getValue().rueProperty());
        colVille.setCellValueFactory(cellData -> cellData.getValue().villeProperty());
        colTelephone.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
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


    private final ProduitFournisseurRepository produitFournisseurRepository = new ProduitFournisseurRepository();

    @FXML
    private void associerProduitFournisseur() {
        // Récupération du produit et du fournisseur sélectionnés
        Produit produitSelectionne = tableProduits.getSelectionModel().getSelectedItem();
        Fournisseur fournisseurSelectionne = tableFournisseurs.getSelectionModel().getSelectedItem();

        if (produitSelectionne == null || fournisseurSelectionne == null) {
            messageLabel.setText("Veuillez selectionner un produit et un fournisseur !");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Récupération du prix saisi
        String prixTexte = prixTextField.getText();
        double prix;

        try {
            prix = Double.parseDouble(prixTexte);
        } catch (NumberFormatException e) {
            messageLabel.setText("Veuillez entrer un prix valide !");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Création de l'objet ProduitFournisseur et insertion dans la base
        ProduitFournisseur produitFournisseur = new ProduitFournisseur(
                produitSelectionne.getId(),
                fournisseurSelectionne.getId(),
                produitSelectionne.getLibelle(),
                fournisseurSelectionne.getNom(),
                prix
        );

        boolean success = produitFournisseurRepository.ajouterProduitFournisseur(produitFournisseur);

        if (success) {
            messageLabel.setText("Associer avec succes !");
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            messageLabel.setText("Erreur lors de l'association, veuillez contatcter le support.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

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

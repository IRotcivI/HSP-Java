package appli.meditrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Fournisseur;
import repository.FournisseurRepository;

import java.sql.*;
import java.util.List;


public class ListeFournisseursController {

    private final FournisseurRepository FournisseurRepository = new FournisseurRepository();

    @FXML private TableView<Fournisseur> tableFournisseurs;
    @FXML private TableColumn<Fournisseur, String> colNom;
    @FXML private TableColumn<Fournisseur, String> colVoie;
    @FXML private TableColumn<Fournisseur, String> colRue;
    @FXML private TableColumn<Fournisseur, String> colVille;
    @FXML private TableColumn<Fournisseur, String> colTelephone;
    @FXML private TableColumn<Fournisseur, String> colEmail;

    private ObservableList<Fournisseur> fournisseursList = FXCollections.observableArrayList();

    private final FournisseurRepository repository = new FournisseurRepository();

    @FXML
    public void initialize() throws SQLException {
        setupTableFournisseurs();
        loadFournisseurs();
    }
    private void setupTableFournisseurs() {
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colVoie.setCellValueFactory(cellData -> cellData.getValue().voieProperty());
        colRue.setCellValueFactory(cellData -> cellData.getValue().rueProperty());
        colVille.setCellValueFactory(cellData -> cellData.getValue().villeProperty());
        colTelephone.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    }

    private void loadFournisseurs() {
        List<Fournisseur> fournisseurs = FournisseurRepository.getFournisseurs();
        tableFournisseurs.setItems(FXCollections.observableArrayList(fournisseurs));
    }
}


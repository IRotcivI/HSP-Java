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

import java.sql.*;

public class ListeProduitsController {

    @FXML
    private TableColumn<Produit, Integer> colDescription;

    @FXML
    private TableColumn<Produit, Integer> colLibelle;

    @FXML
    private TableColumn<Produit, Integer> colNiveauDangerosite;

    @FXML
    private TableView<Produit> tableProduits;

    private ObservableList<Produit> produitsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        // Associer les colonnes aux propriétés de la classe Produit
        colLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colNiveauDangerosite.setCellValueFactory(new PropertyValueFactory<>("niveauDangerosite"));

        // Charger les données de la base de données
        chargerDonneesDepuisBD();
    }

    private void chargerDonneesDepuisBD() throws SQLException {
        Database database = new Database();
        Connection connection = database.getConnection();

        String requete = "SELECT libelle, description, niveauDangerosite FROM produit";
        PreparedStatement requeteStatement = connection.prepareStatement(requete);
        ResultSet resultSet = requeteStatement.executeQuery();

        while (resultSet.next()) {
            produitsList.add(new Produit(
                    resultSet.getString("libelle"),
                    resultSet.getString("description"),
                    resultSet.getInt("niveauDangerosite")
            ));
        }

        tableProduits.setItems(produitsList);
    }
}


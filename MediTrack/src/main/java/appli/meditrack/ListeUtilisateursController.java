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
import model.Utilisateur;

import java.sql.*;

public class ListeUtilisateursController {

    @FXML
    private TableColumn<Utilisateur, Integer> colNom;

    @FXML
    private TableColumn<Utilisateur, Integer> colPrenom;

    @FXML
    private TableColumn<Utilisateur, Integer> colEmail;

    @FXML
    private TableView<Utilisateur> tableUtilisateur;

    private ObservableList<Utilisateur> utilisateurList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        // Associer les colonnes aux propriétés de la classe Produit
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Charger les données de la base de données
        chargerDonneesDepuisBD();
    }

    private void chargerDonneesDepuisBD() throws SQLException {
        Database database = new Database();
        Connection connection = database.getConnection();

        String requete = "SELECT nom, prenom, email FROM utilisateur";
        PreparedStatement requeteStatement = connection.prepareStatement(requete);
        ResultSet resultSet = requeteStatement.executeQuery();

        while (resultSet.next()) {
            utilisateurList.add(new Utilisateur(
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("email"),
                    "",
                    ""
            ));
        }

        tableUtilisateur.setItems(utilisateurList);
    }
}
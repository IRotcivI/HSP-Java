package appli.meditrack;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListeTestController {

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button AjoutUser;

    @FXML
    private TableColumn<?, ?> id_utilisateur;

    @FXML
    private TableColumn<?, ?> nom_utilisateur;

    @FXML
    private TableColumn<?, ?> prenom_utilisateur;

    @FXML
    private TableView<Utilisateur> tableUser;

    private final ObservableList<Utilisateur> dossiers = FXCollections.observableArrayList();

    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    public void initialize() {
        id_utilisateur.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom_utilisateur.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom_utilisateur.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        afficherUtilisateur();
        tableUser.setItems(dossiers);
    }

    private void afficherUtilisateur() {
        String sql = "select * from utilisateur";

        Database db = new Database();
        try (Connection conn = db.getConnection();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_utilisateur");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");

                Utilisateur util = new Utilisateur(id, nom, prenom);
                dossiers.add(util);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void AjouterUtilisateur(ActionEvent event) {
       String firstName = prenom.getText();
       String lastName = nom.getText();
       String mail = email.getText();
       String password = mdp.getText();

        Utilisateur utilisateur = new Utilisateur(firstName, lastName, mail, password,"1");

        try {
            boolean inscrit = utilisateurRepository.ajouterUtilisateur(utilisateur);
            if (inscrit) {
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
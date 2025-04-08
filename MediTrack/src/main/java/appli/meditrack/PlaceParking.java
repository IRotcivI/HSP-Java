package appli.meditrack;

import com.mysql.cj.Session;
import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Parking;
import model.Utilisateur;
import repository.ParkingRepository;
import repository.UtilisateurRepository;
import session.SessionManager;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceParking {

    @FXML
    private TableColumn<?, ?> ColoneAllee;

    @FXML
    private TableColumn<?, ?> ColoneEmailUser;

    @FXML
    private TableColumn<?, ?> ColoneNom;

    @FXML
    private TableColumn<?, ?> ColoneNomUser;

    @FXML
    private TableColumn<?, ?> ColonePrenomUser;

    @FXML
    private TableView<Utilisateur> Membre;

    @FXML
    private TableView<Parking> Place;

    @FXML
    private Button attribuerButton;

    @FXML
    private Button createButton;

    private final ParkingRepository parkingRepository = new ParkingRepository();
    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
    private final ObservableList<Parking> placesParking = FXCollections.observableArrayList();
    private final ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList();


    public void initialize() throws SQLException {
        ColoneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColoneAllee.setCellValueFactory(new PropertyValueFactory<>("allee"));
        ColoneNomUser.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColonePrenomUser.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColoneEmailUser.setCellValueFactory(new PropertyValueFactory<>("email"));

        afficherMembrePlace();
        Place.setItems(placesParking);
        Membre.setItems(utilisateurs);
    }

    private void afficherMembrePlace() throws SQLException {
        String sqlUser = "SELECT u.* " +
                "FROM utilisateur AS u " +
                "LEFT JOIN parking ON u.id_utilisateur = parking.ref_utilisateur " +
                "WHERE parking.ref_utilisateur IS NULL;";

        String sqlPlace = "SELECT * FROM parking WHERE ref_utilisateur IS NULL";

        Database db = new Database();
        try (Connection conn = db.getConnection()) {
            PreparedStatement userStmt = conn.prepareStatement(sqlUser);
            ResultSet utilisateurRS = userStmt.executeQuery();

            PreparedStatement placeStmt = conn.prepareStatement(sqlPlace);
            ResultSet placesRS = placeStmt.executeQuery();

            while (utilisateurRS.next()) {
                int id = utilisateurRS.getInt("id_utilisateur");
                String nom = utilisateurRS.getString("nom");
                String prenom = utilisateurRS.getString("prenom");
                String email = utilisateurRS.getString("email");

                Utilisateur util = new Utilisateur(nom, prenom, email);
                utilisateurs.add(util);
            }

            while (placesRS.next()) {
                int idParking = placesRS.getInt("id_parking");
                String nom_parking = placesRS.getString("nom");
                String allee = placesRS.getString("allee");

                Parking parking = new Parking(idParking, nom_parking, allee);
                placesParking.add(parking);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Affiche l'erreur pour le débogage
            // Vous pouvez également journaliser l'erreur ou la gérer différemment
        }
    }


    @FXML
    void creerUnePlace(ActionEvent event) throws IOException {
        Parent creer_dossier = FXMLLoader.load(getClass().getResource("/Fxml/gestionDesPlaces/CreerUnePlace.fxml"));
        Scene scene = new Scene(creer_dossier);
        Stage stage = new Stage();
        stage.setTitle("MediTrack");
        stage.setScene(scene);
        stage.show();
    }

    public void lierLesDeux(ActionEvent actionEvent) throws SQLException {
        Parking selectedParking = Place.getSelectionModel().getSelectedItem();
        Utilisateur selectedUtilisateur = Membre.getSelectionModel().getSelectedItem();
        if (selectedParking != null){
            int idParking = selectedParking.getId_parking();
            int idUtilisateur = SessionManager.getId();

            parkingRepository.lierParking(idParking,idUtilisateur);
            placesParking.remove(selectedParking);
            utilisateurs.remove(selectedUtilisateur);
        } else {

        }
    }
}

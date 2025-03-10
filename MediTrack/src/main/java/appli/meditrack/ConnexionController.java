package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;

public class ConnexionController {

    @FXML
    private Button btnValider;

    @FXML
    private Button btnInscription;

    @FXML
    private TextField utilisateurId;

    @FXML
    private TextField utilisateurMdp;

    @FXML
    private Label mauvaisMdp;

    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    public void connexionApp(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        valider(stage);
    }

    private void valider(Stage stage) throws SQLException, IOException {
        String email = utilisateurId.getText();
        String mdp = utilisateurMdp.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            mauvaisMdp.setText("Veuillez remplir tous les champs.");
            return;
        }

        Utilisateur utilisateur = new Utilisateur("", "", email, mdp, "");
        boolean connexionReussie = utilisateurRepository.connexionUtilisateur(utilisateur);

        if (connexionReussie) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/ApresConnexion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            mauvaisMdp.setText("Identifiants incorrects.");
        }

    }

}

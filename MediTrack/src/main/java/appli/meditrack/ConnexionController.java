package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;

public class ConnexionController {

    @FXML
    private Button btnValider;

    @FXML
    private TextArea utilisateurId;

    @FXML
    private TextArea utilisateurMdp;

    @FXML
    private Label mauvaisMdp;

    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    public void connexionApp(ActionEvent event) throws IOException, SQLException {
        valider();
    }

    private void valider() throws SQLException {

        String prenom = "";
        String nom = "";
        String role = "";
        String email = utilisateurId.getText();
        String mdp = utilisateurMdp.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            mauvaisMdp.setText("Veuillez remplir tous les champs.");
            return;
        }

        Utilisateur utilisateur = new Utilisateur(nom,prenom,email, mdp,role);

        boolean connexionReussie = utilisateurRepository.connexionUtilisateur(utilisateur);

        if (connexionReussie) {
            // Rediriger vers la page principale ou afficher un message de succès
            mauvaisMdp.setText("Connexion réussie !");
            // Exemple de redirection
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            // Parent root = loader.load();
            // Scene scene = new Scene(root);
            // Stage stage = (Stage) btnValider.getScene().getWindow();
            // stage.setScene(scene);
            // stage.show();
        } else {
            mauvaisMdp.setText("Identifiants incorrects.");
        }
    }
}

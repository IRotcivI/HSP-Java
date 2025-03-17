package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InscriptionController {

    private final UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField nomField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        // Ajouter les rôles disponibles dans le ComboBox
        List<String> roles = Arrays.asList("Admin", "Médecin", "Patient");
        roleComboBox.getItems().addAll(roles);
    }

    @FXML
    void inscrireUtilisateur(ActionEvent event) {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String role = roleComboBox.getValue();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || role == null) {
            messageLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        // Vérifier si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            messageLabel.setText("Les mots de passe ne correspondent pas.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            messageLabel.setText("Veuillez entrer une adresse email valide.");
            return;
        }

        // Créer un objet Utilisateur
        Utilisateur utilisateur = new Utilisateur(nom, prenom, email, password, role);

        try {
            boolean inscrit = utilisateurRepository.ajouterUtilisateur(utilisateur);
            if (inscrit) {
                messageLabel.setText("Inscription réussie !");
            } else {
                messageLabel.setText("Erreur lors de l'inscription.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Erreur avec la base de données.");
        }
    }
}

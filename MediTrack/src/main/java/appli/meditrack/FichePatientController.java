package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.FichePatient;
import repository.FichePatientRepository;
import session.SessionManager;

import java.sql.SQLException;

public class FichePatientController {

    @FXML
    private Button btnValider;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField rueField;

    @FXML
    private TextField securiteSocialeField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField villeField;

    @FXML
    private TextField paysField;

    @FXML
    private TextField voieField;

    @FXML
    private Label labelErreur;

    @FXML
    private Label labelReussi;

    private final FichePatientRepository fichePatientRepository = new FichePatientRepository() ;

    @FXML
    void enregistrerFichePatient(ActionEvent event) throws SQLException {

        String email = emailField.getText();
        String nom = nomField.getText();
        String pays = paysField.getText();
        String prenom = prenomField.getText();
        String rue = rueField.getText();
        String securiteSocialeText = securiteSocialeField.getText();
        String telephone = telephoneField.getText();
        String ville = villeField.getText();
        String voie = voieField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty() || rue.isEmpty() || ville.isEmpty() || securiteSocialeText.isEmpty()) {
            labelErreur.setText("Tous les champs obligatoires doivent être remplis.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            labelErreur.setText("Veuillez entrer une adresse email valide.");
            return;
        }

        if (!telephone.matches("^\\d{10}$")) {
            labelErreur.setText("Le numéro de téléphone doit contenir 10 chiffres.");
            return;
        }

        if (!pays.matches("^[A-Za-zÀ-ÖØ-öø-ÿ\\s'-]+$")) {
            labelErreur.setText("Veuillez entrer un nom de pays valide.");
            return;
        }

        if (!securiteSocialeText.matches("^\\d{13}$")) {
            labelErreur.setText("Le numéro de sécurité sociale doit contenir 13 chiffres.");
            return;
        }

        int securiteSociale = Integer.parseInt(securiteSocialeText);

        FichePatient fiche = new FichePatient(nom, securiteSociale, prenom, email, voie, telephone, rue, ville, pays, SessionManager.getId());
        boolean status = fichePatientRepository.creerUneFiche(fiche);

        if (status) {
            labelReussi.setText("Fiche patient créée");
            labelErreur.setText("");
            emailField.clear();
            nomField.clear();
            paysField.clear();
            prenomField.clear();
            rueField.clear();
            securiteSocialeField.clear();
            telephoneField.clear();
            villeField.clear();
            voieField.clear();
        } else {
            labelErreur.setText("Erreur de création");
        }
    }
}

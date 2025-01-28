package appli.meditrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.FichePatient;
import repository.FichePatientRepository;

import java.sql.SQLException;

public class FichePatientController {

    @FXML
    private Button btnValider;

    @FXML
    private TextField emailField;

    @FXML
    private ChoiceBox<?> graviteChoiceBox;

    @FXML
    private TextField nomField;

    @FXML
    private TextField paysField;

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
    private TextField voieField;

    private final FichePatientRepository fichePatientRepository = new FichePatientRepository() ;

    @FXML
    void enregistrerFichePatient(ActionEvent event) throws SQLException {

        String email = emailField.getText();
        String nom = nomField.getText();
        String pays = paysField.getText();
        String prenom = prenomField.getText();
        String rue = rueField.getText();
        String securiteSociale = securiteSocialeField.getText();
        String telephone = telephoneField.getText();
        String ville = villeField.getText();
        String voie = voieField.getText();
        int gravite = graviteChoiceBox.getSelectionModel().getSelectedIndex();

        FichePatient fiche = new FichePatient(nom,securiteSociale,prenom,email,voie,telephone,rue,ville,pays,2);
        boolean status = fichePatientRepository.creerUneFiche(fiche);

        //if () {

        //} else {

        //}
    }
}

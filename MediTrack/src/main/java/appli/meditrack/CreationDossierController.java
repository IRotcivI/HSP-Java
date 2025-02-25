package appli.meditrack;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import repository.DossierRepository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreationDossierController {

    @FXML
    private Button btnValider;

    @FXML
    private DatePicker dateArriveePicker;

    @FXML
    private TextArea decisionField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField heureArriveeField;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelReussi;

    @FXML
    private TextField numSecuField;

    private DossierRepository dossierRepository = new DossierRepository();

    @FXML
    public void creerDossier() {
        LocalDate dateArrivee = dateArriveePicker.getValue();
        String heureArrivee = heureArriveeField.getText().trim();
        String description = descriptionField.getText().trim();
        String decision = decisionField.getText().trim();
        BigInteger secu = new BigInteger(numSecuField.getText());

        if (dateArrivee == null || heureArrivee.isEmpty() || description.isEmpty() || decision.isEmpty()) {
            labelStatus.setText("Veuillez remplir tous les champs.");
            return;
        }

        try {
            dossierRepository.creerDossier(dateArrivee.toString(), heureArrivee, description, decision, secu);
            labelReussi.setText("Dossier créé avec succès.");
            clearFields();
        } catch (SQLException e) {
            labelStatus.setText("Erreur lors de la création du dossier.");
            e.printStackTrace();
        }
    }

    private void clearFields() {
        dateArriveePicker.setValue(null);
        heureArriveeField.clear();
        descriptionField.clear();
        decisionField.clear();
        numSecuField.clear();
    }
}

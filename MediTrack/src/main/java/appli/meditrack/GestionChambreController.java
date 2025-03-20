package appli.meditrack;

import database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Chambre;

public class GestionChambreController {

    @FXML
    private TextField typeField;

    @FXML
    private TextField numeroField;

    @FXML
    private CheckBox disponibleCheckBox;


    @FXML
    public void ajouterChambre() {
        String type = typeField.getText();
        int numero;
        try {
            numero = Integer.parseInt(numeroField.getText());
        } catch (NumberFormatException e) {
            showError("Le numéro de chambre doit être un nombre.");
            return;
        }

        boolean disponible = disponibleCheckBox.isSelected();

        Chambre chambre = new Chambre(type, numero, disponible);

        Database db = new Database();
        if (db.ajouterChambre(chambre)) {
            showInfo("Chambre ajoutée avec succès !");
        } else {
            showError("Une erreur est survenue lors de l'ajout de la chambre.");
        }
    }


    private void showInfo(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

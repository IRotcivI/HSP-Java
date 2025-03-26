package appli.meditrack;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Chambre;
import repository.ChambreRepository;

import java.sql.SQLException;

public class GestionChambreController {

    @FXML
    private TextField typeField;

    @FXML
    private TextField numeroField;

    @FXML
    private CheckBox disponibleCheckBox;


    @FXML
    public void ajouterChambre() throws SQLException {
        String type = typeField.getText();
        int numero = Integer.parseInt(numeroField.getText());
        int disponible = disponibleCheckBox.isSelected() ? 1 : 0;  // Conversion en 1 ou 0

        if (ChambreRepository.ajouterChambre(numero, type, disponible)) {
            System.out.println("Chambre ajoutée avec succès !");
        } else {
            System.out.println("Une erreur est survenue lors de l'ajout de la chambre.");
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

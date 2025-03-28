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
    private TextField numeroField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField disponibleField;


    @FXML
    public void ajouterChambre() throws SQLException {
        int numero = Integer.parseInt(numeroField.getText());
        String type = typeField.getText();
        String disponible = disponibleField.getText();

        if (ChambreRepository.ajouterChambre(numero , type , disponible)) {
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

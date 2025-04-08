package appli.meditrack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import repository.ParkingRepository;

import java.sql.SQLException;

public class CreerUnePlace {

    @FXML
    private TextField Alle;

    @FXML
    private Button CreateButton;

    @FXML
    private TextField Nom;

    private final ParkingRepository parkingRepository = new ParkingRepository();


    @FXML
    void CreerUnePlace(ActionEvent event) throws SQLException {
        parkingRepository.createParking(Nom.getText(),Alle.getText());
    }

}

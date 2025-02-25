package Fxml.gestionDesStocks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GestionProduitsController {

    @FXML
    private Button ajouterProduitButton;

    @FXML
    private TableColumn<?, ?> colNom;

    @FXML
    private TableColumn<?, ?> colQuantite;

    @FXML
    private TableColumn<?, ?> colSeuilMinimum;

    @FXML
    private Button modifierProduitButton;

    @FXML
    private Button supprimerProduitButton;

    @FXML
    private TableView<?> tableProduits;

}

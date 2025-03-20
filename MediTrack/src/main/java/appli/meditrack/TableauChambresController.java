package appli.meditrack;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Chambre;

public class TableauChambresController {

    @FXML
    private TableView<Chambre> chambreTable;
    @FXML
    private TableColumn<Chambre, Integer> numeroCol;
    @FXML
    private TableColumn<Chambre, String> typeCol;
    @FXML
    private TableColumn<Chambre, Boolean> disponibleCol;

    private ObservableList<Chambre> data;

    @FXML
    public void initialize() {


        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        disponibleCol.setCellValueFactory(new PropertyValueFactory<>("disponible"));


        data = FXCollections.observableArrayList(
                new Chambre("Simple", 101, true),
                new Chambre("Double", 102, false),
                new Chambre("Suite", 103, true)
        );


        chambreTable.setItems(data);
    }
}

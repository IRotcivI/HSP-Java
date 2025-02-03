package appli.meditrack;

import javafx.beans.binding.ObjectExpression;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    private static ObjectExpression<Boolean> call(TableColumn.CellDataFeatures<Chambre, Integer> cellData) {
        return cellData.getValue().numero().asObject();
    }

    @FXML
    public void initialize() {
        numeroCol.setCellValueFactory(cellData1 -> {
            ObjectExpression<Boolean> call = call(cellData1);
            return call;
        });
        typeCol.setCellValueFactory(cellData -> cellData.getValue().type());
        disponibleCol.setCellValueFactory(cellData -> cellData.getValue().disponible().asObject());

        ObservableList<Chambre> chambres = FXCollections.observableArrayList(
                new Chambre(101, "Simple", true),
                new Chambre(102, "Double", false),
                new Chambre(103, "Simple", true),
                new Chambre(104, "Simple", true)
        );

        chambreTable.setItems(chambres);
    }
}

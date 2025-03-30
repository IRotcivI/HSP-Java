package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Chambre {
    private final javafx.beans.property.IntegerProperty numero;
    private final javafx.beans.property.StringProperty type;
    private final javafx.beans.property.StringProperty disponible;

    public Chambre(int numero, String type, String disponible) {
        this.numero = new SimpleIntegerProperty(numero);;
        this.type = new SimpleStringProperty(type);
        this.disponible = new SimpleStringProperty(disponible);
    }

    public int getNumero() {
        return numero.get();
    }

    public javafx.beans.property.IntegerProperty numeroProperty() {
        return numero;
    }
    public String getType() {
        return type.get();
    }
    public javafx.beans.property.StringProperty typeProperty() {
        return type;
    }
    public String getDisponible() {
        return disponible.get();
    }
    public javafx.beans.property.StringProperty disponibleProperty() {
        return disponible;
    }
}

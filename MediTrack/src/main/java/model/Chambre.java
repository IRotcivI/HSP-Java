package model;


import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;

public class Chambre {

    public int numero;
    private String type;
    private boolean disponible;

    public Chambre(int numero , String type , boolean disponible ) {
        this.numero = numero;
        this.type = type;
        this.disponible = disponible;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public BooleanExpression numero() {
        return null;
    }

    public BooleanExpression disponible() {
        return null;
    }

    public ObservableValue<String> type() {
        return null;
    }
}

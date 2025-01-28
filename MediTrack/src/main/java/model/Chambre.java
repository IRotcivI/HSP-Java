package model;

import javafx.beans.binding.BooleanExpression;

public class Chambre {
    private String type;
    private int numero;
    private boolean disponibilite;

    public Chambre(int numero, String type, boolean disponibilite) {
        this.numero = numero;
        this.type = type;
        this.disponibilite = disponibilite;
    }

    public int getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public BooleanExpression numeroProperty() {
    }
}
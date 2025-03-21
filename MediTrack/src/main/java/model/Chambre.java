package model;

public class Chambre {
    private String type;
    private int numero;
    private boolean disponible;


    public Chambre(String type, int numero, boolean disponible) {
        this.type = type;
        this.numero = numero;
        this.disponible = disponible;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

package model;

public class Roles {
    private int id;
    private String nom;

    public Roles(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

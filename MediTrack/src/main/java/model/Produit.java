package model;

public class Produit {
    private int id;
    private String libelle;
    private String description;
    private String NiveauDangerosite;

    public Produit(String libelle, String description, String niveauDangerosite) {
        this.libelle = libelle;
        this.description = description;
        NiveauDangerosite = niveauDangerosite;
    }

    public String getNiveauDangerosite() {
        return NiveauDangerosite;
    }

    public void setNiveauDangerosite(String niveauDangerosite) {
        NiveauDangerosite = niveauDangerosite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

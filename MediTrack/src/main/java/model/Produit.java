package model;

public class Produit {
    private int id;
    private String libelle;
    private String description;
    private String niveauDangerosite;  // Utilisation de String au lieu de int

    // Constructeur avec id (utile pour récupérer depuis la BDD)
    public Produit(int id, String libelle, String description, String niveauDangerosite) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.niveauDangerosite = niveauDangerosite;
    }

    // Constructeur sans id (utile pour ajouter un nouveau produit)
    public Produit(String libelle, String description, String niveauDangerosite) {
        this.libelle = libelle;
        this.description = description;
        this.niveauDangerosite = niveauDangerosite;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveauDangerosite() {
        return niveauDangerosite;
    }

    public void setNiveauDangerosite(String niveauDangerosite) {
        this.niveauDangerosite = niveauDangerosite;
    }

    @Override
    public String toString() {
        return libelle + " (Dangerosité : " + niveauDangerosite + ")";
    }
}

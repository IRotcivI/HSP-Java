package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit {
    private IntegerProperty id;
    private StringProperty libelle;
    private StringProperty description;
    private IntegerProperty niveauDangerosite;

    // Constructeur avec id (utile pour récupérer depuis la BDD)
    public Produit(int id, String libelle, String description, Integer niveauDangerosite) {
        this.id = new SimpleIntegerProperty(id);
        this.libelle = new SimpleStringProperty(libelle);
        this.description = new SimpleStringProperty(description);
        this.niveauDangerosite = new SimpleIntegerProperty(niveauDangerosite);
    }

    // Constructeur sans id (utile pour ajouter un nouveau produit)
    public Produit(String libelle, String description, Integer niveauDangerosite) {
        this.libelle = new SimpleStringProperty(libelle);
        this.description = new SimpleStringProperty(description);
        this.niveauDangerosite = new SimpleIntegerProperty(niveauDangerosite);
    }
    public Produit(String libelle) {
        this.libelle = new SimpleStringProperty(libelle);
    }

    public Produit(int idProduit, String libelle) {
    }


    // Getters et Setters pour les propriétés JavaFX
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty libelleProperty() {
        return libelle;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public IntegerProperty niveauDangerositeProperty() {
        return niveauDangerosite;
    }

    // Getters et Setters pour les valeurs
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getLibelle() {
        return libelle.get();
    }

    public void setLibelle(String libelle) {
        this.libelle.set(libelle);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Integer getNiveauDangerosite() {
        return niveauDangerosite.get();
    }

    public void setNiveauDangerosite(Integer niveauDangerosite) {
        this.niveauDangerosite.set(niveauDangerosite);
    }

    @Override
    public String toString() {
        return libelle.get() + " (Dangerosité : " + niveauDangerosite.get() + ")";
    }
}

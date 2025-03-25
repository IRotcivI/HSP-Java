package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fournisseur {
    private IntegerProperty id;
    private StringProperty nom;
    private StringProperty voie;
    private StringProperty rue;
    private StringProperty ville;
    private StringProperty telephone;
    private StringProperty email;

    // Constructeur avec id (utile pour récupérer depuis la BDD)
    public Fournisseur(int id, String nom, String voie, String rue, String ville, String telephone, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.voie = new SimpleStringProperty(voie);
        this.rue = new SimpleStringProperty(rue);
        this.ville = new SimpleStringProperty(ville);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
    }

    public Fournisseur(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    // Constructeur sans id (utile pour ajouter un fournisseur)
    public Fournisseur(String nom, String voie, String rue, String ville, String telephone, String email) {
        this.nom = new SimpleStringProperty(nom);
        this.voie = new SimpleStringProperty(voie);
        this.rue = new SimpleStringProperty(rue);
        this.ville = new SimpleStringProperty(ville);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
    }

    public Fournisseur(int idFournisseur, String nom) {
    }

    // Getters et Setters pour les propriétés JavaFX
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public StringProperty voieProperty() {
        return voie;
    }

    public StringProperty rueProperty() {
        return rue;
    }

    public StringProperty villeProperty() {
        return ville;
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public StringProperty emailProperty() {
        return email;
    }

    // Getters et Setters pour les valeurs
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getVoie() {
        return voie.get();
    }

    public void setVoie(String voie) {
        this.voie.set(voie);
    }

    public String getRue() {
        return rue.get();
    }

    public void setRue(String rue) {
        this.rue.set(rue);
    }

    public String getVille() {
        return ville.get();
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public String toString() {
        return nom.get() + " - " + ville.get();
    }
}

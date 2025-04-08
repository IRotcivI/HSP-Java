package model;

import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.StringProperty;

public class Parking {
    private int id_parking;
    private String nom;
    private String allee;
    private int id_utilisateur;
    private String nom_utilisateur;
    private String email;
    private String prenom;

    public Parking(int id_parking, String nom, String allee) {
        this.id_parking = id_parking;
        this.nom = nom;
        this.allee = allee;
    }

    public Parking(int id_parking, String nom, String allee, int id_utilisateur, String nom_utilisateur, String email, String prenom) {
        this.id_parking = id_parking;
        this.nom = nom;
        this.allee = allee;
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.email = email;
        this.prenom = prenom;
    }

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAllee() {
        return allee;
    }

    public void setAllee(String allee) {
        this.allee = allee;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}

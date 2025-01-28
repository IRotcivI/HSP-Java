package model;

public class Hospitalisation {
    private int id;
    private String description;
    private String date;
    private String salle;
    private int ref_utilisateur;


    public Hospitalisation(String description, String date, String salle, int ref_utilisateur) {
        this.description = description;
        this.date = date;
        this.salle = salle;
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

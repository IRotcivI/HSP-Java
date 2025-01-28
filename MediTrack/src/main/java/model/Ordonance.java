package model;

public class Ordonance {
    private int id;
    private String dateCreation;
    private String dateSortie;
    private int ref_utilisateur;

    public Ordonance(String dateSortie, int ref_utilisateur, String dateCreation) {
        this.dateSortie = dateSortie;
        this.ref_utilisateur = ref_utilisateur;
        this.dateCreation = dateCreation;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}

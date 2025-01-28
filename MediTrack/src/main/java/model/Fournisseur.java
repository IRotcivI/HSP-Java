package model;

public class Fournisseur {
    private int id;
    private String nom;
    private String voie;
    private String rue;
    private String ville;
    private String telephone;
    private String email;


    public Fournisseur(String email, String telephone, String ville, String rue, String voie, String nom) {
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.rue = rue;
        this.voie = voie;
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

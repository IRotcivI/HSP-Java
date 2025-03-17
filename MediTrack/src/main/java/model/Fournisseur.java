package model;

public class Fournisseur {
    private int id;
    private String nom;
    private String voie;
    private String rue;
    private String ville;
    private String telephone;
    private String email;

    // Constructeur avec id (utile pour récupérer depuis la BDD)
    public Fournisseur(int id, String nom, String voie, String rue, String ville, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.voie = voie;
        this.rue = rue;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
    }

    // Constructeur sans id (utile pour ajouter un fournisseur)
    public Fournisseur(String nom, String voie, String rue, String ville, String telephone, String email) {
        this.nom = nom;
        this.voie = voie;
        this.rue = rue;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nom + " - " + ville;
    }
}

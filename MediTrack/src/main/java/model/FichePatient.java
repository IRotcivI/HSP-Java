package model;

public class FichePatient {
    private int id;
    private String nom;
    private String prenom;
    private long secu;
    private String email;
    private String telephone;
    private String voie;
    private String rue;
    private String ville;
    private String pays;
    private int utilisateur;

    public FichePatient(String nom, long secu, String prenom, String email, String voie, String telephone, String rue, String ville, String pays, int utilisateur) {
        this.nom = nom;
        this.secu = secu;
        this.prenom = prenom;
        this.email = email;
        this.voie = voie;
        this.telephone = telephone;
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
        this.utilisateur = utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getSecu() {
        return secu;
    }

    public void setSecu(long secu) {
        this.secu = secu;
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

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }
}

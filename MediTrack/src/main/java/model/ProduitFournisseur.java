package model;

public class ProduitFournisseur {
    private int idProduit;
    private int idFournisseur;
    private double prix;

    public ProduitFournisseur(int idProduit, int idFournisseur, double prix) {
        this.idProduit = idProduit;
        this.idFournisseur = idFournisseur;
        this.prix = prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

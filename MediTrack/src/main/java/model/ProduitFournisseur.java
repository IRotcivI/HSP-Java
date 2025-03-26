package model;

public class ProduitFournisseur {
    private int idProduit;
    private int idFournisseur;
    private String libelle;
    private String nom;
    private double prix;

    // Constructeur pour la liaison entre produit et fournisseur

    public ProduitFournisseur(int idProduit, int idFournisseur, String libelle, String nom, double prix) {
        this.idProduit = idProduit;
        this.idFournisseur = idFournisseur;
        this.libelle = libelle;
        this.nom = nom;
        this.prix = prix;
    }

    public ProduitFournisseur(Produit produit, Fournisseur fournisseur, double prix) {
    }

    // Getters et setters pour les propriétés
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}

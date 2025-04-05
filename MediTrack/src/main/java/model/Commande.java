package model;

import java.time.LocalDateTime;

public class Commande {
    private int idCommande;
    private int idProduit;
    private int idFournisseur;
    private int quantite;
    private double prixUnitaire;
    private LocalDateTime dateCommande;

    public Commande(int idProduit, int idFournisseur, int quantite, double prixUnitaire) {
        this.idProduit = idProduit;
        this.idFournisseur = idFournisseur;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.dateCommande = LocalDateTime.now();
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }
}

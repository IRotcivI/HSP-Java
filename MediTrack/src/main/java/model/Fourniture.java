package model;

public class Fourniture {
    private int id;
    private int quantite;
    private String text;
    private String status;
    private int ref_fournisseur;
    private int ref_produit;

    public Fourniture(int ref_produit, int ref_fournisseur, String status, String text, int quantite) {
        this.ref_produit = ref_produit;
        this.ref_fournisseur = ref_fournisseur;
        this.status = status;
        this.text = text;
        this.quantite = quantite;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }

    public int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public void setRef_fournisseur(int ref_fournisseur) {
        this.ref_fournisseur = ref_fournisseur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

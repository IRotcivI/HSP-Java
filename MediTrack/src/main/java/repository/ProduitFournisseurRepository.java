package repository;

import database.Database;
import model.Fournisseur;
import model.Produit;
import model.ProduitFournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProduitFournisseurRepository {

    private final Database database = new Database();

    public boolean ajouterProduitFournisseur(ProduitFournisseur produitFournisseur) {
        String sql = "INSERT INTO produit_fournisseur (id_produit, id_fournisseur, prix) VALUES (?, ?, ?)";

        try (Connection conn = database.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, produitFournisseur.getIdProduit());
            statement.setInt(2, produitFournisseur.getIdFournisseur());
            statement.setDouble(3, produitFournisseur.getPrix());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProduitFournisseur> getProduitFournisseurs() {

        List<ProduitFournisseur> associations = new ArrayList<>();
        String sql = "SELECT p.libelle, f.nom, pf.prix FROM produit_fournisseur pf " +
                "JOIN produit p ON pf.id_produit = p.id_produit " +
                "JOIN fournisseur f ON pf.id_fournisseur = f.id_fournisseur";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produit produit = new Produit(rs.getString("libelle"));
                Fournisseur fournisseur = new Fournisseur(rs.getString("nom"));
                ProduitFournisseur association = new ProduitFournisseur(produit.getId(), fournisseur.getId(), rs.getDouble("prix"));
                associations.add(association);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return associations;
    }

}

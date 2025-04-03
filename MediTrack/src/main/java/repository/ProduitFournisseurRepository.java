package repository;

import com.sun.nio.sctp.Association;
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
        String sql = "INSERT INTO produit_fournisseur (id_produit, id_fournisseur, libelle, nom, prix) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = database.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, produitFournisseur.getIdProduit());
            statement.setInt(2, produitFournisseur.getIdFournisseur());
            statement.setString(3, produitFournisseur.getLibelle());
            statement.setString(4, produitFournisseur.getNom());
            statement.setDouble(5, produitFournisseur.getPrix());
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
        String sql = "SELECT id_produit, id_fournisseur, libelle, nom, prix FROM produit_fournisseur";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProduitFournisseur ProduitFournisseur = new ProduitFournisseur(
                        rs.getInt("id_produit"),  // Ajout de l'ID
                        rs.getInt("id_fournisseur"),  // Ajout de l'ID
                        rs.getString("libelle"),
                        rs.getString("nom"),
                        rs.getDouble("prix")
                );
                associations.add(ProduitFournisseur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return associations;
    }


}

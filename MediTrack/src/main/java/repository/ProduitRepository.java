package repository;

import database.Database;
import model.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitRepository {

    private final Database database = new Database();

    public boolean ajouterProduit(Produit produit) {
        String sql = "INSERT INTO produit (libelle, description, niveauDangerosite) VALUES (?, ?, ?)";

        try (Connection connection = database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produit.getLibelle());
            stmt.setString(2, produit.getDescription());
            stmt.setString(3, produit.getNiveauDangerosite());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Produit> getProduits() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT id_produit, libelle, description, niveauDangerosite, stock FROM produit";

        try (Connection connection = database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getInt("id_produit"),  // Ajout de l'ID
                        rs.getString("libelle"),
                        rs.getString("description"),
                        rs.getString("niveauDangerosite"),
                        rs.getInt("stock")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public boolean supprimerProduit(int id) {
        String sql = "DELETE FROM produit WHERE id_produit = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

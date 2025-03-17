package repository;

import database.Database;
import model.Produit;
import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class ProduitRepository {

    public static void ajouterProduit(Produit produit) {
        String sql = "INSERT INTO produit (libelle, description, niveauDangerosité) VALUES (?, ?, ?)";

        Database database = new Database();
        Connection connection = database.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produit.getLibelle());
            stmt.setString(2, produit.getDescription());
            stmt.setString(3, produit.getNiveauDangerosite());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Produit> getProduits() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produit";

        Database database = new Database();
        Connection connection = database.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getString("libelle"),
                        rs.getString("description"),
                        rs.getString("niveauDangerosité")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
    public static void supprimerProduit(int id) {
        String sql = "DELETE FROM produit WHERE id_produit = ?";

        Database database = new Database();
        Connection connection = database.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produit supprimé !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}

package repository;

import database.Database;
import model.Fournisseur;
import model.ProduitFournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Produit_FournisseurRepository {

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
}

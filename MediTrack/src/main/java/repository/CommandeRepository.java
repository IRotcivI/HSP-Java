package repository;

import database.Database;
import model.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandeRepository {

    private final Database database = new Database();

    public boolean enregistrerCommande(Commande commande) {
        String sql = "INSERT INTO commande (id_produit, id_fournisseur, quantite, prix_unitaire) VALUES (?, ?, ?, ?)";
        String  modifStock = "UPDATE produit SET stock = stock + ? WHERE id_produit = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmtCommande = conn.prepareStatement(sql);
        PreparedStatement stmtStock = conn.prepareStatement(modifStock)) {

            stmtCommande.setInt(1, commande.getIdProduit());
            stmtCommande.setInt(2, commande.getIdFournisseur());
            stmtCommande.setInt(3, commande.getQuantite());
            stmtCommande.setDouble(4, commande.getPrixUnitaire());
            int rowsCommande = stmtCommande.executeUpdate();

            stmtStock.setInt(1, commande.getQuantite());
            stmtStock.setInt(2, commande.getIdProduit());
            int rowsStock = stmtStock.executeUpdate();


            return rowsCommande > 0 && rowsStock > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

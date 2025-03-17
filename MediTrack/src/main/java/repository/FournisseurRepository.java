package repository;

import model.Fournisseur;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FournisseurRepository {

    public boolean ajouterFournisseur(Fournisseur fournisseur) {
        String sql = "INSERT INTO fournisseur (nom, voie, rue, ville, telephone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Database().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fournisseur.getNom());
            stmt.setString(2, fournisseur.getVoie());
            stmt.setString(3, fournisseur.getRue());
            stmt.setString(4, fournisseur.getVille());
            stmt.setString(5, fournisseur.getTelephone());
            stmt.setString(6, fournisseur.getEmail());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

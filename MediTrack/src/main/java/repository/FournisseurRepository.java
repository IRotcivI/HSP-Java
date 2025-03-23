package repository;

import database.Database;
import model.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurRepository {

    private final Database database = new Database();

    public boolean ajouterFournisseur(Fournisseur fournisseur) {
        String sql = "INSERT INTO fournisseur (nom, voie, rue, ville, telephone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = database.getConnection();
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

    public List<Fournisseur> getFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT id_fournisseur, nom, voie, rue, ville, telephone, email FROM fournisseur";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur(
                        rs.getInt("id_fournisseur"),
                        rs.getString("nom"),
                        rs.getString("voie"),
                        rs.getString("rue"),
                        rs.getString("ville"),
                        rs.getString("telephone"),
                        rs.getString("email")
                );
                fournisseurs.add(fournisseur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseurs;
    }

    public boolean supprimerFournisseur(int id) {
        String sql = "DELETE FROM fournisseur WHERE id_fournisseur = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

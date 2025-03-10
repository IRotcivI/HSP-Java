package repository;

import model.Utilisateur;
import database.Database;
import session.SessionManager;
import java.sql.*;

public class UtilisateurRepository {

    public boolean connexionUtilisateur(Utilisateur utilisateur) throws SQLException {
        Connection maConnexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hsp_java", "root", ""
        );

        String id = utilisateur.getEmail();
        String mdp = utilisateur.getMdp();

        PreparedStatement requetePrepareSelect =
                maConnexion.prepareStatement("" +
                        "SELECT * FROM utilisateur WHERE email = ? AND motDePasse = ?"
                );
        requetePrepareSelect.setString(1, id);
        requetePrepareSelect.setString(2, mdp);
        ResultSet resultat = requetePrepareSelect.executeQuery();
        if (resultat.next()) {
            SessionManager.setId(resultat.getInt("id_utilisateur"));
            SessionManager.setNom(resultat.getString("nom"));
            SessionManager.setPrenom(resultat.getString("prenom"));
            SessionManager.setEmail(resultat.getString("email"));
            return true;
        }
        return false;
    }

    public boolean ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hsp_java";
        String user = "root";
        String password = "";

        // Requête pour récupérer l'ID du rôle
        String getRoleIdQuery = "SELECT id FROM Role WHERE nom = ?";

        // Requête pour insérer l'utilisateur
        String insertUserQuery = "INSERT INTO Utilisateur(nom, prenom, email, motDePasse, role_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection maConnexion = DriverManager.getConnection(url, user, password);
             PreparedStatement roleStatement = maConnexion.prepareStatement(getRoleIdQuery);
             PreparedStatement insertStatement = maConnexion.prepareStatement(insertUserQuery)) {

            // 1. Récupérer l'ID du rôle
            roleStatement.setString(1, utilisateur.getRole());
            ResultSet roleResult = roleStatement.executeQuery();

            if (!roleResult.next()) {
                System.out.println("Erreur : Rôle non trouvé !");
                return false; // Si le rôle n'existe pas, on ne peut pas créer l'utilisateur
            }
            int roleId = roleResult.getInt("id");

            // 2. Insérer l'utilisateur avec l'ID du rôle
            insertStatement.setString(1, utilisateur.getNom());
            insertStatement.setString(2, utilisateur.getPrenom());
            insertStatement.setString(3, utilisateur.getEmail());
            insertStatement.setString(4, utilisateur.getMdp());
            insertStatement.setInt(5, roleId);

            int rowsInserted = insertStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

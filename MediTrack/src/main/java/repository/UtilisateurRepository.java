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

        String insertUserQuery = "INSERT INTO Utilisateur(nom, prenom, email, motDePasse, role) VALUES (?, ?, ?, ?, ?)";

        Database database = new Database();
        try (Connection maConnexion = database.getConnection();
             PreparedStatement insertStatement = maConnexion.prepareStatement(insertUserQuery)) {

            // 🔹 Insérer l'utilisateur avec le rôle en texte
            insertStatement.setString(1, utilisateur.getNom());
            insertStatement.setString(2, utilisateur.getPrenom());
            insertStatement.setString(3, utilisateur.getEmail());
            insertStatement.setString(4, utilisateur.getMdp()); // Tu peux aussi hacher le mot de passe ici
            insertStatement.setString(5, utilisateur.getRole()); // Stocke le rôle en tant que texte

            int rowsInserted = insertStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

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

    public boolean inscrireUtilisateur(Utilisateur utilisateur) throws SQLException {
        Connection maConnexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hsp_java", "root", ""
        );
        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String email = utilisateur.getEmail();
        String mdp = utilisateur.getMdp();
        String role = utilisateur.getRole();

        PreparedStatement requetePrepareInsert = maConnexion.prepareStatement("INSERT INTO Utilisateur(nom, prenom, email, motDePasse, role) VALUES (?, ?, ?, ?, ?)");

            requetePrepareInsert.setString(1, utilisateur.getNom());
            requetePrepareInsert.setString(2, utilisateur.getPrenom());
            requetePrepareInsert.setString(3, utilisateur.getEmail());
            requetePrepareInsert.setString(4, utilisateur.getmotDePasse());
            requetePrepareInsert.setString(5, utilisateur.getRole());

            int rowsInserted = requetePrepareInsert.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


}

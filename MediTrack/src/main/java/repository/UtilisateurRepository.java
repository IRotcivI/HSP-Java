package repository;

import model.Utilisateur;
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
}

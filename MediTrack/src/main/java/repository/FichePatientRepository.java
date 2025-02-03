package repository;

import model.FichePatient;

import java.sql.*;
import session.SessionManager;

public class FichePatientRepository {

    public boolean creerUneFiche(FichePatient fichePatient) throws SQLException {
        Connection maConnexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hsp_java", "root", ""
        );

        String nom = fichePatient.getNom();
        String prenom = fichePatient.getPrenom();
        String email = fichePatient.getEmail();
        long secu = fichePatient.getSecu();
        String telephone = fichePatient.getTelephone();
        String voie = fichePatient.getVoie();
        String rue = fichePatient.getRue();
        String ville = fichePatient.getVille();
        String pays = fichePatient.getPays();

        String sql = "INSERT INTO fiche_patient (nom, prenom, numeroSecu, email, telephone, voie, rue, ville, pays, ref_utilisateur) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement requetePrepareInsert = maConnexion.prepareStatement(sql);

        requetePrepareInsert.setString(1, nom);
        requetePrepareInsert.setString(2, prenom);
        requetePrepareInsert.setLong(3, secu);
        requetePrepareInsert.setString(4, email);
        requetePrepareInsert.setString(5, telephone);
        requetePrepareInsert.setString(6, voie);
        requetePrepareInsert.setString(7, rue);
        requetePrepareInsert.setString(8, ville);
        requetePrepareInsert.setString(9, pays);
        requetePrepareInsert.setInt(10, SessionManager.getId());

        int resultat = requetePrepareInsert.executeUpdate();
        return resultat > 0;
    }
}

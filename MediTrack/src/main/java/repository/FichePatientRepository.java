package repository;

import model.FichePatient;

import java.sql.*;

public class FichePatientRepository {

    public boolean creerUneFiche(FichePatient fichePatient) throws SQLException {
        Connection maConnexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hsp_java", "root", ""
        );

        String nom = fichePatient.getNom();
        String prenom = fichePatient.getPrenom();
        String email = fichePatient.getEmail();
        String secu = fichePatient.getSecu();
        String telephone = fichePatient.getTelephone();
        String voie = fichePatient.getVoie();
        String rue = fichePatient.getRue();
        String ville = fichePatient.getVille();
        String pays = fichePatient.getPays();
        int utilisateur = fichePatient.getUtilisateur();

        PreparedStatement requetePrepareInsert = maConnexion.prepareStatement("" +
                "INSERT INTO `fiche_patient`(`nom`, `prenom`, `numeroSecu`, `email`, `telephone`, `numeroRue`, `rue`, `ville`, `pays`, `ref_utilisateur`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                "");
        requetePrepareInsert.setString(1, nom);
        requetePrepareInsert.setString(2, prenom);
        requetePrepareInsert.setString(3, email);
        requetePrepareInsert.setString(4, telephone);
        requetePrepareInsert.setString(5, rue);
        requetePrepareInsert.setString(6, ville);
        requetePrepareInsert.setString(7, pays);
        requetePrepareInsert.setInt(8, utilisateur);
        ResultSet resultat = requetePrepareInsert.executeQuery();
        if (resultat.next()) {
            return true;
        }
        return false;
    }
}

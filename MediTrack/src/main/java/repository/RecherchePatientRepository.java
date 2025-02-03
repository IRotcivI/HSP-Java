package repository;

import database.Database;
import model.FichePatient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecherchePatientRepository {

    public List<FichePatient> recherchePatient(String recherche) throws SQLException {
        List<FichePatient> patients = new ArrayList<>();
        Database database = new Database();
        Connection connection = database.getConnection();

        String sql = "SELECT * FROM fiche_patient WHERE numeroSecu LIKE ?";
        PreparedStatement requetePrepareSelect = connection.prepareStatement(sql);
        requetePrepareSelect.setString(1, "%" + recherche + "%");
        ResultSet resultSet = requetePrepareSelect.executeQuery();

        while (resultSet.next()) {
            // Extraction des champs depuis le ResultSet
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            Long secu = resultSet.getLong("numeroSecu");
            String email = resultSet.getString("email");
            String telephone = resultSet.getString("telephone");
            String voie = resultSet.getString("voie");
            String rue = resultSet.getString("rue");
            String ville = resultSet.getString("ville");
            String pays = resultSet.getString("pays");
            int utilisateur = resultSet.getInt("ref_utilisateur");

            FichePatient patient = new FichePatient(
                    nom, secu, prenom, email, voie, telephone, rue, ville, pays, utilisateur
            );

            patients.add(patient);
        }

        resultSet.close();
        requetePrepareSelect.close();
        connection.close();

        return patients;
    }
}

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
            FichePatient patient = new FichePatient();
            patient.setNom(resultSet.getString("nom"));
            patient.setPrenom(resultSet.getString("prenom"));
            patient.setSecu(resultSet.getString("numeroSecu"));
            patient.setEmail(resultSet.getString("email"));
            patients.add(patient);
        }
        return patients;
    }
}

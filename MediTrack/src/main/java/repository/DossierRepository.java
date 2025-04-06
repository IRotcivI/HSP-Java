package repository;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Database;
import session.SessionManager;

public class DossierRepository {

    public void creerDossier(String dateArrivee, String heureArrivee, String description, String decision, BigInteger secu) throws SQLException {
        Connection connection = null;
        PreparedStatement selectPs = null;
        PreparedStatement insertPs = null;
        ResultSet rs = null;

        try {
            connection = new Database().getConnection();

            String lqs = "SELECT id_patient FROM fiche_patient WHERE numeroSecu = ?";
            selectPs = connection.prepareStatement(lqs);
            selectPs.setObject(1, secu);
            rs = selectPs.executeQuery();

            if (rs.next()) {
                int idPatient = rs.getInt("id_patient");

                String sql = "INSERT INTO dossier (date, heureArrive, description, décision, ref_utilisateur, ref_patient) VALUES (?, ?, ?, ?, ?, ?)";
                insertPs = connection.prepareStatement(sql);
                insertPs.setString(1, dateArrivee);
                insertPs.setString(2, heureArrivee);
                insertPs.setString(3, description);
                insertPs.setString(4, decision);
                insertPs.setInt(5, SessionManager.getId());
                insertPs.setInt(6, idPatient);
                insertPs.executeUpdate();
            } else {
                throw new SQLException("Patient non trouvé pour le numéro de sécurité sociale : " + secu);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (selectPs != null) {
                selectPs.close();
            }
            if (insertPs != null) {
                insertPs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void supprimerDossier(int idDossier) throws SQLException {
        Connection connection = null;
        PreparedStatement selectPs = null;
        ResultSet rs = null;
        try {
            connection = new Database().getConnection();
            String sql = "DELETE FROM dossier WHERE id_dossier = ?";
            selectPs = connection.prepareStatement(sql);
            selectPs.setInt(1, idDossier);
            selectPs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void marquerDossier(int idDossier) throws SQLException {
        Connection connection = null;
        PreparedStatement selectPs = null;
        ResultSet rs = null;
        try {
            connection = new Database().getConnection();
            String sql = "UPDATE dossier SET decision = 'LU' WHERE id_dossier = ?";
            selectPs = connection.prepareStatement(sql);
            selectPs.setInt(1, idDossier);
            selectPs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

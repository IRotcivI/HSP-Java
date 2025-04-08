package repository;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingRepository {

    public boolean createParking(String nom, String allee) throws SQLException {
        String insertUserQuery = "INSERT INTO parking(nom, allee) VALUES (?,?)";
        Database database = new Database();
        try (Connection maConnexion = database.getConnection();){
            PreparedStatement insertStatement = maConnexion.prepareStatement(insertUserQuery);

            insertStatement.setString(1, nom);
            insertStatement.setString(2, allee);

            int rowsInserted = insertStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public void lierParking(int idParking, int idUtilisateur) throws SQLException {
        String sql = "UPDATE parking SET ref_utilisateur = ? WHERE id_parking = ?";
        Database database = new Database();

        try (Connection maConnexion = database.getConnection();){
            PreparedStatement insertStatement = maConnexion.prepareStatement(sql);

            insertStatement.setInt(1, idUtilisateur);
            insertStatement.setInt(2, idParking);

            int rowsInserted = insertStatement.executeUpdate();
        }
    }
}

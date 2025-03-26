package repository;

import model.Chambre;

import java.sql.*;
import java.util.ArrayList;

public class ChambreRepository {


    public static boolean ajouterChambre(int numero, String type, String disponible) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hsp_java", "root", ""
            );


            String sql = "INSERT INTO chambre (numero, type, disponible) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);


            statement.setInt(1, numero);
            statement.setString(2, type);
            statement.setString(3, disponible);


            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }}
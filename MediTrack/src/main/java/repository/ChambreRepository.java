package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Chambre;

import java.sql.*;

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
    }
    public static ObservableList<Chambre> getChambres() throws SQLException {
        javafx.collections.ObservableList<Chambre> chambresList = FXCollections.observableArrayList();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsp_java", "root", "");
            String query = "SELECT * FROM chambre";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int num = resultSet.getInt("numero");
                String type = resultSet.getString("type");
                String disponible = resultSet.getString("disponible");


                chambresList.add(new Chambre(num, type, disponible));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur lors de la récupération des chambres");
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return chambresList;
}}
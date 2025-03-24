package repository;

import model.Chambre;

import java.sql.*;
import java.util.ArrayList;

public class ChambreRepository {


    public boolean ajouterChambre(Chambre chambre) {
        String sql = "INSERT INTO chambre (numero, type, disponible) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {



            statement.setInt(2, chambre.getNumero());
            statement.setString(1, chambre.getType());
            statement.setBoolean(3, chambre.isDisponible());


            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Chambre> getChambres() {
        ArrayList<Chambre> chambres = new ArrayList<>();
        String query = "SELECT * FROM chambres";

        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String type = rs.getString("type");
                int numero = rs.getInt("numero");
                boolean disponible = rs.getBoolean("disponible");

                chambres.add(new Chambre(type, numero, disponible));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chambres;

    }}

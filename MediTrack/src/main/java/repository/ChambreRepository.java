package repository;

import model.Chambre;

import java.sql.*;
import java.util.ArrayList;

public class ChambreRepository {

public static boolean ajouterChambre (int n, String t, int d) throws SQLException {
    Connection maConnexion = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hsp_java", "root", "");


        String sql = "INSERT INTO chambre (numero, type,disponible) " +
                "VALUES (?, ?,?)";
        PreparedStatement requetePrepareInsert = maConnexion.prepareStatement(sql);
        requetePrepareInsert.setInt(1, n);
        requetePrepareInsert.setString(2, t);
        requetePrepareInsert.setInt(3, d);
    int resultat = requetePrepareInsert.executeUpdate();
    return resultat > 0;
}



    }

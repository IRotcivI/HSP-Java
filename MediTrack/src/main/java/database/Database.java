package database;

import model.Chambre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class Database {
    String server ="localhost";
    String nomDeLaBase = "hsp_java";
    String utilisateur = "root";
    String mdp = "";

    private String getUrl (){
        return "jdbc:mysql://"+server+"/"+nomDeLaBase;
    }

    public Connection getConnection (){
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(),this.utilisateur,this.mdp);
            System.out.print("Etat de la connexion : ");
            System.out.print(cnx.isClosed()?"fermée":"ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la tentative de connexion à la base de données.");
            e.printStackTrace();
            return null;
        }
    }
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
}
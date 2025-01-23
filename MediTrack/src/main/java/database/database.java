package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    String server ="localhost";
    String nomDeLaBase = "hsp_java";
    String utilisateur = "root";
    String mdp = "";

    public database(String server, String nomDeLaBase, String utilisateur, String mdp) {
        this.server = server;
        this.nomDeLaBase = nomDeLaBase;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
    }

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
}

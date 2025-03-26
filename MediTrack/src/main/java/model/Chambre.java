package model;

public class Chambre {
    private static String type;
    private static int numero;
    private static String disponible;


    public Chambre( int numero,String type, String disponible) {
        Chambre.numero = numero;
        Chambre.type = type;
        Chambre.disponible = disponible;
    }




    public static int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        Chambre.numero = numero;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        Chambre.type = type;
    }

    public static String getDisponible() {
        return disponible;
    }

    public static void setDisponible(String disponible) {
        Chambre.disponible = disponible;
    }
}

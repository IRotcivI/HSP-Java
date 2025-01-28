package model;

public class Log {
    private int id;
    private String action;
    public String date;
    private int ref_utilisateur;

    public Log(int ref_utilisateur, String date, String action) {
        this.ref_utilisateur = ref_utilisateur;
        this.date = date;
        this.action = action;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

package model;

public class Dossier {
    private int id;
    private String date;
    private int heureArrive;
    private String description;
    private String decision;
    private int ref_utilisateur;
    private int ref_patient;

    public Dossier(int ref_utilisateur, String decision, String description, int heureArrive, String date, int ref_patient) {
        this.ref_utilisateur = ref_utilisateur;
        this.decision = decision;
        this.description = description;
        this.heureArrive = heureArrive;
        this.date = date;
        this.ref_patient = ref_patient;
    }


    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(int heureArrive) {
        this.heureArrive = heureArrive;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRef_patient() {
        return ref_patient;
    }

    public void setRef_patient(int ref_patient) {
        this.ref_patient = ref_patient;
    }
}

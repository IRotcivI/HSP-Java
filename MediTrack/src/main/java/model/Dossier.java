package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dossier {
    private SimpleStringProperty dossierId;
    private final StringProperty dateArrivee = new SimpleStringProperty();
    private final StringProperty heureArrivee = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty decision = new SimpleStringProperty();
    private final StringProperty nomPatient = new SimpleStringProperty();

    public Dossier(int dossierId, String dateArrivee, String heureArrivee, String description, String decision, String nomPatient) {
        this.dossierId = new SimpleStringProperty(Integer.toString(dossierId));
        setDateArrivee(dateArrivee);
        setHeureArrivee(heureArrivee);
        setDescription(description);
        setDecision(decision);
        setNomPatient(nomPatient);
    }

    public Dossier(String dateArrivee, String heureArrivee, String description, String decision, String nomPatient) {
        this(0, dateArrivee, heureArrivee, description, decision, nomPatient);
    }

    public String getDossierId() {
        return dossierId.get();
    }

    public SimpleStringProperty dossierIdProperty() {
        return dossierId;
    }

    public void setDossierId(String dossierId) {
        this.dossierId.set(dossierId);
    }

    public String getDateArrivee() {
        return dateArrivee.get();
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee.set(dateArrivee);
    }

    public StringProperty dateArriveeProperty() {
        return dateArrivee;
    }

    public String getHeureArrivee() {
        return heureArrivee.get();
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee.set(heureArrivee);
    }

    public StringProperty heureArriveeProperty() {
        return heureArrivee;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDecision() {
        return decision.get();
    }

    public void setDecision(String decision) {
        this.decision.set(decision);
    }

    public StringProperty decisionProperty() {
        return decision;
    }

    public String getNomPatient() {
        return nomPatient.get();
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient.set(nomPatient);
    }

    public StringProperty nomPatientProperty() {
        return nomPatient;
    }
}

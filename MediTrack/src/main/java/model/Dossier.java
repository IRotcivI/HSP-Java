package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dossier {
    private final StringProperty dateArrivee = new SimpleStringProperty();
    private final StringProperty heureArrivee = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty decision = new SimpleStringProperty();
    private final StringProperty nomPatient = new SimpleStringProperty();

    public Dossier(String dateArrivee, String heureArrivee, String description, String decision, String nomPatient) {
        setDateArrivee(dateArrivee);
        setHeureArrivee(heureArrivee);
        setDescription(description);
        setDecision(decision);
        setNomPatient(nomPatient);
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

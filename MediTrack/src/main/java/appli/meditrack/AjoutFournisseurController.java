package appli.meditrack;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Fournisseur;
import repository.FournisseurRepository;

public class AjoutFournisseurController {

    @FXML private TextField nom;
    @FXML private TextField voie;
    @FXML private TextField rue;
    @FXML private TextField ville;
    @FXML private TextField telephone;
    @FXML private TextField email;
    @FXML private Label labelErreur;
    @FXML private Label labelReussi;
    @FXML private Button btnAnnuler;

    private final FournisseurRepository fournisseurRepository = new FournisseurRepository();

    @FXML
    public void ajouterFournisseur() {
        String nomValue = nom.getText();
        String voieValue = voie.getText();
        String rueValue = rue.getText();
        String villeValue = ville.getText();
        String telephoneValue = telephone.getText();
        String emailValue = email.getText();

        if (nomValue.isEmpty() || voieValue.isEmpty() || rueValue.isEmpty() || villeValue.isEmpty() || telephoneValue.isEmpty() || emailValue.isEmpty()) {
            labelErreur.setText("Tous les champs doivent être remplis.");
            return;
        }

        if (!emailValue.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            labelErreur.setText("Veuillez entrer une adresse email valide.");
            return;
        }

        if (!telephoneValue.matches("^\\d{10}$")) {
            labelErreur.setText("Le numéro de téléphone doit contenir 10 chiffres.");
            return;
        }

        Fournisseur fournisseur = new Fournisseur(nomValue, voieValue, rueValue, villeValue, telephoneValue, emailValue);
        boolean status = fournisseurRepository.ajouterFournisseur(fournisseur);

        if (status) {
            labelReussi.setText("Fournisseur ajouté avec succès.");
            labelErreur.setText("");
            fermerFenetre();
        } else {
            labelErreur.setText("Erreur lors de l'ajout du fournisseur.");
        }
    }

    @FXML
    void fermerFenetre() {
        ((Stage) btnAnnuler.getScene().getWindow()).close();
    }
}

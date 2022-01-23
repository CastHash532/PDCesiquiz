package gui.formateur;

import gui.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;
import java.time.LocalDate;

public class CreerApprenantController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private DatePicker ddn;

    @FXML
    private TextField adresse;

    @FXML
    private TextField nomUtil;

    @FXML
    private TextField pass;

    @FXML
    void Retour() {
        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "menu.fxml");

            s.setScene(new Scene(loader.load(), 600, 400));

            MenuController c = loader.getController();
            c.initialiser(quiz, current);

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void Valider(ActionEvent event) {
        Apprenant a = new Apprenant(nom.getText(), prenom.getText(), ddn.getValue(), adresse.getText());

        if(!nomUtil.getText().isEmpty())
            a.setNomUtilisateur(nomUtil.getText());
        if(!pass.getText().isEmpty())
            a.setMotDePasse(pass.getText());

        quiz.ajouterCompte(a);

        Retour();
    }

}

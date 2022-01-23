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
import noyau.ESIQuiz;
import noyau.Formateur;
import noyau.Quiz;

import java.io.IOException;

public class GenererQuizController {

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
    private TextField nom;

    @FXML
    private DatePicker ouverture;

    @FXML
    private DatePicker expiration;

    @FXML
    void Retour(ActionEvent event) {
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
    void Suivant(ActionEvent event) {
        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "genererQuiz_1.fxml");

            s.setScene(new Scene(loader.load(), 600, 400));

            GenererQuiz1Controller c = loader.getController();
            c.initialize(quiz, current, nom.getText(), ouverture.getValue(), expiration.getValue());

        } catch(IOException e){
            e.printStackTrace();
        }
    }

}

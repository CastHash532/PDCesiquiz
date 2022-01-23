package gui.formateur;

import gui.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noyau.ESIQuiz;
import noyau.Formateur;
import noyau.Notion;
import quiz.MultiReponse;
import quiz.QCM;
import quiz.QCU;
import quiz.QO;

import java.io.IOException;

public class AjouterNotionController {

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
    public void Valider()
    {
        if(!nom.getText().isEmpty())
        {
            Notion n = new Notion(nom.getText());

            MultiReponse reps = new MultiReponse(new String[]{"rep1", "rep2", "rep3"});
            MultiReponse freps = new MultiReponse(new String[]{"frep"});

            QCM qcm = new QCM("this is a qcm", reps, freps);
            QCU  qcu = new QCU("this is a qcu", reps, freps);

            n.ajouterQuestion(qcm);
            n.ajouterQuestion(qcu);
            current.ajouterNotion(n);
        }

        Retour();
    }

    @FXML
    void ajouterQuestion(ActionEvent event) {

    }

    @FXML
    public void Retour()
    {
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

}

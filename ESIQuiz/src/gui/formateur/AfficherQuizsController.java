package gui.formateur;

import gui.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import noyau.ESIQuiz;
import noyau.Formateur;
import noyau.Quiz;

import java.io.IOException;
import java.util.Iterator;

public class AfficherQuizsController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Quiz> iter = current.getFormation().getQuizs();
        ObservableList<Quiz> li = FXCollections.observableArrayList();
        while(iter.hasNext())
        {
            li.add(iter.next());
        }

        list.setItems(li);

    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ListView<Quiz> list;

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


}

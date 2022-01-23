package gui.formateur;

import gui.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import noyau.*;

import java.io.IOException;
import java.util.Iterator;

public class AfficherNotionsController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Notion> iter = current.getFormation().getNotions();
        ObservableList<Notion> li = FXCollections.observableArrayList();

        while(iter.hasNext()) {
            li.add(iter.next());
        }
        list.setItems(li);
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ListView list;

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

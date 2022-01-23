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
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;
import java.util.Iterator;

public class AfficherApprenantsController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c, boolean toutApprenant)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Apprenant> iter;

        if(toutApprenant)
        {
            iter = quiz.getApprenants();
        } else
            iter = current.getApprenants();

        ObservableList<Apprenant> lis = FXCollections.observableArrayList();

        while(iter.hasNext()) {
                lis.add(iter.next());
        }
        list.setItems(lis);
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ListView<Apprenant> list;

    @FXML
    public void Retour() {
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

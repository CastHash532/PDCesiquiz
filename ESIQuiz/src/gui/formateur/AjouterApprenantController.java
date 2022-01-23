package gui.formateur;

import gui.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AjouterApprenantController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur current)
    {
        this.quiz = quiz;
        this.current = current;
        nomFormateur.setText(current.getNomUtilisateur());

        Iterator<Compte> iter = quiz.getComptes();
        ObservableList<Apprenant> list = FXCollections.observableArrayList();

        while(iter.hasNext()) {
            Compte c = iter.next();
            if(c instanceof Apprenant){
                list.add((Apprenant)c);
            }
        }
        apprenants.setItems(list);
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ChoiceBox<Apprenant> apprenants;

    @FXML
    void Valider(ActionEvent event) {
        if(apprenants.getValue() != null)
        {
            current.ajouterApprenant(apprenants.getValue());
        }

        retour();
    }

    @FXML void retour() {
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

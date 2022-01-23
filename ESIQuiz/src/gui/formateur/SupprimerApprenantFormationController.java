package gui.formateur;

import gui.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;
import java.util.Iterator;

public class SupprimerApprenantFormationController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Apprenant> iter = current.getApprenants();
        ObservableList<Apprenant> list = FXCollections.observableArrayList();

        while(iter.hasNext()) {
            list.add(iter.next());
        }
        apprenants.setItems(list);
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ChoiceBox<Apprenant> apprenants;

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
    void Supprimer(ActionEvent event) {
        if(apprenants.getValue() != null)
            current.supprimerApprenant(apprenants.getValue());

        Retour();
    }

}

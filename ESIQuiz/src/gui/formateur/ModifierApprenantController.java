package gui.formateur;

import gui.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

public class ModifierApprenantController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Apprenant> iter = quiz.getApprenants();
        ObservableList<Apprenant> li = FXCollections.observableArrayList();
        while(iter.hasNext())
        {
                li.add(iter.next());
        }
        list.setItems(li);

        list.setOnAction(event -> {
            Changed(event);
        });
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private ChoiceBox<Apprenant> list;

    @FXML
    private DatePicker ddn;

    @FXML
    private TextField adresse;

    @FXML
    private TextField nom;

    @FXML
    private TextField pass;

    @FXML
    public void Changed(ActionEvent event) {
        Apprenant a = list.getValue();

        ddn.setValue(a.getDateDeNaissance());
        adresse.setText(a.getAdresse());
        nom.setText(a.getNomUtilisateur());
        pass.setText(a.getMotDePasse());
    }

    @FXML
    public void Valider() {
        Apprenant a = list.getValue();
        if(a != null)
        {
            a.setDateDeNaissance(ddn.getValue());
            a.setAdresse(adresse.getText());
            a.setNomUtilisateur(nom.getText());
            a.setMotDePasse(pass.getText());

            // add prompt because it was modified successfully
        }
        Retour();
    }

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

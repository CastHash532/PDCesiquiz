package gui.formateur;

import gui.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import noyau.ESIQuiz;
import noyau.Formateur;
import noyau.Formation;

import java.io.IOException;

public class CreerFormationController {

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
    private TextArea description;

    @FXML
    private DatePicker debut;

    @FXML
    private DatePicker fin;

    @FXML
    public void Valider(ActionEvent e)
    {
        Formation f = new Formation(nom.getText(), description.getText(), debut.getValue(), fin.getValue());
        current.setFormation(f);
        Retour();
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

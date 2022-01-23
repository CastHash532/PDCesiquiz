package gui.formateur;

import gui.Utility;
import gui.formateur.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.IOException;

public class ProfileController {

    private ESIQuiz quiz;

    private Formateur current;

    public void initialize(ESIQuiz quiz, Formateur c)
    {
        this.quiz = quiz;
        this.current = c;
        nomFormateur.setText(c.getNomUtilisateur());
        nom.setText(c.getNomUtilisateur());
        pass.setText(c.getMotDePasse());
    }

    @FXML
    private Label nomFormateur;

    @FXML
    private TextField nom;

    @FXML
    private TextField pass;

    @FXML
    void valider(ActionEvent event) {
        current.setNomUtilisateur(nom.getText());
        current.setMotDePasse(pass.getText());

        try {
            Stage s = Utility.getStage(nom);
            FXMLLoader loader = Utility.getLoader(this, "menu.fxml");

            s.setScene(new Scene(loader.load(), 600, 400));

            MenuController controller = loader.getController();
            controller.initialiser(quiz, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

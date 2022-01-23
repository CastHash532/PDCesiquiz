package gui;

import gui.formateur.MenuController;
import gui.templates.Type;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noyau.*;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class SeConnecterController implements Initializable {

    private ESIQuiz quiz;    // think of getting this from a file

    @FXML
    private TextField nomUtilisateur;

    @FXML
    private TextField motDePasseUtilisateur;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setQuiz(ESIQuiz quiz) {
        this.quiz = quiz;
    }

    @FXML
    public void seConnecter(Event e) throws UserPassNotFoundException {
        String nom = nomUtilisateur.getText();
        String pass = motDePasseUtilisateur.getText();

        try {
            Compte c = quiz.authentifier(nom, pass);
            FXMLLoader loader;
            if(c instanceof Formateur) {
                loader = Utility.getLoader(this, "formateur/menu.fxml");
            } else {
                loader = Utility.getLoader(this, "apprenant/menu.fxml");
            }
            Parent p = loader.load();
            Stage stage = Utility.getStage(nomUtilisateur);
            stage.setScene(new Scene(p, 600, 400));

            if(c instanceof Formateur) {
                MenuController controller = loader.getController();
                controller.initialiser(quiz, (Formateur)c);
            } else {
                gui.apprenant.MenuController controller = loader.getController();
                controller.initialiser(quiz, (Apprenant)c);
            }
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }
}

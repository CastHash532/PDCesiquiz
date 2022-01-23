package gui.apprenant;

import gui.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.ESIQuiz;

import java.io.IOException;

public class ProfileController {

    private ESIQuiz quiz;

    private Apprenant current;

    @FXML
    private Label nomApprenant;

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

    public void initialize(ESIQuiz quiz, Apprenant c)
    {
        this.quiz = quiz;
        this.current = c;
        nomApprenant.setText(c.getNom() + " " + c.getPrenom());
        nom.setText(c.getNomUtilisateur());
        pass.setText(c.getMotDePasse());
    }

}

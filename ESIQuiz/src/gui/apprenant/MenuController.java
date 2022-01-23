package gui.apprenant;

import gui.SeConnecterController;
import gui.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class MenuController {

    private ESIQuiz app;

    private Apprenant current;

    @FXML
    private Label nomApprenant;

    public void initialiser(ESIQuiz app, Apprenant connecte)
    {
        this.app = app;
        this.current = connecte;
        nomApprenant.setText(connecte.getNom() + " " + connecte.getPrenom());
    }

    @FXML
    void modifierProfile(ActionEvent event) {
        Stage s = Utility.getStage(nomApprenant);
        try {
            FXMLLoader loader = Utility.getLoader(this, "profile.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            ProfileController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void consulterQuizs(ActionEvent event) {
        Stage s = Utility.getStage(nomApprenant);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherQuizs.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherQuizController c = loader.getController();
            c.initialiser(app, current);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void repondreQuiz(ActionEvent event) {

    }

    @FXML
    void evaluerQuiz(ActionEvent event) {

    }

    @FXML
    void deconnecter(ActionEvent event) {
        Stage s = (Stage)nomApprenant.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../SeConnecter.fxml"));
            s.setScene(new Scene(loader.load(), 600, 400));

            SeConnecterController controller = loader.getController();
            controller.setQuiz(app);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void quitApplication(ActionEvent event) {
        Stage s = (Stage)nomApprenant.getScene().getWindow();
        s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

}

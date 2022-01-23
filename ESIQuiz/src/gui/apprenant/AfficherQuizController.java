package gui.apprenant;

import gui.Utility;
import gui.apprenant.MenuController;
import gui.templates.QCMController;
import gui.templates.QCUController;
import gui.templates.QOController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import noyau.Apprenant;
import noyau.ESIQuiz;
import noyau.Quiz;
import quiz.QCM;
import quiz.QCU;
import quiz.QO;
import quiz.Question;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AfficherQuizController {

    private ESIQuiz quiz;

    private Apprenant current;

    private HashMap<Question, FXMLLoader> map = new HashMap<Question, FXMLLoader>();

    public void initialiser(ESIQuiz quiz, Apprenant app){
        this.quiz = quiz;
        this.current = app;

        nomApprenant.setText(app.getNom() + " " + app.getPrenom());

        Iterator<Quiz> iter = quiz.getQuizs(current);
        ObservableList<Quiz> list = FXCollections.observableArrayList();

        while(iter.hasNext())
        {
            list.add(iter.next());
        }

        quizs.setItems(list);

        quizs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Quiz>() {
            @Override
            public void changed(ObservableValue<? extends Quiz> observable, Quiz oldValue, Quiz newValue) {
                Iterator<Question> quests = newValue.getQuestions();
                while(quests.hasNext())
                {
                    try {
                        Question q = quests.next();
                        FXMLLoader loader = null;
                        if(q instanceof QCM)
                        {
                            loader = Utility.getLoader(this, "../templates/questionChoixMultiple.fxml");
                        } else if(q instanceof QCU)
                        {
                            loader = Utility.getLoader(this, "../templates/questionChoixUnique.fxml");
                        } else {
                            loader = Utility.getLoader(this, "../templates/questionOuverte.fxml");
                        }

                        map.put(q, loader);

                        quizDetails.getChildren().add(loader.load());
                        quizDetails.getChildren().add(new Separator());

                        if(q instanceof QCM)
                        {
                            QCMController controller = loader.getController();
                            controller.setQCM((QCM)q);
                        } else if(q instanceof QCU)
                        {
                            QCUController controller = loader.getController();
                            controller.setQCU((QCU)q);
                        } else {
                            QOController controller = loader.getController();
                            controller.setQO((QO)q);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @FXML
    private Label nomApprenant;

    @FXML
    private ListView<Quiz> quizs;

    @FXML
    private VBox quizDetails;

    @FXML
    void modifierProfile(ActionEvent event) {
        Stage s = Utility.getStage(nomApprenant);
        try {
            FXMLLoader loader = Utility.getLoader(this, "profile.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            ProfileController c = loader.getController();
            c.initialize(quiz, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void retour(ActionEvent event) {
        Stage s = Utility.getStage(nomApprenant);
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

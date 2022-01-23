package gui;

import gui.templates.Type;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Iterator;

public class Main extends Application {

    private int SplashScreenDelay = 5;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            if(throwable instanceof RuntimeException)
            {
                RuntimeException e = (RuntimeException)throwable;
                Throwable th = e.getCause();
                if(th instanceof InvocationTargetException)
                Utility.MessageBox(this, "erreur!", ((InvocationTargetException)th).getTargetException().getMessage(), Type.OK);
            } else {
                Utility.MessageBox(this, "erreur!", throwable.getMessage(), Type.OK);
            }
        });


        Parent splash = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeConnecter.fxml"));

        Stage stage = new Stage();

        primaryStage.setScene(new Scene(splash, 800, 500));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("hello");
        primaryStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(SplashScreenDelay));
        delay.setOnFinished( event -> {
            try {
                primaryStage.close();
                stage.setScene(new Scene(loader.load(), 600, 400));
                stage.setTitle("ESI Quiz");
                stage.show();

                SeConnecterController controller = loader.getController();
                ESIQuiz q = getQuiz();
                controller.setQuiz(q);

                stage.setOnCloseRequest(event1 -> {
                    try {
                        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("save.quiz"));
                        o.writeObject(q);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch(IOException e) {
                e.printStackTrace();
            } catch(Exception ev) {
                Utility.MessageBox(this, "Erreur!", ev.getMessage(), Type.OK);
            }
        } );
        delay.play();
    }

    private ESIQuiz getQuiz() {  // get the quiz from a serialized file... later
        ESIQuiz quiz;

        try {
            ObjectInputStream f = new ObjectInputStream(new FileInputStream("save.quiz"));
            quiz = (ESIQuiz)f.readObject();
        } catch (FileNotFoundException e) {
            quiz = new ESIQuiz();

            LocalDate d = LocalDate.of(2000, 05, 11);

            Apprenant a = new Apprenant("otsmane", "nabil", d, "abdel9ader la rue");
            Formateur f = new Formateur("teacher1", "pass");

            quiz.ajouterCompte(a);
            quiz.ajouterCompte(f);
        } catch (IOException e) {
            //Utility.MessageBox(this, "Erreur!", "erreur inconnu.", Type.OK);
            quiz = new ESIQuiz();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Utility.MessageBox(this, "Erreur!", "save file is corrupted.", Type.OK);
            quiz = new ESIQuiz();
        }


        return quiz;
    }

    public static void main(String args) {
        launch(args);
    }

}

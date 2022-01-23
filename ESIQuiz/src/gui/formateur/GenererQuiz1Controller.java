package gui.formateur;

import gui.Utility;
import gui.templates.NotionListItemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import noyau.ESIQuiz;
import noyau.Formateur;
import noyau.Notion;
import noyau.Quiz;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenererQuiz1Controller {

    private ESIQuiz quiz;

    private Formateur current;

    private String nom;

    private LocalDate ouverture;

    private LocalDate expiration;

    private List<NotionListItemController> controllers = new ArrayList<NotionListItemController>();

    public void initialize(ESIQuiz quiz, Formateur c, String nom, LocalDate ouverture, LocalDate expiration)
    {
        this.quiz = quiz;
        this.current = c;
        this.nom = nom;
        this.ouverture = ouverture;
        this.expiration = expiration;

        nomFormateur.setText(c.getNomUtilisateur());

        Iterator<Notion> iter = current.getFormation().getNotions();
        while(iter.hasNext())
        {
            try {
                FXMLLoader loader = Utility.getLoader(this, "../templates/notionListItem.fxml");
                Parent elem = loader.load();

                container.getChildren().add(elem);

                NotionListItemController control = loader.getController();
                Notion n = iter.next();
                control.initialiser(n);
                controllers.add(control);
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    @FXML
    private Label nomFormateur;

    @FXML
    private VBox container;

    @FXML
    void Annuler() {
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
    void Generer(ActionEvent event) {
        List<Notion> list = new ArrayList<Notion>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(NotionListItemController c : controllers)
        {
            if(c.getNbQuestion() != 0)
            {
                list.add(c.getNotion());
                list2.add(c.getNbQuestion());
            }
        }

        Notion[] ns = new Notion[list.size()];
        int[] nbs = new int[list2.size()];

        for(int i = 0; i < list.size(); i++)
        {
            ns[i] = list.get(i);
            nbs[i] = list2.get(i);
        }

        Quiz q = new Quiz(nom, ouverture, expiration, ns, nbs);

        current.ajouterQuiz(q);

        Annuler();
    }

}

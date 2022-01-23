package gui.templates;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import noyau.Notion;

public class NotionListItemController {

    private Notion notion;

    public void initialiser(Notion n)
    {
        notion = n;

        nom.setText(n.getNom());
        SpinnerValueFactory<Integer> values = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, n.nbQuestions(), 0);

        nbQuestion.setValueFactory(values);
    }

    public Notion getNotion()
    {
        return notion;
    }

    public int getNbQuestion()
    {
        return nbQuestion.getValue();
    }

    @FXML
    private TextField nom;

    @FXML
    private Spinner<Integer> nbQuestion;

}

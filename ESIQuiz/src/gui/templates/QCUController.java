package gui.templates;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import quiz.MultiReponse;
import quiz.QCM;
import quiz.QCU;
import quiz.UniReponse;

import java.util.Iterator;

public class QCUController {

    @FXML
    private Label question;

    @FXML
    private HBox reponseCont;

    private QCU qcu;

    public void setQCU(QCU qcu) {
        this.qcu = qcu;
        question.setText(qcu.getNom());

        Iterator<String> iter = qcu.getReponses().getReponses();
        if(iter.hasNext())
        {
            RadioButton cb = new RadioButton();
            cb.setText(iter.next());
            reponseCont.getChildren().add(cb);
        }

        iter = qcu.getFauxReponses().getReponses();
        while(iter.hasNext())
        {
            RadioButton cb = new RadioButton();
            cb.setText(iter.next());
            reponseCont.getChildren().add(cb);
        }
    }

    public UniReponse getReponse()
    {
        UniReponse rep = null;
        for(Node c : reponseCont.getChildren())
        {
            RadioButton cb = (RadioButton)c;
            if(cb.isSelected()) rep = new UniReponse(cb.getText());
        }

        return rep;
    }

}

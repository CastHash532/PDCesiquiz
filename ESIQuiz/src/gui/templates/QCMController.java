package gui.templates;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import quiz.MultiReponse;
import quiz.QCM;

import java.util.Iterator;

public class QCMController {

    @FXML
    private Label question;

    @FXML
    private HBox reponseCont;

    private QCM qcm;

    public void setQCM(QCM qcm) {
        this.qcm = qcm;
        question.setText(qcm.getNom());

        Iterator<String> iter = qcm.getReponses().getReponses();
        while(iter.hasNext())
        {
            CheckBox cb = new CheckBox();
            cb.setText(iter.next());
            reponseCont.getChildren().add(cb);
        }

        iter = qcm.getFauxReponses().getReponses();
        while(iter.hasNext())
        {
            CheckBox cb = new CheckBox();
            cb.setText(iter.next());
            reponseCont.getChildren().add(cb);
        }
    }

    public MultiReponse getReponse()
    {
        MultiReponse rep = new MultiReponse();
        for(Node c : reponseCont.getChildren())
        {
            CheckBox cb = (CheckBox)c;
            if(cb.isSelected())
                rep.ajouterReponse(cb.getText());
        }

        if(rep.nbReponses() == 0)
            return null;

        return rep;
    }

}

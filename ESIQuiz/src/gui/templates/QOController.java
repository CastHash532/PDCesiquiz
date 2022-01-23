package gui.templates;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import quiz.QO;
import quiz.UniReponse;

public class QOController {

    @FXML
    private Label question;

    @FXML
    private TextField reponse;

    private QO qo;

    public void setQO(QO q)
    {
        qo = q;

        question.setText(qo.getNom());
    }

    public UniReponse getReponse()
    {
        return (!reponse.getText().isEmpty())? new UniReponse(reponse.getText()): null;
    }

}

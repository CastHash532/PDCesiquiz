package quiz;

import java.util.ArrayList;
import java.util.List;
import QCM.QCM;

public class QCMCreator extends QuestionCreator {

    public QCM createQuestion(String question, String[] propositions, int bonneReponse) {
        return new QCM(question, propositions, bonneReponse);
    }

}

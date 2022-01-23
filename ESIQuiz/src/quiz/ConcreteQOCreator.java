package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Serializable;
import QO.QO;

public QOCreator extends QuestionCreator {

    public QOC createQuestion(String question, String[] propositions, int bonneReponse) {
        return new QOC(question, propositions, bonneReponse);
    }

}

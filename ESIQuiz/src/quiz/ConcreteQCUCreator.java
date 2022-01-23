package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Serializable;
import question.Question;
import QCU.QCU;

public class ConcreteQCUCreator extends QuestionCreator {

    public QCU createQuestion(String question, String[] propositions, int bonneReponse) {
        return new QCU(question, propositions, bonneReponse);
    }

}
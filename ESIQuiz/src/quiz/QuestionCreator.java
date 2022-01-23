package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Serializable;
import question.Question;

public abstract class QuestionCreator implements Serializable {
    
    public abstract Question createQuestion(String question, String[] propositions, int bonneReponse);
    
}


package noyau;

public class QuizObserver implements Observer {
        
    private Quiz quiz;
    
    public QuizObserver(Quiz quiz) {
        this.quiz = quiz;
    }
    
    @Override
    public void update(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public Quiz getQuiz() {
        return quiz;
    }
    
    
}
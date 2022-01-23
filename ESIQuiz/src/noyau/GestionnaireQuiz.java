package noyau;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import quiz.Quiz;


public class GestionnaireQuiz {

    private Set<Quiz> quizs;

    public GestionnaireQuiz() {
        quizs = new HashSet<Quiz>();
    }

    public void ajouterQuiz(Quiz quiz) {
        quizs.add(quiz);
    }

    public void supprimerQuiz(Quiz quiz) {
        quizs.remove(quiz);
    }

    public Quiz getQuiz(String nom) {
        for(Quiz quiz : quizs) {
            if(quiz.getNom().equals(nom))
                return quiz;
        }
        return null;
    }

    public Set<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(Set<Quiz> quizs) {
        this.quizs = quizs;
    }

    public void ajouterReponse(Quiz quiz, Reponse reponse) {
        quiz.ajouterReponse(reponse);
    }

    public void supprimerReponse(Quiz quiz, Reponse reponse) {
        quiz.supprimerReponse(reponse);
    }

    public double getAvancementQuiz(Quiz quiz) {
        return quiz.getAvancementQuiz();
    }

    public Reponse getReponse(Quiz quiz, int numero) {
        return quiz.getReponse(numero);
    }

    public List<Reponse> getReponses(Quiz quiz) {
        return quiz.getReponses();
    }
    
    //gérer les notions 
    public void ajouterNotion(Notion notion) {
        quizs.forEach(quiz -> quiz.ajouterNotion(notion));
    }

    public void supprimerNotion(Notion notion) {
        quizs.forEach(quiz -> quiz.supprimerNotion(notion));
    }

    public Notion getNotion(String nom) {
        for(Quiz quiz : quizs) {
            Notion notion = quiz.getNotion(nom);
            if(notion != null)
                return notion;
        }
        return null;
    }

    public Set<Notion> getNotions() {
        Set<Notion> notions = new TreeSet<Notion>();
        for(Quiz quiz : quizs) {
            notions.addAll(quiz.getNotions());
        }
        return notions;
    }

    public void setNotions(Set<Notion> notions) {
        quizs.forEach(quiz -> quiz.setNotions(notions));
    }
}
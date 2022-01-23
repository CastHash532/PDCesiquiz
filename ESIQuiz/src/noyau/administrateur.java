package noyau;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

//classe qui herite de la classe Compte 
public class Administrateur extends Compte implements Serializable {
    
    private ESIQuiz quiz;

    //constructeur de la classe Administrateur
    public Administrateur(String nomUtilisateur, String motDePasse, ESIQuiz quiz) {
        super(nomUtilisateur, motDePasse);
        this.quiz = quiz;
    }
    
    //methode qui permet de creer un quiz
    public void creerQuiz(Quiz quiz) {
        this.quiz.ajouterQuiz(quiz);
    }

    //methode qui permet de supprimer un quiz
    public void supprimerQuiz(Quiz quiz) {
        this.quiz.supprimerQuiz(quiz);
    }

    //methode qui permet de recuperer un quiz
    public Quiz getQuiz(String nom) {
        return this.quiz.getQuiz(nom);
    }

    //methode qui permet de recuperer tous les quizs
    public Set<Quiz> getQuizs() {
        return this.quiz.getQuizs();
    }

    //methode qui permet de recuperer tous les quizs
    public void setQuizs(Set<Quiz> quizs) {
        this.quiz.setQuizs(quizs);
    }

    //methode qui permet d'ajouter une reponse a un quiz
    public void ajouterReponse(Quiz quiz, Reponse reponse) {
        this.quiz.ajouterReponse(quiz, reponse);
    }

    //methode qui permet de supprimer une reponse a un quiz
    public void supprimerReponse(Quiz quiz, Reponse reponse) {
        this.quiz.supprimerReponse(quiz, reponse);
    }

    //methode qui permet de recuperer l'avancement d'un quiz
    public double getAvancementQuiz(Quiz quiz) {
        return this.quiz.getAvancementQuiz(quiz);
    }

    //methode qui permet de recuperer une reponse a un quiz
    public Reponse getReponse(Quiz quiz, int numero) {
        return this.quiz.getReponse(quiz, numero);
    }

    //methode qui permet de recuperer toutes les reponses a un quiz
    public Set<Reponse> getReponses(Quiz quiz) {
        return this.quiz.getReponses(quiz);
    }

    //gérer les formateurs
    public void ajouterFormateur(Formateur formateur) {
        this.quiz.ajouterFormateur(formateur);
    }

    public void supprimerFormateur(Formateur formateur) {
        this.quiz.supprimerFormateur(formateur);
    }

    public Formateur getFormateur(String nom) {
        return this.quiz.getFormateur(nom);
    }

    public Set<Formateur> getFormateurs() {
        return this.quiz.getFormateurs();
    }

    public void setFormateurs(Set<Formateur> formateurs) {
        this.quiz.setFormateurs(formateurs);
    }

    //gérer les questions
    public void ajouterQuestion(Question question) {
        this.quiz.ajouterQuestion(question);
    }

    public void supprimerQuestion(Question question) {
        this.quiz.supprimerQuestion(question);
    }

    public Question getQuestion(String nom) {
        return this.quiz.getQuestion(nom);
    }

    public Set<Question> getQuestions() {
        return this.quiz.getQuestions();
    }

}


package noyau;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quiz.Reponse;

public class Apprenant extends Compte implements Comparable<Apprenant>, Serializable {

    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String adresse;

    private HashMap<Quiz, Reponse[]> reponses;

    private List<Quiz> quizAccomplis;

    public Apprenant(String nom, String prenom, LocalDate dateDeNaissance, String adresse) {
        super(prenom.substring(0,  1) + nom, prenom + dateDeNaissance.toString());
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateDeNaissance(dateDeNaissance);
        this.setAdresse(adresse);

        reponses = new HashMap<Quiz, Reponse[]>();
        quizAccomplis = new ArrayList<Quiz>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void ajouterReponses(Quiz quiz, Reponse[] reponses) {
        this.reponses.put(quiz, reponses);
    }

    public void modifierReponses(Quiz quiz, Reponse[] reponses) {
        this.reponses.replace(quiz, reponses);
    }

    public Reponse[] getAvancementQuiz(Quiz q) {
        return reponses.get(q);
    }

    public void setReponsesQuiz(Quiz q, Reponse[] reponses) {
        this.reponses.put(q, reponses);
    }

    public HashMap<Quiz, Reponse[]> getQuizNonAccomplis() {
        HashMap<Quiz, Reponse[]> qna = new HashMap<Quiz, Reponse[]>();

        for(Quiz q : reponses.keySet()) {
            if(!quizAccomplis.contains(q))
                qna.put(q, reponses.get(q));
        }

        return qna;
    }

    public HashMap<Quiz, Reponse[]> getQuizAccomplis() {
        HashMap<Quiz, Reponse[]> qna = new HashMap<Quiz, Reponse[]>();

        for(Quiz q : quizAccomplis) {
            qna.put(q, reponses.get(q));
        }

        return qna;
    }

    public void ajouterQuizAccompli(Quiz q) {
        this.quizAccomplis.add(q);
    }

    private double tauxReussiteMoyen(Apprenant a) {
        HashMap<Quiz, Reponse[]> reps = a.getQuizAccomplis();

        double moy = 0;

        for(Quiz q : reps.keySet())
        {
            moy += q.tauxDeReussite(a);
        }
        return moy/reps.keySet().size();
    }

    @Override
    public int compareTo(Apprenant arg0) {
        return Double.compare(tauxReussiteMoyen(this), tauxReussiteMoyen(arg0));
    }

    @Override
    public String toString() {
        return this.getNom() + " " + this.getPrenom();
    }

}

package noyau;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import quiz.Question;

public class Notion implements Serializable {


    private String nom;
    private Set<Question> questions;

    public Notion(String nom) {

        this.nom = nom;

        this.questions = new HashSet<Question>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean ajouterQuestion(Question q) {
        return questions.add(q);
    }

    public void supprimerQuestion(Question q) {
        questions.remove(q);
    }

    public int nbQuestions() {
        return questions.size();
    }

    public Question getQuestion(int id) throws IllegalArgumentException {
        if(id >= questions.size() || id < 0)
            throw new IllegalArgumentException();

        int i = 0;
        for(Question q : questions) {
            if(i == id)
                return q;
            i++;
        }

        return null;
    }

    public Iterator<Question> getQuestions() {
        return questions.iterator();
    }

    public boolean contient(Question q) {
        return questions.contains(q);
    }

    public boolean equals(Notion n) {
        if(!n.getNom().equals(nom))
            return false;

        Iterator<Question> iter = n.getQuestions();
        while(iter.hasNext()) {
            if(!questions.contains(iter.next()))
                return false;
        }
        return true;
    }

    public String toString() {
        return nom;
    }

}

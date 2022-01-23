package noyau;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import quiz.Question;
import quiz.Reponse;

public class Quiz implements Serializable {

    private HashSet<Question> questions;
    private HashSet<Notion> notions;

    private String nom;
    private LocalDate dateOuverture;
    private LocalDate dateExpiration;

    public Quiz(String nom, LocalDate dateOuverture, LocalDate dateExpiration, Notion[] notions, int[] nbQuestions) {
        this.setNom(nom);

        this.setDateOuverture(dateOuverture);

        this.setDateExpiration(dateExpiration);

        /********** il faut utiliser la classe Date pour faire **********/
        if(this.dateOuverture.compareTo(this.dateExpiration) >= 0)
            throw new IllegalArgumentException("la date d'ouverture doit être avant la date d'expiration.");

        this.notions = new HashSet<Notion>();
        this.notions.addAll(Arrays.asList(notions));

        questions = new HashSet<Question>();

        for(int i = 0; i < notions.length; i++) {
            Notion n = notions[i];
            int size = n.nbQuestions();
            if(size <= nbQuestions[i])     // ou ajoute tout les questions
            {
                Iterator<Question> iter = n.getQuestions();
                while(iter.hasNext())
                    questions.add(iter.next());
            } else {
                int j = 0;
                while(j < nbQuestions[i]) {
                    int id = (int) Math.floor(Math.random() * size);
                    if(questions.add(n.getQuestion(id)))
                        j++;
                }
            }

        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(LocalDate dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    /************* il faut utiliser des types Date pour utiliser ces m�thodes *************/
    public boolean estOuvert() {
        return dateOuverture.compareTo(LocalDate.now()) < 0
                && !expirer();
    }

    public boolean expirer() {
        return dateExpiration.compareTo(LocalDate.now()) < 0;
    }

    public Iterator<Question> getQuestions() {
        return questions.iterator();
    }

    public int getNbQuestions() {
        return questions.size();
    }

    public boolean ajouterQuestion(Question q) {
        return questions.add(q);
    }

    public Question ajouterQuestion(Notion n) {
        Iterator<Question> iter = n.getQuestions();
        while(iter.hasNext()) {
            Question q = iter.next();
            if(!questions.contains(q))
            {
                questions.add(q);
                return q;
            }
        }
        return null;
    }

    public boolean supprimerQuestion(Question q) {
        return questions.remove(q);
    }

    public boolean modifierQuestion(Question q) {
        for(Notion n : notions) {
            if(n.contient(q)) {
                if(ajouterQuestion(n) != null)
                {
                    return supprimerQuestion(q);
                } else
                    return false;
            }
        }
        return false;
    }

    public Iterator<Notion> getNotions() {
        return notions.iterator();
    }

    public int getNbNotions() {
        return notions.size();
    }

    public double TauxDaccomplissement(Apprenant a) {
        Reponse[] reponses = a.getAvancementQuiz(this);
        if(reponses.length != questions.size())
            throw new IllegalArgumentException("longueur des réponses et des questions ne sont pas égaux.");

        int taux = 0;
        for(Reponse r : reponses)
            if(r != null) {
                taux++;
            }

        return taux*100/questions.size();
    }

    public double tauxDeReussite(Apprenant a) {
        if(!a.getQuizAccomplis().containsKey(this))
            throw new IllegalArgumentException("cet apprenant n'a pas soumis cette quiz sous évaluation!");

        Reponse[] reponses = a.getAvancementQuiz(this);

        if(reponses.length != questions.size())
            throw new IllegalArgumentException("longueur des réponses et des questions ne sont pas égaux.");

        float taux = 0;
        int ind = 0;
        for(Question q : questions) {
            if(reponses[ind] != null)
                taux += q.evaluer(reponses[ind]);
            ind++;
        }

        return taux*100/questions.size();
    }

    public boolean equals(Quiz q) {
        if(q.getNom().equals(getNom())
                && q.getDateOuverture().equals(getDateOuverture())
                && q.getDateExpiration().equals(dateExpiration)
                && getNbQuestions() == q.getNbQuestions()
                && getNbNotions() == q.getNbNotions())
        {
            // voir si getQuestions() == q.getQuestions()
            Iterator<Question> iter = getQuestions();
            while(iter.hasNext())
            {
                boolean tr2 = false;
                Iterator<Question> iter2 = q.getQuestions();
                Question question = iter.next();
                while(iter2.hasNext())
                {
                    if(question.equals(iter2.next()))
                    {
                        tr2 = true;
                        break;
                    }
                }
                if(!tr2)
                    return false;
            }

            // voir si getNotions() == q.getNotions()
            Iterator<Notion> iter3 = getNotions();
            while(iter3.hasNext())
            {
                boolean tr2 = false;
                Iterator<Notion> iter2 = q.getNotions();
                Notion notion = iter3.next();
                while(iter2.hasNext())
                {
                    if(notion.equals(iter2.next()))
                    {
                        tr2 = true;
                        break;
                    }
                }
                if(!tr2)
                    return false;
            }
            return true;
        }

        return false;
    }

    public String toString()
    {
        return nom;
    }
}

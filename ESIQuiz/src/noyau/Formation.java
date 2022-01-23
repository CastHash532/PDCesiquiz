package noyau;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Formation implements Serializable {

    private String nom;
    private String description;
    private LocalDate debut;
    private LocalDate fin;

    private Set<Quiz> quizs;
    private Set<Notion> notions;
    private Set<Apprenant> apprenants;

    public Formation(String nom, String description, LocalDate debut, LocalDate fin) {
        if(debut.compareTo(fin) >= 0)
            throw new IllegalArgumentException("la date debut doit être inferieur à la date fin");

        this.setNom(nom);
        this.setDescription(description);
        this.setDebut(debut);
        this.setFin(fin);

        quizs = new HashSet<Quiz>();
        notions = new HashSet<Notion>();
        apprenants = new HashSet<Apprenant>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public boolean ajouterQuiz(Quiz q) {
        if(debut.compareTo(q.getDateOuverture()) > 0 || fin.compareTo(q.getDateExpiration()) < 0)
            throw new IllegalArgumentException("les dates de la quiz doit �tre entre les dates debut et fin de la formation.");

        return quizs.add(q);
    }

    public boolean supprimerQuiz(Quiz q) {
        return quizs.remove(q);
    }

    public Iterator<Quiz> getQuizs() {
        return quizs.iterator();
    }

    public boolean ajouterNotion(Notion n) {
        return notions.add(n);
    }

    public boolean supprimerNotion(Notion n) {
        return notions.remove(n);
    }

    public Iterator<Notion> getNotions() {
        return notions.iterator();
    }

    public boolean ajouterApprenant(Apprenant a) {
        return apprenants.add(a);
    }

    public boolean supprimerApprenant(Apprenant a) {
        return apprenants.remove(a);
    }

    public Iterator<Apprenant> getApprenants() {
        return apprenants.iterator();
    }

    public int getNombreApprenants() {
        return apprenants.size();
    }

    public Apprenant[] getTableauApprenants() {
        Apprenant[] app = new Apprenant[apprenants.size()];
        int i = 0;
        for(Apprenant a : apprenants) {
            app[i] = a;
            i++;
        }

        return app;
    }

    public boolean contient(Apprenant a) {
        return apprenants.contains(a);
    }

    public boolean equals(Formation f) {
        if(nom.equals(f.getNom()) && description.equals(f.getDescription()))
            return true;

        return false;
    }

    public boolean equals(String nom) {
        if(getNom().equals(nom))
            return true;

        return false;
    }

}

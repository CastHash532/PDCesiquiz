package quiz;

import java.io.Serializable;

public abstract class Question implements Evaluation, Serializable {

    private String nom;

    private MultiReponse reponses;

    public Question(String nom, MultiReponse reponses) {
        this.nom = nom;
        this.reponses = reponses;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public MultiReponse getReponses() {
        return reponses;
    }

    public void setReponses(MultiReponse reponse) {
        reponses = reponse;
    }

    public void ajouterReponse(String reponse) {
        reponses.ajouterReponse(reponse);
    }

    public void supprimerReponse(String reponse) {
        reponses.supprimerReponse(reponse);
    }

    public boolean equals(Question q) {
        if(nom.equals(q.getNom()) && reponses.equals(q.getReponses()))
            return true;

        return false;
    }

}

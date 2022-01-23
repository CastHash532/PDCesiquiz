package noyau;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class Formateur extends Compte implements Serializable {

    private Set<GestionnaireFormation> gestionnairesFormation;

    public Formateur(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void setFormation(Formation f) {
        this.gestionnairesFormation.add(new GestionnaireFormation(f));
    }

    public Formation getFormation() {
        return this.gestionnairesFormation.iterator().next().getFormation();
    }

    public void setGestionnairesFormation(Set<GestionnaireFormation> gestionnairesFormation) {
        this.gestionnairesFormation = gestionnairesFormation;
    }

    public Set<GestionnaireFormation> getGestionnairesFormation() {
        return this.gestionnairesFormation;
    }


    /*public boolean ajouterQuiz(Quiz q) {
        return formation.ajouterQuiz(q);
    }

    public boolean supprimerQuiz(Quiz q) {
        return formation.supprimerQuiz(q);
    }

    public boolean ajouterNotion(Notion n) {
        return formation.ajouterNotion(n);
    }

    public boolean supprimerNotion(Notion n) {
        return formation.supprimerNotion(n);
    }

    public boolean ajouterApprenant(Apprenant a) {
        return formation.ajouterApprenant(a);
    }

    public boolean supprimerApprenant(Apprenant a) {
        return formation.supprimerApprenant(a);
    }

    public Iterator<Apprenant> getApprenants(){
        return formation.getApprenants();
    }

    public Apprenant[] getClassementApprenant(){
        Apprenant[] app = formation.getTableauApprenants();
        Arrays.sort(app);
        return app;
    }*/

    public String toString() {
        return getNomUtilisateur();
    }

}

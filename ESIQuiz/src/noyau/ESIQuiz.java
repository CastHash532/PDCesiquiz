package noyau;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class ESIQuiz implements Serializable {

    private HashSet<Compte> comptes;

    public ESIQuiz() {
        comptes = new HashSet<Compte>();
    }

    public boolean ajouterCompte(Compte c) {
        return comptes.add(c);
    }

    public boolean supprimerCompte(Compte c) {
        return comptes.remove(c);
    }

    public boolean modifierCompte(Compte c, Compte c1) {
        if(comptes.contains(c))
        {
            comptes.remove(c);
            return comptes.add(c1);
        }
        return false;
    }

    public Iterator<Compte> getComptes() {
        return comptes.iterator();
    }

    public Iterator<Apprenant> getApprenants() {
        HashSet<Apprenant> set = new HashSet<Apprenant>();
        for(Compte a : comptes){
            if(a instanceof Apprenant)
                set.add((Apprenant)a);
        }
        return set.iterator();
    }

    public Iterator<Formateur> getFormateurs() {
        HashSet<Formateur> set = new HashSet<Formateur>();
        for(Compte a : comptes){
            if(a instanceof Formateur)
                set.add((Formateur)a);
        }
        return set.iterator();
    }

    public Compte authentifier(String nom, String pass) throws UserPassNotFoundException {
        for(Compte c : comptes) {
            if(c.getNomUtilisateur().equals(nom) && c.getMotDePasse().equals(pass))
                return c;
        }
        throw new UserPassNotFoundException("nom d'utilisateur ou mot de passe introuvable!");
    }

    public Iterator<Quiz> getQuizs(Apprenant a) {
        for(Compte c : comptes) {
            if(c instanceof Formateur) {
                Formateur f = (Formateur)c;
                if(f.getFormation() != null)
                    if(f.estDansFormation(a))
                        return f.getFormation().getQuizs();
            }
        }
        return null;
    }

}

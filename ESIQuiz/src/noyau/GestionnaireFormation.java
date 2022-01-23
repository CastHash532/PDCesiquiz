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
import Formation.Formation;

public class GestionnaireFormation {
    
    private Set<Formation> formations;

    private GestionnaireQuiz gestionnaireQuiz;
    
    public GestionnaireFormation() {
        formations = new HashSet<Formation>();
    }
    
    public void ajouterFormation(Formation formation) {
        formations.add(formation);
    }
    
    public void supprimerFormation(Formation formation) {
        formations.remove(formation);
    }
    
    public Formation getFormation(String nom) {
        for(Formation formation : formations) {
            if(formation.getNom().equals(nom))
                return formation;
        }
        return null;
    }
    
    public Set<Formation> getFormations() {
        return formations;
    }
    
    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    //gérer les apprenants
    public void ajouterApprenant(Apprenant apprenant) {
        for(Formation formation : formations) {
            formation.ajouterApprenant(apprenant);
        }
    }

    public void supprimerApprenant(Apprenant apprenant) {
        for(Formation formation : formations) {
            formation.supprimerApprenant(apprenant);
        }
    }

    public Set<Apprenant> getApprenants() {
        Set<Apprenant> apprenants = new TreeSet<Apprenant>();
        for(Formation formation : formations) {
            apprenants.addAll(formation.getApprenants());
        }
        return apprenants;
    }

    public Apprenant[] getClassementApprenant() {
        List<Apprenant> apprenants = new ArrayList<Apprenant>();
        for(Formation formation : formations) {
            apprenants.addAll(formation.getClassementApprenant());
        }
        return apprenants.toArray(new Apprenant[apprenants.size()]);
    }

}
    
    
package quiz;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiReponse extends Reponse implements Serializable {

    private Set<String> reponses;

    public MultiReponse() {
        reponses = new HashSet<String>();
    }

    public MultiReponse(String[] reponses) {
        this.reponses = new HashSet<String>();
        for(String s : reponses) {
            this.reponses.add(s);
        }
    }

    public Iterator<String> getReponses() {
        return reponses.iterator();
    }

    public void ajouterReponse(String reponse) {
        reponses.add(reponse);
    }

    public void supprimerReponse(String reponse) {
        reponses.remove(reponse);
    }

    public boolean contient(String reponse) {
        return reponses.contains(reponse);
    }

    public int nbReponses() {
        return reponses.size();
    }

    public boolean equals(MultiReponse mr) {
        Iterator<String> iter = mr.getReponses();
        while(iter.hasNext()) {
            if(!reponses.contains(iter.next()))
                return false;
        }
        return true;
    }

}

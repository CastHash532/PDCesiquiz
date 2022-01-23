package quiz;

import java.io.Serializable;

public abstract class QC extends Question implements Serializable {

    private MultiReponse fauxReponses;

    public QC(String nom, MultiReponse reponses, MultiReponse fauxReponses) {
        super(nom, reponses);
        this.fauxReponses = fauxReponses;
    }

    public MultiReponse getFauxReponses() {
        return fauxReponses;
    }

    public void setFauxReponses(MultiReponse fauxReponse) {
        fauxReponses = fauxReponse;
    }

    public void ajouterFauxReponse(String reponse) {
        fauxReponses.ajouterReponse(reponse);
    }

    public void supprimerFauxReponse(String reponse) {
        fauxReponses.supprimerReponse(reponse);
    }

}

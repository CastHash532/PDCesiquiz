package quiz;

import java.io.Serializable;
import java.util.Iterator;

public class QCM extends QC implements Serializable {

    public QCM(String nom, MultiReponse reponses, MultiReponse fauxReponses) {
        super(nom, reponses, fauxReponses);
    }

    @Override
    public float evaluer(Reponse r) {

        float score = 0;

        MultiReponse reponsesApprenant = (MultiReponse)r;
        MultiReponse reponsesJustes = getReponses();
        MultiReponse reponsesFausses = getFauxReponses();

        Iterator<String> iter = reponsesJustes.getReponses();
        while(iter.hasNext()) {
            if(reponsesApprenant.contient(iter.next()))
                score += 1;
            else
                score -= 1;
        }

        Iterator<String> iter2 = reponsesFausses.getReponses();
        while(iter2.hasNext())
        {
            if(reponsesApprenant.contient(iter2.next()))
                score -= 1;
            else
                score += 1;
        }

        return score / (reponsesJustes.nbReponses()+reponsesFausses.nbReponses());
    }

}

package quiz;

import java.io.Serializable;
import java.util.Iterator;

public class QCU extends QC implements Serializable {

    public QCU(String nom, MultiReponse reponses, MultiReponse fauxReponses) {
        super(nom, reponses, fauxReponses);
    }

    @Override
    public float evaluer(Reponse r) {

        UniReponse u = (UniReponse)r;

        MultiReponse m = getReponses();

        Iterator<String> iter = m.getReponses();
        while(iter.hasNext()) {
            if(u.getReponse().equals(iter.next()))
                return 1;
        }

        return 0;
    }

}

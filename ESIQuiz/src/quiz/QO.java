package quiz;

import java.io.Serializable;
import java.util.Iterator;

public class QO extends Question implements Serializable {

    public QO(String nom, MultiReponse reponses) {
        super(nom, reponses);
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

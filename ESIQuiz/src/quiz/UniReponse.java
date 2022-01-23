package quiz;

import java.io.Serializable;

public class UniReponse extends Reponse implements Serializable {

    private String reponse;

    public UniReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

}

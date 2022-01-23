package quiz;

import java.io.Serializable;

//classe qui herite de la classe Proposition et qui represente une reponse en image a une question
public class PropositionImage extends Proposition implements Serializable {

    //attributs
    private String image;

    //constructeur
    public PropositionImage(String texte, String image) {
        super(texte);
        this.setImage(image);
    }

    //getters et setters
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //methode qui retourne la reponse a la question
    public boolean estCorrecte() {
        return true;
    }

    //methode qui retourne la reponse a la question
    public boolean estFausse() {
        return false;
    }
}
package quiz;

//classe abstraite qui represente une proposition dans une question
public abstract class Proposition {
    
    //attributs
    private String texte;
    
    //constructeur
    public Proposition(String texte) {
        this.setTexte(texte);
    }
    
    //getters et setters
    public String getTexte() {
        return texte;
    }
    
    public void setTexte(String texte) {
        this.texte = texte;
    }
    
    //methode qui retourne la reponse a la question
    public abstract boolean estCorrecte(){
        return true;
    };
    
    //methode qui retourne la reponse a la question
    public abstract boolean estFausse(){
        return false;
    };
}
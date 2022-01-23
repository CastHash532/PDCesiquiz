package noyau;

import java.io.Serializable;

public abstract class Compte implements Serializable {

    private String nomUtilisateur;
    private String motDePasse;

    public Compte(String nomUtilisateur, String motDePasse) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean equals(Compte c) {
        if(nomUtilisateur.equals(c.getNomUtilisateur()))
            return true;

        return false;
    }

}

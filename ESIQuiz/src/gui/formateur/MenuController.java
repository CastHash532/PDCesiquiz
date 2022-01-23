package gui.formateur;

import gui.SeConnecterController;
import gui.Utility;
import gui.formateur.ProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import noyau.Apprenant;
import noyau.Compte;
import noyau.ESIQuiz;
import noyau.Formateur;

import javax.swing.*;
import java.io.IOException;
import java.util.Iterator;

public class MenuController {

    private ESIQuiz app;

    private Formateur current;

    @FXML
    private Label nomFormateur;

    public void initialiser(ESIQuiz app, Formateur connecte)
    {
        this.app = app;
        this.current = connecte;

        nomFormateur.setText(connecte.getNomUtilisateur());

        Iterator<Compte> iter = app.getComptes();
        while(iter.hasNext())
        {
            Compte c = iter.next();
            if(c instanceof Apprenant)
            {
                System.out.println(c.getNomUtilisateur() + " " + c.getMotDePasse());
            }
        }
    }

    @FXML
    void AfficherNotion(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherNotions.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherNotionsController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void afficherApprenant(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherApprenants.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherApprenantsController c = loader.getController();
            c.initialize(app, current, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void afficherComptesApprenant(ActionEvent event) throws FormationNotFoundException {

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherApprenants.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherApprenantsController c = loader.getController();
            c.initialize(app, current, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void afficherAvancementApprenant(ActionEvent event) {

    }

    @FXML
    void afficherComptes(ActionEvent event) throws FormationNotFoundException {

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherComptes.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherComptesController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void afficherQuiz(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "afficherQuizs.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AfficherQuizsController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ajouterApprenantFormation(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "ajouterApprenant.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AjouterApprenantController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ajouterNotion(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "ajouterNotion.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            AjouterNotionController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void creerApprenant(ActionEvent event) {

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "creerCompteApprenant.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            CreerApprenantController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void creerFormation(ActionEvent event) {
        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "creerFormation.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            CreerFormationController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genererQuiz(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "genererQuiz.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            GenererQuizController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void modifierApprenant(ActionEvent event) {

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "modifierApprenant.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            ModifierApprenantController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void modifierQuiz(ActionEvent event) {
        /*Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "modifierQuiz.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            ModifierQuizController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void modifierNotion()
    {

    }

    @FXML
    void supprimerApprenant(ActionEvent event) {

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "supprimerCompteApprenant.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            SupprimerCompteApprenantController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void supprimerApprenantFormation(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "supprimerApprenantFormation.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            SupprimerApprenantFormationController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void supprimerNotion(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "supprimerNotion.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            SupprimerNotionController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void supprimerQuiz(ActionEvent event) throws FormationNotFoundException {
        if(current.getFormation() == null)
            throw new FormationNotFoundException("il faut d'abord créer une formation.");

        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "supprimerQuiz.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            SupprimerQuizController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void modifierProfile(ActionEvent event) {
        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "profile.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            ProfileController c = loader.getController();
            c.initialize(app, current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deconnecter(ActionEvent event) {
        Stage s = Utility.getStage(nomFormateur);
        try {
            FXMLLoader loader = Utility.getLoader(this, "../SeConnecter.fxml");
            s.setScene(new Scene(loader.load(), 600, 400));

            SeConnecterController controller = loader.getController();
            controller.setQuiz(app);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void quitApplication(ActionEvent event) {
        Stage s = Utility.getStage(nomFormateur);
        s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

}

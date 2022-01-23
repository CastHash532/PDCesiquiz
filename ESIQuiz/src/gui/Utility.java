package gui;

import gui.templates.MessageBoxController;
import gui.templates.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Utility {

    public static Stage getStage(Control control)
    {
        return (Stage)control.getScene().getWindow();
    }

    public static FXMLLoader getLoader(Object classeCourante, String Path)
    {
        return new FXMLLoader(classeCourante.getClass().getResource(Path));
    }

    public static Parent getFXMLContainer(Object classeCourante, String path) throws IOException {
        return FXMLLoader.load(classeCourante.getClass().getResource(path));
    }

    public static boolean MessageBox(Object classe, String titre, String body, Type type)
    {
        MessageBoxController controller;
        try {
            FXMLLoader loader = getLoader(classe, "/gui/templates/messageBox.fxml");
            Stage s = new Stage();
            s.setScene(new Scene(loader.load(), 250, 170));
            s.initModality(Modality.APPLICATION_MODAL);
            s.setResizable(false);

            controller = loader.getController();
            controller.initialiser(titre, body, type);

            s.showAndWait();

            return controller.isOK;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}

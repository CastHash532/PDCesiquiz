package gui.templates;

import gui.Utility;
import gui.templates.Type;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

;

public class MessageBoxController {

    @FXML
    private Label title;

    @FXML
    private Label body;

    @FXML
    private Button cancel;

    @FXML
    private Button ok;

    public boolean isOK = false;

    public void initialiser(String title, String body, Type type) {
        this.title.setText(title);
        this.body.setText(body);

        switch (type) {
            case OK:
                cancel.setVisible(false);
                break;
            case CANCEL:
                ok.setVisible(false);
                break;
            case OK_CANCEL:
                break;

        }
    }

    @FXML
    void Cancel(ActionEvent event) {
        Stage s = Utility.getStage(title);
        s.close();
    }

    @FXML
    void OK(ActionEvent event) {
        Stage s = Utility.getStage(title);
        isOK = true;
        s.close();
    }

}

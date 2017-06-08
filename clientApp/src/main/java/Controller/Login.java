package Controller;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;


/**
 * Created by karoru on 16.05.17.
 */
public class Login {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox anonCheckBox;

    @FXML
    private void handleLoginButtonAction(ActionEvent evt) {
        if (!anonCheckBox.isSelected()) {
            Notifications.create().title("Test").text("Test Notification!").hideAfter(Duration.millis(1000)).showError();
            return;
        }
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("mainwindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Main Window");
            stage.setScene(new Scene(root, 800, 480));
            stage.show();
            ((Stage)((Node)(evt.getSource())).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent evt) {
        Stage stage = (Stage) ((Node)(evt.getSource())).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleSignupLabelAction(ActionEvent evt) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("signup.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root, 800, 480));
            stage.show();
            ((Stage)((Node)(evt.getSource())).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAnonCheckBoxAction(ActionEvent evt) {
        boolean disable = ((CheckBox)evt.getSource()).isSelected();
        passwordField.setDisable(disable);
        loginField.setDisable(disable);
    }
}

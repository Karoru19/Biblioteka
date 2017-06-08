package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by karoru on 16.05.17.
 */
public class Login {

    @FXML
    private void handleLoginButtonAction(ActionEvent evt) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("managment.fxml"));
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
    public void handleSignupButtonAction(ActionEvent evt) {
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
}

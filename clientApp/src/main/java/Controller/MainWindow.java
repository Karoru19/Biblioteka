package Controller;

import Helper.SessionHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.User;
import Controller.Login;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by karoru on 16.05.17.
 */
public class MainWindow implements Initializable {

    @FXML
    private Label userName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(SessionHelper.getCurrentUser().getName());
        userName.setText(SessionHelper.getCurrentUser().getName());
    }
}

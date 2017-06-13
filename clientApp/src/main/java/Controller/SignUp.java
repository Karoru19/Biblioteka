package Controller;

import Helper.*;
import ejb.UserBeanRemote;
import helpers.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import model.User;
import org.controlsfx.control.Notifications;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by karoru on 23.05.17.
 */
public class SignUp {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordConfirmationField;

    @FXML
    private void handleCancelButtonAction(ActionEvent evt) {
        Stage stage = (Stage) ((Node)(evt.getSource())).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleOkButtonAction(ActionEvent evt) throws NamingException {
        if (!passwordField.getText().equals(passwordConfirmationField.getText())) {
            Notifications.create().title("Error").text("Password doesn't match!").hideAfter(Duration.millis(5000)).showError();
            return;
        }
        else if (nameField.getText().equals("") || emailField.getText().equals("") || passwordField.equals("")) {
            Notifications.create().title("Error").text("Some fields is blank!").hideAfter(Duration.millis(5000)).showError();
            return;
        }

        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");

        InitialContext ic = new InitialContext(jndiProperties);

        UserBeanRemote ejb = (UserBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/UserBean!" + UserBeanRemote.class.getName());

        User user = new User(nameField.getText(), passwordField.getText(), emailField.getText(), UserType.USER);
        ejb.add(user);
        SessionHelper.setCurrentUser(user);

        Stage childStage = (Stage) ((Node)(evt.getSource())).getScene().getWindow();
        childStage.getOnCloseRequest().handle(new WindowEvent(childStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        Helper.MainWindow mainWindow = new Helper.MainWindow(evt);
    }
}

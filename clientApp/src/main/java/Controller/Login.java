package Controller;

import Helper.*;
import Helper.MainWindow;
import ejb.BookBean;
import ejb.UserBeanRemote;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import model.Book;
import model.User;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
    private void handleLoginButtonAction(ActionEvent evt) throws NamingException {
        if (!anonCheckBox.isSelected()) {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");

            InitialContext ic = new InitialContext(jndiProperties);
            String login = loginField.getText();
            String passwd = passwordField.getText();

            UserBeanRemote ejb = (UserBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/UserBean!" + UserBeanRemote.class.getName());
            System.out.println(login +" " + passwd);
            System.out.println(ejb.authenticate(login, passwd));
            for (User u : ejb.findAll() ) {
                System.out.println(u.getName());
            }
            if(!ejb.authenticate(login, passwd)){
                Notifications.create().title("Error").text("Login or Password is incorrect!").hideAfter(Duration.millis(5000)).showError();
                return;
            }
            else {
                User user = ejb.findByName(login);
                SessionHelper.setCurrentUser(user);
            }
        }
        Helper.MainWindow mainWindow = new Helper.MainWindow(evt);
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent evt) {
        Stage stage = (Stage) ((Node)(evt.getSource())).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleSignupLinkAction(ActionEvent evt) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("signup.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root, 262, 266));
            stage.setResizable(false);
            stage.initOwner(((Node)(evt.getSource())).getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(event -> ((Stage)((Node)(evt.getSource())).getScene().getWindow()).close());
            stage.showAndWait();
            //((Stage)((Node)(evt.getSource())).getScene().getWindow()).close();
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

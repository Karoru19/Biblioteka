package Controller;

import Helper.SessionHelper;
import ejb.BookBeanRemote;
import helpers.UserType;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.ResourceBundle;


/**
 * Created by karoru on 16.05.17.
 */
public class MainWindow implements Initializable {

    private ObservableList<Book> data;

    @FXML private TextField userName;
    @FXML private TextField userEmail;
    @FXML private PasswordField userPassword;
    @FXML private TextField search;

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> titleCol;
    @FXML private TableColumn<Book, String> authorCol;
    @FXML private TableColumn<Book, Long> isbnCol;
    @FXML private TableColumn<Book, Integer> editionCol;
    @FXML private TableColumn<Book, String> publisherCol;
    @FXML private TableColumn<Book, Integer> dateTableColumn;

    @FXML private TabPane tabPane;
    @FXML private Tab managment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");

        InitialContext ic = null;
        try {
            ic = new InitialContext(jndiProperties);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        BookBeanRemote ejbBook = null;
        try {
            ejbBook = (BookBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/BookBean!" + BookBeanRemote.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }

        setData(FXCollections.observableArrayList(ejbBook.findAll()));

        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<Book,Long>("isbn"));
        editionCol.setCellValueFactory(new PropertyValueFactory<Book,Integer>("edition"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("dateOfPublication"));

        tableView.setItems(data);

        System.out.println(SessionHelper.getCurrentUser().getEmail());
        userName.setText(SessionHelper.getCurrentUser().getName());
        userEmail.setText(SessionHelper.getCurrentUser().getEmail());
        userPassword.setText(SessionHelper.getCurrentUser().getPassword());
        userName.setEditable(false);
        userEmail.setEditable(false);
        userPassword.setEditable(false);
        if(SessionHelper.getCurrentUser().getType() != UserType.ADMIN) tabPane.getTabs().remove(3);
        if(SessionHelper.getCurrentUser().getType() == UserType.ANON) {
            tabPane.getTabs().get(2).setDisable(true);
            tabPane.getTabs().get(1).setDisable(true);
        }

    }

    public void handleSeaarch(ActionEvent evt) {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");

        InitialContext ic = null;
        try {
            ic = new InitialContext(jndiProperties);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        BookBeanRemote ejbBook = null;
        try {
            ejbBook = (BookBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/BookBean!" + BookBeanRemote.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }

        setData(FXCollections.observableArrayList(ejbBook.findByTitleOrAuthor(search.getText())));

        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<Book,Long>("isbn"));
        editionCol.setCellValueFactory(new PropertyValueFactory<Book,Integer>("edition"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("dateOfPublication"));

        tableView.setItems(data);
    }

    public void setData(ObservableList<Book> data) {
        this.data = data;
    }
}

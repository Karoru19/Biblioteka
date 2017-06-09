import View.Login;
import ejb.BookBean;
import ejb.BookBeanRemote;
import ejb.BookDao;
import javafx.application.Application;
import model.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by karoru on 08.06.17.
 */
public class Main  {
    public static void main(String[] args) throws NamingException {

        System.out.println("Initializing remote EJB bean...");
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");
        //jndiProperties.put("jboss.naming.client.ejb.context", true);

        InitialContext ic = new InitialContext(jndiProperties);

        BookBeanRemote ejb = (BookBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/BookBean!" + BookBeanRemote.class.getName());
        Book book = new Book("Lol", "XD", 1, (long) 1923, new Date(), "Jakis rak");
        ejb.save(book);
        System.out.println(book.getTitle());
        ejb.remove(ejb.getIdByISBN(book.getISBN()));
        Application.launch(Login.class, args);
    }
}

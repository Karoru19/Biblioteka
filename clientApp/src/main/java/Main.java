import Helper.SessionHelper;
import View.Login;
import ejb.BookBean;
import ejb.BookBeanRemote;
import ejb.BookDao;
import ejb.UserBeanRemote;
import helpers.UserType;
import javafx.application.Application;
import model.Book;
import model.User;

import javax.jws.soap.SOAPBinding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by karoru on 08.06.17.
 */
public class Main  {
    public static void main(String[] args) throws NamingException, ParseException {

        System.out.println("Initializing remote EJB bean...");
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.wildfly.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");

        InitialContext ic = new InitialContext(jndiProperties);

        BookBeanRemote ejbBook = (BookBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/BookBean!" + BookBeanRemote.class.getName());

//        for (Integer i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
//            ejbBook.save(new Book("Book"+i, "Author"+i, i, (long) (1000*i), 1996, "Publisher"+i));

        UserBeanRemote ejbUser = (UserBeanRemote) ic.lookup("ejb:client-ear-1.0-SNAPSHOT/client-ejb-1.0-SNAPSHOT/UserBean!" + UserBeanRemote.class.getName());
//        ejbUser.add(new User("user", "user", "user@library.edu.org", UserType.USER));
//        ejbUser.add(new User("admin", "admin", "admin@library.edu.org", UserType.ADMIN));
        List<User> list = ejbUser.findAll();
        for (User u : list) {
            System.out.println(u.getName());
        }
        SessionHelper.setCurrentUser(new User("Anonymous", "", "Brak", UserType.ANON));
        Application.launch(Login.class, args);
    }
}

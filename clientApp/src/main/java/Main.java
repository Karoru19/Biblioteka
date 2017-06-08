import View.Login;
import ejb.BookBean;
import ejb.BookDao;
import helpers.SendRequest;
import javafx.application.Application;
import model.Book;

import java.util.Date;

/**
 * Created by karoru on 08.06.17.
 */
public class Main  {
    public static void main(String[] args) {

        BookDao bookBean = new BookDao();
        Book book = new Book("Lol", "XD", 1, new Date(), "Jakis rak");
        bookBean.save(book);
        bookBean.remove(book.getId());
        Application.launch(Login.class, args);
    }
}

package ejb;

import model.Book;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Remote
public interface BookBeanRemote {
    void save(Book book);
    List<Book> findAll();
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    Long getIdByIsbn (Long isbn);
    List<Book> findByTitleOrAuthor(String value);
    void remove(Long id);
}

package ejb;

import model.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class BookBean implements BookBeanRemote{

    @EJB
    private BookDao bookDao;

    @Override
    public void save(Book book) { bookDao.save(book); }

    @Override
    public List<Book> findAll() { return bookDao.findAll(); }

    @Override
    public List<Book> findByTitle(String title) { return bookDao.findByTitle(title); }

    @Override
    public List<Book> findByAuthor(String author) { return bookDao.findByAuthor(author); }

    @Override
    public Long getIdByIsbn(Long isbn) { return bookDao.getIdByIsbn(isbn); }

    @Override
    public List<Book> findByTitleOrAuthor(String value) { return bookDao.findByTitleOrAuthor(value); }

    @Override
    public void remove(Long id) { bookDao.remove(id); }
}

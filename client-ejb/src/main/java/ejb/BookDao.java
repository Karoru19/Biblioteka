package ejb;

import model.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class BookDao {
    private EntityManager em;

    public void save(Book book) { em.persist(book); }

    public List<Book> findAll() {
        TypedQuery<Book> query = em.createNamedQuery(Book.findAll, Book.class);
        return query.getResultList();
    }

    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = em.createNamedQuery(Book.findByTitle, Book.class);
        query.setParameter(1, title);
        return query.getResultList();
    }

    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = em.createNamedQuery(Book.findByAuthor, Book.class);
        query.setParameter(1, author);
        return query.getResultList();
    }

    public void remove(Long id) { em.remove(em.getReference(Book.class, id)); }
}

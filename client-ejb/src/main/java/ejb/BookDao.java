package ejb;

import model.Book;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@DataSourceDefinition(
        name = "java:jboss/datasources/BibliotekaDS",
        className = "org.postgresql.xa.PGXADataSource",
        user = "postgres",
        password = "postgres",
        serverName = "localhost",
        portNumber = 5432,
        databaseName = "test",
        minPoolSize = 10,
        maxPoolSize = 50
)

@Stateless
public class BookDao {
    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    public void save(Book book) { em.persist(book);  }

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

    public Long getIdByISBN(Long isbn) {
        TypedQuery<Long> query = em.createNamedQuery(Book.getIdByISBN, Long.class);
        query.setParameter(1, isbn);
        return query.getSingleResult();
    }

    public void remove(Long id) { em.remove(em.getReference(Book.class, id)); }


}

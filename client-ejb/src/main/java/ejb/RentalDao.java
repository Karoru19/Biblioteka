package ejb;

import model.Book;
import model.Rental;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class RentalDao {
    private EntityManager em;

    public void save(Rental rental) { em.persist(rental); }

    public List<Rental> findAll() {
        TypedQuery<Rental> query = em.createNamedQuery(Rental.findAll, Rental.class);
        return query.getResultList();
    }

    public List<Rental> findByBook(Book book) {
        TypedQuery<Rental> query = em.createNamedQuery(Rental.findByBook, Rental.class);
        query.setParameter(1, book);
        return query.getResultList();
    }

    public List<Rental> findByRentDate(Date date) {
        TypedQuery<Rental> query = em.createNamedQuery(Rental.findByRentDate, Rental.class);
        query.setParameter(1, date);
        return query.getResultList();
    }

    public List<Rental> findByReturnDate(Date date) {
        TypedQuery<Rental> query = em.createNamedQuery(Rental.findByReturnDate, Rental.class);
        query.setParameter(1, date);
        return query.getResultList();
    }

    public void remove(Long id) { em.remove(em.getReference(Rental.class, id)); }
}

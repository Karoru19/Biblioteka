package ejb;

import model.Rental;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class RentalDao {
    private EntityManager em;

    public void save(Rental rental) { em.persist(rental); }
    public void remove(Long id) { em.remove(em.getReference(Rental.class, id)); }
}

package ejb;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class UserDao {
    private EntityManager em;

    public void save(User user) { em.persist(user); }
    public void remove(Long id) { em.remove(em.getReference(User.class, id)); }
}

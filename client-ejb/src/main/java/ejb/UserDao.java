package ejb;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class UserDao {
    @PersistenceContext(name = "PU")
    private EntityManager em;

    public void add(User user) { em.persist(user); }
    public void remove(Long id) { em.remove(em.getReference(User.class, id)); }
    public void update(User user) { }

    public boolean authenticate(String login, String passwd){ /* niewiem xd */
        Query query = em.createNamedQuery(User.authenticate);
        query.setParameter(1, login);
        query.setParameter(2, passwd);
        return !query.getResultList().isEmpty();
    }
    public boolean isAdmin(String login){
        return false;
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery(User.findAll, User.class);
        return query.getResultList();
    }

    public User findByName(String name) {
        TypedQuery<User> query = em.createNamedQuery(User.findByName, User.class);
        query.setParameter(1, name);
        return query.getSingleResult();
    }

    public List<User> findAllWithBooks() {/*znajduje tych co majo coś wypożyczone ;u */
        return null;
    }


}

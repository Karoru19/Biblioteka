package ejb;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class UserDao {
    private EntityManager em;

    public void add(User user) { em.persist(user); }
    public void remove(Long id) { em.remove(em.getReference(User.class, id)); }
    public void update(User user) { }

    public boolean authenticate(String login, String passwd){ /* niewiem xd */
        return false;
    }
    public boolean isAdmin(String login){
        return false;
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery(User.findAll, User.class);
        return query.getResultList();
    }

    public List<User> findAllWithBooks() {/*znajduje tych co majo coś wypożyczone ;u */
        return null;
    }


}

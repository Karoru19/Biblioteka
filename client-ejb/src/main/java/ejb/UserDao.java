package ejb;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public boolean authenticate(String name, String passwd){
        Query query = em.createNamedQuery(User.authenticate);
        return !query.getResultList().isEmpty();
    }
    public boolean isAdmin(String name){
        Long id = getId(name);
        Query query = em.createNamedQuery(User.isAdmin);
        query.setParameter(1, id);
        return !query.getResultList().isEmpty();
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery(User.findAll, User.class);
        return query.getResultList();
    }

    public List<User> findAllWithBooks() {
        TypedQuery<User> query = em.createNamedQuery(User.findAllWithBooks, User.class);
        return query.getResultList();
    }

    public Long getId(String name){
        Query query = em.createNamedQuery(User.getId);
        return Long.parseLong(query.getSingleResult().toString());
    }

    public boolean exists(String name){
        Query query = em.createNamedQuery(User.getId);
        return !query.getResultList().isEmpty();
    }

}

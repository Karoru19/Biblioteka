package ejb;

import model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class UserBean implements UserBeanRemote {

    @EJB
    private UserDao userDao;

    @Override
    public void add(User user) { userDao.add(user); }

    @Override
    public void remove(Long id) { userDao.remove(id); }

    @Override
    public void update(User user) { userDao.update(user); }

    @Override
    public boolean authenticate(String login, String passwd) { return userDao.authenticate(login, passwd); }

    @Override
    public boolean isAdmin(String login) { return userDao.isAdmin(login); }

    @Override
    public List<User> findAll() { return userDao.findAll(); }

    @Override
    public List<User> findAllWithBooks() { return userDao.findAllWithBooks(); }
}

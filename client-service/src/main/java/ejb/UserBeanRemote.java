package ejb;

import model.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Remote
public interface UserBeanRemote {
    void add(User user);
    void remove(Long id);
    void update(User user);

    boolean authenticate(String login, String passwd);
    boolean isAdmin(String login);

    List<User> findAll();

    List<User> findAllWithBooks();
}

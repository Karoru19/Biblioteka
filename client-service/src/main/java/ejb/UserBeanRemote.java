package ejb;

import model.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Remote
public interface UserBeanRemote {
    void save(User user);
    List<User> findAll();
    boolean checkPassword(User user);
    void remove(Long id);
}

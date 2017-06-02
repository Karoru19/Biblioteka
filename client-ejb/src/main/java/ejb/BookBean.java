package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class BookBean implements BookBeanRemote{

    @EJB
    private BookDao bookDao;
}

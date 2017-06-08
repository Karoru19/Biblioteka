package ejb;

import model.Book;
import model.Rental;

import javax.ejb.Remote;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Remote
public interface RentalBeanRemote {
    public void save(Rental rental);
    public List<Rental> findAll();
    public List<Rental> findByBook(Book book);
    public List<Rental> findByRentDate(Date date);
    public List<Rental> findByReturnDate(Date date);
    public void remove(Long id);
}

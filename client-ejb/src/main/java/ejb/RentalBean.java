package ejb;

import model.Book;
import model.Rental;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/**
 * Created by karoru on 02.06.17.
 */
@Stateless
public class RentalBean implements RentalBeanRemote {

    @EJB
    private RentalDao rentalDao;

    @Override
    public void save(Rental rental) { rentalDao.save(rental); }

    @Override
    public List<Rental> findAll() { return rentalDao.findAll(); }

    @Override
    public List<Rental> findByBook(Book book) { return rentalDao.findByBook(book); }

    @Override
    public List<Rental> findByRentDate(Date date) { return rentalDao.findByRentDate(date); }

    @Override
    public List<Rental> findByReturnDate(Date date) { return rentalDao.findByReturnDate(date); }

    @Override
    public void remove(Long id) { rentalDao.remove(id); }
}

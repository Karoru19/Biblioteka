package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Rental.findAll", query = "select r from Rental r"),
        @NamedQuery(name = "Rental.findByBook", query = "select r from Rental r where r.book=?1"),
        @NamedQuery(name = "Rental.findByRentDate", query = "select r from Rental r where r.rentDate=?1"),
        @NamedQuery(name = "Rental.findByReturnDate", query = "select r from Rental r where r.returnDate=?1")
})

public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private Date rentDate;
    private Date returnDate;

    public static final String findAll = "Rental.findAll";
    public static final String findByBook = "Rental.findByBook";
    public static final String findByRentDate = "Rental.findByRentDate";
    public static final String findByReturnDate = "Rental.findByReturnDate";
}

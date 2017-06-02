package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
public class Rental implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private Date rentDate;
    private Date returnDate;
}

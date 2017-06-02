package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.findByTitle", query = "select b from Book b where b.name=?1"),
        @NamedQuery(name = "Book.findByAuthor", query = "select b from Book b where b.author=?1")
})
public class Book implements Serializable {
    @Id
    private Long id;
    private String title;
    private String author;
    private Integer edition;
    private Date dateOfPublication;
    private String publisher;

    public static final String findAll = "Book.findAll";
    public static final String findByTitle = "Book.findByTitle";
    public static final String findByAuthor = "Book.findByAuthor";

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Integer getEdition() { return edition; }

    public void setEdition(Integer edition) { this.edition = edition; }

    public Date getDateOfPublication() { return dateOfPublication; }

    public void setDateOfPublication(Date dateOfPublication) { this.dateOfPublication = dateOfPublication; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
}

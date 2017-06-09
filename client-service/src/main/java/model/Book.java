package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.getIdByISBN", query = "select b.id from Book b where b.ISBN = ?1"),
        @NamedQuery(name = "Book.findByTitle", query = "select b from Book b where b.title=?1"),
        @NamedQuery(name = "Book.findByAuthor", query = "select b from Book b where b.author=?1")
})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long ISBN;
    private Integer edition;
    private Date dateOfPublication;
    private String publisher;

    private static final long serialVersionUID = -558553967080513790L;

    public static final String findAll = "Book.findAll";
    public static final String findByTitle = "Book.findByTitle";
    public static final String findByAuthor = "Book.findByAuthor";
    public static final String getIdByISBN = "Book.getIdByISBN";

    public Book() {  }

    public Book(String title, String author, Integer edition, Long ISBN,  Date dateOfPublication, String publisher) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.ISBN = ISBN;
        this.dateOfPublication = dateOfPublication;
        this.publisher = publisher;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Long getISBN() { return ISBN; }

    public void setISBN(Long ISBN) { this.ISBN = ISBN; }

    public Integer getEdition() { return edition; }

    public void setEdition(Integer edition) { this.edition = edition; }

    public Date getDateOfPublication() { return dateOfPublication; }

    public void setDateOfPublication(Date dateOfPublication) { this.dateOfPublication = dateOfPublication; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
}

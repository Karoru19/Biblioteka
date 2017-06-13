package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.getIdByIsbn", query = "select b.id from Book b where b.isbn = ?1"),
        @NamedQuery(name = "Book.findByTitle", query = "select b from Book b where b.title like ?1"),
        @NamedQuery(name = "Book.findByAuthor", query = "select b from Book b where b.author like ?1"),
        @NamedQuery(name = "Book.findByTitleOrAuthor", query = "select b from Book b where upper(b.author) like upper(?1) or upper(b.title) like upper(?2)")
})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long isbn;
    private Integer edition;
    private Integer dateOfPublication;
    private String publisher;

    private static final long serialVersionUID = -558553967080513790L;

    public static final String findAll = "Book.findAll";
    public static final String findByTitle = "Book.findByTitle";
    public static final String findByAuthor = "Book.findByAuthor";
    public static final String getIdByIsbn = "Book.getIdByIsbn";
    public static final String findByTitleOrAuthor = "Book.findByTitleOrAuthor";

    public Book() {  }

    public Book(String title, String author, Integer edition, Long isbn,  Integer dateOfPublication, String publisher) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.dateOfPublication = dateOfPublication;
        this.publisher = publisher;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Long getIsbn() { return isbn; }

    public void setIsbn(Long isbn) { this.isbn = isbn; }

    public Integer getEdition() { return edition; }

    public void setEdition(Integer edition) { this.edition = edition; }

    public Integer getDateOfPublication() { return dateOfPublication; }

    public void setDateOfPublication(Integer dateOfPublication) { this.dateOfPublication = dateOfPublication; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
}

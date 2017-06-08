package model;

import helpers.UserType;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "User.exists", query = "select u from User u where u.name = ?1"),
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.findAllWithBooks", query = "select u from User u" +
                " where exists (select 1 from Rental r where r.user = u" +
                "and r.returnDate > ?1 )"),
        @NamedQuery(name = "User.getId", query = "select u.id from User u where u.name = ?1"),
        @NamedQuery(name = "User.isAdmin", query = "select u from User u" +
                "where u.id = ?1 and u.UserType = ADMIN"),
        @NamedQuery(name = "User.authenticate", query = "select u from User u" +
                "where u.name = ?1 and u.password = ?2")
})
public class User implements Serializable {
    @Id
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public static final String findAll = "User.findAll";
    public static final String findAllWithBooks = "User.findAllWithBooks";
    public static final String isAdmin = "User.isAdmin";
    public static final String getId = "User.getId";
    public static final String authenticate = "User.authenticate";
}

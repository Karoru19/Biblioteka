package model;

import helpers.UserType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public static final String findAll = "User.findAll";
}

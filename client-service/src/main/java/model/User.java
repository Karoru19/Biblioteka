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
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public static final String findAll = "User.findAll";
}

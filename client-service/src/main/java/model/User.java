package model;

import helpers.UserType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
@Table (name = "People")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.authenticate", query = "select u from User u where u.name = ?1 and u.password = ?2"),
        @NamedQuery(name = "User.findByName", query = "select u from User u where u.name = ?1")
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
    private Integer type;

    private static final long serialVersionUID = -558987967080513790L;

    public static final String findAll = "User.findAll";
    public static final String authenticate = "User.authenticate";
    public static final String findByName = "User.findByName";

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {  }

    public User(String name, String password, String email, Integer type) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

}

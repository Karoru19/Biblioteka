package model;

import helpers.UserType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by karoru on 02.06.17.
 */
@Entity
public class User implements Serializable {
    @Id
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType type;
}

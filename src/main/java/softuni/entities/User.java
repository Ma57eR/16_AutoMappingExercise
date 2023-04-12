package softuni.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private boolean admin;

    @ManyToMany
    private Set<Game> games;

    @OneToMany(targetEntity = Order.class, mappedBy = "buyer")
    private Set<Order> orders;


}

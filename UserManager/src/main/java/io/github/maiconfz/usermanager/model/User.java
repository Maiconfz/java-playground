package io.github.maiconfz.usermanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private final Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private final String userName;

    @Column(name = "PASSWORD", nullable = false)
    private final String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private final List<UserEmail> emails;
}

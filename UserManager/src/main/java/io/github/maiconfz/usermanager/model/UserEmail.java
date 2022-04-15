package io.github.maiconfz.usermanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_EMAIL")
@Data
public class UserEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private final Long id;

    @Column(name = "EMAIL", nullable = false)
    private final String email;

    @Column(name = "IS_MAIN")
    private final Boolean main;

    @Column(name = "IS_CONFIRMED")
    private final Boolean confirmed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private final User user;


}

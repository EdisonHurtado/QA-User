package com.user.qauser.domain;

import com.user.qauser.Domain.Hobby;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_user", columnDefinition = "uuid", updatable = false)
    private UUID idUser;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "date_registered")
    private Instant dateRegistered = Instant.now();

    private String status = "active";

    @Column(name = "last_connection")
    private Instant lastConnection;

    @ManyToMany
    @JoinTable(
            name = "users_hobbies",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_hobby")
    )
    private Set<Hobby> hobbies = new HashSet<>();
}

package com.user.qauser.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "hobbies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_hobby", columnDefinition = "uuid", updatable = false)
    private UUID idHobby;

    @Column(name = "hobby_name", unique = true)
    private String hobbyName;

    private String description;

    @ManyToMany(mappedBy = "hobbies")
    private Set<com.user.qauser.domain.User> users = new HashSet<>();
}

package com.example.musicschoolmanager.model.abstracts;

import com.example.musicschoolmanager.model.attribute.ContactData;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String PESEL;
    @Embedded
    private ContactData contactData;

}

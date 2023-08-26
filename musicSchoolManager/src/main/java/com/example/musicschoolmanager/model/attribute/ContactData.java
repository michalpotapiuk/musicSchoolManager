package com.example.musicschoolmanager.model.attribute;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Embeddable
public class ContactData {

    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
}

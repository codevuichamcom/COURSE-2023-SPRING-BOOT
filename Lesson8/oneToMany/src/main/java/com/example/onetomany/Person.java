package com.example.onetomany;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int age;
    String email;
    String firstName;
    String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    Address address;

}

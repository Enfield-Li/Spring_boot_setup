package com.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Person")
@Table(
    name = "person",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "person_email_unique")
    }
)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(
        name = "first_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String email;

    @Column(
        name = "age",
        nullable = true
    )
    private Integer age;
}

package com.money;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.person.Person;

@Entity(name = "Money")
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public Money(Integer amount, Person person) {
        this.amount = amount;
        this.person = person;
    }

}

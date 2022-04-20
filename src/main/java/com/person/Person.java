package com.person;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.money.Money;

@Entity(name = "Person")
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany( mappedBy = "person", cascade = CascadeType.ALL)
    private List<Money> moneys = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Money> getMoneys() {
        return this.moneys;
    }

    public void setMoneys(List<Money> moneys) {
        this.moneys = moneys;
    }

}

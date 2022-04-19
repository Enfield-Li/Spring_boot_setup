package com.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.owner.Owner;


@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    
    @OneToOne(mappedBy = "car")
    private Owner owner;

    public Car() {
    }

    public Car(String model, Owner owner) {
        this.model = model;
        this.owner = owner;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", model='" + getModel() + "'" +
            ", owner='" + getOwner() + "'" +
            "}";
    }

}

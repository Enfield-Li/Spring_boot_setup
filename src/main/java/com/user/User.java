package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.address.Address;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    // @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public User() {
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

}

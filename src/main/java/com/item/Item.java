package com.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cart.Cart;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "\"serialNum\"")
    private String serialNum;

    @ManyToOne
    @JoinColumn(name = "\"cartId\"") // Skippable
    private Cart cart;

    public Item(String serialNum, Cart cart) {
        this.serialNum = serialNum;
        this.cart = cart;
    }

}

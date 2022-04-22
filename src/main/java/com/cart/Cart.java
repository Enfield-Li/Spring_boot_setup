package com.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @JsonIgnore
  @OneToMany(
    mappedBy = "cart", // Owner table reference
    cascade = CascadeType.ALL, // Cascade save
    orphanRemoval = true,
    fetch = FetchType.LAZY
  )
  private List<Item> items = new ArrayList<>();

  public Cart() {}

  public Cart(String name, List<Item> items) {
    this.name = name;
    this.items = items;
  }

  public Cart(String name) {
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

  public List<Item> getItems() {
    return this.items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}

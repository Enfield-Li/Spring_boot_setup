package com.cart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cart")
public class CartController {

  private final CartRepository cartRepository;

  @Autowired
  public CartController(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @GetMapping
  public List<Cart> getAll() {
    return cartRepository.findAll();
  }
}

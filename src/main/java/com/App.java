package com;

import com.cart.Cart;
import com.cart.CartRepository;
import com.item.Item;
import com.item.ItemRepository;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );

    CartRepository cartRepo = configContext.getBean(CartRepository.class);
    ItemRepository itemRepo = configContext.getBean(ItemRepository.class);

    Cart newCart = new Cart("One big cart");
    Cart newCart2 = new Cart("anthoer cart");
    Cart newCart3 = new Cart("anthoer cart 3");

    Item newItem1 = new Item("item1", newCart);
    Item newItem2 = new Item("item2", newCart);
    Item newItem4 = new Item("item4", newCart);
    Item newItem5 = new Item("item5", newCart);
    Item newItem6 = new Item("item6", newCart);

    Item newItem3 = new Item("item3", newCart2);

    List<Item> items = Arrays.asList(newItem1, newItem2, newItem4, newItem5);
    newCart.setItems(items);

    List<Item> items2 = Arrays.asList(newItem3);
	newCart2.setItems(items2);

	List<Item> items3 = Arrays.asList(newItem6);
	newCart3.setItems(items3);

    cartRepo.save(newCart);
    cartRepo.save(newCart2);
  }
}

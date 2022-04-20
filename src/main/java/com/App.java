package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.cart.Cart;
import com.cart.CartRepository;
import com.item.Item;
import com.item.ItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		CartRepository cartRepo = configContext.getBean(CartRepository.class);
		ItemRepository itemRepo = configContext.getBean(ItemRepository.class);

		Cart newCart = new Cart("One big cart");
		Item newItem1 = new Item("item1", newCart);
		Item newItem2 = new Item("item2", newCart);

		List<Item> items = Arrays.asList(newItem1, newItem2);
		newCart.setItems(items);

		cartRepo.save(newCart);

	}
}

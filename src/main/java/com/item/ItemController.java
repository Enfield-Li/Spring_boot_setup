package com.item;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "item")
public class ItemController {

  private final ItemRepository itemRepository;

  @Autowired
  public ItemController(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @GetMapping
  public List<Item> getAll() {
    return itemRepository.findAll();
  }
}

package com.Interactions;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "interactions")
public class InteractionsController {

  private final InteractionsService interactionsService;

  @Autowired
  public InteractionsController(InteractionsService interactionsService) {
    this.interactionsService = interactionsService;
  }

  @GetMapping
  public List<Interactions> votePost() {
    return interactionsService.findAll();
  }
}

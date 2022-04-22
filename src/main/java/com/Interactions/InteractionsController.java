package com.Interactions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "interactions")
public class InteractionsController {

  private final InteractionsService interactionsService;

  public InteractionsController(InteractionsService interactionsService) {
    this.interactionsService = interactionsService;
  }
}

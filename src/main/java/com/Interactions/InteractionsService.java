package com.Interactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionsService {

  private InteractionsRepository interactionsRepository;

  @Autowired
  public InteractionsService(InteractionsRepository interactionsRepository) {
    this.interactionsRepository = interactionsRepository;
  }

  public void votePost() {
    // Interactions interactPost = new Interactions(
    //   true,
    //   null,
    //   null,
    //   null,
    //   null,
    //   null,
    //   1L,
    //   2L
    // );

    // interactionsRepository.save(interactPost);
  }
}

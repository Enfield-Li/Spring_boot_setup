package com.Interactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionsService {

  private InteractionsRepository interactionsRepository;

  @Autowired
  public InteractionsService(InteractionsRepository interactionsRepository) {
    this.interactionsRepository = interactionsRepository;
  }

  public List<Interactions> findAll() {
    return interactionsRepository.findAll();
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

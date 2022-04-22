package com.Interactions.config;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeys implements Serializable {

  @Column(name = "user_id", nullable = false)
  private int userId;

  @Column(name = "post_id", nullable = false)
  private int postId;
}

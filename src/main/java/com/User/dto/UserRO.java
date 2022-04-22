package com.User.dto;

import java.util.Date;

public class UserRO {

  private Long id;

  private String username;

  private String email;

  private Long postAmounts;

  private Date createdAt;

  public UserRO() {}

  public UserRO(
    Long id,
    String username,
    String email,
    Long postAmounts,
    Date createdAt
  ) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.postAmounts = postAmounts;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getPostAmounts() {
    return this.postAmounts;
  }

  public void setPostAmounts(Long postAmounts) {
    this.postAmounts = postAmounts;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}

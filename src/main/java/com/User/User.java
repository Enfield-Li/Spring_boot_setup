package com.User;

import com.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

@Entity(name = "User")
@Table(name = "\"user\"")
@DynamicInsert
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "username", nullable = false) // Db field null check
  private String username;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @ColumnDefault(value = "0")
  private Long postAmounts;

  @CreationTimestamp
  private Date createdAt;

  @JsonIgnore // wtf???
  @OneToMany(
    mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    targetEntity = Post.class
  )
  private List<Post> posts = new ArrayList<>();

  public User() {}

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
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

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public List<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", username='" +
      getUsername() +
      "'" +
      ", email='" +
      getEmail() +
      "'" +
      ", password='" +
      getPassword() +
      "'" +
      ", postAmounts='" +
      getPostAmounts() +
      "'" +
      ", createdAt='" +
      getCreatedAt() +
      "'" +
      ", posts='" +
      getPosts() +
      "'" +
      "}"
    );
  }
}

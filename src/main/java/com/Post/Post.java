package com.Post;

import com.Interactions.Interactions;
import com.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

@Entity(name = "Post")
@Table(name = "post")
@DynamicInsert
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @CreationTimestamp
  private Date createdAt;

  @UpdateTimestamp
  private Date updatedAt;

  @NonNull
  @Column(nullable = false)
  private String title;

  @Column(nullable = true)
  private String content;

  @ColumnDefault(value = "0")
  private Integer viewCount;

  @ColumnDefault(value = "0")
  private Integer votePoints;

  @ColumnDefault(value = "0")
  private Integer likePoints;

  @ColumnDefault(value = "0")
  private Integer confusedPoints;

  @ColumnDefault(value = "0")
  private Integer laughPoints;

  @ColumnDefault(value = "0")
  private Integer commentAmounts;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @JsonIgnore
  @OneToMany(
    mappedBy = "post",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    targetEntity = Interactions.class,
    fetch = FetchType.LAZY
  )
  private List<Interactions> interactions;

  public Post() {}

  public Post(String title, String content, User user) {
    this.title = title;
    this.content = content;
    this.user = user;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getViewCount() {
    return this.viewCount;
  }

  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }

  public Integer getVotePoints() {
    return this.votePoints;
  }

  public void setVotePoints(Integer votePoints) {
    this.votePoints = votePoints;
  }

  public Integer getLikePoints() {
    return this.likePoints;
  }

  public void setLikePoints(Integer likePoints) {
    this.likePoints = likePoints;
  }

  public Integer getConfusedPoints() {
    return this.confusedPoints;
  }

  public void setConfusedPoints(Integer confusedPoints) {
    this.confusedPoints = confusedPoints;
  }

  public Integer getLaughPoints() {
    return this.laughPoints;
  }

  public void setLaughPoints(Integer laughPoints) {
    this.laughPoints = laughPoints;
  }

  public Integer getCommentAmounts() {
    return this.commentAmounts;
  }

  public void setCommentAmounts(Integer commentAmounts) {
    this.commentAmounts = commentAmounts;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Interactions> getInteractions() {
    return this.interactions;
  }

  public void setInteractions(List<Interactions> interactions) {
    this.interactions = interactions;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", createdAt='" +
      getCreatedAt() +
      "'" +
      ", updatedAt='" +
      getUpdatedAt() +
      "'" +
      ", title='" +
      getTitle() +
      "'" +
      ", content='" +
      getContent() +
      "'" +
      ", viewCount='" +
      getViewCount() +
      "'" +
      ", votePoints='" +
      getVotePoints() +
      "'" +
      ", likePoints='" +
      getLikePoints() +
      "'" +
      ", confusedPoints='" +
      getConfusedPoints() +
      "'" +
      ", laughPoints='" +
      getLaughPoints() +
      "'" +
      ", commentAmounts='" +
      getCommentAmounts() +
      "'" +
      ", user='" +
      getUser() +
      "'" +
      ", interactions='" +
      getInteractions() +
      "'" +
      "}"
    );
  }
}

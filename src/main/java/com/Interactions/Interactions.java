package com.Interactions;

import com.Interactions.config.CompositeKeys;
import com.Post.Post;
import com.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Interactions {

  @EmbeddedId
  private CompositeKeys CompositeKeys;

  private Boolean voteStatus;
  private Boolean likeStatus;
  private Boolean laughStatus;
  private Boolean confusedStatus;

  @ColumnDefault(value = "false")
  private Boolean read;

  @ColumnDefault(value = "false")
  private Boolean checked;

  @CreationTimestamp
  private Date createdAt;

  @UpdateTimestamp
  private Date updatedAt;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", insertable = false, updatable = false)
  private Post post;

  public Interactions() {}

  public Interactions(
    Boolean voteStatus,
    Boolean likeStatus,
    Boolean laughStatus,
    Boolean confusedStatus,
    Boolean read,
    Boolean checked,
    User user,
    Post post
  ) {
    this.voteStatus = voteStatus;
    this.likeStatus = likeStatus;
    this.laughStatus = laughStatus;
    this.confusedStatus = confusedStatus;
    this.read = read;
    this.checked = checked;
    this.user = user;
    this.post = post;
  }

  public CompositeKeys getCompositeKeys() {
    return this.CompositeKeys;
  }

  public void setCompositeKeys(CompositeKeys CompositeKeys) {
    this.CompositeKeys = CompositeKeys;
  }

  public Boolean isVoteStatus() {
    return this.voteStatus;
  }

  public Boolean getVoteStatus() {
    return this.voteStatus;
  }

  public void setVoteStatus(Boolean voteStatus) {
    this.voteStatus = voteStatus;
  }

  public Boolean isLikeStatus() {
    return this.likeStatus;
  }

  public Boolean getLikeStatus() {
    return this.likeStatus;
  }

  public void setLikeStatus(Boolean likeStatus) {
    this.likeStatus = likeStatus;
  }

  public Boolean isLaughStatus() {
    return this.laughStatus;
  }

  public Boolean getLaughStatus() {
    return this.laughStatus;
  }

  public void setLaughStatus(Boolean laughStatus) {
    this.laughStatus = laughStatus;
  }

  public Boolean isConfusedStatus() {
    return this.confusedStatus;
  }

  public Boolean getConfusedStatus() {
    return this.confusedStatus;
  }

  public void setConfusedStatus(Boolean confusedStatus) {
    this.confusedStatus = confusedStatus;
  }

  public Boolean isRead() {
    return this.read;
  }

  public Boolean getRead() {
    return this.read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }

  public Boolean isChecked() {
    return this.checked;
  }

  public Boolean getChecked() {
    return this.checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
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

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Post getPost() {
    return this.post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " CompositeKeys='" +
      getCompositeKeys() +
      "'" +
      ", voteStatus='" +
      isVoteStatus() +
      "'" +
      ", likeStatus='" +
      isLikeStatus() +
      "'" +
      ", laughStatus='" +
      isLaughStatus() +
      "'" +
      ", confusedStatus='" +
      isConfusedStatus() +
      "'" +
      ", read='" +
      isRead() +
      "'" +
      ", checked='" +
      isChecked() +
      "'" +
      ", createdAt='" +
      getCreatedAt() +
      "'" +
      ", updatedAt='" +
      getUpdatedAt() +
      "'" +
      ", user='" +
      getUser() +
      "'" +
      ", post='" +
      getPost() +
      "'" +
      "}"
    );
  }
}

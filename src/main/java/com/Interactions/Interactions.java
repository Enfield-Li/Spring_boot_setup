package com.Interactions;

import com.Interactions.config.CompositeKeys;
import com.Post.Post;
import com.User.User;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "post_id", insertable = false, updatable = false)
  private Post post;
}

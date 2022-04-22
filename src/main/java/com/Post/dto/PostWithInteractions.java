package com.Post.dto;

public class PostWithInteractions {

  private Long id;
  private String content;
  private Integer votePoints;
  private Boolean voteStatus;
  private Boolean read;
  private Long userId;
  private Long postId;

  public PostWithInteractions(
    Long id,
    String content,
    Integer votePoints,
    Boolean voteStatus,
    Boolean read,
    Long userId,
    Long postId
  ) {
    this.id = id;
    this.content = content;
    this.votePoints = votePoints;
    this.voteStatus = voteStatus;
    this.read = read;
    this.userId = userId;
    this.postId = postId;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getVotePoints() {
    return this.votePoints;
  }

  public void setVotePoints(Integer votePoints) {
    this.votePoints = votePoints;
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

  public Boolean isRead() {
    return this.read;
  }

  public Boolean getRead() {
    return this.read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getPostId() {
    return this.postId;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }
}

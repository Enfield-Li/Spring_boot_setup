package com.Post.dto;

import org.springframework.lang.NonNull;

public class CreatePostDto {

  @NonNull
  private String title;

  private String content;

  public CreatePostDto(String title, String content) {
    this.title = title;
    this.content = content;
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

  @Override
  public String toString() {
    return (
      "{" +
      " title='" +
      getTitle() +
      "'" +
      ", content='" +
      getContent() +
      "'" +
      "}"
    );
  }
}

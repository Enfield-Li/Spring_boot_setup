package com.Post.dto;

public class UpdatePostDto {

  private String title;
  private String content;

  public UpdatePostDto(String title, String content) {
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

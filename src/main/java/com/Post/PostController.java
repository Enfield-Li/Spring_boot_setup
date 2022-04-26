package com.Post;

import com.Post.dto.PostWithInteractions;
import com.User.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "post")
public class PostController {

  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping(path = "/title/{title}")
  public List<Post> getPostByTitle(@PathVariable String title) {
    return postService.findWithName(title);
  }

  @GetMapping(path = "{userId}")
  public List<Post> getPostUser(@PathVariable String userId) {
    return postService.getUserPosts(Long.parseLong(userId));
  }

  @GetMapping(path = "/with")
  public Object getIt() {
    return postService.getPostsWithInteractions();
  }
}

package com.Post;

import com.Post.dto.PostWithInteractions;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Optional<List<Post>> getAllPostsWithAuthor() {
    return null;
  }

  public List<Post> getUserPosts(Long userId) {
    return postRepository.findByUserId(userId);
  }

  public Object getPostsWithInteractions() {
    return postRepository.findPostWithInteractions(2, 1);
  }
}

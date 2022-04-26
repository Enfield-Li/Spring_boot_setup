package com.Post;

import com.Post.dto.PostWithInteractions;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;
  private final EntityManager em;

  @Autowired
  public PostService(PostRepository postRepository, EntityManager em) {
    this.postRepository = postRepository;
    this.em = em;
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
    // return postRepository.findPostWithInteractions(2, 1);

    return em
      .createQuery(
        "SELECT p.title, p.id, i.postId, i.voteStatus" +
        " FROM Post p" +
        " JOIN Interactions i" +
        " On p.id = i.postId" +
        " WHERE i.postId = :postId AND i.userId = :userId"
      )
      .setParameter("postId", 2L)
      .setParameter("userId", 1L)
      .setMaxResults(10)
      .getResultList();
  }

  public List<Post> findWithName(String title) {
    return em
      .createQuery("SELECT p FROM Post p") //  WHERE p.title LIKE :title
      // .setParameter("title", title)
      .setMaxResults(10)
      .getResultList();
  }
}
